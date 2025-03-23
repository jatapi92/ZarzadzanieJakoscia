package pakiet1;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.sql.SQLOutput;

import static org.junit.jupiter.api.Assertions.*;

class CurrencyExchangeTest {

    private CurrencyExchange testTarget;

    @BeforeEach
    void setUp() {

        testTarget = new CurrencyExchange();
    }

    @AfterEach
    void tearDown() {

        testTarget = null;
    }

    @Test
    void exchange() {
        //GIVEN PLN->EUR rate = .25
        //WHEN PLN->EUR, amount = 100
        double result = testTarget.exchange(Currency.PLN, Currency.EUR, 100);
        //THEN result = 25 euro
        assertEquals(25, result, .01, "Bad exchange result");
    }

    @Test
    void exchange2() {

    }
}