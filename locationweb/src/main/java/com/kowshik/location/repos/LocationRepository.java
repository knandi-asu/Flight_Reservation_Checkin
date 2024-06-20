package com.kowshik.location.repos;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

import com.kowshik.location.entities.Location;

public interface LocationRepository extends JpaRepository<Location, Integer> {

}
