package com.rabelas.weathercurrentday;

public class EvacCenter {
    String name, city;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }


    EvacCenter(String name, String city){
        this.name=name;
        this.city=city;

    }
}
