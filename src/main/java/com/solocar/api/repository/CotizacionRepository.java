package com.solocar.api.repository;

import com.solocar.api.model.Cotizacion;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.sql.Date;
import java.time.LocalDate;
import java.util.List;

@Repository
public class CotizacionRepository {
    
    @Autowired
    private JdbcTemplate jdbcTemplate;
    
    // Crear una nueva cotización
    public int insertar(Cotizacion cotizacion) {
        String sql = "INSERT INTO cotizaciones (tipo_cliente, documento, nombre, email, telefono, " +
                     "producto, descripcion, fecha_estimada, fecha_creacion) " +
                     "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";
        
        return jdbcTemplate.update(sql,
            cotizacion.getTipoCliente(),
            cotizacion.getDocumento(),
            cotizacion.getNombre(),
            cotizacion.getEmail(),
            cotizacion.getTelefono(),
            cotizacion.getProducto(),
            cotizacion.getDescripcion(),
            cotizacion.getFechaEstimada() != null ? Date.valueOf(cotizacion.getFechaEstimada()) : null,
            Date.valueOf(LocalDate.now())
        );
    }
    
    // Listar todas las cotizaciones
    public List<Cotizacion> listarTodas() {
        String sql = "SELECT * FROM cotizaciones ORDER BY fecha_creacion DESC";
        return jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(Cotizacion.class));
    }
    
    // Buscar por ID
    public Cotizacion buscarPorId(int id) {
        String sql = "SELECT * FROM cotizaciones WHERE id = ?";
        return jdbcTemplate.queryForObject(sql, new BeanPropertyRowMapper<>(Cotizacion.class), id);
    }
    
    // Actualizar una cotización
    public int actualizar(Cotizacion cotizacion) {
        String sql = "UPDATE cotizaciones SET tipo_cliente=?, documento=?, nombre=?, email=?, telefono=?, " +
                     "producto=?, descripcion=?, fecha_estimada=? WHERE id=?";
        
        return jdbcTemplate.update(sql,
            cotizacion.getTipoCliente(),
            cotizacion.getDocumento(),
            cotizacion.getNombre(),
            cotizacion.getEmail(),
            cotizacion.getTelefono(),
            cotizacion.getProducto(),
            cotizacion.getDescripcion(),
            cotizacion.getFechaEstimada() != null ? Date.valueOf(cotizacion.getFechaEstimada()) : null,
            cotizacion.getId()
        );
    }
    
    // Eliminar una cotización
    public int eliminar(int id) {
        String sql = "DELETE FROM cotizaciones WHERE id = ?";
        return jdbcTemplate.update(sql, id);
    }
}