package com.koltsov.cms.service.cakes;

import lombok.RequiredArgsConstructor;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.Optional;

@RequiredArgsConstructor
@RestController
@RequestMapping("api/v1/cakes/{id}/image")
public class CakeImageController {

    private final CakeService cakeService;
    private final CakeStore cakeStore;

    @GetMapping
    public ResponseEntity<InputStreamResource> getImage(@PathVariable Long id) {
        Cake cake = cakeService.getById(id);
        return Optional.ofNullable(cakeStore.getContent(cake))
                .map(InputStreamResource::new)
                .map(inputStreamResource -> ResponseEntity.ok()
                        .contentLength(cake.getImageLength())
                        .contentType(MediaType.parseMediaType(cake.getImageMimeType()))
                        .body(inputStreamResource))
                .orElse(ResponseEntity.noContent().build());
    }

    @PutMapping
    public ResponseEntity<Void> uploadImage(@PathVariable Long id, @RequestParam("image") MultipartFile image) throws IOException {
        Cake cake = cakeService.getById(id);
        cakeStore.setContent(cake, image.getInputStream());
        cake.setImageMimeType(image.getContentType());
        cakeService.update(id, cake);
        return ResponseEntity.accepted().build();
    }
}
