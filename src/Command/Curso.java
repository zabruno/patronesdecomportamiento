package Command;

import Observer.*;
import lombok.*;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Setter
@Getter
//Receiver
public class Curso implements Subject {
    private String nombre;
    private Set<Alumno> alumnos = new HashSet<>();
    private List<Observer> observers = new ArrayList<>();
    private LocalDateTime horaInicio;

    public Curso(String nombre) {
        this.nombre = nombre;
        this.alumnos = new HashSet<>();
    }

    public void addObserver (Observer o) {
        observers.add(o);
    }

    public void removeObserver (Observer o) {
        observers.remove(o);
    }

    public void aviso (String mensaje) {
        notifyObservers(mensaje);
    }

    public void cambioHorario (LocalDateTime horaInicio){
        this.horaInicio = horaInicio;
        String mensaje = "Se cambio la hora de inicio de "+nombre+ ": "+horaInicio.toString();
        notifyObservers(mensaje);
    }

    public void notifyObservers(String mensaje) {
        for (Observer o : observers) {
            o.update(mensaje);
        }
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

