/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package br.edu.ifms.DesempregaNavirai.empresa;

import java.util.List;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.factory.Mappers;


public interface EmpresaMapper {
    public static final EmpresaMapper INSTANCE = Mappers.getMapper(EmpresaMapper.class);
    
    public EmpresaDto toDto(Empresa entity);
    
    public List<EmpresaDto>map(List<Empresa>itens);
    
    @Mapping(target = "id", ignore = true)
    public void update(EmpresaForm dto, @MappingTarget Empresa entity);
    
    @Mapping(target = "id", ignore = true)
    public Empresa toEntity(EmpresaForm form);
}
