package com.mycode.springboot.aopdemo;

import com.mycode.springboot.aopdemo.dao.AccountDAO;
import com.mycode.springboot.aopdemo.dao.MembershipDAO;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class AopdemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(AopdemoApplication.class, args);
	}

	@Bean
	public CommandLineRunner commandLineRunner(AccountDAO theAccountDAO, MembershipDAO membershipDAO)
	{
		return runner -> {
			demoTheBeforeAdvice(theAccountDAO,membershipDAO);
		};
	}

	private void demoTheBeforeAdvice(AccountDAO theAccountDAO, MembershipDAO membershipDAO) {
		// call the business method
		Account myAccount = new Account();

		theAccountDAO.addAccount(myAccount,true);
		// call the membership method
		System.out.println(membershipDAO.addSillyMember());
		// call the doWork method
		theAccountDAO.doWork();

		// call the goToSleep method
		membershipDAO.goToSleep();




	}

}
