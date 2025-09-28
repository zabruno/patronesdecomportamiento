import ChainOfResp.*;
import Command.*;

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
        Command inscribirMatematica = new InscribirseCommand();
        Command abandonarFisica = new AbandonarCommand();
        Command solicitarCertificado = new CertificadoCommand();
        // Crear invokers para cada alumno
        AlumnoCommand brunoInvoker = new AlumnoCommand(inscribirMatematica);
        bruno.setAlumnoCommand(brunoInvoker);
        AlumnoCommand candelaInvoker = new AlumnoCommand(abandonarFisica);
        candela.setAlumnoCommand(candelaInvoker);
        // --- Bruno se inscribe en Matemáticas ---
        bruno.getAlumnoCommand().pressButton(matematicas, bruno);  // Ejecuta Inscribirse
        bruno.getAlumnoCommand().unpressButton(matematicas, bruno); // Undo: Bruno abandona Matemáticas
        bruno.getAlumnoCommand().pressButton(matematicas, bruno);  // Ejecuta Inscribirse nuevamente
        // --- Candela abandona Física (sin estar inscripta, solo prueba undo) ---
        candela.getAlumnoCommand().pressButton(fisica, candela);    // Ejecuta Abandonar
        candela.getAlumnoCommand().unpressButton(fisica, candela);  // Undo: Candela se reinscribe en Física
        // --- Bruno solicita certificado de Matemáticas ---
        AlumnoCommand certificadoInvoker = new AlumnoCommand(solicitarCertificado);
        bruno.setAlumnoCommand(certificadoInvoker);
        bruno.getAlumnoCommand().pressButton(matematicas, bruno);   // Genera certificado
        bruno.getAlumnoCommand().unpressButton(matematicas, bruno); // Elimina certificado

        System.out.println("\n\n----------Ejercicio 3----------");

    }
}
