package com.Indexia.Boutique.Services.Impl;

import com.Indexia.Boutique.Models.Entitys.Producto;
import com.Indexia.Boutique.Models.Repositorys.ProductoDAO;
import com.Indexia.Boutique.Services.ProductosService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductoServiceImp implements ProductosService {
    @Autowired
    private ProductoDAO productoDAO;
    @Override
    public Producto save(Producto producto) {
        Producto producto1 = productoDAO.save(producto);
        return producto1;
    }

    @Override
    public List<Producto> findAll() {
        List<Producto> readAll = productoDAO.findAll();
        return readAll;
    }

    @Override
    public Producto update(Integer idProducto, Producto producto) {
        Optional<Producto> existe = productoDAO.findById(idProducto);
        if (existe.isPresent()) {
            Producto productoExistente = existe.get();

            // Mantener el ID del producto existente
            producto.setIdProducto(productoExistente.getIdProducto());

            // Guardar el producto actualizado
            return productoDAO.save(producto);
        } else {
            // Producto no encontrado
            throw new RuntimeException("Producto no encontrado");
        }
    }

    @Override
    public void delate(Integer idProducto) {
        productoDAO.deleteById(idProducto);
    }
}
