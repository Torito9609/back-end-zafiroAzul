package com.proyectofinal.backend_zafiro_azul.service;

import com.proyectofinal.backend_zafiro_azul.exception.CategoriaProductoNotFoundException;
import com.proyectofinal.backend_zafiro_azul.exception.EntityConflictException;
import com.proyectofinal.backend_zafiro_azul.exception.InvalidArgumentException;
import com.proyectofinal.backend_zafiro_azul.exception.NoDataFoundException;
import com.proyectofinal.backend_zafiro_azul.model.CategoriaProducto;
import com.proyectofinal.backend_zafiro_azul.repository.ICategoriaProductoRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoriaProductoService implements ICategoriaProductoService{

    @Autowired
    private ICategoriaProductoRepository categoriaProductoRepository;

    @Override
    public List<CategoriaProducto> getAllCategoriaProducto() {
        boolean listaCategoriaVacia = categoriaProductoRepository.findAll().isEmpty();
        if(listaCategoriaVacia){
            throw new NoDataFoundException("productos");
        }
        return categoriaProductoRepository.findAll();
    }

    @Transactional
    @Override
    public void saveCategoriaProducto(CategoriaProducto categoriaProducto) {
        if (categoriaProducto.getNombreCategoria() == null || categoriaProducto.getNombreCategoria().isEmpty()) {
            throw new InvalidArgumentException("categoría", "nombre");
        }
        if (categoriaProducto.getDescripcionCategoria() == null || categoriaProducto.getDescripcionCategoria().isEmpty()) {
            throw new InvalidArgumentException("categoría", "descripción");
        }
        categoriaProductoRepository.save(categoriaProducto);
    }

    @Transactional
    @Override
    public void deleteCategoriaProducto(Long id_categoria) {
        if(!categoriaProductoRepository.existsById(id_categoria)){
            throw new CategoriaProductoNotFoundException(id_categoria);
        }
        categoriaProductoRepository.deleteById(id_categoria);
    }

    @Override
    public CategoriaProducto findCategoriaProducto(Long id_categoria) {
        if(!categoriaProductoRepository.existsById(id_categoria)){
            throw new CategoriaProductoNotFoundException(id_categoria);
        }
        return categoriaProductoRepository.findById(id_categoria).orElseThrow(()->new
                CategoriaProductoNotFoundException(id_categoria));
    }

    @Transactional
    @Override
    public void editCategoriaProducto(Long idCategoriaToUpdate, CategoriaProducto categoriaUpdated) {
        CategoriaProducto categoriaExistente = categoriaProductoRepository.findById(idCategoriaToUpdate).orElseThrow(()->
                new CategoriaProductoNotFoundException(idCategoriaToUpdate));

        //Verificar si el nombre está vacío.
        if (categoriaUpdated.getNombreCategoria() == null || categoriaUpdated.getNombreCategoria().trim().isEmpty()) {
            throw new InvalidArgumentException("Categoría de producto", "nombre");
        }

        //Verificar si la descripción está vacía.
        if (categoriaUpdated.getDescripcionCategoria() == null || categoriaUpdated.getDescripcionCategoria().trim().isEmpty()){
            throw new InvalidArgumentException("Descripción de categoría", "descripción");
        }

        //Verificar si existe nombre de categoría duplicado.
        boolean nombreDuplicado = categoriaProductoRepository.existsByNombreCategoriaAndIdNot(
                categoriaUpdated.getNombreCategoria(), idCategoriaToUpdate);
        if(nombreDuplicado){
            throw new EntityConflictException("Categoría de producto", "nombre", categoriaUpdated.getNombreCategoria());
        }

        // Validar si los valores han cambiado antes de proceder a guardarlos
        if (categoriaExistente.getNombreCategoria().equals(categoriaUpdated.getNombreCategoria()) &&
                categoriaExistente.getDescripcionCategoria().equals(categoriaUpdated.getDescripcionCategoria())) {
            throw new IllegalArgumentException("No se han realizado cambios en los campos de la categoría.");
        }

        categoriaExistente.setNombreCategoria(categoriaUpdated.getNombreCategoria());
        categoriaExistente.setDescripcionCategoria(categoriaUpdated.getDescripcionCategoria());

        categoriaProductoRepository.save(categoriaExistente);

    }
}
