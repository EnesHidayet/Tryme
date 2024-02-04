package org.enes.service;

import lombok.RequiredArgsConstructor;
import org.enes.entity.UrunOzellikleri;
import org.enes.exception.ErrorType;
import org.enes.exception.TryMeAppException;
import org.enes.repository.UrunOzellikleriRepository;
import org.enes.utility.ICrudService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UrunOzellikleriService implements ICrudService<UrunOzellikleri, Long> {
    private final UrunOzellikleriRepository urunOzellikleriRepository;


    @Override
    public UrunOzellikleri save(UrunOzellikleri urunOzellikleri) {
        UrunOzellikleri urunOzellikleri1 = urunOzellikleriRepository.save(urunOzellikleri);
        if (urunOzellikleri1 != null) {
            return urunOzellikleri1;
        }
        throw new TryMeAppException(ErrorType.BAD_REQUEST);
    }

    @Override
    public UrunOzellikleri update(UrunOzellikleri urunOzellikleri) {
        return urunOzellikleriRepository.save(urunOzellikleri);
    }

    @Override
    public Iterable<UrunOzellikleri> saveAll(Iterable<UrunOzellikleri> t) {
        return urunOzellikleriRepository.saveAll(t);
    }

    @Override
    public void deleteById(Long aLong) {
        urunOzellikleriRepository.deleteById(aLong);
    }

    @Override
    public Optional<UrunOzellikleri> findById(Long aLong) {
        Optional<UrunOzellikleri> urunOzellikleri = urunOzellikleriRepository.findById(aLong);
        if (urunOzellikleri.isEmpty()) {
            throw new TryMeAppException(ErrorType.ENTITY_NOT_FOUND,"Ürün özellikleri bulunamadı.");
        }
        return urunOzellikleri;
    }

    @Override
    public List<UrunOzellikleri> findAll() {
        return urunOzellikleriRepository.findAll();
    }
}
