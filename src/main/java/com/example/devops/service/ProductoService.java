package com.example.devops.service;

import com.example.devops.model.Producto;
import com.example.devops.repository.ProductoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductoService {

    @Autowired
    private ProductoRepository productoRepo;

    public Producto save(Producto req) {
        productoRepo.save(req);
        return req;
    }

    public List<Producto> findAll() {
        return productoRepo.findAll();
    }

    public Producto update(Producto req) {
        productoRepo.update(req);
        List<Producto> productos = productoRepo.findAll();
        return productos.stream()
                .filter(p -> p.getId() == req.getId())
                .findFirst()
                .orElse(null);
    }

    public String delete(int id) {
        productoRepo.deleteById(id);
        return "Producto eliminado con exito";
    }

    public Producto findById(int id) {
        return productoRepo.findById(id);
    }

    public String deleteAll() {
        productoRepo.deleteAll();
        return "Productos eliminados con exito";
    }

    public List<Producto> productStockNoAvalible() {
        return productoRepo.productStockNoAvalible();
    }

}
