package com.erp.eBanking.web;


import com.erp.eBanking.domain.Compte;
import com.erp.eBanking.services.CompteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.security.Principal;
import java.util.List;

@RestController
@RequestMapping("compte")
@CrossOrigin
public class CompteController {
    @Autowired
    private CompteService compteService ;
    @PostMapping("/add")
    public ResponseEntity<?> createCompte(@Valid @RequestBody Compte compte , Principal principal){
        Compte compte1 = compteService.saveCompte(compte , principal.getName());
        return new ResponseEntity<Compte>(compte1 , HttpStatus.CREATED);
    }

    @GetMapping("/all")
    public ResponseEntity<?> getAllComptes(Principal principal){
        List<Compte> comptes = compteService.findAllComptes(principal.getName());
        return new ResponseEntity<Iterable<Compte>>(comptes , HttpStatus.OK);
    }

    @PostMapping("/virement/{numeroCompte1}/{numeroCompte2}/{montant}")
    public ResponseEntity<?> virementSolde(@PathVariable Long numeroCompte1,
                                           @PathVariable Long numeroCompte2 ,
                                           @PathVariable double montant ){
        compteService.Virement(numeroCompte1 , numeroCompte2 ,montant);
        return new ResponseEntity<String>("with success",HttpStatus.OK);
    }

}
