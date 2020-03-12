/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hoangtd.struts2;

/**
 *
 * @author Dell
 */
public class SearchIndexAction {

    private String serchType;
    private String searchValue;
    private String rentalDate;
    private String returnDate;
    private String total;
    private final String SUCCESS = "success";

    public SearchIndexAction() {
    }

    public String getSerchType() {
        return serchType;
    }

    public void setSerchType(String serchType) {
        this.serchType = serchType;
    }

    public String getSearchValue() {
        return searchValue;
    }

    public void setSearchValue(String searchValue) {
        this.searchValue = searchValue;
    }

    public String getRentalDate() {
        return rentalDate;
    }

    public void setRentalDate(String rentalDate) {
        this.rentalDate = rentalDate;
    }

    public String getReturnDate() {
        return returnDate;
    }

    public void setReturnDate(String returnDate) {
        this.returnDate = returnDate;
    }

    public String getTotal() {
        return total;
    }

    public void setTotal(String total) {
        this.total = total;
    }

    public String execute() throws Exception {
        String url = SUCCESS;
        if (searchValue.isEmpty() || serchType.isEmpty() || rentalDate.isEmpty() || returnDate.isEmpty() || total.isEmpty()) {
            url = SUCCESS;
        } else {
            System.out.println(getSerchType());
            System.out.println(getSearchValue());
            System.out.println(getRentalDate());
            System.out.println(getReturnDate());
            System.out.println(getTotal());
        }
        return url;
    }

}
