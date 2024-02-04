package org.enes.service;

import lombok.RequiredArgsConstructor;
import org.enes.entity.Adres;
import org.enes.exception.ErrorType;
import org.enes.exception.TryMeAppException;
import org.enes.repository.AdresRepository;
import org.enes.utility.ICrudService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class AdresService  implements ICrudService<Adres,Long> {
    private final AdresRepository adresRepository;


    @Override
    public Adres save(Adres adres) {
        Adres adres1= adresRepository.save(adres);
        if (adres1!=null){
            return adres1;
        }
            throw new TryMeAppException(ErrorType.BAD_REQUEST);
    }

    @Override
    public Adres update(Adres adres) {
        return adresRepository.save(adres);
    }

    @Override
    public Iterable<Adres> saveAll(Iterable<Adres> t) {
        return adresRepository.saveAll(t);
    }

    @Override
    public void deleteById(Long id) {
        adresRepository.deleteById(id);
    }

    @Override
    public Optional<Adres> findById(Long id) {

        Optional<Adres> adres = adresRepository.findById(id);

        if (adres.isPresent()) {
            return adres;
        }else {
            throw new TryMeAppException(ErrorType.ENTITY_NOT_FOUND);
        }
    }

    @Override
    public List<Adres> findAll() {
        return adresRepository.findAll();
    }
}
