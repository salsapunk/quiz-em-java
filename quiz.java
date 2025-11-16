public class Pergunta {
  protected static int indice = -1;
  protected String[] perguntas;

  Pergunta() {
    Pergunta.indice += 1;
    if (Pergunta.indice >= 4) {
      // n deixar criar o objeto
      return;
    }
  }

  protected boolean validarResposta(String resposta) {
    String respostaCerta = getResposta(indice);
    if (resposta == respostaCerta) {
      return true;
    } else {
      return false;
    }
  }

  protected String getResposta(int indice) {

  }

  protected String getPergunta(int indice) {

  }

  protected String setPergunta(String[] perguntas) {
    this.perguntas = perguntas;
  }
}

public class PerguntaMultiplaEscolha extends Pergunta {
  private String[] perguntas = {
      "Quais os tipos que o pokémon Castform pode evoluir?",
      "Qual o nome da dupla de pokémons baseados nos astros celestes?"
  };

  public boolean validarResposta(String resposta) {
    super.validarResposta(resposta);
  }

  public void setPergunta() {
    super.setPergunta(this.perguntas);
  }

  public String getPergunta(int indice) {
    super.getPergunta(indice);
  }
}

public class PerguntaVerdadeiroFalse extends Pergunta {
  private String[] perguntas = {
      "A terceira geração de Pokémon se passa em Kanto.",
      "O lendário secreto de Pokémon Emerald é o Deyoxis",
  };

  public boolean validarResposta(String resposta) {
    super.validarResposta(resposta);
  }

  public void setPergunta() {
    super.setPergunta(this.perguntas);
  }
}

class Jogador {
  private void responder() {
    // pegar String do usuário;
    return;
  }
}

public class Quiz {
  static int numeroDeQuizes = 0;

  static int getTotalQuizzesJogos() {
    System.out.println("Você jogou o quiz" + numeroDeQuizes + "vezes!");
  }

  public static void main(String[] args) {
    numeroDeQuizes++;
    int p = 0;
    while (p < 10) {

      // RANDOMIZAR P CHAMAR UM TIPO DE PERGUNTA E ARMAZENAR A QUANTIDADE DISPONÍVEL
      // NO ATRIBUTO DA PERGUNTA FILHA

      SistemaLogs log;
      log = new SistemaLogs();

      Pontuavel pontosAcumulados;
      pontosAcumulados = new Pontuavel();

      log.registrarEvento(pontosAcumulados);

      Jogador novoJogador;
      novoJogador = new Jogador();

      log.registrarEvento(novoJogador);

      Pergunta novaPergunta;
      novaPergunta = new Pergunta();

      log.registrarEvento(novaPergunta);

      String perguntaAtual;
      perguntaAtual = novaPergunta.setPergunta();

      log.registrarEvento(perguntaAtual);

      String resposta;
      // resposta = novoJogador.responder();
      log.registrarEvento(resposta, novoJogador);

      boolean validacao;
      validacao = novaPergunta.validarResposta(resposta);

      log.registrarEvento(validacao);

      if (!validacao) {
        System.out.println("A resposta está incorreta!");
      } else {
        System.out.println("A resposta está correta!");
      }
      pontosAcumulados.calcularPontuacao(validacao);
      p++;
    }
  }
}

class Pontuavel {
  int pontuacao = 0;

  public void calcularPontuacao(boolean ponto) {
    if (ponto == true) {
      this.pontuacao++;
    }
  }
}

class SistemaLogs {
  public void registrarEvento(Pontuavel pontosAcumulados) {
    System.out.println("Evento registrado");
  }

  public void registrarEvento(Jogador novoJogador) {
    System.out.println("Evento registrado");
  }

  public void registrarEvento(Pergunta novaPergunta) {
    System.out.println("Evento registrado");
  }

  public void registrarEvento(String pergunta) {
    System.out.println("Evento registrado");
  }

  public void registrarEvento(String resposta, Jogador novoJogador) {
    System.out.println("Evento registrado");
  }

  public void registrarEvento(boolean validacao) {
    System.out.println("Evento registrado");
  }
}
