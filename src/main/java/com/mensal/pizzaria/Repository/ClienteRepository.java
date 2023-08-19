package com.mensal.pizzaria.Repository;

import com.mensal.pizzaria.Entity.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClienteRepository extends JpaRepository <Cliente,Long> {


    public Cliente findByNome(String nome);
    public Cliente findByCpf(String cpf);
}