package com.projeto.poo.entity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Locale;

@Entity
@AllArgsConstructor
@NoArgsConstructor
public class VideoEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String titulo;

    private String descricao;

    private Long duracao;

    public Long getId() {
        return id;
    }

    public String getTitulo() {
        return titulo;
    }

    public String getDescricao() {
        return descricao;
    }

    public Long getDuracao() {
        return duracao;
    }

    public CategoriaEntity getCategoria() {
        return categoria;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public void setDuracao(Long duracao) {
        this.duracao = duracao;
    }

    public void setCategoria(CategoriaEntity categoria) {
        this.categoria = categoria;
    }

    ///-----------Relacionamentos------------


    @ManyToOne(fetch = FetchType.LAZY)
    private CategoriaEntity categoria;

    @OneToMany(mappedBy = "video", fetch = FetchType.LAZY)
    private List<VisualizacaoEntity> visualizacao;

    @OneToMany(mappedBy = "video", fetch = FetchType.LAZY)
    private List<AvaliacaoEntity> avaliacao;

    @Override
    public String toString() {
        return "VideoEntity{" +
                "id=" + id +
                ", titulo='" + titulo + '\'' +
                ", descricao='" + descricao + '\'' +
                ", duracao=" + duracao +
                ", categoria=" + categoria +
                '}';
    }
}
