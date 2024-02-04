package org.enes.service;


import lombok.RequiredArgsConstructor;
import org.enes.entity.AltKategori;
import org.enes.exception.ErrorType;
import org.enes.exception.TryMeAppException;
import org.enes.repository.AltKategoriRepository;
import org.enes.utility.ICrudService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class AltKategoriService implements ICrudService<AltKategori, Long> {
    private final AltKategoriRepository altKategoriRepository;

    @Override
    public AltKategori save(AltKategori altKategori) {
        AltKategori altKategori1 = altKategoriRepository.save(altKategori);
        if (altKategori1 != null) {
            return altKategori1;
        }
            throw new TryMeAppException(ErrorType.BAD_REQUEST);

    }

    @Override
    public AltKategori update(AltKategori altKategori) {
        return altKategoriRepository.save(altKategori);
    }

    @Override
    public Iterable<AltKategori> saveAll(Iterable<AltKategori> t) {
        return altKategoriRepository.saveAll(t);
    }

    @Override
    public void deleteById(Long aLong) {
        altKategoriRepository.deleteById(aLong);
    }

    @Override
    public Optional<AltKategori> findById(Long aLong) {
        Optional<AltKategori> altKategori = altKategoriRepository.findById(aLong);
        if (altKategori.isPresent()) {
            return altKategori;
        } else {
            throw new TryMeAppException(ErrorType.ENTITY_NOT_FOUND);
        }
    }

    @Override
    public List<AltKategori> findAll() {
        return altKategoriRepository.findAll();
    }

}
