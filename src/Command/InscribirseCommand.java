package Command;

public class InscribirseCommand implements Command {

    @Override
    public void execute(Curso curso, Alumno alumno) {
        boolean agregadoAlumno = curso.getAlumnos().add(alumno);
        boolean agregadoCurso = alumno.getCursos().add(curso);

        if (agregadoAlumno && agregadoCurso) {
            System.out.println("El alumno " + alumno + " se unió al curso " + curso);
        } else {
            System.out.println("El alumno " + alumno + " ya estaba inscripto en " + curso);
        }
    }
    @Override
    public void undo(Curso curso, Alumno alumno) {
        if (curso.getAlumnos().remove(alumno) && alumno.getCursos().remove(curso)) {
            System.out.println("El alumno " + alumno + " abandonó el curso " + curso);
        } else {
            System.out.println("El alumno " + alumno + " no estaba inscripto en " + curso);
        }
    }
}
