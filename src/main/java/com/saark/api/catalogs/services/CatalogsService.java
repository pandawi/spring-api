package com.saark.api.catalogs.services;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.saark.api.catalogs.domain.Catalog;
import com.saark.api.catalogs.models.CatalogMappingRequest;
import com.saark.api.catalogs.models.ResponseStatus;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;

@Service
public class CatalogsService {

    public CatalogMappingRequest getMockResponse() {
        CatalogMappingRequest mockResponse = new CatalogMappingRequest();

        try {
            Path path = Paths.get(System.getProperty("user.dir"), "resources/response-json.txt");
            byte[] jsonData = Files.readAllBytes(path);
            ObjectMapper objectMapper = new ObjectMapper();
            mockResponse = objectMapper.readValue(jsonData, CatalogMappingRequest.class);
            return mockResponse;

        } catch (IOException e) {
            String[] errors = { e.getMessage() };
            mockResponse.setErrors(errors);
            mockResponse.setResponseStatus(ResponseStatus.FAILURE);
            return mockResponse;
        }
    }

    /**
     * In case we were going to the server...
     * Couldn't test it so I'm not sure it works
     */
    // private static final CatalogMappingRequest getMappingResponse(Long catalogId, Integer siteId) {
    //     RestTemplate restTemplate = new RestTemplate();
    //     CatalogMappingRequest catalogMappingRequest = restTemplate.getForObject("http://10.64.203.119/catalogmapping/getcatalogmapping/json/" + catalogId + "/" + siteId, CatalogMappingRequest.class);
    //     return catalogMappingRequest;
    // }

    public CatalogMappingRequest getCatalogMapping(Long catalogId, Integer siteId) {
        CatalogMappingRequest catalogMappingRequest = this.getMockResponse();

        if (catalogMappingRequest.getResponseStatus() == ResponseStatus.FAILURE) {
            return catalogMappingRequest;
        }

        ArrayList<Catalog> catalogs = catalogMappingRequest.getMappingList();
        if (catalogId > -1) {
            catalogs.removeIf(c -> c.getCatalogId() != catalogId);
        }
        if (siteId > -1) {
            catalogs.removeIf(c -> c.getSiteID() != siteId);
        }
        catalogMappingRequest.setMappingList(catalogs);
        return catalogMappingRequest;
    }

}
