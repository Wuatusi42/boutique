package com.Indexia.Boutique.Models.Entitys;
import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "tallas")
public class Talla {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_talla")
    private int idTalla;

    @Column(name = "talla", length = 12)
    private String talla;

    @OneToMany(mappedBy = "talla", cascade = CascadeType.ALL)
    private List<ProductoTalla> productoTallas;

    // Getters y setters
    public int getIdTalla() {
        return idTalla;
    }

    public void setIdTalla(int idTalla) {
        this.idTalla = idTalla;
    }

    public String getTalla() {
        return talla;
    }

    public void setTalla(String talla) {
        this.talla = talla;
    }

    public List<ProductoTalla> getProductoTallas() {
        return productoTallas;
    }

    public void setProductoTallas(List<ProductoTalla> productoTallas) {
        this.productoTallas = productoTallas;
    }
}
