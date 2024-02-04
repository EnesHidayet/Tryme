package org.enes.service;

import lombok.RequiredArgsConstructor;
import org.enes.entity.Resim;
import org.enes.exception.ErrorType;
import org.enes.exception.TryMeAppException;
import org.enes.repository.ResimRepository;
import org.enes.utility.ICrudService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ResimService implements ICrudService<Resim,Long> {
    private final ResimRepository resimRepository;


    @Override
    public Resim save(Resim resim) {
        Resim resim1 = resimRepository.save(resim);
        if (resim1 != null) {
            return resim1;
        }
       throw new TryMeAppException(ErrorType.BAD_REQUEST);
    }

    @Override
    public Resim update(Resim resim) {
        return resimRepository.save(resim);
    }

    @Override
    public Iterable<Resim> saveAll(Iterable<Resim> t) {
        return resimRepository.saveAll(t);
    }

    @Override
    public void deleteById(Long aLong) {
        resimRepository.deleteById(aLong);
    }

    @Override
    public Optional<Resim> findById(Long aLong) {
        Optional<Resim> resim = resimRepository.findById(aLong);
        if (resim.isEmpty()){
            throw new TryMeAppException(ErrorType.ENTITY_NOT_FOUND,"Resim bulunamadı.");
        }
        return resim;
    }

    @Override
    public List<Resim> findAll() {
        return resimRepository.findAll();
    }
}