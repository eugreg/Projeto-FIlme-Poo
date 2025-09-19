package com.projeto.poo.repository;

import com.projeto.poo.entity.VideoEntity;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;


import java.util.List;

@Repository
public interface VideoRepository extends JpaRepository<VideoEntity, Long> {
    VideoEntity findByTitulo(String titulo);

    List<VideoEntity> findByCategoriaNameOrderByTitulo(String nameCategoria);

    @Query("SELECT v FROM VideoEntity v LEFT JOIN v.visualizacao vis GROUP BY v.id ORDER BY COUNT(vis) DESC")
    List<VideoEntity> findTop10ByVisualizacoes(Pageable pageable);

    @Query("SELECT v FROM VideoEntity v LEFT JOIN v.avaliacao vis GROUP BY v.id ORDER BY COUNT(vis) DESC ")
    List<VideoEntity>findTop10ByAvaliacao(Pageable page);



}
