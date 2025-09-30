package Mediator;

import java.util.ArrayList;
import java.util.List;

public class ChatRoom implements ChatMediator {
    private List<Usuario> usuarios = new ArrayList<>();

    public void agregarUsuario (Usuario u) {
        usuarios.add(u);
    }

    public void enviar (String mensaje, Usuario usuario) {
        for  (Usuario u : usuarios) {
            if (u != usuario) {
                u.recibir(mensaje);
            }
        }
    }

}
