package com.example.devops.repository;

import com.example.devops.model.Producto;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class ProductoRepository {

    private List<Producto> productos = new ArrayList<Producto>();

    public void save(Producto req) {
        productos.add(req);
    }

    public List<Producto> findAll() {
        return productos;
    }

    public void update(Producto req) {
        productos.stream()
                .forEach(p -> {
                    if (p.getId() == req.getId()) {
                        p.setNombre(req.getNombre());
                        p.setPrecio(req.getPrecio());
                        p.setStock(req.getStock());
                    }
                });
    }

    public void deleteById(int id) {
        productos.removeIf(p -> p.getId() == id);
    }

//    public Producto findById(int id) {
//        return productos.stream()
//                .filter(p -> p.getId() == id)
//                .findFirst()
//                .orElse(null);
//    }

}
