package com.test.api.intuitive.infrastructure.model;

import jakarta.persistence.*;
import lombok.*;

import java.io.Serial;
import java.io.Serializable;
import java.util.UUID;

@Entity
@Table(name = "tb_operadora")
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter
@Setter
@ToString
@EqualsAndHashCode(of = "id")
public class Operadora implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @Column(nullable = false)
    private String registroAns;

    @Column(unique = true, nullable = false)
    private String cnpj;

    @Column(nullable = false)
    private String razaoSocial;

    private String nomeFantasia;

    @Column(nullable = false)
    private String modalidade;

    @Column(nullable = false)
    private String logradouro;

    private String numero;

    private String complemento;

    @Column(nullable = false)
    private String bairro;

    @Column(nullable = false)
    private String cidade;

    @Column(nullable = false)
    private String uf;

    @Column(nullable = false)
    private String cep;

    private String ddd;

    private String telefone;

    private String fax;

    private String enderecoEletronico;

    @Column(nullable = false)
    private String representante;

    @Column(nullable = false)
    private String cargoRepresentante;

    private String regiaoDeComercializacao;

    private String dataRegistroAns;
}
