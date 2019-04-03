package com.dao;

import java.util.List;

import com.domain.Student;

public interface StuDao {
    List<Student> findAll();
}
