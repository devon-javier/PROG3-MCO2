import java.util.ArrayList;

public class VendingMachine {

    private Slot[] slots;
    private Money vmMoney;
    private Money userPayments;

    private ArrayList<Bread> breadStock;
    private ArrayList<Cheese> cheeseStock;
    private ArrayList<Ham> hamStock;
    private ArrayList<Egg> eggStock;
    private ArrayList<Chicken> chickenStock;
    private ArrayList<Lettuce> lettuceStock;
    private ArrayList<Tuna> tunaStock;
    private ArrayList<Tomato> tomatoStock;
    private ArrayList<Pickle> pickleStock;
    private ArrayList<Nutella> nutellaStock;
    private ArrayList<PeanutButter> peanutbutterStock;
    private ArrayList<StrawberryJam> strawberryjamStock;
    private ArrayList<Mayonnaise> mayonnaiseStock;


    public VendingMachine() {
        slots = new Slot[8];
        vmMoney = new Money();
        userPayments = new Money();

        initIngredients();
        initSlots();

    }

    public void initIngredients()   {
        breadStock = new ArrayList<Bread>();
        cheeseStock = new ArrayList<Cheese>();
        hamStock = new ArrayList<Ham>();
        eggStock = new ArrayList<Egg>();
        chickenStock = new ArrayList<Chicken>();
        lettuceStock = new ArrayList<Lettuce>();
        tunaStock = new ArrayList<Tuna>();
        tomatoStock = new ArrayList<Tomato>();
        pickleStock = new ArrayList<Pickle>();
        nutellaStock = new ArrayList<Nutella>();
        peanutbutterStock = new ArrayList<PeanutButter>();
        strawberryjamStock = new ArrayList<StrawberryJam>();
        mayonnaiseStock = new ArrayList<Mayonnaise>();

        for(int i = 0; i < 30; i++) {
            breadStock.add(new Bread());
            breadStock.add(new Bread());
            breadStock.add(new Bread());
            cheeseStock.add(new Cheese());
            hamStock.add(new Ham());
            eggStock.add(new Egg());
            chickenStock.add(new Chicken());
            lettuceStock.add(new Lettuce());
            tunaStock.add(new Tuna());
            tomatoStock.add(new Tomato());
            pickleStock.add(new Pickle());
            nutellaStock.add(new Nutella());
            peanutbutterStock.add(new PeanutButter());
            strawberryjamStock.add(new StrawberryJam());
            mayonnaiseStock.add(new Mayonnaise());
        }

    }

    public void initSlots() {

        ArrayList<Item> ingredientsList = new ArrayList<Item>();
        int calories;
        Sandwich sandwich;

        for(int i = 0; i < 8; i++)  {
            calories = 0;
            ingredientsList.clear();

            switch(i)   {
                case 0:
                    ingredientsList.add(new Bread());
                    ingredientsList.add(new Ham());

                    for(int j = 0; j < ingredientsList.size(); j++) {
                        calories += ingredientsList.get(j).getCalories();
                    }
                    
                    sandwich = new Sandwich(ingredientsList, calories);
                    slots[i] = new Slot(sandwich);
                    slots[i].fillSlots(sandwich);

                    for(int k = 0; k < slots[i].getinitialQuantity(); k++)  {
                        breadStock.remove(breadStock.size() - 1);
                        hamStock.remove(hamStock.size() - 1);
                    }

                    break;
                case 1:
                    ingredientsList.add(new Bread());
                    ingredientsList.add(new Egg());
                    ingredientsList.add(new Mayonnaise());

                    for(int j = 0; j < ingredientsList.size(); j++) {
                        calories += ingredientsList.get(j).getCalories();
                    }
                    
                    sandwich = new Sandwich(ingredientsList, calories);
                    slots[i] = new Slot(sandwich);
                    slots[i].fillSlots(sandwich);

                    for(int k = 0; k < slots[i].getinitialQuantity(); k++)  {
                        breadStock.remove(breadStock.size() - 1);
                        eggStock.remove(eggStock.size() - 1);
                        mayonnaiseStock.remove(mayonnaiseStock.size() - 1);
                    }

                    break;
                case 2:
                    ingredientsList.add(new Bread());
                    ingredientsList.add(new Tuna());
                    
                    for(int j = 0; j < ingredientsList.size(); j++) {
                        calories += ingredientsList.get(j).getCalories();
                    }

                    sandwich = new Sandwich(ingredientsList, calories);
                    slots[i] = new Slot(sandwich);
                    slots[i].fillSlots(sandwich);

                    for(int k = 0; k < slots[i].getinitialQuantity(); k++)  {
                        breadStock.remove(breadStock.size() - 1);
                        tunaStock.remove(tunaStock.size() - 1);
                    }
                    
                    break;
                case 3:
                    ingredientsList.add(new Bread());
                    ingredientsList.add(new Cheese());

                    for(int j = 0; j < ingredientsList.size(); j++) {
                        calories += ingredientsList.get(j).getCalories();
                    }

                    sandwich = new Sandwich(ingredientsList, calories);
                    slots[i] = new Slot(sandwich);
                    slots[i].fillSlots(sandwich);

                    for(int k = 0; k < slots[i].getinitialQuantity(); k++)  {
                        breadStock.remove(breadStock.size() - 1);
                        cheeseStock.remove(cheeseStock.size() - 1);
                    }

                    break;
                case 4:
                    ingredientsList.add(new Bread());
                    ingredientsList.add(new Chicken());
                    ingredientsList.add(new Lettuce());
                    ingredientsList.add(new Mayonnaise());

                    for(int j = 0; j < ingredientsList.size(); j++) {
                        calories += ingredientsList.get(j).getCalories();
                    }

                    sandwich = new Sandwich(ingredientsList, calories);
                    slots[i] = new Slot(sandwich);
                    slots[i].fillSlots(sandwich);

                    for(int k = 0; k < slots[i].getinitialQuantity(); k++)  {
                        breadStock.remove(breadStock.size() - 1);
                        chickenStock.remove(chickenStock.size() - 1);
                        lettuceStock.remove(lettuceStock.size() - 1);
                        mayonnaiseStock.remove(mayonnaiseStock.size() - 1);
                    }

                    break;
                case 5:
                    ingredientsList.add(new Bread());
                    ingredientsList.add(new PeanutButter());

                    for(int j = 0; j < ingredientsList.size(); j++) {
                        calories += ingredientsList.get(j).getCalories();
                    }

                    sandwich = new Sandwich(ingredientsList, calories);
                    slots[i] = new Slot(sandwich);
                    slots[i].fillSlots(sandwich);

                    for(int k = 0; k < slots[i].getinitialQuantity(); k++)  {
                        breadStock.remove(breadStock.size() - 1);
                        peanutbutterStock.remove(peanutbutterStock.size() - 1);
                    }

                    break;
                case 6:
                    ingredientsList.add(new Bread());
                    ingredientsList.add(new StrawberryJam());

                    for(int j = 0; j < ingredientsList.size(); j++) {
                        calories += ingredientsList.get(j).getCalories();
                    }

                    sandwich = new Sandwich(ingredientsList, calories);
                    slots[i] = new Slot(sandwich);
                    slots[i].fillSlots(sandwich);

                    for(int k = 0; k < slots[i].getinitialQuantity(); k++)  {
                        breadStock.remove(breadStock.size() - 1);
                        strawberryjamStock.remove(strawberryjamStock.size() - 1);
                    }

                    break;
                case 7:
                    ingredientsList.add(new Bread());
                    ingredientsList.add(new Nutella());

                    for(int j = 0; j < ingredientsList.size(); j++) {
                        calories += ingredientsList.get(j).getCalories();
                    }

                    sandwich = new Sandwich(ingredientsList, calories);
                    slots[i] = new Slot(sandwich);
                    slots[i].fillSlots(sandwich);

                    for(int k = 0; k < slots[i].getinitialQuantity(); k++)  {
                        breadStock.remove(breadStock.size() - 1);
                        nutellaStock.remove(nutellaStock.size() - 1);
                    }

                    break;
            }

            
        }
    }

    public void receiveMoney(Money userPayment)    {
        this.userPayments.addPeso1(userPayment.getPeso1());
        this.userPayments.addPeso5(userPayment.getPeso5());
        this.userPayments.addPeso10(userPayment.getPeso10());
        this.userPayments.addPeso20(userPayment.getPeso20());
        this.userPayments.addPeso50(userPayment.getPeso50());
        this.userPayments.addPeso100(userPayment.getPeso100());
        this.userPayments.addPeso200(userPayment.getPeso200());
        this.userPayments.addPeso500(userPayment.getPeso500());
        this.userPayments.addPeso1000(userPayment.getPeso1000());
    }

    /*
    public void reduceVMMoney(Money change) {
        this.vmMoney.reducePeso1(change.getPeso1());
        this.vmMoney.reducePeso5(change.getPeso5());
        this.vmMoney.reducePeso10(change.getPeso10());
        this.vmMoney.reducePeso20(change.getPeso20());
        this.vmMoney.reducePeso50(change.getPeso50());
        this.vmMoney.reducePeso100(change.getPeso100());
        this.vmMoney.reducePeso200(change.getPeso200());
        this.vmMoney.reducePeso500(change.getPeso500());
        this.vmMoney.reducePeso1000(change.getPeso1000());
    }
    */

    public void dispenseItem(int index)  {
        slots[index].sellSandwich();
    }

    public Slot getVendingMachineSlot(int index) {
        return slots[index];
    }

    
    public Money produceChange(int index, Money userMoney) {

        int temp, curr; 
        Money change = new Money();

        temp = 
        (int)userMoney.computeTotal() - (int)slots[index].getsandwichList().get(slots[index].getsandwichList().size() - 1).computePrice();

        curr = temp / 1000;
        change.addPeso1000(curr);
        vmMoney.reducePeso1000(curr);
        temp %= 1000;

        curr = temp / 500;
        change.addPeso500(curr);
        vmMoney.reducePeso500(curr);
        temp %= 500;

        curr = temp / 200;
        change.addPeso200(curr);
        vmMoney.reducePeso200(curr);
        temp %= 200;

        curr = temp / 100;
        change.addPeso100(curr);
        vmMoney.reducePeso100(curr);
        temp %= 100;

        curr = temp / 50;
        change.addPeso50(curr);
        vmMoney.reducePeso50(curr);
        temp %= 50;

        curr = temp / 20; 
        change.addPeso20(curr);
        vmMoney.reducePeso20(curr);
        temp %= 20;

        curr = temp / 10;
        change.addPeso10(curr);
        vmMoney.reducePeso10(curr);
        temp %= 10;

        curr = temp / 5;
        change.addPeso5(curr);
        vmMoney.reducePeso5(curr);
        temp %= 5;

        curr = temp / 1;
        change.addPeso1(curr);
        vmMoney.reducePeso1(curr);

        return change;

    }
    
    
}
