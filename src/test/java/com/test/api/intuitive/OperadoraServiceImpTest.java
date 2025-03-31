package com.test.api.intuitive;


import com.test.api.intuitive.business.mapstruct.OperadoraMapStruct;
import com.test.api.intuitive.business.service.imp.OperadoraServiceImp;
import com.test.api.intuitive.controller.dto.OperadoraResponseDto;
import com.test.api.intuitive.infrastructure.model.Operadora;
import com.test.api.intuitive.infrastructure.repository.OperadoraRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.mock.web.MockMultipartFile;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class OperadoraServiceImpTest {

    @Mock
    private OperadoraRepository repository;

    @Mock
    private OperadoraMapStruct mapStruct;

    @InjectMocks
    private OperadoraServiceImp service;

    private Operadora operadora;
    private OperadoraResponseDto operadoraResponseDto;

    @BeforeEach
    void setUp() {
        operadora = new Operadora();
        operadora.setCnpj("12345678000100");
        operadora.setRazaoSocial("Operadora Teste");

        operadoraResponseDto = new OperadoraResponseDto(
                "1234", "12345678000100", "Operadora Teste", "Fantasia Teste",
                "Modalidade", "Logradouro", "123", "Complemento", "Bairro",
                "Cidade", "UF", "12345-678", "11", "1234-5678", "1234-5679",
                "email@test.com", "Representante", "Cargo", "Região", "2024-03-31"
        );
    }


    @Test
    void testListar() {
        when(repository.findAll()).thenReturn(List.of(operadora));
        when(mapStruct.toListResponseDto(anyList())).thenReturn(List.of(operadoraResponseDto));

        List<OperadoraResponseDto> result = service.listar();

        assertNotNull(result);
        assertEquals(1, result.size());
        verify(repository, times(1)).findAll();
        verify(mapStruct, times(1)).toListResponseDto(anyList());
    }

    @Test
    void testBuscarPorCnpj() {
        String cnpj = "12345678000100";
        when(repository.findByCnpj(cnpj)).thenReturn(List.of(operadora));
        when(mapStruct.toListResponseDto(anyList())).thenReturn(List.of(operadoraResponseDto));

        List<OperadoraResponseDto> result = service.buscarPorCnpj(cnpj);

        assertNotNull(result);
        assertEquals(1, result.size());
        verify(repository, times(1)).findByCnpj(cnpj);
        verify(mapStruct, times(1)).toListResponseDto(anyList());
    }

    @Test
    void testBuscarPorRazaoSocial() {
        String razaoSocial = "Operadora Teste";
        when(repository.findByRazaoSocialContainingIgnoreCase(razaoSocial)).thenReturn(List.of(operadora));
        when(mapStruct.toListResponseDto(anyList())).thenReturn(List.of(operadoraResponseDto));

        List<OperadoraResponseDto> result = service.buscarPorRazaoSocial(razaoSocial);

        assertNotNull(result);
        assertEquals(1, result.size());
        verify(repository, times(1)).findByRazaoSocialContainingIgnoreCase(razaoSocial);
        verify(mapStruct, times(1)).toListResponseDto(anyList());
    }

    @Test
    void testArquivoCsv() throws IOException {
        String csvContent = "RegistroAns;Cnpj;RazaoSocial;NomeFantasia;Modalidade;Logradouro;Numero;Complemento;Bairro;Cidade;Uf;Cep;Ddd;Telefone;Fax;EnderecoEletronico;Representante;CargoRepresentante;RegiaoDeComercializacao;DataRegistroAns\n"
                + "1234;12345678000100;Operadora Teste;Fantasia Teste;Modalidade;Logradouro;123;Complemento;Bairro;Cidade;UF;12345-678;11;1234-5678;1234-5679;email@test.com;Representante;Cargo;Região;2024-03-31\n";

        MultipartFile file = new MockMultipartFile("file.csv", "file.csv", "text/csv", csvContent.getBytes());

        service.arquivoCsv(file);

        verify(repository, times(1)).save(any(Operadora.class));
    }

}
