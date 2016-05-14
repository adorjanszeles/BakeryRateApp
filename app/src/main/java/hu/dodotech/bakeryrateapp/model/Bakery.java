package hu.dodotech.bakeryrateapp.model;

import com.google.gson.annotations.SerializedName;
import com.orm.SugarRecord;

import java.io.Serializable;
import java.util.Objects;

import hu.dodotech.bakeryrateapp.common.RatingHelper;

public class Bakery extends SugarRecord implements Serializable {
    @SerializedName("rate")
    private double rate;
    @SerializedName("numberOfRates")
    private int numberOfRatings;
    @SerializedName("bakeryImage")
    private Integer bakeryImageResourceId;
    @SerializedName("rateImage")
    private Integer rateImageResourceId;
    @SerializedName("name")
    private String name;
    @SerializedName("details")
    private String details;
    @SerializedName("address")
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
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Bakery bakery = (Bakery) o;
        return Objects.equals(this.getId(), bakery.getId()) &&
                Objects.equals(name, bakery.name) &&
                Objects.equals(details, bakery.details) &&
                Objects.equals(address, bakery.address) &&
                Objects.equals(rate, bakery.rate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.getId(), name, details, address, rate);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class Bakery {\n");
        sb.append("    id: ").append(toIndentedString(this.getId())).append("\n");
        sb.append("    name: ").append(toIndentedString(name)).append("\n");
        sb.append("    details: ").append(toIndentedString(details)).append("\n");
        sb.append("    address: ").append(toIndentedString(address)).append("\n");
        sb.append("    rate: ").append(toIndentedString(rate)).append("\n");
        sb.append("}");
        return sb.toString();
    }

    /**
     * Convert the given object to string with each line indented by 4 spaces
     * (except the first line).
     */
    private String toIndentedString(Object o) {
        if (o == null) {
            return "null";
        }
        return o.toString().replace("\n", "\n    ");
    }
}
