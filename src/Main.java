import ChainOfResp.*;
import Command.*;
import Iterator.*;

import java.util.List;
import java.util.Set;

public class Main {
    public static void main(String[] args) {

        System.out.println("\n\n----------Ejercicio 1----------");
        ManejadorSolicitudes asistente = new Asistente();
        ManejadorSolicitudes profesor = new Profesor();
        ManejadorSolicitudes coordinador = new Coordinador();

        asistente.setSiguiente(profesor);
        profesor.setSiguiente(coordinador);

        asistente.revisar("Cambio de comision",1);
        profesor.revisar("Revision de final",3);

        System.out.println("\n\n----------Ejercicio 2----------");
        // Crear cursos
        Curso matematicas = new Curso("Analisis Matematico");
        Curso fisica = new Curso("Física");
        // Crear alumnos
        Alumno bruno = new Alumno(123, "Bruno");
        Alumno candela = new Alumno(456, "Candela");
        // Crear comandos
        Command inscribir = new InscribirseCommand();
        Command abandonar = new AbandonarCommand();
        Command certificado = new CertificadoCommand();
        // Crear invokers para cada alumno
        AlumnoCommand brunoInvoker = new AlumnoCommand(inscribir);
        bruno.setAlumnoCommand(brunoInvoker);
        AlumnoCommand candelaInvoker = new AlumnoCommand(abandonar);
        candela.setAlumnoCommand(candelaInvoker);
        // --- Bruno se inscribe en Matemáticas ---
        bruno.getAlumnoCommand().pressButton(matematicas, bruno);  // Ejecuta Inscribirse
        bruno.getAlumnoCommand().unpressButton(matematicas, bruno); // Undo: Bruno abandona Matemáticas
        bruno.getAlumnoCommand().pressButton(matematicas, bruno);  // Ejecuta Inscribirse nuevamente
        // --- Candela abandona Física (sin estar inscripta, solo prueba undo) ---
        candela.getAlumnoCommand().pressButton(fisica, candela);    // Ejecuta Abandonar
        candela.getAlumnoCommand().unpressButton(fisica, candela);  // Undo: Candela se reinscribe en Física
        // --- Bruno solicita certificado de Matemáticas ---
        AlumnoCommand certificadoInvoker = new AlumnoCommand(certificado);
        bruno.setAlumnoCommand(certificadoInvoker);
        bruno.getAlumnoCommand().pressButton(matematicas, bruno);   // Genera certificado
        bruno.getAlumnoCommand().unpressButton(matematicas, bruno); // Elimina certificado

        System.out.println("\n\n----------Ejercicio 3----------");
        bruno.getAlumnoCommand().setCommand(inscribir);
        bruno.getAlumnoCommand().pressButton(fisica, bruno);
        CursoIterator it = bruno.iterator();
        while (it.hasNext()) {
            System.out.println(it.next().getNombre());  // asumiendo que Curso tiene getNombre()
        }

        System.out.println("\n\n----------Ejercicio 4----------");


    }
}
