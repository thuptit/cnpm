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
public class ResultDTO implements Serializable{
    private int Id;
    private int lapNumber;
    private Time time;
    private int status;

    public ResultDTO() {
    }

    public ResultDTO(int Id, int lapNumber, Time time, int status) {
        this.Id = Id;
        this.lapNumber = lapNumber;
        this.time = time;
        this.status = status;
    }

    public int getId() {
        return Id;
    }

    public void setId(int Id) {
        this.Id = Id;
    }

    public int getLapNumber() {
        return lapNumber;
    }

    public void setLapNumber(int lapNumber) {
        this.lapNumber = lapNumber;
    }

    public Time getTime() {
        return time;
    }

    public void setTime(Time time) {
        this.time = time;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    
}
