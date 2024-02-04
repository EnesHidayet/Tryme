package org.enes.controller;

import lombok.RequiredArgsConstructor;
import org.enes.entity.Urun;
import org.enes.service.UrunService;
import org.enes.utility.enums.EBeden;
import org.enes.utility.enums.ECinsiyet;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

import static org.enes.constants.RestApiUrl.*;
@RestController
@RequiredArgsConstructor
@RequestMapping(URUN)
public class UrunController {
    private final UrunService urunService;

    @PostMapping(SAVE)
    public ResponseEntity<Urun> save(Urun urun){
        return ResponseEntity.ok(urunService.save(urun));
    }

    @GetMapping(FIND_BY_ID)
    public ResponseEntity<Optional<Urun>> findById(Long id){
        return ResponseEntity.ok(urunService.findById(id));
    }

    @GetMapping(FIND_ALL)
    public ResponseEntity<List<Urun>> findAll(){
        return ResponseEntity.ok(urunService.findAll());
    }

    @GetMapping(FIND_ALL_BY_CINSIYET)
    public ResponseEntity<List<Urun>> findAllByOzelliklerCinsiyet(ECinsiyet cinsiyet){
        return ResponseEntity.ok(urunService.findAllByOzelliklerCinsiyet(cinsiyet));
    }

    @GetMapping(FIND_ALL_BY_BEDEN)
    public ResponseEntity<List<Urun>> findAllByOzelliklerBeden(@RequestParam EBeden beden){
        return ResponseEntity.ok(urunService.findAllByOzelliklerBeden(beden));
    }

    @GetMapping(FIND_ALL_BY_CINSIYET_AND_BEDEN)
    public ResponseEntity<List<Urun>> findAllByOzelliklerCinsiyetAndOzelliklerBeden(ECinsiyet cinsiyet, EBeden beden){
        return ResponseEntity.ok(urunService.findAllByOzelliklerCinsiyetAndOzelliklerBeden(cinsiyet, beden));
    }

    @GetMapping(FIND_BY_URUN_ADI)
    public ResponseEntity<List<Urun>> findByUrunAdiContainingIgnoreCase(String urunAdi){
        return ResponseEntity.ok(urunService.findByUrunAdiContainingIgnoreCase(urunAdi));
    }

    @GetMapping(FIND_ALL_BY_FIYAT)
    public ResponseEntity<List<Urun>> findAllByFiyatBetween(Double min, Double max){
        return ResponseEntity.ok(urunService.findAllByFiyatBetween(min, max));
    }

    @GetMapping(FIND_ALL_BY_MARKA)
    public ResponseEntity<List<Urun>> findAllByMarkaId(Long id){
        return ResponseEntity.ok(urunService.findAllByMarkaId(id));
    }

    @GetMapping(FIND_ALL_BY_MODEL)
    public ResponseEntity<List<Urun>> findAllByModelId(Long id){
        return ResponseEntity.ok(urunService.findAllByModelId(id));
    }

    @GetMapping(FIND_ALL_BY_ALT_KATEGORI)
    public ResponseEntity<List<Urun>> findAllByAltKategoriId(Long id){
        return ResponseEntity.ok(urunService.findAllByAltKategoriId(id));
    }

    @GetMapping(FIND_ALL_BY_KATEGORI)
    public ResponseEntity<List<Urun>> findAllByKategoriId(Long id){
        return ResponseEntity.ok(urunService.findAllByKategoriId(id));
    }
}
