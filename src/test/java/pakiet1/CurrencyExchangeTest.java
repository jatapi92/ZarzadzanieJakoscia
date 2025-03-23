package pakiet1;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.sql.SQLOutput;

import static org.junit.jupiter.api.Assertions.*;

class CurrencyExchangeTest {

    private CurrencyExchange testTarget;
    private CurrencyRates rates;


    @BeforeEach
    void setUp() {
        rates = new CurrencyRates();
        testTarget = new CurrencyExchange(rates);
    }

    @AfterEach
    void tearDown() {

        testTarget = null;
    }

    @Test
    void exchange() throws Exception {
        //GIVEN PLN->EUR rate = .33
        rates.setRate(Currency.PLN, Currency.EUR, .33);
        //WHEN PLN->EUR, amount = 100
        double result = testTarget.exchange(Currency.PLN, Currency.EUR, 100);
        //THEN result = 33 euro
        assertEquals(.33 * 100, result, .01, "Bad exchange result");
    }

    @Test
    void exchange2() {
        //GIVEN rates for PLN->USD is not set
        //WHEN PLN->USD, amount = 100
        //THEN Exception is thrown
        assertThrows(Exception.class, ()->{
            double result = testTarget.exchange(Currency.PLN, Currency.USD, 100);
        });
    }

    @Test
    void exchange3() throws Exception {
        //GIVEN PLN->PLN
        //WHEN PLN->PLN, amount = 100
        double result = testTarget.exchange(Currency.PLN, Currency.PLN, 100);
        //THEN result = 100 PLN
        assertEquals(100, result, .01, "Bad exchange result");
    }
}