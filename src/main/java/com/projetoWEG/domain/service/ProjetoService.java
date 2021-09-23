package com.projetoWEG.domain.service;

import com.projetoWEG.api.assembler.ProjetoAssembler;
import com.projetoWEG.api.model.dto.projeto.ProjetoFornecedorDTO;
import com.projetoWEG.domain.exception.CasoException;
import com.projetoWEG.domain.model.Projeto;
import com.projetoWEG.domain.model.StatusProjeto;
import com.projetoWEG.domain.repository.ProjetoRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@AllArgsConstructor
@Service
public class ProjetoService {

    private ProjetoRepository projetoRepository;
    private ProjetoAssembler projetoAssembler;

    public List<Projeto> listarTodos() {
        return projetoRepository.findAll();
    }

    public ProjetoFornecedorDTO listarId(Long id) {
        return projetoAssembler.toFornecedor(projetoRepository.findById(id)
                .orElseThrow(() -> new CasoException("Projeto não encontrado.")));
    }
    public ProjetoFornecedorDTO listarNome(String nome) {
        return projetoAssembler.toFornecedor(projetoRepository.findByNome(nome)
                .orElseThrow(() -> new CasoException("Projeto não encontrado.")));
    }
    public List<ProjetoFornecedorDTO> listarSecao(String secao) {
        return projetoAssembler.toFornecedorCollection(projetoRepository.findBySecao_nomeSecao(secao));
    }
    public List<Projeto> listarContaining(String contain) {
        return projetoRepository.findByNomeContaining(contain);
    }

    public List<Projeto> listarStatus(StatusProjeto status) {
        return projetoRepository.findByStatus(status);
    }
}
