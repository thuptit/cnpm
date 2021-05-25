/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test.unit;

import DAO.DAOConnect;
import DAO.ResultDAO;
import Model.ResultModel;
import Model.ResultDTO;
import java.sql.Connection;
import java.util.ArrayList;
import org.junit.Assert;
import org.junit.Test;
import java.sql.Time;

/**
 *
 * @author thu
 */
public class TestResultDAO {
    ResultDAO rs = new ResultDAO();
    
    @Test
    public void testGetListResult(){
        ArrayList<ResultModel> resultModel = new ArrayList<>();
        int Id = 1;
        resultModel = rs.getListResult(Id);
        Assert.assertNotNull(resultModel);
        Assert.assertEquals(4, resultModel.size());
        return;
    }
    
    @Test
    public void testUpdateStandard(){
        ArrayList<ResultDTO> list = new ArrayList<ResultDTO>();
        ResultDTO r = new ResultDTO();
        r.setId(4);
        r.setLapNumber(56);
        r.setTime(Time.valueOf("01:32:04"));
        r.setStatus(1);
        list.add(r);
        Connection cnn = DAOConnect.cnn;
        try{                
            cnn.setAutoCommit(false);           
            Assert.assertTrue(rs.UpdateResult(list));
        }catch(Exception e){
            e.printStackTrace();
        }finally{
            try{
                if(!cnn.getAutoCommit()) {
                    cnn.rollback();
                    cnn.setAutoCommit(true);
                }
            }catch(Exception ex){
                ex.printStackTrace();
            }
        }
        return;
    }
}
