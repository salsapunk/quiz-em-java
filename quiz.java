import java.util.Scanner;

public class Quiz {
  static int numeroDeQuizes = 0;

  static void getTotalQuizzesJogos() {
    System.out.println("Você jogou o quiz" + numeroDeQuizes + "vezes!");
  }

  public static void main(String[] args) {
    numeroDeQuizes++;
    int p = 0;
    Pontuavel pontosAcumulados;
    pontosAcumulados = new Pontuavel();

    SistemaLogs log;
    log = new SistemaLogs();

    log.registrarEvento(p);
    while (p < 4) {
      log.registrarEvento(pontosAcumulados);

      Jogador novoJogador;
      novoJogador = new Jogador();

      log.registrarEvento(novoJogador);

      boolean validacao;

      if (p < 2) {
        PerguntaMultiplaEscolha novaPergunta;
        novaPergunta = new PerguntaMultiplaEscolha();

        log.registrarEvento(novaPergunta);

        novaPergunta.setPergunta();
        novaPergunta.setResposta();
        novaPergunta.setRespostaCerta();
        System.out.println(novaPergunta.getRespostaCerta());

        String perguntaAtual;
        perguntaAtual = novaPergunta.getPergunta();
        System.out.println(perguntaAtual);
        System.out.println(novaPergunta.getRespostas()); // DEGUB

        log.registrarEvento(perguntaAtual);

        String resposta;
        resposta = novoJogador.responder();
        System.out.println(resposta); // DEBUG
        log.registrarEvento(resposta, novoJogador);

        validacao = novaPergunta.validarResposta(resposta);
        log.registrarEvento(validacao);
      } else {
        PerguntaVerdadeiroFalso novaPergunta;
        novaPergunta = new PerguntaVerdadeiroFalso();

        novaPergunta.setPergunta();
        novaPergunta.setRespostaCerta();

        log.registrarEvento(novaPergunta);

        String perguntaAtual;
        perguntaAtual = novaPergunta.pergunta;
        System.out.println(perguntaAtual);

        log.registrarEvento(perguntaAtual);

        String resposta;
        resposta = novoJogador.responder();
        log.registrarEvento(resposta, novoJogador);

        validacao = novaPergunta.validarResposta(resposta);
        log.registrarEvento(validacao);
      }
      if (validacao) {
        System.out.println("A resposta está correta!");
      } else {
        System.out.println("A resposta está incorreta!");
      }
      pontosAcumulados.calcularPontuacao(validacao);
      p++;
    }
    System.out.println("O quiz acabou!");
    System.out.println("Sua pontuação foi: " + pontosAcumulados.pontuacao);
  }
}

public abstract class Pergunta {
  protected String pergunta;
  protected String respostas;
  protected String respostaCerta;
  protected int indice;

  protected boolean validarResposta(String resposta) {
    if (resposta.trim().equalsIgnoreCase(this.respostaCerta.trim())) {
      return true;
    } else {
      return false;
    }
  }

  protected String getPergunta() {
    return this.pergunta;
  }

  protected String getRespostas() {
    return this.respostas;
  }

  protected String getRespostaCerta() {
    return this.respostaCerta;
  }

  protected void setPergunta(String pergunta) {
    this.pergunta = pergunta;
  }

  protected void setResposta(String respostas) {
    this.respostas = respostas;
  }

  protected void setRespostaCerta(String respostaCerta) {
    this.respostaCerta = respostaCerta;
  }
}

public class PerguntaMultiplaEscolha extends Pergunta {
  private static int indiceLivre = 0;
  private static String[] perguntas = {
      "Quais os tipos das formas que o pokémon Castform pode assumir?",
      "Qual o nome da dupla de pokémons baseados nos astros celestes?",
  };
  private static String[] respostas = {
      "a) Fogo, Terra e Pedra\nb) Fogo, Água e Voador\nc) Fogo, Água e Vento\nd) Fada, Sombrio e Veneno\n",
      "a) Martus e Gaius\nb) Strelus e Lunatone\nc) Solrock e Lunatone\nd) Solrock e Gaius\n",
  };
  private static String[] respostasCertas = {
      "b",
      "c",
  };

  public String getPergunta() {
    return PerguntaMultiplaEscolha.perguntas[PerguntaMultiplaEscolha.indiceLivre];
  }

  public String getRespostas() {
    return PerguntaMultiplaEscolha.respostas[indiceLivre];
  }

  public String getRespostaCerta() {
    return PerguntaMultiplaEscolha.respostasCertas[PerguntaMultiplaEscolha.indiceLivre];
  }

  public void setPergunta() {
    super.setPergunta(this.getPergunta());
  }

  public void setResposta() {
    super.setResposta(this.getRespostas());
  }

  public void setRespostaCerta() {
    super.setRespostaCerta(this.getRespostaCerta());
  }

  public boolean validarResposta(String resposta) {
    PerguntaMultiplaEscolha.indiceLivre += 1;
    return super.validarResposta(resposta);
  }
}

public class PerguntaVerdadeiroFalso extends Pergunta {
  private static int indiceLivre = 0;
  private static String[] perguntas = {
      "A terceira geração de Pokémon se passa em Kanto.",
      "O lendário secreto de Pokémon Emerald é o Deyoxis",
  };
  private static String[] respostasCertas = {
      "F",
      "V",
  };

  public String getPergunta() {
    return PerguntaVerdadeiroFalso.perguntas[PerguntaVerdadeiroFalso.indiceLivre];
  }

  public String getRespostaCerta() {
    return PerguntaVerdadeiroFalso.respostasCertas[PerguntaVerdadeiroFalso.indiceLivre];
  }

  public void setPergunta() {
    super.setPergunta(this.getPergunta());
  }

  public void setRespostaCerta() {
    super.setRespostaCerta(this.getRespostaCerta());
  }

  public boolean validarResposta(String resposta) {
    PerguntaVerdadeiroFalso.indiceLivre += 1;
    return super.validarResposta(resposta);
  }
}

class Jogador {
  public Scanner ler = new Scanner(System.in);
  private String nome;

  public void setNome() {
    this.nome = ler.nextLine();
  }

  public String getNome() {
    return this.nome;
  }

  public String responder() {
    String resposta = ler.next();
    return resposta;
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
  public void registrarEvento(int p) {
    System.out.println("Evento registrado");
  }

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
