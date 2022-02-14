package com.koltsov.cms.service.cakes;

import lombok.RequiredArgsConstructor;
import org.springframework.core.io.InputStreamResource;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class CakeImageService {

    private final CakeService cakeService;
    private final CakeStore cakeStore;

    public Image getImage(Long id) {
        Cake cake = cakeService.getById(id);
        return Optional.ofNullable(cakeStore.getContent(cake))
                .map(InputStreamResource::new)
                .map(inputStreamResource -> Image.builder()
                        .metadata(ImageMetadata.builder()
                                .id(cake.getImageId())
                                .length(cake.getImageLength())
                                .mimoType(cake.getImageMimeType())
                                .build())
                        .content(inputStreamResource)
                        .build()
                )
                .orElse(null);
    }

    @Transactional
    public void uploadImage(Long id, MultipartFile image) throws IOException {
        Cake cake = cakeService.getById(id);
        cakeStore.setContent(cake, image.getInputStream());
        cake.setImageMimeType(image.getContentType());
    }
}
