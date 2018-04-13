/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package query;

import classtables.Student;
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
public class StudentQ {
    private Connection conecta;
    public StudentQ(){
        this.conecta = new ConectionFactory().conecta();
    }
    public void RemoveStudent(Student obj){
        
        try{
            String cmdsql = "delete from student where s_id = ?";
            PreparedStatement stmt = conecta.prepareStatement(cmdsql);
            stmt.setInt(1, obj.getS_id());
            stmt.execute();
            stmt.close();
        }catch(SQLException e){
            throw new RuntimeException(e); 
        }
    }
    public void AddStudent(Student obj){
        
        try{
            String cmdsql = "insert into student (s_name) values (?)";
            PreparedStatement stmt = conecta.prepareStatement(cmdsql);
            stmt.setString(1, obj.getS_name());
            stmt.execute();
            stmt.close();
        }catch(SQLException e){
            throw new RuntimeException(e); 
        }
    }
    public List<Student> ListStudents(){
        try{
            String cmdsql = "select * from student";
            PreparedStatement stmt = conecta.prepareStatement(cmdsql);
            List<Student> list = new ArrayList<Student>();
            ResultSet rs = stmt.executeQuery();
            while(rs.next()){
                Student c = new Student();
                c.setS_id(rs.getInt("s_id"));
                c.setS_name(rs.getString("s_name"));
                list.add(c);
            }
            return list;
        }catch(SQLException e){
            throw new RuntimeException(e); 
        }
    }
    public void UpdateStudent(Student obj){
        
        try{
            String cmdsql = "UPDATE student SET s_name = ? WHERE s_id = ?";
            PreparedStatement stmt = conecta.prepareStatement(cmdsql);
            stmt.setString(1, obj.getS_name());
            stmt.setInt(2, obj.getS_id());
            stmt.execute();
            stmt.close();
        }catch(SQLException e){
            throw new RuntimeException(e); 
        }
    }
}
