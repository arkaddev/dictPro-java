package com.example.CarRentalRestApi.repository;

import com.example.CarRentalRestApi.model.Car;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CarsRepository extends JpaRepository<Car, Long> {
    List<Car> findByBrand(String brand);
}
