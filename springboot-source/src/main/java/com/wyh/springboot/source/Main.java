package com.wyh.springboot.source;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

//{4,3,2,7,8,2,3,1};
public class Main {
    
    public static void main(String[] args) {
    	
    	while(true) {
	    	Scanner scanner = new Scanner(System.in);
	    	
	    	String[] a = scanner.next().split(",");
	    	
	    	if(a == null || a.length <= 0)
	    		return;
	    	
	        Map<String, Integer> count = new HashMap<String, Integer>();
	        for(int i = 0; i < a.length; i ++) {
	            if(count.get("" + a[i]) != null) {
	                System.out.print("" + a[i] + " ");
	            } else {
	                count.put("" + a[i], 0);
	            }
	        }
    	}
    }
    
}
