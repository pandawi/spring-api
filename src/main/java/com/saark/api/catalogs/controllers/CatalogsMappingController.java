package com.saark.api.catalogs.controllers;

import com.saark.api.catalogs.models.CatalogMappingRequest;
import com.saark.api.catalogs.services.CatalogsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@EnableAutoConfiguration
@RequestMapping("/catalogmapping")
public class CatalogsMappingController {

    @Autowired
    private CatalogsService catalogsService;

    @GetMapping(value = "/getcatalogmapping/json/{catalogId}/{siteId}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<CatalogMappingRequest> getCatalogMapping(@PathVariable(name = "catalogId") Long catalogId,
            @PathVariable(name = "siteId") Integer siteId) {

        CatalogMappingRequest catalogMappingRequest = this.catalogsService.getCatalogMapping(catalogId, siteId);
        return new ResponseEntity<CatalogMappingRequest>(catalogMappingRequest, HttpStatus.OK);
    }

}