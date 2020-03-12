/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hoangtd.car;

import hoangtd.utils.Utilities;
import java.io.Serializable;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.naming.NamingException;

/**
 *
 * @author Dell
 */
public class CarDAO implements Serializable{
    Connection con = null;
    PreparedStatement ptmt = null;
    ResultSet rs = null;
    public void closeConnection() throws SQLException{
        if(rs != null){
            rs.close();
        }
        if(ptmt != null){
            ptmt.close();
        }
        if(con != null){
            con.close();
        }
    }
     public ArrayList<CarDTO> loadCar() throws NamingException, SQLException{
        con = Utilities.makeConnection();
         ArrayList<CarDTO> listcars = null;
        try {
            String sql = "Select Id, CarName, Color, Year, Category, Price, Quantity "
                    + "from Car where Quantity > 0";
            ptmt = con.prepareStatement(sql);
            rs = ptmt.executeQuery();
            listcars = new ArrayList<>();
            while(rs.next()){
                listcars.add(new CarDTO(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getInt(4), rs.getString(5), rs.getDouble(6), rs.getInt(7)));
            }
        } finally{
            closeConnection();
        }
        return listcars;
    }
}
