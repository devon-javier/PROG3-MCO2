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

        Money temp_payment = new Money();

        //creating a vending machine
        this.fView.setCreateVMListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e)  {
                fView.displayCreateVM();
            }
        });
        this.fView.setRegularVMBtnListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e)  {
                
                fModel.setCurrentMachine(factory.createVendingMachine());   // Sets current machine to test

                fView.displayFactoryView();

            }
        });
        this.fView.setSpecialVMBtnListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e)  {

                fModel.setCurrentMachine(factory.createSpecialVendingMachine());

                fView.displayFactoryView();
                
                //SpecialVendingMachine svm = factory.createVendingMachine();
    
                // might need to pass rvm thru rvmview later
                //SpecialVendingMachine svm = factory.createSpecialVendingMachine();
                // not sure if need model ?
                //VMController cRVM = new VMController(rvm);
                //SpecialVendingMachineController cSVM = new VendingMachineController(vRVM, rvm);

               
            }

        });

        //testing a vending machine
        this.fView.setTestVMListener(new ActionListener()   {
            @Override
            public void actionPerformed(ActionEvent e)  {
                
                if(fModel.getCurrentMachine() instanceof SpecialVendingMachine) {
                    fView.displayTestVM();
                } else if (fModel.getCurrentMachine() instanceof VendingMachine) {
                    fView.displayTestVM();
                } else {
                    fView.dispErrorTestVM();
                }
            }
        });

        //for insert money interface in buy item
        this.fView.setBuyItemListener(new ActionListener()  {
            @Override
            public void actionPerformed(ActionEvent e)  {
                String dispAmount = "Current Amount Inserted: P" + Double.toString(temp_payment.computeTotal());
                fView.setCurrentAmount(dispAmount);
                fView.displayBuyItemInterface();
            }
        });
        this.fView.setConfirmMoney(new ActionListener()  {
            @Override
            public void actionPerformed(ActionEvent e)  {
                
                if(fModel.getCurrentMachine() instanceof SpecialVendingMachine) {
                    fView.displaySVMInterface();
                } else if (fModel.getCurrentMachine() instanceof VendingMachine) {
                    fView.displayRVMInterface();
                }
            }
        });
        this.fView.setPlus1Listener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e)  {
                
                int newval = Integer.parseInt(fView.getQuant1()) + 1;
                fView.setQuant1(String.valueOf(newval));

                temp_payment.addPeso1(1);
                String dispAmount = "Current Amount Inserted: P" + Double.toString(temp_payment.computeTotal());
                fView.setCurrentAmount(dispAmount);
            }
        });
        this.fView.setPlus5Listener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e)  {
                
                int newval = Integer.parseInt(fView.getQuant5()) + 1;
                fView.setQuant5(String.valueOf(newval));

                temp_payment.addPeso5(1);
                String dispAmount = "Current Amount Inserted: P" + Double.toString(temp_payment.computeTotal());
                fView.setCurrentAmount(dispAmount);
            }
        });
        this.fView.setPlus10Listener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e)  {
                
                int newval = Integer.parseInt(fView.getQuant10()) + 1;
                fView.setQuant10(String.valueOf(newval));

                temp_payment.addPeso10(1);
                String dispAmount = "Current Amount Inserted: P" + Double.toString(temp_payment.computeTotal());
                fView.setCurrentAmount(dispAmount);
            }
        });
        this.fView.setPlus20Listener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e)  {
                
                int newval = Integer.parseInt(fView.getQuant20()) + 1;
                fView.setQuant20(String.valueOf(newval));

                temp_payment.addPeso20(1);
                String dispAmount = "Current Amount Inserted: P" + Double.toString(temp_payment.computeTotal());
                fView.setCurrentAmount(dispAmount);
            }
        });
        this.fView.setPlus50Listener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e)  {
                
                int newval = Integer.parseInt(fView.getQuant50()) + 1;
                fView.setQuant50(String.valueOf(newval));

                temp_payment.addPeso50(1);
                String dispAmount = "Current Amount Inserted: P" + Double.toString(temp_payment.computeTotal());
                fView.setCurrentAmount(dispAmount);
            }
        });
        this.fView.setPlus100Listener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e)  {
                
                int newval = Integer.parseInt(fView.getQuant100()) + 1;
                fView.setQuant100(String.valueOf(newval));

                temp_payment.addPeso100(1);
                String dispAmount = "Current Amount Inserted: P" + Double.toString(temp_payment.computeTotal());
                fView.setCurrentAmount(dispAmount);
            }
        });
        this.fView.setPlus200Listener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e)  {
                
                int newval = Integer.parseInt(fView.getQuant200()) + 1;
                fView.setQuant200(String.valueOf(newval));

                temp_payment.addPeso200(1);
                String dispAmount = "Current Amount Inserted: P" + Double.toString(temp_payment.computeTotal());
                fView.setCurrentAmount(dispAmount);
            }
        });
        this.fView.setPlus500Listener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e)  {
                
                int newval = Integer.parseInt(fView.getQuant500()) + 1;
                fView.setQuant500(String.valueOf(newval));

                temp_payment.addPeso500(1);
                String dispAmount = "Current Amount Inserted: P" + Double.toString(temp_payment.computeTotal());
                fView.setCurrentAmount(dispAmount);
            }
        });
        this.fView.setPlus1000Listener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e)  {
                
                int newval = Integer.parseInt(fView.getQuant1000()) + 1;
                fView.setQuant1000(String.valueOf(newval));

                temp_payment.addPeso1000(1);
                String dispAmount = "Current Amount Inserted: P" + Double.toString(temp_payment.computeTotal());
                fView.setCurrentAmount(dispAmount);
            }
        });

        //to go back to factory view from test VM menu
        this.fView.setBackListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e)  {
                fView.displayFactoryView();
            }
        });

        //for slot items ------------------------------------------- RVM
        this.fView.setSlot1RListener(new ActionListener()  {
            @Override
            public void actionPerformed(ActionEvent e)  {
                fView.dispSelectItem();
            }
        });
        this.fView.setSlot2RListener(new ActionListener()  {
            @Override
            public void actionPerformed(ActionEvent e)  {
                fView.dispSelectItem();
            }
        });
        this.fView.setSlot3RListener(new ActionListener()  {
            @Override
            public void actionPerformed(ActionEvent e)  {
                fView.dispSelectItem();
            }
        });
        this.fView.setSlot4RListener(new ActionListener()  {
            @Override
            public void actionPerformed(ActionEvent e)  {
                fView.dispSelectItem();
            }
        });
        this.fView.setSlot5RListener(new ActionListener()  {
            @Override
            public void actionPerformed(ActionEvent e)  {
                fView.dispSelectItem();
            }
        });
        this.fView.setSlot6RListener(new ActionListener()  {
            @Override
            public void actionPerformed(ActionEvent e)  {
                fView.dispSelectItem();
            }
        });
        this.fView.setSlot7RListener(new ActionListener()  {
            @Override
            public void actionPerformed(ActionEvent e)  {
                fView.dispSelectItem();
            }
        });
        this.fView.setSlot8RListener(new ActionListener()  {
            @Override
            public void actionPerformed(ActionEvent e)  {
                fView.dispSelectItem();
            }
        });

        //for slot items ------------------------------------------- SVM
        this.fView.setSlot1SListener(new ActionListener()  {
            @Override
            public void actionPerformed(ActionEvent e)  {
                fView.dispCustomizeItem();
            }
        });
        this.fView.setSlot2SListener(new ActionListener()  {
            @Override
            public void actionPerformed(ActionEvent e)  {
                fView.dispCustomizeItem();
            }
        });
        this.fView.setSlot3SListener(new ActionListener()  {
            @Override
            public void actionPerformed(ActionEvent e)  {
                fView.dispCustomizeItem();
            }
        });
        this.fView.setSlot4SListener(new ActionListener()  {
            @Override
            public void actionPerformed(ActionEvent e)  {
                fView.dispCustomizeItem();
            }
        });
        this.fView.setSlot5SListener(new ActionListener()  {
            @Override
            public void actionPerformed(ActionEvent e)  {
                fView.dispCustomizeItem();
            }
        });
        this.fView.setSlot6SListener(new ActionListener()  {
            @Override
            public void actionPerformed(ActionEvent e)  {
                fView.dispCustomizeItem();
            }
        });
        this.fView.setSlot7SListener(new ActionListener()  {
            @Override
            public void actionPerformed(ActionEvent e)  {
                fView.dispCustomizeItem();
            }
        });
        this.fView.setSlot8SListener(new ActionListener()  {
            @Override
            public void actionPerformed(ActionEvent e)  {
                fView.dispCustomizeItem();
            }
        });

        // ------------------------------------------------------------- Maintenance mode
        this.fView.setMaintenanceListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e)  {
                fView.displayMaintenanceInterface();
            }
        });
        this.fView.setBackTestVMListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e)  {
                fView.displayTestVM();
            }
        });
        this.fView.setRestockListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e)  {
                // fView.displayRestockItemRVM();
                if(fModel.getCurrentMachine() instanceof SpecialVendingMachine) {
                    fView.displayRestockItemSVM();
                } else if (fModel.getCurrentMachine() instanceof VendingMachine) {
                    fView.displayRestockItemRVM();
                }
            }
        });

    }
    
}
