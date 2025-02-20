package com.proyectofinal.backend_zafiro_azul.controller;

import com.proyectofinal.backend_zafiro_azul.model.CategoriaProducto;
import com.proyectofinal.backend_zafiro_azul.service.ICategoriaProductoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/categorias")
@RestController
public class CategoriaProductoController {

    @Autowired
    private ICategoriaProductoService categoriaProductoService;

    @GetMapping("/traer")
    public List<CategoriaProducto> getCategorias(){
        return categoriaProductoService.getAllCategoriaProducto();
    }

    @PostMapping("/crear")
    public ResponseEntity<String> saveCategoria(@RequestBody CategoriaProducto categoriaProducto){
        categoriaProductoService.saveCategoriaProducto(categoriaProducto);
        return ResponseEntity.ok("Categoría creada con éxito.");
    }

    @DeleteMapping("/borrar/{id}")
    public ResponseEntity<String> deleteCategoria(@PathVariable Long id){
        categoriaProductoService.deleteCategoriaProducto(id);
        return ResponseEntity.ok("La categoría se eliminó con éxito.");
    }

    @PutMapping("/editar/{id}")
    public ResponseEntity<String> editCategoria(@PathVariable Long id,
                                                @RequestBody CategoriaProducto categoriaUpdated){
        categoriaProductoService.editCategoriaProducto(id, categoriaUpdated);
        return ResponseEntity.ok("La categoría se editó con éxito.");
    }
}
