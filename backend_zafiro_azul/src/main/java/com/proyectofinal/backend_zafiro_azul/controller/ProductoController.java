package com.proyectofinal.backend_zafiro_azul.controller;

import com.proyectofinal.backend_zafiro_azul.model.Producto;
import com.proyectofinal.backend_zafiro_azul.service.IProductoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/productos")
public class ProductoController {

    @Autowired
    private IProductoService productoService;

    //Obtener todos los productos
    @GetMapping("/get")
    public ResponseEntity<List<Producto>> getAllProductos() {
        List<Producto> productos = productoService.getAllProductos();
        return ResponseEntity.ok(productos);
    }

    //Obtener un producto por ID
    @GetMapping("/get/{id}")
    public ResponseEntity<Producto> getProductoById(@PathVariable Long id) {
        Producto producto = productoService.findProducto(id);
        return ResponseEntity.ok(producto);
    }

    //Crear un nuevo producto
    @PostMapping("/new")
    public ResponseEntity<String> createProducto(@RequestBody Producto producto) {
        productoService.createProducto(producto);
        return ResponseEntity.ok("Producto creado exitosamente");
    }

    //Actualizar un producto existente
    @PutMapping("/update/{id}")
    public ResponseEntity<String> updateProducto(@PathVariable Long id, @RequestBody Producto productoUpdated) {
        Producto productoExistente = productoService.findProducto(id);
        if (productoExistente != null) {
            productoService.updateProducto(id, productoUpdated);
            return ResponseEntity.ok("Producto actualizado correctamente");
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    //Eliminar un producto
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteProducto(@PathVariable Long id) {
        Producto productoExistente = productoService.findProducto(id);
        if (productoExistente != null) {
            productoService.deleteProducto(id);
            return ResponseEntity.ok("Producto eliminado exitosamente");
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
