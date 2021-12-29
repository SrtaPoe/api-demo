package com.joanice.apidemo.repository;

import com.joanice.apidemo.model.Produto;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Optional;

@Repository
public class ProdutoRepository {

    private ArrayList<Produto> produtos = new ArrayList<Produto>();
    private Integer idProduto = 0;

   /**
    * @return Lista de produtos
    * Método que lista todos os produtos
    * **/
    public List<Produto> listaDeProdutos(){
        return produtos;
    }

    /**
     * @return produto por id repassado
     * Método que retorna produto, caso o id seja encontrado
     * @param id do produto a ser localizado
     * **/
    public Optional<Produto> obterPorIdProduto(Integer id){
        return produtos
                .stream()
                .filter(produto -> produto.getId() == id)
                .findFirst();
    }

    /**
     * @return produto adicionado com seu id
     * Método que adicona produto
     * @param produto a ser adicionado
     * **/
    public Produto adicionarProduto(Produto produto){
        idProduto++;
        produto.setId(idProduto);
        produtos.add(produto);
        return produto;
    }

    /**
     *
     * Método que deleta produto por id passado
     * @param id do produto a ser deletado
     * **/
    public void deletarProduto(Integer id){
        produtos.removeIf(produto -> produto.getId() == id);
    }

    /**
     * @return produto atualizado
     * Método que atualiza produto solicitado por id
     * @param produto a ser adicionado
     * **/
    public Produto atualizaProduto(Produto produto){
        Optional<Produto> produtoEncontrado = obterPorIdProduto(produto.getId());

        if(produtos.isEmpty()){
            throw new InputMismatchException("Produto não encontrado");
        }

        //deleta o produto anterior
        deletarProduto(produto.getId());

        //adiciona produto atualizado
        produtos.add(produto);

        return produto;
    }
}
