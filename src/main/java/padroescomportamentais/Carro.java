package padroescomportamentais;

import java.util.Observable;

public class Carro extends Observable {

    private String modelo;
    private String tipo;
    private String chassi;
    private String cor;
    private Integer anoFabricacao;
    private Integer anoModelo;

    public Carro(String modelo, String tipo, String chassi, String cor, Integer anoFabricacao, Integer anoModelo) {
        this.modelo = modelo;
        this.tipo = tipo;
        this.chassi = chassi;
        this.cor = cor;
        this.anoFabricacao = anoFabricacao;
        this.anoModelo = anoModelo;
    }

    public void FinalizarCarro() {
        setChanged();
        notifyObservers();
    }

    @Override
    public String toString() {
        return "Veículo {" +
                "Modelo = " + modelo +
                ", Tipo = " + tipo +
                ", Chassi = " + chassi +
                ", Cor = " + cor +
                ", Ano Fabricação = " + anoFabricacao  +
                ", Ano Modelo = " + anoModelo  +
                '}';
    }
}
