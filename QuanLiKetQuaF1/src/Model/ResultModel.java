/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;
import java.io.Serializable;
import java.sql.Time;
/**
 *
 * @author thu
 */
public class ResultModel implements Serializable{
    private int Id;
    private String raceName;
    private int raceId;
    private String racerTeamName;
    private int racerTeamId;
    private String username;
    private int userId;
    private String LapNumber;
    private String time;
    private String status;
    private String racerName;

    public ResultModel() {
        super();
    }

    public ResultModel(String raceName, String racerTeamName, String username, String LapNumber, String time, String status, String racerName) {
        this.raceName = raceName;
        this.racerTeamName = racerTeamName;
        this.username = username;
        this.LapNumber = LapNumber;
        this.time = time;
        this.status = status;
        this.racerName = racerName;
    }

    public int getId() {
        return Id;
    }

    public void setId(int Id) {
        this.Id = Id;
    }

    public String getRaceName() {
        return raceName;
    }

    public void setRaceName(String raceName) {
        this.raceName = raceName;
    }

    public int getRaceId() {
        return raceId;
    }

    public void setRaceId(int raceId) {
        this.raceId = raceId;
    }

    public String getRacerTeamName() {
        return racerTeamName;
    }

    public void setRacerTeamName(String racerTeamName) {
        this.racerTeamName = racerTeamName;
    }

    public int getRacerTeamId() {
        return racerTeamId;
    }

    public void setRacerTeamId(int racerTeamId) {
        this.racerTeamId = racerTeamId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getLapNumber() {
        return LapNumber;
    }

    public void setLapNumber(String LapNumber) {
        this.LapNumber = LapNumber;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getRacerName() {
        return racerName;
    }

    public void setRacerName(String racerName) {
        this.racerName = racerName;
    }

    
}
