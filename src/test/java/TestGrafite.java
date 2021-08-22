import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestGrafite {

    @Test
    public void testGrafiteHB()
    {
        Grafite hb = new Grafite(0.7f, Grafite.Dureza.G_HB, 10);
        assertEquals(1, hb.desgastePorFolha(), "O desgaste do Grafite HB deve ser 1");
    }

    @Test
    public void testGrafite2B()
    {
        Grafite g2b = new Grafite(0.5f, Grafite.Dureza.G_2B, 80);
        assertEquals(2, g2b.desgastePorFolha(), "O desgaste do Grafite 2B deve ser 2");
    }

    @Test
    public void testGrafite4B()
    {
        Grafite g4b = new Grafite(0.1f, Grafite.Dureza.G_4B, 80);
        assertEquals(4, g4b.desgastePorFolha(), "O desgaste do Grafite 4B deve ser 4");
    }

    @Test
    public void testGrafite6B()
    {
        Grafite g6b = new Grafite(0.3f, Grafite.Dureza.G_6B, 80);
        assertEquals(6, g6b.desgastePorFolha(), "O desgaste do Grafite 6B deve ser 6");
    }
}