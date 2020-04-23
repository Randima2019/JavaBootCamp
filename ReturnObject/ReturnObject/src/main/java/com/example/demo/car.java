package com.example.demo;

public class car {

    private String carId;
    private String carName;
    private String carcolor;
    public car(){
    }

    public car(String carId, String carName, String carcolor) {
        super();
        this.carId = carId;
        this.carName = carName;
        this.carcolor = carcolor;
    }

    public String getCarId() {
        return carId;
    }

    public void setCarId(String carId) {
        this.carId = carId;
    }

    public String getCarName() {
        return carName;
    }

    public void setCarName(String carName) {
        this.carName = carName;
    }

    public String getCarcolor() {
        return carcolor;
    }

    public void setCarcolor(String carcolor) {
        this.carcolor = carcolor;
    }
}
