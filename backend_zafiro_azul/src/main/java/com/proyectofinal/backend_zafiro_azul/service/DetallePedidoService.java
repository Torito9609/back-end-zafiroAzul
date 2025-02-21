package com.proyectofinal.backend_zafiro_azul.service;

import com.proyectofinal.backend_zafiro_azul.exception.CategoriaProductoNotFoundException;
import com.proyectofinal.backend_zafiro_azul.exception.DetallePedidoNotFoundException;
import com.proyectofinal.backend_zafiro_azul.exception.InvalidArgumentException;
import com.proyectofinal.backend_zafiro_azul.exception.NoDataFoundException;
import com.proyectofinal.backend_zafiro_azul.model.DetallePedido;
import com.proyectofinal.backend_zafiro_azul.repository.IDetallePedidoRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;

@Service
public class DetallePedidoService implements IDetallePedidoService{

    @Autowired
    private IDetallePedidoRepository detallePedidoRepository;

    @Override
    public List<DetallePedido> getAllDetallPedido() {
        boolean listaDetallePedidoVacia = detallePedidoRepository.findAll().isEmpty();
        if(listaDetallePedidoVacia){
            throw new NoDataFoundException("detalles de pedidos");
        }
        return detallePedidoRepository.findAll();
    }

    @Transactional
    @Override
    public void saveDetallePedido(DetallePedido detallePedido) {
        //Verificar si tiene Pedido
        if(detallePedido.getPedido() == null){
            throw new InvalidArgumentException("detalle pedido", "pedido");
        }
        //Verificar si tiene VarianteProducto
        if(detallePedido.getVariante() != null){
            throw new InvalidArgumentException("detalle pedido", "variante");
        }

        BigDecimal calculadoSubTotal = detallePedido.getPrecioUnitario()
                .multiply(BigDecimal.valueOf(detallePedido.getCantidadVariante()));
        if (!detallePedido.getSubTotal().equals(calculadoSubTotal)) {
            throw new IllegalArgumentException("El subtotal no coincide con la cantidad y el precio unitario.");
        }
        detallePedidoRepository.save(detallePedido);
    }

    @Transactional
    @Override
    public void deleteDetallePedido(Long idDetallePedido) {
        if(!detallePedidoRepository.existsById(idDetallePedido)){
            throw new DetallePedidoNotFoundException(idDetallePedido);
        }
        detallePedidoRepository.deleteById(idDetallePedido);
    }

    @Override
    public DetallePedido findDetallePedido(Long idDetallePedido) {
        if(!detallePedidoRepository.existsById(idDetallePedido)){
            throw new DetallePedidoNotFoundException(idDetallePedido);
        }
        return detallePedidoRepository.findById(idDetallePedido).orElseThrow(()->new
                DetallePedidoNotFoundException(idDetallePedido));
    }

    @Transactional
    @Override
    public void editDetallePedido(Long idDetallePedidoToUpdate, DetallePedido detallePedidoUpdated) {
        DetallePedido detalleExistente = detallePedidoRepository.findById(idDetallePedidoToUpdate)
                .orElseThrow(() -> new DetallePedidoNotFoundException(idDetallePedidoToUpdate));

        if (detallePedidoUpdated.getCantidadVariante() <= 0) {
            throw new IllegalArgumentException("La cantidad de variantes debe ser mayor a cero.");
        }

        if (detallePedidoUpdated.getPrecioUnitario().compareTo(BigDecimal.ZERO) <= 0) {
            throw new IllegalArgumentException("El precio unitario debe ser mayor a cero.");
        }

        BigDecimal calculadoSubTotal = detallePedidoUpdated.getPrecioUnitario()
                .multiply(BigDecimal.valueOf(detallePedidoUpdated.getCantidadVariante()));
        if (!detallePedidoUpdated.getSubTotal().equals(calculadoSubTotal)) {
            throw new IllegalArgumentException("El subtotal no coincide con la cantidad y el precio unitario.");
        }
        
        detalleExistente.setCantidadVariante(detallePedidoUpdated.getCantidadVariante());
        detalleExistente.setPrecioUnitario(detallePedidoUpdated.getPrecioUnitario());
        detalleExistente.setSubTotal(detallePedidoUpdated.getSubTotal());

        detallePedidoRepository.save(detalleExistente);

    }
}
