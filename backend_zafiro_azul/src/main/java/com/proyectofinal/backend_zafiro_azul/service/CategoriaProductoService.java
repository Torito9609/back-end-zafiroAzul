package com.proyectofinal.backend_zafiro_azul.service;

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
        return categoriaProductoRepository.findAll();
    }

    @Transactional
    @Override
    public void saveCategoriaProducto(CategoriaProducto categoriaProducto) {
        categoriaProductoRepository.save(categoriaProducto);
    }

    @Transactional
    @Override
    public void deleteCategoriaProducto(Long id_categoria) {
        categoriaProductoRepository.deleteById(id_categoria);
    }

    @Override
    public CategoriaProducto findCategoriaProducto(Long id_categoria) {
        return categoriaProductoRepository.findById(id_categoria).orElse(null);
    }

    @Transactional
    @Override
    public void editCategoriaProducto(Long idCategoriaToUpdate, CategoriaProducto categoriaUpdated) {
        CategoriaProducto categoriaExistente = categoriaProductoRepository.findById(idCategoriaToUpdate).orElse(null);

        if(categoriaExistente != null){
            categoriaExistente.setNombreCategoria(categoriaUpdated.getNombreCategoria());
            categoriaExistente.setDescripcionCategoria(categoriaUpdated.getDescripcionCategoria());
            categoriaProductoRepository.save(categoriaExistente);
        }

    }
}
