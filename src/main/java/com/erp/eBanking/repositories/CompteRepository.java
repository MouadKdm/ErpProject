package com.erp.eBanking.repositories;


import com.erp.eBanking.domain.Abonne;
import com.erp.eBanking.domain.Compte;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository

public interface CompteRepository extends CrudRepository<Compte, Long> {
    @Override
    List<Compte> findAll();
    List<Compte> getAllByAbonne(Abonne abonne);
    Compte findByNumeroCompte(Long numero);
}
