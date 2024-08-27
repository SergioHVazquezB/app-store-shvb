package com.dwi.app_store_shvb.services.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.dwi.app_store_shvb.dto.ProductoDto;
import com.dwi.app_store_shvb.models.entities.Producto;
import com.dwi.app_store_shvb.repositories.ProductoRepository;
import com.dwi.app_store_shvb.services.ProductoService;

@Service
public class ProdcutoServiceImpl implements ProductoService{

    @Autowired
    private ProductoRepository productoRepository;


    @Override
    @Transactional(readOnly = true)
    public List<Producto> findAll() {
        return (List<Producto>) productoRepository.findAll();
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<Producto> findById(Long id) {
        return productoRepository.findById(id);
    }

    @Override
    @Transactional
    public Producto save(ProductoDto producto) {
        Producto productoDb = new Producto();
        productoDb.setNombre(producto.getNombre());
        productoDb.setDescripcion(producto.getDescripcion());
        productoDb.setPrecio(producto.getPrecio());

        return productoRepository.save(productoDb);
    }

    @Override
    @Transactional
    public Optional<Producto> update(ProductoDto producto, Long id) {
        Optional<Producto> productoDb = productoRepository.findById(id); 
        Producto productoOptional = null;
        if(productoDb.isPresent()) {
            Producto productos = productoDb.orElseThrow();
            productos.setNombre(producto.getNombre());
            productos.setDescripcion(producto.getDescripcion());
            productos.setPrecio(producto.getPrecio());
            productoOptional = productoRepository.save(productos);
        }
        return Optional.ofNullable(productoOptional);
    }

    @Override
    @Transactional
    public void remove(Long id) {
        productoRepository.deleteById(id);
    }

}
