package hu.dodotech.bakeryrateapp.model.helper;

import java.io.Serializable;

public class SearchItem implements Serializable {
    private String name;
    private String address;
    private Double rate;

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

    public Double getRate() {
        return rate;
    }

    public void setRate(Double rate) {
        this.rate = rate;
    }
}
