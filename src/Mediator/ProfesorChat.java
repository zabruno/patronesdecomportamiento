package Mediator;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter

public class ProfesorChat extends Usuario{


    public ProfesorChat(ChatMediator mediator, String nombre) {
        super(mediator, nombre);
    }

    public ProfesorChat(String nombre) {
        super(nombre);
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
}
