package State;
//State
interface EstadoInscripcion {
    void inscribir(Inscripcion inscripcion);
    void ponerEnEspera(Inscripcion inscripcion);
    void cancelar(Inscripcion inscripcion);
}
