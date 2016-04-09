package hu.dodotech.bakeryrateapp.model;

public class Bakery {
    private Integer id;
    private Integer rate;
    private Integer bakeryImageResourceId;
    private Integer rateImageResourceId;
    private String name;
    private String details;
    private String address;

    public Integer getBakeryImageResourceId() {
        return bakeryImageResourceId;
    }

    public void setBakeryImageResourceId(Integer bakeryImageResourceId) {
        this.bakeryImageResourceId = bakeryImageResourceId;
    }

    public Integer getRateImageResourceId() {
        return rateImageResourceId;
    }

    public void setRateImageResourceId(Integer rateImageResourceId) {
        this.rateImageResourceId = rateImageResourceId;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getRate() {
        return rate;
    }

    public void setRate(Integer rate) {
        this.rate = rate;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDetails() {
        return details;
    }

    public void setDetails(String details) {
        this.details = details;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
