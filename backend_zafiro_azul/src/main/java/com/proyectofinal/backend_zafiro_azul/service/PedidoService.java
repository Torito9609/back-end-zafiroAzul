package com.proyectofinal.backend_zafiro_azul.service;

import com.proyectofinal.backend_zafiro_azul.model.Pedido;
import com.proyectofinal.backend_zafiro_azul.repository.IPedidoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PedidoService implements IPedidoService{

    @Autowired
    private IPedidoRepository pedidoRepository;

    @Override
    public List<Pedido> getAllPedidos() {
        List<Pedido> listaPedidos = pedidoRepository.findAll();
        return listaPedidos;
    }

    @Override
    public void createPedido(Pedido pedido) {
        pedidoRepository.save(pedido);

    }

    @Override
    public void deletePedido(Long idPedido) {
        pedidoRepository.deleteById(idPedido);
    }

    @Override
    public Pedido findPedido(Long idPedido) {
        Pedido pedido = pedidoRepository.findById(idPedido).orElse(null);
        return pedido;
    }

    @Override
    public void updatePedido(Long idPedidoToUpdate, Pedido pedidoUpdated) {
        Pedido pedidoToUpdate = pedidoRepository.findById(idPedidoToUpdate).orElse(null);
        if(pedidoToUpdate != null){
            pedidoToUpdate.setFechaPedido(pedidoUpdated.getFechaPedido());
            pedidoToUpdate.setTotalPedido(pedidoUpdated.getTotalPedido());

            pedidoRepository.save(pedidoToUpdate);
        }
    }
}
