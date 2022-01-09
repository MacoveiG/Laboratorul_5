package com.laboratorul_5.controller;

import com.laboratorul_5.entity.Adresa;
import com.laboratorul_5.repository.AdresaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/adresa")
public class AdresaController {

    @Autowired
    private AdresaRepository adresaRepository;

    @GetMapping("/test")
    public String test() {
        System.out.println("test successful!!!");
        return "test successful";
    }

    @GetMapping
    public List<Adresa> adresaList() {
        return adresaRepository.findAll();
    }

    @GetMapping("/{id}")
    public Adresa adresaById(@PathVariable("id") Integer id) {
        return adresaRepository.findById(id);
    }

    @GetMapping("/")
    public Adresa adresaByIdRP(@RequestParam("id") Integer id) {
        return adresaRepository.findById(id);
    }

    @GetMapping("/oras/{oras}")
    public Adresa persoanaByOras(@PathVariable("oras") String oras) {
        return adresaRepository.findByOras(oras);
    }

    @PostMapping
    public void add(@RequestBody Adresa adresa) {
        adresaRepository.add(adresa);
    }

    @PutMapping("/{id}")
    public void uodate(@PathVariable("id") Integer id, @RequestBody Adresa adresa) {
        adresaRepository.update(id, adresa);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable("id") Integer id) {
        adresaRepository.delete(id);
    }
}
