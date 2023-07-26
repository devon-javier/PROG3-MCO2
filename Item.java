public class Item {
    private int calories; 
    private String name;

    public Item(String name, int calories)  {
        this.name = name;
        this.calories = calories;
    }

    public int getCalories()    {
        return this.calories;
    }
    
    public String getName() {
        return this.name;
    }

    public void setCalories(int calories) {
        this.calories = calories;
    }

    public void setName(String name) {
        this.name = name;
    }

}



