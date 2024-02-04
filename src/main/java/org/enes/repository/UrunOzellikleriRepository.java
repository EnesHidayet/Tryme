package org.enes.repository;

import org.apache.catalina.LifecycleState;
import org.enes.entity.Urun;
import org.enes.entity.UrunOzellikleri;
import org.enes.utility.enums.EBeden;
import org.enes.utility.enums.ECinsiyet;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UrunOzellikleriRepository extends JpaRepository<UrunOzellikleri, Long> {

    List<UrunOzellikleri> findAllByBeden(EBeden beden);
    List<UrunOzellikleri> findAllByCinsiyet(ECinsiyet cinsiyet);

    List<UrunOzellikleri> findAllByBedenAndCinsiyet(EBeden beden, ECinsiyet cinsiyet);

}
