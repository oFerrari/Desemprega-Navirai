/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package br.edu.ifms.DesempregaNavirai.candidato;

import java.util.List;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.factory.Mappers;


public interface CandidatoMapper {
    public static final CandidatoMapper INSTANCE = Mappers.getMapper(CandidatoMapper.class);
    
    public CandidatoDto toDto(Candidato entity);
    
    public List<CandidatoDto>map(List<Candidato>itens);
    
    @Mapping(target = "id", ignore = true)
    public void update(CandidatoForm dto, @MappingTarget Candidato entity);
    
    @Mapping(target = "id", ignore = true)
    public Candidato toEntity(CandidatoForm form);
}
