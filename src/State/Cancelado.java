package State;

// Concrete State: Cancelado
class Cancelado implements EstadoInscripcion {
    public void inscribir(Inscripcion insc) {
        System.out.println("Inscribiendo a " + insc.getAlumno() + " en el curso " + insc.getCurso());
        insc.setEstado(new Inscrito());
    }

    public void ponerEnEspera(Inscripcion insc) {
        System.out.println("Agregando a " + insc.getAlumno() + " a lista de espera para " + insc.getCurso());
        insc.setEstado(new EnEspera());
    }

    public void cancelar(Inscripcion insc) {
        System.out.println("La inscripción de " + insc.getAlumno() + " ya está cancelada");
    }
}