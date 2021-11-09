package com.myproject.dal;

import java.sql.SQLException;

import java.util.ArrayList;

import com.myproject.beans.Hunter;
/**
 *
 * @author Amman Nega
 */
public interface DaoInterface<T> {
    ArrayList<T> findAll() throws SQLException;
    
    ArrayList<Hunter> findAllAlive() throws SQLException;
    
    T findById(int id) throws SQLException;
    
    T findByName(String firstName) throws SQLException;
    
    void update(T obj) throws SQLException;
    
    T save(T obj) throws SQLException;
    
    void delete(int id) throws SQLException;
}
