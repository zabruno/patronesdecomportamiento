import ChainOfResp.*;
import Command.*;
import Iterator.*;
import Mediator.*;
import Memento.*;
import State.Inscripcion;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;


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
        ChatMediator sala = new ChatRoom();
        ProfesorChat profesorChat = new ProfesorChat(sala,"Pablo");
        bruno.setMediator(sala);
        candela.setMediator(sala);
        profesorChat.enviar("Hola!");
        bruno.enviar("Hola profesor!");
        candela.enviar("Buenas tardes!");


        System.out.println("\n\n----------Ejercicio 5----------");
        Examen examenFisica = new Examen();
        Historial hExamenFisica = new Historial();
        examenFisica.setHistorial(hExamenFisica);
        bruno.setExamen(examenFisica);
        bruno.getExamen().respuesta("Respuesta corta");
        bruno.getExamen().getHistorial().guardar(examenFisica.save());
        System.out.println("La respuesta actual es: "+bruno.getExamen().getRespuesta());
        bruno.getExamen().respuesta("Respuesta final");
        bruno.getExamen().getHistorial().guardar(examenFisica.save());
        System.out.println("La respuesta actual es: "+bruno.getExamen().getRespuesta());
        bruno.getExamen().getHistorial().deshacer();
        bruno.getExamen().restore(bruno.getExamen().getHistorial().deshacer());
        System.out.println("La respuesta actual es: "+bruno.getExamen().getRespuesta());


        System.out.println("\n\n----------Ejercicio 6----------");
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
        LocalDateTime fecha = LocalDateTime.parse("2025-09-30 22:30", formatter);
        matematicas.addObserver(bruno); //Podria agregarse al ingresar al curso con el patron command / Agregar un command para unirse a la lista de observers
        matematicas.addObserver(candela);
        matematicas.aviso("Mañana examen :)");
        matematicas.removeObserver(candela);
        matematicas.cambioHorario(fecha);


        System.out.println("\n\n----------Ejercicio 7----------");
        Curso sistemas = new Curso("Sistemas");
        Inscripcion inscripcion = new Inscripcion(bruno,sistemas);
        inscripcion.inscribir();        // EnEspera -> Inscrito
        inscripcion.cancelar();         // Inscrito -> Cancelado


        System.out.println("\n\n----------Ejercicio 8----------");

    }
}
