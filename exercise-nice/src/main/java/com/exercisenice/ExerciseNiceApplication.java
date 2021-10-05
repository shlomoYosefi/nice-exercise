package com.exercisenice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.IOException;
import java.util.logging.*;

@SpringBootApplication
public class ExerciseNiceApplication {

	private static final Logger logger = Logger.getLogger("DocumentLogger");



	public static void main(String[] args) throws IOException {
		SpringApplication.run(ExerciseNiceApplication.class, args);

		LogManager.getLogManager().reset();
		logger.setLevel(Level.ALL);
		ConsoleHandler ch = new ConsoleHandler();
		ch.setLevel(Level.SEVERE);
		logger.addHandler(ch);

		try {
			FileHandler fh = new FileHandler("documentLogger.log");
			fh.setFormatter(new SimpleFormatter());
			fh.setLevel(Level.FINE);
			logger.addHandler(fh);
		} catch (Exception e) {
			logger.log(Level.SEVERE,"File logger not working.",e);
		}


		System.out.println("ppppppppppppppppppp");
		logger.info("my first log");



	}




















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



