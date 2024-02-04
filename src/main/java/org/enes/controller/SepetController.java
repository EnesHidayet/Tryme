package org.enes.controller;

import lombok.RequiredArgsConstructor;
import org.enes.entity.Sepet;
import org.enes.service.SepetService;
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
@RequestMapping(SEPET)
public class SepetController {
    private final SepetService sepetService;

    @PostMapping(SAVE)
    public ResponseEntity<Sepet> save(Sepet sepet){
        return ResponseEntity.ok(sepetService.save(sepet));
    }

    @GetMapping(FIND_BY_ID)
    public ResponseEntity<Optional<Sepet>> findById(Long id){
        return ResponseEntity.ok(sepetService.findById(id));
    }

    @GetMapping(FIND_ALL)
    public ResponseEntity<List<Sepet>> findAll(){
        return ResponseEntity.ok(sepetService.findAll());
    }

    @GetMapping(ADD_URUN)
    public ResponseEntity<Sepet> addUrun(Long urunId){
        return ResponseEntity.ok(sepetService.addUrun(urunId));
    }
}
