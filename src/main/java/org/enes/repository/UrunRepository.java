package org.enes.repository;

import org.enes.entity.Urun;
import org.enes.utility.enums.EBeden;
import org.enes.utility.enums.ECinsiyet;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface UrunRepository extends JpaRepository<Urun, Long> {

    List<Urun> findByUrunAdiContainingIgnoreCase(String urunAdi);

    List<Urun> findAllByFiyatBetween(Double min, Double max);

    List<Urun> findAllByMarkaId(Long id);

    List<Urun> findAllByModelId(Long id);

    List<Urun> findAllByAltKategoriId(Long id);

    List<Urun> findAllByKategoriId(Long id);

    Optional<Urun> findAllByUrunOzellikleriId(Long id);
}
