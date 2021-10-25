package com.feroliapps;

import com.feroliapps.enums.ModelEnum;
import com.feroliapps.models.CarModel;

import java.util.ArrayList;
import java.util.List;

import static java.lang.System.out;

public class Main {

    public static void main(String[] args) {

        out.println("Testing ...");

        Integer[] integers = {1, 2, 3};

        List<CarModel> cars = new ArrayList();
        CarModel car1 = new CarModel("XPTO1", ModelEnum.FIESTA);
        CarModel car2 = new CarModel("XPTO2", ModelEnum.KA);
        cars.add(car1);
        cars.add(car2);

        cars.stream().forEach(car -> {
            out.println(car.toString());
            car.open();
        });



    }

}
