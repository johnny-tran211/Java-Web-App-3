/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hoangtd.struts2;

import com.opensymphony.xwork2.ActionContext;
import hoangtd.Registration.RegistrationDAO;
import hoangtd.Registration.RegistrationDTO;
import org.apache.struts2.dispatcher.RequestMap;
import org.apache.struts2.dispatcher.SessionMap;

/**
 *
 * @author Dell
 */
public class LoginAction {

    private String username;
    private String password;
    private final String SUCCESS = "success";
    private final String FAIL = "fail";

    public LoginAction() {
    }


    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String execute() throws Exception {
        RegistrationDAO registrationDAO = new RegistrationDAO();
        RegistrationDTO user = registrationDAO.checkLogin(username, password);
        String url = FAIL;
        if (user != null) {
            SessionMap session = (SessionMap) ActionContext.getContext().getSession();
            session.put("USER", user);
            url = SUCCESS;
        } else {
            RequestMap request = (RequestMap) ActionContext.getContext().get("request");
            request.put("ERROR", "Email is not existed !");
        }
        return url;
    }

}
