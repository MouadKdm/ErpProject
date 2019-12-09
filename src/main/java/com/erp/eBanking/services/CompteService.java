package com.erp.eBanking.services;

import com.erp.eBanking.domain.Abonne;
import com.erp.eBanking.domain.Compte;
import com.erp.eBanking.repositories.AbonneRepository;
import com.erp.eBanking.repositories.CompteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CompteService {
    @Autowired
    private CompteRepository compteRepository ;
    @Autowired
    private AbonneRepository abonneRepository ;


    public Compte saveCompte(Compte compte , String username){
        Abonne abonne = abonneRepository.findByUsername(username);
        compte.setAbonne(abonne);
        compte.setCompteLeader(abonne.getUsername());
       return compteRepository.save(compte);
    }

    public List<Compte> findAllComptes(String username){
        Abonne abonne = abonneRepository.findByUsername(username);
       return compteRepository.getAllByAbonne(abonne);
    }
    public Compte findCompteByNumeroCompte(Long numero){
         Compte compte =compteRepository.findByNumeroCompte(numero);
         return compte ;
    }

    public void Virement(Long numeroCompte1 , Long numeroCompte2 , Double montant){

        Compte compte1 = compteRepository.findByNumeroCompte(numeroCompte1);
        Compte compte2 = compteRepository.findByNumeroCompte(numeroCompte2);

        double solde1 = compte1.getSoldeCompte() - montant ;
        double solde2 = compte2.getSoldeCompte() + montant ;
        compte1.setSoldeCompte(solde1);
        compte2.setSoldeCompte(solde2);

        compteRepository.save(compte1);
        compteRepository.save(compte2);


    }
}
