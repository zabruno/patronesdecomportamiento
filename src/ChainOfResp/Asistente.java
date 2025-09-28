package ChainOfResp;

//Clase concreta
public class Asistente extends ManejadorSolicitudes {
    @Override
    protected boolean procesar(String solicitud, int nivel) {
        System.out.println("Asistente revisara solicitud: "+solicitud);
        if (nivel <= 1) {
            System.out.println("Asistente reviso solicitud: "+solicitud);
            return true;
        }
        return false;
    }
}
