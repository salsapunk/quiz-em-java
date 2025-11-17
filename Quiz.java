public class Quiz {
  static int numeroDeQuizes = 0;

  static void getTotalQuizzesJogos() {
    System.out.println("Você jogou o quiz" + numeroDeQuizes + "vezes!");
  }

  public static void main(String[] args) {
    numeroDeQuizes++;
    int p = 0;

    SistemaLogs log;
    log = new SistemaLogs();

    log.registrarEvento("Sistema de logs criado");

    Jogador novoJogador;
    novoJogador = new Jogador();
    novoJogador.setPontuacao(0);

    log.registrarEvento("novoJogador criado");

    while (p < 4) {
      log.registrarEvento("Novo loop rodando");
      boolean validacao;

      if (p < 2) {
        System.out.println("-- Pergunta de múltipla escolha --");
        PerguntaMultiplaEscolha novaPergunta;
        novaPergunta = new PerguntaMultiplaEscolha();

        novaPergunta.setPergunta();
        novaPergunta.setResposta();
        novaPergunta.setRespostaCerta();

        System.out.println(novaPergunta.getPergunta());
        System.out.println(novaPergunta.getRespostas());

        log.registrarEvento("Pergunta feita", p + 1);

        System.out.println("Digite sua resposta:");
        String resposta;
        resposta = novoJogador.responder();
        log.registrarEvento("Pergunta respondida");

        validacao = novaPergunta.validarResposta(resposta);
        log.registrarEvento("Validação feita");
      } else {
        System.out.println("--Pergunta de (V)erdadeiro ou (F)also --");
        PerguntaVerdadeiroFalso novaPergunta;
        novaPergunta = new PerguntaVerdadeiroFalso();

        novaPergunta.setPergunta();
        novaPergunta.setRespostaCerta();

        String perguntaAtual;
        perguntaAtual = novaPergunta.pergunta;
        System.out.println(perguntaAtual);

        log.registrarEvento("Pergunta feita", p + 1);

        System.out.println("Digite sua resposta: ");
        String resposta;
        resposta = novoJogador.responder();
        log.registrarEvento("Resposta feita");

        validacao = novaPergunta.validarResposta(resposta);
        log.registrarEvento("Validação feita");
      }
      if (validacao) {
        System.out.println("A resposta está correta!");
        novoJogador.adicionarPonto();
      } else {
        System.out.println("A resposta está incorreta!");
      }
      p++;
    }
    System.out.println("O quiz acabou!");
    System.out.println("Sua pontuação foi: " + novoJogador.getPontuacao());
  }
}
