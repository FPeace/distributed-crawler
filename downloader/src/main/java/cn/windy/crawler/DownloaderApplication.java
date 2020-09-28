package cn.windy.crawler;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;

import java.util.function.Consumer;

@SpringBootApplication
@EnableEurekaClient
public class DownloaderApplication {

	public static void main(String[] args) {
		SpringApplication.run(DownloaderApplication.class, args);
	}
}
