package com.inditex.guillermobarrena.inditex.repositories.repositories;

import com.inditex.guillermobarrena.inditex.repositories.entities.PricesEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IPriceRepository extends JpaRepository<PricesEntity, Integer> {}
