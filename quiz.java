public class Pergunta {
    public boolean validarResposta(String r){
        String respostaCerta
        if(r==resposta)
    }

    private getResposta() {
        //return respostaCorreta;
    }

    private setPergunta() {
        //return perguntaAtual;
    }


public class PerguntaMultiplaEscolha extends Pergunta {
    
}

public class PerguntaVerdadeiroFalse extends Pergunta {

}

class Jogador {
    private responder() {
        //pegar String do usuário;
    }
}

public class Quiz {
    static int numeroDeQuizes = 0;

    static int getTotalQuizzesJogos() {
        //printar numeroDeQuizes;
    }

    public static void main(String[] args) {
        this.numeroDeQuizes++;
        int p = 0;
        while (p < 10) {
            Pontuavel pontosAcumulados;
            pontosAcumulados = new Pontuavel();   
            //registrarEvento(Pontuavel pontosAcumulados);
            Jogador novoJogador;
            novoJogador = new Jogador();
            //registrarEvento(Jogador novoJogador);
            Pergunta novaPergunta;
            novaPergunta = new Pergunta();
            //registrarEvento(Pergunta novaPergunta);
            String perguntaAtual;
            perguntaAtual = novaPergunta.setPergunta();
            //registrarEvento(String pergunta);
            String respostaCerta;
            respostaCerta = novaPergunta.getResposta();
            //registrarEvento(String respostaCerta);
            //String resposta;
            //resposta = novoJogador.responder();
            //registrarEvento(String resposta, Jogador novoJogador);
            boolean validacao;
            validacao = novaPergunta.validarResposta(resposta);
            //registrarEvento(String resposta);
            if (!validacao) {
                System.out.println("A resposta está incorreta!");
            }
            else {
                System.out.println("A resposta está correta!");
            }
            pontosAcumulados.calcularPontuacao(validacao);
            p++;
        }
    }
}

class Pontuavel {
    int pontuacao = 0;
    
    public int calcularPontuacao(boolean ponto) {
        if (ponto == true) {
            pontuacao++;
        }
    }
}

class SistemaLogs {
    void registrarEvento() {
    
    };
}
