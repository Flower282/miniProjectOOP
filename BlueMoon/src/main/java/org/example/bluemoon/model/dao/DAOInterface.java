package org.example.bluemoon.model.dao;

import java.util.List;

public interface DAOInterface <T>{
    public void insert(T t);
    public void update(T t);
    public void delete(T t);
    public T get(int id);
    public List<T> getAll();
}
