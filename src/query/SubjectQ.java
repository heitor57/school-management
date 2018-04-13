/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package query;

import classtables.Subject;
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
public class SubjectQ {
    private Connection conecta;
    public SubjectQ(){
        this.conecta = new ConectionFactory().conecta();
    }
    public void RemoveSubject(Subject obj){
        
        try{
            String cmdsql = "delete from subject where su_id = ?";
            PreparedStatement stmt = conecta.prepareStatement(cmdsql);
            stmt.setInt(1, obj.getSu_id());
            stmt.execute();
            stmt.close();
        }catch(SQLException e){
            throw new RuntimeException(e); 
        }
    }
    public void AddSubject(Subject obj){
        
        try{
            String cmdsql = "insert into subject (su_name,su_description,p_id) values (?,?,?)";
            PreparedStatement stmt = conecta.prepareStatement(cmdsql);
            stmt.setString(1, obj.getSu_name());
            stmt.setString(2, obj.getSu_description());
            if(obj.getP_id()!=null)
                stmt.setInt(3, obj.getP_id());
            else
                stmt.setNull(3, java.sql.Types.INTEGER);
            stmt.execute();
            stmt.close();
        }catch(SQLException e){
            throw new RuntimeException(e); 
        }
    }
    public List<Subject> ListSubjects(){
        try{
            String cmdsql = "select * from subject";
            PreparedStatement stmt = conecta.prepareStatement(cmdsql);
            List<Subject> list = new ArrayList<Subject>();
            ResultSet rs = stmt.executeQuery();
            while(rs.next()){
                Subject c = new Subject();
                c.setP_id(rs.getInt("p_id"));
                c.setSu_id(rs.getInt("su_id"));
                c.setSu_name(rs.getString("su_name"));
                c.setSu_description(rs.getString("su_description"));
                list.add(c);
            }
            return list;
        }catch(SQLException e){
            throw new RuntimeException(e); 
        }
    }
    public void UpdateSubject(Subject obj){
        
        try{
            String cmdsql = "UPDATE subject SET su_name = ?, su_description = ?, p_id = ? WHERE su_id = ?";
            PreparedStatement stmt = conecta.prepareStatement(cmdsql);
            stmt.setString(1, obj.getSu_name());
            stmt.setString(2, obj.getSu_description());
            stmt.setInt(3, obj.getP_id());
            stmt.setInt(4, obj.getSu_id());
            stmt.execute();
            stmt.close();
        }catch(SQLException e){
            throw new RuntimeException(e); 
        }
    }
}
