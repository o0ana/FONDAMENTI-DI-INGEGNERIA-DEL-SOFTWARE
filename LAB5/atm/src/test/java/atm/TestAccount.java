package atm;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class TestAccount {
    private Account account;
    private final int realPin = 54321;
    private final int fakePin = 00000;

    @BeforeEach
    void setUp() {
        account = new Account(12345, 54321, new Euro(1000.0), new Euro(1200.0));
    }

    @Test
    void testValidatePin_realPin() {
        assertTrue(account.validatePIN(realPin));
    }
    
    @Test
    void testValidatePin_fakePin() {
        assertFalse(account.validatePIN(fakePin));
    }

    @ParameterizedTest
    @CsvSource("0, 1200")
    @CsvSource("100, 1300")
    @CsvSource("555.55, 1755.55")
    void testCredit(double amount, double expected) {
        account.credit(new Euro(amount));
        assertTrue(new Euro(expected).equalTo(account.getTotalBalance()));
    }

    @ParameterizedTest
    @CsvSource("0, 1200")
    @CsvSource("100, 1100")
    @CsvSource("555.55, 644.45")
    void testDebit(double amount, double expected) {
        account.debit(new Euro(amount));
        assertTrue(new Euro(expected).equalTo(account.getTotalBalance()));
    }

}
