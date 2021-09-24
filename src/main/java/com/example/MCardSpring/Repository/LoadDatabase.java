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
            Applicant yasinB = new Applicant("Yasin", "Büzgülü",
                    "05/09/1997", 53452312702L, "Normal",
                    "Öğrenci");
            yasinB = applicantRepository.save(yasinB);

            Applicant fuatB = new Applicant("Fuat", "Başgil",
                    "01/12/1893", 14513286998L, "Yaşlı",
                    "Sivil");
            fuatB = applicantRepository.save(fuatB);

            City istanbul = new City();
            istanbul.setCityName("ISTANBUL");
            istanbul = cityRepository.save(istanbul);

            City adana = new City();
            adana.setCityName("ADANA");
            adana = cityRepository.save(adana);

            City ankara = new City();
            ankara.setCityName("ANKARA");
            ankara = cityRepository.save(ankara);

            City izmir = new City();
            izmir.setCityName("IZMIR");
            izmir = cityRepository.save(izmir);

            City bursa = new City();
            bursa.setCityName("BURSA");
            bursa = cityRepository.save(bursa);

            Opportunity parking = new Opportunity();
            parking.setName("PARKING");
            parking = opportunityRepository.save(parking);

            Opportunity library = new Opportunity();
            library.setName("LIBRARY");
            library = opportunityRepository.save(library);

            Opportunity museum = new Opportunity();
            museum.setName("MUSEUM");
            museum = opportunityRepository.save(museum);

            Opportunity theatre = new Opportunity();
            theatre.setName("THEATRE");
            theatre = opportunityRepository.save(theatre);

            CityOpportunity istanbulMuseum = new CityOpportunity(istanbul, museum, 250, 5);
            istanbulMuseum = cityOpportunityRepository.save(istanbulMuseum);
            CityOpportunity istanbulParking = new CityOpportunity(istanbul, parking, 50, 4);
            istanbulParking = cityOpportunityRepository.save(istanbulParking);
            CityOpportunity istanbulTheatre = new CityOpportunity(istanbul, theatre, 250, 5);
            istanbulTheatre = cityOpportunityRepository.save(istanbulTheatre);
            CityOpportunity istanbulLibrary = new CityOpportunity(istanbul, library, 250, 5);
            istanbulLibrary = cityOpportunityRepository.save(istanbulLibrary);

            CityOpportunity bursaTheatre = new CityOpportunity(bursa, theatre, 400, 3);
            bursaTheatre = cityOpportunityRepository.save(bursaTheatre);
            CityOpportunity bursaLibrary = new CityOpportunity(bursa, library, 400, 3);
            bursaLibrary = cityOpportunityRepository.save(bursaLibrary);
            CityOpportunity bursaMuseum = new CityOpportunity(bursa, museum, 400, 3);
            bursaMuseum = cityOpportunityRepository.save(bursaMuseum);

            CityOpportunity ankaraTheatre = new CityOpportunity(ankara, theatre, 400, 3);
            ankaraTheatre = cityOpportunityRepository.save(ankaraTheatre);
            CityOpportunity ankaraLibrary = new CityOpportunity(ankara, library, 400, 3);
            ankaraLibrary = cityOpportunityRepository.save(ankaraLibrary);
            CityOpportunity ankaraParking = new CityOpportunity(ankara, parking, 400, 3);
            ankaraParking = cityOpportunityRepository.save(ankaraParking);
            CityOpportunity ankaraMuseum = new CityOpportunity(ankara, museum, 400, 3);
            ankaraMuseum = cityOpportunityRepository.save(ankaraMuseum);

            CityOpportunity izmirMuseum = new CityOpportunity(izmir, museum, 400, 3);
            izmirMuseum = cityOpportunityRepository.save(izmirMuseum);
            CityOpportunity izmirTheatre = new CityOpportunity(izmir, theatre, 400, 3);
            izmirTheatre = cityOpportunityRepository.save(izmirTheatre);

            CityOpportunity adanaParking = new CityOpportunity(adana, parking, 400, 3);
            adanaParking = cityOpportunityRepository.save(adanaParking);
            CityOpportunity adanaMuseum = new CityOpportunity(adana, museum, 400, 3);
            adanaMuseum = cityOpportunityRepository.save(adanaMuseum);
            CityOpportunity adanaLibrary = new CityOpportunity(adana, library, 400, 3);
            adanaLibrary = cityOpportunityRepository.save(adanaLibrary);

            List<CityOpportunity> istanbulOpportunityList = new ArrayList<>();
            istanbulOpportunityList.add(istanbulMuseum);
            istanbulOpportunityList.add(istanbulParking);
            istanbulOpportunityList.add(istanbulTheatre);
            istanbulOpportunityList.add(istanbulLibrary);

            List<CityOpportunity> ankaraOpportunityList = new ArrayList<>();
            ankaraOpportunityList.add(ankaraTheatre);
            ankaraOpportunityList.add(ankaraLibrary);
            ankaraOpportunityList.add(ankaraParking);
            ankaraOpportunityList.add(ankaraMuseum);

            List<CityOpportunity> adanaOpportunityList = new ArrayList<>();
            adanaOpportunityList.add(adanaMuseum);
            adanaOpportunityList.add(adanaParking);
            adanaOpportunityList.add(adanaLibrary);

            List<CityOpportunity> bursaOpportunityList = new ArrayList<>();
            bursaOpportunityList.add(bursaTheatre);
            bursaOpportunityList.add(bursaLibrary);
            bursaOpportunityList.add(bursaMuseum);

            List<CityOpportunity> izmirOpportunityList = new ArrayList<>();
            izmirOpportunityList.add(izmirTheatre);
            izmirOpportunityList.add(izmirMuseum);


            Card testCard = new Card(250, "09/09/2023", yasinB,
                    bursaOpportunityList, 4);
            testCard = cardRepository.save(testCard);

            Card testCard2 = new Card(20, "09/12/2024", fuatB,
                    istanbulOpportunityList, 5);
            cardRepository.save(testCard2);

        };

    }

}
