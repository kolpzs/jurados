package com.jurados.services;

import com.jurados.entities.*;
import com.jurados.repositories.AvaliadorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Service
public class AvaliadorService {

    @Autowired
    private AvaliadorRepository avaliadorRepository;

    @Autowired
    private IdeiaService ideiaService;

    public AvaliadorEntity save(AvaliadorEntity avaliador) {
        return avaliadorRepository.save(avaliador);
    }

    public List<AvaliadorEntity> findAll() {
        return avaliadorRepository.findAll();
    }

    public AvaliadorEntity findById(Long id) {
        return avaliadorRepository.findById(id).orElseThrow();
    }

    public String delete(Long id) {
        AvaliadorEntity avaliador = findById(id);
        String nome = avaliador.getNome();
        avaliadorRepository.delete(avaliador);
        return "Avaliador " + nome + "deletado com sucesso!";
    }

    public AvaliadorEntity update(AvaliadorEntity avaliador) {
        if(avaliador.getId() == null) {
            return null;
        } else {
            AvaliadorEntity base = findById(avaliador.getId());
            if(avaliador.getNome() != null) {
                base.setNome(avaliador.getNome());
            }
            if(avaliador.getEmail() != null) {
                base.setEmail(avaliador.getEmail());
            }
            if(avaliador.getSenha() != null) {
                base.setSenha(avaliador.getSenha());
            }
            return avaliadorRepository.save(base);
        }
    }

    public String avaliaIdeia(Long avaliador_id, Long ideia_id, int nota) {
        IdeiaEntity ideia = ideiaService.findById(ideia_id);
        AvaliadorEntity avaliador = findById(avaliador_id);
        int valido = 0;
        for(AvaliadorEntity avaliadorEntity : ideia.getAvaliadores()) {
            if (Objects.equals(avaliadorEntity.getId(), avaliador.getId())) {
                valido = 1;
                break;
            }
        }

        if(valido == 0) {
            return "Ideia não foi cadastrado este Avaliador!";
        }
        
        NotaEntity notaEntity = new NotaEntity();
        notaEntity.setNota_avaliador(nota);
        ideia.getNotas().add(notaEntity);
        float media = mediaNota(avaliador_id);
        return "Nota: " + nota + " adicionada com sucesso. Média: " + media;

    }

    public float mediaNota(Long ideia_id) {
        IdeiaEntity ideia = ideiaService.findById(ideia_id);
        float tamanho = ideia.getNotas().size();
        float media = ideia.getMedia();
        for(NotaEntity nota : ideia.getNotas()) {
            media += nota.getNota_avaliador();
        }
        ideia.setMedia(media);
        return media/tamanho;
    }
}
