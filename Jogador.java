import java.util.Scanner;

class Jogador {
  public Scanner ler = new Scanner(System.in);
  private String nome;
  private int pontuacao;

  Jogador() {
    setNome();
    this.pontuacao = 0;
  }

  public void setPontuacao(int pontuacao) {
    if (pontuacao < 0) {
      throw new IllegalArgumentException("A pontuação não pode ser negativa!");
    }
    this.pontuacao = pontuacao;
  }

  public int getPontuacao() {
    return this.pontuacao;
  }

  public void setNome() {
    this.nome = ler.nextLine();
    if (this.nome == null || nome.isBlank()) {
      throw new IllegalArgumentException("Nome inválido.");
    }
  }

  public void adicionarPonto() {
    if (pontuacao < 0) {
      throw new IllegalArgumentException("A pontuação não pode ser negativa!");
    }
    this.pontuacao += 1;
  }

  public String getNome() {
    return this.nome;
  }

  public String responder() {
    String resposta = ler.next();
    return resposta;
  }
}
