/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hoangtd.struts2;

import com.opensymphony.xwork2.ActionContext;
import hoangtd.Registration.RegistrationDTO;
import hoangtd.cart.CartObj;
import hoangtd.template.checkValidation;
import org.apache.struts2.dispatcher.RequestMap;
import org.apache.struts2.dispatcher.SessionMap;

/**
 *
 * @author Dell
 */
public class AddToCartAction {

    private final String SUCCESS = "success";
    private final String FAIL = "fail";
    private final String LOGIN = "login";
    private String id;
    private String carName;
    private String category;
    private String price;
    private String realQuantity;
    private String quantity;
    private String errorQuantity;

    public String getErrorQuantity() {
        return errorQuantity;
    }

    public void setErrorQuantity(String errorQuantity) {
        this.errorQuantity = errorQuantity;
    }
    

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getRealQuantity() {
        return realQuantity;
    }

    public void setRealQuantity(String realQuantity) {
        this.realQuantity = realQuantity;
    }

    public String getQuantity() {
        return quantity;
    }

    public void setQuantity(String quantity) {
        this.quantity = quantity;
    }

    public String getCarName() {
        return carName;
    }

    public void setCarName(String carName) {
        this.carName = carName;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public AddToCartAction() {
    }

    public String execute() throws Exception {
        SessionMap session = (SessionMap) ActionContext.getContext().getSession();
        RegistrationDTO user = (RegistrationDTO) session.get("USER");
        String url = LOGIN;
        if (user != null) {
            if (user.getRole().equals("user")) {
                if (quantity.isEmpty()) {
                    return FAIL;
                }
                boolean checkId = checkValidation.checkNumber(this.id);
                boolean checkQuantity = checkValidation.checkNumber(this.quantity);
                boolean checkRealQuantity = checkValidation.checkNumber(this.realQuantity);
                boolean checkPrice = checkValidation.checkDoubleNumber(this.price);
                if (checkPrice == false || checkRealQuantity == false || checkQuantity == false || checkId == false) {
                    return FAIL;
                } else {
                    int idNum = Integer.parseInt(id);
                    int quantityNum = Integer.parseInt(quantity);
                    int realQuantityNum = Integer.parseInt(realQuantity);
                    double priceNum = Double.parseDouble(price);
                    CartObj cart = (CartObj) session.get("CART");
                    if (cart == null) {
                        cart = new CartObj();
                    }
                    boolean result = cart.addToCart(idNum, carName, carName, quantityNum, priceNum, realQuantityNum);
                    if (result) {
                        session.put("CART", cart);
                        url = SUCCESS;
                    } else {
                        errorQuantity = "Out of stock";
                        url = FAIL;
                    }

                }

            }
        }
        return url;
    }

}
