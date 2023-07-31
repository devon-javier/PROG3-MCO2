import java.util.ArrayList;

public class Sandwich extends Item implements Sellable  {

    private double price;
    private ArrayList<Item> ingredientsList;

    public Sandwich(ArrayList<Item> ingredientsList, int calories)   {
        
        super("Sandwich", calories);

        this.ingredientsList = ingredientsList;
        
    }

    public void computePrice()    {
        this.price = (double)this.getCalories() * 0.5;
    }

    public double getPrice()    {
        return this.price;
    }

    public ArrayList<Item> getIngredients() {
        return this.ingredientsList;
    }

    public void setPrice(double price)  {
        this.price = price;
    }


    
}
