/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import static DAO.DAOConnect.cnn;
import Model.RaceModel;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

/**
 *
 * @author thu
 */
public class RaceDAO extends DAOConnect{
    public RaceDAO(){
        super();
    }
    public ArrayList<RaceModel> getListRace(){
        ArrayList<RaceModel> listRace = new ArrayList<>();
        String query = "SELECT * FROM tblraces";
        try {
            PreparedStatement ps = cnn.prepareStatement(query);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                RaceModel race = new RaceModel();
                race.setId(rs.getInt("ID"));
                race.setName(rs.getString("RaceName"));
                race.setAddress(rs.getString("Address"));
                race.setStartTime(rs.getDate("StartTime"));
                race.setEndTime(rs.getDate("EndTime"));
                listRace.add(race);
            }
            System.out.println(listRace);
        }catch(Exception e) {
            e.printStackTrace();
        }
        return listRace;
    }
}
