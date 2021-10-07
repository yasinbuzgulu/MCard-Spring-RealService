//package com.example.MCardSpring;
//
//import com.example.MCardSpring.Controller.ApplicantController;
//import com.example.MCardSpring.MainModel.Applicant;
//import com.example.MCardSpring.Repository.ApplicantRepository;
//import com.example.MCardSpring.Service.ApplicantService;
//import com.fasterxml.jackson.databind.ObjectMapper;
//import org.junit.Test;
//import org.junit.runner.RunWith;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
//import org.springframework.boot.test.mock.mockito.MockBean;
//import org.springframework.http.MediaType;
//import org.springframework.test.context.junit4.SpringRunner;
//import org.springframework.test.web.servlet.MockMvc;
//import org.springframework.test.web.servlet.ResultMatcher;
//import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
//import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
//
//@RunWith(SpringRunner.class)
//@WebMvcTest(ApplicantController.class)
//public class TestApplicantController {
//
//    public ResultMatcher ok = MockMvcResultMatchers.status().isOk();
//    public ResultMatcher created = MockMvcResultMatchers.status().isCreated();
//    public ResultMatcher accepted = MockMvcResultMatchers.status().isAccepted();
//    @Autowired
//    private MockMvc mvc;
//    @MockBean
//    private ApplicantService applicantService;
//    @MockBean
//    private ApplicantRepository applicantRepository;
//
//    public static String asJsonString(final Object obj) {
//        try {
//            return new ObjectMapper().writeValueAsString(obj);
//        } catch (Exception e) {
//            throw new RuntimeException(e);
//        }
//    }
//
//    @Test
//    public void getAllApplicantsAPI() throws Exception {
//
//        mvc.perform(MockMvcRequestBuilders
//                        .get("http://localhost:8080/applicants")
//                        .accept(MediaType.APPLICATION_JSON))
//                .andExpect(ok);
//    }
//
//    @Test
//    public void getApplicantByIdAPI() throws Exception {
//        mvc.perform(MockMvcRequestBuilders
//                        .get("http://localhost:8080/applicants/{id}", 1)
//                        .accept(MediaType.APPLICATION_JSON))
//                .andExpect(ok)
//                .andExpect(MockMvcResultMatchers.jsonPath("$.id").value(1));
//    }
//
//    @Test
//    public void createApplicantAPI() throws Exception {
//        mvc.perform(MockMvcRequestBuilders
//                        .post("http://localhost:8080/applicants")
//                        .content(asJsonString(new Applicant("Fuat", "Ulak", "05/12/1993", 14513286998L,
//                                "Normal", "Sivil")))
//                        .contentType(MediaType.APPLICATION_JSON)
//                        .accept(MediaType.APPLICATION_JSON))
//                .andExpect(created);
//    }
//
//    @Test
//    public void updateApplicantAPI() throws Exception {
//        mvc.perform(MockMvcRequestBuilders
//                        .put("http://localhost:8080/applicants/{id}", 2)
//                        .content(asJsonString(new Applicant("Kemal", "Ulak", "05/12/1993", 14513286998L,
//                                "Normal", "Sivil")))
//                        .contentType(MediaType.APPLICATION_JSON)
//                        .accept(MediaType.APPLICATION_JSON))
//                .andExpect(ok)
//                .andExpect(MockMvcResultMatchers.jsonPath("$.name").value("Kemal"))
//                .andExpect(MockMvcResultMatchers.jsonPath("$.surname").value("Ulak"))
//                .andExpect(MockMvcResultMatchers.jsonPath("$.birthDate").value("05/12/1993"))
//                .andExpect(MockMvcResultMatchers.jsonPath("$.citizenNumber").value(14513286998L))
//                .andExpect(MockMvcResultMatchers.jsonPath("$.typeBasedOnAge").value("Normal"))
//                .andExpect(MockMvcResultMatchers.jsonPath("$.typeBasedOnEducation").value("Sivil"));
//    }
//
//    @Test
//    public void deletePreschoolAPI() throws Exception {
//        mvc.perform(MockMvcRequestBuilders.delete("http://localhost:8080/applicants/{id}", 1))
//                .andExpect(accepted);
//    }
//
//}
