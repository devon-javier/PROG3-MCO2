import java.util.ArrayList;

public class Sandwich extends Item implements Sellable  {

    private double price;
    private ArrayList<Item> ingredientsList;

    public Sandwich(ArrayList<Item> ingredientsList, int calories)   {
        
        super("Sandwich", calories);

        this.ingredientsList = ingredientsList;
        
    }

    public double computePrice()    {
        return (double)this.getCalories() * 0.5;
    }


    
}
