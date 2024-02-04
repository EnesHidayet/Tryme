package org.enes.entity;

import jakarta.persistence.*;
import lombok.*;
import org.apache.catalina.LifecycleState;

import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "tbl_kategori")
public class Kategori {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String kategoriAdi;

    @ElementCollection
    private List<Long> altKategori;
}
