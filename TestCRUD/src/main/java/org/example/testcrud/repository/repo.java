package org.example.testcrud.repository;

import java.util.List;

public interface repo <T> {
    List<T> selectAll();
    T selectById(int id);
    void save(T t);
    void delete(int id);
    void update(int id, T t);
}
