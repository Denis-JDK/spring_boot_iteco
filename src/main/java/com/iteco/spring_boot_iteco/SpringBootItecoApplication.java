package com.iteco.spring_boot_iteco;


import com.iteco.spring_boot_iteco.home_worke.ExternalInfo;
import com.iteco.spring_boot_iteco.home_worke.ExternalService;
import com.iteco.spring_boot_iteco.home_worke.ExternalServiceImpl;
import com.iteco.spring_boot_iteco.model.BankBook;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.PropertySource;

@ComponentScan("com.*")
@PropertySource("classpath:application.properties")
public class SpringBootItecoApplication {
	public static void main(String[] args) {

		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(SpringBootItecoApplication.class);

		 BankBook bank = context.getBean(BankBook.class);
		System.out.println(bank);
		 bank.setId(120);
		System.out.println(bank);

		ExternalServiceImpl externalService = (ExternalServiceImpl) context.getBean(ExternalService.class);




	}

}
