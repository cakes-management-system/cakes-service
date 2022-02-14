package com.koltsov.cms.service.cakes;

import com.koltsov.cms.starter.mapper.CakeMangerMapperConfig;
import com.koltsov.cms.starter.mapper.GenericMapper;
import com.koltsov.cms.starter.web.dto.cake.CakeCreateDto;
import com.koltsov.cms.starter.web.dto.cake.CakeDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(config = CakeMangerMapperConfig.class)
public interface CakeMapper extends GenericMapper<Cake, CakeDto, CakeCreateDto> {

    @Override
    CakeDto toDto(Cake entity);

    @Mapping(target = "imageMimeType", ignore = true)
    @Mapping(target = "imageLength", ignore = true)
    @Mapping(target = "imageId", ignore = true)
    @Override
    Cake toEntity(CakeDto dto);

    @Mapping(target = "imageMimeType", ignore = true)
    @Mapping(target = "imageLength", ignore = true)
    @Mapping(target = "imageId", ignore = true)
    @Mapping(target = "id", ignore = true)
    @Override
    Cake toNewEntity(CakeCreateDto createDto);
}
