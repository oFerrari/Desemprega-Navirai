/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package br.edu.ifms.DesempregaNavirai.vaga;

import java.util.List;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.factory.Mappers;


public interface VagaMapper {
    public static final VagaMapper INSTANCE = Mappers.getMapper(VagaMapper.class);
    
    public VagaDto toDto(Vaga entity);
    
    public List<VagaDto>map(List<Vaga>itens);
    
    @Mapping(target = "id", ignore = true)
    public void update(VagaForm dto, @MappingTarget Vaga entity);
    
    @Mapping(target = "id", ignore = true)
    public Vaga toEntity(VagaForm form);
}
