package org.enes.repository;

import org.enes.entity.Kullanici;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface KullaniciRepository extends JpaRepository<Kullanici, Long> {

    Optional<Kullanici> findByEmailAndPassword(String email, String password);

    boolean findByEmail(String email);
}
