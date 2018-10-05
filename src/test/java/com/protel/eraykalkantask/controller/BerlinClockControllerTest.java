package com.protel.eraykalkantask.controller;

import com.protel.eraykalkantask.service.BerlinClockService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.bind.MissingServletRequestParameterException;

import static org.hamcrest.Matchers.containsString;
import static org.mockito.ArgumentMatchers.any;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@RunWith(MockitoJUnitRunner.class)
public class BerlinClockControllerTest {
    private MockMvc mockMvc;

    @InjectMocks
    private BerlinClockController berlinClockController;

    @Mock
    private BerlinClockService berlinClockService;

    @Before
    public void setup() {
        MockitoAnnotations.initMocks(this);
        mockMvc= MockMvcBuilders.standaloneSetup(berlinClockController).build();

    }

    @Test
    public void getBerlinClock_ShouldReturnEmptyStringOnNull() throws Exception {

        //when(berlinClockService.convertToBerlinClock("")).thenReturn(null);

        this.mockMvc.perform(get("/berlinClock")
                .param("time","")
                .contentType(MediaType.APPLICATION_JSON_UTF8))
                .andExpect(status().isOk())
                .andExpect(content().string(containsString("")));
    }

    @Test
    public void getBerlinClock_ShouldReturnHttp400WhenParameterNotPresent() throws Exception {

        this.mockMvc.perform(get("/berlinClock")
                .contentType(MediaType.APPLICATION_JSON_UTF8))
                .andExpect(status().is4xxClientError())
                .andExpect(content().string(containsString("")));
    }
    
}