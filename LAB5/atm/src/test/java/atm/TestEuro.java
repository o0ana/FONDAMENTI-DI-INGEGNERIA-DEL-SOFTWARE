package atm;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


class TestEuro {

    private Euro euro1;
    private Euro euro2;

    @BeforeEach
    public void setUp() {
        euro1 = new Euro(530.5);
        euro2 = new Euro(100);
    }

    @Test
    void testSum() {
        assertEquals(630.5, (euro1.sum(euro2)).getValue(), 0.001);
    }

    @Test
    void testSubtract() {
        assertEquals(430.5, euro1.subtract(euro2).getValue(), 0.001);
    }

    @Test
    void testEqualTo_shouldBeEqual() {
        assertTrue(euro1.equalTo(euro1));
        assertTrue(euro1.equalTo(new Euro(530.5)));
    }

    @Test
    void testEqualTo_shouldNotBeEqual() {
        assertFalse(euro1.equalTo(euro2));
    }

    @Test
    void testLessThan_shouldBeLessThan() {
        assertTrue(euro2.lessThan(euro1));
        assertTrue(euro1.lessThan(euro1)); // Same ==> less equal
    }

    @Test
    void testLessThan_shouldNotBeLessThan() {
        assertFalse(euro1.lessThan(euro2));
    }

    @Test
    void testPrint() {
        assertEquals("530.5 euro", euro1.print());
    }

}
