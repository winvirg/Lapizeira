public class Grafite {

    private float calibre;
    private Dureza dureza;
    private int tamanho;

    public enum Dureza {
        G_HB,
        G_2B,
        G_4B,
        G_6B
    }

    public Grafite(float calibre, Dureza dureza, int tamanho) {
        this.calibre = calibre;
        this.dureza = dureza;
        setTamanho(tamanho);
    }

    public int desgastePorFolha() {
        int dureza;
        switch (getDureza()){
            case G_HB:
                dureza = 1;
                break;
            case G_2B:
                dureza = 2;
                break;
            case G_4B:
                dureza = 4;
                break;
            default:
                dureza = 6;
                break;
        }
        return dureza;
    }

    public int getTamanho() {
        return this.tamanho;
    }

    public void setTamanho(int tamanho) {
        this.tamanho = tamanho;
    }
    
    public Dureza getDureza() {
        return this.dureza;
    }

    public float getCalibre() {
        return this.calibre;
    }
}