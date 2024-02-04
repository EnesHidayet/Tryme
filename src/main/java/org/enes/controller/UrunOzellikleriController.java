package org.enes.controller;

import lombok.RequiredArgsConstructor;
import org.enes.entity.UrunOzellikleri;
import org.enes.service.UrunOzellikleriService;
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
@RequestMapping(URUNOZELLIKLERI)
public class UrunOzellikleriController {
    private final UrunOzellikleriService urunOzellikleriService;

    @PostMapping(SAVE)
    public ResponseEntity<UrunOzellikleri> save(UrunOzellikleri urunOzellikleri){
        return ResponseEntity.ok(urunOzellikleriService.save(urunOzellikleri));
    }

    @GetMapping(FIND_BY_ID)
    public ResponseEntity<Optional<UrunOzellikleri>> findById(Long id){
        return ResponseEntity.ok(urunOzellikleriService.findById(id));
    }

    @GetMapping(FIND_ALL)
    public ResponseEntity<List<UrunOzellikleri>> findAll(){
        return ResponseEntity.ok(urunOzellikleriService.findAll());
    }
}
