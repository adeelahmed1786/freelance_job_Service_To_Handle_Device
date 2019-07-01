package com.restapi.jobdemo.model;

import java.util.ArrayList;
import java.util.List;

public class RadioDeviceModal {

    public String alias ="";
    public List<String> allowed_locations = new ArrayList<>();



    public RadioDeviceModal(String alias, List<String> allowed_locations) {
        this.alias = alias;
        this.allowed_locations = allowed_locations;

    }
    public RadioDeviceModal() {
        this.alias = "";
        this.allowed_locations  = new ArrayList<>();

    }
    public String getAlias() {
        return alias;
    }

    public void setAlias(String alias) {
        this.alias = alias;
    }

    public List<String> getAllowed_locations() {
        return allowed_locations;
    }

    public void setAllowed_locations(List<String> allowed_locations) {
        this.allowed_locations = allowed_locations;
    }
}
