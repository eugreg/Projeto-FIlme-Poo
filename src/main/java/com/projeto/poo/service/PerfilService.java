package com.projeto.poo.service;

import com.projeto.poo.entity.PerfilEntity;
import com.projeto.poo.entity.UsuarioEntity;
import com.projeto.poo.repository.PerfilRepository;
import com.projeto.poo.repository.UsuarioRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Scanner;

@Service
@Transactional
public class PerfilService {

    private final PerfilRepository perfilRepository;
    private final UsuarioRepository usuarioRepository;

    // Injeção via construtor (recomendado)
    public PerfilService(PerfilRepository perfilRepository, UsuarioRepository usuarioRepository) {
        this.perfilRepository = perfilRepository;
        this.usuarioRepository = usuarioRepository;
    }

    public void salvarPerfil() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Digite o nome do perfil:");
        String nomePerfil = scanner.nextLine();

        List<UsuarioEntity> usuarios = usuarioRepository.findAll();
        System.out.println("Usuários disponíveis: ");
        for (UsuarioEntity usuario : usuarios) {
            System.out.println(usuario.getId() + " - " + usuario.getName()); // ou qualquer outro atributo relevante
        }

        System.out.println("Digite o ID do usuário para associar ao perfil:");
        Long usuarioId = Long.valueOf(scanner.nextLine());

        UsuarioEntity usuarioSelecionado = usuarioRepository.findById(usuarioId).orElse(null);

        PerfilEntity perfil = new PerfilEntity();
        perfil.setNomePerfil(nomePerfil);
        perfil.setUsuario(usuarioSelecionado);

        perfilRepository.save(perfil);

        System.out.println("Perfil salvo com sucesso!");
    }
}
