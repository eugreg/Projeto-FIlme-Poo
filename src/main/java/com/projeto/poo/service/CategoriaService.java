package com.projeto.poo.service;

import com.projeto.poo.entity.CategoriaEntity;
import com.projeto.poo.repository.CategoriaRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.Scanner;

@Service
@Transactional
public class CategoriaService {
    private CategoriaRepository categoriaRepository;

    public CategoriaService(CategoriaRepository categoriaRepository){
        this.categoriaRepository = categoriaRepository;
    }

    public void salvaCategoria(){
        Scanner scanner = new Scanner(System.in);

        System.out.println("Digite a descrição da Categoria:");
        String name = scanner.nextLine();

        CategoriaEntity categoria = new CategoriaEntity();
        categoria.setName(name);

        categoriaRepository.save(categoria);

    }
}
