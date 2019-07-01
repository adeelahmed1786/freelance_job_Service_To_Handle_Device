package com.restapi.jobdemo.model;

import java.util.ArrayList;
import java.util.List;

public class RadioDevice {

    public String alias ="";
    public List<String> allowed_locations = new ArrayList<>();
    public String currentLocation = "undefined";

    public RadioDevice(String alias, List<String> allowed_locations, String currentLocation) {
        this.alias = alias;
        this.allowed_locations = allowed_locations;
        this.currentLocation = currentLocation;
    }
    public RadioDevice(String alias, List<String> allowed_locations) {
        this.alias = alias;
        this.allowed_locations = allowed_locations;
        this.currentLocation = "";
    }
    public RadioDevice() {
        this.alias = "";
        this.allowed_locations  = new ArrayList<>();
        this.currentLocation = "";
    }
    public String getAlias() {
        return alias;
    }

    public void setAlias(String alias) {
        this.alias = alias;
    }

    public String getCurrentLocation() {
        return currentLocation;
    }

    public void setCurrentLocation(String currentLocation) {
        this.currentLocation = currentLocation;
    }

    public List<String> getAllowed_locations() {
        return allowed_locations;
    }

    public void setAllowed_locations(List<String> allowed_locations) {
        this.allowed_locations = allowed_locations;
    }
}
