package com.mensal.pizzaria.Controller;

import com.mensal.pizzaria.DTO.FuncionarioDto;
import com.mensal.pizzaria.Entity.Funcionario;
import com.mensal.pizzaria.Repository.FuncionarioRepository;
import com.mensal.pizzaria.Service.FuncionarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/funcionarios")
public class FuncionarioController {

    @Autowired
    private FuncionarioService funcionarioService;

    @Autowired
    private FuncionarioRepository funcionarioRepository;

    @GetMapping()
    public ResponseEntity<?> listaCompleta(){
        return ResponseEntity.ok(this.funcionarioRepository.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> findById(
            @PathVariable("id") final long id
    ) {
        final Funcionario funcionario = this.funcionarioRepository.findById(id).orElse(null);
        return funcionario == null
                ? ResponseEntity.badRequest().body("Sem valor encontrado.")
                : ResponseEntity.ok(funcionario);
    }

    @PostMapping("/guardar")
    public ResponseEntity<?> cadastraFuncionario(@RequestBody FuncionarioDto funcionarioDto) {
        try {
            funcionarioService.cadastraFuncionario(funcionarioDto);
        }
        catch (Exception e){
            return ResponseEntity.badRequest().body("Error: " + e.getMessage());
        }
        return ResponseEntity.ok().body("Registro adicionado com sucesso");
    }
}
