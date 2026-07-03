package videostore;

// 1.0
public class Film {
    
	public static final int BAMBINI = 2;
    public static final int REGOLARE = 0;
    public static final int NOVITA = 1;
    
    private String titolo;
    private Prezzo prezzo;

    public Film(String titolo, int codicePrezzo) {
        this.titolo = titolo;
        setCodicePrezzo(codicePrezzo);
    }

    public int getCodicePrezzo() {
        return prezzo.getCodicePrezzo();
    }

    public void setCodicePrezzo(int codicePrezzo) {
        switch (codicePrezzo) {
            case BAMBINI:
                this.prezzo = new PrezzoBambini();
                break;
            case NOVITA:
                this.prezzo = new PrezzoNovita();
                break;
            default://Regolare
                this.prezzo = new PrezzoRegolare();
                break;
        }
    }

    public String getTitolo() {
        return titolo;
    }
    
    public double getAmmontare(int giorniNoleggio) {
        return prezzo.getAmmontare(giorniNoleggio);
    }

}
