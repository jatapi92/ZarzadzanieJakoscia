package pakiet1;



public class CurrencyExchange {

    private CurrencyRates rates;


    public double exchange(Currency source, Currency target, double amount) {
        double rate = rates.getRate(source, target);
        return amount * rate;
    }

}
