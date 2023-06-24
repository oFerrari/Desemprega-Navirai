/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.edu.ifms.DesempregaNavirai.inscricao;

import br.edu.ifms.DesempregaNavirai.candidato.Candidato;
import br.edu.ifms.DesempregaNavirai.vaga.Vaga;
import jakarta.persistence.Column;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import java.io.Serializable;
import java.time.LocalDateTime;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Entity
@Data
@EqualsAndHashCode
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Inscricao implements Serializable{
    @EmbeddedId
    private InscricaoId id;
    
    @Column(nullable = false)
    private String caminhoArquivoCurriculo;
    
    @Column(nullable = false)
    private LocalDateTime horarioInscricao;
    
    @ManyToOne
    @JoinColumn(name = "vaga_id",
            insertable = false,
            updatable = false)
    private Vaga vaga;
    
    @ManyToOne
    @JoinColumn(name = "candidato_id",
            insertable = false,
            updatable = false)
    private Candidato candidato;

}
