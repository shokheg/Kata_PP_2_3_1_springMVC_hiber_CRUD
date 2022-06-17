package web.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import web.dao.CarDAO;
import web.model.Car;

import java.util.ArrayList;
import java.util.List;

/**
 * @author shokhalevich
 */
@Service
public class CarService {

    @Autowired
    private CarDAO carDAO;

    public List<Car> getSomeCars(int count) {
        if (count < -1) { //если отрицательное кол-во авто, выбрасываем исключение
            throw new IllegalArgumentException();
        } else if (count == -1) {  // если дефолтное /cars  то выводим все авто
            return carDAO.getAllCars().subList(0, carDAO.getAllCars().size());
        } else {  // во всех остальных случаях либо count либо все
            return carDAO.getAllCars().subList(0, Math.min(count, carDAO.getAllCars().size()));
        }
    }


}
