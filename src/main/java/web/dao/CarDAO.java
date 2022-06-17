package web.dao;

import org.springframework.stereotype.Component;
import web.model.Car;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author shokhalevich
 */

@Component
public class CarDAO {

    private List<Car> carsList = new ArrayList<>();

    {
        Car car1 = new Car("VAZ", "white", 101);
        Car car2 = new Car("BELAZ", "yellow", 1000);
        Car car3 = new Car("DAEWOO", "matiz", 55);
        Car car4 = new Car("VW", "silver", 150);
        Car car5 = new Car("PORSCHE", "orenge", 559);

        carsList.add(car1);
        carsList.add(car2);
        carsList.add(car3);
        carsList.add(car4);
        carsList.add(car5);
    }

    public List<Car> getAllCars(){
        return carsList;
    }



}
