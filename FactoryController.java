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


        this.fView.setCreateVMListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e)  {
                fView.displayCreateVM();
            }
        });

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

        this.fView.setBuyItemListener(new ActionListener()  {
            @Override
            public void actionPerformed(ActionEvent e)  {
                fView.displayBuyItemInterface();
            }
        });

        this.fView.setBackListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e)  {
                fView.displayFactoryView();
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

        //for slot items - RVM
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

        //for slot items - SVM
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

        //Maintenance mode
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
