package com.purnima.jain;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import lombok.extern.slf4j.Slf4j;

@SpringBootApplication
@Slf4j
public class RedisAsDatabaseApplication {

	public static void main(String[] args) {
		SpringApplication.run(RedisAsDatabaseApplication.class, args);
		log.info("Started RedisAsDatabaseApplication..............");
	}

}
