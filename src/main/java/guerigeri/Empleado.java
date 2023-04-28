/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package guerigeri;

import java.time.LocalDate;
import java.util.Objects;

/**
 *
 * @author guerig
 */
public class Empleado {
    private String apellidos;
    private String nombre;
    private String dni;
    private String puesto;
    private LocalDate fechaPosesion;
    private LocalDate fechaCese;
    private String telefono;
    private String evaluador;
    private String coordinador;

    public Empleado() {
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }



    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public String getPuesto() {
        return puesto;
    }

    public void setPuesto(String puesto) {
        this.puesto = puesto;
    }

    public LocalDate getFechaPosesion() {
        return fechaPosesion;
    }

    public void setFechaPosesion(LocalDate fechaPosesion) {
        this.fechaPosesion = fechaPosesion;
    }

    public LocalDate getFechaCese() {
        return fechaCese;
    }

    public void setFechaCese(LocalDate fechaCese) {
        this.fechaCese = fechaCese;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getEvaluador() {
        return evaluador;
    }

    public void setEvaluador(String evaluador) {
        this.evaluador = evaluador;
    }

    public String getCoordinador() {
        return coordinador;
    }

    public void setCoordinador(String coordinador) {
        this.coordinador = coordinador;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 29 * hash + Objects.hashCode(this.dni);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Empleado other = (Empleado) obj;
        return Objects.equals(this.dni, other.dni);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Empleado{");
        sb.append("Apellidos = ").append(apellidos).append(";");
        sb.append("Nombre = ").append(nombre).append(";");
        sb.append("Dni = ").append(dni).append(";");
        sb.append("Puesto = ").append(puesto).append(";");
        sb.append("FechaPosesion = ").append(fechaPosesion).append(";");
        sb.append("FechaCese = ").append(fechaCese).append(";");
        sb.append("Telefono = ").append(telefono).append(";");
        sb.append("Evaluador = ").append(evaluador).append(";");
        sb.append("Coordinador = ").append(coordinador).append(";");
        sb.append('}');
        return sb.toString();
    }
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
}
