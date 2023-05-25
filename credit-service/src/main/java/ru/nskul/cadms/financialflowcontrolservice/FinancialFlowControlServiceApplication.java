package ru.nskul.cadms.financialflowcontrolservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@EnableJpaAuditing
@SpringBootApplication
public class FinancialFlowControlServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(FinancialFlowControlServiceApplication.class, args);
	}

}
