package videostore;

public class PrezzoRegolare extends Prezzo {
    @Override
    public int getCodicePrezzo() {
        return 0;    
    }

    @Override
    public double getAmmontare(int giorniNoleggio) {
        double risultato = 2;
        if (giorniNoleggio > 2)
            risultato += (giorniNoleggio - 2) * 1.5;
        return risultato;
    }

}
