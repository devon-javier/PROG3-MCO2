import java.time.*;
import java.util.ArrayList;

public class History {
    LocalDate date;
    int[] itemsSold = new int[8];
    int[] initialItems = new int[8];
    int[] currentItems = new int[8];
    ArrayList<Transaction> transactionList;

    public History(VendingMachine vm)    {
        date = LocalDate.now();
        transactionList = new ArrayList<Transaction>();

        for(int i = 0; i < 8; i++){
            this.itemsSold[i] = vm.getVendingMachineSlot(i).getSold();
            this.initialItems[i] = vm.getVendingMachineSlot(i).getinitialQuantity();
            this.currentItems[i] = vm.getVendingMachineSlot(i).getcurrentQuantity();
        }
    } 

    public LocalDate getDate()  {
        return this.date;
    }

    public int[] getItemsSold() {
        return this.itemsSold;
    }

    public int[] getInitialItems()  {
        return this.initialItems;
    }

    public int[] getCurrentItems()  {
        return this.currentItems;
    }

    public ArrayList<Transaction> getTransactions() {
        return this.transactionList;
    }


    /*
    public void setEndInv(ArrayList<transaction> transactionList)   {

    }
    */
}
