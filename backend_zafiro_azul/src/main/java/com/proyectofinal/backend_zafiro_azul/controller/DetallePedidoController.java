package com.proyectofinal.backend_zafiro_azul.controller;

import com.proyectofinal.backend_zafiro_azul.model.DetallePedido;
import com.proyectofinal.backend_zafiro_azul.service.IDetallePedidoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/detalle_pedido")
public class DetallePedidoController {
    @Autowired
    private IDetallePedidoService detallePedidoService;

    @GetMapping("/traer")
    public List<DetallePedido> getCategorias(){
        return detallePedidoService.getAllDetallPedido();
    }

    @PostMapping("/crear")
    public ResponseEntity<String> saveDetalle(@RequestBody DetallePedido detallePedido){
        detallePedidoService.saveDetallePedido(detallePedido);
        return ResponseEntity.ok("Detalle pedido creado con éxito.");
    }

    @DeleteMapping("/borrar/{id}")
    public ResponseEntity<String> deleteDetalle(@PathVariable Long id){
        detallePedidoService.deleteDetallePedido(id);
        return ResponseEntity.ok("El detalle pedido se eliminó con éxito.");
    }

    @PutMapping("/editar/{id}")
    public ResponseEntity<String> editCategoria(@PathVariable Long id,
                                                @RequestBody DetallePedido detallePedido){
        detallePedidoService.editDetallePedido(id, detallePedido);
        return ResponseEntity.ok("La categoría se editó con éxito.");
    }
}
