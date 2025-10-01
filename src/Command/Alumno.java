package Command;

import Iterator.*;
import Mediator.*;
import Memento.*;
import Observer.*;
import lombok.*;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;


@Setter
@Getter
//Invoker
public class Alumno extends Usuario implements Observer {
    private int legajo;
    private String nombre;
    private List<Curso> cursos;
    private AlumnoCommand alumnoCommand;
    private Set<String> certificados = new HashSet<>();
    private Examen examen;

    public Alumno(int legajo,String nombre) {
        super(nombre);
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
    @Override
    public void enviar(String mensaje) {
        System.out.println(nombre+" envia: "+mensaje);
        mediator.enviar(mensaje,this);
    }
    @Override
    public void recibir (String mensaje) {
        System.out.println(nombre+" recibe: "+mensaje);
    }

    public CursoIterator iterator(){
        return new AlumnoIterator(cursos);
    }

    @Override
    public void update(String mensaje) {
        System.out.println(nombre+" fue notificad@: "+mensaje);
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
