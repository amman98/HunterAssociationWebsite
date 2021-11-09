package com.myproject.services;
import java.sql.SQLException;

import java.util.ArrayList;

import com.myproject.beans.Hunter;
import com.myproject.dal.HunterDao;
/**
 *
 * @author Amman Nega
 */
public class HunterService implements ServiceInterface<Hunter> {
    private static HunterDao dao;
    
    public HunterService() {
        dao = new HunterDao();
    }
    
    public Hunter save(Hunter hunter) throws SQLException {
        return dao.save(hunter);
    }
    
    public ArrayList<Hunter> findAll() throws SQLException {
        return dao.findAll();
    }
    
    public ArrayList<Hunter> findAllAlive() throws SQLException {
        return dao.findAllAlive();
    }
    
    public Hunter findById(int id) throws SQLException {
        return dao.findById(id);
    }
    
    public Hunter findByName(String firstName) throws SQLException {
    	return dao.findByName(firstName);
    }
    
    public void update(Hunter obj) throws SQLException {
        dao.update(obj);
    }
    
    public void delete(int id) throws SQLException {
        dao.delete(id);
    }
}
