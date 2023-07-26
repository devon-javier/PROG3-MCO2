import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class FactoryController {

    private FactoryView fView;
    private Factory factory;

    public FactoryController(FactoryView fView, Factory factory)    {
        this.fView = fView;
        this.factory = factory;

        this.fView.setRegularVMBtnListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e)  {
                
                //VendingMachine rvm = factory.createVendingMachine();
    
                // might need to pass rvm thru rvmview later
                VendingMachine rvm = factory.createVendingMachine();
                VMView vRVM = new VMView();
                VMModel mRVM = new VMModel();
                // not sure if need model ?

                VMController cRVM = new VMController(vRVM, mRVM, rvm);

                fView.dispose();

            }

        });

        this.fView.setSpecialVMBtnListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e)  {
                
                //SpecialVendingMachine svm = factory.createVendingMachine();
    
                // might need to pass rvm thru rvmview later
                SVMView vSVM = new SVMView();
                // not sure if need model ?
                
                //SpecialVendingMachineController cSVM = new VendingMachineController(vRVM, rvm);

                fView.dispose();

            }

        });
    }
    
}
