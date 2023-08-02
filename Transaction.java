import java.time.LocalDate;

public class Transaction {
    private LocalDate date;
    private Item item;
    private double userPayment;
    private double change;


    public Transaction(Item item, Money userPayment, Money change)    {
        date = LocalDate.now();
        this.item = item;
        this.userPayment = userPayment.computeTotal();
        this.change = change.computeTotal();
    }

    public Transaction(Money userPayment, Money change) {
        date = LocalDate.now();
        item = new None();
        this.userPayment = userPayment.computeTotal();
        this.change = change.computeTotal();
    }

    public LocalDate getDate()  {
        return this.date;
    }


    public Item getItem()   {
        return this.item;
    }

    public double getPayment()   {
        return this.userPayment;
    }

    public double getChange()    {
        return this.change;
    }
    
   



    
    
}
