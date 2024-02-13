package com.mycode.cruddemo.dao;

import com.mycode.cruddemo.entity.Course;
import com.mycode.cruddemo.entity.Instructor;
import com.mycode.cruddemo.entity.InstructorDetail;
import com.mycode.cruddemo.entity.Student;

import java.util.List;

public interface AppDAO {
    void save(Instructor theInstructor);
    Instructor findInstructorById(int theId);
    void deleteInstructorById(int theId);

    void deleteInstructorDetailById(int theId);

    InstructorDetail findInstructorDetailById(int theId);

    List<Course> findCoursesByInstructorId(int theId);

    Instructor findInstructorByIdJoinFetch(int theId);

    void update(Instructor tempInstructor);

    void update(Course tempCourse);

    Course findCourseById(int theId);

    void deleteCourseById(int theId);

    void save(Course theCourse);

    Course findCourseAndReviewsByCourseId(int theId);

    Course findCourseAndStudentsByCourseId(int theId);

    Student findStudentAndCoursesByStudentId(int theId);

     void update(Student tempStudent);

     void delete(int theId);



}
