package com.projeto.poo.service;

import com.projeto.poo.entity.PerfilEntity;
import com.projeto.poo.entity.VideoEntity;
import com.projeto.poo.entity.VisualizacaoEntity;
import com.projeto.poo.repository.PerfilRepository;
import com.projeto.poo.repository.VideoRepository;
import com.projeto.poo.repository.VisualizacaoRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Scanner;

@Service
@Transactional
public class VisualizacaoService {

    private final VideoRepository videoRepository;
    private final PerfilRepository perfilRepository;
    private final VisualizacaoRepository visualizacaoRepository;

    public VisualizacaoService(
            VideoRepository videoRepository,
            PerfilRepository perfilRepository,
            VisualizacaoRepository visualizacaoRepository) {
        this.videoRepository = videoRepository;
        this.perfilRepository = perfilRepository;
        this.visualizacaoRepository = visualizacaoRepository;
    }

    public void salvarVisualizacao() {
        Scanner scanner = new Scanner(System.in);

        List<VideoEntity> videoEntities = videoRepository.findAll();
        System.out.println(videoEntities);

        System.out.println("Digite o ID do vídeo que está sendo assistido:");
        Long videoId = Long.valueOf(scanner.nextLine());
        VideoEntity video = videoRepository.findById(videoId).orElse(null);

        if (video == null) {
            System.out.println("Vídeo não encontrado.");
            return;
        }

        List<PerfilEntity> perfilEntities = perfilRepository.findAll();
        System.out.println(perfilEntities);
        
        System.out.println("Digite o ID do perfil que está assistindo:");
        Long perfilId = Long.valueOf(scanner.nextLine());
        PerfilEntity perfil = perfilRepository.findById(perfilId).orElse(null);

        if (perfil == null) {
            System.out.println("Perfil não encontrado.");
            return;
        }

        System.out.println("Digite o progresso da visualização (em porcentagem, 0 a 100):");
        Long progresso = Long.valueOf(scanner.nextLine());

        VisualizacaoEntity visualizacao = new VisualizacaoEntity();
        visualizacao.setDataHora(LocalDateTime.now());
        visualizacao.setProgresso(progresso);
        visualizacao.setVideo(video);
        visualizacao.setPerfil(perfil);

        visualizacaoRepository.save(visualizacao);

        System.out.println("Visualização salva com sucesso!");
    }
}
