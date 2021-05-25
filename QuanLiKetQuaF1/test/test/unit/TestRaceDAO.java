/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test.unit;

import DAO.RaceDAO;
import Model.RaceModel;
import java.util.ArrayList;
import org.junit.Assert;
import org.junit.Test;

/**
 *
 * @author thu
 */
public class TestRaceDAO {
    RaceDAO race = new RaceDAO();
    
    @Test
    public void testGetListRaceStandard(){
        ArrayList<RaceModel> listRace = race.getListRace();
        Assert.assertNotNull(listRace);
        Assert.assertEquals(3, listRace.size());
        return;
    }
}
