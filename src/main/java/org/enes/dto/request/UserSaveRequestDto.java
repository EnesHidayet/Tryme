package org.enes.dto.request;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Size;
import org.antlr.v4.runtime.misc.NotNull;
import lombok.*;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class UserSaveRequestDto {
    @NotNull
    @Size(min = 3,max = 64)
    String kullaniciAdi;
    @NotNull
    @Email
    String email;
    @NotNull
    @Size(min = 8)
    String password;
    @NotNull
    @Size(min = 8)
    String rePassword;
}
