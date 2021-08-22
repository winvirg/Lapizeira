import org.junit.jupiter.api.Test;


import java.io.*;

import static org.junit.jupiter.api.Assertions.*;

public class TestLapiseira {

    @Test
    public void testInicializacao()
    {
        Lapiseira lapiseira = new Lapiseira(0.5f);
        assertEquals(0.5f, lapiseira.getCalibre(),
                "Ao criar uma lapiseira o seu calibre deve ser igual ao informado" );
        assertNull(lapiseira.getGrafite(), "Ao criar uma lapiseira ela deve vir sem grafite [null]");
    }

    @Test
    public void testInserirGrafiteCerto()
    {
        Lapiseira lapiseira = new Lapiseira(0.5f);
        Grafite grafite = new Grafite(0.5f, Grafite.Dureza.G_2B, 10);
        assertTrue(lapiseira.inserir(grafite),
                "Deve ser possivel inserir grafites que tenham o mesmo calibre da lapiseira");
    }

    @Test
    public void testInserirGrafiteCalibreMenor()
    {
        Lapiseira lapiseira = new Lapiseira(0.5f);
        Grafite grafite = new Grafite(0.3f, Grafite.Dureza.G_2B, 10);
        assertFalse(lapiseira.inserir(grafite),
                "Não Deve ser possivel inserir grafites que tenham um calibre menor do que o da lapiseira");
    }

    @Test
    public void testInserirGrafiteCalibreMaior()
    {
        Lapiseira lapiseira = new Lapiseira(0.5f);
        Grafite grafite = new Grafite(0.8f, Grafite.Dureza.G_2B, 10);
        assertFalse(lapiseira.inserir(grafite),
                "Não Deve ser possivel inserir grafites que tenham um calibre maior do que o da lapiseira");
    }

    @Test
    public void testInserirGrafiteEmUmLapiseiraCheia() {
        Lapiseira lapiseira = new Lapiseira(0.5f);
        Grafite grafite = new Grafite(0.5f, Grafite.Dureza.G_2B, 10);
        assertTrue(lapiseira.inserir(grafite),
                "Deve ser possivel inserir grafites que tenham o mesmo calibre da lapiseira");
        assertFalse(lapiseira.inserir(grafite),
                "Não deve ser possivel inserir um grafite se a lapiseira ja tiver um");
    }


    @Test
    public void testRemoverGrafite() {
        Lapiseira lapiseira = new Lapiseira(0.5f);
        Grafite grafite = new Grafite(0.5f, Grafite.Dureza.G_2B, 10);
        lapiseira.inserir(grafite);
        assertTrue(lapiseira.remover(), "Deve ser possivel remover o grafite que esta na lapiseira");
    }

    @Test
    public void testRemoverGrafiteNaoInserido() {
        Lapiseira lapiseira = new Lapiseira(0.5f);
        assertFalse(lapiseira.remover(), "Nao deve ser possivel remover um grafite nao inserido");
    }

    @Test
    public void testEscrevendoSemGrafite() {
        Lapiseira lapiseira = new Lapiseira(0.5f);
        assertFalse(lapiseira.escrever(100), "Nao deve ser possivel escrever sem um grafite");
    }

    @Test
    public void testEscrevendoComHB() {
        Lapiseira lapiseira = new Lapiseira(0.5f);
        Grafite grafite = new Grafite(0.5f, Grafite.Dureza.G_HB, 10);
        lapiseira.inserir(grafite);
        assertTrue(lapiseira.escrever(10),
                "Com esse grafite inserido, deve ser possivel escrever ate 10 paginas");
        assertEquals(10,lapiseira.getFolhasEscritas(),"Esta lapiseira deve ter escrito 10 paginas");
        assertNull(lapiseira.getGrafite(), "Ao consumir todo o grafite, a lapiseira deve ficar vazia");
    }

    @Test
    public void testEscrevendoCom2B() {
        Lapiseira lapiseira = new Lapiseira(0.5f);
        Grafite grafite = new Grafite(0.5f, Grafite.Dureza.G_2B, 10);
        lapiseira.inserir(grafite);
        assertTrue(lapiseira.escrever(5),
                "Com esse grafite inserido, deve ser possivel escrever ate 5 paginas");
        assertEquals(5,lapiseira.getFolhasEscritas(),"Esta lapiseira deve ter escrito 5 paginas");
        assertNull(lapiseira.getGrafite(), "Ao consumir todo o grafite, a lapiseira deve ficar vazia");
    }

    @Test
    public void testEscrevendoCom4B() {
        Lapiseira lapiseira = new Lapiseira(0.5f);
        Grafite grafite = new Grafite(0.5f, Grafite.Dureza.G_4B, 16);
        lapiseira.inserir(grafite);
        assertTrue(lapiseira.escrever(4),
                "Com esse grafite inserido, deve ser possivel escrever ate 4 paginas");
        assertEquals(4,lapiseira.getFolhasEscritas(),"Esta lapiseira deve ter escrito 4 paginas");
        assertNull(lapiseira.getGrafite(), "Ao consumir todo o grafite, a lapiseira deve ficar vazia");
    }

    @Test
    public void testEscrevendoCom6B() {
        Lapiseira lapiseira = new Lapiseira(0.5f);
        Grafite grafite = new Grafite(0.5f, Grafite.Dureza.G_6B, 12);
        lapiseira.inserir(grafite);
        assertTrue(lapiseira.escrever(2),
                "Com esse grafite inserido, deve ser possivel escrever ate 2 paginas");
        assertEquals(2,lapiseira.getFolhasEscritas(),"Esta lapiseira deve ter escrito 2 paginas");
        assertNull(lapiseira.getGrafite(), "Ao consumir todo o grafite, a lapiseira deve ficar vazia");
    }

    @Test
    public void testEscrevendoAteAcabar() {
        Lapiseira lapiseira = new Lapiseira(0.5f);
        Grafite grafite = new Grafite(0.5f, Grafite.Dureza.G_6B, 12);
        lapiseira.inserir(grafite);
        assertFalse(lapiseira.escrever(4),
                "Com esse grafite inserido, deve ser possivel escrever ate 2 paginas");
        assertEquals(2,lapiseira.getFolhasEscritas(),"Esta lapiseira deve ter escrito 2 paginas");
        assertNull(lapiseira.getGrafite(), "Ao consumir todo o grafite, a lapiseira deve ficar vazia");
    }

    @Test
    public void testEscrevendoVariasVezesAteAcabar() {
        Lapiseira lapiseira = new Lapiseira(0.5f);
        Grafite grafite = new Grafite(0.5f, Grafite.Dureza.G_2B, 12);
        lapiseira.inserir(grafite);
        lapiseira.escrever(4);
        lapiseira.escrever(5);
        assertEquals(6, lapiseira.getFolhasEscritas(), "O total de folhas escritas com esse grafite tem q ser 6");
    }

    @Test
    public void testEscrevendoVariasVezesSemAcabarGrafite() {
        Lapiseira lapiseira = new Lapiseira(0.5f);
        Grafite grafite = new Grafite(0.5f, Grafite.Dureza.G_HB, 12);
        lapiseira.inserir(grafite);
        lapiseira.escrever(4);
        lapiseira.escrever(5);
        assertEquals(9, lapiseira.getFolhasEscritas(), "O total de folhas escritas com esse grafite tem q ser 9");
    }

    @Test
    public void testTrocandoGrafiteAposEscrita() {
        Lapiseira lapiseira = new Lapiseira(0.5f);
        Grafite grafite = new Grafite(0.5f, Grafite.Dureza.G_HB, 12);
        lapiseira.inserir(grafite);
        lapiseira.escrever(4);
        lapiseira.remover();
        lapiseira.inserir(grafite);
        assertEquals(0, lapiseira.getFolhasEscritas(), "Ao trocar de grafite a contagem deve ser zerada");
    }



}
