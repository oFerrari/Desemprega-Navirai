package br.edu.ifms.DesempregaNavirai.empresa;

import br.edu.ifms.DesempregaNavirai.vaga.*;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EmpresaService {
    @Autowired
    private EmpresaRepository repository;
    
    public List<Empresa> listar() {
        return repository.findAll();
    }
    
    public Empresa salvar(Empresa entity) {
        Empresa p = repository.save(entity);
        return p;
    }
    
    public Empresa atualizar(Long id, EmpresaForm form) {
        Empresa entity = buscarPorId(id);
        EmpresaMapper.INSTANCE.update(form, entity);
        return entity;
    }
    
    public Empresa buscarPorId(Long id) {
        Optional<Empresa> optional = repository.findById(id);
        if (optional.isEmpty()) {
            String msg = "Não existe Empresa para o código [%d] informado";
            throw new EmpresaNotFoundException(String.format(msg, id));
        }
        return optional.get();
    }

    public void excluir(Long id) {
        Empresa entity = buscarPorId(id);
        repository.delete(entity);
    }
}
