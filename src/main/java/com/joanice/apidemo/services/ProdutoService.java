package com.joanice.apidemo.services;

import com.joanice.apidemo.model.Produto;
import com.joanice.apidemo.repository.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class ProdutoService {

    @Autowired //aqui eu manipulo essa instancia
    private ProdutoRepository produtoRepository;

    public List<Produto> listaDeProdutos(){
        return produtoRepository.listaDeProdutos();
    }

    public Optional<Produto> obterPorIdProduto(Integer id){
        return produtoRepository.obterPorIdProduto(id);
    }

    public Produto adicionarProduto(Produto produto){
       return produtoRepository.adicionarProduto(produto);
    }

    public void deletarProduto(Integer id){
        produtoRepository.deletarProduto(id);
    }

    public Produto atualizaProduto( Integer id, Produto produto){
        produto.setId(id);
        return produtoRepository.atualizaProduto(produto);
    }
}
