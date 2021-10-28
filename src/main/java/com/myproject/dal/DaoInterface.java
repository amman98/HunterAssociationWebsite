package com.myproject.dal;

import java.sql.SQLException;

import java.util.ArrayList;
/**
 *
 * @author Amman Nega
 */
public interface DaoInterface<T> {
    ArrayList<T> findAll() throws SQLException;
    
    T findByName(String firstName) throws SQLException;
    
    void update(T obj) throws SQLException;
    
    T save(T obj) throws SQLException;
    
    void delete(String firstName) throws SQLException;
}
