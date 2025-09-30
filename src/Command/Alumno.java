package Command;

import Iterator.*;
import lombok.*;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;


@Setter
@Getter
//Invoker
public class Alumno {
    private int legajo;
    private String nombre;
    private List<Curso> cursos;
    private AlumnoCommand alumnoCommand;
    private Set<String> certificados = new HashSet<>();

    public Alumno(int legajo,String nombre) {
        this.legajo = legajo;
        this.nombre = nombre;
        this.cursos = new ArrayList<>();
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

    public CursoIterator iterator(){
        return new AlumnoIterator(cursos);
    }

    public static class AlumnoIterator implements CursoIterator {
        private List<Curso> cursos;
        private int posicion=0;

        public AlumnoIterator(List<Curso> cursos){
            this.cursos = cursos;
        }
        @Override
        public boolean hasNext() {
            return posicion < cursos.size();
        }
        @Override
        public Curso next() {
            return cursos.get(posicion++);
        }
    }
}
