/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Model.UserModel;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
/**
 *
 * @author thu
 */
public class UserDAO extends DAOConnect{
    public UserDAO() {
        super();
    }
     
    public boolean checkLogin(UserModel user) {
        boolean result = false;
        String sql = "SELECT * FROM tblusers WHERE Username = ? AND Password = ?";
        try {
            PreparedStatement ps = cnn.prepareStatement(sql);
            ps.setString(1, user.getUsername());
            ps.setString(2, user.getPassword());
            ResultSet rs = ps.executeQuery();
            if(rs.next()) {
                user.setUsername(rs.getString("Username"));
                user.setType(rs.getInt("Type"));
                result = true;
            }
        }catch(Exception e) {
            e.printStackTrace();
        }
        return result;
    }
}
