package com.mensal.pizzaria.controllerTest;

import com.mensal.pizzaria.controller.ClienteController;
import com.mensal.pizzaria.dto.ClienteDTO;
import com.mensal.pizzaria.repository.ClienteRepository;
import com.mensal.pizzaria.service.ClienteService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.modelmapper.ModelMapper;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.*;

@SpringBootTest
class ClienteControllerTest {
    @InjectMocks
    private ClienteController controller;
    @Mock
    private ClienteService service;
    @Mock
    private ClienteRepository repository;
    @Mock
    private ModelMapper modelMapper;
    private ClienteDTO dto;
    private final Long id = 1L;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);

        dto = new ClienteDTO(id, "Gustavo", "36126170601", null, "+55 45 99988-7766");
        List<ClienteDTO> dtoList = new ArrayList<>();
        dtoList.add(dto);

        when(service.getById(anyLong())).thenReturn(dto);
        //when(service.getByCpf(anyString())).thenReturn(dto);
        when(service.getAll()).thenReturn(dtoList);
        when(service.create(any(ClienteDTO.class))).thenReturn(dto);
        when(service.update(anyLong(), any(ClienteDTO.class))).thenReturn(dto);
        doNothing().when(service).deleteById(anyLong());
    }

    @Test
    void testGetAll() {
        ResponseEntity<List<ClienteDTO>> responseEntity = controller.getAll();

        List<ClienteDTO> dtoList = responseEntity.getBody();

        assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
        assertNotNull(dtoList);
    }

    @Test
    void testGetById() {
        ResponseEntity<ClienteDTO> response = controller.getById(id);

        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(dto, response.getBody());
    }

    @Test
    void testGetByCpf() {
        String cpf = "36126170601";
        ResponseEntity<ClienteDTO> response = controller.getByCpf(cpf);

        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(dto, response.getBody());
    }

    @Test
    void testCreate() {
        ResponseEntity<ClienteDTO> response = controller.create(dto);

        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(dto, response.getBody());
    }

    @Test
    void testUpdate() {
        ResponseEntity<ClienteDTO> response = controller.update(id, dto);

        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(dto, response.getBody());
    }

    @Test
    void testDelete() {
        ResponseEntity<HttpStatus> response = controller.delete(id);

        verify(service).deleteById(id);

        assertEquals(HttpStatus.OK, response.getStatusCode());
    }
}
