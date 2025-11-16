//criar uma array de strings com as respostas e perguntas onde um item tem o mesmo índice que o seu correspondente

public class Pergunta {
  private int indexAtual;
  private String[] perguntas = new String[4];

  public boolean validarResposta(String resposta) {
    String respostaCerta = getResposta(indexAtual);
    if (resposta == respostaCerta) {
      return true;
    } else {
      return false;
    }
  }

  public String getResposta(int indice) {
    // return respostaCorreta;
  }

  public String setPergunta() {
    // seta o indexAtual;
    // return perguntaAtual;
  }
}

public class PerguntaMultiplaEscolha extends Pergunta {

}

public class PerguntaVerdadeiroFalse extends Pergunta {

}

class Jogador {
  private void responder() {
    // pegar String do usuário;
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
      Pontuavel pontosAcumulados;
      pontosAcumulados = new Pontuavel();

      // registrarEvento(Pontuavel pontosAcumulados);

      Jogador novoJogador;
      novoJogador = new Jogador();

      // registrarEvento(Jogador novoJogador);

      Pergunta novaPergunta;
      novaPergunta = new Pergunta();

      // registrarEvento(Pergunta novaPergunta);

      String perguntaAtual;
      perguntaAtual = novaPergunta.setPergunta();

      // registrarEvento(String pergunta);

      String resposta;
      // resposta = novoJogador.responder();
      // registrarEvento(String resposta, Jogador novoJogador);

      boolean validacao;
      validacao = novaPergunta.validarResposta(resposta);

      // registrarEvento(String resposta);

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
  void registrarEvento() {

  };
}
