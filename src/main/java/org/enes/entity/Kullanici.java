package org.enes.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import lombok.*;
import org.enes.utility.enums.ECinsiyet;
import org.enes.utility.enums.EStatus;

import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "tbl_kullanici")
public class Kullanici {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(length = 50)
    private String ad;
    @Column(length = 50)
    private String soyad;
    @Column(length = 50)
    private String kullaniciAdi;
    @Column(length = 50)
    @Email
    private String email;
    @Column(length = 32)
    private String password;
    @Column(length = 32)
    private String rePassword;
    @Column(length = 15)
    private String telefon;
    @Enumerated
    @Builder.Default
    private EStatus status=EStatus.PENDING;
    @Enumerated
    private ECinsiyet cinsiyet;
    private String anaResimUrl;

    private Long sepetId;

    @ElementCollection
    private List<Long> adresler;

    @ElementCollection
    private List<Long> resimler;
}
