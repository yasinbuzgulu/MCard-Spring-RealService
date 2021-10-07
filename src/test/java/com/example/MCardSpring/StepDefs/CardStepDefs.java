package com.example.MCardSpring.StepDefs;

import com.example.MCardSpring.MainModel.*;
import com.example.MCardSpring.Repository.CityRepository;
import com.example.MCardSpring.Service.*;
import com.example.MCardSpring.TestConfiguration;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@SpringBootTest
//@CucumberContextConfiguration
@AutoConfigureMockMvc
@ContextConfiguration(classes = TestConfiguration.class)
public class CardStepDefs {
    @Autowired
    CityService cityService;
    @Autowired
    CityRepository cityRepository;
    @Autowired
    CardService cardService;
    @Autowired
    ApplicantService applicantService;
    @Autowired
    OpportunityService opportunityService;
    @Autowired
    CityOpportunityService cityOpportunityService;
    ResultActions action;
    Map<String, Object> contex = new HashMap<>();
    @Autowired
    private MockMvc mvc;
    private String reqBody = null;

    public static String asJsonString(final Object obj) {
        try {
            return new ObjectMapper().writeValueAsString(obj);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    ////////////////////////////////////////////////////////////////////////////////////////////
    // 1.  Senaryo
    @Given("{string} kartı var iken")
    public void kartiVarIken(String key) throws ParseException {
        Applicant yasinB = new Applicant("Yasin", "Buzgulu",
                "05/09/1997", 53452312702L, "Normal",
                "Ogrenci");
        applicantService.createApplicant(yasinB);

        City izmir = new City("IZMIR");
        cityService.createCity(izmir);

        Opportunity museum = new Opportunity("MUSEUM");
        Opportunity theatre = new Opportunity("THEATRE");
        opportunityService.createOpportunity(museum);
        opportunityService.createOpportunity(theatre);

        CityOpportunity izmirMuseum = new CityOpportunity(izmir, museum, 400);
        CityOpportunity izmirTheatre = new CityOpportunity(izmir, theatre, 400);
        cityOpportunityService.createCityOpportunity(izmirMuseum);
        cityOpportunityService.createCityOpportunity(izmirTheatre);

        List<CityOpportunity> izmirOpportunityList = new ArrayList<>();
        izmirOpportunityList.add(izmirTheatre);
        izmirOpportunityList.add(izmirMuseum);

        Card yasbuCard = new Card(250, "09/10/2025", yasinB,
                izmirOpportunityList, 4);

        Card card = cardService.createCard(yasbuCard);
        this.contex.put(key, card);
    }

    @When("{string} kartı post edildiğinde")
    public void kartiPostEdildiginde(String key) throws Throwable {
        Card card = (Card) contex.get(key);
        action = mvc.perform(MockMvcRequestBuilders
                .post("http://localhost:8080/cards")
                .content(asJsonString(card))
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON));
    }

    @Then("Kart başarıyla kaydedilir")
    public void kartBasariylaKaydedilir() throws Throwable {
        action.andExpect(status().is(201));
    }

    ////////////////////////////////////////////////////////////////////////////////////////////
    // 2.  Senaryo
    @When("Tüm kartlar için Get request'i atıldığında")
    public void tumKartlarIcinGetRequestIAtildiginda() throws Throwable {
        action = mvc.perform(MockMvcRequestBuilders
                .get("http://localhost:8080/cards")
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON));
    }

    @Then("Tüm kartlar başarıyla listelenir")
    public void tumKartlarBasariylaListelenir() throws Throwable {
        action.andExpect(status().is(200));

    }

    ////////////////////////////////////////////////////////////////////////////////////////////
    // 3.  Senaryo
    @When("{string} kartına silme isteği atıldığında")
    public void kartinaSilmeIstegiAtildiginda(String key) throws Throwable {
        Card card = (Card) contex.get(key);
        long id = card.getId();
        action = mvc.perform(MockMvcRequestBuilders
                .delete("http://localhost:8080/cards/" + id)
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON));
    }

    @Then("Kart başarıyla silinir.")
    public void kartBasariylaSilinir() throws Throwable {
        action.andExpect(status().is(204));

    }

    ////////////////////////////////////////////////////////////////////////////////////////////
    // 4.  Senaryo
    @When("{string} kartında güncellemeler yapıldığında")
    public void kartindaGuncellemelerYapildiginda(String key) throws Throwable {
        Card card = (Card) contex.get(key);
        long id = card.getId();
        card.setPrice(177);
        card.setCardOpportunityYear(1);
        action = mvc.perform(MockMvcRequestBuilders
                .put("http://localhost:8080/cards/" + id)
                .content(asJsonString(card))
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON));
    }

    @Then("Kart başarı ile güncellenir")
    public void kartBasariIleGuncellenir() throws Throwable {
        action.andExpect(status().is(200));
    }

    @When("{string} kartının başvuran'ı boş post edildiğinde")
    public void kartininBasvuranIBosPostEdildiginde(String key) throws Throwable {
        Card card = (Card) contex.get(key);
        card.setApplicant(null);
        action = mvc.perform(MockMvcRequestBuilders
                .post("http://localhost:8080/cards")
                .content(asJsonString(card))
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON));
    }

    @When("{string} kartının şehir-olanak'ı boş post edildiğinde")
    public void kartininSehirOlanakIBosPostEdildiginde(String key) throws Throwable{
        Card card = (Card) contex.get(key);
        card.setCityOpportunity(null);
        action = mvc.perform(MockMvcRequestBuilders
                .post("http://localhost:8080/cards")
                .content(asJsonString(card))
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON));
    }

    @When("{string} kartının son kullanma tarihi boş post edildiğinde")
    public void kartininSonKullanmaTarihiBosPostEdildiginde(String key) throws Throwable{
        Card card = (Card) contex.get(key);
        card.setExpiryDate(null);
        action = mvc.perform(MockMvcRequestBuilders
                .post("http://localhost:8080/cards")
                .content(asJsonString(card))
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON));
    }

    @When("{string} kartının fiyatı boş post edildiğinde")
    public void kartininFiyatiBosPostEdildiginde(String key) throws Throwable{
        Card card = (Card) contex.get(key);
        card.setPrice(null);
        action = mvc.perform(MockMvcRequestBuilders
                .post("http://localhost:8080/cards")
                .content(asJsonString(card))
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON));
    }

    @When("{string} kartının olanak tanımlanma yılı boş post edildiğinde")
    public void kartininOlanakTanimlanmaYiliBosPostEdildiginde(String key) throws Throwable{
        Card card = (Card) contex.get(key);
        card.setCardOpportunityYear(null);
        action = mvc.perform(MockMvcRequestBuilders
                .post("http://localhost:8080/cards")
                .content(asJsonString(card))
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON));
    }

    @Then("Kart postu hata verir")
    public void kartPostuHataVerir() throws Throwable {
        action.andExpect(status().is(400));

    }
}
