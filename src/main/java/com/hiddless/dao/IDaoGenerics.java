package com.hiddless.dao;

import com.hiddless.dto.TeacherDto;

import java.sql.Connection;
import java.util.List;
import java.util.Optional;

public interface IDaoGenerics<T> {

    /// Crud
    /// Create
    T create(T t);

    /// FindbyName
    T findByName(String name);
    Optional<TeacherDto> findById(int id);

    /// List
    List<T> list();

    /// Update
    T update(int id, T t);

    /// Delete
    Optional<TeacherDto> delete(int id);

    /// Chooise
    void chooise();

    /// Body Method
    default Connection getInterfaceConnection(){
        return null;
    }
}
