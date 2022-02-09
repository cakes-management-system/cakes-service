package com.koltsov.cms.service.cakes;

import com.koltsov.cms.starter.service.DefaultCrudService;
import org.springframework.stereotype.Service;

@Service
public class CakeService extends DefaultCrudService<Cake, Long> {

    @Override
    protected void updateFields(Cake to, Cake from) {
        to.setName(from.getName());
    }
}
