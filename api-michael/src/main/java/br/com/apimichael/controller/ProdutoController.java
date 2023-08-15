package br.com.apimichael.controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProdutoController {
    @GetMapping(path = "/produtos", produces = "application/json")
    public String getProdutos(){
        return "Lista de produtos";
    }

    @GetMapping(path = "/produtos/{produtoId}")
    public String findById(@PathVariable Long produtoId){
        if(produtoId == 1){
            return "Produto 1";
        }

        return "Produto não encontrado!";
    }
}
