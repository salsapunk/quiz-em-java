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
    resposta.trim();
    PerguntaVerdadeiroFalso.indiceLivre += 1;
    return super.validarResposta(resposta);
  }
}
