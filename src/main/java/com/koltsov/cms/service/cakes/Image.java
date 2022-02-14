package com.koltsov.cms.service.cakes;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.core.io.Resource;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Data
public class Image {
    private ImageMetadata metadata;
    private Resource content;
}
