package com.saark.api.catalogs.models;

import com.saark.api.catalogs.domain.Catalog;

import java.util.ArrayList;

public class CatalogMappingRequest {

    public String getInvocationId() {
        return invocationId;
    }

    public void setInvocationId(String invocationId) {
        this.invocationId = invocationId;
    }

    public ResponseStatus getResponseStatus() {
        return responseStatus;
    }

    public void setResponseStatus(ResponseStatus responseStatus) {
        this.responseStatus = responseStatus;
    }

    public String[] getErrors() {
        return errors;
    }

    public void setErrors(String[] errors) {
        this.errors = errors;
    }

    public ArrayList<Catalog> getMappingList() {
        return mappingList;
    }

    public void setMappingList(ArrayList<Catalog> mappingList) {
        this.mappingList = mappingList;
    }

    private String invocationId;
    private ResponseStatus responseStatus;
    private String[] errors;
    private ArrayList<Catalog> mappingList;
}
