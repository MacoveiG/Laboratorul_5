package com.laboratorul_5.repository;

import com.laboratorul_5.entity.Carte;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class CarteRepository {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public List<Carte> findAll() {
        List<Carte> carteList = jdbcTemplate.query("SELECT * FROM carte ORDER BY id", (rs, rowNum) -> {
            return new Carte(
                    rs.getInt("id"),
                    rs.getString("denumire"),
                    rs.getString("autor"),
                    rs.getInt("an"));
        });
        return carteList;
    }

    public Carte findById(Integer id) {
        Carte carte = jdbcTemplate.queryForObject("SELECT * FROM carte WHERE id = ?",
                new Object[]{id}, (rs, rowNum) -> {
                    return new Carte(
                            rs.getInt("id"),
                            rs.getString("denumire"),
                            rs.getString("autor"),
                            rs.getInt("an"));
                });
        return carte;
    }

    public Carte findByAutor(String autor) {
        Carte carte = jdbcTemplate.queryForObject("SELECT * FROM carte WHERE autor = ?",
                new Object[]{autor}, (rs, rowNum) -> {
                    return new Carte(
                            rs.getInt("id"),
                            rs.getString("denumire"),
                            rs.getString("autor"),
                            rs.getInt("an"));
                });
        return carte;
    }

    public void add(Carte carte) {
        jdbcTemplate.update("INSERT INTO carte(id, denumire, autor, an) VALUES (?, ?, ?, ?);",
                carte.getId(), carte.getDenumire(), carte.getAutor(), carte.getAn());
    }

    public void update(Integer id, Carte carte) {
        jdbcTemplate.update("UPDATE carte SET denumire = ?, autor = ?, an = ? WHERE id = ?",
                carte.getDenumire(), carte.getAutor(), carte.getAn(), id);
    }

    public void delete(Integer id) {
        jdbcTemplate.update("DELETE FROM carte WHERE id = ?", id);
    }
}
