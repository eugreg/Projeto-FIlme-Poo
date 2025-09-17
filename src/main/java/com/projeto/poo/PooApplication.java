package com.projeto.poo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import com.projeto.poo.service.VideoService;

@SpringBootApplication
public class PooApplication {

	public static void main(String[] args) {
		ApplicationContext context = SpringApplication.run(PooApplication.class, args);
		VideoService videoService = context.getBean(VideoService.class);
		videoService.salvarVideo();


	}

}
