package State;

// Concrete State: Inscrito
class Inscrito implements EstadoInscripcion {
    public void inscribir(Inscripcion insc) {
        System.out.println("El alumno " + insc.getAlumno().getNombre() + " ya está inscrito en " + insc.getCurso().getNombre());
    }

    public void ponerEnEspera(Inscripcion insc) {
        System.out.println("Moviendo a " + insc.getAlumno().getNombre() + " a lista de espera para " + insc.getCurso().getNombre());
        insc.setEstado(new EnEspera());
    }

    public void cancelar(Inscripcion insc) {
        System.out.println("Cancelando inscripción de " + insc.getAlumno().getNombre() + " en " + insc.getCurso().getNombre());
        insc.setEstado(new Cancelado());
    }
}
