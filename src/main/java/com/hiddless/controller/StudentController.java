package com.hiddless.controller;

import com.hiddless.dao.IDaoGenerics;
import com.hiddless.dao.StudentDao;
import com.hiddless.dto.StudentDto;
import com.hiddless.dto.TeacherDto;

import java.util.List;
import java.util.Optional;

public class StudentController implements IDaoGenerics<StudentDto> {

    /// Injection
    private final StudentDao studentDao;

    /// Parametresiz Constructor
    public StudentController() {
        this.studentDao = new StudentDao();
    }

    /// Create
    @Override
    public StudentDto create(StudentDto studentDto) {
        return studentDao.create(studentDto);
    }

    /// Find by name
    @Override
    public StudentDto findByName(String name) {
        return studentDao.findByName(name);
    }

    @Override
    public Optional<TeacherDto> findById(int id) {
        return null;
    }

    /// List
    @Override
    public List<StudentDto> list() {
        return studentDao.list();
    }

    /// Update
    @Override
    public StudentDto update(int id, StudentDto studentDto) {
        return studentDao.update(id, studentDto);
    }

    /// Delete
    @Override
    public Optional<TeacherDto> delete(int id){
        return studentDao.delete(id);
    }

    /// CHOOISE(Switch-case)
    @Override
    public void chooise(){
        studentDao.chooise();
    }

}
