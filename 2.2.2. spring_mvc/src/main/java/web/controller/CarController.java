package web.controller;

import web.config.CarConfig;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import web.service.CarService;

@Controller
public class CarController {
    @GetMapping(value = "/cars")
    public String printCars(@RequestParam(value = "num", required = false) String string,
                            ModelMap model) {
        ApplicationContext applicationContext =
                new AnnotationConfigApplicationContext(CarConfig.class);
        int num;
        try {
            num = Integer.parseInt(string);
            if(num >= 5){
                num = 5;
            }
        } catch (NumberFormatException e){
            num = 5;
        }
        model.addAttribute("car_list", applicationContext.getBean(CarService.class).getCar(num));
        return "cars";
    }
}
