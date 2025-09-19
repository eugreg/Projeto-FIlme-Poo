package com.projeto.poo.repository;

import com.projeto.poo.entity.VideoEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface VideoRepository extends JpaRepository<VideoEntity, Long> {
    VideoEntity findByTitulo(String titulo);

    List<VideoEntity> findByCategoriaNameOrderByTitulo(String nameCategoria);

}
