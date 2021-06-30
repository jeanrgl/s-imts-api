package com.projetoWEG.api.model.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.projetoWEG.domain.model.Consultor;
import com.projetoWEG.domain.model.StatusProjeto;
import lombok.*;
import lombok.experimental.FieldDefaults;

import javax.persistence.*;
import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter

public class ProjetoFornecedorDTO {

    @Column(name = "id_projeto")
    Long id;

    @Column(name = "secao_projeto")
    String secao;
    @Column(name = "nome_projeto")
    String nome;

    @Column(name = "descricao_projeto")
    String descricao;

    List<ConsultorDTO> consultores;

    @Column(name = "status_projeto")
    StatusProjeto status;


    String data_inicio;

    String data_fim;

    int horas_apontadas;

   int horas_total;

}
