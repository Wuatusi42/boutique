package com.Indexia.Boutique.Services;

import com.Indexia.Boutique.Models.Entitys.Producto;

import java.util.List;

public interface ProductosService {
    public Producto save(Producto producto);
    public List<Producto> findAll();
    public Producto update(Integer idProducto, Producto producto);
    public void delate(Integer idProducto);
}
