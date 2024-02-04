package org.enes.mapper;

import org.enes.entity.Kullanici;
import org.enes.dto.request.UserSaveRequestDto;
import org.enes.dto.response.UserSaveResponseDto;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring",unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface KullaniciMapper {
    KullaniciMapper INSTANCE = Mappers.getMapper(KullaniciMapper.class);

    Kullanici fromRequestDto(UserSaveRequestDto dto);
    UserSaveResponseDto fromResponseDto(Kullanici kullanici);
}
