import java.util.ArrayList;

public class Slot {

    private ArrayList<Sandwich> sandwichList;
    private int initialQuantity;
    private int sold;
    private int currentQuantity;

    public Slot(Sandwich Sandwich)  {
        sandwichList = new ArrayList<Sandwich>();
        this.initialQuantity = 10;
        this.currentQuantity = this.initialQuantity;
        this.sold = 0;
    }

    public void fillSlots(Sandwich sandwich)  {
        resetSlots();
        for(int i = 0; i < initialQuantity; i++)   {
            sandwichList.add(sandwich);
        }
    }

    public void sellSandwich()    {
        sandwichList.remove(sandwichList.size() - 1);
        this.currentQuantity--;
        this.sold++;
    }

    public void addSandwich(int quantity)   {
        this.currentQuantity += quantity;
    }

    public ArrayList<Sandwich> getsandwichList()    {
        return this.sandwichList;
    }

    public int getinitialQuantity()    {
        return this.initialQuantity;
    }

    public int getcurrentQuantity() {
        return this.currentQuantity;
    }

    public int getSold()    {
        return this.sold;
    }

    public void setinitialQuantity(int initialQuantity)   {
        this.initialQuantity = initialQuantity;
    }

    public void resetSold() {
        this.sold = 0;
    }

    public void resetSlots()    {
        this.sandwichList.clear();
    }




    
}
