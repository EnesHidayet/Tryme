package org.enes.controller;

import lombok.RequiredArgsConstructor;
import org.enes.entity.Adres;
import org.enes.service.AdresService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

import static org.enes.constants.RestApiUrl.*;
@RestController
@RequiredArgsConstructor
@RequestMapping(ADRES)
public class AdresController {
    private final AdresService adresService;

    @PostMapping(SAVE)
    public ResponseEntity<Adres> saveAdres(Adres adres) {
        return ResponseEntity.ok(adresService.save(adres));
    }

    @GetMapping(FIND_BY_ID)
    public ResponseEntity<Optional<Adres>> findAdresById(Long id) {
        return ResponseEntity.ok(adresService.findById(id));
    }

    @GetMapping(FIND_ALL)
    public ResponseEntity<List<Adres>> findAllAdres() {
        return ResponseEntity.ok(adresService.findAll());
    }
}
