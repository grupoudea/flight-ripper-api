package com.ritallus.flightripper.repositories;

import com.ritallus.flightripper.entities.Passenger;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PassengerRepository extends JpaRepository<Passenger, Integer> {


    /* A continuación escribo diferentes metodos que equivalen a la siguiente consulta en base de datos
    Consulta que obtenga todos los pasageros cuyo full_name empiece con:
    select * from passenger p WHERE p.full_name LIKE 'STRING%'
    *
    */
    List<Passenger> findByFullNameStartingWith(String name); //forma llamada Method Query Name

    @Query("SELECT p FROM Passenger p WHERE p.fullName LIKE CONCAT(:name, '%')")
    List<Passenger> findByFullNameStartingWithVersion2(@Param("name") String name); //forma llamada JPQL

    @Query(value = "SELECT * FROM passenger WHERE full_name LIKE ?1%", nativeQuery = true)
    List<Passenger> findByFullNameStartingWithVersion3(String name);

    //existe otras formas de hacerlo, por ejemplo con Query Specification o con  consultas personalizadas
    // las tres anteriores son muy comunes y permiten resolver la mayoría de consultas








}
