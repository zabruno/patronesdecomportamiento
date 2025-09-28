package Command;

//Command con execute
public interface Command {
    void execute(Curso curso,Alumno alumno);
    void undo(Curso curso,Alumno alumno);
}
