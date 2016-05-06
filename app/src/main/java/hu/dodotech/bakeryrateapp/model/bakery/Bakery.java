package hu.dodotech.bakeryrateapp.model.bakery;

import com.orm.SugarRecord;

import java.io.Serializable;
import java.util.List;

import hu.dodotech.bakeryrateapp.common.RatingHelper;
import hu.dodotech.bakeryrateapp.model.helper.SearchItem;

public class Bakery extends SugarRecord implements BakeryDal, Serializable {
    private double rate;
    private int numberOfRatings;
    private Integer bakeryImageResourceId;
    private Integer rateImageResourceId;
    private String name;
    private String details;
    private String address;

    public Bakery(){}

    public Integer getBakeryImageResourceId() {
        return bakeryImageResourceId;
    }

    public void setBakeryImageResourceId(Integer bakeryImageResourceId) {
        this.bakeryImageResourceId = bakeryImageResourceId;
    }

    public Integer getRateImageResourceId() {
        return rateImageResourceId;
    }

    public void setRateImageResourceId() {
        this.rateImageResourceId = RatingHelper.getRatingResource(this.rate);
    }

    public double getRate() {
        return rate;
    }

    public void setRate(double rate) {
        this.numberOfRatings++;
        this.rate += rate;
        this.rate /= numberOfRatings;
        setRateImageResourceId();
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

    @Override
    public List<Bakery> listAllBakeryItems(Class<?> pClass) {
        return null;
    }

    @Override
    public List<Bakery> listQueryBakery(SearchItem searchItem) {
        return null;
    }

    @Override
    public void addBakery(Bakery bakery) {

    }

    @Override
    public void deleteBakery(Bakery bakery) {

    }

    @Override
    public void modifyBakery(Bakery bakery) {

    }

    @Override
    public void rateBakery(Bakery bakery) {

    }
}
