package org.example.DAO;

import java.util.List;

public interface Dao<T> {
    void create(T t);
    T read(long id);
    void update(long id, T t);
    void delete(long id);
}
