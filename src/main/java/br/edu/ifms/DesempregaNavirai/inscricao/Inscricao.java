/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.edu.ifms.DesempregaNavirai.inscricao;

import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import java.io.Serializable;
import java.time.LocalDateTime;

@Entity
public class Inscricao implements Serializable{
    @EmbeddedId
    private InscricaoId id;
    private String caminhoArquivoCurriculo;
    private LocalDateTime horarioInscricao;
}
