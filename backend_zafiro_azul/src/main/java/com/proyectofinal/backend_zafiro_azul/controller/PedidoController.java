package com.proyectofinal.backend_zafiro_azul.controller;

import com.proyectofinal.backend_zafiro_azul.model.Pedido;
import com.proyectofinal.backend_zafiro_azul.service.IPedidoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/pedidos")
public class PedidoController {

    @Autowired
    private IPedidoService pedidoService;

    //Endpoint para obtener todos los pedidos
    @GetMapping("/traer")
    public List<Pedido> getPedido(){
        return pedidoService.getAllPedidos();
    }

    //Endpoint para obtener un pedido por id
    @GetMapping("/traer/{id}")
    public ResponseEntity<Pedido> findPedido(@PathVariable Long id){
        Pedido pedido = pedidoService.findPedido(id);
        return ResponseEntity.ok(pedido);
    }

    //Endpoint para crear un pedido
    @PostMapping("/crear")
    public String createPedido(@RequestBody Pedido pedido){
        pedidoService.createPedido(pedido);
        return "Su pedido ha sido creado";
    }

    //Endpoint para borrar un pedido
    @DeleteMapping("/borrar/{id}")
    public String deletePedido(@PathVariable Long id){
        pedidoService.deletePedido(id);
        return "El pedido ha sido eliminado";
    }

    //Endpoint para modificar un pedido
    @PutMapping("/editar/{id}")
    public ResponseEntity<String> updatePedido(
            @PathVariable Long id,
            @RequestBody Pedido pedidoUpdated
    ){
        pedidoService.updatePedido(id, pedidoUpdated);
        return ResponseEntity.ok("El pedido ha sido actualizado");
    }


}
