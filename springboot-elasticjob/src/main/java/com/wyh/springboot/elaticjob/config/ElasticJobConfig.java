package com.wyh.springboot.elaticjob.config;

import com.dangdang.ddframe.job.api.simple.SimpleJob;
import com.dangdang.ddframe.job.config.JobCoreConfiguration;
import com.dangdang.ddframe.job.config.simple.SimpleJobConfiguration;
import com.dangdang.ddframe.job.executor.ShardingContexts;
import com.dangdang.ddframe.job.lite.config.LiteJobConfiguration;
import com.dangdang.ddframe.job.lite.spring.api.SpringJobScheduler;
import com.wyh.springboot.elaticjob.job.SimpleJobDemo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.dangdang.ddframe.job.lite.api.JobScheduler;
import com.dangdang.ddframe.job.lite.api.listener.ElasticJobListener;
import com.dangdang.ddframe.job.reg.zookeeper.ZookeeperRegistryCenter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;

import java.util.Date;


@Configuration
public class ElasticJobConfig {

    private static final Logger logger = LoggerFactory.getLogger(ElasticJobConfig.class);

    @Autowired
    private ZookeeperRegistryCenter regCenter;

    /**
     * 配置任务详细信息
     * @param jobClass
     * @param cron
     * @param shardingTotalCount
     * @param shardingItemParameters
     * @return
     */
    private LiteJobConfiguration getLiteJobConfiguration(final Class<? extends SimpleJob> jobClass,
                                                         final String cron,
                                                         final int shardingTotalCount,
                                                         final String shardingItemParameters) {
        return LiteJobConfiguration.newBuilder(new SimpleJobConfiguration(
                JobCoreConfiguration.newBuilder(jobClass.getName(), cron, shardingTotalCount)
                        .shardingItemParameters(shardingItemParameters).build()
                , jobClass.getCanonicalName())
        ).overwrite(true).build();
    }

    /**
     * 配置监听器
     * @return
     */
    private ElasticJobListener getElasticJobListener() {
        return new ElasticJobListener() {

            @Override
            public void beforeJobExecuted(ShardingContexts shardingContexts) {
                logger.info("===>{} 执行开始时间 {} <===",shardingContexts.getJobName(), new Date());
            }

            @Override
            public void afterJobExecuted(ShardingContexts shardingContexts) {
                logger.info("===>{} 执行结束时间:{} <===",shardingContexts.getJobName(), new Date());
            }

        };
    }

    @Bean(initMethod = "init")
    public JobScheduler simpleJobScheduler(final SimpleJobDemo simpleJob,
                                           @Value("${stockJob.cron}") final String cron,
                                           @Value("${stockJob.shardingTotalCount}") final int shardingTotalCount,
                                           @Value("${stockJob.shardingItemParameters}") final String shardingItemParameters) {
        return new SpringJobScheduler(simpleJob, regCenter,
                getLiteJobConfiguration(simpleJob.getClass(), cron, shardingTotalCount, shardingItemParameters),
                getElasticJobListener());
    }
}


