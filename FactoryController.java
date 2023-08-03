import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

/**
 * The FactoryController class handles all the logical processing for the program and handles
 * all the computations for all functions of the program.
 * 
 */

public class FactoryController {

    private FactoryView fView;
    private FactoryModel fModel;

    /** Constructor for FactoryController
     * 
     * @param fView contains all GUI properties and provides feedback to the user
     * @param fModel hosts the stored vending machine
     */

    public FactoryController(FactoryView fView, FactoryModel fModel)    {
        this.fView = fView;
        this.fModel = fModel;

        //creating a vending machine
        factoryView();
        createVM();
        buyItem();
        restockItems();
        restockSandwiches();
        collectPayment();
        collectVMMoney();
        setItemPrice();
        replenishVMMoney();
        transactionHistory();

        //to go back to factory view from test VM menu
        this.fView.setBackListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e)  {
                fView.displayFactoryView();
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

        this.fView.setBackMaintenanceModeListenerFromSetPrice(new ActionListener() {        
            @Override
            public void actionPerformed(ActionEvent e)  {
                fView.displayMaintenanceInterface();
            }
        });       
        
        

    }

    private void factoryView()   {
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
    } 

    /**
     * The createVM() method handles the panel regarding the creation of a vending machine and stores it
     * in a FactoryModel
     * 
     */
    public void createVM()  {
        Factory factory = new Factory();

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

                SpecialVendingMachine svm = (SpecialVendingMachine)fModel.getCurrentMachine();
                svm.getHistory().setInitialStockS(svm);

                fModel.setCurrentMachine(svm);

                fView.displayFactoryView();
            
            }

        });
    }

    /**
     * The buyItem() handles the whole process of buying an item from the stored vending machine
     * 
     * 
     */
    public void buyItem()   {

        Money temp_payment = new Money();
        ArrayList<Item> temp_ingredientsList = new ArrayList<Item>();


        this.fView.setBuyItemListener(new ActionListener()  {
            @Override
            public void actionPerformed(ActionEvent e)  {
                String dispAmount = "Current Amount Inserted: P" + Double.toString(temp_payment.computeTotal());
                fView.setCurrentAmount(dispAmount);
                fView.displayBuyItemInterface();
            }
        });
        this.fView.setConfirmMoney(new ActionListener()  {              //DOES NOT ALLOW FOR ADVANCING TO VM IF NO MONEY IS INSERTED~~~~~~~START
            @Override
            public void actionPerformed(ActionEvent e)  {               //MUST INCLUDE IF MONEY IS NOT ENOUGH FOR ANY ITEM PURCHASE?????
                
                if(fModel.getCurrentMachine() instanceof SpecialVendingMachine && temp_payment.computeTotal() != 0) {
                    fView.displaySVMInterface();
                } else if (fModel.getCurrentMachine() instanceof VendingMachine && temp_payment.computeTotal() != 0) {
                    fView.displayRVMInterface();
                }
                else{
                    fView.dispErrorNotEnoughMoney();
                }
            }
        });       
        
        this.fView.setViewPriceList(new ActionListener()  {
            @Override
            public void actionPerformed(ActionEvent e)  {
                String longText = "Ham Sandwich\nP " + fModel.getCurrentMachine().getVendingMachineSlot(0).getsandwichList().get(0).getPrice()
                + "\n\nCheese Sandwich\nP" + fModel.getCurrentMachine().getVendingMachineSlot(1).getsandwichList().get(0).getPrice() 
                + "\n\nChicken Sandwich\nP" + fModel.getCurrentMachine().getVendingMachineSlot(2).getsandwichList().get(0).getPrice() 
                + "\n\nTuna Sandwich\nP" + fModel.getCurrentMachine().getVendingMachineSlot(3).getsandwichList().get(0).getPrice() 
                + "\n\nEgg Salad Sandwich\nP" + fModel.getCurrentMachine().getVendingMachineSlot(4).getsandwichList().get(0).getPrice() 
                + "\n\nPeanut Butter Sandwich\nP" + fModel.getCurrentMachine().getVendingMachineSlot(5).getsandwichList().get(0).getPrice() 
                + "\n\nStrawberry Jam Sandwich\nP" + fModel.getCurrentMachine().getVendingMachineSlot(6).getsandwichList().get(0).getPrice() 
                + "\n\nNutella Sandwich\nP" + fModel.getCurrentMachine().getVendingMachineSlot(7).getsandwichList().get(0).getPrice();

                fView.dispViewPriceList(longText);
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
        this.fView.setViewItemInfoRListener(new ActionListener()  {
            @Override
            public void actionPerformed(ActionEvent e)  {
                fView.setHamSandAvailabilityR(String.valueOf(fModel.getCurrentMachine().getVendingMachineSlot(0).getcurrentQuantity()));
                fView.setEggSandAvailabilityR(String.valueOf(fModel.getCurrentMachine().getVendingMachineSlot(1).getcurrentQuantity()));
                fView.setTunaSandAvailabilityR(String.valueOf(fModel.getCurrentMachine().getVendingMachineSlot(2).getcurrentQuantity()));
                fView.setCheeseSandAvailabilityR(String.valueOf(fModel.getCurrentMachine().getVendingMachineSlot(3).getcurrentQuantity()));
                fView.setChickenSandAvailabilityR(String.valueOf(fModel.getCurrentMachine().getVendingMachineSlot(4).getcurrentQuantity()));
                fView.setPeanutBSandAvailabilityR(String.valueOf(fModel.getCurrentMachine().getVendingMachineSlot(5).getcurrentQuantity()));
                fView.setStrawberryJSandAvailabilityR(String.valueOf(fModel.getCurrentMachine().getVendingMachineSlot(6).getcurrentQuantity()));
                fView.setNutellaSandAvailabilityR(String.valueOf(fModel.getCurrentMachine().getVendingMachineSlot(7).getcurrentQuantity()));
                fView.displayViewItemInfoR();
            }
        });
        this.fView.setGoBackFromViewItemInfoRListener(new ActionListener()  {
            @Override
            public void actionPerformed(ActionEvent e)  {
                fView.displayRVMInterface();
            }
        });
        this.fView.setViewItemInfoSListener(new ActionListener()  {
            @Override
            public void actionPerformed(ActionEvent e)  {
                fView.setHamSandAvailabilityS(String.valueOf(fModel.getCurrentMachine().getVendingMachineSlot(0).getcurrentQuantity()));
                fView.setEggSandAvailabilityS(String.valueOf(fModel.getCurrentMachine().getVendingMachineSlot(1).getcurrentQuantity()));
                fView.setTunaSandAvailabilityS(String.valueOf(fModel.getCurrentMachine().getVendingMachineSlot(2).getcurrentQuantity()));
                fView.setCheeseSandAvailabilityS(String.valueOf(fModel.getCurrentMachine().getVendingMachineSlot(3).getcurrentQuantity()));
                fView.setChickenSandAvailabilityS(String.valueOf(fModel.getCurrentMachine().getVendingMachineSlot(4).getcurrentQuantity()));
                fView.setPeanutBSandAvailabilityS(String.valueOf(fModel.getCurrentMachine().getVendingMachineSlot(5).getcurrentQuantity()));
                fView.setStrawberryJSandAvailabilityS(String.valueOf(fModel.getCurrentMachine().getVendingMachineSlot(6).getcurrentQuantity()));
                fView.setNutellaSandAvailabilityS(String.valueOf(fModel.getCurrentMachine().getVendingMachineSlot(7).getcurrentQuantity()));
                fView.setMayoAddAvailability(String.valueOf(fModel.getCurrentMachine().getMayonnaiseStock().size()));
                fView.setHamAddAvailability(String.valueOf(fModel.getCurrentMachine().getHamStock().size()));
                fView.setCheeseAddAvailability(String.valueOf(fModel.getCurrentMachine().getCheeseStock().size()));
                fView.setChickenAddAvailability(String.valueOf(fModel.getCurrentMachine().getChickenStock().size()));
                fView.setEggAddAvailability(String.valueOf(fModel.getCurrentMachine().getEggStock().size()));
                fView.setTunaAddAvailability(String.valueOf(fModel.getCurrentMachine().getTunaStock().size()));
                fView.setPeanutBAddAvailability(String.valueOf(fModel.getCurrentMachine().getPeanutbutterStock().size()));
                fView.setStrawberryJAddAvailability(String.valueOf(fModel.getCurrentMachine().getStrawberryjamStock().size()));
                fView.setNutellaAddAvailability(String.valueOf(fModel.getCurrentMachine().getNutellaStock().size()));
                SpecialVendingMachine svm = (SpecialVendingMachine)fModel.getCurrentMachine();
                fView.setLettuceAddAvailability(String.valueOf(svm.getLettuceStock().size()));
                fView.setTomatoAddAvailability(String.valueOf(svm.getTomatoStock().size()));
                fView.setPickleAddAvailability((String.valueOf(svm.getPickleStock().size())));
                fView.displayViewItemInfoS();
            }
        });
        this.fView.setViewAdditionalInfoListener(new ActionListener()  {
            @Override
            public void actionPerformed(ActionEvent e)  {
                fView.displayViewAddtionalItemsS();
            }
        });
        this.fView.setGoBackFromAdditionalInfoListener(new ActionListener()  {
            @Override
            public void actionPerformed(ActionEvent e)  {
                fView.displaySVMInterface();
            }
        });
        this.fView.setProduceReceiptOfPurchaseListener(new ActionListener()  {
            @Override
            public void actionPerformed(ActionEvent e)  {
                fView.displayReceiptOfPurchased();
            }
        });

        this.fView.setReceiptGoBackToMenuListener(new ActionListener()  {
            @Override
            public void actionPerformed(ActionEvent e)  {
                fView.displayTestVM();
            }
        });
        this.fView.setCancelTransactionRListener(new ActionListener()  {
            @Override
            public void actionPerformed(ActionEvent e)  {
                fModel.getCurrentMachine().receiveMoney(temp_payment);
                fModel.getCurrentMachine().produceTransaction(temp_payment, temp_payment);
                temp_payment.resetMoney();

                int latest = fModel.getCurrentMachine().getHistory().getTransactions().size() - 1;

                String text1, text2, text3;
                text1 = String.valueOf(fModel.getCurrentMachine().getHistory().getTransactions().get(latest).getPayment());
                text2 = "CANCELLED";
                text3 = String.valueOf(fModel.getCurrentMachine().getHistory().getTransactions().get(latest).getChange());
                fView.setShowReceiptTransaction(text1);
                fView.setShowReceiptProductPurchased(text2);
                fView.setShowReceiptProducedChange(text3);
                fView.displayReceiptOfPurchased();
                resetMoneyFields();
            }
        });
        this.fView.setCancelTransactionSListener(new ActionListener()  {
            @Override
            public void actionPerformed(ActionEvent e)  {
                fModel.getCurrentMachine().receiveMoney(temp_payment);
                fModel.getCurrentMachine().produceTransaction(temp_payment, temp_payment);
                temp_payment.resetMoney();

                int latest = fModel.getCurrentMachine().getHistory().getTransactions().size() - 1;

                String text1, text2, text3;
                text1 = String.valueOf(fModel.getCurrentMachine().getHistory().getTransactions().get(latest).getPayment());
                text2 = "CANCELLED";
                text3 = String.valueOf(fModel.getCurrentMachine().getHistory().getTransactions().get(latest).getChange());
                fView.setShowReceiptTransaction(text1);
                fView.setShowReceiptProductPurchased(text2);
                fView.setShowReceiptProducedChange(text3);
                fView.displayReceiptOfPurchased();
                resetMoneyFields();
            }
        });

       //for slot items ------------------------------------------- RVM
       this.fView.setSlot1RListener(new ActionListener()  {
        @Override
        public void actionPerformed(ActionEvent e)  {
            
            if(temp_payment.computeTotal() < 
            fModel.getCurrentMachine().getVendingMachineSlot(0).getsandwichList().get(0).getPrice())    {
                fView.dispErrorNotEnoughMoney();
            } else {
                boolean bool = fView.dispSelectItem();

                if(bool == true)    {
                        fModel.getCurrentMachine().receiveMoney(temp_payment);
                        Money change  = fModel.getCurrentMachine().produceChange(0, temp_payment);
                        fModel.getCurrentMachine().produceTransaction
                        (fModel.getCurrentMachine().getVendingMachineSlot(0).getsandwichList().get(0), 
                        temp_payment, change);
                        fModel.getCurrentMachine().dispenseItem(0);
                        temp_payment.resetMoney();
                        int latest = fModel.getCurrentMachine().getHistory().getTransactions().size() - 1;
                        String text1, text2, text3;
                        text1 = String.valueOf(fModel.getCurrentMachine().getHistory().getTransactions().get(latest).getPayment());
                        text2 = fModel.getCurrentMachine().getHistory().getTransactions().get(latest).getItem().getName() + " P" + 
                        fModel.getCurrentMachine().getVendingMachineSlot(0).getsandwichList().get(0).getPrice();
                        text3 = String.valueOf(fModel.getCurrentMachine().getHistory().getTransactions().get(latest).getChange());
                        fView.setShowReceiptTransaction(text1);
                        fView.setShowReceiptProductPurchased(text2);
                        fView.setShowReceiptProducedChange(text3);

                        fView.displayReceiptOfPurchased();
                        resetMoneyFields();
                } 
            }
            
        }
        });
        this.fView.setSlot2RListener(new ActionListener()  {
            @Override
            public void actionPerformed(ActionEvent e)  {
                if(temp_payment.computeTotal() < 
                fModel.getCurrentMachine().getVendingMachineSlot(1).getsandwichList().get(0).getPrice())    {
                    fView.dispErrorNotEnoughMoney();
                } else {
                    boolean bool = fView.dispSelectItem();

                    if(bool == true)    {
                        fModel.getCurrentMachine().receiveMoney(temp_payment);
                        Money change  = fModel.getCurrentMachine().produceChange(1, temp_payment);
                        fModel.getCurrentMachine().produceTransaction
                        (fModel.getCurrentMachine().getVendingMachineSlot(1).getsandwichList().get(0), 
                        temp_payment, change);
                        fModel.getCurrentMachine().dispenseItem(1);
                        temp_payment.resetMoney();
                        int latest = fModel.getCurrentMachine().getHistory().getTransactions().size() - 1;
                        String text1, text2, text3;
                        text1 = String.valueOf(fModel.getCurrentMachine().getHistory().getTransactions().get(latest).getPayment());
                        text2 = fModel.getCurrentMachine().getHistory().getTransactions().get(latest).getItem().getName() + " P" + 
                        fModel.getCurrentMachine().getVendingMachineSlot(1).getsandwichList().get(0).getPrice();
                        text3 = String.valueOf(fModel.getCurrentMachine().getHistory().getTransactions().get(latest).getChange());
                        fView.setShowReceiptTransaction(text1);
                        fView.setShowReceiptProductPurchased(text2);
                        fView.setShowReceiptProducedChange(text3);

                        fView.displayReceiptOfPurchased();
                        resetMoneyFields();
                    }
                }
            }
        });
        this.fView.setSlot3RListener(new ActionListener()  {
            @Override
            public void actionPerformed(ActionEvent e)  {
                if(temp_payment.computeTotal() < 
                fModel.getCurrentMachine().getVendingMachineSlot(2).getsandwichList().get(0).getPrice())    {
                    fView.dispErrorNotEnoughMoney();
                } else {
                    boolean bool = fView.dispSelectItem();

                    if(bool == true)    {
                        fModel.getCurrentMachine().receiveMoney(temp_payment);
                        Money change  = fModel.getCurrentMachine().produceChange(2, temp_payment);
                        fModel.getCurrentMachine().produceTransaction
                        (fModel.getCurrentMachine().getVendingMachineSlot(2).getsandwichList().get(0), 
                        temp_payment, change);
                        fModel.getCurrentMachine().dispenseItem(2);

                        int latest = fModel.getCurrentMachine().getHistory().getTransactions().size() - 1;
                        String text1, text2, text3;
                        text1 = String.valueOf(fModel.getCurrentMachine().getHistory().getTransactions().get(latest).getPayment());
                        text2 = fModel.getCurrentMachine().getHistory().getTransactions().get(latest).getItem().getName() + " P" + 
                        fModel.getCurrentMachine().getVendingMachineSlot(2).getsandwichList().get(0).getPrice();
                        text3 = String.valueOf(fModel.getCurrentMachine().getHistory().getTransactions().get(latest).getChange());
                        fView.setShowReceiptTransaction(text1);
                        fView.setShowReceiptProductPurchased(text2);
                        fView.setShowReceiptProducedChange(text3);

                        fView.displayReceiptOfPurchased();
                        resetMoneyFields();
                    }
                }
            }
        });
        this.fView.setSlot4RListener(new ActionListener()  {
            @Override
            public void actionPerformed(ActionEvent e)  {
                if(temp_payment.computeTotal() < 
                fModel.getCurrentMachine().getVendingMachineSlot(3).getsandwichList().get(0).getPrice())    {
                    fView.dispErrorNotEnoughMoney();
                } else {
                    boolean bool = fView.dispSelectItem();

                    if(bool == true)    {
                        fModel.getCurrentMachine().receiveMoney(temp_payment);
                        Money change  = fModel.getCurrentMachine().produceChange(3, temp_payment);
                        fModel.getCurrentMachine().produceTransaction
                        (fModel.getCurrentMachine().getVendingMachineSlot(3).getsandwichList().get(0), 
                        temp_payment, change);
                        fModel.getCurrentMachine().dispenseItem(3);
                        temp_payment.resetMoney();

                        int latest = fModel.getCurrentMachine().getHistory().getTransactions().size() - 1;
                        String text1, text2, text3;
                        text1 = String.valueOf(fModel.getCurrentMachine().getHistory().getTransactions().get(latest).getPayment());
                        text2 = fModel.getCurrentMachine().getHistory().getTransactions().get(latest).getItem().getName() + " P" + 
                        fModel.getCurrentMachine().getVendingMachineSlot(3).getsandwichList().get(0).getPrice();
                        text3 = String.valueOf(fModel.getCurrentMachine().getHistory().getTransactions().get(latest).getChange());
                        fView.setShowReceiptTransaction(text1);
                        fView.setShowReceiptProductPurchased(text2);
                        fView.setShowReceiptProducedChange(text3);

                        fView.displayReceiptOfPurchased();
                        resetMoneyFields();
                    }

                }
            }
        });
        this.fView.setSlot5RListener(new ActionListener()  {
            @Override
            public void actionPerformed(ActionEvent e)  {
                if(temp_payment.computeTotal() < 
                fModel.getCurrentMachine().getVendingMachineSlot(4).getsandwichList().get(0).getPrice())    {
                    fView.dispErrorNotEnoughMoney();
                } else {
                    boolean bool = fView.dispSelectItem();

                    if(bool == true)    {
                        fModel.getCurrentMachine().receiveMoney(temp_payment);
                        Money change  = fModel.getCurrentMachine().produceChange(4, temp_payment);
                        fModel.getCurrentMachine().produceTransaction
                        (fModel.getCurrentMachine().getVendingMachineSlot(4).getsandwichList().get(0), 
                        temp_payment, change);
                        fModel.getCurrentMachine().dispenseItem(4);
                        temp_payment.resetMoney();

                        int latest = fModel.getCurrentMachine().getHistory().getTransactions().size() - 1;
                        String text1, text2, text3;
                        text1 = String.valueOf(fModel.getCurrentMachine().getHistory().getTransactions().get(latest).getPayment());
                        text2 = fModel.getCurrentMachine().getHistory().getTransactions().get(latest).getItem().getName() + " P" + 
                        fModel.getCurrentMachine().getVendingMachineSlot(4).getsandwichList().get(0).getPrice();
                        text3 = String.valueOf(fModel.getCurrentMachine().getHistory().getTransactions().get(latest).getChange());
                        fView.setShowReceiptTransaction(text1);
                        fView.setShowReceiptProductPurchased(text2);
                        fView.setShowReceiptProducedChange(text3);

                        fView.displayReceiptOfPurchased();
                        resetMoneyFields();
                    }
                }
            }
        });
        this.fView.setSlot6RListener(new ActionListener()  {
            @Override
            public void actionPerformed(ActionEvent e)  {
                if(temp_payment.computeTotal() < 
                fModel.getCurrentMachine().getVendingMachineSlot(5).getsandwichList().get(0).getPrice())    {
                    fView.dispErrorNotEnoughMoney();
                } else {
                    boolean bool = fView.dispSelectItem();

                    if(bool == true)    {
                         fModel.getCurrentMachine().receiveMoney(temp_payment);
                        Money change  = fModel.getCurrentMachine().produceChange(5, temp_payment);
                        fModel.getCurrentMachine().produceTransaction
                        (fModel.getCurrentMachine().getVendingMachineSlot(5).getsandwichList().get(0), 
                        temp_payment, change);
                        fModel.getCurrentMachine().dispenseItem(5);
                        temp_payment.resetMoney();

                        int latest = fModel.getCurrentMachine().getHistory().getTransactions().size() - 1;
                        String text1, text2, text3;
                        text1 = String.valueOf(fModel.getCurrentMachine().getHistory().getTransactions().get(latest).getPayment());
                        text2 = fModel.getCurrentMachine().getHistory().getTransactions().get(latest).getItem().getName() + " P" + 
                        fModel.getCurrentMachine().getVendingMachineSlot(5).getsandwichList().get(0).getPrice();
                        text3 = String.valueOf(fModel.getCurrentMachine().getHistory().getTransactions().get(latest).getChange());
                        fView.setShowReceiptTransaction(text1);
                        fView.setShowReceiptProductPurchased(text2);
                        fView.setShowReceiptProducedChange(text3);

                        fView.displayReceiptOfPurchased();
                        resetMoneyFields();
                    }
                }
            }
        });

        this.fView.setSlot7RListener(new ActionListener()  {
            @Override
            public void actionPerformed(ActionEvent e)  {
                if(temp_payment.computeTotal() < 
                fModel.getCurrentMachine().getVendingMachineSlot(6).getsandwichList().get(0).getPrice())    {
                    fView.dispErrorNotEnoughMoney();
                } else {
                    boolean bool = fView.dispSelectItem();

                    if(bool == true)    {
                         fModel.getCurrentMachine().receiveMoney(temp_payment);
                        Money change  = fModel.getCurrentMachine().produceChange(6, temp_payment);
                        fModel.getCurrentMachine().produceTransaction
                        (fModel.getCurrentMachine().getVendingMachineSlot(6).getsandwichList().get(0), 
                        temp_payment, change);
                        fModel.getCurrentMachine().dispenseItem(6);
                        temp_payment.resetMoney();

                        int latest = fModel.getCurrentMachine().getHistory().getTransactions().size() - 1;
                        String text1, text2, text3;
                        text1 = String.valueOf(fModel.getCurrentMachine().getHistory().getTransactions().get(latest).getPayment());
                        text2 = fModel.getCurrentMachine().getHistory().getTransactions().get(latest).getItem().getName() + " P" + 
                        fModel.getCurrentMachine().getVendingMachineSlot(6).getsandwichList().get(0).getPrice();
                        text3 = String.valueOf(fModel.getCurrentMachine().getHistory().getTransactions().get(latest).getChange());
                        fView.setShowReceiptTransaction(text1);
                        fView.setShowReceiptProductPurchased(text2);
                        fView.setShowReceiptProducedChange(text3);

                        fView.displayReceiptOfPurchased();
                        resetMoneyFields();
                    }
                }
            }
        });
        this.fView.setSlot8RListener(new ActionListener()  {
            @Override
            public void actionPerformed(ActionEvent e)  {
                if(temp_payment.computeTotal() < 
                fModel.getCurrentMachine().getVendingMachineSlot(7).getsandwichList().get(0).getPrice())    {
                    fView.dispErrorNotEnoughMoney();
                } else {
                    boolean bool = fView.dispSelectItem();

                    if(bool == true)    {
                         fModel.getCurrentMachine().receiveMoney(temp_payment);
                        Money change  = fModel.getCurrentMachine().produceChange(7, temp_payment);
                        fModel.getCurrentMachine().produceTransaction
                        (fModel.getCurrentMachine().getVendingMachineSlot(7).getsandwichList().get(0), 
                        temp_payment, change);
                        fModel.getCurrentMachine().dispenseItem(7);
                        temp_payment.resetMoney();

                        int latest = fModel.getCurrentMachine().getHistory().getTransactions().size() - 1;
                        String text1, text2, text3;
                        text1 = String.valueOf(fModel.getCurrentMachine().getHistory().getTransactions().get(latest).getPayment());
                        text2 = fModel.getCurrentMachine().getHistory().getTransactions().get(latest).getItem().getName() + " P" + 
                        fModel.getCurrentMachine().getVendingMachineSlot(7).getsandwichList().get(0).getPrice();
                        text3 = String.valueOf(fModel.getCurrentMachine().getHistory().getTransactions().get(latest).getChange());
                        fView.setShowReceiptTransaction(text1);
                        fView.setShowReceiptProductPurchased(text2);
                        fView.setShowReceiptProducedChange(text3);

                        fView.displayReceiptOfPurchased();
                        resetMoneyFields();
                    }
                }
            }
        });

        //for slot items ------------------------------------------- SVM
        this.fView.setSlot1SListener(new ActionListener()  {
            @Override
            public void actionPerformed(ActionEvent e)  {
                if(temp_payment.computeTotal() < 
                fModel.getCurrentMachine().getVendingMachineSlot(0).getsandwichList().get(0).getPrice())    {
                    fView.dispErrorNotEnoughMoney();
                } else {
                    int result = fView.dispCustomizeItem();

                    if(result == 1) {
                        fModel.getCurrentMachine().getBreadStock().remove(fModel.getCurrentMachine().getBreadStock().size() - 1);
                        fModel.getCurrentMachine().getHamStock().remove(fModel.getCurrentMachine().getHamStock().size() - 1);
                        temp_ingredientsList.add(new Bread());
                        temp_ingredientsList.add(new Ham());
                        fView.setCustTextHam("1");
                        fView.setCustTextCheese("0");
                        fView.setCustTextChicken("0");
                        fView.setCustTextTuna("0");
                        fView.setCustTextEgg("0");
                        fView.setCustTextMayo("0");
                        fView.setCustTextPeanutB("0");
                        fView.setCustTextStrawberryJ("0");
                        fView.setCustTextNutella("0");
                        fView.setCustTextLettuce("0");
                        fView.setCustTextTomato("0");
                        fView.setCustTextPickle("0");

                        fView.displayCustomizeItemsSVMInterface();
                    } else if (result == 2) {
                        boolean bool = fView.dispSelectItem();

                        if(bool == true)    {
                            fModel.getCurrentMachine().receiveMoney(temp_payment);
                            Money change  = fModel.getCurrentMachine().produceChange(0, temp_payment);
                            fModel.getCurrentMachine().produceTransaction
                            (fModel.getCurrentMachine().getVendingMachineSlot(0).getsandwichList().get(0), 
                            temp_payment, change);
                            fModel.getCurrentMachine().dispenseItem(0);
                            temp_payment.resetMoney();

                            int latest = fModel.getCurrentMachine().getHistory().getTransactions().size() - 1;
                            String text1, text2, text3;
                            text1 = String.valueOf(fModel.getCurrentMachine().getHistory().getTransactions().get(latest).getPayment());
                            text2 = fModel.getCurrentMachine().getHistory().getTransactions().get(latest).getItem().getName() + " P" + 
                            fModel.getCurrentMachine().getVendingMachineSlot(0).getsandwichList().get(0).getPrice();
                            text3 = String.valueOf(fModel.getCurrentMachine().getHistory().getTransactions().get(latest).getChange());
                            fView.setShowReceiptTransaction(text1);
                            fView.setShowReceiptProductPurchased(text2);
                            fView.setShowReceiptProducedChange(text3);

                            fView.displayReceiptOfPurchased();
                            resetMoneyFields();
                        }
                    }
                }
            }
        });
        this.fView.setSlot2SListener(new ActionListener()  {
            @Override
            public void actionPerformed(ActionEvent e)  {
                if(temp_payment.computeTotal() < 
                fModel.getCurrentMachine().getVendingMachineSlot(1).getsandwichList().get(0).getPrice())    {
                    fView.dispErrorNotEnoughMoney();
                } else {
                    int result = fView.dispCustomizeItem();

                    if(result == 1) {
                        fModel.getCurrentMachine().getBreadStock().remove(fModel.getCurrentMachine().getBreadStock().size() - 1);
                        fModel.getCurrentMachine().getEggStock().remove(fModel.getCurrentMachine().getEggStock().size() - 1);
                        fModel.getCurrentMachine().getMayonnaiseStock().remove(fModel.getCurrentMachine().getMayonnaiseStock().size() - 1);
                        temp_ingredientsList.add(new Bread());
                        temp_ingredientsList.add(new Egg());
                        temp_ingredientsList.add(new Mayonnaise());
                        fView.setCustTextHam("0");
                        fView.setCustTextCheese("0");
                        fView.setCustTextChicken("0");
                        fView.setCustTextTuna("0");
                        fView.setCustTextEgg("1");
                        fView.setCustTextMayo("1");
                        fView.setCustTextPeanutB("0");
                        fView.setCustTextStrawberryJ("0");
                        fView.setCustTextNutella("0");
                        fView.setCustTextLettuce("0");
                        fView.setCustTextTomato("0");
                        fView.setCustTextPickle("0");
                        fView.displayCustomizeItemsSVMInterface();
                    } else if (result == 2) {
                        boolean bool = fView.dispSelectItem();

                        if(bool == true)    {
                            fModel.getCurrentMachine().receiveMoney(temp_payment);
                            Money change  = fModel.getCurrentMachine().produceChange(1, temp_payment);
                            fModel.getCurrentMachine().produceTransaction
                            (fModel.getCurrentMachine().getVendingMachineSlot(1).getsandwichList().get(0), 
                            temp_payment, change);
                            fModel.getCurrentMachine().dispenseItem(1);
                            temp_payment.resetMoney();
                            resetMoneyFields();
                        }
                    }
                }
            }
        });
        this.fView.setSlot3SListener(new ActionListener()  {
            @Override
            public void actionPerformed(ActionEvent e)  {
                if(temp_payment.computeTotal() < 
                fModel.getCurrentMachine().getVendingMachineSlot(2).getsandwichList().get(0).getPrice())    {
                    fView.dispErrorNotEnoughMoney();
                } else {
                    int result = fView.dispCustomizeItem();

                    if(result == 1) {
                        fModel.getCurrentMachine().getBreadStock().remove(fModel.getCurrentMachine().getBreadStock().size() - 1);
                        fModel.getCurrentMachine().getTunaStock().remove(fModel.getCurrentMachine().getTunaStock().size() - 1);
                        temp_ingredientsList.add(new Bread());
                        temp_ingredientsList.add(new Tuna());
                        fView.setCustTextHam("0");
                        fView.setCustTextCheese("0");
                        fView.setCustTextChicken("0");
                        fView.setCustTextTuna("1");
                        fView.setCustTextEgg("0");
                        fView.setCustTextMayo("0");
                        fView.setCustTextPeanutB("0");
                        fView.setCustTextStrawberryJ("0");
                        fView.setCustTextNutella("0");
                        fView.setCustTextLettuce("0");
                        fView.setCustTextTomato("0");
                        fView.setCustTextPickle("0");
                        fView.displayCustomizeItemsSVMInterface();
                    } else if (result == 2) {
                        boolean bool = fView.dispSelectItem();

                        if(bool == true)    {
                            fModel.getCurrentMachine().receiveMoney(temp_payment);
                            Money change  = fModel.getCurrentMachine().produceChange(2, temp_payment);
                            fModel.getCurrentMachine().produceTransaction
                            (fModel.getCurrentMachine().getVendingMachineSlot(2).getsandwichList().get(0), 
                            temp_payment, change);
                            fModel.getCurrentMachine().dispenseItem(2);
                            temp_payment.resetMoney();

                            int latest = fModel.getCurrentMachine().getHistory().getTransactions().size() - 1;
                            String text1, text2, text3;
                            text1 = String.valueOf(fModel.getCurrentMachine().getHistory().getTransactions().get(latest).getPayment());
                            text2 = fModel.getCurrentMachine().getHistory().getTransactions().get(latest).getItem().getName() + " P" + 
                            fModel.getCurrentMachine().getVendingMachineSlot(2).getsandwichList().get(0).getPrice();
                            text3 = String.valueOf(fModel.getCurrentMachine().getHistory().getTransactions().get(latest).getChange());
                            fView.setShowReceiptTransaction(text1);
                            fView.setShowReceiptProductPurchased(text2);
                            fView.setShowReceiptProducedChange(text3);

                            fView.displayReceiptOfPurchased();
                            resetMoneyFields();
                        }
                    }
                }
            }
        });
        this.fView.setSlot4SListener(new ActionListener()  {
            @Override
            public void actionPerformed(ActionEvent e)  {
                if(temp_payment.computeTotal() < 
                fModel.getCurrentMachine().getVendingMachineSlot(3).getsandwichList().get(0).getPrice())    {
                    fView.dispErrorNotEnoughMoney();
                } else {
                    int result = fView.dispCustomizeItem();

                    if(result == 1) {
                        fModel.getCurrentMachine().getBreadStock().remove(fModel.getCurrentMachine().getBreadStock().size() - 1);
                        fModel.getCurrentMachine().getCheeseStock().remove(fModel.getCurrentMachine().getCheeseStock().size() - 1);
                        temp_ingredientsList.add(new Bread());
                        temp_ingredientsList.add(new Cheese());
                        fView.setCustTextHam("0");
                        fView.setCustTextCheese("1");
                        fView.setCustTextChicken("0");
                        fView.setCustTextTuna("0");
                        fView.setCustTextEgg("0");
                        fView.setCustTextMayo("0");
                        fView.setCustTextPeanutB("0");
                        fView.setCustTextStrawberryJ("0");
                        fView.setCustTextNutella("0");
                        fView.setCustTextLettuce("0");
                        fView.setCustTextTomato("0");
                        fView.setCustTextPickle("0");
                        fView.displayCustomizeItemsSVMInterface();
                    } else if (result == 2) {
                        boolean bool = fView.dispSelectItem();

                        if(bool == true)    {
                            fModel.getCurrentMachine().receiveMoney(temp_payment);
                            Money change  = fModel.getCurrentMachine().produceChange(3, temp_payment);
                            fModel.getCurrentMachine().produceTransaction
                            (fModel.getCurrentMachine().getVendingMachineSlot(3).getsandwichList().get(0), 
                            temp_payment, change);
                            fModel.getCurrentMachine().dispenseItem(3);
                            temp_payment.resetMoney();

                            int latest = fModel.getCurrentMachine().getHistory().getTransactions().size() - 1;
                            String text1, text2, text3;
                            text1 = String.valueOf(fModel.getCurrentMachine().getHistory().getTransactions().get(latest).getPayment());
                            text2 = fModel.getCurrentMachine().getHistory().getTransactions().get(latest).getItem().getName() + " P" + 
                            fModel.getCurrentMachine().getVendingMachineSlot(3).getsandwichList().get(0).getPrice();
                            text3 = String.valueOf(fModel.getCurrentMachine().getHistory().getTransactions().get(latest).getChange());
                            fView.setShowReceiptTransaction(text1);
                            fView.setShowReceiptProductPurchased(text2);
                            fView.setShowReceiptProducedChange(text3);

                            fView.displayReceiptOfPurchased();
                            resetMoneyFields();
                        }
                    }
                }
            }
        });
        this.fView.setSlot5SListener(new ActionListener()  {
            @Override
            public void actionPerformed(ActionEvent e)  {
                if(temp_payment.computeTotal() < 
                fModel.getCurrentMachine().getVendingMachineSlot(4).getsandwichList().get(0).getPrice())    {
                    fView.dispErrorNotEnoughMoney();
                } else {
                    int result = fView.dispCustomizeItem();

                    if(result == 1) {
                        fModel.getCurrentMachine().getBreadStock().remove(fModel.getCurrentMachine().getBreadStock().size() - 1);
                        fModel.getCurrentMachine().getChickenStock().remove(fModel.getCurrentMachine().getChickenStock().size() - 1);
                        fModel.getCurrentMachine().getMayonnaiseStock().remove(fModel.getCurrentMachine().getMayonnaiseStock().size() - 1);
                        temp_ingredientsList.add(new Bread());
                        temp_ingredientsList.add(new Chicken());
                        temp_ingredientsList.add(new Mayonnaise());
                        fView.setCustTextHam("0");
                        fView.setCustTextCheese("0");
                        fView.setCustTextChicken("1");
                        fView.setCustTextTuna("0");
                        fView.setCustTextEgg("0");
                        fView.setCustTextMayo("1");
                        fView.setCustTextPeanutB("0");
                        fView.setCustTextStrawberryJ("0");
                        fView.setCustTextNutella("0");
                        fView.setCustTextLettuce("0");
                        fView.setCustTextTomato("0");
                        fView.setCustTextPickle("0");
                        fView.displayCustomizeItemsSVMInterface();
                    } else if (result == 2) {
                        boolean bool = fView.dispSelectItem();

                        if(bool == true)    {
                            fModel.getCurrentMachine().receiveMoney(temp_payment);
                            Money change  = fModel.getCurrentMachine().produceChange(4, temp_payment);
                            fModel.getCurrentMachine().produceTransaction
                            (fModel.getCurrentMachine().getVendingMachineSlot(4).getsandwichList().get(0), 
                            temp_payment, change);
                            fModel.getCurrentMachine().dispenseItem(4);
                            temp_payment.resetMoney();

                            int latest = fModel.getCurrentMachine().getHistory().getTransactions().size() - 1;
                            String text1, text2, text3;
                            text1 = String.valueOf(fModel.getCurrentMachine().getHistory().getTransactions().get(latest).getPayment());
                            text2 = fModel.getCurrentMachine().getHistory().getTransactions().get(latest).getItem().getName() + " P" + 
                            fModel.getCurrentMachine().getVendingMachineSlot(4).getsandwichList().get(0).getPrice();
                            text3 = String.valueOf(fModel.getCurrentMachine().getHistory().getTransactions().get(latest).getChange());
                            fView.setShowReceiptTransaction(text1);
                            fView.setShowReceiptProductPurchased(text2);
                            fView.setShowReceiptProducedChange(text3);

                            fView.displayReceiptOfPurchased();
                            resetMoneyFields();
                        }
                    }
                }
            }
        });
        this.fView.setSlot6SListener(new ActionListener()  {
            @Override
            public void actionPerformed(ActionEvent e)  {
                if(temp_payment.computeTotal() < 
                fModel.getCurrentMachine().getVendingMachineSlot(5).getsandwichList().get(0).getPrice())    {
                    fView.dispErrorNotEnoughMoney();
                } else {
                    int result = fView.dispCustomizeItem();

                    if(result == 1) {
                        fModel.getCurrentMachine().getBreadStock().remove(fModel.getCurrentMachine().getBreadStock().size() - 1);
                        fModel.getCurrentMachine().getPeanutbutterStock().remove(fModel.getCurrentMachine().getPeanutbutterStock().size() - 1);
                        temp_ingredientsList.add(new Bread());
                        temp_ingredientsList.add(new PeanutButter());
                        fView.setCustTextHam("0");
                        fView.setCustTextCheese("0");
                        fView.setCustTextChicken("0");
                        fView.setCustTextTuna("0");
                        fView.setCustTextEgg("0");
                        fView.setCustTextMayo("0");
                        fView.setCustTextPeanutB("1");
                        fView.setCustTextStrawberryJ("0");
                        fView.setCustTextNutella("0");
                        fView.setCustTextLettuce("0");
                        fView.setCustTextTomato("0");
                        fView.setCustTextPickle("0");
                        fView.displayCustomizeItemsSVMInterface();
                    } else if (result == 2) {
                        boolean bool = fView.dispSelectItem();

                        if(bool == true)    {
                            fModel.getCurrentMachine().receiveMoney(temp_payment);
                            Money change  = fModel.getCurrentMachine().produceChange(5, temp_payment);
                            fModel.getCurrentMachine().produceTransaction
                            (fModel.getCurrentMachine().getVendingMachineSlot(5).getsandwichList().get(0), 
                            temp_payment, change);
                            fModel.getCurrentMachine().dispenseItem(5);
                            temp_payment.resetMoney();

                            int latest = fModel.getCurrentMachine().getHistory().getTransactions().size() - 1;
                            String text1, text2, text3;
                            text1 = String.valueOf(fModel.getCurrentMachine().getHistory().getTransactions().get(latest).getPayment());
                            text2 = fModel.getCurrentMachine().getHistory().getTransactions().get(latest).getItem().getName() + " P" + 
                            fModel.getCurrentMachine().getVendingMachineSlot(5).getsandwichList().get(0).getPrice();
                            text3 = String.valueOf(fModel.getCurrentMachine().getHistory().getTransactions().get(latest).getChange());
                            fView.setShowReceiptTransaction(text1);
                            fView.setShowReceiptProductPurchased(text2);
                            fView.setShowReceiptProducedChange(text3);

                            fView.displayReceiptOfPurchased();
                            resetMoneyFields();
                        }
                    }
                }
            }
        });
        this.fView.setSlot7SListener(new ActionListener()  {
            @Override
            public void actionPerformed(ActionEvent e)  {
                if(temp_payment.computeTotal() < 
                fModel.getCurrentMachine().getVendingMachineSlot(6).getsandwichList().get(0).getPrice())    {
                    fView.dispErrorNotEnoughMoney();
                } else {
                    int result = fView.dispCustomizeItem();

                    if(result == 1) {
                        fModel.getCurrentMachine().getBreadStock().remove(fModel.getCurrentMachine().getBreadStock().size() - 1);
                        fModel.getCurrentMachine().getStrawberryjamStock().remove(fModel.getCurrentMachine().getStrawberryjamStock().size() - 1);
                        temp_ingredientsList.add(new Bread());
                        temp_ingredientsList.add(new StrawberryJam());
                        fView.setCustTextHam("0");
                        fView.setCustTextCheese("0");
                        fView.setCustTextChicken("0");
                        fView.setCustTextTuna("0");
                        fView.setCustTextEgg("0");
                        fView.setCustTextMayo("0");
                        fView.setCustTextPeanutB("0");
                        fView.setCustTextStrawberryJ("1");
                        fView.setCustTextNutella("0");
                        fView.setCustTextLettuce("0");
                        fView.setCustTextTomato("0");
                        fView.setCustTextPickle("0");
                        fView.displayCustomizeItemsSVMInterface();
                    } else if (result == 2) {
                        boolean bool = fView.dispSelectItem();

                        if(bool == true)    {
                            fModel.getCurrentMachine().receiveMoney(temp_payment);
                            Money change  = fModel.getCurrentMachine().produceChange(6, temp_payment);
                            fModel.getCurrentMachine().produceTransaction
                            (fModel.getCurrentMachine().getVendingMachineSlot(6).getsandwichList().get(0), 
                            temp_payment, change);
                            fModel.getCurrentMachine().dispenseItem(6);
                            temp_payment.resetMoney();

                            int latest = fModel.getCurrentMachine().getHistory().getTransactions().size() - 1;
                            String text1, text2, text3;
                            text1 = String.valueOf(fModel.getCurrentMachine().getHistory().getTransactions().get(latest).getPayment());
                            text2 = fModel.getCurrentMachine().getHistory().getTransactions().get(latest).getItem().getName() + " P" + 
                            fModel.getCurrentMachine().getVendingMachineSlot(6).getsandwichList().get(0).getPrice();
                            text3 = String.valueOf(fModel.getCurrentMachine().getHistory().getTransactions().get(latest).getChange());
                            fView.setShowReceiptTransaction(text1);
                            fView.setShowReceiptProductPurchased(text2);
                            fView.setShowReceiptProducedChange(text3);

                            fView.displayReceiptOfPurchased();
                            resetMoneyFields();
                        }
                    }
                }
            }
        });
        this.fView.setSlot8SListener(new ActionListener()  {
            @Override
            public void actionPerformed(ActionEvent e)  {
                if(temp_payment.computeTotal() < 
                fModel.getCurrentMachine().getVendingMachineSlot(7).getsandwichList().get(0).getPrice())    {
                    fView.dispErrorNotEnoughMoney();
                } else {

                    int result = fView.dispCustomizeItem();

                    if(result == 1) {
                        fModel.getCurrentMachine().getBreadStock().remove(fModel.getCurrentMachine().getBreadStock().size() - 1);
                        fModel.getCurrentMachine().getNutellaStock().remove(fModel.getCurrentMachine().getNutellaStock().size() - 1);
                        temp_ingredientsList.add(new Bread());
                        temp_ingredientsList.add(new Nutella());
                        fView.setCustTextHam("0");
                        fView.setCustTextCheese("0");
                        fView.setCustTextChicken("0");
                        fView.setCustTextTuna("0");
                        fView.setCustTextEgg("0");
                        fView.setCustTextMayo("0");
                        fView.setCustTextPeanutB("0");
                        fView.setCustTextStrawberryJ("0");
                        fView.setCustTextNutella("1");
                        fView.setCustTextLettuce("0");
                        fView.setCustTextTomato("0");
                        fView.setCustTextPickle("0");
                        fView.displayCustomizeItemsSVMInterface();
                    } else if (result == 2) {
                        boolean bool = fView.dispSelectItem();

                        if(bool == true)    {
                            fModel.getCurrentMachine().receiveMoney(temp_payment);
                            Money change  = fModel.getCurrentMachine().produceChange(7, temp_payment);
                            fModel.getCurrentMachine().produceTransaction
                            (fModel.getCurrentMachine().getVendingMachineSlot(7).getsandwichList().get(0), 
                            temp_payment, change);
                            fModel.getCurrentMachine().dispenseItem(7);
                            temp_payment.resetMoney();

                            int latest = fModel.getCurrentMachine().getHistory().getTransactions().size() - 1;
                            String text1, text2, text3;
                            text1 = String.valueOf(fModel.getCurrentMachine().getHistory().getTransactions().get(latest).getPayment());
                            text2 = fModel.getCurrentMachine().getHistory().getTransactions().get(latest).getItem().getName() + " P" + 
                            fModel.getCurrentMachine().getVendingMachineSlot(7).getsandwichList().get(0).getPrice();
                            text3 = String.valueOf(fModel.getCurrentMachine().getHistory().getTransactions().get(latest).getChange());
                            fView.setShowReceiptTransaction(text1);
                            fView.setShowReceiptProductPurchased(text2);
                            fView.setShowReceiptProducedChange(text3);

                            fView.displayReceiptOfPurchased();
                            resetMoneyFields();
                        }
                    }
                }
            }
        });

        this.fView.setCustPlusHamListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e)  {
                int newval = Integer.parseInt(fView.getCustTextHam()) + 1;

                if(fModel.getCurrentMachine().getHamStock().size() - newval < 0)    {
                    fView.dispErrorNotEnoughStock();
                } else  {
                    fView.setCustTextHam(String.valueOf(newval));
                    temp_ingredientsList.add(new Ham());
                }

            }            
        });

        this.fView.setCustPlusCheeseListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e)  {
                int newval = Integer.parseInt(fView.getCustTextCheese()) + 1;

                if(fModel.getCurrentMachine().getCheeseStock().size() - newval < 0)    {
                    fView.dispErrorNotEnoughStock();
                } else  {
                    fView.setCustTextCheese(String.valueOf(newval));
                    temp_ingredientsList.add(new Cheese());
                }
            }            
        });

        this.fView.setCustPlusChickenListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e)  {
                int newval = Integer.parseInt(fView.getCustTextChicken()) + 1;

                if(fModel.getCurrentMachine().getChickenStock().size() - newval < 0)   {
                    fView.dispErrorNotEnoughStock();
                } else  {
                    fView.setCustTextChicken(String.valueOf(newval));
                    temp_ingredientsList.add(new Chicken());
                }
            }            
        });

        this.fView.setCustPlusTunaListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e)  {

                int newval = Integer.parseInt(fView.getCustTextTuna()) + 1;

                if(fModel.getCurrentMachine().getTunaStock().size() - newval < 0)    {
                    fView.dispErrorNotEnoughStock();
                } else  {
                    fView.setCustTextTuna(String.valueOf(newval));
                    temp_ingredientsList.add(new Tuna());
                }
            }            
        });

        this.fView.setCustPlusEggListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e)  {

                int newval = Integer.parseInt(fView.getCustTextEgg()) + 1;

                if(fModel.getCurrentMachine().getEggStock().size() - newval < 0)    {
                    fView.dispErrorNotEnoughStock();
                } else  {
                    fView.setCustTextEgg(String.valueOf(newval));
                    temp_ingredientsList.add(new Egg());
                }
            }            
        });

        this.fView.setCustPlusMayoListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e)  {

                int newval = Integer.parseInt(fView.getCustTextMayo()) + 1;

                if(fModel.getCurrentMachine().getMayonnaiseStock().size() - newval < 0)    {
                    fView.dispErrorNotEnoughStock();
                } else  {
                    fView.setCustTextMayo(String.valueOf(newval));
                    temp_ingredientsList.add(new Mayonnaise());
                }
            }            
        });

        this.fView.setCustPlusPeanutBListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e)  {

                int newval = Integer.parseInt(fView.getCustTextPeanutB()) + 1;

                if(fModel.getCurrentMachine().getPeanutbutterStock().size() - newval < 0)    {
                    fView.dispErrorNotEnoughStock();
                } else  {
                    fView.setCustTextPeanutB(String.valueOf(newval));
                    temp_ingredientsList.add(new PeanutButter());
                }
            }            
        });

        this.fView.setCustPlusStrawberryJListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e)  {

                int newval = Integer.parseInt(fView.getCustTextStrawberryJ()) + 1;

                if(fModel.getCurrentMachine().getStrawberryjamStock().size() - newval < 0)    {
                    fView.dispErrorNotEnoughStock();
                } else  {
                    fView.setCustTextStrawberryJ(String.valueOf(newval));
                    temp_ingredientsList.add(new StrawberryJam());
                }
            }            
        });

        this.fView.setCustPlusNutellaListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e)  {

                int newval = Integer.parseInt(fView.getCustTextNutella()) + 1;

                if(fModel.getCurrentMachine().getNutellaStock().size() - newval < 0)    {
                    fView.dispErrorNotEnoughStock();
                } else  {
                    fView.setCustTextNutella(String.valueOf(newval));
                    temp_ingredientsList.add(new Nutella());
                }
            }            
        });

        this.fView.setCustPlusLettuceListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e)  {

                int newval = Integer.parseInt(fView.getCustTextLettuce()) + 1;

                SpecialVendingMachine svm = (SpecialVendingMachine)fModel.getCurrentMachine();

                if(svm.getLettuceStock().size() - newval < 0)    {
                    fView.dispErrorNotEnoughStock();
                } else  {
                    fView.setCustTextLettuce(String.valueOf(newval));
                    temp_ingredientsList.add(new Lettuce());
                }
            }            
        });

        this.fView.setCustPlusTomatoListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e)  {

                int newval = Integer.parseInt(fView.getCustTextTomato()) + 1;

                SpecialVendingMachine svm = (SpecialVendingMachine)fModel.getCurrentMachine();

                if(svm.getTomatoStock().size() - newval < 0)    {
                    fView.dispErrorNotEnoughStock();
                } else  {
                    fView.setCustTextTomato(String.valueOf(newval));
                    temp_ingredientsList.add(new Tomato());
                }
            }            
        });

        this.fView.setCustPlusPickleListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e)  {

                int newval = Integer.parseInt(fView.getCustTextPickle()) + 1;

                SpecialVendingMachine svm = (SpecialVendingMachine)fModel.getCurrentMachine();

                if(svm.getPickleStock().size() - newval < 0)    {
                    fView.dispErrorNotEnoughStock();
                } else  {
                    fView.setCustTextPickle(String.valueOf(newval));
                    temp_ingredientsList.add(new Pickle());
                }
            }            
        });
        this.fView.setPurchaseCustItemListener(new ActionListener()    {
            @Override
            public void actionPerformed(ActionEvent e)  {

                int calories = 0;
                Money change;

                for(int i = 0; i < temp_ingredientsList.size(); i++)    {
                    calories += temp_ingredientsList.get(i).getCalories();
                }

                Sandwich temp_sandwich = new Sandwich(temp_ingredientsList, calories);
                temp_sandwich.computePrice();

                SpecialVendingMachine svm = (SpecialVendingMachine)fModel.getCurrentMachine();

                if(temp_sandwich.getPrice() > temp_payment.computeTotal())   {
                    temp_ingredientsList.clear();
                    fView.dispErrorNotEnoughMoneySpecial();
                    fView.displayBuyItemInterface();
                } else  {

                    Sandwich sandwich = svm.createSandwich(temp_ingredientsList, calories);
                    sandwich.computePrice();

                    change = svm.produceSpecialChange(sandwich, temp_payment);
                    
                    svm.produceTransaction(sandwich, temp_payment, change);

                    int latest = svm.getHistory().getTransactions().size() - 1;
                    String text1, text2, text3;
                    text1 = String.valueOf(fModel.getCurrentMachine().getHistory().getTransactions().get(latest).getPayment());
                    text2 = fModel.getCurrentMachine().getHistory().getTransactions().get(latest).getItem().getName() + " P" + 
                    sandwich.getPrice();
                    text3 = String.valueOf(fModel.getCurrentMachine().getHistory().getTransactions().get(latest).getChange());
                    fView.setShowReceiptTransaction(text1);
                    fView.setShowReceiptProductPurchased(text2);
                    fView.setShowReceiptProducedChange(text3);

                    temp_payment.resetMoney();
                    resetMoneyFields();
                    fView.displayViewItemPreparation();
                }
                    
            }
        });


    }

    private void restockItems()  {
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

                fModel.getCurrentMachine().resetHistoryRecord();

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
                temp.resetHistoryRecord();
                fModel.setCurrentMachine(temp);

                fView.displayTestVM();
            }
        });

    }

    private void restockSandwiches() {
       this.fView.setRestockSandwichesListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e)  {
                fView.setHamSandwichQuant(String.valueOf(fModel.getCurrentMachine().getVendingMachineSlot(0).getcurrentQuantity()));
                fView.setEggSandwichQuant(String.valueOf(fModel.getCurrentMachine().getVendingMachineSlot(1).getcurrentQuantity()));
                fView.setTunaSandwichQuant(String.valueOf(fModel.getCurrentMachine().getVendingMachineSlot(2).getcurrentQuantity()));
                fView.setCheeseSandwichQuant(String.valueOf(fModel.getCurrentMachine().getVendingMachineSlot(3).getcurrentQuantity()));
                fView.setChickenSandwichQuant(String.valueOf(fModel.getCurrentMachine().getVendingMachineSlot(4).getcurrentQuantity()));
                fView.setPeanutBSandwichQuant(String.valueOf(fModel.getCurrentMachine().getVendingMachineSlot(5).getcurrentQuantity()));
                fView.setStrawberryJSandwichQuant(String.valueOf(fModel.getCurrentMachine().getVendingMachineSlot(6).getcurrentQuantity()));
                fView.setNutellaSandwichQuant(String.valueOf(fModel.getCurrentMachine().getVendingMachineSlot(7).getcurrentQuantity()));
                fView.displayRestockSandwiches();
            }
        });

        this.fView.setPlusHamSandwichListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e)  {

                int newval = Integer.parseInt(fView.getHamSandwichQuant()) + 1;
                ArrayList<Item> ingredientsList = new ArrayList<Item>();
                int calories = 0;

                Sandwich sandwich;
                
                if(fModel.getCurrentMachine().getBreadStock().size() - 1 != -1 &&
                fModel.getCurrentMachine().getHamStock().size() - 1 != -1)   {

                    fView.setHamSandwichQuant(String.valueOf(newval));
                    ingredientsList.add(new Bread());
                    ingredientsList.add(new Ham());
                    
                    for(int i = 0; i < ingredientsList.size(); i++) {
                        calories += ingredientsList.get(i).getCalories();
                    }

                    fModel.getCurrentMachine().getBreadStock().remove(fModel.getCurrentMachine().getBreadStock().size() - 1);
                    fModel.getCurrentMachine().getHamStock().remove(fModel.getCurrentMachine().getHamStock().size()-1);

                    sandwich = new Sandwich(ingredientsList, calories);
                    fModel.getCurrentMachine().getVendingMachineSlot(0).setinitialQuantity(newval);
                    fModel.getCurrentMachine().getVendingMachineSlot(0).fillSlots(sandwich);
                } else fView.dispErrorSandwichRestock();
                           
            }
        });

        this.fView.setPlusEggSandwichListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e)  {
                int newval = Integer.parseInt(fView.getEggSandwichQuant()) + 1;
                ArrayList<Item> ingredientsList = new ArrayList<Item>();
                int calories = 0;

                Sandwich sandwich;
                
                if(fModel.getCurrentMachine().getBreadStock().size() - 1 != -1 &&
                fModel.getCurrentMachine().getEggStock().size() - 1 != -1 &&
                fModel.getCurrentMachine().getMayonnaiseStock().size() -1 != -1)   {

                    fView.setEggSandwichQuant(String.valueOf(newval));
                    ingredientsList.add(new Bread());
                    ingredientsList.add(new Egg());
                    ingredientsList.add(new Mayonnaise());
                    
                    for(int i = 0; i < ingredientsList.size(); i++) {
                        calories += ingredientsList.get(i).getCalories();
                    }

                    fModel.getCurrentMachine().getBreadStock().remove(fModel.getCurrentMachine().getBreadStock().size() - 1);
                    fModel.getCurrentMachine().getEggStock().remove(fModel.getCurrentMachine().getEggStock().size()-1);
                    fModel.getCurrentMachine().getMayonnaiseStock().remove(fModel.getCurrentMachine().getMayonnaiseStock().size()-1);

                    sandwich = new Sandwich(ingredientsList, calories);
                    fModel.getCurrentMachine().getVendingMachineSlot(1).setinitialQuantity(newval);
                    fModel.getCurrentMachine().getVendingMachineSlot(1).fillSlots(sandwich);
                } else fView.dispErrorSandwichRestock();            
            }
        });

        this.fView.setPlusTunaSandwichListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e)  {
                int newval = Integer.parseInt(fView.getTunaSandwichQuant()) + 1;
                ArrayList<Item> ingredientsList = new ArrayList<Item>();
                int calories = 0;

                Sandwich sandwich;
                
                if(fModel.getCurrentMachine().getBreadStock().size() - 1 != -1 &&
                fModel.getCurrentMachine().getTunaStock().size() - 1 != -1)   {

                    fView.setTunaSandwichQuant(String.valueOf(newval));
                    ingredientsList.add(new Bread());
                    ingredientsList.add(new Tuna());

                    for(int i = 0; i < ingredientsList.size(); i++) {
                        calories += ingredientsList.get(i).getCalories();
                    }

                    fModel.getCurrentMachine().getBreadStock().remove(fModel.getCurrentMachine().getBreadStock().size() - 1);
                    fModel.getCurrentMachine().getTunaStock().remove(fModel.getCurrentMachine().getTunaStock().size()-1);

                    sandwich = new Sandwich(ingredientsList, calories);
                    fModel.getCurrentMachine().getVendingMachineSlot(2).setinitialQuantity(newval);
                    fModel.getCurrentMachine().getVendingMachineSlot(2).fillSlots(sandwich);
                } else fView.dispErrorSandwichRestock();            
            }
        });

        this.fView.setPlusCheeseSandwichListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e)  {
                int newval = Integer.parseInt(fView.getCheeseSandwichQuant()) + 1;
                ArrayList<Item> ingredientsList = new ArrayList<Item>();
                int calories = 0;

                Sandwich sandwich;
                
                if(fModel.getCurrentMachine().getBreadStock().size() - 1 != -1 &&
                fModel.getCurrentMachine().getCheeseStock().size() - 1 != -1)   {

                    fView.setCheeseSandwichQuant(String.valueOf(newval));
                    ingredientsList.add(new Bread());
                    ingredientsList.add(new Cheese());

                    for(int i = 0; i < ingredientsList.size(); i++) {
                        calories += ingredientsList.get(i).getCalories();
                    }

                    fModel.getCurrentMachine().getBreadStock().remove(fModel.getCurrentMachine().getBreadStock().size() - 1);
                    fModel.getCurrentMachine().getCheeseStock().remove(fModel.getCurrentMachine().getCheeseStock().size()-1);

                    sandwich = new Sandwich(ingredientsList, calories);
                    fModel.getCurrentMachine().getVendingMachineSlot(3).setinitialQuantity(newval);
                    fModel.getCurrentMachine().getVendingMachineSlot(3).fillSlots(sandwich);
                } else fView.dispErrorSandwichRestock();            
            }
        });

        this.fView.setPlusChickenSandwichListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e)  {
                int newval = Integer.parseInt(fView.getChickenSandwichQuant()) + 1;
                ArrayList<Item> ingredientsList = new ArrayList<Item>();
                int calories = 0;

                Sandwich sandwich;
                
                if(fModel.getCurrentMachine().getBreadStock().size() - 1 != -1 &&
                fModel.getCurrentMachine().getChickenStock().size() - 1 != -1)   {

                    fView.setChickenSandwichQuant(String.valueOf(newval));
                    ingredientsList.add(new Bread());
                    ingredientsList.add(new Chicken());
                    ingredientsList.add(new Mayonnaise());

                    for(int i = 0; i < ingredientsList.size(); i++) {
                        calories += ingredientsList.get(i).getCalories();
                    }

                    fModel.getCurrentMachine().getBreadStock().remove(fModel.getCurrentMachine().getBreadStock().size() - 1);
                    fModel.getCurrentMachine().getChickenStock().remove(fModel.getCurrentMachine().getChickenStock().size()-1);
                    fModel.getCurrentMachine().getMayonnaiseStock().remove(fModel.getCurrentMachine().getMayonnaiseStock().size()-1);

                    sandwich = new Sandwich(ingredientsList, calories);
                    fModel.getCurrentMachine().getVendingMachineSlot(4).setinitialQuantity(newval);
                    fModel.getCurrentMachine().getVendingMachineSlot(4).fillSlots(sandwich);
                } else fView.dispErrorSandwichRestock();                 
            }
        });

        this.fView.setPlusPeanutBSandwichListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e)  {
                int newval = Integer.parseInt(fView.getPeanutBSandwichQuant()) + 1;
                ArrayList<Item> ingredientsList = new ArrayList<Item>();
                int calories = 0;

                Sandwich sandwich;
                
                if(fModel.getCurrentMachine().getBreadStock().size() - 1 != -1 &&
                fModel.getCurrentMachine().getPeanutbutterStock().size() - 1 != -1)   {

                    fView.setPeanutBSandwichQuant(String.valueOf(newval));
                    ingredientsList.add(new Bread());
                    ingredientsList.add(new PeanutButter());

                    for(int i = 0; i < ingredientsList.size(); i++) {
                        calories += ingredientsList.get(i).getCalories();
                    }

                    fModel.getCurrentMachine().getBreadStock().remove(fModel.getCurrentMachine().getBreadStock().size() - 1);
                    fModel.getCurrentMachine().getPeanutbutterStock().remove(fModel.getCurrentMachine().getPeanutbutterStock().size()-1);

                    sandwich = new Sandwich(ingredientsList, calories);
                    fModel.getCurrentMachine().getVendingMachineSlot(3).setinitialQuantity(newval);
                    fModel.getCurrentMachine().getVendingMachineSlot(3).fillSlots(sandwich);
                } else fView.dispErrorSandwichRestock();                   
            }
        });

        this.fView.setPlusStrawberryJSandwichListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e)  {
                int newval = Integer.parseInt(fView.getStrawberryJSandwichQuant()) + 1;
                ArrayList<Item> ingredientsList = new ArrayList<Item>();
                int calories = 0;

                Sandwich sandwich;
                
                if(fModel.getCurrentMachine().getBreadStock().size() - 1 != -1 &&
                fModel.getCurrentMachine().getStrawberryjamStock().size() - 1 != -1)   {

                    fView.setStrawberryJSandwichQuant(String.valueOf(newval));
                    ingredientsList.add(new Bread());
                    ingredientsList.add(new StrawberryJam());

                    for(int i = 0; i < ingredientsList.size(); i++) {
                        calories += ingredientsList.get(i).getCalories();
                    }

                    fModel.getCurrentMachine().getBreadStock().remove(fModel.getCurrentMachine().getBreadStock().size() - 1);
                    fModel.getCurrentMachine().getStrawberryjamStock().remove(fModel.getCurrentMachine().getStrawberryjamStock().size()-1);

                    sandwich = new Sandwich(ingredientsList, calories);
                    fModel.getCurrentMachine().getVendingMachineSlot(3).setinitialQuantity(newval);
                    fModel.getCurrentMachine().getVendingMachineSlot(3).fillSlots(sandwich);
                } else fView.dispErrorSandwichRestock();                 
            }
        });

        this.fView.setPlusNutellaSandwichListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e)  {
                int newval = Integer.parseInt(fView.getNutellaSandwichQuant()) + 1;
                ArrayList<Item> ingredientsList = new ArrayList<Item>();
                int calories = 0;

                Sandwich sandwich;
                
                if(fModel.getCurrentMachine().getBreadStock().size() - 1 != -1 &&
                fModel.getCurrentMachine().getNutellaStock().size() - 1 != -1)   {

                    fView.setNutellaSandwichQuant(String.valueOf(newval));
                    ingredientsList.add(new Bread());
                    ingredientsList.add(new Nutella());

                    for(int i = 0; i < ingredientsList.size(); i++) {
                        calories += ingredientsList.get(i).getCalories();
                    }

                    fModel.getCurrentMachine().getBreadStock().remove(fModel.getCurrentMachine().getBreadStock().size() - 1);
                    fModel.getCurrentMachine().getNutellaStock().remove(fModel.getCurrentMachine().getNutellaStock().size()-1);

                    sandwich = new Sandwich(ingredientsList, calories);
                    fModel.getCurrentMachine().getVendingMachineSlot(3).setinitialQuantity(newval);
                    fModel.getCurrentMachine().getVendingMachineSlot(3).fillSlots(sandwich);
                } else fView.dispErrorSandwichRestock();                  
            }
        });
    }

    private void collectPayment()   {

        this.fView.setCollectPaymentsListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e)  {
                String message = "Total User Payments: P" + fModel.getCurrentMachine().getUserPayments().computeTotal() +
                "\n\nCollect?";;
                boolean bool = fView.buildCollectPayment(message);

                if(bool == true)    {
                    message = "Collected P" + fModel.getCurrentMachine().getUserPayments().computeTotal();
                    fView.confirmCollectPayment(message);
                    fModel.getCurrentMachine().getUserPayments().resetMoney();
                }
            }
        });
    }

    private void collectVMMoney()   {
        this.fView.setCollectVMMoneyListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e)  {
                String message = "Total Money in Vending Machine: P" + fModel.getCurrentMachine().getVmMoney().computeTotal() +
                "\n\nCollect?";
                boolean bool = fView.buildCollectMachineMoney(message);

                if(bool == true)    {
                    message = "Collected P" + fModel.getCurrentMachine().getVmMoney().computeTotal();
                    fView.confirmCollectPayment(message);
                    fModel.getCurrentMachine().getVmMoney().resetMoney();
                }
            }
        });
    }

    private void setItemPrice()  {
        this.fView.setSetItemPriceListener(new ActionListener() {                       //START~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
            @Override
            public void actionPerformed(ActionEvent e)  {
                fView.setCurHamSandwichPrice
                (String.valueOf(fModel.getCurrentMachine().getVendingMachineSlot(0).getsandwichList().get(0).getPrice()));
                fView.setCurEggSandwichPrice
                (String.valueOf(fModel.getCurrentMachine().getVendingMachineSlot(1).getsandwichList().get(0).getPrice()));
                fView.setCurTunaSandwichPrice
                (String.valueOf(fModel.getCurrentMachine().getVendingMachineSlot(2).getsandwichList().get(0).getPrice()));
                fView.setCurCheeseSandwichPrice
                (String.valueOf(fModel.getCurrentMachine().getVendingMachineSlot(3).getsandwichList().get(0).getPrice()));
                fView.setCurChickenSandwichPrice
                (String.valueOf(fModel.getCurrentMachine().getVendingMachineSlot(4).getsandwichList().get(0).getPrice()));
                fView.setCurPeanutBSandwichPrice
                (String.valueOf(fModel.getCurrentMachine().getVendingMachineSlot(5).getsandwichList().get(0).getPrice()));
                fView.setCurStrawberryJSandwichPrice
                (String.valueOf(fModel.getCurrentMachine().getVendingMachineSlot(6).getsandwichList().get(0).getPrice()));
                fView.setCurNutellaSandwichPrice
                (String.valueOf(fModel.getCurrentMachine().getVendingMachineSlot(7).getsandwichList().get(0).getPrice()));
                fView.displaySetItemPriceRVM();
            }
        });

        this.fView.setConfirmItemPrice(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e)  {

                Sandwich temp;
                if(Double.parseDouble(fView.getCurHamSandwichPrice()) > -1 && fView.getCurHamSandwichPrice() != null) {
                    temp = fModel.getCurrentMachine().getVendingMachineSlot(0).getsandwichList().get(0);
                    temp.setPrice(Double.parseDouble(fView.getCurHamSandwichPrice()));
                    fModel.getCurrentMachine().getVendingMachineSlot(0).fillSlots(temp);
                }

                if(Double.parseDouble(fView.getCurEggSandwichPrice()) > -1 && fView.getCurEggSandwichPrice() != null) {
                    temp = fModel.getCurrentMachine().getVendingMachineSlot(1).getsandwichList().get(0);
                    temp.setPrice(Double.parseDouble(fView.getCurEggSandwichPrice()));
                    fModel.getCurrentMachine().getVendingMachineSlot(1).fillSlots(temp);
                }

                if(Double.parseDouble(fView.getCurTunaSandwichPrice()) > -1 && fView.getCurTunaSandwichPrice() != null) {
                    temp = fModel.getCurrentMachine().getVendingMachineSlot(2).getsandwichList().get(0);
                    temp.setPrice(Double.parseDouble(fView.getCurTunaSandwichPrice()));
                    fModel.getCurrentMachine().getVendingMachineSlot(2).fillSlots(temp);
                }

                if(Double.parseDouble(fView.getCurCheeseSandwichPrice()) > -1 && fView.getCurCheeseSandwichPrice() != null) {
                    temp = fModel.getCurrentMachine().getVendingMachineSlot(3).getsandwichList().get(0);
                    temp.setPrice(Double.parseDouble(fView.getCurCheeseSandwichPrice()));
                    fModel.getCurrentMachine().getVendingMachineSlot(3).fillSlots(temp);
                }

                if(Double.parseDouble(fView.getCurChickenSandwichPrice()) > -1 && fView.getCurChickenSandwichPrice() != null) {
                    temp = fModel.getCurrentMachine().getVendingMachineSlot(4).getsandwichList().get(0);
                    temp.setPrice(Double.parseDouble(fView.getCurChickenSandwichPrice()));
                    fModel.getCurrentMachine().getVendingMachineSlot(4).fillSlots(temp);
                }

                if(Double.parseDouble(fView.getCurPeanutBSandwichPrice()) > -1 && fView.getCurPeanutBSandwichPrice() != null) {
                    temp = fModel.getCurrentMachine().getVendingMachineSlot(5).getsandwichList().get(0);
                    temp.setPrice(Double.parseDouble(fView.getCurPeanutBSandwichPrice()));
                    fModel.getCurrentMachine().getVendingMachineSlot(5).fillSlots(temp);
                }

                if(Double.parseDouble(fView.getCurStrawberryJSandwichPrice()) > -1 && fView.getCurStrawberryJSandwichPrice() != null) {
                    temp = fModel.getCurrentMachine().getVendingMachineSlot(6).getsandwichList().get(0);
                    temp.setPrice(Double.parseDouble(fView.getCurStrawberryJSandwichPrice()));
                    fModel.getCurrentMachine().getVendingMachineSlot(6).fillSlots(temp);
                }

                
                if(Double.parseDouble(fView.getCurNutellaSandwichPrice()) > -1 && fView.getCurNutellaSandwichPrice() != null) {
                    temp = fModel.getCurrentMachine().getVendingMachineSlot(7).getsandwichList().get(0);
                    temp.setPrice(Double.parseDouble(fView.getCurNutellaSandwichPrice()));
                    fModel.getCurrentMachine().getVendingMachineSlot(7).fillSlots(temp);
                }
            }
        });
    }

    private void replenishVMMoney()  {
        this.fView.setReplenishVMMoneyListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e)  {
                fView.setShowCurVMMoney(String.valueOf(fModel.getCurrentMachine().getVmMoney().computeTotal()));
                fView.setCur1(String.valueOf(fModel.getCurrentMachine().getVmMoney().getPeso1()));
                fView.setCur5(String.valueOf(fModel.getCurrentMachine().getVmMoney().getPeso5()));
                fView.setCur10(String.valueOf(fModel.getCurrentMachine().getVmMoney().getPeso10()));
                fView.setCur20(String.valueOf(fModel.getCurrentMachine().getVmMoney().getPeso20()));
                fView.setCur50(String.valueOf(fModel.getCurrentMachine().getVmMoney().getPeso50()));
                fView.setCur100(String.valueOf(fModel.getCurrentMachine().getVmMoney().getPeso100()));
                fView.setCur200(String.valueOf(fModel.getCurrentMachine().getVmMoney().getPeso200()));
                fView.setCur500(String.valueOf(fModel.getCurrentMachine().getVmMoney().getPeso500()));
                fView.setCur1000(String.valueOf(fModel.getCurrentMachine().getVmMoney().getPeso1000()));
                fView.displayReplenishMoney();
            }
        }); 

        this.fView.setReplenish1Listener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e)  {
                fModel.getCurrentMachine().getVmMoney().addPeso1(1);
                fView.setCur1(String.valueOf(fModel.getCurrentMachine().getVmMoney().getPeso1()));
                fView.setShowCurVMMoney(String.valueOf(fModel.getCurrentMachine().getVmMoney().computeTotal()));
            }
        });

        this.fView.setReplenish5Listener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e)  {
                fModel.getCurrentMachine().getVmMoney().addPeso5(1);
                fView.setCur5(String.valueOf(fModel.getCurrentMachine().getVmMoney().getPeso5()));
                fView.setShowCurVMMoney(String.valueOf(fModel.getCurrentMachine().getVmMoney().computeTotal()));
            }
        });

        this.fView.setReplenish10Listener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e)  {
                fModel.getCurrentMachine().getVmMoney().addPeso10(1);
                fView.setCur10(String.valueOf(fModel.getCurrentMachine().getVmMoney().getPeso10()));
                fView.setShowCurVMMoney(String.valueOf(fModel.getCurrentMachine().getVmMoney().computeTotal()));
            }
        });

        this.fView.setReplenish20Listener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e)  {
                fModel.getCurrentMachine().getVmMoney().addPeso20(1);
                fView.setCur20(String.valueOf(fModel.getCurrentMachine().getVmMoney().getPeso20()));
                fView.setShowCurVMMoney(String.valueOf(fModel.getCurrentMachine().getVmMoney().computeTotal()));
            }
        });

        this.fView.setReplenish50Listener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e)  {
                fModel.getCurrentMachine().getVmMoney().addPeso50(1);
                fView.setCur50(String.valueOf(fModel.getCurrentMachine().getVmMoney().getPeso50()));
                fView.setShowCurVMMoney(String.valueOf(fModel.getCurrentMachine().getVmMoney().computeTotal()));
            }
        });

        this.fView.setReplenish100Listener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e)  {
                fModel.getCurrentMachine().getVmMoney().addPeso100(1);
                fView.setCur100(String.valueOf(fModel.getCurrentMachine().getVmMoney().getPeso100()));
                fView.setShowCurVMMoney(String.valueOf(fModel.getCurrentMachine().getVmMoney().computeTotal()));
            }
        });

        this.fView.setReplenish200Listener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e)  {
                fModel.getCurrentMachine().getVmMoney().addPeso200(1);
                fView.setCur200(String.valueOf(fModel.getCurrentMachine().getVmMoney().getPeso200()));
                fView.setShowCurVMMoney(String.valueOf(fModel.getCurrentMachine().getVmMoney().computeTotal()));
            }
        });

        this.fView.setReplenish500Listener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e)  {
                fModel.getCurrentMachine().getVmMoney().addPeso500(1);
                fView.setCur500(String.valueOf(fModel.getCurrentMachine().getVmMoney().getPeso500()));
                fView.setShowCurVMMoney(String.valueOf(fModel.getCurrentMachine().getVmMoney().computeTotal()));
            }
        });

        this.fView.setReplenish1000Listener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e)  {
                fModel.getCurrentMachine().getVmMoney().addPeso1000(1);
                fView.setCur1000(String.valueOf(fModel.getCurrentMachine().getVmMoney().getPeso1000()));
                fView.setShowCurVMMoney(String.valueOf(fModel.getCurrentMachine().getVmMoney().computeTotal()));
            }
        });
        
        this.fView.setGoBackFromReplenishMoneyListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e)  {
                fView.displayMaintenanceInterface();
            }
        });
        
    }

    public void transactionHistory(){
        this.fView.setViewTransactionHistory(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e)  {
                String text = "";
                int size = fModel.getCurrentMachine().getHistory().getTransactions().size();
                Transaction transaction;
                Sandwich item;
                for(int i = 0; i < size; i++) {
                    transaction = fModel.getCurrentMachine().getHistory().getTransactions().get(i);
                    item = (Sandwich)transaction.getItem();
                    text += "Transaction #" + String.valueOf(i+1) + "\n\n\nMoney Inputted: P" + String.valueOf(transaction.getPayment()) + 
                    "\nItem Purchased: " + String.valueOf(transaction.getItem().getName()) + " P" + String.valueOf(item.getPrice()) + "\nChange Received: P" +
                    String.valueOf(transaction.getChange()) + "\n\n\n";
                }

                fView.setContainTransactionHistory(text);
                fView.displayVMTransactionHistory();
            }
        });
        this.fView.setViewInventoryHistory(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e)  {
                String text = "";

                if(fModel.getCurrentMachine() instanceof SpecialVendingMachine) {
                    SpecialVendingMachine svm = (SpecialVendingMachine)fModel.getCurrentMachine();
                    svm.getHistory().setFinalStockS(svm);
                    text = "Bread Initial : " + String.valueOf(svm.getHistory().getBreadInitial()) + "\t\tBread Final : " + String.valueOf(svm.getHistory().getBreadFinal());
                    text += "\nHam Initial : " + String.valueOf(svm.getHistory().getHamInitial()) + "\t\tHam Final : " + String.valueOf(svm.getHistory().getHamFinal());
                    text += "\nCheese Initial : " + String.valueOf(svm.getHistory().getCheeseInitial()) + "\tCheese Final : " + String.valueOf(svm.getHistory().getCheeseFinal());
                    text += "\nEgg Initial : " + String.valueOf(svm.getHistory().getEggInitial()) + "\t\tEgg Final : " + String.valueOf(svm.getHistory().getEggFinal());
                    text += "\nChicken Initial : " + String.valueOf(svm.getHistory().getChickenInitial()) + "\tChicken Final : " + String.valueOf(svm.getHistory().getChickenFinal());
                    text += "\nTuna Initial : " + String.valueOf(svm.getHistory().getTunaInitial()) + "\t\tTuna Final : " + String.valueOf(svm.getHistory().getTunaFinal());
                    text += "\nPeanut Butter Initial : " + String.valueOf(svm.getHistory().getPeanutbutterInitial()) + "\tPeanut Butter Final : " + String.valueOf(svm.getHistory().getPeanutbutterFinal());
                    text += "\nStrawberry Jam Initial : " + String.valueOf(svm.getHistory().getStrawberryjamInitial()) + "\tStrawberry Jam Final : " + String.valueOf(svm.getHistory().getStrawberryjamFinal());
                    text += "\nNutella Initial : " + String.valueOf(svm.getHistory().getNutellaInitial()) + "\tNutella Final : " + String.valueOf(svm.getHistory().getNutellaFinal());
                    text += "\nLettuce Initial : " + String.valueOf(svm.getHistory().getLettuceInitial()) + "\tLettuce Final : " + String.valueOf(svm.getHistory().getLettuceFinal());
                    text += "\nTomato Initial : " + String.valueOf(svm.getHistory().getTomatoInitial()) + "\tTomato Final : " + String.valueOf(svm.getHistory().getTomatoFinal());
                    text += "\nPickle Initial : " + String.valueOf(svm.getHistory().getPickleInitial()) + "\t\tPickle Final : " + String.valueOf(svm.getHistory().getPickleFinal());
                } else  {
                    VendingMachine vm = fModel.getCurrentMachine();
                    vm.getHistory().setFinalStockR(vm);
                    text = "Bread Initial : " + String.valueOf(vm.getHistory().getBreadInitial()) + "\t\tBread Final : " + String.valueOf(vm.getHistory().getBreadFinal()) +
                     "\nHam Initial : " + String.valueOf(vm.getHistory().getHamInitial()) + "\t\tHam Final : " + String.valueOf(vm.getHistory().getHamFinal()) +
                     "\nCheese Initial : " + String.valueOf(vm.getHistory().getCheeseInitial()) + "\t\tCheese Final : " + String.valueOf(vm.getHistory().getCheeseFinal()) +
                     "\nEgg Initial : " + String.valueOf(vm.getHistory().getEggInitial()) + "\t\tEgg Final : " + String.valueOf(vm.getHistory().getEggFinal()) +
                     "\nChicken Initial : " + String.valueOf(vm.getHistory().getChickenInitial()) + "\t\tChicken Final : " + String.valueOf(vm.getHistory().getChickenFinal()) +
                     "\nTuna Initial : " + String.valueOf(vm.getHistory().getTunaInitial()) + "\t\tTuna Final : " + String.valueOf(vm.getHistory().getTunaFinal()) +
                     "\nPeanut Butter Initial : " + String.valueOf(vm.getHistory().getPeanutbutterInitial()) + "\t\tPeanut Butter Final : " + String.valueOf(vm.getHistory().getPeanutbutterFinal()) +
                     "\nStrawberry Jam Initial : " + String.valueOf(vm.getHistory().getStrawberryjamInitial()) + "\t\tStrawberry Jam Final : " + String.valueOf(vm.getHistory().getStrawberryjamFinal()) +
                     "\nNutella Initial : " + String.valueOf(vm.getHistory().getNutellaInitial()) + "\t\tNutella Final : " + String.valueOf(vm.getHistory().getNutellaFinal()) +
                     "\nLettuce Initial : " + String.valueOf(vm.getHistory().getLettuceInitial()) + "\t\tLettuce Final : " + String.valueOf(vm.getHistory().getLettuceFinal()) +
                     "\nTomato Initial : " + String.valueOf(vm.getHistory().getTomatoInitial()) + "\t\tTomato Final : " + String.valueOf(vm.getHistory().getTomatoFinal()) +
                     "\nPickle Initial : " + String.valueOf(vm.getHistory().getPickleInitial()) + "\t\tPickle Final : " + String.valueOf(vm.getHistory().getPickleFinal());
                }

                fView.setContainInventoryHistory(text);
                fView.repaint();
                fView.displayVMInventoryHistory();
            }
        });
        this.fView.setGoBackFromTransactionHistory(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e)  {
                fView.displayMaintenanceInterface();
            }
        });
        this.fView.setGoBackFromInventoryHistory(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e)  {
                fView.displayMaintenanceInterface();
            }
        });
    }
    
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


    public void resetMoneyFields()  {
        fView.setQuant1("0");
        fView.setQuant5("0");
        fView.setQuant10("0");
        fView.setQuant20("0");
        fView.setQuant50("0");
        fView.setQuant100("0");
        fView.setQuant200("0");
        fView.setQuant500("0");
        fView.setQuant1000("0");
    }
}
