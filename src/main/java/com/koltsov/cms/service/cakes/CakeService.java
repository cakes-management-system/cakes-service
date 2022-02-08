package com.koltsov.cms.service.cakes;

import com.koltsov.cms.starter.service.DefaultCrudService;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

@Service
public class CakeService extends DefaultCrudService<Cake, Long> {

    public CakeService(JpaRepository<Cake, Long> repository) {
        super(repository);
    }

    @Override
    protected void updateFields(Cake to, Cake from) {
        to.setName(from.getName());
    }
}
