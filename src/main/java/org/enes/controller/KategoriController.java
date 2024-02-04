package org.enes.controller;

import lombok.RequiredArgsConstructor;
import org.enes.entity.Kategori;
import org.enes.service.KategoriService;
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
@RequestMapping(KATEGORI)
public class KategoriController {
    private final KategoriService kategoriService;

    @PostMapping(SAVE)
    public ResponseEntity<Kategori> save(Kategori kategori){ return ResponseEntity.ok(kategoriService.save(kategori)); }

    @GetMapping(FIND_BY_ID)
    public ResponseEntity<Optional<Kategori>> findById(Long id){
        return ResponseEntity.ok(kategoriService.findById(id));
    }

    @GetMapping(FIND_ALL)
    public ResponseEntity<List<Kategori>> findAll(){
        return ResponseEntity.ok(kategoriService.findAll());
    }
}
