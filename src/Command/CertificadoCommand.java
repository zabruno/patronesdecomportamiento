package Command;

public class CertificadoCommand implements Command {

    @Override
    public void execute(Curso curso, Alumno alumno) {
        String certificado = "El alumno " + alumno + " cursa " + curso;
        alumno.getCertificados().add(certificado);
        System.out.println("Se generó el certificado: " + certificado);
    }

    @Override
    public void undo(Curso curso, Alumno alumno) {
        String certificado = "El alumno " + alumno + " cursa " + curso;
        boolean eliminado = alumno.getCertificados().remove(certificado);

        if (eliminado) {
            System.out.println("Se eliminó el certificado: " + certificado);
        } else {
            System.out.println("No se encontró el certificado para eliminar.");
        }
    }
}

