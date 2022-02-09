package com.koltsov.cms.service.cakes;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;

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

    private Cake createCake(String name) {
        Cake cake = new Cake();
        cake.setId(1L);
        cake.setName(name);
        return cake;
    }
}