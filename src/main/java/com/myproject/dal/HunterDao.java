package com.myproject.dal;

import java.sql.SQLException;

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
    public ArrayList<Hunter> findAll() throws SQLException {
        ArrayList<Hunter> hunters = new ArrayList<Hunter>();
        
        Connection con = DBCon.getConnection();
        
        try {
            String qry = "select * from " + TABLE;
            PreparedStatement st = con.prepareStatement(qry);
            ResultSet rs = st.executeQuery();
            
            while(rs.next()) {
                Hunter hunter = new Hunter();
                hunter.setId(rs.getInt(1));
                hunter.setFirstName(rs.getString(2));
                hunter.setLastName(rs.getString(3));
                hunter.setNenAffinity(rs.getString(4));
                hunter.setOccupation(rs.getString(5));
                hunter.setStatus(rs.getString(6));
                hunter.setDescription(rs.getString(7));
                
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
    public ArrayList<Hunter> findAllAlive() throws SQLException {
        ArrayList<Hunter> hunters = new ArrayList<Hunter>();
        
        Connection con = DBCon.getConnection();
        
        try {
            String qry = "select * from " + TABLE + " WHERE Status = 'Alive'";
            PreparedStatement st = con.prepareStatement(qry);
            ResultSet rs = st.executeQuery();
            
            while(rs.next()) {
                Hunter hunter = new Hunter();
                hunter.setId(rs.getInt(1));
                hunter.setFirstName(rs.getString(2));
                hunter.setLastName(rs.getString(3));
                hunter.setNenAffinity(rs.getString(4));
                hunter.setOccupation(rs.getString(5));
                hunter.setStatus(rs.getString(6));
                hunter.setDescription(rs.getString(7));
                
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
     * for potential search bar I may incorporate to project
     */
    public Hunter findByName(String firstName) throws SQLException {
        Connection con = DBCon.getConnection();
        Hunter hunter = new Hunter();
        
        try {
            String qry = "select * from " + TABLE + " WHERE First_name = ?";
            PreparedStatement st = con.prepareStatement(qry);
            st.setString(1, firstName);
            ResultSet rs = st.executeQuery();
            if(rs.next()) {
                hunter.setId(rs.getInt(1));
                hunter.setFirstName(rs.getString(2));
                hunter.setLastName(rs.getString(3));
                hunter.setNenAffinity(rs.getString(4));
                hunter.setOccupation(rs.getString(5));
                hunter.setStatus(rs.getString(6));
                hunter.setDescription(rs.getString(7));
            }
        } catch(Exception e) {
            e.printStackTrace();
        } finally {
            DBCon.closeConnection();
        }
        return hunter;
    }
    
    public Hunter findById(int id) throws SQLException {
    	Connection con = DBCon.getConnection();
        Hunter hunter = new Hunter();
        
        try {
            String qry = "select * from " + TABLE + " WHERE Id = ?";
            PreparedStatement st = con.prepareStatement(qry);
            st.setInt(1, id);
            ResultSet rs = st.executeQuery();
            if(rs.next()) {
                hunter.setId(rs.getInt(1));
                hunter.setFirstName(rs.getString(2));
                hunter.setLastName(rs.getString(3));
                hunter.setNenAffinity(rs.getString(4));
                hunter.setOccupation(rs.getString(5));
                hunter.setStatus(rs.getString(6));
                hunter.setDescription(rs.getString(7));
            }
        } catch(Exception e) {
            e.printStackTrace();
        } finally {
            DBCon.closeConnection();
        }
        return hunter;
    }
    
    public void update(Hunter hunter) throws SQLException {
        Connection con = DBCon.getConnection();
        
        try {
            String qry = "update " + TABLE 
                    + " set First_name = ?, Last_name = ?, Nen_affinity = ?, Occupation = ?, Status = ?, Description = ? "
                    + "where Id = ?";
            PreparedStatement st = con.prepareStatement(qry);
            st.setString(1, hunter.getFirstName());
            st.setString(2, hunter.getLastName());
            st.setString(3, hunter.getNenAffinity());
            st.setString(4, hunter.getOccupation());
            st.setString(5, hunter.getStatus());
            st.setString(6, hunter.getDescription());
            st.setInt(7, hunter.getId());
            
            st.executeUpdate();
            
        } catch(Exception e) {
            e.printStackTrace();
        } finally {
            DBCon.closeConnection();
        }
    }
    
    public Hunter save(Hunter obj) throws SQLException {
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
    
    public void delete(int id) throws SQLException {
        Connection con = DBCon.getConnection();
        
        try {
            String qry = "delete from " + TABLE + " WHERE Id = ?";
            PreparedStatement st = con.prepareStatement(qry);
            st.setInt(1, id);
            
            st.executeUpdate();
        } catch(Exception e) {
            e.printStackTrace();
        } finally {
            DBCon.closeConnection();
        }
    }
}
