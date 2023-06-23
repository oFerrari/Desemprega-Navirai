package br.edu.ifms.DesempregaNavirai.inscricao;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class InscricaoService {
    @Autowired
    private InscricaoRepository repository;
    
    public List<Inscricao> listar() {
        return repository.findAll();
    }
    
    public Inscricao salvar(Inscricao entity) {
        Inscricao p = repository.save(entity);
        return p;
    }
    
    public Inscricao atualizar(Long id, InscricaoForm form) {
        Inscricao entity = buscarPorId(id);
        InscricaoMapper.INSTANCE.update(form, entity);
        return entity;
    }
    
    public Inscricao buscarPorId(Long id) {
        Optional<Inscricao> optional = repository.findById(id);
        if (optional.isEmpty()) {
            String msg = "Não existe inscricao para o código [%d] informado";
            throw new InscricaoNotFoundException(String.format(msg, id));
        }
        return optional.get();
    }

    public void excluir(Long id) {
        Inscricao entity = buscarPorId(id);
        repository.delete(entity);
    }
}
