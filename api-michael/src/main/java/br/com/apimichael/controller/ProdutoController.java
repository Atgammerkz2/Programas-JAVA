package br.com.apimichael.controller;
import br.com.apimichael.entities.Produto;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProdutoController {

    private  static Produto[] produtos = new Produto[]{
            new Produto(1l, "Coca-cola", 10.0f),
            new Produto(2l, "Extra Power 1250ml", 12.0f),
    };

    @GetMapping(path = "/produtos", produces = "application/json")
    public Produto[] getProdutos(){
        return produtos;
    }

    @GetMapping(path = "/produtos/{produtoId}")
    public String findById(@PathVariable Long produtoId){
        if(produtoId == 1){
            return "Produto 1";
        }

        return "Produto não encontrado!";
    }
}
