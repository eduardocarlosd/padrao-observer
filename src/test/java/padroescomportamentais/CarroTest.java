package padroescomportamentais;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.Assert.assertEquals;

class CarroTest {


    static Carro carroX;
    static Carro carroZ;
    static Gerente gerenteA;
    static Gerente gerenteB;

    @BeforeAll
    static void setUpBeforeClass() {
        carroX = new Carro("Corolla", "XEI","9GRID7EI8EIE8E","Branca", 2022,2023);
        carroZ = new Carro("Corolla Cross", "GR-SPORT","5GRID7EI8EIE8E","Cinza", 2023,2023);
        gerenteA = new Gerente("Fulano");
        gerenteB = new Gerente("Ciclano");
    }

    @AfterAll
    static void tearDownAfterClass() {
        carroX = null;
        carroZ = null;
        gerenteA = null;
        gerenteB = null;
    }

    @Test
    void notificaGerente(){
    gerenteA.notificarFabricacao(carroX);
    carroX.FinalizarCarro();
    assertEquals("Fulano - Carro finalizado: Veículo {Modelo = Corolla, Tipo = XEI, Chassi = 9GRID7EI8EIE8E, Cor = Branca, Ano Fabricação = 2022, Ano Modelo = 2023}",gerenteA.getUltimaNotificacao());
    }

    @Test
    void notificaGerentes(){
        gerenteA.notificarFabricacao(carroX);
        gerenteB.notificarFabricacao(carroX);
        carroX.FinalizarCarro();
        assertEquals("Fulano - Carro finalizado: Veículo {Modelo = Corolla, Tipo = XEI, Chassi = 9GRID7EI8EIE8E, Cor = Branca, Ano Fabricação = 2022, Ano Modelo = 2023}",gerenteA.getUltimaNotificacao());
        assertEquals("Ciclano - Carro finalizado: Veículo {Modelo = Corolla, Tipo = XEI, Chassi = 9GRID7EI8EIE8E, Cor = Branca, Ano Fabricação = 2022, Ano Modelo = 2023}",gerenteB.getUltimaNotificacao());
    }

    @Test
    void naoNotificarGerente(){
        carroX.FinalizarCarro();
        assertEquals(null,gerenteA.getUltimaNotificacao());
    }

    @Test
    void notificarGerenteConformeModelo(){

        gerenteA.notificarFabricacao(carroX);
        gerenteB.notificarFabricacao(carroZ);
        carroX.FinalizarCarro();
        carroZ.FinalizarCarro();
        assertEquals("Fulano - Carro finalizado: Veículo {Modelo = Corolla, Tipo = XEI, Chassi = 9GRID7EI8EIE8E, Cor = Branca, Ano Fabricação = 2022, Ano Modelo = 2023}",gerenteA.getUltimaNotificacao());
        assertEquals("Ciclano - Carro finalizado: Veículo {Modelo = Corolla Cross, Tipo = GR-SPORT, Chassi = 5GRID7EI8EIE8E, Cor = Cinza, Ano Fabricação = 2023, Ano Modelo = 2023}",gerenteB.getUltimaNotificacao());
    }

}