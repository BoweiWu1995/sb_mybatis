package com.mydemo.mapper;

import com.mydemo.model.Student;

import java.util.List;


public interface StudentMapper {

    List<Student> getAll();

    Student getStudent(String id);

    Long insertStudent(Student student);

    Long updateStudent(Student student);

    Long deleteStudent(String id);
}
