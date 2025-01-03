package com.Indexia.Boutique.Models.Repositorys;

import com.Indexia.Boutique.Models.Entitys.Producto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductoDAO extends JpaRepository<Producto,Integer> {
}
