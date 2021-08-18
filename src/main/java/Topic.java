import java.util.ArrayList;

public class Topic {
	
	private int prioritarios;
	private int capacidade;
	ArrayList<String> assentosNormais = new ArrayList<String> ();
	ArrayList<String> assentosPrioritarios = new ArrayList<String> ();
	private int vagas;
	
    public Topic(int capacidade, int qtdPrioritatios) {
    	this.capacidade=capacidade;
    	this.prioritarios=qtdPrioritatios;
    	this.vagas=capacidade;
    }

     public int getNumeroAssentosPrioritarios() {
        return prioritarios;
    }
    public int getNumeroAssentosNormais() {
        return capacidade-prioritarios;
    }

    public Passageiro getPassageiroAssentoNormal(int lugar) {
        return null;
    }

    public Passageiro getPassageiroAssentoPrioritario(int lugar) {
        return null;
    }

    public int getVagas() {
        return vagas;
    }

    public boolean subir(Passageiro passageiro) {
	    if(vagas<1) {
	    	return false;
	    } else {
    		if (passageiro.ePrioritario()) {
	    		assentosPrioritarios.add(passageiro.getNome());
	    	}else {
	    		assentosNormais.add(passageiro.getNome());
	    	}
    		return true;
	    }
    }
    
    public boolean descer(String nome) {
	    if(vagas<1) {
	    	return false;
	    }else {
    		for(int i = 0; i < assentosPrioritarios.size();i++) {
		    	if(nome.equals(assentosPrioritarios)) {
		    		assentosPrioritarios.remove(i);
		    		i=assentosPrioritarios.size();
		    	}
	    	}
	    	for(int i = 0; i < assentosNormais.size();i++) {
		    	if(nome.equals(assentosNormais)) {
		    		assentosNormais.remove(i);
		    		i=assentosNormais.size();
		    	}
	    	}
	    	return true;
	    }
    }

	public ArrayList<String> getAssentosNormais() {
		return assentosNormais;
	}

	public ArrayList<String> getAssentosPrioritarios() {
		return assentosPrioritarios;
	}
    
}