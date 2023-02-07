package web.service;

import web.model.Car;


import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Service{
    public static List<Car> getCarList (List<Car> cars, Integer count) {
        if (count == null || count >= cars.size()) return cars;
        return cars.subList(0, count);
    }
}
