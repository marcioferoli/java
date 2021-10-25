package com.feroliapps.models;

import java.util.Objects;

public class CarModel extends CarAbstract {

    private String name;
    private Enum model;

    public CarModel(String name, Enum model) {
        this.name = name;
        this.model = model;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Enum getModel() {
        return model;
    }

    public void setModel(Enum model) {
        this.model = model;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CarModel carModel = (CarModel) o;
        return Objects.equals(name, carModel.name) && Objects.equals(model, carModel.model);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, model);
    }

    @Override
    public String toString() {
        return "CarModel{" +
                "name='" + name + '\'' +
                ", model=" + model +
                '}';
    }

}
