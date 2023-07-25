public class Main{
    public static void main(String args[])  {
        FactoryView vFactory = new FactoryView();
        Factory factory = new Factory();

        FactoryController cFactory = new FactoryController(vFactory, factory);
    }
}
