package org.enes.controller;

import lombok.RequiredArgsConstructor;
import org.enes.entity.AltKategori;
import org.enes.service.AltKategoriService;
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
@RequestMapping(ALTKATEGORI)
public class AltKategoriController {
    private final AltKategoriService altKategoriService;
    @PostMapping(SAVE)
    public ResponseEntity<AltKategori> save(AltKategori altKategori) {
        return ResponseEntity.ok(altKategoriService.save(altKategori));
    }

    @GetMapping(FIND_BY_ID)
    public ResponseEntity<Optional<AltKategori>> findById(Long id) {
        return ResponseEntity.ok(altKategoriService.findById(id));
    }

    @GetMapping(FIND_ALL)
    public ResponseEntity<List<AltKategori>> findAll() {
        return ResponseEntity.ok(altKategoriService.findAll());
    }
}
