package padroescomportamentais;

import java.util.Observable;
import java.util.Observer;

public class Gerente implements Observer {

    private String NomeGerente;
    private String ultimaNotificacao;

    public Gerente(String nomeGerente) {
        NomeGerente = nomeGerente;
    }

    public String getUltimaNotificacao() {
        return this.ultimaNotificacao;
    }

    public void notificarFabricacao(Carro carro) {
        carro.addObserver(this);
    }
    @Override
    public void update(Observable carro, Object arg) {
        this.ultimaNotificacao = this.NomeGerente + " - Carro finalizado: " + carro.toString();
        // System.out.println(this.ultimaNotificacao);
    }

}
