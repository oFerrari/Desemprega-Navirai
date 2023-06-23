/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.edu.ifms.DesempregaNavirai.inscricao;


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
@RequestMapping("/api/inscricao")
public class InscricaoController {
     @Autowired // faz o Spring criar uma instância de DiciplinaService
    private InscricaoService service;
    
    @GetMapping
    public ResponseEntity<List<InscricaoDto>> listar() {
        List<Inscricao> listaEntity = service.listar();
        List<InscricaoDto> listaDto = InscricaoMapper.INSTANCE.map(listaEntity);
        return ResponseEntity.ok(listaDto);
    }

    @PostMapping
    @Transactional
    public ResponseEntity<InscricaoDto> cadastrar(
            @RequestBody @Valid InscricaoForm form) {
        Inscricao entity = InscricaoMapper.INSTANCE.toEntity(form);
        service.salvar(entity);
        InscricaoDto dto = InscricaoMapper.INSTANCE.toDto(entity);
        return ResponseEntity.accepted().body(dto);
    }
    
    @PutMapping("/{id}")
    @Transactional
    public ResponseEntity<InscricaoDto> atualizar(
            @PathVariable Long id,
            @RequestBody @Valid InscricaoForm form) {
        Inscricao entity = service.atualizar(id, form);
        InscricaoDto dto = InscricaoMapper.INSTANCE.toDto(entity);
        return ResponseEntity.ok(dto);
    }
    
    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity<?> excluir(@PathVariable Long id) {
        service.excluir(id);
        return ResponseEntity.ok().build();
    }
}

