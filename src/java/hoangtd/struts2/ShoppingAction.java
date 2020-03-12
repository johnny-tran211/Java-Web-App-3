/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hoangtd.struts2;

import hoangtd.car.CarDAO;
import hoangtd.car.CarDTO;
import java.util.ArrayList;

/**
 *
 * @author Dell
 */
public class ShoppingAction {

    private ArrayList<CarDTO> listcars;
    private final String SUCCESS = "success";
    private final String FAIL = "fail";
    private String error;

    public ArrayList<CarDTO> getListcars() {
        return listcars;
    }

    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }

    public ShoppingAction() {
    }

    public String execute() throws Exception {
        CarDAO carDAO = new CarDAO();
        listcars = carDAO.loadCar();
        String url = FAIL;

        if (listcars != null) {
            url = SUCCESS;
        } else {

            error = "No record !!!";

        }
        return url;
    }
}
