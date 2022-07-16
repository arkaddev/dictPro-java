package com.example.CarRentalRestApi.controller;


import com.example.CarRentalRestApi.model.Car;
import com.example.CarRentalRestApi.model.Order;
import com.example.CarRentalRestApi.repository.CarsRepository;
import com.example.CarRentalRestApi.repository.OrdersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api")
public class CarRentalController {

    @Autowired
    CarsRepository carsRepository;
    @Autowired
    OrdersRepository ordersRepository;

    @GetMapping("/cars")
    public List<Car> showCars() {
        List<Car> listCars = carsRepository.findAll();
        return listCars;
    }

    @GetMapping("/cars/{id}")
    public Optional<Car> showCar(@PathVariable long id) {
        return carsRepository.findById(id);
    }

    @GetMapping("/car")
    public List<Car> showCarsByName(String name) {
        return carsRepository.findByBrand(name);
    }

    @PostMapping("/cars")
    public Car addCar(@RequestBody Car car) {
        carsRepository.save(car);
        return car;
    }

    @PutMapping("/cars/{id}")
    public Car editCar(@PathVariable long id, @RequestBody Car car) {
        Car newcar = carsRepository.findById(id)
                .orElseThrow();

        newcar.setBrand(car.getBrand());
        newcar.setModel(car.getModel());
        newcar.setColor(car.getColor());
        newcar.setNumberOfSeats(car.getNumberOfSeats());
        newcar.setYear(car.getYear());
        newcar.setCostPerDay(car.getCostPerDay());

        carsRepository.save(newcar);
        return newcar;
    }


    @DeleteMapping("/cars/{id}")
    public void deleteCar(@PathVariable long id) {
        carsRepository.deleteById(id);
    }


    @GetMapping("/orders")
    public List<Order> showOrders() {
        return ordersRepository.findAll();
    }

    @GetMapping("/orders/{id}")
    public Optional<Order> showOrdersById(@PathVariable long id) {
        return ordersRepository.findById(id);
    }

}