package videostore;

public class PrezzoNovita extends Prezzo {
    @Override
    public int getCodicePrezzo() {
        return 1;
    }

    @Override
    public double getAmmontare(int giorniNoleggio) {
        return (giorniNoleggio * 3);
    }

}
