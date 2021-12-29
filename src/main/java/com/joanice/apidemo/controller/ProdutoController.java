package com.joanice.apidemo.controller;

import com.joanice.apidemo.model.Produto;
import com.joanice.apidemo.services.ProdutoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/produtos")
public class ProdutoController {

    @Autowired
    private ProdutoService produtoService;

    @GetMapping
    public List<Produto> listaDeProdutos(){
        return produtoService.listaDeProdutos();
    }

    @GetMapping("/{id}")
    public Optional<Produto> obterPorIdProduto(@PathVariable Integer id){
        return produtoService.obterPorIdProduto(id);
    }

    @PostMapping
    public Produto adicionarProduto(@RequestBody Produto produto){
        return produtoService.adicionarProduto(produto);
    }

    @DeleteMapping("/{id}")
    public String deletarProduto(@PathVariable Integer id){
        produtoService.deletarProduto(id);
        return "Produto com id: " + id + " foi deletado com sucesso";
    }

    @PutMapping("/{id}")
    public Produto atualizaProduto(@RequestBody Produto produto, @PathVariable Integer id){
      return produtoService.atualizaProduto(id, produto);
    }
}
