package com.exercisenice;

import com.exercisenice.models.Document;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.tomcat.util.json.JSONParser;
import org.json.JSONArray;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

@SpringBootApplication
public class ExerciseNiceApplication {

	public static void main(String[] args) throws IOException {
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
