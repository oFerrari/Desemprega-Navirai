/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.edu.ifms.DesempregaNavirai.candidato;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CandidatoService {
    @Autowired
    private CandidatoRepository repository;
    
    public List<Candidato> listar() {
        return repository.findAll();
    }
    
    public Candidato salvar(Candidato entity) {
        Candidato p = repository.save(entity);
        return p;
    }
    
    public Candidato atualizar(Long id, CandidatoForm form) {
        Candidato entity = buscarPorId(id);
        CandidatoMapper.INSTANCE.update(form, entity);
        return entity;
    }
    
    public Candidato buscarPorId(Long id) {
        Optional<Candidato> optional = repository.findById(id);
        if (optional.isEmpty()) {
            String msg = "Não existe Candidato para o código [%d] informado";
            throw new CandidatoNotFoundException(String.format(msg, id));
        }
        return optional.get();
    }

    public void excluir(Long id) {
        Candidato entity = buscarPorId(id);
        repository.delete(entity);
    }
}
