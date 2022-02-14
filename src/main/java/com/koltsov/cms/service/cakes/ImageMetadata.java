package com.koltsov.cms.service.cakes;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Data
public class ImageMetadata {
    private UUID id;
    private Long length;
    private String mimoType;
}
