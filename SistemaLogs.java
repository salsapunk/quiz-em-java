import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

class SistemaLogs {
  private static String hora() {
    return LocalDateTime.now().format(DateTimeFormatter.ofPattern("dd--MM-yyyy HH:mm:ss"));
  }

  public void registrarEvento(String mensagem) {
    System.out.println("\t\t\t~(" + hora() + " " + mensagem + ")");
  }

  public void registrarEvento(String mensagem, int codigo) {
    System.out.println("\t\t\t~(" + hora() + " Código: " + " " + codigo + " " + mensagem + ")");
  }
}
