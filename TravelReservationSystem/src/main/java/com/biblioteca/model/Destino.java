package com.biblioteca.model;

import jakarta.persistence.*;
import java.util.List;

@Entity
@Table(name = "tb_destino")
public class Destino {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String nomeCidade;

    @Column(nullable = false)
    private String pais;

    @Column
    private String descricao;

    @Column
    private Double precoEstimado;

    // Relacionamento: Um Destino pode ter várias Viagens
    @OneToMany(mappedBy = "destino", cascade = CascadeType.ALL)
    private List<Viagem> viagens;

    // Construtores
    public Destino() {}

    public Destino(String nomeCidade, String pais, String descricao, Double precoEstimado) {
        this.nomeCidade = nomeCidade;
        this.pais = pais;
        this.descricao = descricao;
        this.precoEstimado = precoEstimado;
    }

    // Getters e Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getNomeCidade() { return nomeCidade; }
    public void setNomeCidade(String nomeCidade) { this.nomeCidade = nomeCidade; }

    public String getPais() { return pais; }
    public void setPais(String pais) { this.pais = pais; }

    public String getDescricao() { return descricao; }
    public void setDescricao(String descricao) { this.descricao = descricao; }

    public Double getPrecoEstimado() { return precoEstimado; }
    public void setPrecoEstimado(Double precoEstimado) { this.precoEstimado = precoEstimado; }

    public List<Viagem> getViagens() { return viagens; }
    public void setViagens(List<Viagem> viagens) { this.viagens = viagens; }
}
