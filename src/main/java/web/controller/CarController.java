package web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import web.dao.CarDAO;
import web.model.Car;
import web.service.CarService;

import java.util.ArrayList;
import java.util.List;

/**
 * @author shokhalevich
 */

@Controller
public class CarController {

    @Autowired
    private CarService carService;

// При запросе /cars выводить весь список. При запросе /cars?count=2 должен отобразиться список из 2 машин,
//при /cars?count=3 - из 3, и тд. При count ≥ 5 выводить весь список машин.
    @GetMapping(value = "/cars") //todo прием параметра (кол во машин) и передача его в сервис слой в метод getSomeCars
    public String printCars(@RequestParam(name="count", defaultValue = "-1")Integer count, ModelMap model) {
        List<Car> cars = carService.getSomeCars(count);
        model.addAttribute("carzzz", cars);
        return "cars";
    }
}
