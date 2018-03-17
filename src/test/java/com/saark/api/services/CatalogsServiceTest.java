package com.saark.api.services;

import com.saark.api.catalogs.domain.Catalog;
import com.saark.api.catalogs.models.CatalogMappingRequest;
import com.saark.api.catalogs.services.CatalogsService;

import org.junit.*;
import org.junit.runner.RunWith;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.*;
import static org.mockito.BDDMockito.*;
import static org.assertj.core.api.Assertions.*;
import java.util.ArrayList;

@RunWith(SpringRunner.class)
public class CatalogsServiceTest {

    @MockBean
    private CatalogsService catalogsService;

    @Test
    public void getCatalogMapping() {
        Catalog mockCatalog = new Catalog();
        Catalog mockCatalog2 = new Catalog();
        mockCatalog.setCatalogId((long) 47);
        mockCatalog.setSiteID(0);
        mockCatalog2.setCatalogId((long) 20);
        mockCatalog2.setSiteID(0);
        ArrayList<Catalog> mockList = new ArrayList<>(1);
        mockList.add(mockCatalog);
        CatalogMappingRequest mockRequest = new CatalogMappingRequest();
        mockRequest.setMappingList(mockList);
        given(this.catalogsService.getMockResponse()).willReturn(mockRequest);
        given(this.catalogsService.getCatalogMapping((long) 47, 0)).willCallRealMethod();
        CatalogMappingRequest request = catalogsService.getCatalogMapping((long) 47, 0);
        assertThat(request.getMappingList().size()).isEqualTo(1);
        assertThat(request.getMappingList().get(0).getCatalogId()).isEqualTo(47);
    }

}