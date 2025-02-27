package com.hiddless.dao;

import java.sql.Connection;
import java.util.List;

public interface IDaoGenerics<T> {

    /// Crud
    /// Create
    T create(T t);

    /// FindbyName
    T findByName(String name);
    T findById(int id);

    /// List
    List<T> list();

    /// Update
    T update(int id, T t);

    /// Delete
    T delete(int id);

    /// Chooise
    void chooise();

    /// Body Method
    default Connection getInterfaceConnection(){
        return null;
    }
}
