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
