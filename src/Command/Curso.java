package Command;

import lombok.*;

import java.util.HashSet;
import java.util.Set;

@Setter
@Getter
//Receiver
public class Curso {
    private String nombre;
    private Set<Alumno> alumnos = new HashSet<>();

    public Curso(String nombre) {
        this.nombre = nombre;
        this.alumnos = new HashSet<>();
    }

    @Override
    public String toString() {
        return nombre;
    }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Curso)) return false;
        Curso curso = (Curso) o;
        return nombre != null && nombre.equals(curso.nombre);
    }

    @Override
    public int hashCode() {
        return nombre != null ? nombre.hashCode() : 0;
    }
}

