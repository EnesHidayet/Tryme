package org.enes.dto.response;

import lombok.*;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class UserSaveResponseDto {
    String kullaniciAdi;
    String email;
}
