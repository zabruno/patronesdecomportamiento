package Command;

import lombok.*;

@Setter
@Getter

public class AlumnoCommand {
    private Command command;
    public AlumnoCommand(Command command) {
        this.command = command;
    }

    public void pressButton(Curso curso, Alumno alumno) {
        command.execute(curso, alumno);
    }
    public void unpressButton(Curso curso, Alumno alumno) {
        command.undo(curso, alumno);
    }
}
