package com.erp.eBanking.services;


import com.erp.eBanking.domain.Abonne;
import com.erp.eBanking.exceptions.UsernameAlreadyExistsException;
import com.erp.eBanking.repositories.AbonneRepository;
import com.erp.eBanking.repositories.CompteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class AbonneService {
    @Autowired
    private AbonneRepository abonneRepository;
    @Autowired
    private CompteRepository compteRepository ;



    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder ;

    public Abonne saveOrUpdateUser(Abonne abonne ){
        try {
            abonne.setPassword(bCryptPasswordEncoder.encode(abonne.getPassword()));
            abonne.setUsername((abonne.getUsername()));
            abonne.setConfirmPassword("");
            return abonneRepository.save(abonne);
        }catch(Exception e){
            throw new UsernameAlreadyExistsException("username"+abonne.getUsername()+"already exist");
        }

    }

}
