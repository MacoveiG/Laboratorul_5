package com.laboratorul_5.controller;

import com.laboratorul_5.entity.Carte;
import com.laboratorul_5.repository.CarteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/carte")
public class CarteController {

    @Autowired
    private CarteRepository carteRepository;

    @GetMapping("/test")
    public String test() {
        System.out.println("test successful!!!");
        return "test successful";
    }

    @GetMapping
    public List<Carte> carteList() {
        return carteRepository.findAll();
    }

    @GetMapping("/{id}")
    public Carte carteById(@PathVariable("id") Integer id) {
        return carteRepository.findById(id);
    }

    @GetMapping("/")
    public Carte carteByIdRP(@RequestParam("id") Integer id) {
        return carteRepository.findById(id);
    }

    @GetMapping("/autor/{autor}")
    public Carte carteByAutor(@PathVariable("autor") String autor) {
        return carteRepository.findByAutor(autor);
    }

    @PostMapping
    public void add(@RequestBody Carte carte) {
        carteRepository.add(carte);
    }

    @PutMapping("/{id}")
    public void update(@PathVariable("id") Integer id, @RequestBody Carte carte) {
        carteRepository.update(id, carte);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable("id") Integer id) {
        carteRepository.delete(id);
    }
}
