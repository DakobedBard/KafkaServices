package org.mddarr.productservice;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.mddarr.productservice.producers.ProductMongoProducer;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ProductServiceApplication implements CommandLineRunner {
	private final Log log = LogFactory.getLog(getClass());
	int counter = 1;
	@Override
	public void run(String...args) throws Exception {
		ProductMongoProducer.productProductMongoDocuments();
		counter++;
	}

	public static void main(String[] args) {
		SpringApplication.run(ProductServiceApplication.class, args);
	}

}
