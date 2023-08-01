import java.util.ArrayList;

public class SpecialVendingMachine extends VendingMachine {

    private ArrayList<Lettuce> lettuceStock;
    protected ArrayList<Tomato> tomatoStock;
    protected ArrayList<Pickle> pickleStock;

    public SpecialVendingMachine()  {
        super();
    }

    @Override
    public void initIngredients()   {
        breadStock = new ArrayList<Bread>();
        cheeseStock = new ArrayList<Cheese>();
        hamStock = new ArrayList<Ham>();
        eggStock = new ArrayList<Egg>();
        chickenStock = new ArrayList<Chicken>();
        tunaStock = new ArrayList<Tuna>();
        nutellaStock = new ArrayList<Nutella>();
        peanutbutterStock = new ArrayList<PeanutButter>();
        strawberryjamStock = new ArrayList<StrawberryJam>();
        mayonnaiseStock = new ArrayList<Mayonnaise>();
        lettuceStock = new ArrayList<Lettuce>();
        tomatoStock = new ArrayList<Tomato>();
        pickleStock = new ArrayList<Pickle>();

        for(int i = 0; i < 30; i++) {
            breadStock.add(new Bread());
            breadStock.add(new Bread());
            breadStock.add(new Bread());
            cheeseStock.add(new Cheese());
            hamStock.add(new Ham());
            eggStock.add(new Egg());
            chickenStock.add(new Chicken());
            tunaStock.add(new Tuna());
            nutellaStock.add(new Nutella());
            peanutbutterStock.add(new PeanutButter());
            strawberryjamStock.add(new StrawberryJam());
            mayonnaiseStock.add(new Mayonnaise());
            lettuceStock.add(new Lettuce());
            tomatoStock.add(new Tomato());
            pickleStock.add(new Pickle());
        }

    }

    @Override
    public void resetHistoryRecord() {
        history.setInitialStockS(this);
        history.setFinalStockS(this);
    }

    @Override
    public void addStock(Item item) {
        if(item instanceof Bread) {
            breadStock.add((Bread)item);

        } else if (item instanceof Cheese)    {
            cheeseStock.add((Cheese)item);

        } else if (item instanceof Ham)   {
            hamStock.add((Ham)item);
            
        } else if (item instanceof Egg)   {
            eggStock.add((Egg)item);

        } else if (item instanceof Chicken)   {

            chickenStock.add((Chicken)item);

        } else if (item instanceof Tuna)  {
            tunaStock.add((Tuna)item);

        } else if (item instanceof Nutella)   {
            nutellaStock.add((Nutella)item);

        } else if (item instanceof PeanutButter)  {
            peanutbutterStock.add((PeanutButter)item);

        } else if (item instanceof StrawberryJam) {
            strawberryjamStock.add((StrawberryJam)item);
            
        } else if (item instanceof Mayonnaise)    {
            mayonnaiseStock.add((Mayonnaise)item);

        } else if (item instanceof Lettuce) {
            lettuceStock.add((Lettuce)item);

        } else if (item instanceof Tomato)  {
            tomatoStock.add((Tomato)item);

        } else if (item instanceof Pickle)  {
            pickleStock.add((Pickle)item);
        }
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

    public ArrayList<Lettuce> getLettuceStock() {
        return lettuceStock;
    }

    public ArrayList<Tomato> getTomatoStock() {
        return tomatoStock;
    }

    public ArrayList<Pickle> getPickleStock() {
        return pickleStock;
    }

    
}
