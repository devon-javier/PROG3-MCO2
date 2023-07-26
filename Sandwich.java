import java.util.ArrayList;

public class Sandwich extends Item implements Sellable  {

    private double price;
    private ArrayList<Item> ingredientsList;

    public Sandwich(ArrayList<Item> ingredientsList, int calories)   {
        
        super("Sandwich", calories);

        this.ingredientsList = ingredientsList;

        /*
        FOR CONTROLLER

        int temp_cal = 0;

        for(int i = 0; i < ingredientsList.size(); i++) {
            temp_cal += ingredientsList.get(i).getCalories();
        }
        */
        
    }

    public double computePrice()    {
        return (double)this.getCalories() * 0.5;
    }


    
}
