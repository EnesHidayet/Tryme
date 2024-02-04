package org.enes.service;

import lombok.RequiredArgsConstructor;
import org.enes.entity.Sepet;
import org.enes.entity.Urun;
import org.enes.exception.ErrorType;
import org.enes.exception.TryMeAppException;
import org.enes.repository.SepetRepository;
import org.enes.utility.ICrudService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class SepetService implements ICrudService<Sepet,Long> {
    private final SepetRepository sepetRepository;
    private final KullaniciService kullaniciService;
    private final UrunService urunService;


    @Override
    public Sepet save(Sepet sepet) {
        Sepet sepet1 = sepetRepository.save(sepet);
        if (sepet1 != null) {
            return sepet1;
        }
        throw new TryMeAppException(ErrorType.BAD_REQUEST);
    }

    @Override
    public Sepet update(Sepet sepet) {
        return sepetRepository.saveAndFlush(sepet);
    }

    @Override
    public Iterable<Sepet> saveAll(Iterable<Sepet> t) {
        return sepetRepository.saveAll(t);
    }

    @Override
    public void deleteById(Long aLong) {
        sepetRepository.deleteById(aLong);
    }

    @Override
    public Optional<Sepet> findById(Long aLong) {
        Optional<Sepet> sepet = sepetRepository.findById(aLong);
        if (sepet.isEmpty()){
            throw new TryMeAppException(ErrorType.ENTITY_NOT_FOUND,"Sepet bulunamadı.");
        }
        return sepet;
    }

    @Override
    public List<Sepet> findAll() {
        return sepetRepository.findAll();
    }

    public Sepet addUrun(Long urunId){
        Optional<Urun> urun = urunService.findById(urunId);
        if (urun.isEmpty()){
            throw new TryMeAppException(ErrorType.ENTITY_NOT_FOUND,"Ürün bulunamadı.");
        }
        if (kullaniciService.aktifKullanici==null){
            throw new TryMeAppException(ErrorType.ENTITY_NOT_FOUND,"Kullanıcı bulunamadı.Sepete ürün eklemek için kullanıcı girişi yapmalısınız.");
        }

      sepetRepository.findById(kullaniciService.aktifKullanici.getSepetId()).get().setUrunler(List.of(urun.get().getId()));

        return sepetRepository.findById(kullaniciService.aktifKullanici.getSepetId()).get();
    }
}