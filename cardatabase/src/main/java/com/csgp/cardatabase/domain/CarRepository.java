package com.csgp.cardatabase.domain;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.List;

@RepositoryRestResource
public interface CarRepository extends CrudRepository <Car, Long> {

    // obtener todos los autos de una marca determinada
    List<Car> findByBrand(@Param("brand") String brand);

     // obtener todos los autos de una marca determinada ordenados por el año del modelo en forma asc
     List<Car> findByBrandOrderByModelYearAsc(@Param("brand") String brand);

    // obtener todos los autos de un determinado color
    List<Car> findByColor(@Param("color") String color);

    // obtener todos los autos de un año determinado
    List<Car> findByModelYear(@Param("modelYear") int modelYear);

    // obtener todos los autos de una marca y color determinado
    List<Car> findByBrandAndColor(String brand, String color);

    // obtener todos los autods de una marca y modelo determinado
    List<Car> findByBrandAndModel(String brand, String model);

}
