package com.proyectofinal.backend_zafiro_azul.service;

import com.proyectofinal.backend_zafiro_azul.model.EstadoPedido;
import com.proyectofinal.backend_zafiro_azul.repository.IEstadoPedidoRepository;
import jakarta.transaction.Transactional;
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

    @Transactional
    @Override
    public void saveEstadoPedido(EstadoPedido estadoPedido) {
        estadoPedidoRepository.save(estadoPedido);
    }

    @Transactional
    @Override
    public void deleteEstadoPedido(Long idEstadoPedido) {
        estadoPedidoRepository.deleteById(idEstadoPedido);
    }

    @Override
    public EstadoPedido findEstadoPedido(Long idEstadoPedido) {
        return estadoPedidoRepository.findById(idEstadoPedido).orElse(null);
    }

    @Transactional
    @Override
    public void editEstadoPedido(Long idEstadoPedidoToUpdate, EstadoPedido estadoPedidoUpdated) {
        EstadoPedido estadoExistente = estadoPedidoRepository.findById(idEstadoPedidoToUpdate).orElse(null);

        if(estadoExistente != null){
            estadoExistente.setNombreEstado(estadoPedidoUpdated.getNombreEstado());
            estadoPedidoRepository.save(estadoExistente);
        }
    }
}
