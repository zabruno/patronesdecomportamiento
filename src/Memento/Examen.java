package Memento;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class Examen {
    @Getter(AccessLevel.NONE)
    private String respuesta;
    private Historial historial;

    public void respuesta(String respuesta){
        this.respuesta = respuesta;
    }
    public String getRespuesta(){return respuesta;}

    public Memento save (){
        return new Memento(respuesta);
    }

    public void restore (Memento memento){
        respuesta = memento.getEstado();
    }
}
