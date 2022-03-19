package com.wyh.springboot.elaticjob.config;

import com.dangdang.ddframe.job.reg.zookeeper.ZookeeperConfiguration;
import com.dangdang.ddframe.job.reg.zookeeper.ZookeeperRegistryCenter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ZookeeperConfig {

    @Bean(initMethod = "init")
    public ZookeeperRegistryCenter regCenter(
            @Value("${zookeeper.serverList}") final String serverList,
            @Value("${zookeeper.namespace}") final String namespace) {
        return new ZookeeperRegistryCenter(new ZookeeperConfiguration(serverList, namespace));
    }

}
