package com.mannetroll.pregistry;

import java.util.HashMap;
import java.util.Map;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.message.ObjectMessage;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class PackageRegistryApp {
	private static final Logger LOG = LogManager.getLogger(PackageRegistryApp.class);
	private static ConfigurableApplicationContext context;

	public static void doLog() {
		Map<String, Object> tmp = new HashMap<String, Object>();
		tmp.put("a_string", "hello");
		tmp.put("a_number", 11L);
		tmp.put("a_float", 1.1234F);
		tmp.put("a_boolean", true);
		LOG.info(new ObjectMessage(tmp));
	}

	public static void main(String[] args) {
		context = SpringApplication.run(PackageRegistryApp.class, args);
		PackageRegistryApp.doLog();
		LOG.info("context: " + context.getBeanDefinitionCount());
	}

}
