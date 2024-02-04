package org.enes.controller;

import lombok.RequiredArgsConstructor;
import org.enes.entity.Resim;
import org.enes.repository.ResimRepository;
import static org.enes.constants.RestApiUrl.*;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@RequiredArgsConstructor
@RequestMapping(RESIMLER)
public class ResimController {
    private final ResimRepository resimRepository;

    @PostMapping(SAVE)
    public ResponseEntity<Resim> save(Resim resim){
        return ResponseEntity.ok(resimRepository.save(resim));
    }

    @GetMapping(FIND_BY_ID)
    public ResponseEntity<Optional<Resim>> findById(Long id){
        return ResponseEntity.ok(resimRepository.findById(id));
    }

    @GetMapping(FIND_ALL)
    public ResponseEntity<List<Resim>> findAll(){
        return ResponseEntity.ok(resimRepository.findAll());
    }

}
