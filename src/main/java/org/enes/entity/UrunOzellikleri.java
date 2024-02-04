package org.enes.entity;

import jakarta.persistence.*;
import lombok.*;
import org.enes.utility.enums.EBeden;
import org.enes.utility.enums.ECinsiyet;

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
    private String kumasTipi;
    @Builder.Default
    private boolean desenliMi=false;
    private String kumasRengi;
    private String aciklama;
    private boolean geriDonusturulebilirMi;

    @Enumerated
    private EBeden beden;
    @Enumerated
    private ECinsiyet cinsiyet;
}
