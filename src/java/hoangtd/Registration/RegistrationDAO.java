/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hoangtd.Registration;

import hoangtd.utils.Utilities;
import java.io.Serializable;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.naming.NamingException;

/**
 *
 * @author Dell
 */
public class RegistrationDAO implements Serializable{
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
    public RegistrationDTO checkLogin(String username, String password) throws NamingException, SQLException{
        con = Utilities.makeConnection();
        RegistrationDTO user = null;
        try {
            String sql = "Select Email, Fullname, Role "
                    + "from Registration where Email = ? and Password = ?";
            ptmt = con.prepareStatement(sql);
            ptmt.setString(1, username);
            ptmt.setString(2, password);
            rs = ptmt.executeQuery();
            if(rs.next()){
                user = new RegistrationDTO(rs.getString(1), rs.getString(2), rs.getString(3));
            }
        } finally{
            closeConnection();
        }
        return user;
    }
}
