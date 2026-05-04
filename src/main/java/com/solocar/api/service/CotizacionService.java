package com.solocar.api.service;

import com.solocar.api.model.Cotizacion;
import com.solocar.api.repository.CotizacionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CotizacionService {
    
    @Autowired
    private CotizacionRepository repository;
    
    public int crear(Cotizacion cotizacion) {
        return repository.insertar(cotizacion);
    }
    
    public List<Cotizacion> listarTodas() {
        return repository.listarTodas();
    }
    
    public Cotizacion buscarPorId(int id) {
        return repository.buscarPorId(id);
    }
    
    public int actualizar(Cotizacion cotizacion) {
        return repository.actualizar(cotizacion);
    }
    
    public int eliminar(int id) {
        return repository.eliminar(id);
    }
}