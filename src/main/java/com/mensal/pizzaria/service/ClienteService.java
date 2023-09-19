package com.mensal.pizzaria.service;

import com.mensal.pizzaria.dto.ClienteDTO;
import com.mensal.pizzaria.entity.ClienteEntity;
import com.mensal.pizzaria.repository.ClienteRepository;
import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
<<<<<<< HEAD
=======
import java.util.stream.Collectors;
>>>>>>> 89d15734e6678d16d002998f3903345b3cbf1544

@Service
public class ClienteService {
    @Autowired
    private ClienteRepository repository;
    @Autowired
    private ModelMapper modelMapper;

    @Transactional
    public List<ClienteDTO> findAll() {
<<<<<<< HEAD
        List<ClienteDTO> list = new ArrayList<>();
        for (ClienteEntity entity : repository.findAll()) {
            ClienteDTO map = modelMapper.map(entity, ClienteDTO.class);
            list.add(map);
        }
        return list;
=======
        return repository.findAll().stream().map(entity -> modelMapper.map(entity, ClienteDTO.class)).collect(Collectors.toList());
>>>>>>> 89d15734e6678d16d002998f3903345b3cbf1544
    }

    @Transactional
    public ClienteDTO create(ClienteDTO dto) {
        return modelMapper.map(repository.save(modelMapper.map(dto, ClienteEntity.class)), ClienteDTO.class);
    }

    @Transactional
    public ClienteDTO update(Long id, ClienteDTO dto) {
        ClienteEntity existingEntity = repository.findById(id).orElseThrow(() -> new EntityNotFoundException("Não foi possível encontrar o registro informado"));

        modelMapper.map(dto, existingEntity);

        return modelMapper.map(repository.save(existingEntity), ClienteDTO.class);
    }
}