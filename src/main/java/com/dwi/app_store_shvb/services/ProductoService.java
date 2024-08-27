package com.dwi.app_store_shvb.services;

import java.util.Optional;
import java.util.List;

import com.dwi.app_store_shvb.dto.ProductoDto;
import com.dwi.app_store_shvb.models.entities.Producto;

public interface ProductoService {

    List<Producto> findAll();

    Optional<Producto> findById(Long id);

    Producto save(ProductoDto producto);

    Optional<Producto> update(ProductoDto producto, Long id);

    void remove(Long id);
}
