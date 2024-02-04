package org.enes.service;

import lombok.RequiredArgsConstructor;
import org.enes.entity.Kullanici;
import org.enes.dto.request.UserLoginRequestDto;
import org.enes.dto.request.UserSaveRequestDto;
import org.enes.dto.response.UserSaveResponseDto;
import org.enes.entity.Sepet;
import org.enes.exception.ErrorType;
import org.enes.exception.TryMeAppException;
import org.enes.repository.SepetRepository;
import org.enes.utility.ICrudService;
import org.enes.utility.enums.EStatus;
import org.enes.mapper.KullaniciMapper;
import org.enes.repository.KullaniciRepository;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
@RequiredArgsConstructor
public class KullaniciService implements ICrudService<Kullanici,Long> {
    private final KullaniciRepository kullaniciRepository;
    private final SepetRepository sepetRepository;
    public static Kullanici aktifKullanici;

    @Override
    public Kullanici save(Kullanici kullanici) {
        return kullaniciRepository.save(kullanici);
    }

    @Override
    public Kullanici update(Kullanici kullanici) {
        return kullaniciRepository.save(kullanici);
    }

    @Override
    public Iterable<Kullanici> saveAll(Iterable<Kullanici> t) {
        return kullaniciRepository.saveAll(t);
    }

    @Override
    public void deleteById(Long aLong) {
        kullaniciRepository.deleteById(aLong);
    }

    @Override
    public Optional<Kullanici> findById(Long aLong) {
        return kullaniciRepository.findById(aLong);
    }

    @Override
    public List<Kullanici> findAll() {
        return kullaniciRepository.findAll();
    }


    public UserSaveResponseDto register( UserSaveRequestDto dto){
        if (!dto.getPassword().equals(dto.getRePassword())){
            System.out.println("şifreler uyuşmuyor.");
            throw new TryMeAppException(ErrorType.BAD_REQUEST,"Şifre ve Tekrarı aynı olmalıdır.");
        }

        if (kullaniciRepository.findByEmail(dto.getEmail())){
            throw new TryMeAppException(ErrorType.BAD_REQUEST,"Mail adresi kullanılmaktadır.");
        }

        Kullanici kullanici = KullaniciMapper.INSTANCE.fromRequestDto(dto);
        kullaniciRepository.save(kullanici);

        return  KullaniciMapper.INSTANCE.fromResponseDto(kullanici);
    }

    public UserSaveResponseDto login( UserLoginRequestDto dto){
        Optional<Kullanici> kullanici = kullaniciRepository.findByEmailAndPassword(dto.getEmail(),dto.getPassword());
        if (kullanici.isEmpty()){
            throw new TryMeAppException(ErrorType.LOGIN_ERROR,"Kullanıcı adı veya şifre hatalıdır.");
        }
            aktifKullanici = kullanici.get();
        return KullaniciMapper.INSTANCE.fromResponseDto(kullanici.get());
    }


    public Kullanici delete(Long id) {
        Optional<Kullanici> kullanici=kullaniciRepository.findById(id);
        if (kullanici.isEmpty()){
            throw new TryMeAppException(ErrorType.USER_NOT_FOUND,"Silinmek istenen kullanıcı bulunamadı.");
        }
        kullanici.get().setStatus(EStatus.INACTIVE);
        return kullaniciRepository.save(kullanici.get());
    }
}
