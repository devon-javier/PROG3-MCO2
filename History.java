import java.time.*;
import java.util.ArrayList;

public class History {
    private LocalDate date;
    private ArrayList<Transaction> transactionList;

    private int breadInitial;
    private int cheeseInitial;
    private int hamInitial;
    private int eggInitial;
    private int chickenInitial;
    private int lettuceInitial;
    private int tunaInitial;
    private int tomatoInitial;
    private int pickleInitial;
    private int nutellaInitial;
    private int peanutbutterInitial;
    private int strawberryjamInitial;
    private int mayonnaiseInitial;

    private int breadFinal;
    private int cheeseFinal;
    private int hamFinal;
    private int eggFinal;
    private int chickenFinal;
    private int lettuceFinal;
    private int tunaFinal;
    private int tomatoFinal;
    private int pickleFinal;
    private int nutellaFinal;
    private int peanutbutterFinal;
    private int strawberryjamFinal;
    private int mayonnaiseFinal;


    public History(VendingMachine vm)    {
        date = LocalDate.now();
        transactionList = new ArrayList<Transaction>();

        this.setInitialStock(vm);
        this.setFinalStock(vm);
    }

    public void setInitialStock(VendingMachine vm)  {
        this.breadInitial = vm.getBreadStock().size();
        this.cheeseInitial = vm.getCheeseStock().size();
        this.hamInitial = vm.getHamStock().size();
        this.eggInitial = vm.getEggStock().size();
        this.chickenInitial = vm.getChickenStock().size();
        this.lettuceInitial = vm.getLettuceStock().size();
        this.tunaInitial = vm.getTunaStock().size();
        this.tomatoInitial = vm.getTomatoStock().size();
        this.pickleInitial = vm.getPickleStock().size();
        this.nutellaInitial = vm.getNutellaStock().size();
        this.peanutbutterInitial = vm.getPeanutbutterStock().size();
        this.strawberryjamInitial = vm.getStrawberryjamStock().size();
        this.mayonnaiseInitial = vm.getMayonnaiseStock().size();
    }

    public void setFinalStock(VendingMachine vm)    {
        this.breadFinal = vm.getBreadStock().size();
        this.cheeseFinal = vm.getCheeseStock().size();
        this.hamFinal = vm.getHamStock().size();
        this.eggFinal = vm.getEggStock().size();
        this.chickenFinal = vm.getChickenStock().size();
        this.lettuceFinal = vm.getLettuceStock().size();
        this.tunaFinal = vm.getTunaStock().size();
        this.tomatoFinal = vm.getTomatoStock().size();
        this.pickleFinal = vm.getPickleStock().size();
        this.nutellaFinal = vm.getNutellaStock().size();
        this.peanutbutterFinal = vm.getPeanutbutterStock().size();
        this.strawberryjamFinal = vm.getStrawberryjamStock().size();
        this.mayonnaiseFinal = vm.getMayonnaiseStock().size();
    }

    public void addTransaction(Transaction transaction)    {
        this.transactionList.add(transaction);
    }

    public LocalDate getDate()  {
        return this.date;
    }

    public ArrayList<Transaction> getTransactions() {
        return this.transactionList;
    }

}
