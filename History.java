import java.time.LocalDate;
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

        this.setInitialStockR(vm);
        this.setFinalStockR(vm);
    }

    public History(SpecialVendingMachine svm)   {
        date = LocalDate.now();
        transactionList = new ArrayList<Transaction>();

        this.setInitialStockS(svm);
        this.setFinalStockS(svm);
    }

    public void setInitialStockR(VendingMachine vm)  {
        this.breadInitial = vm.getBreadStock().size();
        this.cheeseInitial = vm.getCheeseStock().size();
        this.hamInitial = vm.getHamStock().size();
        this.eggInitial = vm.getEggStock().size();
        this.chickenInitial = vm.getChickenStock().size();
        this.tunaInitial = vm.getTunaStock().size();
        this.nutellaInitial = vm.getNutellaStock().size();
        this.peanutbutterInitial = vm.getPeanutbutterStock().size();
        this.strawberryjamInitial = vm.getStrawberryjamStock().size();
        this.mayonnaiseInitial = vm.getMayonnaiseStock().size();
        this.lettuceInitial = -1;
        this.tomatoInitial = -1;
        this.pickleInitial = -1;

    }

    public void setFinalStockR(VendingMachine vm)    {
        this.breadFinal = vm.getBreadStock().size();
        this.cheeseFinal = vm.getCheeseStock().size();
        this.hamFinal = vm.getHamStock().size();
        this.eggFinal = vm.getEggStock().size();
        this.chickenFinal = vm.getChickenStock().size();
        this.tunaFinal = vm.getTunaStock().size();
        this.nutellaFinal = vm.getNutellaStock().size();
        this.peanutbutterFinal = vm.getPeanutbutterStock().size();
        this.strawberryjamFinal = vm.getStrawberryjamStock().size();
        this.mayonnaiseFinal = vm.getMayonnaiseStock().size();
        this.lettuceFinal = -1;
        this.tomatoFinal = -1;
        this.pickleFinal = -1;
    }

    public void setInitialStockS(SpecialVendingMachine vm)  {
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

    public void setFinalStockS(SpecialVendingMachine vm)    {
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

    public int getBreadInitial() {
        return breadInitial;
    }

    public int getCheeseInitial() {
        return cheeseInitial;
    }

    public int getHamInitial() {
        return hamInitial;
    }

    public int getEggInitial() {
        return eggInitial;
    }

    public int getChickenInitial() {
        return chickenInitial;
    }

    public int getLettuceInitial() {
        return lettuceInitial;
    }

    public int getTunaInitial() {
        return tunaInitial;
    }

    public int getTomatoInitial() {
        return tomatoInitial;
    }

    public int getPickleInitial() {
        return pickleInitial;
    }

    public int getNutellaInitial() {
        return nutellaInitial;
    }

    public int getPeanutbutterInitial() {
        return peanutbutterInitial;
    }

    public int getStrawberryjamInitial() {
        return strawberryjamInitial;
    }

    public int getMayonnaiseInitial() {
        return mayonnaiseInitial;
    }

    public int getBreadFinal() {
        return breadFinal;
    }

    public int getCheeseFinal() {
        return cheeseFinal;
    }

    public int getHamFinal() {
        return hamFinal;
    }

    public int getEggFinal() {
        return eggFinal;
    }

    public int getChickenFinal() {
        return chickenFinal;
    }

    public int getLettuceFinal() {
        return lettuceFinal;
    }

    public int getTunaFinal() {
        return tunaFinal;
    }

    public int getTomatoFinal() {
        return tomatoFinal;
    }

    public int getPickleFinal() {
        return pickleFinal;
    }

    public int getNutellaFinal() {
        return nutellaFinal;
    }

    public int getPeanutbutterFinal() {
        return peanutbutterFinal;
    }

    public int getStrawberryjamFinal() {
        return strawberryjamFinal;
    }

    public int getMayonnaiseFinal() {
        return mayonnaiseFinal;
    }

}
