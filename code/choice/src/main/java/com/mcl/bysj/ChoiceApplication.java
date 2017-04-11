package com.mcl.bysj;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.mybatis.spring.annotation.MapperScan;

@SpringBootApplication
@MapperScan("com.mcl.bysj.dao")     //配置mapper接口类扫描
public class ChoiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(ChoiceApplication.class, args);
	}
}
