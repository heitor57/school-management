/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package query;

import classtables.Registration;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import jdbc.ConectionFactory;

/**
 *
 * @author heitor
 */
public class RegistrationQ {
    private Connection conecta;
    public RegistrationQ(){
        this.conecta = new ConectionFactory().conecta();
    }
    public void RemoveRegistration(Registration obj){
        
        try{
            String cmdsql = "delete from registration where su_id = ?, s_id = ?";
            PreparedStatement stmt = conecta.prepareStatement(cmdsql);
            stmt.setInt(1, obj.getSu_id());
            stmt.setInt(2, obj.getS_id());
            stmt.execute();
            stmt.close();
        }catch(SQLException e){
            throw new RuntimeException(e); 
        }
    }
    public void AddRegistration(Registration obj){
        
        try{
            String cmdsql = "insert into registration (su_id,s_id) values (?,?)";
            PreparedStatement stmt = conecta.prepareStatement(cmdsql);
            stmt.setInt(1, obj.getSu_id());
            stmt.setInt(2, obj.getS_id());
            stmt.execute();
            stmt.close();
        }catch(SQLException e){
            throw new RuntimeException(e); 
        }
    }
    public List<Registration> ListRegistrations(){
        try{
            String cmdsql = "select * from registration";
            PreparedStatement stmt = conecta.prepareStatement(cmdsql);
            List<Registration> list = new ArrayList<Registration>();
            ResultSet rs = stmt.executeQuery();
            while(rs.next()){
                Registration c = new Registration();
                c.setS_id(rs.getInt("s_id"));
                c.setSu_id(rs.getInt("su_id"));
                list.add(c);
            }
            return list;
        }catch(SQLException e){
            throw new RuntimeException(e); 
        }
    }
    public void UpdateRegistration(Registration obj){
        
        try{
            String cmdsql = "UPDATE registration SET su_id = ?,s_id = ? WHERE su_id = ?,s_id = ?";
            PreparedStatement stmt = conecta.prepareStatement(cmdsql);
            stmt.setInt(1, obj.getSu_id());
            stmt.setInt(2, obj.getS_id());
            stmt.setInt(3, obj.getSu_id());
            stmt.setInt(4, obj.getS_id());
            stmt.execute();
            stmt.close();
        }catch(SQLException e){
            throw new RuntimeException(e); 
        }
    }
}
