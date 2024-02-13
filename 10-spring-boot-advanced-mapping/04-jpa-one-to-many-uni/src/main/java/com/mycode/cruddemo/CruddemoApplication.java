package com.mycode.cruddemo;

import com.mycode.cruddemo.dao.AppDAO;
import com.mycode.cruddemo.entity.Course;
import com.mycode.cruddemo.entity.Instructor;
import com.mycode.cruddemo.entity.InstructorDetail;
import com.mycode.cruddemo.entity.Review;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import java.util.*;

@SpringBootApplication
public class CruddemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(CruddemoApplication.class, args);
	}

	@Bean
	public CommandLineRunner commandLineRunner(AppDAO appDAO)
	{
		return runner -> {
			//createCourseAndReview(appDAO);
			//findCourseAndReviewsById(appDAO);
			deleteCourseAndReviews(appDAO);

		};

	}

	private void deleteCourseAndReviews(AppDAO appDAO) {
		int theId = 10;
		System.out.println("Deleting course id: "+theId);

		appDAO.deleteCourseById(theId);
		System.out.println("Done!");
	}

	private void findCourseAndReviewsById(AppDAO appDAO) {
		int theId = 10;
		System.out.println("Finding the course id : "+theId);
		Course course = appDAO.findCourseAndReviewsByCourseId(theId);
		System.out.println("Found the course : "+ course);
		System.out.println(course.getReviews());

		System.out.println("Done!");
	}

	private void createCourseAndReview(AppDAO appDAO) {
		// create a course
		Course course1 = new Course("Coding");


		// add some reviews
		course1.addReviews(new Review("Love it!"));
		course1.addReviews(new Review("Awesome"));
		course1.addReviews(new Review("Headache course!"));

		// save the course
		System.out.println("Saving the course :");
		System.out.println(course1);
		System.out.println(course1.getReviews());

		appDAO.save(course1);
		System.out.println("Done!");
	}


	private void deleteCourse(AppDAO appDAO) {
		int theId = 10;
		System.out.println("Deleting course id : "+theId);
		appDAO.deleteCourseById(theId);
		System.out.println("Done!");
	}

	private void updateCourse(AppDAO appDAO) {
		int theID = 10;
		// find the course
		System.out.println("Finding the course ID : "+theID);
		Course tempCourse = appDAO.findCourseById(theID);

		// update the course
		System.out.println("Updating the course ID : "+theID);
		tempCourse.setTitle("Java Spring Boot");
		appDAO.update(tempCourse);
		System.out.println("Done!");
	}

	private void updateInstructor(AppDAO appDAO) {
		int theId = 1;
		// find the instructor
		System.out.println("finding instances id: "+theId);
		Instructor tempInstructor = appDAO.findInstructorById(theId);

		// update the instructor
		System.out.println("Updating instructor id: "+theId);
		tempInstructor.setLastName("Justine");
		appDAO.update(tempInstructor);

		System.out.println("Done!");
	}

	private void findInstructorWithCoursesJoinFetch(AppDAO appDAO) {
		int theId = 1;
		// find the instructor
		System.out.println("Finding instances id: "+theId);
		Instructor tempInstructor  = appDAO.findInstructorByIdJoinFetch(theId);
		System.out.println("tempInstructor: "+tempInstructor);
		System.out.println("Associated courses : "+tempInstructor.getCourses());
		System.out.println("Done!");
	}

	private void findCoursesForInstructor(AppDAO appDAO) {
		int theId = 1;
		System.out.println("Finding instructor id: "+ theId);
		Instructor tempInstructor = appDAO.findInstructorById(theId);

		System.out.println("tempInstructor : "+tempInstructor);
		// find courses for instructor

		System.out.println("find courses for instructor id: "+theId);
		List<Course> courses = appDAO.findCoursesByInstructorId(theId);
		tempInstructor.setCourses(courses);
		System.out.println("Associated Courses: "+tempInstructor.getCourses());

		System.out.println("Done");

	}

	private void findInstructorWithCourses(AppDAO appDAO) {
		int theId = 1;
		System.out.println("Finding instructor id: "+ theId);
		Instructor tempInstructor = appDAO.findInstructorById(theId);

		System.out.println("tempInstructor : "+tempInstructor);
		System.out.println("the associated courses : "+tempInstructor.getCourses() );
	}

	private void createInstructorWithCourses(AppDAO appDAO) {
		Instructor tempInstructor = new Instructor("Myint Aung","Zaw","alienjj@gmail.com");
		InstructorDetail tempInstructorDetail = new InstructorDetail("http://youtube.com","love to sing");

		tempInstructor.setInstructorDetail(tempInstructorDetail);
		// Create some courses
		Course tempCourse1 = new Course("Air Guitar");
		Course tempCourse2 = new Course("Piano Learning");
		Course tempCourse3 = new Course("Coding");
		tempInstructor.add(tempCourse1);
		tempInstructor.add(tempCourse2);
		tempInstructor.add(tempCourse3);

		System.out.println("Saving instructor: "+ tempInstructor);
		appDAO.save(tempInstructor);
		System.out.println("The courses : "+tempInstructor.getCourses());
		System.out.println("Done!");
	}

	private void deleteInstructorDetail(AppDAO appDAO) {
		int theId = 3;
		System.out.println("Deleting instructor detail id: "+theId);
		appDAO.deleteInstructorDetailById(theId);


		System.out.println("Done!");
	}

	private void findInstructorDetail(AppDAO appDAO) {
		// get the instructor detail object
		int theId = 2;
		InstructorDetail tempInstructorDetail = appDAO.findInstructorDetailById(theId);

		// print the instructor detail
		System.out.println("Temp instructor detail : + "+tempInstructorDetail);

		// print the associated instructor
		System.out.println("The associated instructor : "+ tempInstructorDetail.getInstructor());

		System.out.println("Done!");

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
