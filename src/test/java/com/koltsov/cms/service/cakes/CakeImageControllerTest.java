package com.koltsov.cms.service.cakes;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest(controllers = CakeImageController.class)
class CakeImageControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private CakeImageService cakeImageService;

    @Test
    void getImage() throws Exception {
        Image image = Image.builder()
                .metadata(ImageMetadata.builder()
                        .length(1000L)
                        .mimoType("image/jpeg")
                        .build())
                .build();
        when(cakeImageService.getImage(1L)).thenReturn(image);

        mockMvc.perform(
                        get("/api/v1/cakes/1/image")
                )
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(header().string(HttpHeaders.CONTENT_LENGTH, "1000"))
                .andExpect(header().string(HttpHeaders.CONTENT_TYPE, MediaType.IMAGE_JPEG_VALUE));
    }

    @Test
    void uploadImage() throws Exception {
        doNothing().when(cakeImageService).uploadImage(eq(1L), any());

        mockMvc.perform(
                        multipart("/api/v1/cakes/1/image")
                                .file("image", "actual picture".getBytes())
                                .header(HttpHeaders.CONTENT_TYPE, MediaType.MULTIPART_FORM_DATA_VALUE)
                                .with(request -> {
                                    request.setMethod("PUT");
                                    return request;
                                })
                )
                .andDo(print())
                .andExpect(status().isAccepted());
    }
}