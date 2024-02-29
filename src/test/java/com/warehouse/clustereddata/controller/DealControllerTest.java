package com.warehouse.clustereddata.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.warehouse.clustereddata.constants.DealsConstants;
import com.warehouse.clustereddata.dto.DealDto;
import com.warehouse.clustereddata.service.IDealService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.time.LocalDateTime;

@WebMvcTest(DealsController.class)
public class DealControllerTest{
    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;
    @MockBean
    private IDealService iDealService;

    @InjectMocks
    private DealsController dealsController;

    @Test
    public void testCreateDeal() throws Exception {
        Mockito.doNothing()
                .when(iDealService).saveValidDeals(Mockito.any(DealDto.class));

        DealDto dealDto = new DealDto("ewqe321","SAR","JOD", 30.43,LocalDateTime.now());
        mockMvc.perform(MockMvcRequestBuilders.post("/api/deal/create")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(dealDto)))
                .andExpect(MockMvcResultMatchers.status().isCreated())
                .andExpect(MockMvcResultMatchers.jsonPath("$.statusCode").value(DealsConstants.STATUS_201))
                .andExpect(MockMvcResultMatchers.jsonPath("$.statusMsg").value(DealsConstants.MESSAGE_201));

    }
}
