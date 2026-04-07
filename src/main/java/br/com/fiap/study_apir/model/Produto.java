package br.com.fiap.study_apir.model;

import java.math.BigDecimal;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Produto {
    private Long id;
    private String nome;
    private BigDecimal valor;
}