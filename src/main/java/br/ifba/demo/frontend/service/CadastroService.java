package br.ifba.demo.frontend.service;

import java.util.List;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import br.ifba.demo.frontend.dto.CadastroDTO;

@Service
public class CadastroService {

    private final String BASE_URL = "http://localhost:8081/cadastro";
    private final RestTemplate restTemplate = new RestTemplate();

    public List<CadastroDTO> listAll() {
        return List.of(restTemplate.getForObject(BASE_URL + "/listAll", CadastroDTO[].class));
    }

    public CadastroDTO getById(Long idCadastro) {
        return restTemplate.getForObject(BASE_URL + "/findById/" + idCadastro, CadastroDTO.class);
    }

    public List<CadastroDTO> getByNome(String nomeCadastro) {
        return List.of(restTemplate.getForObject(BASE_URL + "/findByNome/" + nomeCadastro, CadastroDTO[].class));
    }

    public CadastroDTO getByCpf(String cpfCadastro) {
        return restTemplate.getForObject(BASE_URL + "/findByCpf/" + cpfCadastro, CadastroDTO.class);
    }

    public CadastroDTO getByEmail(String emailCadastro) {
        return restTemplate.getForObject(BASE_URL + "/findByEmail/" + emailCadastro, CadastroDTO.class);
    }

    public CadastroDTO save(CadastroDTO cadastro) {
        return restTemplate.postForObject(BASE_URL + "/save", cadastro, CadastroDTO.class);
    }

    public void delete(Long id) {
        restTemplate.delete(BASE_URL + "/delete/" + id);
    }
}
