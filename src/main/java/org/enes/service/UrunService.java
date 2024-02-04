package org.enes.service;

import lombok.RequiredArgsConstructor;
import org.enes.entity.Urun;
import org.enes.exception.ErrorType;
import org.enes.exception.TryMeAppException;
import org.enes.repository.UrunOzellikleriRepository;
import org.enes.repository.UrunRepository;
import org.enes.utility.ICrudService;
import org.enes.utility.enums.EBeden;
import org.enes.utility.enums.ECinsiyet;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UrunService implements ICrudService<Urun,Long> {
    private final UrunRepository urunRepository;
    private final UrunOzellikleriRepository urunOzellikleriRepository;


    @Override
    public Urun save(Urun urun) {
        Urun urun1 = urunRepository.save(urun);
        if (urun1 != null) {
            return urun1;
        }
        throw new TryMeAppException(ErrorType.BAD_REQUEST);
    }

    @Override
    public Urun update(Urun urun) {
        return urunRepository.save(urun);
    }

    @Override
    public Iterable<Urun> saveAll(Iterable<Urun> t) {
        return urunRepository.saveAll(t);
    }

    @Override
    public void deleteById(Long aLong) {
        urunRepository.deleteById(aLong);
    }

    @Override
    public Optional<Urun> findById(Long aLong) {
        Optional<Urun> urun = urunRepository.findById(aLong);
        if (urun.isEmpty()){
            throw new TryMeAppException(ErrorType.ENTITY_NOT_FOUND,"Ürün bulunamadı.");
        }
        return urun;
    }

    @Override
    public List<Urun> findAll() {
        return urunRepository.findAll();
    }


    public List<Urun> findByUrunAdiContainingIgnoreCase(String urunAdi){
        List<Urun> uruns = urunRepository.findByUrunAdiContainingIgnoreCase(urunAdi);
        if (uruns.isEmpty()){
            throw new TryMeAppException(ErrorType.ENTITY_NOT_FOUND,"Aranılan isimde ürün bulunamadı.");
        }
        return uruns;
    }

    public List<Urun> findAllByFiyatBetween(Double min, Double max){
        List<Urun> uruns = urunRepository.findAllByFiyatBetween(min, max);
        if (uruns.isEmpty()){
            throw new TryMeAppException(ErrorType.ENTITY_NOT_FOUND,"Aranılan fiyat aralığında ürün bulunamadı.");
        }
        return uruns;
    }

    public List<Urun> findAllByMarkaId(Long id){
        List<Urun> uruns = urunRepository.findAllByMarkaId(id);
        if (uruns.isEmpty()){
            throw new TryMeAppException(ErrorType.ENTITY_NOT_FOUND,"Aranılan markaya uygun ürün bulunamadı.");
        }
        return uruns;
    }

    public List<Urun> findAllByModelId(Long id){
        List<Urun> uruns = urunRepository.findAllByModelId(id);
        if (uruns.isEmpty()){
            throw new TryMeAppException(ErrorType.ENTITY_NOT_FOUND,"Aranılan modela uygun ürün bulunamadı.");
        }
        return uruns;
    }

    public List<Urun> findAllByAltKategoriId(Long id){
        List<Urun> uruns = urunRepository.findAllByAltKategoriId(id);
        if (uruns.isEmpty()){
            throw new TryMeAppException(ErrorType.ENTITY_NOT_FOUND,"Aranılan alt kategoride ürün bulunamadı.");
        }
        return uruns;
    }

    public List<Urun> findAllByKategoriId(Long id){
        List<Urun> uruns = urunRepository.findAllByKategoriId(id);
        if (uruns.isEmpty()){
            throw new TryMeAppException(ErrorType.ENTITY_NOT_FOUND,"Aranılan kategoride ürün bulunamadı.");
        }
        return uruns;
    }

    public List<Urun> findAllByOzelliklerCinsiyet(ECinsiyet cinsiyet){
        List<Urun> urunler = new ArrayList<>();
         urunOzellikleriRepository.findAllByCinsiyet(cinsiyet).forEach(x->{
             Optional<Urun> urun = urunRepository.findAllByUrunOzellikleriId(x.getId());
             if (urun.isEmpty()){
                 throw new TryMeAppException(ErrorType.ENTITY_NOT_FOUND,"Aranılan cinsiyete uygun ürün bulunamadı.");
             }else {
                 urunler.add(urun.get());
             }
         });

        return urunler;
    }

    public List<Urun> findAllByOzelliklerCinsiyetAndOzelliklerBeden(ECinsiyet cinsiyet, EBeden beden){
        List<Urun> urunler = new ArrayList<>();
        urunOzellikleriRepository.findAllByBedenAndCinsiyet(beden, cinsiyet).forEach(x->{
            Optional<Urun> urun = urunRepository.findAllByUrunOzellikleriId(x.getId());
            if (urun.isEmpty()){
                throw new TryMeAppException(ErrorType.ENTITY_NOT_FOUND,"Aranılan cinsiyete ve bedene uygun ürün bulunamadı.");
            }else {
                urunler.add(urun.get());
            }
        });
        return urunler;
    }

    public List<Urun> findAllByOzelliklerBeden(EBeden beden){
        List<Urun> uruns=new ArrayList<>();
        urunOzellikleriRepository.findAllByBeden(beden).forEach(x->{
            Optional<Urun> urun =urunRepository.findAllByUrunOzellikleriId(x.getId());
            if (urun.isEmpty()){
                throw new TryMeAppException(ErrorType.ENTITY_NOT_FOUND,"Aranılan bedende ürün bulunamadı.");
            }else {
                uruns.add(urun.get());
            }
        });
        return uruns;
    }
}
