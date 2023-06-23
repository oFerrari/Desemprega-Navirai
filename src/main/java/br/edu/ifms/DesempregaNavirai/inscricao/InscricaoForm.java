/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.edu.ifms.DesempregaNavirai.inscricao;

import br.edu.ifms.DesempregaNavirai.candidato.CandidatoDto;
import br.edu.ifms.DesempregaNavirai.vaga.VagaDto;
import java.time.LocalDateTime;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode


public class InscricaoForm {
    private String caminhoArquivoCurriculo;
    private LocalDateTime horarioInscricao;
    private VagaDto vaga;
    private CandidatoDto candidato;
}
