package br.edu.ifms.DesempregaNavirai.vaga;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class VagaService {
    @Autowired
    private VagaRepository repository;
    
    public List<Vaga> listar() {
        return repository.findAll();
    }
    
    public Vaga salvar(Vaga entity) {
        Vaga p = repository.save(entity);
        return p;
    }
    
    public Vaga atualizar(Long id, VagaForm form) {
        Vaga entity = buscarPorId(id);
        VagaMapper.INSTANCE.update(form, entity);
        return entity;
    }
    
    public Vaga buscarPorId(Long id) {
        Optional<Vaga> optional = repository.findById(id);
        if (optional.isEmpty()) {
            String msg = "Não existe Vaga para o código [%d] informado";
            throw new VagaNotFoundException(String.format(msg, id));
        }
        return optional.get();
    }

    public void excluir(Long id) {
        Vaga entity = buscarPorId(id);
        repository.delete(entity);
    }
}
