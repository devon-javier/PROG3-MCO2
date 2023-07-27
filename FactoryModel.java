
public class FactoryModel {
    private VendingMachine currentMachine;

    public FactoryModel()   {
        currentMachine = null;
    }

    public void setCurrentMachine(VendingMachine vm)  {
        this.currentMachine = vm;
    }

    public VendingMachine getCurrentMachine() {
        return this.currentMachine;
    }


}


