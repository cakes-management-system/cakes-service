package com.koltsov.cms.service.cakes;

import lombok.RequiredArgsConstructor;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@RequiredArgsConstructor
@RestController
@RequestMapping("api/v1/cakes/{id}/image")
public class CakeImageController {

    private final CakeImageService cakeImageService;

    @GetMapping
    public ResponseEntity<Resource> getImage(@PathVariable Long id) {
        Image image = cakeImageService.getImage(id);
        return ResponseEntity.ok()
                .contentLength(image.getMetadata().getLength())
                .contentType(MediaType.parseMediaType(image.getMetadata().getMimoType()))
                .body(image.getContent());
    }

    @ResponseStatus(HttpStatus.ACCEPTED)
    @PutMapping(consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public void uploadImage(@PathVariable Long id, @RequestPart MultipartFile image) throws IOException {
        cakeImageService.uploadImage(id, image);
    }
}
