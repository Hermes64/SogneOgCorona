package com.example.sogneogcorona.services;

import com.example.sogneogcorona.model.Kommune;
import com.example.sogneogcorona.model.Sogne;
import com.example.sogneogcorona.repositories.KommuneRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

@Service
public class KommuneService {
    @Autowired
    KommuneRepo kommuneRepo;


    public Set<Kommune> findAll(){
        Set<Kommune> sogneSet = new HashSet<>();
        for (Kommune kommune : kommuneRepo.findAll()){
            sogneSet.add(kommune);
        }
        return sogneSet;
    }



    public Kommune findById(int id){
        //findById returnerer en optional, så der skal checkes for null og pakkes ud
        Optional<Kommune> optionalKommune = kommuneRepo.findById(id);
        if (!optionalKommune.isPresent()) {
            throw new RuntimeException("Sogne " + id + " not found");
        }
        //return indholdet af optionalKommune
        return optionalKommune.get();
    }

    public Kommune create(Kommune kommune){

        return kommuneRepo.save(kommune);
    }

    public Kommune update(Kommune kommune){
        //check evt. for eksistens og thow exception hvis ikke eksisterer
        return kommuneRepo.save(kommune);
    }

    public void deleteById(int id){
        kommuneRepo.deleteById(id);
    }
}
