package com.assignment.atmmachine.model;

import com.assignment.atmmachine.repository.AccountRepository;
import com.assignment.atmmachine.repository.AddressRepository;
import com.assignment.atmmachine.repository.ContactRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Date;

@Configuration
public class LoadDatabase {

    private static final Logger LOGGER = LoggerFactory.getLogger(LoadDatabase.class);

    @Bean
    CommandLineRunner initDatabase(AddressRepository addrRep, ContactRepository contactRep, AccountRepository accRep) {
        LOGGER.info("Initializing sample data.");
        return args -> {
            Address addr1 = new Address("53 Strand Rd", "" ,"Bray", "Wicklow", "Ireland", "A98VW99");
            Address addr2 = new Address("47 Meath Rd", "", "Bray", "Wicklow", "Ireland", "A98F433");

            AccountHolder accholder1 = new AccountHolder("Bart", "Simpson", "0853406062", new Date(1995, 4, 3), addr1);
            AccountHolder accholder2 = new AccountHolder("Lisa", "Simpson", "0853406072", new Date(1997, 1, 19), addr2);

            Account account1 = new Account("123456789", accholder1, 1234, 800, 200);
            Account account2 = new Account("987654321", accholder2, 4321, 1230, 150);

            LOGGER.info("Preloading " + addrRep.save(addr1));
            LOGGER.info("Preloading " + addrRep.save(addr2));
            LOGGER.info("Preloading " + contactRep.save(accholder1));
            LOGGER.info("Preloading " + contactRep.save(accholder2));
            LOGGER.info("Preloading " + accRep.save(account1));
            LOGGER.info("Preloading " + accRep.save(account2));
        };
    }
}
