package State;

import Command.Alumno;
import Command.Curso;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
//Context
public class Inscripcion {
    private EstadoInscripcion estado;
    private final Alumno alumno;
    private final Curso curso;

    public Inscripcion(Alumno alumno, Curso curso) {
        this.alumno = alumno;
        this.curso = curso;
        System.out.println("Se creó la inscripcion de "+alumno.getNombre()+" para "+curso.getNombre()+" y esta EN ESPERA");
        this.estado = new EnEspera(); // Estado inicial
    }

    public void inscribir() {
        estado.inscribir(this);
    }

    public void ponerEnEspera() {
        estado.ponerEnEspera(this);
    }

    public void cancelar() {
        estado.cancelar(this);
    }
}
