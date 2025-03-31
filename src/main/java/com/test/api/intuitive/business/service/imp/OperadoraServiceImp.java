package com.test.api.intuitive.business.service.imp;

import com.test.api.intuitive.business.mapstruct.OperadoraMapStruct;
import com.test.api.intuitive.business.service.IOperadoraService;
import com.test.api.intuitive.controller.dto.OperadoraResponseDto;
import com.test.api.intuitive.infrastructure.logger.LoggerSlf4j;
import com.test.api.intuitive.infrastructure.model.Operadora;
import com.test.api.intuitive.infrastructure.repository.OperadoraRepository;
import jakarta.transaction.Transactional;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.*;
import java.util.List;

@Service
public class OperadoraServiceImp implements IOperadoraService, LoggerSlf4j {
    public static final String OPERADORA_CACHE = "operadoras";

    private final OperadoraRepository repository;
    private final OperadoraMapStruct mapStruct;

    public OperadoraServiceImp(OperadoraRepository repository, OperadoraMapStruct mapStruct) {
        this.repository = repository;
        this.mapStruct = mapStruct;
    }

    @Override
    @Cacheable(value = OPERADORA_CACHE)
    public List<OperadoraResponseDto> listar() {
        LOGGER().info("Retornando uma lista de Operadora");
        return mapStruct.toListResponseDto(repository.findAll());
    }

    @Override
    @Cacheable(value = OPERADORA_CACHE, key = "#cnpj")
    public List<OperadoraResponseDto> buscarPorCnpj(String cnpj) {
        LOGGER().info("Retornando consultas pelo CNPJ: {}", cnpj);
        return mapStruct.toListResponseDto(repository.findByCnpj(cnpj));
    }

    @Override
    @Cacheable(value = OPERADORA_CACHE, key = "#razaoSocial")
    public List<OperadoraResponseDto> buscarPorRazaoSocial(String razaoSocial) {
        LOGGER().info("Retornando consultas pela RAZÃO SOCIAL: {}", razaoSocial);
        return mapStruct.toListResponseDto(repository.findByRazaoSocialContainingIgnoreCase(razaoSocial));
    }


    @Override
    @Transactional
    public void arquivoCsv(MultipartFile file) {

        try (BufferedReader br = new BufferedReader(new InputStreamReader(file.getInputStream()))) {
            LOGGER().info("Bloco try - método arquivo.csv: {}", file.getName());
            String linha;
            br.readLine();

            while ((linha = br.readLine()) != null) {
                String[] campos = linha.replace("\"", "").split(";");
                Operadora operadora = new Operadora();

                operadora.setRegistroAns(campos[0]);
                operadora.setCnpj(campos[1]);
                operadora.setRazaoSocial(campos[2]);
                operadora.setNomeFantasia(campos[3]);
                operadora.setModalidade(campos[4]);
                operadora.setLogradouro(campos[5]);
                operadora.setNumero(campos[6]);
                operadora.setComplemento(campos[7]);
                operadora.setBairro(campos[8]);
                operadora.setCidade(campos[9]);
                operadora.setUf(campos[10]);
                operadora.setCep(campos[11]);
                operadora.setDdd(campos[12]);
                operadora.setTelefone(campos[13]);
                operadora.setFax(campos[14]);
                operadora.setEnderecoEletronico(campos[15]);
                operadora.setRepresentante(campos[16]);
                operadora.setCargoRepresentante(campos[17]);
                operadora.setRegiaoDeComercializacao(campos[18]);
                operadora.setDataRegistroAns(campos[19]);

                repository.save(operadora);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

