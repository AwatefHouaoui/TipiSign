package com.example.demo;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.support.ResourceBundleMessageSource;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import com.linecorp.bot.spring.boot.annotation.LineMessageHandler;

@SpringBootApplication
@LineMessageHandler
@EnableConfigurationProperties
@EntityScan(basePackages = { "com.example.entities" })
@ComponentScan(basePackages = { "com.example.controller", "com.example.service" })
@EnableJpaRepositories(basePackages = { "com.example.dao" })

public class HrBotApplication extends WebMvcConfigurerAdapter {

	static Path downloadedContentDir;

	public static void main(String[] args) throws IOException {
		downloadedContentDir = Files.createTempDirectory("line-bot");
		SpringApplication.run(HrBotApplication.class, args);
	}

	@Bean
	public ResourceBundleMessageSource messageSource() {
		ResourceBundleMessageSource source = new ResourceBundleMessageSource();
		source.setBasename("messages");
		source.setUseCodeAsDefaultMessage(true);
		return source;
	}
}
