package com.jurados.entities;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;
import java.util.List;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Table
@Entity(name = "eventos")
public class EventoEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(nullable = false)
    private String nome;

    @Column(nullable = false)
    private String descricao;

    @Column(nullable = false)
    private Date data_inicio;

    @Column(nullable = false)
    private Date data_fim;

    @ManyToOne
    @JoinColumn(name = "adm_id")
    @JsonIgnoreProperties({"eventos", "avaliadores", "adms", "ideias", "colaboradores", "notas"})
    private AdmEntity adm;

    @OneToMany(mappedBy = "evento")
    @JsonIgnoreProperties({"eventos", "avaliadores", "adms", "ideias", "colaboradores", "notas"})
    private List<IdeiaEntity> ideias;

    @ManyToMany
    @JoinTable(
            name = "evento_avaliador",
            joinColumns = @JoinColumn(name = "evento_id"),
            inverseJoinColumns = @JoinColumn(name = "avaliador_id")
    )
    @JsonIgnoreProperties({"eventos", "avaliadores", "adms", "ideias", "colaboradores", "notas"})
    private List<AvaliadorEntity> avaliadores;

}
