/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;
import java.io.Serializable;
import java.sql.Date;

/**
 *
 * @author thu
 */
public class RaceModel implements Serializable{
    private int Id;
    private String name;
    private String address;
    private Date startTime;
    private Date endTime;

    public RaceModel() {
        super();
    }

    public RaceModel(String name, String address, Date startTime, Date endTime) {
        this.name = name;
        this.address = address;
        this.startTime = startTime;
        this.endTime = endTime;
    }

    public int getId() {
        return Id;
    }

    public void setId(int Id) {
        this.Id = Id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Date getStartTime() {
        return startTime;
    }

    public void setStartTime(Date startTime) {
        this.startTime = startTime;
    }

    public Date getEndTime() {
        return endTime;
    }

    public void setEndTime(Date endTime) {
        this.endTime = endTime;
    }
    
}
