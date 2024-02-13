package com.mycode.cruddemo.dao;

import com.mycode.cruddemo.entity.Instructor;
import com.mycode.cruddemo.entity.InstructorDetail;

public interface AppDAO {
    void save(Instructor theInstructor);
    Instructor findInstructorById(int theId);
    void deleteInstructorById(int theId);

    void deleteInstructorDetailById(int theId);

    InstructorDetail findInstructorDetailById(int theId);

}
