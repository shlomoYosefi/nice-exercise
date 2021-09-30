package com.exercisenice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ExerciseNiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(ExerciseNiceApplication.class, args);
//		Timer timer = new Timer();
//		timer.scheduleAtFixedRate(new TimerTask(){
//			int counter =0;
//			@Override
//			public void run(){
//				if(counter<5){
//					counter+=1;
//					System.out.println("shlomo");
//				}
//				else {
//					timer.cancel();
//				}
//			}
//		},0,1000);
	}


}
