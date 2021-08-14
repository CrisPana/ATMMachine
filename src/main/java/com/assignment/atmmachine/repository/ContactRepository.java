package com.assignment.atmmachine.repository;

import com.assignment.atmmachine.model.Contact;
import org.springframework.data.jpa.repository.JpaRepository;

/*
 * Class to allows us to communicate with database regarding contact entity
 * */
public interface ContactRepository extends JpaRepository<Contact, Integer> {
}
