import java.util.ArrayList;

public class SpecialVendingMachine extends VendingMachine {

    public SpecialVendingMachine()  {
        super();
    }

    public Sandwich createSandwich(ArrayList<Item> ingredientsList, int calories)  {

        for(int i = 0; i < ingredientsList.size(); i++) {
            if(ingredientsList.get(i) instanceof Bread) {
                breadStock.remove(breadStock.size() - 1);

            } else if (ingredientsList.get(i) instanceof Cheese)    {
                cheeseStock.remove(cheeseStock.size() - 1);

            } else if (ingredientsList.get(i) instanceof Ham)   {
                hamStock.remove(hamStock.size() - 1);
                
            } else if (ingredientsList.get(i) instanceof Egg)   {
                eggStock.remove(eggStock.size() - 1);

            } else if (ingredientsList.get(i) instanceof Chicken)   {
                chickenStock.remove(chickenStock.size() - 1);

            } else if (ingredientsList.get(i) instanceof Lettuce)   {
                lettuceStock.remove(lettuceStock.size() - 1);

            } else if (ingredientsList.get(i) instanceof Tuna)  {
                tunaStock.remove(tunaStock.size() - 1);

            } else if (ingredientsList.get(i) instanceof Tomato)    {
                tomatoStock.remove(tomatoStock.size() - 1);

            } else if (ingredientsList.get(i) instanceof Pickle)    {
                pickleStock.remove(pickleStock.size() - 1);

            } else if (ingredientsList.get(i) instanceof Nutella)   {
                nutellaStock.remove(nutellaStock.size() - 1);

            } else if (ingredientsList.get(i) instanceof PeanutButter)  {
                peanutbutterStock.remove(peanutbutterStock.size() - 1);

            } else if (ingredientsList.get(i) instanceof StrawberryJam) {
                strawberryjamStock.remove(strawberryjamStock.size() - 1);
                
            } else if (ingredientsList.get(i) instanceof Mayonnaise)    {
                mayonnaiseStock.remove(mayonnaiseStock.size() - 1);

            }
        }

        return new Sandwich(ingredientsList, calories);

    }
    
}
