/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.edu.ifms.DesempregaNavirai.Empresa;


import br.edu.ifms.DesempregaNavirai.empresa.Empresa;
import br.edu.ifms.DesempregaNavirai.empresa.EmpresaDto;
import br.edu.ifms.DesempregaNavirai.empresa.EmpresaForm;
import br.edu.ifms.DesempregaNavirai.empresa.EmpresaMapper;
import br.edu.ifms.DesempregaNavirai.empresa.EmpresaService;
import jakarta.validation.Valid;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author 07041626105
 */
@RestController
@RequestMapping("/api/empresa")
public class EmpresaController {
     @Autowired // faz o Spring criar uma instância de DiciplinaService
    private EmpresaService service;
    
    @GetMapping
    public ResponseEntity<List<EmpresaDto>> listar() {
        List<Empresa> listaEntity = service.listar();
        List<EmpresaDto> listaDto = EmpresaMapper.INSTANCE.map(listaEntity);
        return ResponseEntity.ok(listaDto);
    }

    @PostMapping
    @Transactional
    public ResponseEntity<EmpresaDto> cadastrar(
            @RequestBody @Valid EmpresaForm form) {
        Empresa entity = EmpresaMapper.INSTANCE.toEntity(form);
        service.salvar(entity);
        EmpresaDto dto = EmpresaMapper.INSTANCE.toDto(entity);
        return ResponseEntity.accepted().body(dto);
    }
    
    @PutMapping("/{id}")
    @Transactional
    public ResponseEntity<EmpresaDto> atualizar(
            @PathVariable Long id,
            @RequestBody @Valid EmpresaForm form) {
        Empresa entity = service.atualizar(id, form);
        EmpresaDto dto = EmpresaMapper.INSTANCE.toDto(entity);
        return ResponseEntity.ok(dto);
    }
    
    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity<?> excluir(@PathVariable Long id) {
        service.excluir(id);
        return ResponseEntity.ok().build();
    }
}
