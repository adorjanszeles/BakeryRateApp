package hu.dodotech.bakeryrateapp.common;

import java.util.ArrayList;
import java.util.List;

import hu.dodotech.bakeryrateapp.model.Bakery;

public class ListSearchHelper {
    public static List<Bakery> searchByConditions(List<Bakery> bakeries, SearchItem item) {
        String name = item.getName();
        String address = item.getAddress();
        double rate = item.getRate();
        List<Bakery> result = new ArrayList<>();
        for (Bakery bakery : bakeries) {
            boolean isName = false;
            boolean isAddress = false;
            boolean isRate = false;

            if(!"".equals(name) && name != null) {
                if(bakery.getName().matches(".*" + name + ".*")) {
                    isName = true;
                }
            } else {
                isName = true;
            }

            if(!"".equals(address) && address != null) {
                if(bakery.getAddress().matches(".*" + address + ".*")) {
                    isAddress = true;
                }
            } else {
                isAddress = true;
            }

            if(rate != 0) {
                if(bakery.getRate() >= rate) {
                    isRate = true;
                }
            } else {
                isRate = true;
            }

            if(isRate && isAddress && isName) {
                result.add(bakery);
            }
        }
        return result;
    }
}
