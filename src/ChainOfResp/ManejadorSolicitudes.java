package ChainOfResp;


//Handler
public abstract class ManejadorSolicitudes {
    private ManejadorSolicitudes siguiente;

    //Handler next
    public void setSiguiente(ManejadorSolicitudes siguiente) {
        this.siguiente = siguiente;
    }


    public void revisar(String solicitud, int nivel){
        if (!procesar(solicitud, nivel) && siguiente != null) {
            siguiente.revisar(solicitud, nivel);
        }
    }

    protected abstract boolean procesar(String solicitud, int nivel);
}
