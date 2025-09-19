package com.projeto.poo.service;

import com.projeto.poo.entity.UsuarioEntity;
import com.projeto.poo.repository.UsuarioRepository;
import com.projeto.poo.repository.VisualizacaoRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Scanner;

@Service
@Transactional
public class UsuarioService {

    private final UsuarioRepository usuarioRepository;
    private final VisualizacaoRepository visualizacaoRepository;

    // Injeção via construtor (recomendado)
    public UsuarioService(UsuarioRepository usuarioRepository, VisualizacaoRepository visualizacaoRepository) {
        this.usuarioRepository = usuarioRepository;
        this.visualizacaoRepository = visualizacaoRepository;
    }

    public void salvarUsuario() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Digite o nome do usuário:");
        String nome = scanner.nextLine();

        System.out.println("Digite o email do usuário:");
        String email = scanner.nextLine();

        System.out.println("Digite a senha do usuário:");
        String senha = scanner.nextLine();

        System.out.println("Digite a data de cadastro (formato: yyyy-MM-dd):");
        String dataCadastroStr = scanner.nextLine();

        LocalDate dataCadastro = LocalDate.parse(dataCadastroStr); // Convertendo a data de String para LocalDate

        // Criando a entidade
        UsuarioEntity usuario = new UsuarioEntity();
        usuario.setName(nome);
        usuario.setEmail(email);
        usuario.setSenha(senha);
        usuario.setData_cadastro(dataCadastro);

        // Salvando o usuário no banco
        usuarioRepository.save(usuario);

        System.out.println("Usuário salvo com sucesso!");
    }

    public void usuarioQueMaisAssistiu() {
        List<UsuarioEntity> usuarios = visualizacaoRepository.findUsuariosMaisAtivos();

        if (!usuarios.isEmpty()) {
            System.out.println(usuarios.get(0));
        }

    }
}
