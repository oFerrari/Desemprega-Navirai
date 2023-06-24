/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package br.edu.ifms.DesempregaNavirai.inscricao;

import br.edu.ifms.DesempregaNavirai.candidato.CandidatoMapper;
import br.edu.ifms.DesempregaNavirai.vaga.VagaMapper;
import java.util.List;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.factory.Mappers;

@Mapper(
        uses = {VagaMapper.class, CandidatoMapper.class}
)
public interface InscricaoMapper {
    public static final InscricaoMapper INSTANCE = Mappers.getMapper(InscricaoMapper.class);
    
    
    public InscricaoDto toDto(Inscricao entity);
    
    public List<InscricaoDto>map(List<Inscricao>itens);
    
    @Mapping(target = "id", ignore = true)
    public void update(InscricaoForm dto, @MappingTarget Inscricao entity);
    
    @Mapping(target = "id", expression = """
                                         java(
                                            InscricaoId.builder()
                                                    .candidatoId(dto.getCandidato().getId())
                                                    .vagaId(dto.getVaga().getId())
                                                    .build()
                                         )
                                         """)
    
    public Inscricao toEntity(InscricaoForm dto);
    
}   
    