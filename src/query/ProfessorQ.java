/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package query;

import classtables.Professor;
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
public class ProfessorQ {
    private Connection conecta;
    public ProfessorQ(){
        this.conecta = new ConectionFactory().conecta();
    }
    
    public void RemoveProfessor(Professor obj){
        
        try{
            String cmdsql = "delete from professor where p_id = ?";
            PreparedStatement stmt = conecta.prepareStatement(cmdsql);
            stmt.setInt(1, obj.getP_id());
            stmt.execute();
            stmt.close();
        }catch(SQLException e){
            throw new RuntimeException(e); 
        }
    }
    public void AddProfessor(Professor obj){
        
        try{
            String cmdsql = "insert into professor (p_name) values (?)";
            PreparedStatement stmt = conecta.prepareStatement(cmdsql);
            stmt.setString(1, obj.getP_name());
            stmt.execute();
            stmt.close();
        }catch(SQLException e){
            throw new RuntimeException(e); 
        }
    }
    public List<Professor> ListProfessors(){
        try{
            String cmdsql = "select * from professor";
            PreparedStatement stmt = conecta.prepareStatement(cmdsql);
            List<Professor> list = new ArrayList<Professor>();
            ResultSet rs = stmt.executeQuery();
            while(rs.next()){
                Professor c = new Professor();
                c.setP_id(rs.getInt("p_id"));
                c.setP_name(rs.getString("p_name"));
                list.add(c);
            }
            return list;
        }catch(SQLException e){
            throw new RuntimeException(e); 
        }
    }
    public void UpdateProfessor(Professor obj){
        
        try{
            String cmdsql = "UPDATE professor SET p_name = ? WHERE p_id = ?";
            PreparedStatement stmt = conecta.prepareStatement(cmdsql);
            stmt.setString(1, obj.getP_name());
            stmt.setInt(2, obj.getP_id());
            stmt.execute();
            stmt.close();
        }catch(SQLException e){
            throw new RuntimeException(e); 
        }
    }
}
