package com.jurados.services;

import com.jurados.entities.*;
import com.jurados.repositories.AdmRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Service
public class AdmService {

    @Autowired
    private AdmRepository admRepository;

    @Autowired
    private ColaboradorService colaboradorService;

    @Autowired
    private AvaliadorService avaliadorService;

    @Autowired
    private EventoService eventoService;

    public AdmEntity save(AdmEntity adm) {
        return admRepository.save(adm);
    }

    public List<AdmEntity> findAll() {
        return admRepository.findAll();
    }

    public AdmEntity findById(Long id) {
        return admRepository.findById(id).orElseThrow();
    }

    public String delete(Long id) {
        if(findAll().size() == 1) {
            return "Perfil Não deletado. É necessário se haver ao menos 01 Perfil ADM.";
        }
        AdmEntity adm = findById(id);
        String nome = adm.getNome();
        admRepository.delete(adm);
        return "Adm " + nome + "deletado com sucesso!";
    }

    public AdmEntity update(AdmEntity adm) {
        return admRepository.save(adm);
    }

    public ColaboradorEntity updateColaborador(ColaboradorEntity colaborador) {
        return colaboradorService.update(colaborador);
    }

    public AvaliadorEntity updateAvaliador(AvaliadorEntity avaliador) {
        return avaliadorService.update(avaliador);
    }

    public EventoEntity saveEvento(EventoEntity evento) {
        return eventoService.save(evento);
    }

    public EventoEntity selecaoAvaliador(Long evento_id, List<Long> avaliadores_id){
        EventoEntity evento = eventoService.findById(evento_id);
        List<AvaliadorEntity> avaliadores = new ArrayList<>();
        for(Long id : avaliadores_id) {
            if(id != null) {
                avaliadores.add(avaliadorService.findById(id));
            } else {
                return null;
            }
        }
        evento.setAvaliadores(avaliadores);
        return eventoService.save(evento);
    }

    public EventoEntity sorteiaIdeias(Long evento_id){
        EventoEntity evento = eventoService.findById(evento_id);
        List<AvaliadorEntity> avaliadores = evento.getAvaliadores();
        List<IdeiaEntity> ideias = evento.getIdeias();

        Collections.shuffle(ideias);
        Collections.shuffle(avaliadores);
        int i = 0;

        for(IdeiaEntity ideia : ideias) {
            if(i <= avaliadores.size()) {
                avaliadores.get(i).getIdeias().add(ideia);
                i++;
            } else {
                i = 0;
            }
        }

        return eventoService.findById(evento_id);
    }
}
