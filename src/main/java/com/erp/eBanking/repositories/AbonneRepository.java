package com.erp.eBanking.repositories;

import com.erp.eBanking.domain.Abonne;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AbonneRepository extends CrudRepository<Abonne, Long> {
    Abonne findByUsername(String username);
    Abonne getById(Long id);
}
