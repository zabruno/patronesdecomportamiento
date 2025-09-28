package ChainOfResp;

//Clase concreta
public class Profesor extends ManejadorSolicitudes {
    @Override
    protected boolean procesar(String solicitud, int nivel) {
        System.out.println("Profesor revisara solicitud: "+solicitud);
        if (nivel <= 2) {
            System.out.println("Profesor reviso solicitud: "+solicitud);
            return true;
        }
        return false;
    }
}
