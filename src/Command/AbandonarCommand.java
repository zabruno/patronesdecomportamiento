package Command;

public class AbandonarCommand implements Command {

    @Override
    public void execute(Curso curso, Alumno alumno) {
        boolean eliminadoAlumno = curso.getAlumnos().remove(alumno);
        boolean eliminadoCurso = alumno.getCursos().remove(curso);

        if (eliminadoAlumno && eliminadoCurso) {
            System.out.println("El alumno " + alumno + " abandonó el curso " + curso);
        } else {
            System.out.println("El alumno " + alumno + " no estaba inscripto en " + curso);
        }
    }

    @Override
    public void undo(Curso curso, Alumno alumno) {
        if (curso.getAlumnos().add(alumno) && alumno.getCursos().add(curso)) {
            System.out.println("El alumno " + alumno + " se volvió a inscribir en " + curso);
        } else {
            System.out.println("El alumno " + alumno + " ya estaba inscripto en " + curso);
        }
    }
}

