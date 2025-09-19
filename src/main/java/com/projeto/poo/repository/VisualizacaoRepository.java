package com.projeto.poo.repository;

import com.projeto.poo.entity.UsuarioEntity;
import com.projeto.poo.entity.VisualizacaoEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface VisualizacaoRepository extends JpaRepository<VisualizacaoEntity, Long> {
    @Query("SELECT v.perfil.usuario " +
            "FROM VisualizacaoEntity v " +
            "GROUP BY v.perfil.usuario " +
            "ORDER BY COUNT(v) DESC")
    List<UsuarioEntity> findUsuariosMaisAtivos();
}