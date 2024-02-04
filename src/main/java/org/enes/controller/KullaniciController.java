package org.enes.controller;

import lombok.RequiredArgsConstructor;
import org.enes.entity.Kullanici;
import org.enes.dto.request.UserLoginRequestDto;
import org.enes.dto.request.UserSaveRequestDto;
import org.enes.dto.response.UserSaveResponseDto;
import org.enes.service.KullaniciService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

import static org.enes.constants.RestApiUrl.*;
@RestController
@RequiredArgsConstructor
@RequestMapping(KULLANICI)
public class KullaniciController {
    private final KullaniciService kullaniciService;

    @PostMapping(REGISTER)
    public ResponseEntity<UserSaveResponseDto> register(@RequestBody UserSaveRequestDto dto){
        return ResponseEntity.ok(kullaniciService.register(dto));
    }

    @PostMapping(LOGIN)
    public ResponseEntity<UserSaveResponseDto> login(@RequestBody UserLoginRequestDto dto){
        return ResponseEntity.ok(kullaniciService.login(dto));
    }

    @GetMapping(FIND_ALL)
    public ResponseEntity<List<Kullanici>> findAll(){
        return ResponseEntity.ok(kullaniciService.findAll());
    }

    @GetMapping(FIND_BY_ID)
    public ResponseEntity<Optional<Kullanici>> findById(Long id){
        return ResponseEntity.ok(kullaniciService.findById(id));
    }

    @DeleteMapping(DELETE)
    public ResponseEntity<Kullanici> delete(Long id){
        kullaniciService.delete(id);
        return ResponseEntity.ok().build();
    }
}
