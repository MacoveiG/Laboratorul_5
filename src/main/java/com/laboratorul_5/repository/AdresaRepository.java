package com.laboratorul_5.repository;

import com.laboratorul_5.entity.Adresa;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class AdresaRepository {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public List<Adresa> findAll() {
        List<Adresa> adresaList = jdbcTemplate.query("SELECT * FROM adresa ORDER BY id", (rs, rowNum) -> {
            return new Adresa(
                    rs.getInt("id"),
                    rs.getString("tara"),
                    rs.getString("oras"),
                    rs.getString("strada"),
                    rs.getInt("nr_casa"),
                    rs.getInt("nr_apartament"));
        });
        return adresaList;
    }

    public Adresa findById(Integer id) {
        Adresa adresa = jdbcTemplate.queryForObject("SELECT * FROM adresa WHERE id = ?",
                new Object[]{id}, (rs, rowNum) -> {
                    return new Adresa(
                            rs.getInt("id"),
                            rs.getString("tara"),
                            rs.getString("oras"),
                            rs.getString("strada"),
                            rs.getInt("nr_casa"),
                            rs.getInt("nr_apartament"));
                });
        return adresa;
    }

    public Adresa findByOras(String oras) {
        Adresa adresa = jdbcTemplate.queryForObject("SELECT * FROM adresa WHERE oras = ?",
                new Object[]{oras}, (rs, rowNum) -> {
                    return new Adresa(
                            rs.getInt("id"),
                            rs.getString("tara"),
                            rs.getString("oras"),
                            rs.getString("strada"),
                            rs.getInt("nr_casa"),
                            rs.getInt("nr_apartament"));
                });
        return adresa;
    }

    public void add(Adresa adresa) {
        jdbcTemplate.update("INSERT INTO adresa(id, tara, oras, strada, nr_casa, nr_apartament) VALUES (?, ?, ?, ?, ?, ?);",
                adresa.getId(), adresa.getTara(), adresa.getOras(), adresa.getStrada(), adresa.getNrCasa(), adresa.getNrApartament());
    }

    public void update(Integer id, Adresa adresa) {
        jdbcTemplate.update("UPDATE adresa SET tara = ?, oras = ?, strada = ?, nr_casa = ?, nr_apartament = ? WHERE id = ?",
                adresa.getTara(), adresa.getOras(), adresa.getStrada(), adresa.getNrCasa(), adresa.getNrApartament(), id);
    }

    public void delete(Integer id) {
        jdbcTemplate.update("DELETE FROM adresa WHERE id = ?", id);
    }
}
