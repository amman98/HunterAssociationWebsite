package com.myproject.dal;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import com.myproject.beans.Hunter;
import com.myproject.utilities.DBCon;
/**
 *
 * @author Amman Nega
 */
public class HunterDao implements DaoInterface<Hunter> {
    
    public static final String TABLE = "HUNTER";
    
    /*
    * returns result of a select all query on the Hunter table
    */
    public ArrayList<Hunter> findAll() {
        ArrayList<Hunter> hunters = new ArrayList<Hunter>();
        
        Connection con = DBCon.getConnection();
        
        try {
            String qry = "select * from " + TABLE;
            PreparedStatement st = con.prepareStatement(qry);
            ResultSet rs = st.executeQuery();
            
            while(rs.next()) {
                Hunter hunter = new Hunter();
                hunter.setFirstName(rs.getString(1));
                hunter.setLastName(rs.getString(2));
                hunter.setNenAffinity(rs.getString(3));
                hunter.setOccupation(rs.getString(4));
                hunter.setStatus(rs.getString(5));
                hunter.setDescription(rs.getString(6));
                
                hunters.add(hunter);
            }
        } catch(Exception e) {
            e.printStackTrace();
        } finally {
            DBCon.closeConnection();
        }
        
        return hunters;
    }
    
    /*
    * This query is unique to the Hunter X Hunter lore.
    * Specifically, it finds which Hunters are still
    * alive in the comic book continuity.
    */
    public ArrayList<Hunter> findAllAlive() {
        ArrayList<Hunter> hunters = new ArrayList<Hunter>();
        
        Connection con = DBCon.getConnection();
        
        try {
            String qry = "select * from " + TABLE + " WHERE Status = 'Alive'";
            PreparedStatement st = con.prepareStatement(qry);
            ResultSet rs = st.executeQuery();
            
            while(rs.next()) {
                Hunter hunter = new Hunter();
                hunter.setFirstName(rs.getString(1));
                hunter.setLastName(rs.getString(2));
                hunter.setNenAffinity(rs.getString(3));
                hunter.setOccupation(rs.getString(4));
                hunter.setStatus(rs.getString(5));
                hunter.setDescription(rs.getString(6));
                
                hunters.add(hunter);
            }
        } catch(Exception e) {
            e.printStackTrace();
        } finally {
            DBCon.closeConnection();
        }
        
        return hunters;
    }
    
    public Hunter findByName(String firstName) {
        Connection con = DBCon.getConnection();
        Hunter hunter = new Hunter();
        
        try {
            String qry = "select * from " + TABLE + "where First_name = ?";
            PreparedStatement st = con.prepareStatement(qry);
            st.setString(1, firstName);
            ResultSet rs = st.executeQuery();
            if(rs.next()) {
                hunter.setFirstName(rs.getString(1));
                hunter.setLastName(rs.getString(2));
                hunter.setNenAffinity(rs.getString(3));
                hunter.setOccupation(rs.getString(4));
                hunter.setStatus(rs.getString(5));
                hunter.setDescription(rs.getString(6));
            }
        } catch(Exception e) {
            e.printStackTrace();
        } finally {
            DBCon.closeConnection();
        }
        return hunter;
    }
    
    public void update(Hunter hunter) {
        Connection con = DBCon.getConnection();
        
        try {
            String qry = "update " + TABLE + " "
                    + "set First_name = ?, Last_name = ?, Nen_affinity = ?, Occupation = ?, Status = ?, Description = ? "
                    + "where First_name = ?";
            PreparedStatement st = con.prepareStatement(qry);
            st.setString(1, hunter.getFirstName());
            st.setString(2, hunter.getLastName());
            st.setString(3, hunter.getNenAffinity());
            st.setString(4, hunter.getOccupation());
            st.setString(5, hunter.getStatus());
            st.setString(6, hunter.getDescription());
            st.setString(7, hunter.getFirstName());
            
            st.executeUpdate();
            
        } catch(Exception e) {
            e.printStackTrace();
        } finally {
            DBCon.closeConnection();
        }
    }
    
    public Hunter save(Hunter obj) {
        Connection con = DBCon.getConnection();
        
        try {
            String qry = "insert into " + TABLE + " (First_name, Last_name, Nen_affinity, Occupation, Status, Description) values (?, ?, ?, ?, ?, ?)";
            PreparedStatement st = con.prepareStatement(qry);
            st.setString(1, obj.getFirstName());
            st.setString(2, obj.getLastName());
            st.setString(3, obj.getNenAffinity());
            st.setString(4, obj.getOccupation());
            st.setString(5, obj.getStatus());
            st.setString(6, obj.getDescription());
            
            st.executeUpdate();
        } catch(Exception e) {
            e.printStackTrace();
        } finally {
            DBCon.closeConnection();
        }
        
        return obj;
    }
    
    public void delete(String firstName) {
        Connection con = DBCon.getConnection();
        
        try {
            String qry = "delete from " + TABLE + " WHERE First_name = ?";
            PreparedStatement st = con.prepareStatement(qry);
            st.setString(1, firstName);
            
            st.executeQuery();
        } catch(Exception e) {
            e.printStackTrace();
        } finally {
            DBCon.closeConnection();
        }
    }
}
