package br.com.apimichael.entities;

public class Produto {

    public Produto(){}

    public Produto(Long id, String nome, float preco){
        this.Id = id;
        this.Nome = nome;
        this.Preco = preco;
    }

    Long Id;
    String Nome;
    float Preco;

    public Long getId() {
        return Id;
    }

    public void setId(Long id) {
        Id = id;
    }

    public String getNome() {
        return Nome;
    }

    public void setNome(String nome) {
        Nome = nome;
    }

    public float getPreco() {
        return Preco;
    }

    public void setPreco(float preco) {
        Preco = preco;
    }
}
