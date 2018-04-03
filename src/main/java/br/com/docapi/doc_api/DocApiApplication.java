package br.com.docapi.doc_api;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = {"br/com/docapi/controllers", "br/com/docapi/database", "br/com/docapi/dao", "br/com/docapi/entity", "br/com/docapi/models"})
public class DocApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(DocApiApplication.class, args);
	}
}
