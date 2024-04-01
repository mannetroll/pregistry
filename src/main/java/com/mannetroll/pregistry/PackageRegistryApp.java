package com.mannetroll.pregistry;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class PackageRegistryApp {
	private static final Logger LOG = LogManager.getLogger(PackageRegistryApp.class);
	private static ConfigurableApplicationContext context;

	public static void main(String[] args) {
		context = SpringApplication.run(PackageRegistryApp.class, args);
		LOG.info("context: " + context.getBeanDefinitionCount());
	}

}
