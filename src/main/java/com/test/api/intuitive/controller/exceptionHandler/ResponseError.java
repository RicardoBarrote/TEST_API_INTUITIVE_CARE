package com.test.api.intuitive.controller.exceptionHandler;

import lombok.*;

import java.io.Serial;
import java.io.Serializable;
import java.time.Instant;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
@ToString
public class ResponseError implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;

    private String mensagem;
    private int status;
    private Instant data_hora;

}
