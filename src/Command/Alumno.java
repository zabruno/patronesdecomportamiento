package Command;

import lombok.*;

import java.util.HashSet;
import java.util.Set;

@Setter
@Getter
//Invoker
public class Alumno {
    private int legajo;
    private String nombre;
    private Set<Curso> cursos = new HashSet<>();
    private AlumnoCommand alumnoCommand;
    private Set<String> certificados = new HashSet<>();

    public Alumno(int legajo,String nombre) {
        this.legajo = legajo;
        this.nombre = nombre;
        this.cursos = new HashSet<>();
        this.certificados = new HashSet<>();
    }

    @Override
    public String toString() {
        return nombre;
    }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Alumno)) return false;
        Alumno alumno = (Alumno) o;
        return legajo == alumno.legajo; // igualdad solo por legajo
    }
    @Override
    public int hashCode() {
        return Integer.hashCode(legajo);
    }
}
