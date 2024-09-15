package com.jurados.services;

import com.jurados.entities.ColaboradorEntity;
import com.jurados.entities.IdeiaEntity;
import com.jurados.repositories.ColaboradorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ColaboradorService {

    @Autowired
    private ColaboradorRepository colaboradorRepository;

    @Autowired
    private IdeiaService ideiaService;

    public ColaboradorEntity save(ColaboradorEntity colaborador) {
        return colaboradorRepository.save(colaborador);
    }

    public List<ColaboradorEntity> findAll() {
        return colaboradorRepository.findAll();
    }

    public ColaboradorEntity findById(Long id) {
        return colaboradorRepository.findById(id).orElseThrow();
    }

    public String delete(Long id) {
        ColaboradorEntity colaborador = findById(id);
        String nome = colaborador.getNome();
        colaboradorRepository.delete(colaborador);
        return "Colaborador " + nome + "deletado com sucesso!";
    }

    public ColaboradorEntity update(ColaboradorEntity colaborador) {
        if(colaborador.getId() == null){
            return null;
        } else {
            ColaboradorEntity base = findById(colaborador.getId());
            if(colaborador.getNome() != null){
                base.setNome(colaborador.getNome());
            }
            if(colaborador.getEmail() != null){
                base.setEmail(colaborador.getEmail());
            }
            if(colaborador.getSenha() != null){
                base.setSenha(colaborador.getSenha());
            }
            return colaboradorRepository.save(base);
        }
    }

    public IdeiaEntity saveIdeia(IdeiaEntity ideia) {
        return ideiaService.save(ideia);
    }
}
