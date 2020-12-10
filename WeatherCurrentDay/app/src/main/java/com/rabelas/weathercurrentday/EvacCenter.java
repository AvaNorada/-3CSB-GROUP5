package com.rabelas.weathercurrentday;

public class EvacCenter {
    String name, city; //menu, guidelines, equake, typhoon, veruption;

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

   /* public String getMenu() {
        return menu;
    }

    public void setMenu(String menu) {
        this.menu = menu;
    }

    public String getGuidelines() {
        return guidelines;
    }

    public void setGuidelines(String guidelines) {
        this.guidelines = guidelines;
    }

    public String getEquake() {
        return equake;
    }

    public void setEquake(String equake) {
        this.equake = equake;
    }

    public String getTyphoon() {
        return typhoon;
    }

    public void setTyphoon(String typhoon) {
        this.typhoon = typhoon;
    }

    public String getVeruption() {
        return veruption;
    }

    public void setVeruption(String veruption) {
        this.veruption = veruption;
    }*/

    EvacCenter(String name, String city){ //String menu, String guidelines, String equake, String typhoon, String veruption){
        this.name=name;
        this.city=city;
        /*this.menu=menu;
        this.guidelines=guidelines;
        this.equake=equake;
        this.typhoon=typhoon;
        this.veruption=veruption;*/
    }
}
