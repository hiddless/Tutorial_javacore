package dao;

import java.sql.Connection;

public interface IDaoGenerics<T> {

    /// Crud
    /// Create
    T create(T t);

    /// FindbyName
    T findByName(String name);

    /// List
    ArrayList<T> list();

    /// Update
    T update(int id, T t);

    /// Delete
    T delete(int id);

    /// Chooise
    public void chooise();

    /// Body Method
    default Connection getInterfaceConnection(){
        return null;
    }


}
