package pakiet1;


public class CurrencyExchange {

    public CurrencyExchange(CurrencyRates rates) {
        this.rates = rates;
    }

    private CurrencyRates rates;


    public double exchange(Currency source, Currency target, double amount) throws Exception {
        double rate = rates.getRate(source, target);
        if (rate <= 0) throw new Exception("Bad rate for this exchange");
        return amount * rate;
    }

}
