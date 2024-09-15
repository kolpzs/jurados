package com.jurados.services;

import com.jurados.entities.IdeiaEntity;
import com.jurados.repositories.IdeiaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class IdeiaService {

    @Autowired
    private IdeiaRepository ideiaRepository;

    public IdeiaEntity save(IdeiaEntity ideia) {
        return ideiaRepository.save(ideia);
    }

    public List<IdeiaEntity> findAll() {
        return ideiaRepository.findAll();
    }

    public IdeiaEntity findById(Long id) {
        return ideiaRepository.findById(id).orElseThrow();
    }

    public String delete(Long id) {
        IdeiaEntity ideia = findById(id);
        String nome = ideia.getNome();
        ideiaRepository.delete(ideia);
        return "Ideia " + nome + "deletado com sucesso!";
    }

    public IdeiaEntity update(IdeiaEntity ideia) {
        if(ideia.getId() == null) {
            return null;
        } else {
            IdeiaEntity base = findById(ideia.getId());
            if(ideia.getNome() != null) {
                base.setNome(ideia.getNome());
            }
            if(ideia.getImpacto() != null) {
                base.setImpacto(ideia.getImpacto());
            }
            if(base.getCusto() >= 0) {
                base.setCusto(ideia.getCusto());
            }
            if(base.getDescricao() != null) {
                base.setDescricao(ideia.getDescricao());
            }
            return ideiaRepository.save(base);
        }
    }
}
