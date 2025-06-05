package com.sample.aon;

import com.sample.aon.service.MyIncDecService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@Slf4j
@SpringBootApplication
@EnableAspectJAutoProxy(proxyTargetClass = true)
@RequiredArgsConstructor
public class AonApplication  implements CommandLineRunner{

	private final Logger logger = LoggerFactory.getLogger(this.getClass());


	private final MyIncDecService incDecService;

	public static void main(String[] args) {
		SpringApplication.run(AonApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		incDecService.increment();
		incDecService.decrement();
	}
}
