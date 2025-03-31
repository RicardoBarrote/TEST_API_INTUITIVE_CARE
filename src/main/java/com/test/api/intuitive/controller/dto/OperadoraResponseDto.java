package com.test.api.intuitive.controller.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.io.Serial;
import java.io.Serializable;

public record OperadoraResponseDto(@NotNull
                                   @NotBlank
                                   String registroAns,
                                   @NotNull
                                   String cnpj,
                                   @NotNull
                                   @NotBlank
                                   String razaoSocial,
                                   String nomeFantasia,
                                   @NotNull
                                   @NotBlank
                                   String modalidade,
                                   @NotNull
                                   @NotBlank
                                   String logradouro,
                                   String numero,
                                   String complemento,
                                   @NotNull
                                   @NotBlank
                                   String bairro,
                                   @NotNull
                                   @NotBlank
                                   String cidade,
                                   @NotNull
                                   @NotBlank
                                   String uf,
                                   @NotNull
                                   @NotBlank
                                   String cep,
                                   String ddd,
                                   String telefone,
                                   String fax,
                                   @Email
                                   String enderecoEletronico,
                                   @NotNull
                                   @NotBlank
                                   String representante,
                                   @NotNull
                                   @NotBlank
                                   String cargoRepresentante,
                                   String regiaoDeComercializacao,
                                   String dataRegistroAns
) implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;
}
