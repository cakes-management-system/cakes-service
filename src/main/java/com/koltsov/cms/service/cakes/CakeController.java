package com.koltsov.cms.service.cakes;

import com.koltsov.cms.starter.mapper.GenericMapper;
import com.koltsov.cms.starter.service.CrudService;
import com.koltsov.cms.starter.web.controller.CrudController;
import com.koltsov.cms.starter.web.dto.cake.CakeCreateDto;
import com.koltsov.cms.starter.web.dto.cake.CakeDto;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1/cakes")
public class CakeController extends CrudController<Cake, Long, CakeDto, CakeCreateDto> {

    public CakeController(CrudService<Cake, Long> crudService,
                          GenericMapper<Cake, CakeDto, CakeCreateDto> mapper) {
        super(crudService, mapper);
    }
}
