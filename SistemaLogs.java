import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

class SistemaLogs {
  private static String agora() {
    return LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
  }

  public void registrarEvento(String mensagem) {
    System.out.println(":" + agora() + mensagem + ":");
  }

  public void registrarEvento(String mensagem, int codigo) {
    System.out.println(":" + agora() + "Código: " + codigo + mensagem + ":");
  }
}
