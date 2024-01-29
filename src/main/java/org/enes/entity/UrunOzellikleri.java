package org.enes.entity;

import jakarta.persistence.*;
import lombok.*;
import org.enes.entity.enums.Beden;
import org.enes.entity.enums.Cinsiyet;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "tbl_urun_ozellikleri")
public class UrunOzellikleri {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne
    private Marka marka;

    @OneToOne
    private Kategori kategori;

    private Beden beden;
    private Cinsiyet cinsiyet;
}
