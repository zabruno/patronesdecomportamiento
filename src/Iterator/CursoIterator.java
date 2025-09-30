package Iterator;

import Command.Curso;
//Implementado en clases Curso y Alumno de package Command

public interface CursoIterator {
    boolean hasNext();
    Curso next();
}
