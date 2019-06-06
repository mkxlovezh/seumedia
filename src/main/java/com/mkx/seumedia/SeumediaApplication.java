package com.mkx.seumedia;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
//@ComponentScan("com.mkx.seumedia")
@MapperScan("com.mkx.seumedia.mappers")
public class SeumediaApplication {
	public static void main(String[] args) {
		SpringApplication.run(SeumediaApplication.class, args);
	}
}
