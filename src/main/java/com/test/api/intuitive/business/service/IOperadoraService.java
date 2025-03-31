package com.test.api.intuitive.business.service;

import com.test.api.intuitive.controller.dto.OperadoraResponseDto;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public interface IOperadoraService {

    List<OperadoraResponseDto> listar();

    List<OperadoraResponseDto> buscarPorCnpj(String cnpj);

    List<OperadoraResponseDto> buscarPorRazaoSocial(String razaoSocial);

    void arquivoCsv(MultipartFile file);
}
