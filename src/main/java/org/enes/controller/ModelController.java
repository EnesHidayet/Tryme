package org.enes.controller;

import lombok.RequiredArgsConstructor;
import org.apache.coyote.Response;
import org.enes.entity.Model;
import org.enes.service.ModelService;
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
@RequestMapping(MODEL)
public class ModelController {
    private final ModelService modelService;

    @PostMapping(SAVE)
    public ResponseEntity<Model> save(Model model){
        return ResponseEntity.ok(modelService.save(model));
    }

    @GetMapping(FIND_BY_ID)
    public ResponseEntity<Optional<Model>> findById(Long id){return ResponseEntity.ok(modelService.findById(id));}

    @GetMapping(FIND_ALL)
    public ResponseEntity<List<Model>> findAll(){
        return ResponseEntity.ok(modelService.findAll());
    }
}
