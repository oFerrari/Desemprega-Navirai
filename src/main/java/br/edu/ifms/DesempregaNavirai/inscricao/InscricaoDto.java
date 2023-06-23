/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.edu.ifms.DesempregaNavirai.inscricao;

import br.edu.ifms.DesempregaNavirai.candidato.Candidato;
import br.edu.ifms.DesempregaNavirai.vaga.Vaga;
import java.time.LocalDateTime;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
@Builder

public class InscricaoDto {

    private String caminhoArquivoCurriculo;
    private LocalDateTime horarioInscricao;
    private Vaga vaga;
    private Candidato candidato;
    
}
