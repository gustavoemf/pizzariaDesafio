package com.mensal.pizzaria.entityTest;

import com.mensal.pizzaria.entity.*;
import com.mensal.pizzaria.entity.enums.Forma_Pagamento;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Collections;

@SpringBootTest
class PedidoTest {
    @Test
    void entitySetterTest() {
        ProdutoEntity produto = new ProdutoEntity();
        ClienteEntity cliente = new ClienteEntity();
        PedidoEntity pedido = new PedidoEntity();

        pedido.setId(1L);
        pedido.setProdutoList(Collections.singletonList(produto));
        pedido.setCliente(cliente);
        pedido.setDelivery(true);
        pedido.setFormaPagamento(Forma_Pagamento.PIX);
        pedido.setTotal(25.0);

        Assertions.assertEquals(1L, pedido.getId());
        Assertions.assertEquals(Collections.singletonList(produto), pedido.getProdutoList());
        Assertions.assertEquals(cliente, pedido.getCliente());
        Assertions.assertEquals(Forma_Pagamento.PIX, pedido.getFormaPagamento());
        Assertions.assertEquals(25.0, pedido.getTotal());
    }
}