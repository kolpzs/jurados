package com.jurados.entities;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
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
@Entity(name="notas")
public class NotaEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Min(3)
    @Max(10)
    @Column(nullable = false)
    private int nota_avaliador;

    @ManyToMany(mappedBy = "notas")
    @JsonIgnoreProperties({"eventos", "avaliadores", "adms", "ideias", "colaboradores", "notas"})
    private List<IdeiaEntity> ideias;

    @ManyToOne
    @JoinColumn(name = "avaliador_id")
    @JsonIgnoreProperties({"eventos", "avaliadores", "adms", "ideias", "colaboradores", "notas"})
    private AvaliadorEntity avaliador;
}
