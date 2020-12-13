package com.obrasgrises.demo;

import javax.annotation.Resource;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.obrasgrises.demo.SERVICES.FileStorageService;

@SpringBootApplication
public class DemoApplication implements CommandLineRunner{
	
	@Resource
	FileStorageService storageService;

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}
	
	  @Override
	  public void run(String... arg) throws Exception {
	    //storageService.deleteAll();
	    storageService.init();
	  }

}
