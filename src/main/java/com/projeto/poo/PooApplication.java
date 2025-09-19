package com.projeto.poo;

import com.projeto.poo.service.*;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import java.util.Scanner;

@SpringBootApplication
public class PooApplication {

	public static void main(String[] args) {
		ApplicationContext context = SpringApplication.run(PooApplication.class, args);

		Scanner scanner = new Scanner(System.in);
		System.out.printf("Deseja Cadastrar(1) ou Consultar(2)");

		int opcao = scanner.nextInt();
		scanner.nextLine();


		if(opcao == 1){
			menuCadastro(context);
		} else{
			consulta(context);
		}



	}

	private static void consulta(ApplicationContext context){
		VideoService videoService = context.getBean(VideoService.class);
		UsuarioService usuarioService = context.getBean(UsuarioService.class);



		Scanner scanner = new Scanner(System.in);

		System.out.println("===== MENU DE CONSULTA =====");
		System.out.println("1 - Buscar Video pelo nome");
		System.out.println("2 - Buscar Video por Categoria");
		System.out.println("3 - Top 10 Mais vistos");
		System.out.println("4 - Top 10 Mais Avaliados");
		System.out.println("5 - Usuario que mais Assitiu");

		int opcao = scanner.nextInt();
		scanner.nextLine();

		switch (opcao){
			case 1:
				videoService.buscarVideoPorNome();
				break;
			case 2:
				videoService.buscarVideoCategoria();
				break;
			case 3:
				videoService.getTop10Videos();
				break;
			case 4:
				videoService.getTop10VideosByAvaliacao();
				break;
			case 5:
				usuarioService.usuarioQueMaisAssistiu();
				break;
		}


	}

	private static void menuCadastro(	ApplicationContext context){
		VideoService videoService = context.getBean(VideoService.class);
		PerfilService perfilService = context.getBean(PerfilService.class);
		UsuarioService usuarioService = context.getBean(UsuarioService.class);
		VisualizacaoService visualizacaoService = context.getBean(VisualizacaoService.class);
		CategoriaService categoriaService = context.getBean(CategoriaService.class);

		Scanner scanner = new Scanner(System.in);

		System.out.println("===== MENU DE CADASTRO =====");
		System.out.println("1 - Cadastrar Vídeo");
		System.out.println("2 - Cadastrar Perfil");
		System.out.println("3 - Cadastrar Usuário");
		System.out.println("4 - Cadastrar Visualização");
		System.out.println("5 - Cadastrar Categoria");
		System.out.println("0 - Sair");
		System.out.print("Escolha uma opção: ");

		int opcao = scanner.nextInt();
		scanner.nextLine(); // limpa o buffer

		switch (opcao) {
			case 1:
				videoService.salvarVideo();
				break;
			case 2:
				perfilService.salvarPerfil();
				break;
			case 3:
				usuarioService.salvarUsuario();
				break;
			case 4:
				visualizacaoService.salvarVisualizacao();
				break;
			case 5:
				categoriaService.salvaCategoria();
				break;
			case 0:
				System.out.println("Encerrando o programa...");
				break;
			default:
				System.out.println("Opção inválida.");
		}

		scanner.close();
	}

}
