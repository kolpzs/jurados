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
@Entity(name="avaliadores")
public class AvaliadorEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(nullable = false)
    private String nome;

    @Column(nullable = false)
    private String email;

    @Column(nullable = false)
    private String senha;

    @OneToMany(mappedBy = "avaliador")
    @JsonIgnoreProperties({"eventos", "avaliadores", "adms", "ideias", "colaboradores", "notas"})
    private List<NotaEntity> notas;

    @ManyToMany(mappedBy = "avaliadores")
    @JsonIgnoreProperties({"eventos", "avaliadores", "adms", "ideias", "colaboradores", "notas"})
    private List<EventoEntity> eventos;

    @ManyToMany(mappedBy = "avaliadores")
    @JsonIgnoreProperties({"eventos", "avaliadores", "adms", "ideias", "colaboradores", "notas"})
    private List<IdeiaEntity> ideias;
}
