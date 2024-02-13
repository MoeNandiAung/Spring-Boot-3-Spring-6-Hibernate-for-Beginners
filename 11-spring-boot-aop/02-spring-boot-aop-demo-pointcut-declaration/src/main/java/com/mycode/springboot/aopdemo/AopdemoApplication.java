package com.mycode.springboot.aopdemo;

import com.mycode.springboot.aopdemo.dao.AccountDAO;
import com.mycode.springboot.aopdemo.dao.MembershipDAO;
import com.mycode.springboot.aopdemo.service.TrafficFortuneService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;

@SpringBootApplication
public class AopdemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(AopdemoApplication.class, args);
	}

	@Bean
	public CommandLineRunner commandLineRunner(AccountDAO theAccountDAO, MembershipDAO membershipDAO, TrafficFortuneService trafficFortuneService)
	{
		return runner -> {
			//demoTheBeforeAdvice(theAccountDAO,membershipDAO);
			//demoTheAfterReturningAdvice(theAccountDAO);
			//demoTheAfterThrowingAdvice(theAccountDAO);
			//demoTheAfterAdvice(theAccountDAO);

			//demoTheAroundAdvice(trafficFortuneService);
			//demoTheAroundHandleException(trafficFortuneService);
			demoTheAroundReThrowException(trafficFortuneService);


		};
	}

	private void demoTheAroundReThrowException(TrafficFortuneService trafficFortuneService) {
		System.out.println("\nMain Program: demoTheAroundAdviceRethrowException");
		System.out.println("Calling getFortune()");

		boolean tripWire = true;
		String data = trafficFortuneService.getFortune(tripWire);
		System.out.println("\nMy fortune is:"+ data);
		System.out.println("Finished");
	}

	private void demoTheAroundHandleException(TrafficFortuneService trafficFortuneService) {
		System.out.println("\nMain Program: demoTheAroundAdviceHandleException");
		System.out.println("Calling getFortune()");

		boolean tripWire = true;
		String data = trafficFortuneService.getFortune(tripWire);
		System.out.println("\nMy fortune is:"+ data);
		System.out.println("Finished");
	}

	private void demoTheAroundAdvice(TrafficFortuneService trafficFortuneService) {
		System.out.println("\nMain Program: demoTheAroundAdvice");
		System.out.println("Calling getFortune()");
		String data = trafficFortuneService.getFortune();
		System.out.println("\nMy fortune is:"+ data);
		System.out.println("Finished");
	}

	private void demoTheAfterAdvice(AccountDAO theAccountDAO) {
		// call method to find the accounts

		List<Account> theAccounts = null;
		try {

			// add  a boolean flag to simulate exceptions
			boolean tripWire = false;
			theAccounts = theAccountDAO.findAccounts(tripWire);
		}
		catch(Exception exc){
			System.out.println("\n\nMain Program: ...... Caught exception: "+ exc);

		}
		// display the accounts

		System.out.println("\n\nMain Program: demoTheAfterThrowingAdvice");
		System.out.println("............");
		System.out.println(theAccounts);
		System.out.println("\n");
	}

	private void demoTheAfterThrowingAdvice(AccountDAO theAccountDAO) {
		// call method to find the accounts

		List<Account> theAccounts = null;
		try {

			// add  a boolean flag to simulate exceptions
			boolean tripWire = true;
			theAccounts = theAccountDAO.findAccounts(tripWire);
		}
		catch(Exception exc){
			System.out.println("\n\nMain Program: ...... Caught exception: "+ exc);

		}
		// display the accounts

		System.out.println("\n\nMain Program: demoTheAfterThrowingAdvice");
		System.out.println("............");
		System.out.println(theAccounts);
		System.out.println("\n");

	}

	private void demoTheAfterReturningAdvice(AccountDAO theAccountDAO) {
		// call method to find the accounts

		List<Account> theAccounts = theAccountDAO.findAccounts();

		// display the accounts

		System.out.println("\n\nMain Program: demoTheAfterReturningAdvice");
		System.out.println("............");
		System.out.println(theAccounts);
		System.out.println("\n");
	}

	private void demoTheBeforeAdvice(AccountDAO theAccountDAO, MembershipDAO membershipDAO) {
		// call the business method
		Account myAccount = new Account();
		myAccount.setName("Myint Aung Zaw");
		myAccount.setLevel("Platinum");

		theAccountDAO.addAccount(myAccount,true);
		// call the membership method
		System.out.println(membershipDAO.addSillyMember());

		// cal the accountdao getter/setter methods
		theAccountDAO.setName("Justine");
		theAccountDAO.setServiceCode("Silver");

		String name = theAccountDAO.getName();
		String code = theAccountDAO.getServiceCode();

		// call the doWork method
		theAccountDAO.doWork();
		// call the goToSleep method
		membershipDAO.goToSleep();




	}

}
