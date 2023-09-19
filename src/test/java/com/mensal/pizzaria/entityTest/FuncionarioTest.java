package com.mensal.pizzaria.entityTest;

import com.mensal.pizzaria.entity.FuncionarioEntity;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class FuncionarioTest {
    @Test
    void entityTest() {
        FuncionarioEntity funcionario = new FuncionarioEntity(1L, "Gustavo", "Entregador");

        Assertions.assertEquals(1L, funcionario.getId());
        Assertions.assertEquals("Gustavo", funcionario.getNomeFuncionario());
        Assertions.assertEquals("Entregador", funcionario.getCargo());
    }
}