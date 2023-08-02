public class None extends Item {
    
    private Money change;

    public void receiveMoney(Money userPayment)    {
        this.change.addPeso1(userPayment.getPeso1());
        this.change.addPeso5(userPayment.getPeso5());
        this.change.addPeso10(userPayment.getPeso10());
        this.change.addPeso20(userPayment.getPeso20());
        this.change.addPeso50(userPayment.getPeso50());
        this.change.addPeso100(userPayment.getPeso100());
        this.change.addPeso200(userPayment.getPeso200());
        this.change.addPeso500(userPayment.getPeso500());
        this.change.addPeso1000(userPayment.getPeso1000());
    }

    public None()   {
        super("None", 0);
    }

    public Money getChange()    {
        return this.change;
    }

}
