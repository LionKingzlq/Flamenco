package com.flamenco.task;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class TaskAnnotation {

////	每天01:00 执行一次
////	@Scheduled(cron="0 0 1 * * *")
//	
////	每5s钟执行一次
//	@Scheduled(cron="*/5 * * * * ?")
//	public void show(){
//		System.out.println("Annotation：is show run"); 
//	}
//	
//	/**  
//     * 心跳更新。启动时执行一次，之后每隔2秒执行一次  
//     */    
//    @Scheduled(fixedRate = 1000*2)   
//    public void print(){  
//        System.out.println("Annotation：print run");  
//    }  
}
