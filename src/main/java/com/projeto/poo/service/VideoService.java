package com.projeto.poo.service;

import com.projeto.poo.entity.CategoriaEntity;
import com.projeto.poo.entity.VideoEntity;
import com.projeto.poo.repository.CategoriaRepository;
import com.projeto.poo.repository.VideoRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Scanner;

@Service
@Transactional
public class VideoService {

    private final CategoriaRepository categoriaRepository;
    private final VideoRepository videoRepository;

    // Injeção via construtor (recomendado)
    public VideoService(CategoriaRepository categoriaRepository, VideoRepository videoRepository) {
        this.categoriaRepository = categoriaRepository;
        this.videoRepository = videoRepository;
    }

    public void salvarVideo(){
        Scanner scanner = new Scanner(System.in);

        System.out.println("Digite o título do vídeo:");
        String titulo = scanner.nextLine();

        List<CategoriaEntity> categorias = categoriaRepository.findAll();
        System.out.println("Categorias disponíveis: " + categorias);

        System.out.println("Digite o ID da categoria:");
        Long categoriaId = Long.valueOf(scanner.nextLine()); // use nextLine para evitar problema após nextInt()

        CategoriaEntity categoriaSelecionada = categoriaRepository.findById(categoriaId).orElse(null);

        System.out.println("Digite a descrição do vídeo:");
        String descricao = scanner.nextLine();

        VideoEntity video = new VideoEntity();
        video.setTitulo(titulo);
        video.setCategoria(categoriaSelecionada);
        video.setDescricao(descricao);

        videoRepository.save(video);

        System.out.println("Vídeo salvo com sucesso!");
    }
}
