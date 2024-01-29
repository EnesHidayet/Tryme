package org.enes.repository;

import org.enes.entity.Urun;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UrunRepository extends JpaRepository<Urun, Long> {
}
