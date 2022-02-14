package com.koltsov.cms.service.cakes;

import lombok.SneakyThrows;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.core.io.InputStreamResource;
import org.springframework.mock.web.MockMultipartFile;
import org.springframework.web.multipart.MultipartFile;

import java.io.ByteArrayInputStream;
import java.io.InputStream;

import static com.koltsov.cms.service.cakes.CakeHelper.*;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class CakeImageServiceTest {

    @Mock
    private CakeService cakeService;
    @Mock
    private CakeStore cakeStore;

    @InjectMocks
    private CakeImageService cakeImageService;

    @Test
    void getImage() {
        Cake cake = createCake();
        InputStream stream = new ByteArrayInputStream("qwe".getBytes());
        Image expected = Image.builder()
                .metadata(ImageMetadata.builder()
                        .id(RANDOM_UUID)
                        .length(IMAGE_LENGTH)
                        .mimoType(IMAGE_MIMO_TYPE)
                        .build())
                .content(new InputStreamResource(stream))
                .build();
        when(cakeService.getById(ID)).thenReturn(cake);
        when(cakeStore.getContent(cake)).thenReturn(stream);

        Image actual = cakeImageService.getImage(ID);

        assertEquals(expected, actual);
    }

    @SneakyThrows
    @Test
    void uploadImage() {
        MultipartFile image = new MockMultipartFile("cake.png", "cake.png", "image/png", "actual_picture".getBytes());
        Cake cake = createCake();
        when(cakeService.getById(ID)).thenReturn(cake);
        when(cakeStore.setContent(eq(cake), any(InputStream.class))).thenReturn(cake);

        cakeImageService.uploadImage(ID, image);

        assertEquals("image/png", cake.getImageMimeType());
    }
}