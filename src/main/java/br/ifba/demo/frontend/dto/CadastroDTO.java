package br.ifba.demo.frontend.dto;

import lombok.Data;
import java.time.LocalDateTime;

@Data
public class CadastroDTO {

    private Long idCadastro;
    private String nomeCadastro;
    private String emailCadastro;
    private String senhaCadastro;
    private String cpfCadastro;
    private LocalDateTime data_cadastro;


    
}
