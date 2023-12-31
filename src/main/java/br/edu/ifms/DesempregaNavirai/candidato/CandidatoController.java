/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.edu.ifms.DesempregaNavirai.candidato;

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

@RestController
@RequestMapping("/api/candidato")
public class CandidatoController {

    @Autowired // faz o Spring criar uma instância de DiciplinaService
    private CandidatoService service;

    @GetMapping
    public ResponseEntity<List<CandidatoDto>> listar() {
        List<Candidato> listaEntity = service.listar();
        List<CandidatoDto> listaDto = CandidatoMapper.INSTANCE.map(listaEntity);
        return ResponseEntity.ok(listaDto);
    }

    @PostMapping
    @Transactional
    public ResponseEntity<CandidatoDto> cadastrar(
            @RequestBody @Valid CandidatoForm form) {
        Candidato entity = CandidatoMapper.INSTANCE.toEntity(form);
        service.salvar(entity);
        CandidatoDto dto = CandidatoMapper.INSTANCE.toDto(entity);
        return ResponseEntity.accepted().body(dto);
    }

    @PutMapping("/{id}")
    @Transactional
    public ResponseEntity<CandidatoDto> atualizar(
            @PathVariable Long id,
            @RequestBody @Valid CandidatoForm form) {
        Candidato entity = service.atualizar(id, form);
        CandidatoDto dto = CandidatoMapper.INSTANCE.toDto(entity);
        return ResponseEntity.ok(dto);
    }

    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity<?> excluir(@PathVariable Long id) {
        service.excluir(id);
        return ResponseEntity.ok().build();
    }
}
