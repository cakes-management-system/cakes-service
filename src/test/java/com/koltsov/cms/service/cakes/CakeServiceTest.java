package com.koltsov.cms.service.cakes;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;

import static com.koltsov.cms.service.cakes.CakeHelper.createCake;
import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class CakeServiceTest {

    @InjectMocks
    private CakeService cakeService;

    @Test
    void updateFields() {
        String expectedName = "Медовик";
        Cake to = createCake("Наполеон");
        Cake from = createCake(expectedName);

        cakeService.updateFields(to, from);

        assertEquals(expectedName, to.getName());
    }
}