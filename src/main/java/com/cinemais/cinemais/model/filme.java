package com.cinemais.cinemais.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import java.time.LocalDate;
import lombok.Data;

@Data
@Entity
@Table(name="filme")
public class filme {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    
    @NotBlank
    @Size(min=2, message="Por favor o titulo deve conter no mínimo 2 caracteres")
    private String titulo;
    private String sinopse;
    private String genero;
    private LocalDate anoLancamento;

}
