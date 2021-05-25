/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import static DAO.DAOConnect.cnn;
import Model.RaceModel;
import Model.ResultModel;
import Model.ResultDTO;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.sql.Time;

/**
 *
 * @author thu
 */
public class ResultDAO extends DAOConnect{
    public ResultDAO(){
        super();
    }
    
    public ArrayList<ResultModel> getListResult(int raceId){
        ArrayList<ResultModel> listRs = new ArrayList<>();
        String query = "SELECT ri.ID, ra.RacerName, r.RaceName, ri.LapNumber, ri.Time, ri.Status "
                + "FROM tblregisterinformations AS ri "
                + "JOIN tblraces AS r ON r.ID = ri.tblRaceID "
                + "JOIN tblracerteam AS rt ON rt.ID = ri.tblRacerTeamID "
                + "JOIN tblracers AS ra ON ra.ID = rt.tblRacerID "
                + "WHERE r.ID = ?";
        try {
            PreparedStatement ps = cnn.prepareStatement(query);
            ps.setString(1, Integer.toString(raceId));
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                ResultModel r = new ResultModel();
                r.setId(rs.getInt("ID"));
                r.setRacerName(rs.getString("RacerName"));
                r.setRaceName(rs.getString("RaceName"));
                String lapNunber = rs.getString("LapNumber");
                if (lapNunber instanceof String) r.setLapNumber(lapNunber);
                Time time = rs.getTime("Time");
                if(time instanceof Time) r.setTime(rs.getTime("Time").toString());
                String status = rs.getString("Status");
                if(status instanceof String) 
                    if(status.equalsIgnoreCase("1"))
                        r.setStatus("Hoàn thành");
                    else 
                        r.setStatus("Chưa hoàn thành");
                listRs.add(r);
            }
        }catch(Exception e) {
            e.printStackTrace();
        }
        return listRs;
    }
    
    public boolean UpdateResult(ArrayList<ResultDTO> list){
        boolean result = false;
        try{
            cnn.setAutoCommit(false);
            for(ResultDTO r : list){
                String query = "UPDATE tblregisterinformations\n"
                + "SET "
                + "LapNumber = ?, "
                + "Time = ? , "
                + "Status = ?\n"
                + "WHERE ID = ?";
                PreparedStatement ps = cnn.prepareStatement(query);
                ps.setString(1, Integer.toString(r.getLapNumber()));
                ps.setString(2, r.getTime().toString());
                ps.setString(3, Integer.toString(r.getStatus()));
                ps.setString(4, Integer.toString(r.getId()));
                ps.executeUpdate();
            }
            result = true;
            cnn.setAutoCommit(true);
        }catch(Exception e) {
            result = false;         
            try {               
                cnn.rollback();
            }catch(Exception ex) {
                result = false;
                ex.printStackTrace();
            }
            e.printStackTrace();
        }finally {
            try {               
                //con.setAutoCommit(true);//set this line into comment in JUnit test mode
            }catch(Exception ex) {
                result = false;
                ex.printStackTrace();
            }
        }
        return result;
    }
}
