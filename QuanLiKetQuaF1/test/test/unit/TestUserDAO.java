/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test.unit;

import DAO.UserDAO;
import Model.UserModel;
import org.junit.Assert;
import org.junit.Test;

/**
 *
 * @author thu
 */
public class TestUserDAO {
    UserDAO u = new UserDAO();
    
    @Test
    public void testLoginSuccess(){
        UserModel user = new UserModel();
        user.setUsername("thumanager");
        user.setPassword("123456a@");
        Assert.assertTrue(u.checkLogin(user));
        return;
    }
    
    @Test
    public void testLoginFail(){
        UserModel user = new UserModel();
        user.setUsername("xxxxx");
        user.setPassword("123456a@");
        Assert.assertFalse(u.checkLogin(user));
        return;
    }
}
