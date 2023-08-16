package br.com.apimichael.controller;
import br.com.apimichael.entities.Produto;
import org.springframework.web.bind.annotation.*;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

@RestController
public class ProdutoController {
    private static List<Produto> produtos = new ArrayList<>();
    private static final DecimalFormat df = new DecimalFormat("0.00");

    @GetMapping(path = "/produtos", produces = "application/json")
    public List<Produto> getProdutos(){
        return produtos;
    }

    @GetMapping(path = "/produtos/{produtoId}")
    public String findById(@PathVariable Long produtoId){
        var produto = produtos.stream().filter(x -> x.getId().equals(produtoId)).findFirst().orElse(null);

        if(produto != null){
            return String.format("ID: %d</br>Nome: %s</br>Preço: R$ %s", produto.getId(),
                    produto.getNome(), df.format(produto.getPreco()));
        }

        return "Produto não encontrado!";
    }

    @PostMapping(path = "/produtos/add")
    public void addProduto(@RequestBody Produto produto){
        produtos.add(produto);
    }
}
