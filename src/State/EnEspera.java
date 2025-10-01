package State;

// Concrete State: EnEspera
class EnEspera implements EstadoInscripcion {
    public void inscribir(Inscripcion insc) {
        System.out.println("Confirmando inscripción de " + insc.getAlumno() + " en " + insc.getCurso() + " desde lista de espera");
        insc.setEstado(new Inscrito());
    }

    public void ponerEnEspera(Inscripcion insc) {
        System.out.println("El alumno " + insc.getAlumno() + " ya está en lista de espera para " + insc.getCurso());
    }

    public void cancelar(Inscripcion insc) {
        System.out.println("Cancelando inscripción en espera de " + insc.getAlumno() + " para " + insc.getCurso());
        insc.setEstado(new Cancelado());
    }

}
