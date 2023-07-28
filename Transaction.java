import java.time.*;

public class Transaction {
    private LocalDate date;
    private Item item;
    private Money userPayment;
    private Money change;

    public Transaction(Item item, Money userPayment, Money change)    {
        date = LocalDate.now();
        this.item = item;
        this.userPayment = userPayment;
        this.change = change;
    }

    public LocalDate getDate()  {
        return this.date;
    }

    // Count ingredients lost in the print method ( ? )

    public Item getItem()   {
        return this.item;
    }

    public Money getPayment()   {
        return this.userPayment;
    }

    public Money getChange()    {
        return this.change;
    }
    
   



    
    
}
