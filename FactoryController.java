import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class FactoryController {

    private FactoryView fView;
    private FactoryModel fModel;
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
        this.fView.setBackMaintenanceModeListenerR(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e)  {
                fView.displayMaintenanceInterface();
            }
        });
        this.fView.setBackMaintenanceModeListenerS(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e)  {
                fView.displayMaintenanceInterface();
            }
        });
        this.fView.setBackMaintenanceModeListenerFromSandwich(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e)  {
                fView.displayMaintenanceInterface();
            }
        });

        this.fView.setBackMaintenanceModeListenerFromSetPrice(new ActionListener() {        //START~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
            @Override
            public void actionPerformed(ActionEvent e)  {
                fView.displayMaintenanceInterface();
            }
        });                                                                                

        // ADDED
        this.fView.setRestockItemsListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e)  {
                // fView.displayRestockItemRVM();

                if(fModel.getCurrentMachine() instanceof SpecialVendingMachine) {
                    fView.setBreadQuantS(String.valueOf(fModel.getCurrentMachine().getBreadStock().size()));
                    fView.setHamQuantS(String.valueOf(fModel.getCurrentMachine().getHamStock().size()));
                    fView.setCheeseQuantS(String.valueOf(fModel.getCurrentMachine().getCheeseStock().size()));
                    fView.setChickenQuantS(String.valueOf(fModel.getCurrentMachine().getChickenStock().size()));
                    fView.setTunaQuantS(String.valueOf(fModel.getCurrentMachine().getTunaStock().size()));
                    fView.setEggQuantS(String.valueOf(fModel.getCurrentMachine().getEggStock().size()));
                    fView.setMayoQuantS(String.valueOf(fModel.getCurrentMachine().getMayonnaiseStock().size()));
                    fView.setPeanutBQuantS(String.valueOf(fModel.getCurrentMachine().getPeanutbutterStock().size()));
                    fView.setStrawberryJQuantS(String.valueOf(fModel.getCurrentMachine().getStrawberryjamStock().size()));
                    fView.setNutellaQuantS(String.valueOf(fModel.getCurrentMachine().getNutellaStock().size()));
                    SpecialVendingMachine temp = (SpecialVendingMachine)fModel.getCurrentMachine();
                    fView.setLettuceQuantS(String.valueOf(temp.getLettuceStock().size()));
                    fView.setTomatoQuantS(String.valueOf(temp.getTomatoStock().size()));
                    fView.setPickleQuantS(String.valueOf(temp.getPickleStock().size()));                    
                    
                    fView.displayRestockItemSVM();
                
                } else if (fModel.getCurrentMachine() instanceof VendingMachine) {
                    fView.setBreadQuantR(String.valueOf(fModel.getCurrentMachine().getBreadStock().size()));
                    fView.setHamQuantR(String.valueOf(fModel.getCurrentMachine().getHamStock().size()));
                    fView.setCheeseQuantR(String.valueOf(fModel.getCurrentMachine().getCheeseStock().size()));
                    fView.setChickenQuantR(String.valueOf(fModel.getCurrentMachine().getChickenStock().size()));
                    fView.setTunaQuantR(String.valueOf(fModel.getCurrentMachine().getTunaStock().size()));
                    fView.setEggQuantR(String.valueOf(fModel.getCurrentMachine().getEggStock().size()));
                    fView.setMayoQuantR(String.valueOf(fModel.getCurrentMachine().getMayonnaiseStock().size()));
                    fView.setPeanutBQuantR(String.valueOf(fModel.getCurrentMachine().getPeanutbutterStock().size()));
                    fView.setStrawberryJQuantR(String.valueOf(fModel.getCurrentMachine().getStrawberryjamStock().size()));
                    fView.setNutellaQuantR(String.valueOf(fModel.getCurrentMachine().getNutellaStock().size())); 
                    fView.displayRestockItemRVM();
                }
            }
        });

        this.fView.setPlusBreadListenerR(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e)  {
                int newval = Integer.parseInt(fView.getBreadQuantR()) + 1;
                fView.setBreadQuantR(String.valueOf(newval));
            }
        });

        this.fView.setPlusHamListenerR(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e)  {
                int newval = Integer.parseInt(fView.getHamQuantR()) + 1;
                fView.setHamQuantR(String.valueOf(newval));
            }
        });

        this.fView.setPlusCheeseListenerR(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e)  {
                int newval = Integer.parseInt(fView.getCheeseQuantR()) + 1;
                fView.setCheeseQuantR(String.valueOf(newval));
            }
        });

        this.fView.setPlusChickenListenerR(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e)  {
                int newval = Integer.parseInt(fView.getChickenQuantR()) + 1;
                fView.setChickenQuantR(String.valueOf(newval));
            }
        });

        this.fView.setPlusTunaListenerR(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e)  {
                int newval = Integer.parseInt(fView.getChickenQuantR()) + 1;
                fView.setChickenQuantR(String.valueOf(newval));
            }
        });

        this.fView.setPlusEggListenerR(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e)  {
                int newval = Integer.parseInt(fView.getEggQuantR()) + 1;
                fView.setEggQuantR(String.valueOf(newval));
            }
        });

        this.fView.setPlusMayoListenerR(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e)  {
                int newval = Integer.parseInt(fView.getMayoQuantR()) + 1;
                fView.setMayoQuantR(String.valueOf(newval));
            }
        });

        this.fView.setPlusPeanutBListenerR(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e)  {
                int newval = Integer.parseInt(fView.getPeanutBQuantR()) + 1;
                fView.setPeanutBQuantR(String.valueOf(newval));
            }
        });

        this.fView.setPlusStrawberryJListenerR(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e)  {
                int newval = Integer.parseInt(fView.getStrawberryJQuantR()) + 1;
                fView.setStrawberryJQuantR(String.valueOf(newval));
            }
        });

        this.fView.setPlusNutellaListenerR(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e)  {
                int newval = Integer.parseInt(fView.getNutellaQuantR()) + 1;
                fView.setNutellaQuantR(String.valueOf(newval));
            }
        });

        // Special item Restock
        this.fView.setPlusBreadListenerS(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e)  {
                int newval = Integer.parseInt(fView.getBreadQuantS()) + 1;
                fView.setBreadQuantS(String.valueOf(newval));
            }
        });

        this.fView.setPlusHamListenerS(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e)  {
                int newval = Integer.parseInt(fView.getHamQuantS()) + 1;
                fView.setHamQuantS(String.valueOf(newval));
            }
        });

        this.fView.setPlusCheeseListenerS(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e)  {
                int newval = Integer.parseInt(fView.getCheeseQuantS()) + 1;
                fView.setCheeseQuantS(String.valueOf(newval));
            }
        });

        this.fView.setPlusChickenListenerS(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e)  {
                int newval = Integer.parseInt(fView.getChickenQuantS()) + 1;
                fView.setChickenQuantS(String.valueOf(newval));
            }
        });

        this.fView.setPlusTunaListenerS(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e)  {
                int newval = Integer.parseInt(fView.getChickenQuantS()) + 1;
                fView.setChickenQuantS(String.valueOf(newval));
            }
        });

        this.fView.setPlusEggListenerS(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e)  {
                int newval = Integer.parseInt(fView.getEggQuantS()) + 1;
                fView.setEggQuantS(String.valueOf(newval));
            }
        });

        this.fView.setPlusMayoListenerS(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e)  {
                int newval = Integer.parseInt(fView.getMayoQuantS()) + 1;
                fView.setMayoQuantS(String.valueOf(newval));
            }
        });

        this.fView.setPlusPeanutBListenerS(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e)  {
                int newval = Integer.parseInt(fView.getPeanutBQuantS()) + 1;
                fView.setPeanutBQuantS(String.valueOf(newval));
            }
        });

        this.fView.setPlusStrawberryJListenerS(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e)  {
                int newval = Integer.parseInt(fView.getStrawberryJQuantS()) + 1;
                fView.setStrawberryJQuantS(String.valueOf(newval));
            }
        });

        this.fView.setPlusNutellaListenerS(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e)  {
                int newval = Integer.parseInt(fView.getNutellaQuantS()) + 1;
                fView.setNutellaQuantS(String.valueOf(newval));
            }
        });

        this.fView.setPlusLettuceListenerS(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e)  {
                int newval = Integer.parseInt(fView.getLettuceQuantS()) + 1;
                fView.setLettuceQuantS(String.valueOf(newval));
            }
        });

        this.fView.setPlusTomatoListenerS(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e)  {
                int newval = Integer.parseInt(fView.getTomatoQuantS()) + 1;
                fView.setTomatoQuantS(String.valueOf(newval));
            }
        });

        this.fView.setPlusPickleListenerS(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e)  {
                int newval = Integer.parseInt(fView.getPickleQuantS()) + 1;
                fView.setPickleQuantS(String.valueOf(newval));
            }
        });

        this.fView.setConfirmRestockItemsR(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e)  {
                int breadLimit = Integer.parseInt(fView.getBreadQuantR()) - fModel.getCurrentMachine().breadStock.size();
                restockItemR(breadLimit, new Bread());
                int hamLimit = Integer.parseInt(fView.getHamQuantR()) - fModel.getCurrentMachine().getHamStock().size();
                restockItemR(hamLimit, new Ham());
                int cheeseLimit = Integer.parseInt(fView.getCheeseQuantR()) - fModel.getCurrentMachine().getCheeseStock().size();
                restockItemR(cheeseLimit, new Cheese());
                int chickenLimit = Integer.parseInt(fView.getChickenQuantR()) - fModel.getCurrentMachine().getChickenStock().size();
                restockItemR(chickenLimit, new Chicken());
                int tunaLimit = Integer.parseInt(fView.getTunaQuantR()) - fModel.getCurrentMachine().getTunaStock().size();
                restockItemR(tunaLimit, new Chicken());
                int eggLimit = Integer.parseInt(fView.getEggQuantR()) - fModel.getCurrentMachine().getEggStock().size();
                restockItemR(eggLimit, new Egg());
                int mayoLimit = Integer.parseInt(fView.getMayoQuantR()) - fModel.getCurrentMachine().getMayonnaiseStock().size();
                restockItemR(mayoLimit, new Mayonnaise());
                int peanutBLimit = Integer.parseInt(fView.getPeanutBQuantR()) - fModel.getCurrentMachine().getPeanutbutterStock().size();
                restockItemR(peanutBLimit, new PeanutButter());
                int strawberryJLimit = Integer.parseInt(fView.getStrawberryJQuantR()) - fModel.getCurrentMachine().getStrawberryjamStock().size();
                restockItemR(strawberryJLimit, new StrawberryJam());
                int nutellaLimit = Integer.parseInt(fView.getNutellaQuantR()) - fModel.getCurrentMachine().getNutellaStock().size();
                restockItemR(nutellaLimit, new Nutella());

                fView.displayTestVM();
            }
        });

        this.fView.setConfirmRestockItemsS(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e)  {
                SpecialVendingMachine temp = (SpecialVendingMachine)fModel.getCurrentMachine();
                int breadLimit = Integer.parseInt(fView.getBreadQuantS()) - fModel.getCurrentMachine().breadStock.size();
                restockItemS(breadLimit, new Bread(), temp);
                int hamLimit = Integer.parseInt(fView.getHamQuantS()) - fModel.getCurrentMachine().getHamStock().size();
                restockItemS(hamLimit, new Ham(), temp);
                int cheeseLimit = Integer.parseInt(fView.getCheeseQuantS()) - fModel.getCurrentMachine().getCheeseStock().size();
                restockItemS(cheeseLimit, new Cheese(), temp);
                int chickenLimit = Integer.parseInt(fView.getChickenQuantS()) - fModel.getCurrentMachine().getChickenStock().size();
                restockItemS(chickenLimit, new Chicken(), temp);
                int tunaLimit = Integer.parseInt(fView.getTunaQuantS()) - fModel.getCurrentMachine().getTunaStock().size();
                restockItemS(tunaLimit, new Chicken(), temp);
                int eggLimit = Integer.parseInt(fView.getEggQuantS()) - fModel.getCurrentMachine().getEggStock().size();
                restockItemS(eggLimit, new Egg(), temp);
                int mayoLimit = Integer.parseInt(fView.getMayoQuantS()) - fModel.getCurrentMachine().getMayonnaiseStock().size();
                restockItemS(mayoLimit, new Mayonnaise(), temp);
                int peanutBLimit = Integer.parseInt(fView.getPeanutBQuantS()) - fModel.getCurrentMachine().getPeanutbutterStock().size();
                restockItemS(peanutBLimit, new PeanutButter(), temp);
                int strawberryJLimit = Integer.parseInt(fView.getStrawberryJQuantS()) - fModel.getCurrentMachine().getStrawberryjamStock().size();
                restockItemS(strawberryJLimit, new StrawberryJam(), temp);
                int nutellaLimit = Integer.parseInt(fView.getNutellaQuantS()) - fModel.getCurrentMachine().getNutellaStock().size();
                restockItemS(nutellaLimit, new Nutella(), temp);
                int lettuceLimit = Integer.parseInt(fView.getLettuceQuantS()) - temp.getLettuceStock().size();
                restockItemS(lettuceLimit, new Lettuce(), temp);
                int tomatoLimit = Integer.parseInt(fView.getTomatoQuantS()) - temp.getTomatoStock().size();
                restockItemS(tomatoLimit, new Tomato(), temp);
                int pickleLimit = Integer.parseInt(fView.getPickleQuantS()) - temp.getPickleStock().size();
                restockItemS(pickleLimit, new Pickle(), temp);

                fModel.setCurrentMachine(temp);

                fView.displayTestVM();
            }
        });


        // ADDED END

        this.fView.setRestockSandwichesListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e)  {
                // fView.displayRestockItemRVM();
                fView.displayRestockSandwiches();
            }
        });

        this.fView.setSetItemPriceListener(new ActionListener() {                       //START~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
            @Override
            public void actionPerformed(ActionEvent e)  {
                fView.displaySetItemPriceRVM();
            }
        });                                                                            

    }

    // ADDED 

    public void restockItemR(int limit, Item item)  {

        if(limit != 0)  {
            for(int i = 1; i <= limit; i++) {
                fModel.getCurrentMachine().addStock(item);
            }
        }

    }
    
    public void restockItemS(int limit, Item item, SpecialVendingMachine temp)  {

        if(limit != 0)  {
            for(int i = 1; i <= limit; i++) {
                temp.addStock(item);
            }
        }

    }

    // ADDED END
    
}
