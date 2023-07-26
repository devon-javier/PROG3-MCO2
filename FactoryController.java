import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Action;

public class FactoryController {

    private FactoryView fView;
    private Factory factory;
    private VendingMachine rvm;
    //private SpecialVendingMachine svm;


    public FactoryController(FactoryView fView, Factory factory)    {
        this.fView = fView;
        this.factory = factory;


        this.fView.setCreateVMListener();

        this.fView.setRegularVMBtnListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e)  {
                
                VendingMachine rvm = factory.createVendingMachine();

                
                // not sure if need model ?


            }

        });

        this.fView.setSpecialVMBtnListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e)  {
                
                //SpecialVendingMachine svm = factory.createVendingMachine();
    
                // might need to pass rvm thru rvmview later
                //SpecialVendingMachine svm = factory.createSpecialVendingMachine();
                // not sure if need model ?
                //VMController cRVM = new VMController(rvm);
                //SpecialVendingMachineController cSVM = new VendingMachineController(vRVM, rvm);

               
            }

        });

        this.fView.setTestVMListener();

    }
    
}
