package com.example.MCardSpring.Repository;

import com.example.MCardSpring.MainModel.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Default bilgiilerin @Config ve @Bean ile yüklendiği sınıf
 */
@Configuration
public class LoadDatabase {

    private static final Logger log = LoggerFactory.getLogger(LoadDatabase.class);

    @Bean
    CommandLineRunner initDatabase(ApplicantRepository applicantRepository, CityRepository cityRepository,
                                   OpportunityRepository opportunityRepository,
                                   CityOpportunityRepository cityOpportunityRepository,
                                   CardRepository cardRepository) {
        return args -> {

            log.info("Preloading " + applicantRepository.save(new Applicant("Yasin", "Büzgülü",
                    "05/09/1997", 53452312702L, "Normal",
                    "Öğrenci", 1L)));

            log.info("Preloading " + applicantRepository.save(new Applicant("Fuat", "Başgil",
                    "01/12/1893", 14513286998L, "Yaşlı",
                    "Sivil", 2L)));

            log.info("Preloading " + cityRepository.save((new City(1L, "İstanbul"))));

            log.info(("Preloading " + opportunityRepository.save(new Opportunity(1L, "Otopark",
                    200, 5))));

            log.info("Preloading" + cityOpportunityRepository.save(new CityOpportunity(1L
                            ,cityRepository.findCityById(1L)),
                    opportunityRepository.findOpportunityById(1L)));

            log.info("Preloading" + cardRepository.save(new Card(1L , applicantRepository.findById(1L),
                    cityOpportunityRepository.findById(1L))));
        };
    }


}
