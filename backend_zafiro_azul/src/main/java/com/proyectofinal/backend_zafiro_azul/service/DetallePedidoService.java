package com.proyectofinal.backend_zafiro_azul.service;

import com.proyectofinal.backend_zafiro_azul.model.DetallePedido;
import com.proyectofinal.backend_zafiro_azul.repository.IDetallePedidoRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DetallePedidoService implements IDetallePedidoService{

    @Autowired
    private IDetallePedidoRepository detallePedidoRepository;

    @Override
    public List<DetallePedido> getAllDetallPedido() {
        return detallePedidoRepository.findAll();
    }

    @Transactional
    @Override
    public void saveDetallePedido(DetallePedido detallePedido) {
        detallePedidoRepository.save(detallePedido);
    }

    @Transactional
    @Override
    public void deleteDetallePedido(Long idDetallePedido) {
        detallePedidoRepository.deleteById(idDetallePedido);
    }

    @Override
    public DetallePedido findDetallePedido(Long idDetallePedido) {
        return detallePedidoRepository.findById(idDetallePedido).orElse(null);
    }

    @Transactional
    @Override
    public void editDetallePedido(Long idDetallePedidoToUpdate, DetallePedido detallePedidoUpdated) {
        DetallePedido detalleExistente = detallePedidoRepository.findById(idDetallePedidoToUpdate).orElse(null);

        if(detalleExistente != null){
            detalleExistente.setCantidadVariante(detallePedidoUpdated.getCantidadVariante());
            detalleExistente.setPrecioUnitario(detallePedidoUpdated.getPrecioUnitario());
            detalleExistente.setSubTotal(detallePedidoUpdated.getSubTotal());
            detallePedidoRepository.save(detalleExistente);
        }
    }
}
