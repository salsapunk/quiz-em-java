import java.util.Scanner;

public class Pergunta {
  protected static int indice;
  protected String pergunta;
  protected char[] respostasCertas = {
      'F',
      'V',
      'b',
      'c',
  };

  Pergunta() {
    Pergunta.indice += 1;
    if (Pergunta.indice >= 4) {
      // n deixar criar o objeto
      return;
    } else {
      if (Pergunta.indice == 1 || Pergunta.indice == 2) {
        PerguntaVerdadeiroFalso p;
        p.setPergunta();
        this.pergunta = p.getPergunta();
      } else {
        PerguntaMultiplaEscolha p;
        p.setPergunta();
        this.pergunta = p.getPergunta();
      }
    }
  }

  protected boolean validarResposta(char resposta) {
    char respostaCerta = getResposta(Pergunta.indice);
    if (resposta == respostaCerta) {
      return true;
    } else {
      return false;
    }
  }

  protected char getResposta(int indice) {
    char resposta = this.respostasCertas[indice];
    return resposta;
  }

  protected char getPergunta(int indice) {
    System.out.println(this.pergunta);
  }
}

public class PerguntaMultiplaEscolha extends Pergunta {
  public static int indiceLivre = 0;
  private String pergunta;
  private String[] perguntas = {
      "Quais os tipos das formas que o pokémon Castform pode assumir?",
      "Qual o nome da dupla de pokémons baseados nos astros celestes?"
  };

  public void setPergunta() {
    this.pergunta = perguntas[indiceLivre];
    PerguntaMultiplaEscolha.indiceLivre += 1;
  }

  public String getPergunta() {
    return this.pergunta;
  }
}

public class PerguntaVerdadeiroFalso extends Pergunta {
  public static int indiceLivre = 0;
  private String[] perguntas = {
      "A terceira geração de Pokémon se passa em Kanto.",
      "O lendário secreto de Pokémon Emerald é o Deyoxis",
  };

  public void setPergunta() {
    this.pergunta = perguntas[indiceLivre];
    PerguntaVerdadeiroFalso.indiceLivre += 1;
  }

  public String getPergunta() {
    return this.pergunta;
  }
}

// FF: ler char com a resposta (a, b, c, d ou V, F)
class Jogador {
  public char responder() {
    // char resposta = (char) System.in.read();
    return responder();
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
    Pontuavel pontosAcumulados;
    pontosAcumulados = new Pontuavel();

    while (p < 4) {
      SistemaLogs log;
      log = new SistemaLogs();

      log.registrarEvento(pontosAcumulados);

      Jogador novoJogador;
      novoJogador = new Jogador();

      log.registrarEvento(novoJogador);

      Pergunta novaPergunta;
      novaPergunta = new Pergunta();

      log.registrarEvento(novaPergunta);

      String perguntaAtual;
      perguntaAtual = novaPergunta.pergunta;
      System.out.println(perguntaAtual);

      log.registrarEvento(perguntaAtual);

      char resposta;
      resposta = novoJogador.responder();
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
    System.out.println("O quiz acabou!");
    System.out.println("Sua pontuação foi: " + pontosAcumulados.pontuacao);
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

  public void registrarEvento(char resposta, Jogador novoJogador) {
    System.out.println("Evento registrado");
  }

  public void registrarEvento(boolean validacao) {
    System.out.println("Evento registrado");
  }
}
