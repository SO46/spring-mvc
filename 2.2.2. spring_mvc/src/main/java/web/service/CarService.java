package web.service;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.stereotype.Service;
import web.config.CarConfig;
import web.model.Car;

import java.util.List;

@Service
public class CarService {

    @SuppressWarnings("unchecked")
    public List<Car> getCar(Integer num){
        ApplicationContext applicationContext =
                new AnnotationConfigApplicationContext(CarConfig.class);
        return ((List<Car>) applicationContext.getBean("list")).subList(0, num);
    }

}
