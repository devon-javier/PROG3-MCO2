public class Main{
    public static void main(String args[])  {
        FactoryView fView = new FactoryView();
        FactoryModel fModel = new FactoryModel();

        FactoryController cFactory = new FactoryController(fView, fModel);
    }
}
