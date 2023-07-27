import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class FactoryController {

    private FactoryView fView;
    private FactoryModel fModel;
    private VendingMachine rvm;
    //private SpecialVendingMachine svm;


    public FactoryController(FactoryView fView, FactoryModel fModel)    {
        this.fView = fView;
        this.fModel = fModel;

        Factory factory = new Factory();


        this.fView.setCreateVMListener();

        this.fView.setRegularVMBtnListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e)  {
                
                fModel.setCurrentMachine(factory.createVendingMachine());   // Sets current machine to test

            }

        });

        this.fView.setSpecialVMBtnListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e)  {

                fModel.setCurrentMachine(factory.createSpecialVendingMachine());
                
                //SpecialVendingMachine svm = factory.createVendingMachine();
    
                // might need to pass rvm thru rvmview later
                //SpecialVendingMachine svm = factory.createSpecialVendingMachine();
                // not sure if need model ?
                //VMController cRVM = new VMController(rvm);
                //SpecialVendingMachineController cSVM = new VendingMachineController(vRVM, rvm);

               
            }

        });

        // this.fView.setTestVMListener(new ActionListener()   {
        //     @Override
        //     public void actionPerformed(ActionEvent e)  {
        //         if(fModel.getCurrentMachine() instanceof SpecialVendingMachine) {
        //             // access the special vending machine panel + methods
        //         } else  {
        //             // access the regular vending machine panel + methods
        //         }
        //     }
        // });

    }
    
}
