package com.test.api.intuitive.controller;

import com.test.api.intuitive.business.service.imp.OperadoraServiceImp;
import com.test.api.intuitive.controller.dto.OperadoraResponseDto;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@RestController
@RequestMapping(value = "/operadoras")
public class OperadoraController {

    private final OperadoraServiceImp serviceImp;

    public OperadoraController(OperadoraServiceImp serviceImp) {
        this.serviceImp = serviceImp;
    }

    @PostMapping(value = "/importar")
    public ResponseEntity<String> arquivoCsv(@RequestParam(value = "file") MultipartFile file) {
        serviceImp.arquivoCsv(file);
        return ResponseEntity.status(HttpStatus.OK).body("Arquivo persistido com sucesso!");
    }

    @GetMapping
    public ResponseEntity<List<OperadoraResponseDto>> listar() {
        return ResponseEntity.status(HttpStatus.OK).body(serviceImp.listar());
    }

    @GetMapping(value = "/cnpj")
    public ResponseEntity<List<OperadoraResponseDto>> listarPorCnpj(@RequestParam(value = "cnpj", required = false) String cnpj) {
        return ResponseEntity.status(HttpStatus.OK).body(serviceImp.buscarPorCnpj(cnpj));
    }

    @GetMapping(value = "/razaoSocial")
    public ResponseEntity<List<OperadoraResponseDto>> listarPorRazaoSocial(@RequestParam(value = "razaoSocial", required = false) String razaoSocial) {
        return ResponseEntity.status(HttpStatus.OK).body(serviceImp.buscarPorRazaoSocial(razaoSocial));
    }

}
