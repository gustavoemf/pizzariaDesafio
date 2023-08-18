package com.mensal.pizzaria.Service;

import com.mensal.pizzaria.DTO.ProdutoDTO;
import com.mensal.pizzaria.Entity.Produto;
import com.mensal.pizzaria.Repository.ProdutoRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

@Service
public class ProdutoService {

    @Autowired
    private ProdutoRepository repository;

    @Transactional
    public Produto cadastrar(@RequestBody final ProdutoDTO produtoDTO) {
        if (produtoDTO.getId() != null) {
            throw new RuntimeException("o campo ID não deve ser inserido");
        }
        Produto produto = toPessoaDTO(produtoDTO);
        return this.repository.save(produto);
    }

    @Transactional
    public void atualizar(final Long id, ProdutoDTO produtoDTO) {
        final Produto produtoBanco = this.repository.findById(id).orElse(null);
        if (produtoBanco != null || !produtoBanco.getId().equals(produtoDTO.getId())) {
            throw new RuntimeException("não foi possível encontrar o registro informado");
        }
        Produto produto = toPessoaDTO(produtoDTO);
        this.repository.save(produto);
    }

    public Produto toPessoaDTO(ProdutoDTO produtoDTO){
        Produto produtoTemp = new Produto();
        produtoTemp.setNome(produtoDTO.getNome());
        produtoTemp.setTipo(produtoDTO.getTipo());
        produtoTemp.setPreco(produtoDTO.getPreco());
        return produtoTemp;
    }
}