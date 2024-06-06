package com.csgp.cardatabase.domain;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.List;


public interface CarRepository extends CrudRepository <Car, Long> {

    // obtener todos los autos de una marca determinada
    List<Car> findByBrand(String brand);

     // obtener todos los autos de una marca determinada ordenados por el año del modelo en forma asc
     List<Car> findByBrandOrderByModelYearAsc(String brand);

    // obtener todos los autos de un determinado color
    List<Car> findByColor(String color);

    // obtener todos los autos de un año determinado
    List<Car> findByModelYear(int modelYear);

    // obtener todos los autos de una marca y color determinado
    List<Car> findByBrandAndColor(String brand, String color);

    // obtener todos los autods de una marca y modelo determinado
    List<Car> findByBrandAndModel(String brand, String model);

}
