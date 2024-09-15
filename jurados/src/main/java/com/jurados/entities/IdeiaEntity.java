package com.jurados.entities;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Table
@Entity(name="ideias")
public class IdeiaEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(nullable = false)
    private String nome;

    @Column(nullable = false)
    private String impacto;

    @Column(nullable = false)
    private float custo;

    @Column(nullable = false, length = 1000)
    private String descricao;

    @Column(nullable = false)
    private float media;

    @ManyToMany
    @JoinTable(
            name = "ideia_nota",
            joinColumns = @JoinColumn(name = "ideia_id"),
            inverseJoinColumns = @JoinColumn(name = "nota_id")
    )
    @JsonIgnoreProperties({"eventos", "avaliadores", "adms", "ideias", "colaboradores", "notas"})
    private List<NotaEntity> notas;

    @OneToOne
    @JoinColumn(name = "colaborador_id")
    @JsonIgnoreProperties({"eventos", "avaliadores", "adms", "ideias", "colaboradores", "notas"})
    private ColaboradorEntity colaborador;

    @ManyToOne
    @JoinColumn(name = "evento_id")
    @JsonIgnoreProperties({"eventos", "avaliadores", "adms", "ideias", "colaboradores", "notas"})
    private EventoEntity evento;

    @ManyToMany
    @JoinTable(
            name = "ideia_avaliador",
            joinColumns = @JoinColumn(name = "ideia_id"),
            inverseJoinColumns = @JoinColumn(name = "avaliador_id")
    )
    @JsonIgnoreProperties({"eventos", "avaliadores", "adms", "ideias", "colaboradores", "notas"})
    private List<AvaliadorEntity> avaliadores;
}
