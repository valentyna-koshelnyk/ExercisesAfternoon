package org.example.persistence.util;

import java.util.List;

public interface DAO <T> {
    List<T> findall();
    T findById(int id);
    void add(T t);
    void update(T t);
    void deleteById(int id);

}