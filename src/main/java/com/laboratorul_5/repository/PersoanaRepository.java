package com.laboratorul_5.repository;

import com.laboratorul_5.entity.Persoana;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class PersoanaRepository {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public List<Persoana> findAll() {
        List<Persoana> persoanaList = jdbcTemplate.query("SELECT * FROM persoana ORDER BY id", (rs, rowNum) -> {
            return new Persoana(
                    rs.getInt("id"),
                    rs.getString("first_name"),
                    rs.getString("last_name"),
                    rs.getString("email"),
                    rs.getString("gender").charAt(0),
                    rs.getInt("adresa_id"));
        });
        return persoanaList;
    }

    public Persoana findById(Integer id) {
        Persoana persoana = jdbcTemplate.queryForObject("SELECT * FROM persoana WHERE id = ?",
                new Object[]{id}, (rs, rowNum) -> {
                    return new Persoana(
                            rs.getInt("id"),
                            rs.getString("first_name"),
                            rs.getString("last_name"),
                            rs.getString("email"),
                            rs.getString("gender").charAt(0),
                            rs.getInt("adresa_id"));
                });
        return persoana;
    }

    public Persoana findByEmail(String email) {
        Persoana persoana = jdbcTemplate.queryForObject("SELECT * FROM persoana WHERE email = ?",
                new Object[]{email}, (rs, rowNum) -> {
                    return new Persoana(
                            rs.getInt("id"),
                            rs.getString("first_name"),
                            rs.getString("last_name"),
                            rs.getString("email"),
                            rs.getString("gender").charAt(0),
                            rs.getInt("adresa_id"));
                });
        return persoana;
    }

    public void add(Persoana persoana) {
        jdbcTemplate.update("INSERT INTO persoana(id, first_name, last_name, email, gender, adresa_id) VALUES (?, ?, ?, ?, ?, ?);",
                persoana.getId(), persoana.getFirstName(), persoana.getLastName(), persoana.getEmail(), persoana.getGender(), persoana.getAdresaId());
    }

    public void update(Integer id, Persoana persoana) {
        jdbcTemplate.update("UPDATE persoana SET first_name = ?, last_name = ?, email = ?, gender = ?, adresa_id = ? WHERE id = ?",
                persoana.getFirstName(), persoana.getLastName(), persoana.getEmail(), persoana.getGender(), persoana.getAdresaId(), id);
    }

    public void delete(Integer id) {
        jdbcTemplate.update("DELETE FROM persoana WHERE id = ?", id);
    }
}
