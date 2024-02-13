package com.mycode.cruddemo;

import com.mycode.cruddemo.dao.AppDAO;
import com.mycode.cruddemo.entity.Instructor;
import com.mycode.cruddemo.entity.InstructorDetail;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class CruddemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(CruddemoApplication.class, args);
	}

	@Bean
	public CommandLineRunner commandLineRunner(AppDAO appDAO)
	{
		return runner -> {
			//createInstructor(appDAO);
			//findInstructor(appDAO);
			deleteInstructor(appDAO);
		};

	}

	private void deleteInstructor(AppDAO appDAO) {
		int theId = 1;
		System.out.println("Deletting instructor id: "+theId);
		appDAO.deleteInstructorById(theId);

		System.out.println("Done!");


	}

	private void findInstructor(AppDAO appDAO) {
		int theId = 2;

		System.out.println("Finding instructor id: "+theId);

		Instructor tempInstructor = appDAO.findInstructorById(theId);

		System.out.println("tempInstructor: "+ tempInstructor);
		System.out.println("the associated instructorDetail only"+tempInstructor.getInstructorDetail());
	}

	public void createInstructor(AppDAO appDAO)
	{
		/*
		Instructor tempInstructor = new Instructor("Moe","Nandi","moenandi10@gmail.com");
		InstructorDetail tempInstructorDetail = new InstructorDetail("http://youtube.com","love to code");

		 */
		Instructor tempInstructor = new Instructor("Myint Aung","Zaw","alienjj@gmail.com");
		InstructorDetail tempInstructorDetail = new InstructorDetail("http://youtube.com","love to sing");

		tempInstructor.setInstructorDetail(tempInstructorDetail);

		System.out.println("Saving instructor: "+ tempInstructor);
		appDAO.save(tempInstructor);

		System.out.println("Done");
	}

}
