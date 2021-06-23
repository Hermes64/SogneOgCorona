package com.example.sogneogcorona.controllers;

import com.example.sogneogcorona.model.Kommune;
import com.example.sogneogcorona.model.Sogne;
import com.example.sogneogcorona.repositories.SogneRepo;
import com.example.sogneogcorona.services.SogneService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.HashSet;
import java.util.Optional;

@Controller
public class sogneController {

    @Autowired
    SogneService sogneService;

    @GetMapping("/")

    public String index (Model model){
        Iterable <Sogne> sogneList;
        sogneList = sogneService.findAll();
        model.addAttribute("sogneList", sogneList);
        return "index";
    }
    @GetMapping("/create")
    public String create (){
        return "/create";
    }

    @PostMapping("/create")
    public String createNewProject(
            @RequestParam("sognekode") int sognekode,
            @RequestParam("navn") String navn,
            @RequestParam("smittetryk") double smittetryk,
//            @RequestParam("lukket") boolean closed,
            @RequestParam("nedlukningStart") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) Date nedlukningStart,
            @RequestParam("kommune") Kommune kommune){
        Sogne sogne = new Sogne(sognekode, navn,smittetryk,nedlukningStart, kommune );
        sogneService.create(sogne);
        return "redirect:/";

    }

    @GetMapping("/delete")
    public String deleteSogn (){
        return "delete";
    }


    @PostMapping("/delete")
 public String delete(@RequestParam("id") int id ){
        sogneService.deleteById(id);
        return "redirect:/";
    }
    public String update(@RequestParam("id") int id,
                         @RequestParam("sognekode") int sognekode,
                         @RequestParam("navn") String navn,
                         @RequestParam("kommune") Kommune kommune,
                         @RequestParam("smittetryk") double smittetryk,
                         @RequestParam("nedlukningStart") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) Date nedlukningStart) {

        Sogne xsogne = new Sogne(sognekode, navn,smittetryk,nedlukningStart, kommune);
        sogneService.update(xsogne);
        return "redirect:/";
    }

}
