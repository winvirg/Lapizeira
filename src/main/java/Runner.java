public class Runner {

    public static void main(final String[] args) {

        //Inserindo grafites
        Lapiseira lapiseira = new Lapiseira(0.5f);
        System.out.println(lapiseira); // Lapiseira{calibre=0.5, grafite=null}

        //Calibre imcompativel
        if(lapiseira.inserir(new Grafite(0.7f, Grafite.Dureza.G_2B, 50)) == false) {
            System.out.println("fail: calibre incompatível"); //fail: calibre incompatível
        }
        lapiseira.inserir(new Grafite(0.5f, Grafite.Dureza.G_2B, 50));
        System.out.println(lapiseira); //Lapiseira{calibre=0.5, grafite=Grafite{calibre=0.5, dureza=Dureza{label='Grafite 2B'}, tamanho=50}}

        //Inserindo e Removendo
        lapiseira = new Lapiseira(0.3f);
        lapiseira.inserir(new Grafite(0.3f, Grafite.Dureza.G_2B, 50));
        System.out.println(lapiseira); //Lapiseira{calibre=0.3, grafite=Grafite{calibre=0.3, dureza=Dureza{label='Grafite 2B'}, tamanho=50}}

        if(lapiseira.inserir(new Grafite(0.3f, Grafite.Dureza.G_4B, 70)) == false) {
            System.out.println("fail: ja existe grafite"); //fail: ja existe grafite
        };
        System.out.println(lapiseira); //Lapiseira{calibre=0.3, grafite=Grafite{calibre=0.3, dureza=Dureza{label='Grafite 2B'}, tamanho=50}}
        lapiseira.remover();
        lapiseira.inserir(new Grafite(0.3f, Grafite.Dureza.G_4B, 70));
        System.out.println(lapiseira); //Lapiseira{calibre=0.3, grafite=Grafite{calibre=0.3, dureza=Dureza{label='Grafite 4B'}, tamanho=70}}

        //Escrevendo
        lapiseira = new Lapiseira(0.9f);
        lapiseira.inserir(new Grafite(0.9f, Grafite.Dureza.G_4B, 4));
        lapiseira.escrever(1);
        if(lapiseira.getGrafite() == null) {
            System.out.println("warning: grafite acabou"); //warning: grafite acabou
        }
        System.out.println(lapiseira); //Lapiseira{calibre=0.9, grafite=null}

        lapiseira.inserir(new Grafite(0.9f, Grafite.Dureza.G_4B, 30));
        lapiseira.escrever(6);
        System.out.println(lapiseira); //Lapiseira{calibre=0.9, grafite=Grafite{calibre=0.9, dureza=Dureza{label='Grafite 4B'}, tamanho=6}}

        if( lapiseira.escrever(3) == false) {
            System.out.println("warning: grafite acabou"); //warning: grafite acabou
            System.out.println(lapiseira.getFolhasEscritas() + " folhas escritas com esse grafite no total"); //8 folhas escritas com esse grafite no total
        }
        System.out.println(lapiseira); //Lapiseira{calibre=0.9, grafite=null}

        //case escrevendo 2
        lapiseira = new Lapiseira(0.9f);
        lapiseira.inserir(new Grafite(0.9f, Grafite.Dureza.G_2B, 15));
        System.out.println(lapiseira); //Lapiseira{calibre=0.9, grafite=Grafite{calibre=0.9, dureza=Dureza{label='Grafite 2B'}, tamanho=15}}

        lapiseira.escrever(4);
        System.out.println(lapiseira); //Lapiseira{calibre=0.9, grafite=Grafite{calibre=0.9, dureza=Dureza{label='Grafite 2B'}, tamanho=7}}

        if (lapiseira.escrever(4) == false){
            System.out.println("warning: grafite acabou"); //warning: grafite acabou
            System.out.println(lapiseira.getFolhasEscritas() + " folhas escritas com esse grafite no total"); //5 folhas escritas com esse grafite no total
        };

        System.out.println(lapiseira); //Lapiseira{calibre=0.9, grafite=null}

    }
}
