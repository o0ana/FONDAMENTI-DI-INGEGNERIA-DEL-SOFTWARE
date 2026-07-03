package atm;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class TestBankDatabase {

    private BankDatabase db;
    private final int existingAccountNumber = 12345;
    private final int notExistingAccountNumber = 00000;
    private final int realPin = 54321;
    private final int fakePin = 00000;

    @BeforeEach
    void setUp(){
        db = new BankDatabase();
    }

    @Test
    void testAuthenticateUser_existingAccount() {
        assertTrue(db.authenticateUser(existingAccountNumber, realPin));
    }

    @Test
    void testAuthenticateUser_notExistingAccount() {
        assertFalse(db.authenticateUser(notExistingAccountNumber, fakePin));
    }

    @Test
    void testAuthenticateUser_fakePin() {
        assertFalse(db.authenticateUser(existingAccountNumber, fakePin));
    }

    
    @Test
    void testGetAvailableBalance_existingAccount() {
        Euro availablebalance = db.getAvailableBalance(existingAccountNumber);
        assertTrue(new Euro(1000.0).equalTo(availablebalance));
    }
    
    @Test
    void testGetAvailableBalance_notExistingAccount() {
        assertThrows(NullPointerException.class, () -> {
            db.getAvailableBalance(notExistingAccountNumber);
        });
    }

    @Test
    void testGetTotalBalance_existingAccount() {
        Euro totalBalance = db.getTotalBalance(existingAccountNumber);
        assertTrue(new Euro(1200.0).equalTo(totalBalance));
    }

    @Test
    void testGetTotalBalance_notExistingAccount() {
        assertThrows(NullPointerException.class, () -> {
            db.getTotalBalance(notExistingAccountNumber);
        });
    }
    

    @ParameterizedTest
    @CsvSource("0, 1200")
    @CsvSource("100, 1300")
    @CsvSource("555.55, 1755.55")
    void testCredit_existingAccount(double amount, double expected) {
        db.credit(existingAccountNumber, new Euro(amount));
        assertTrue(new Euro(expected).equalTo(db.getTotalBalance(existingAccountNumber)));
    }

    @Test
    void testCredit_notExistingAccount() {
        assertThrows(NullPointerException.class, () -> {
            db.credit(notExistingAccountNumber, new Euro(100));
        });
    }
    
    @ParameterizedTest
    @CsvSource("0, 1200")
    @CsvSource("100, 1100")
    @CsvSource("555.55, 644.45")
    void testDebit_onRealAccount(double amount, double expected) {
        db.debit(existingAccountNumber, new Euro(amount));
        assertTrue(new Euro(expected).equalTo(db.getTotalBalance(existingAccountNumber)));
    }

    @Test
    void testDebit_notExistingAccount() {
        assertThrows(NullPointerException.class, () -> {
            db.debit(notExistingAccountNumber, new Euro(100));
        });
    }

}
