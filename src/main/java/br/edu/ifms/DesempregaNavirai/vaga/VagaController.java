/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.edu.ifms.DesempregaNavirai.vaga;

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
@RequestMapping("/api/vaga")
public class VagaController {

    @Autowired // faz o Spring criar uma instância de DiciplinaService
    private VagaService service;

    @GetMapping
    public ResponseEntity<List<VagaDto>> listar() {
        List<Vaga> listaEntity = service.listar();
        List<VagaDto> listaDto = VagaMapper.INSTANCE.map(listaEntity);
        return ResponseEntity.ok(listaDto);
    }

    @PostMapping
    @Transactional
    public ResponseEntity<VagaDto> cadastrar(
            @RequestBody @Valid VagaForm form) {
        Vaga entity = VagaMapper.INSTANCE.toEntity(form);
        service.salvar(entity);
        VagaDto dto = VagaMapper.INSTANCE.toDto(entity);
        return ResponseEntity.accepted().body(dto);
    }

    @PutMapping("/{id}")
    @Transactional
    public ResponseEntity<VagaDto> atualizar(
            @PathVariable Long id,
            @RequestBody @Valid VagaForm form) {
        Vaga entity = service.atualizar(id, form);
        VagaDto dto = VagaMapper.INSTANCE.toDto(entity);
        return ResponseEntity.ok(dto);
    }

    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity<?> excluir(@PathVariable Long id) {
        service.excluir(id);
        return ResponseEntity.ok().build();
    }
}
