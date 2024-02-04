package org.enes.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

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
    private String aciklama;
    private Double fiyat;
    private Integer stok;
    private String anaResimUrl;
    @Builder.Default
    private boolean satistaMi = true;

    private Long markaId;

    private Long modelId;

    private Long kategoriId;

    private Long altKategoriId;

    @ElementCollection
    private List<Long> resim;

    private Long urunOzellikleriId;
}
