package ChainOfResp;

//Clase concreta
public class Coordinador extends ManejadorSolicitudes {
    @Override
    protected boolean procesar(String solicitud, int nivel) {
        System.out.println("Coordinador revisara solicitud: "+solicitud);
        if (nivel <= 3) {
            System.out.println("Asistente reviso solicitud: "+solicitud);
            return true;
        }
        return false;
    }
}
