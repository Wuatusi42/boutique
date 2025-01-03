package com.Indexia.Boutique.Controller;

import com.Indexia.Boutique.Models.Entitys.Producto;
import com.Indexia.Boutique.Services.ProductosService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/productos")
public class ProductoController {

    @Autowired
    private ProductosService productosService;

    @PostMapping("/save")
    public ResponseEntity<?> save(@RequestBody Producto producto) {
        try {
            Producto producto1 = productosService.save(producto);
            return ResponseEntity.status(HttpStatus.OK).body(producto1); // Asegúrate de devolver el objeto guardado
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("error");
        }
    }
    @GetMapping("/findAll")
    public ResponseEntity<?> findAll(){
        try {
            List<Producto> readAll = productosService.findAll();
            return ResponseEntity.status(HttpStatus.OK).body(readAll);
        }catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("error");
        }
    }
    @PutMapping("/update/{id}")
    public ResponseEntity<?> update(@PathVariable Integer id, @RequestBody Producto producto) {
        try {
            Producto productoActualizado = productosService.update(id, producto); // Llamamos al servicio para actualizar
            return ResponseEntity.status(HttpStatus.OK).body(productoActualizado); // Respondemos con 200 y el producto actualizado
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Producto no encontrado"); // Respondemos con 404 si no se encuentra el producto
        }
    }
    @DeleteMapping("/delate/{idProducto}")
    public void delate(@PathVariable Integer idProducto){
        try {
        productosService.delate(idProducto);
        }catch (Exception e){
            ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("error");
        }
    }
}
