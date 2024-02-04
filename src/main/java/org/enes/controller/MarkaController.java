package org.enes.controller;

import lombok.RequiredArgsConstructor;
import org.enes.entity.Marka;
import org.enes.service.MarkaService;
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
@RequestMapping(MARKA)
public class MarkaController {
    private final MarkaService markaService;

    @PostMapping(SAVE)
    public ResponseEntity<Marka> save(Marka marka){
        return ResponseEntity.ok(markaService.save(marka));
    }
    @GetMapping(FIND_BY_ID)
    public ResponseEntity<Optional<Marka>> findById(Long id){return ResponseEntity.ok(markaService.findById(id));}
    @GetMapping(FIND_ALL)
    public ResponseEntity<List<Marka>> findAll(){
        return ResponseEntity.ok(markaService.findAll());
    }
}
