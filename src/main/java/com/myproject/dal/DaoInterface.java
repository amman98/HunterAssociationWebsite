package com.myproject.dal;

import java.util.ArrayList;
/**
 *
 * @author Amman Nega
 */
public interface DaoInterface<T> {
    ArrayList<T> findAll();
    
    T findByName(String firstName);
    
    void update(T obj);
    
    T save(T obj);
    
    void delete(String firstName);
}
