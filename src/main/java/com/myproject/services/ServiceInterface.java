package com.myproject.services;

import java.util.ArrayList;
/**
 *
 * @author Amman Nega
 * 
 * This interface includes methods that represent queries which will
 * be performed on the Hunter table in our database.
 */
public interface ServiceInterface<T> {
    
    ArrayList<T> findAll();
    
    ArrayList<T> findAllAlive();
    
    T findById(String firstName);
    
    void update(T obj);
    
    T save(T obj);
    
    void delete(String firstName);
}
