package com.koltsov.cms.service.cakes;

import org.springframework.content.jpa.store.JpaContentStore;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
public interface CakeStore extends JpaContentStore<Cake, UUID> {
}
