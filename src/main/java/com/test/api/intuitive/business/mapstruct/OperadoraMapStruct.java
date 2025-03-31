package com.test.api.intuitive.business.mapstruct;

import com.test.api.intuitive.controller.dto.OperadoraResponseDto;
import com.test.api.intuitive.infrastructure.model.Operadora;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingConstants;
import org.mapstruct.ReportingPolicy;

import java.util.List;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING,
        unmappedTargetPolicy = ReportingPolicy.ERROR)
public interface OperadoraMapStruct {

    OperadoraResponseDto toResponseDto(Operadora operadora);

    List<OperadoraResponseDto> toListResponseDto(List<Operadora> operadoras);
}
