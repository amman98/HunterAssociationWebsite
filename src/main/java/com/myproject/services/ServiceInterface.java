package com.myproject.services;

import java.sql.SQLException;

import java.util.ArrayList;
/**
 *
 * @author Amman Nega
 * 
 * This interface includes methods that represent queries which will
 * be performed on the Hunter table in our database.
 */
public interface ServiceInterface<T> {
    
    ArrayList<T> findAll() throws SQLException;
    
    ArrayList<T> findAllAlive() throws SQLException;
    
    T findById(int id) throws SQLException;
    
    T findByName(String firstName) throws SQLException;
    
    void update(T obj) throws SQLException;
    
    T save(T obj) throws SQLException;
    
    void delete(int id) throws SQLException;
}
