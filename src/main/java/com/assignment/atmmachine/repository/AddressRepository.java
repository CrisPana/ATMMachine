package com.assignment.atmmachine.repository;

import com.assignment.atmmachine.model.Address;
import org.springframework.data.jpa.repository.JpaRepository;

/*
 * Class to allows us to communicate with database regarding address entity
 * */
public interface AddressRepository extends JpaRepository<Address, Integer> {

}
