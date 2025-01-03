package com.Indexia.Boutique.Models.Entitys;
import jakarta.persistence.*;


@Entity
@Table(name = "marcas")
public class Marca {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_marca")
    private int idMarca;

    @Column(name = "nombre", length = 45)
    private String nombre;

    @ManyToOne
    @JoinColumn(name = "fk_productos", nullable = false)
    private Producto producto;

    // Getters y setters
    public int getIdMarca() {
        return idMarca;
    }

    public void setIdMarca(int idMarca) {
        this.idMarca = idMarca;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Producto getProducto() {
        return producto;
    }

    public void setProducto(Producto producto) {
        this.producto = producto;
    }
}
