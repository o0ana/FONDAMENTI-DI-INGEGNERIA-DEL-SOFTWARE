package videostore;

public class PrezzoBambini extends Prezzo {

    @Override
    public int getCodicePrezzo() {
        return 2;    
    }

    @Override
    public double getAmmontare(int giorniNoleggio) {
        double risultato = 1.5;
        if (giorniNoleggio > 3)
            risultato += (giorniNoleggio - 3) * 1.5;
        return risultato;
    }
    
}
