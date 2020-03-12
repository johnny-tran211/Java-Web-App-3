/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hoangtd.Registration;

import java.io.Serializable;

/**
 *
 * @author Dell
 */
public class RegistrationDTO implements Serializable{
    private String email;
    private String fullname;
    private String role;

    public RegistrationDTO(String email, String fullname, String role) {
        this.email = email;
        this.fullname = fullname;
        this.role = role;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getFullname() {
        return fullname;
    }

    public void setFullname(String fullname) {
        this.fullname = fullname;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }
    
}
