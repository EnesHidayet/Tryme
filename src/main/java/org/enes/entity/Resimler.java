package org.enes.entity;

import jakarta.persistence.*;
import lombok.*;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "tbl_resimler")
public class Resimler {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String anaResimUrl;
    private String digerResimUrl1;
    private String digerResimUrl2;
    private String digerResimUrl3;
}
