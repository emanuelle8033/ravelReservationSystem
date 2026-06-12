package com.biblioteca.model;

import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "tb_viagem")
public class Viagem {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private LocalDate dataPartida;

    @Column
    private LocalDate dataRetorno;

    @Column
    private String status; // AGENDADA, CONFIRMADA, CANCELADA, CONCLUIDA

    @Column
    private Double valorTotal;

    // Relacionamento: Viagem pertence a um Passageiro (ManyToOne)
    @ManyToOne
    @JoinColumn(name = "passageiro_id", nullable = false)
    private Passageiro passageiro;

    // Relacionamento: Viagem pertence a um Destino (ManyToOne)
    @ManyToOne
    @JoinColumn(name = "destino_id", nullable = false)
    private Destino destino;

    // Construtores
    public Viagem() {}

    public Viagem(LocalDate dataPartida, LocalDate dataRetorno, Passageiro passageiro, Destino destino) {
        this.dataPartida = dataPartida;
        this.dataRetorno = dataRetorno;
        this.passageiro = passageiro;
        this.destino = destino;
        this.status = "AGENDADA";
    }

    // Getters e Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public LocalDate getDataPartida() { return dataPartida; }
    public void setDataPartida(LocalDate dataPartida) { this.dataPartida = dataPartida; }

    public LocalDate getDataRetorno() { return dataRetorno; }
    public void setDataRetorno(LocalDate dataRetorno) { this.dataRetorno = dataRetorno; }

    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }

    public Double getValorTotal() { return valorTotal; }
    public void setValorTotal(Double valorTotal) { this.valorTotal = valorTotal; }

    public Passageiro getPassageiro() { return passageiro; }
    public void setPassageiro(Passageiro passageiro) { this.passageiro = passageiro; }

    public Destino getDestino() { return destino; }
    public void setDestino(Destino destino) { this.destino = destino; }
}
