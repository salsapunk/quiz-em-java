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
