package com.saark.api.catalogs.domain;

public class Catalog {


    public Integer getSiteID() {
        return siteID;
    }

    public void setSiteID(Integer siteID) {
        this.siteID = siteID;
    }

    public Long getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(Long categoryId) {
        this.categoryId = categoryId;
    }

    public Long getCatalogId() {
        return catalogId;
    }

    public void setCatalogId(Long catalogId) {
        this.catalogId = catalogId;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    public String getCatalogName() {
        return catalogName;
    }

    public void setCatalogName(String catalogName) {
        this.catalogName = catalogName;
    }

    public Boolean getIsCatalogEnabled() {
        return isCatalogEnabled;
    }

    public void setIsCatalogEnabled(Boolean catalogEnabled) {
        isCatalogEnabled = catalogEnabled;
    }

    public Long getVcsId() {
        return vcsId;
    }

    public void setVcsId(Long vcsId) {
        this.vcsId = vcsId;
    }

    private Integer siteID;
    private Long categoryId;
    private Long catalogId;
    private String categoryName;
    private String catalogName;
    private Boolean isCatalogEnabled;
    private Long vcsId;


}
