package videostore;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

// 1.0
public class Cliente {
    
	private String nome;
    private List<Noleggio> noleggi = new ArrayList<>();

    public Cliente (String nome) {
        this.nome = nome;
    }

    public void addNoleggio(Noleggio arg) {
        noleggi.add(arg);
    }
    
    public String getNome(){
        return nome;
    }

    public String rendiconto() {
        Iterator<Noleggio> noleggiIt = noleggi.iterator();
        StringBuilder r = new StringBuilder();
        r.append("Rendiconto noleggi per " + getNome() + ": ");
        
        while (noleggiIt.hasNext()) {
            Noleggio noleggio = noleggiIt.next();
            r.append(noleggio.getFilm().getTitolo())
            .append(" ")
            .append(noleggio.getAmmontare())
            .append(" ");   
        }

        r.append("L'ammontare dovuto e' ").append(getAmmontareTotale());
        return r.toString();
    }

    private double getAmmontareTotale() {
        double ammontareTotale = 0;
        Iterator<Noleggio> noleggiIt = noleggi.iterator();
        while (noleggiIt.hasNext()) {
            Noleggio noleggio = noleggiIt.next();
            ammontareTotale += noleggio.getAmmontare();
        }
        return ammontareTotale;
    }

}
