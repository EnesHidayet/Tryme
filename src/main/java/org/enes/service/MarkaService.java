package org.enes.service;

import lombok.RequiredArgsConstructor;
import org.enes.entity.Marka;
import org.enes.exception.ErrorType;
import org.enes.exception.TryMeAppException;
import org.enes.repository.MarkaRepository;
import org.enes.utility.ICrudService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class MarkaService implements ICrudService<Marka, Long> {
    private final MarkaRepository markaRepository;


    @Override
    public Marka save(Marka marka) {
        Marka marka1 = markaRepository.save(marka);
        if (marka1 != null) {
            return marka1;
        }
        throw new TryMeAppException(ErrorType.BAD_REQUEST);
    }

    @Override
    public Marka update(Marka marka) {
        return markaRepository.save(marka);
    }

    @Override
    public Iterable<Marka> saveAll(Iterable<Marka> t) {
        return markaRepository.saveAll(t);
    }

    @Override
    public void deleteById(Long aLong) {
        markaRepository.deleteById(aLong);
    }

    @Override
    public Optional<Marka> findById(Long aLong) {
        Optional<Marka> marka = markaRepository.findById(aLong);

        if (marka.isEmpty()) {
            throw new TryMeAppException(ErrorType.ENTITY_NOT_FOUND);
        }
        return marka;
    }

    @Override
    public List<Marka> findAll() {
        return markaRepository.findAll();
    }
}
