package com.mensal.pizzaria.Entity;


import  com.mensal.pizzaria.Entity.Endereco;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "cliente_table", schema = "pizzaria")
public class Cliente {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false,  unique = true)
    private Long id;

    private String nome;


    @OneToMany(fetch = FetchType.EAGER)
    @JoinColumn(name = "id_endereco", nullable = false)
    private List<Endereco> id_endereco;

    private String telefone;





}