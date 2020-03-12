/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hoangtd.cart;

import hoangtd.car.CarDTO;
import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author Dell
 */
public class CartObj implements Serializable{
    private Map<Integer, CarDTO> listCars;

    public CartObj() {
    }
    
    
    public Map<Integer, CarDTO> getListCars() {
        return listCars;
    }


    
    public boolean addToCart(int id, String carName, String carType, int quantity, double price, int realQuantity){
        double total;
        if (this.listCars == null) {
            this.listCars = new HashMap<>();
        }
        if (this.listCars.containsKey(id)) {
            if ((this.listCars.get(id).getQuantity() + quantity) > realQuantity) {
                return false;
            }
            this.listCars.get(id).setQuantity(this.listCars.get(id).getQuantity() + quantity);
            total = this.listCars.get(id).getQuantity() * this.listCars.get(id).getPrice();
            this.listCars.get(id).setTotal(total);
            listCars.put(id, this.listCars.get(id));
        } else {
            if (quantity > realQuantity) {
                return false;
            }
            total = quantity * price;
            listCars.put(id, new CarDTO(carName, carType, quantity, price, total));
        }
        return true;
    }
    public void deleteItem(int id) {
        if (this.listCars == null) {
            return;
        }
        if (this.listCars.containsKey(id)) {
            this.listCars.remove(id);
        }
        if (listCars.isEmpty()) {
            listCars = null;
        }
    }
}
