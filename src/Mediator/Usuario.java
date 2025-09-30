package Mediator;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter

//Se coloco extends en clase Alumno de Command
public abstract class Usuario {
    @Setter(AccessLevel.NONE)
    protected ChatMediator mediator;
    protected String nombre;

    public Usuario (ChatMediator mediator, String nombre) {
        this.mediator = mediator;
        mediator.agregarUsuario(this);
        this.nombre = nombre;
    }
    public Usuario (String nombre) {
        this.nombre = nombre;
    }

    public void setMediator(ChatMediator mediator) {
        this.mediator = mediator;
        mediator.agregarUsuario(this);
    }

    public abstract void enviar (String mensaje);
    public abstract void recibir (String mensaje);
}
