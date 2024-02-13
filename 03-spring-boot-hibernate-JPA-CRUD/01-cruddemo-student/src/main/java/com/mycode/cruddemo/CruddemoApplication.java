package com.mycode.cruddemo;

import com.mycode.cruddemo.dao.StudentDAO;
import com.mycode.cruddemo.entity.Student;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import java.util.*;


@SpringBootApplication
public class CruddemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(CruddemoApplication.class, args);}

		@Bean
		public CommandLineRunner CommandLineRunner(StudentDAO studentDAO)
		{
			return runner -> {
				//createStudent(studentDAO);
				createMultipleStudents(studentDAO);
				//readStudent(studentDAO);
				//queryForStudents(studentDAO);
				//queryByStudentsByLastName(studentDAO);
				//updateStudent(studentDAO);
				//deleteStudent(studentDAO);
				//deleteAll(studentDAO);

			};
		}

	private void queryByStudentsByLastName(StudentDAO studentDAO) {
		// get a list of students
		List<Student> theStudents = studentDAO.findByLastName("Nandi");

		// display a list of students
		for(Student tempStudent : theStudents)
		{
			System.out.println(tempStudent);
		}
	}
	private void deleteAll(StudentDAO studentDAO)
	{
		System.out.println("Deleting all students ..");
		int numRowsDeleted = studentDAO.deleteAll();
		System.out.println("Deleted row count : "+numRowsDeleted);
	}

	private void deleteStudent(StudentDAO studentDAO)
	{
		int studentId = 3;
		System.out.println("Deleting student id : "+ studentId);
		studentDAO.delete((studentId));
	}
	private void updateStudent(StudentDAO studentDAO)
	{
		// retrieve student based on the id: primary key
		int studentId = 1;
		System.out.println("Getting student with id : "+ studentId);
		Student myStudent = studentDAO.findById(studentId);

		// change first name to "ScooBy"
		System.out.println("Updating student ...");
		myStudent.setFirstName("Moe");

		// update the student
		studentDAO.update(myStudent);

		// display the update student
		System.out.println("Update student: "+ myStudent);
	}

	public void createStudent(StudentDAO studentDAO)
		{
			// create the student object
			System.out.println("Creating new student object ..");
			Student tempStudent = new Student("Moe", "Nandi", "moenandi10@gmail.com");

			// save the student object
			System.out.println("Saving the student ...");
			studentDAO.save(tempStudent);

			// display id of the saved student
			System.out.println("Saved student. Generated id: "+ tempStudent.getId());

		}

		public void createMultipleStudents(StudentDAO studentDAO){
		// Create multiple students
			System.out.println("Creating 3 students objects ...");
			Student tempStudent1 = new Student("Su", "Su", "susu10@gmail.com");
			Student tempStudent2 = new Student("Aye", "Aye", "ayeaye10@gmail.com");
			Student tempStudent3 = new Student("Khine", "Khine", "khinekhine10@gmail.com");
		// Save multiple students
			System.out.println("Saving the students ...");
			studentDAO.save(tempStudent1);
			studentDAO.save(tempStudent2);
			studentDAO.save(tempStudent3);


		}

		private void readStudent(StudentDAO studentDAO)
		{
			// create a student object
			System.out.println("Creating new student objects ...");
			Student tempStudent = new Student("Justine", "Paul", "alienjj@gmail.com");

			// save the student
			System.out.println("Saving the student ...");
			studentDAO.save(tempStudent);
			// display id of the saved student
			int theId = tempStudent.getId();
			System.out.println("Saved student. Generated id: "+ theId);

			// retrieve student based on id : primary key
			System.out.println("Retrieving student with id: " + theId);
			Student myStudent = studentDAO.findById(theId);
			// display student
			System.out.println(myStudent);
		}

		private void queryForStudents(StudentDAO studentDAO)
		{
			// get a list of students
			List<Student> theStudents =studentDAO.findAll();

			// display list of students
			for(Student tempStudent : theStudents)
			{
				System.out.println(tempStudent);
			}
		}



}
