package com.projeto.poo.repository;

import com.projeto.poo.entity.VisualizacaoEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VisualizacaoRepository extends JpaRepository<VisualizacaoEntity, Long> {
}