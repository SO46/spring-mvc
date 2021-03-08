package web.config;

import web.model.Car;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Scope;

import java.util.ArrayList;
import java.util.List;


@Configuration
public class CarConfig {

    @Bean(name = "list")
    @Scope("singleton")
    public List<Car> listCars() {
        List<Car> cars = new ArrayList<>();

        cars.add(new Car(1,1,"01"));
        cars.add(new Car(2,2,"02"));
        cars.add(new Car(3,3,"03"));
        cars.add(new Car(3,4,"04"));
        cars.add(new Car(3,5,"05"));

        return cars;
    }
}
