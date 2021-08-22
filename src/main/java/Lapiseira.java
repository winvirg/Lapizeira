public class Lapiseira {

    private float calibre;
    private int folhasEscritas;
    private int permitida;
    private Grafite grafite;

    public Lapiseira(float calibre) {
        this.calibre = calibre;
        this.grafite = null;
    }

    public boolean inserir(Grafite grafite) {
        if(this.calibre != grafite.getCalibre())
            return false;
        if(getGrafite() != null)
            return false;
        this.folhasEscritas = 0;
        this.grafite = grafite;
        return true;
    }

    public boolean remover() {
        if(this.grafite == (null))
            return false;
        this.grafite = null;
        return true;
    }

    public boolean escrever(int folhas) {
        if(this.grafite == (null))
            return false;
        permitida = grafite.getTamanho() / grafite.desgastePorFolha();
        permitida -= getFolhasEscritas();
        if((permitida - folhas) <= 0) {
            this.folhasEscritas += permitida;
            this.grafite = null;
        }
        else
            this.folhasEscritas += folhas;
        return (permitida - folhas) >= 0;
    }

    public Grafite getGrafite() {
        return this.grafite;
    }

    public float getCalibre() {
        return this.calibre;
    }

    public int getFolhasEscritas() {
        return this.folhasEscritas;
    }
}