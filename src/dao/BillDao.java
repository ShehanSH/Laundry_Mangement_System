/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import javax.swing.JOptionPane;
import java.sql.*;
import model.Bill;
/**
 *
 * @author SHEN
 */
public class BillDao {
    
    public static String getId(){
        int id = 1;
        try {
            ResultSet rs = DbOperation.getData("Select max(id) from bill");
            if(rs.next()){
                
                id = rs.getInt(1);      // data type eka string danma int id eke
                id = id +1;
                
                
            }
        }
        catch(Exception e){
            JOptionPane.showMessageDialog(null, e);
        }
        return String.valueOf(id);
    }
    
    public static void save(Bill bill){
        
        String query = "insert into bill values('"+bill.getId()+"', '"+bill.getName()+"', '"+bill.getMobileNumber()+"', '"+bill.getEmail()+"', '"+bill.getDate()+"', '"+bill.getTotal()+"', '"+bill.getCreatedBy()+"')";
        DbOperation.setDataOrDelete(query, "Bill Details Added Successfully !");
        
    }
}
