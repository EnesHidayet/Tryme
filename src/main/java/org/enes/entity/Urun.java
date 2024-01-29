package org.enes.entity;

import jakarta.persistence.*;
import lombok.*;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "tbl_urun")
public class Urun {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String urunAdi;
    private Double fiyat;
    private Integer stok;

    @OneToOne
    private Resimler resimler;

    @OneToOne
    private UrunOzellikleri ozellikler;
}
