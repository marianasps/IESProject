package ua.ies.project.model;

import java.util.*;
import javax.persistence.*;

@Entity
@Table(name = "co2")
public class Co2 extends SensorData {

    public Co2() { 
        super();
    }

    public Co2( double value, String timestamp, Sensor sensor, boolean warn) {
        super(timestamp,  sensor, warn);
        this.value = value;
 
    }

    public Co2( double value, Date timestamp, Sensor sensor, boolean warn) {
        super(timestamp,  sensor, warn);
        this.value = value;
 
    }


    @Column(name="value")
    private double value;
    public double getValue() { return value; }
    public void setValue(double val) {
         value = val; }

    

    @Override
    public String toString() {
        return "[ co2 entry id= " + super.getId() + ": timestamp= " + super.getTimestamp() +  "; sensor= " + super.getSensor() + "; VALUE= " + value + " ]" ;
    }
    
    /* https://www.javaguides.net/2018/09/spring-boot-2-jpa-mysql-crud-example.html */
    
    @Override
    public Map<String, Object> convertToMap() {
        HashMap<String, Object> hm = new HashMap<String, Object>();
        hm.put("id", super.getId());
        hm.put("timestamp", super.getTimestamp());
        hm.put("warn", super.getWarn());

        hm.put("value", value);
        return hm;
    }   
}
