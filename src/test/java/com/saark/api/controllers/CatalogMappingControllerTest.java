package com.saark.api.controllers;

import org.hamcrest.Matchers;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import java.util.ArrayList;

import com.saark.api.catalogs.controllers.CatalogsMappingController;
import com.saark.api.catalogs.domain.Catalog;
import com.saark.api.catalogs.models.CatalogMappingRequest;
import com.saark.api.catalogs.services.CatalogsService;


@RunWith(SpringRunner.class)
@WebMvcTest(CatalogsMappingController.class)
public class CatalogMappingControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private CatalogsService catalogService;

    @Test
    public void getCatalogMapping() throws Exception {
        Catalog mockCatalog = new Catalog();
        mockCatalog.setCatalogId((long) 1);
        ArrayList<Catalog> mockList = new ArrayList<>(1);
        mockList.add(mockCatalog);
        CatalogMappingRequest mockRequest = new CatalogMappingRequest();
        mockRequest.setMappingList(mockList);
        Mockito.when(catalogService.getCatalogMapping((long) 47, 0)).thenReturn(mockRequest);
        mockMvc.perform(get("/catalogmapping/getcatalogmapping/json/47/0")
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.mappingList[0].catalogId", Matchers.is(1)));
    }
}