package org.enes.service;

import lombok.RequiredArgsConstructor;
import org.enes.entity.Kategori;
import org.enes.exception.ErrorType;
import org.enes.exception.TryMeAppException;
import org.enes.repository.KategoriRepository;
import org.enes.utility.ICrudService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class KategoriService implements ICrudService<Kategori, Long> {
    private final KategoriRepository kategoriRepository;


    @Override
    public Kategori save(Kategori kategori) {
        Kategori kategori1 = kategoriRepository.save(kategori);
        if (kategori1 != null) {
            return kategori1;
        }

        throw new TryMeAppException(ErrorType.BAD_REQUEST);
    }

    @Override
    public Kategori update(Kategori kategori) {
        return kategoriRepository.save(kategori);
    }

    @Override
    public Iterable<Kategori> saveAll(Iterable<Kategori> t) {
        return kategoriRepository.saveAll(t);
    }

    @Override
    public void deleteById(Long aLong) {
        kategoriRepository.deleteById(aLong);
    }

    @Override
    public Optional<Kategori> findById(Long aLong) {
        Optional<Kategori> kategori = kategoriRepository.findById(aLong);

        if (kategori.isPresent()) {
            return kategori;
        }else {
            throw new TryMeAppException(ErrorType.ENTITY_NOT_FOUND);
        }
    }

    @Override
    public List<Kategori> findAll() {
        return kategoriRepository.findAll();
    }
}
