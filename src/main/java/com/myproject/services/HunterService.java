package com.myproject.services;

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
    
    public Hunter save(Hunter hunter) {
        return dao.save(hunter);
    }
    
    public ArrayList<Hunter> findAll() {
        return dao.findAll();
    }
    
    public ArrayList<Hunter> findAllAlive() {
        return dao.findAllAlive();
    }
    
    public Hunter findById(String firstName) {
        return dao.findByName(firstName);
    }
    
    public void update(Hunter obj) {
        dao.update(obj);
    }
    
    public void delete(String firstName) {
        dao.delete(firstName);
    }
}
