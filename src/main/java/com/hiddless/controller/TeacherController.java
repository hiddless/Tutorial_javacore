package com.hiddless.controller;

import com.hiddless.dao.IDaoGenerics;
import com.hiddless.dao.TeacherDao;
import com.hiddless.dto.TeacherDto;
import com.hiddless.util.SpecialColor;

import java.util.List;
import java.util.Optional;


public class TeacherController implements IDaoGenerics<TeacherDto> {
    // INJECTION
    private final TeacherDao teacherDao;

    // Parametresiz Constructor
    public TeacherController() {
        this.teacherDao = new TeacherDao();
    }

    // CREATE
    @Override
    public TeacherDto create(TeacherDto teacherDto) {
        TeacherDto createdTeacher = teacherDao.create(teacherDto);
        if (createdTeacher == null) {
            System.out.println(SpecialColor.RED + "❌ Öğretmen oluşturulamadı. Geçerli bilgiler giriniz." + SpecialColor.RESET);
        }
        return createdTeacher;
    }


    // FIND BY NAME
    @Override
    public TeacherDto findByName(String name) {
        return Optional.of(teacherDao.findByName(name)) ;
    }

    @Override
    public Optional<TeacherDto> findById(int id) {
        return null;
    }

    // LIST
    @Override
    public List<TeacherDto> list() {
        return teacherDao.list();
    }

    // UPDATE
    @Override
    public Optional<TeacherDto> update(int id, TeacherDto teacherDto) {
        return Optional.of(teacherDao.update(id, teacherDto));
    }

    // DELETE
    @Override
    public Optional<TeacherDto> delete(int id) {
        return Optional.of(teacherDao.delete(id));
    }

    // CHOOISE(Switch-case)
    @Override
    public void chooise() {
        teacherDao.chooise();
    }
}