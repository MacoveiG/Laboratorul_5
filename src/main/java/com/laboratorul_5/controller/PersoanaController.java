package com.laboratorul_5.controller;

import com.laboratorul_5.entity.Persoana;
import com.laboratorul_5.entity.PersoanaDetaliat;
import com.laboratorul_5.repository.PersoanaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/persoana")
public class PersoanaController {

    @Autowired
    private PersoanaRepository persoanaRepository;

    @GetMapping("/test")
    public String test() {
        System.out.println("test successful!!!");
        return "test successful";
    }

    @GetMapping
    public List<Persoana> persoanaList() {
        return persoanaRepository.findAll();
    }

    @GetMapping("/{id}")
    public Persoana persoanaById(@PathVariable("id") Integer id) {
        return persoanaRepository.findById(id);
    }

    @GetMapping("/")
    public Persoana persoanaByIdRP(@RequestParam("id") Integer id) {
        return persoanaRepository.findById(id);
    }

    @GetMapping("/detaliat/{id}")
    public PersoanaDetaliat persoanaDetaliatById(@PathVariable("id") Integer id) {
        return persoanaRepository.findByIdDetaliat(id);
    }

    @GetMapping("/email/{email}")
    public Persoana persoanaByEmail(@PathVariable("email") String email) {
        return persoanaRepository.findByEmail(email);
    }

    @PostMapping
    public void add(@RequestBody Persoana persoana) {
        persoanaRepository.add(persoana);
    }

    @PutMapping("/{id}")
    public void update(@PathVariable("id") Integer id, @RequestBody Persoana persoana) {
        persoanaRepository.update(id, persoana);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable("id") Integer id) {
        persoanaRepository.delete(id);
    }
}
