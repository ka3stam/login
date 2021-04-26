package model;

import java.sql.Date;

/**
 *
 * @author matina
 */
public class User {
    
    private String username;
    private String at;
    private String firstname;
    private String lastname;
    private Date dob;
    private byte role;
    private byte voteBefore;

    public User() {
    }

    public User(String username, String firstname, String lastname, Date dob, String at, byte role, byte voteBefore) {
        this.username = username;
        this.at = at;
        this.firstname = firstname;
        this.lastname = lastname;
        this.dob = dob;
        this.role = role;
        this.voteBefore = voteBefore;
    }
    
    

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getAt() {
        return at;
    }

    public void setAt(String at) {
        this.at = at;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public Date getDob() {
        return dob;
    }

    public void setDob(Date dob) {
        this.dob = dob;
    }

    public byte getRole() {
        return role;
    }

    public void setRole(byte role) {
        this.role = role;
    }

    public byte getVoteBefore() {
        return voteBefore;
    }

    public void setVoteBefore(byte voteBefore) {
        this.voteBefore = voteBefore;
    }
    
    
            
          
}
