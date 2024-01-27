package org.example;

import java.util.List;
import java.util.Optional;

public interface DAO<T> {
    void insert(T t);
    Optional<T> selectById(int id);
    List<T> selectAll();
    int updateById(int id, T t);
    int deleteById(int id);
}
