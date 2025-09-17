package com.projeto.poo.entity;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Locale;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class VisualizacaoEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private LocalDateTime dataHora;

    private Long progresso;


    ///-----------Relacionamentos------------

    @ManyToOne(fetch = FetchType.LAZY)
    private VideoEntity video;

    @ManyToOne(fetch = FetchType.LAZY)
    private PerfilEntity perfil;


}
