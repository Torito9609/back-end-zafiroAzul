package com.proyectofinal.backend_zafiro_azul.service;

import com.proyectofinal.backend_zafiro_azul.model.EstadoPedido;
import com.proyectofinal.backend_zafiro_azul.repository.IEstadoPedidoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EstadoPedidoService implements IEstadoPedidoService{

    @Autowired
    private IEstadoPedidoRepository estadoPedidoRepository;

    @Override
    public List<EstadoPedido> getAllEstadoPedido() {
        return estadoPedidoRepository.findAll();
    }

    @Override
    public void saveEstadoPedido(EstadoPedido estadoPedido) {

    }

    @Override
    public void deleteEstadoPedido(Long idEstadoPedido) {

    }

    @Override
    public EstadoPedido findEstadoPedido(Long idEstadoPedido) {
        return null;
    }

    @Override
    public void editEstadoPedido(Long idEstadoPedidoToUpdate, EstadoPedido estadoPedidoUpdated) {

    }
}
