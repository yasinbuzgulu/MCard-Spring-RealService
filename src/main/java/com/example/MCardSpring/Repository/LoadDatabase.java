package com.example.MCardSpring.Repository;

import com.example.MCardSpring.MainModel.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.ArrayList;
import java.util.List;

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
            Applicant testApplicant = new Applicant("Yasin", "Büzgülü",
                    "05/09/1997", 53452312702L, "Normal",
                    "Öğrenci", 1L);
            applicantRepository.save(testApplicant);
            log.info("Preloading Applicant 1 " + applicantRepository.findById(1L).get());

            Applicant testApplicant2 = new Applicant("Fuat", "Başgil",
                    "01/12/1893", 14513286998L, "Yaşlı",
                    "Sivil", 2L);
            applicantRepository.save(testApplicant2);
            log.info("Preloading Applicant 2 " + applicantRepository.findById(2L).get());

            City testCity = new City(3L, "İstanbul");
            cityRepository.save(testCity);
            log.info("Preloading City 1" + cityRepository.findById(3L).get());

            City testCity2 = new City(4L, "Adana");
            cityRepository.save(testCity2);
            log.info("Preloading City 2" + cityRepository.findById(4L).get());

            Opportunity testOpportunity = new Opportunity(5L, "Otopark", 200, 5);
            var result = opportunityRepository.save(testOpportunity);
            log.info("Preloading Opportunity 1 " + testOpportunity);

            Opportunity testOpportunity2 = new Opportunity(6L, "Havuz", 120, 3);
            var result2 = opportunityRepository.save(testOpportunity2);
            log.info("Preloading Opportunity 2 " + testOpportunity2);

            Opportunity testOpportunity3 = new Opportunity(7L, "Parasailing", 500, 1);
            var result3 = opportunityRepository.save(testOpportunity3);
            log.info("Preloading Opportunity 3 " + testOpportunity3);

            List<Opportunity> opportunityList = new ArrayList<>();
            opportunityList.add(testOpportunity);

            List<Opportunity> opportunityList2 = new ArrayList<>();
            opportunityList2.add(testOpportunity);
            opportunityList2.add(testOpportunity2);
            opportunityList2.add(testOpportunity3);

            CityOpportunity testCityOpportunity = new CityOpportunity(3L, cityRepository.findById(4L).get(),
                    opportunityList);
            var result4 = cityOpportunityRepository.save(testCityOpportunity);
            log.info("Preloading-- CityOpportunity" + testCityOpportunity);

            CityOpportunity testCityOpportunity2 = new CityOpportunity(4L, cityRepository.findById(3L).get(),
                    opportunityList2);
            var result5 = cityOpportunityRepository.save(testCityOpportunity2);
            log.info("Preloading-- CityOpportunity 2" + testCityOpportunity2);
           // var a =(cityOpportunityRepository.findAll());

            CityOpportunity testOPP = cityOpportunityRepository.findById(3L).get();
            CityOpportunity testOPP2 = cityOpportunityRepository.findById(4L).get();

            Card testCard = new Card(5L, 250, "09/12/2024", applicantRepository.findById(1L).get(),
                    testOPP, 5);
            var result6 = cardRepository.save(testCard);
            log.info("Preloading Card 1" + testCard);

            Card testCard2 = new Card(6L, 20, "09/12/2024", applicantRepository.findById(2L).get(),
                    testOPP2, 5);
            var result7 = cardRepository.save(testCard2);
            log.info("Preloading Card 2" + testCard2);


        };

    }

}
