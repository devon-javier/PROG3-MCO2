public class Factory {

    public VendingMachine createVendingMachine()   {
        VendingMachine vm;
        return vm = new VendingMachine();
    }

     public SpecialVendingMachine createSpecialVendingMachine() {
        SpecialVendingMachine svm;
        return svm = new SpecialVendingMachine();
    }
    

    
}
