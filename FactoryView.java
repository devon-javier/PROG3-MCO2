import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.Insets;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.Timer;
import javax.swing.border.LineBorder;

 /**
 * The FactoryView class contains the all the components that makes up the program's GUI. This concerns the different:
 * 
 *      panels (contains and displays the other GUI components),
 *      buttons (interactables that move you to different panels or performs an action when pressed),
 *      labels (provides short titles and descriptions within the program),
 *      text fields (either accepts input or displays output),
 *      text areas (displays large/long output),
 *      image icons (used for background images),
 *      card layout (contains each panel in a single container and calls upon the container number when the panel is used),
 *      gridbagconstraints(assists the use of gridBagLayout in some panels),
 *      and the frame that has been used (JFrame has been extended).
 */

public class FactoryView extends JFrame{
    //panels
    private JPanel buyMainPanel;
    private JPanel buySubPanel1;
    private JPanel buySubPanel2;

    //FACTORY interactables
    private JButton createVM;
    private JButton testVM;
    private JButton regularVM;
    private JButton specialVM;
    private JButton buyItem;
    private JButton accMain;
    private JButton goBack;

    //components for BUY ITEM WINDOW
    private JLabel peso1;
    private JLabel peso5;
    private JLabel peso10;
    private JLabel peso20;
    private JLabel peso50;
    private JLabel peso100;
    private JLabel peso200;
    private JLabel peso500;
    private JLabel peso1000;
    private JButton plus1;
    private JButton plus5;
    private JButton plus10;
    private JButton plus20;
    private JButton plus50;
    private JButton plus100;
    private JButton plus200;
    private JButton plus500;
    private JButton plus1000;
    private JTextField quant1;
    private JTextField quant5;
    private JTextField quant10;
    private JTextField quant20;
    private JTextField quant50;
    private JTextField quant100;
    private JTextField quant200;
    private JTextField quant500;
    private JTextField quant1000;
    private JButton confirmPayment;
    private JButton viewPriceList;
    private JTextField currentAmount;
    private JTextArea containPriceList;

    //COMPONENTS FOR MAINTENANCE MODE WINDOW
     private JButton restockItems;
     private JButton restockSandwich;
     private JButton setItemPrice;
     private JButton collectPayments;
     private JButton collectVMMoney;
     private JButton replenishVMMoney;
     private JButton viewTransactionHistory;
     private JButton viewInventoryHistory;
     private JPanel layoutMaintenance;
     private JButton goBackTestVM;
     private JButton backMaintenanceModeR;
     private JButton backMaintenanceModeS;

     //MAINTENANCE MODE - RESTOCK ITEMS
     private JLabel restockBread;
     private JLabel restockHam;
     private JLabel restockCheese;
     private JLabel restockChicken;
     private JLabel restockTuna;
     private JLabel restockEgg;
     private JLabel restockMayo;
     private JLabel restockPeanutButter;
     private JLabel restockStrawberryJam;
     private JLabel restockNutella;
     private JLabel restockLettuce;
     private JLabel restockTomato;
     private JLabel restockPickle;

     private JTextField breadQuantR;
     private JTextField hamQuantR;
     private JTextField cheeseQuantR;
     private JTextField chickenQuantR;
     private JTextField tunaQuantR;
     private JTextField eggQuantR;
     private JTextField mayoQuantR;
     private JTextField peanutBQuantR;
     private JTextField strawberryJQuantR;
     private JTextField nutellaQuantR;

     private JTextField breadQuantS;
     private JTextField hamQuantS;
     private JTextField cheeseQuantS;
     private JTextField chickenQuantS;
     private JTextField tunaQuantS;
     private JTextField eggQuantS;
     private JTextField mayoQuantS;
     private JTextField peanutBQuantS;
     private JTextField strawberryJQuantS;
     private JTextField nutellaQuantS;
     private JTextField lettuceQuantS;
     private JTextField tomatoQuantS;
     private JTextField pickleQuantS;

     private JButton plusBreadR;
     private JButton plusHamR;
     private JButton plusCheeseR;
     private JButton plusChickenR;
     private JButton plusTunaR;
     private JButton plusEggR;
     private JButton plusMayoR;
     private JButton plusPeanutBR;
     private JButton plusStrawberryJR;
     private JButton plusNutellaR;
     private JButton confirmRestockItemsR;

     private JButton plusBreadS;
     private JButton plusHamS;
     private JButton plusCheeseS;
     private JButton plusChickenS;
     private JButton plusTunaS;
     private JButton plusEggS;
     private JButton plusMayoS;
     private JButton plusPeanutBS;
     private JButton plusStrawberryJS;
     private JButton plusNutellaS;
     private JButton plusLettuceS;
     private JButton plusTomatoS;
     private JButton plusPickleS;
     private JButton confirmRestockItemsS;

     private JPanel layoutRestockItems;

     //MAINTENANCE MODE - RESTOCK SANDWICHES
     private JLabel restockHamSandwich;
     private JLabel restockCheeseSandwich;
     private JLabel restockChickenSandwich;
     private JLabel restockTunaSandwich;
     private JLabel restockEggSandwich;
     private JLabel restockPeanutButterSandwich;
     private JLabel restockStrawberryJamSandwich;
     private JLabel restockNutellaSandwich;

     private JTextField hamSandwichQuant;
     private JTextField cheeseSandwichQuant;
     private JTextField chickenSandwichQuant;
     private JTextField tunaSandwichQuant;
     private JTextField eggSandwichQuant;
     private JTextField peanutBSandwichQuant;
     private JTextField strawberryJSandwichQuant;
     private JTextField nutellaSandwichQuant;

     private JButton plusHamSandwich;
     private JButton plusCheeseSandwich;
     private JButton plusChickenSandwich;
     private JButton plusTunaSandwich;
     private JButton plusEggSandwich;
     private JButton plusPeanutBSandwich;
     private JButton plusStrawberryJSandwich;
     private JButton plusNutellaSandwich;
     private JButton backMaintenanceModeFromSandwich;

     private JPanel layoutRestockSandwiches;

    //MAINTENANCE MODE - SET ITEM PRICE                       
    private JLabel setHamSandwichPrice;
    private JLabel setCheeseSandwichPrice;
    private JLabel setChickenSandwichPrice;
    private JLabel setTunaSandwichPrice;
    private JLabel setEggSandwichPrice;
    private JLabel setPeanutBSandwichPrice;
    private JLabel setStrawberryJSandwichPrice;
    private JLabel setNutellaSandwichPrice;

    private JTextField curHamSandwichPrice;
    private JTextField curCheeseSandwichPrice;
    private JTextField curChickenSandwichPrice;
    private JTextField curTunaSandwichPrice;
    private JTextField curEggSandwichPrice;
    private JTextField curPeanutBSandwichPrice;
    private JTextField curStrawberryJSandwichPrice;
    private JTextField curNutellaSandwichPrice;

    private JButton confirmItemPrice;
    private JButton backMaintenanceModeFromSetPrice;

    private JPanel layoutSetPrice;
    
    //MAINTENANCE MODE - REPLENISH VM MONEY
    private JLabel curVMMoney;
    private JLabel curPeso1;
    private JLabel curPeso5;
    private JLabel curPeso10;
    private JLabel curPeso20;
    private JLabel curPeso50;
    private JLabel curPeso100;
    private JLabel curPeso200;
    private JLabel curPeso500;
    private JLabel curPeso1000;
    private JButton replenish1;
    private JButton replenish5;
    private JButton replenish10;
    private JButton replenish20;
    private JButton replenish50;
    private JButton replenish100;
    private JButton replenish200;
    private JButton replenish500;
    private JButton replenish1000;
    private JTextField showCurVMMoney;
    private JTextField cur1;
    private JTextField cur5;
    private JTextField cur10;
    private JTextField cur20;
    private JTextField cur50;
    private JTextField cur100;
    private JTextField cur200;
    private JTextField cur500;
    private JTextField cur1000;
    private JButton goBackFromReplenish;
    private JPanel layoutReplenishMoney;

    //COMPONENTS FOR REGULAR VM WINDOW
    private JButton slot1R;
    private JButton slot2R;
    private JButton slot3R;
    private JButton slot4R;
    private JButton slot5R;
    private JButton slot6R;
    private JButton slot7R;
    private JButton slot8R;
    private JButton cancelTransactionR;
    private JButton viewItemInfoR;
    private JOptionPane selectItemRVM;  //when an item is selected
    private JPanel layoutRVM;
    private JTextArea containItemPriceR;

    private JPanel layoutViewItemInfoR;
    private JLabel displayViewItemInfoR;
    private JButton goBackFromViewInfoR;

    private JTextField hamSandAvailabilityR;
    private JTextField cheeseSandAvailabilityR;
    private JTextField chickenSandAvailabilityR;
    private JTextField tunaSandAvailabilityR;
    private JTextField eggSandAvailabilityR;
    private JTextField peanutBSandAvailabilityR;
    private JTextField strawberryJSandAvailabilityR;
    private JTextField nutellaSandAvailabilityR;

    //COMPONENTS FOR SPECIAL VM WINDOW
    private JButton slot1S;
    private JButton slot2S;
    private JButton slot3S;
    private JButton slot4S;
    private JButton slot5S;
    private JButton slot6S;
    private JButton slot7S;
    private JButton slot8S;
    private JButton cancelTransactionS;
    private JButton viewItemInfoS;
    private JOptionPane selectItemSVM;  //when an item is selected
    private JPanel layoutSVM;

    private JPanel layoutViewItemInfoS;
    private JLabel displayViewItemInfoS;
    private JPanel layoutViewAdditionalItemInfoS;
    private JLabel displayViewAdditionaItemlInfoS;
    private JButton viewAdditionalInfo;
    private JButton goBackFromViewAdditionalItemInfoS;

    private JTextField hamSandAvailabilityS;
    private JTextField cheeseSandAvailabilityS;
    private JTextField chickenSandAvailabilityS;
    private JTextField tunaSandAvailabilityS;
    private JTextField eggSandAvailabilityS;
    private JTextField peanutBSandAvailabilityS;
    private JTextField strawberryJSandAvailabilityS;
    private JTextField nutellaSandAvailabilityS;

    private JTextField hamAddAvailability;
    private JTextField cheeseAddAvailability;
    private JTextField chickenAddAvailability;
    private JTextField tunaAddAvailability;
    private JTextField eggAddAvailability;
    private JTextField peanutBAddAvailability;
    private JTextField strawberryJAddAvailability;
    private JTextField nutellaAddAvailability;
    private JTextField mayoAddAvailability;
    private JTextField tomatoAddAvailability;
    private JTextField lettuceAddAvailability;
    private JTextField pickleAddAvailability;

    //COMPONENTS FOR SVM CUSTOMIZE ITEM
    private JLabel displayCustomizeItemSVM;
    private JPanel layoutCustomizeItemSVM;

    private JLabel custLabelHam;
    private JLabel custLabelCheese;
    private JLabel custLabelChicken;
    private JLabel custLabelTuna;
    private JLabel custLabelEgg;
    private JLabel custLabelMayo;
    private JLabel custLabelPeanutB;
    private JLabel custLabelStrawberryJ;
    private JLabel custLabelNutella;
    private JLabel custLabelLettuce;
    private JLabel custLabelTomato;
    private JLabel custLabelPickle;

    private JTextField custTextHam;
    private JTextField custTextCheese;
    private JTextField custTextChicken;
    private JTextField custTextTuna;
    private JTextField custTextEgg;
    private JTextField custTextMayo;
    private JTextField custTextPeanutB;
    private JTextField custTextStrawberryJ;
    private JTextField custTextNutella;
    private JTextField custTextLettuce;
    private JTextField custTextTomato;
    private JTextField custTextPickle;

    private JButton custPlusHam;
    private JButton custPlusCheese;
    private JButton custPlusChicken;
    private JButton custPlusTuna;
    private JButton custPlusEgg;
    private JButton custPlusMayo;
    private JButton custPlusPeanutB;
    private JButton custPlusStrawberryJ;
    private JButton custPlusNutella;
    private JButton custPlusLettuce;
    private JButton custPlusTomato;
    private JButton custPlusPickle;
    private JButton custPurchase;

    //COMPONENTS FOR SVM ITEM PREPARATION
    private JLabel displayItemPreparation;
    private JPanel layoutItemPreparation;
    private JButton finishItemPreparation;
    private JTextField containItemPreparation1;
    private JTextField containItemPreparation2;
    private JTextField containItemPreparation3;
    private JTextField containItemPreparation4;
    private JTextField containItemPreparation5;
    private JTextField containItemPreparation6;

    //COMPONENTS FOR DISPENSE ITEM AND CHANGE WINDOW
    private JLabel displayDispenseItemAndChange;
    private JPanel layoutDispenseItemAndChange;
    private JPanel layoutDispenseItemSubPanel1;
    private JPanel layoutDispenseItemSubPanel2;
    private JPanel layoutDispenseItemSubPanel3;

    private JLabel receiptTransaction;
    private JTextArea showReceiptTransaction;
    private JLabel receiptProductPurchased;
    private JTextArea showReceiptProductPurchased;
    private JLabel receiptProducedChange;
    private JTextField showReceiptProducedChange;

    private JButton receiptGoBackToMenu;

    //COMPONENTS FOR VIEW TRANSACTION HISTORY
    private JLabel displayViewTransactionHistory;
    private JPanel layoutDisplayViewTransactionHistory;
    private JTextArea containTransactionHistory;
    private JButton goBackFromTransactionHistory;

    //COMPONENTS FOR VIEW ITEM INVENTORY
    private JLabel displayViewInventoryHistory;
    private JPanel layoutDisplayInventoryHistory;
    private JTextArea containInventoryHistory;
    private JButton goBackFromInventoryHistory;

    //misc.
    private GridBagConstraints gbc;
    private CardLayout cl;          //sets the card layout
    private Container container;    
    private GridBagConstraints gbc2;
    private GridBagConstraints gbc3;
    private JButton filler1;        //for pure aesthetic
    private JButton filler2;        //for pure aesthetic
    private JButton filler3;        //for pure aesthetic

    //for background image
    private JLabel displayField;
    private ImageIcon background_image;
    private JLabel displayFieldCreate;
    private ImageIcon background_image_create;
    private JLabel displayFieldTest;
    private ImageIcon background_image_test;
    private JLabel displayFieldBuy;
    private ImageIcon background_image_buy;
    private JLabel displayFieldRVM;
    private ImageIcon background_image_RVM;
    private JLabel displayFieldSVM;
    private ImageIcon background_image_SVM;
    private JLabel displayFieldMaintenance;
    private ImageIcon background_image_Maintenance;
    private JLabel displayBlank1;
    private JLabel displayBlank2;
    private JLabel displayBlank3;
    private JLabel displayBlank4;
    private JLabel displayBlank5;
    private ImageIcon background_image_plain;

    /**
     * Constructs an instance of FactoryView.
     * 
     *      Sets the card layout, contains panel 1 in the card layout that displays the factory main menu.
     *      Contains the interactables for panel 2, which displays buttons for creating a Regular or Special vending machine.
     *      Contains JFrame configurations.
     *      Holds all added "build" methods under the FactoryView class to assist the program in properly displaying panels.
     */
    public FactoryView(){
        super("CCPROG3 MCO2");

        //misc.
        gbc = new GridBagConstraints();
        gbc.insets = new Insets(10, 0, 10, 0);
        container = getContentPane();
        gbc2 = new GridBagConstraints();
        gbc2.insets = new Insets(10, 5, 10, 5);
        filler1 = new JButton("");
        filler1.setContentAreaFilled(false);
        filler1.setFocusPainted(false);
        filler1.setBorderPainted(false);
        filler2 = new JButton("");
        filler2.setContentAreaFilled(false);
        filler2.setFocusPainted(false);
        filler2.setBorderPainted(false);
        filler3 = new JButton("");
        filler3.setContentAreaFilled(false);
        filler3.setFocusPainted(false);
        filler3.setBorderPainted(false);
        
        //panels
        buyMainPanel = new JPanel();
        buyMainPanel.setLayout(new GridLayout(2, 1, 10, 25));
        buySubPanel1 = new JPanel();
        buySubPanel1.setLayout(new GridLayout(9, 3, 5, 5));
        buySubPanel2 = new JPanel();
        buySubPanel2.setLayout(new FlowLayout(FlowLayout.CENTER, 50, 40));
        cl = new CardLayout();
        container.setLayout(cl);

        background_image = new ImageIcon("phonemenu.png");
        Image img = background_image.getImage();
        Image temp_img = img.getScaledInstance(550, 700, Image.SCALE_SMOOTH);
        background_image = new ImageIcon(temp_img);
        displayField = new JLabel("", background_image, JLabel.CENTER);
        displayField.setLayout(new GridBagLayout());  
        
        background_image_create = new ImageIcon("phonecreate.png");
        Image img1 = background_image_create.getImage();
        Image temp_img1 = img1.getScaledInstance(550, 700, Image.SCALE_SMOOTH);
        background_image_create = new ImageIcon(temp_img1);
        displayFieldCreate = new JLabel("", background_image_create, JLabel.CENTER);
        displayFieldCreate.setLayout(new GridBagLayout());

        //buttons + button adds -------------------------------------------- (FOR MAIN FACTORY MENU)
        createVM = new JButton("Create a Vending Machine");
        createVM.setOpaque(false);
        createVM.setFocusPainted(false);
        createVM.setBorder(BorderFactory.createEtchedBorder(0));
        createVM.setPreferredSize(new Dimension(220, 50));
        createVM.setFont(new Font("TimesRoman", Font.BOLD, 16));
        createVM.setForeground(Color.decode("#B47EDE"));
        gbc.gridy = 0;
        gbc.gridx = 0;
        displayField.add(createVM, gbc);

        testVM = new JButton("Test a Vending Machine");
        testVM.setOpaque(false);
        testVM.setFocusPainted(false);
        testVM.setBorder(BorderFactory.createEtchedBorder(0));
        testVM.setPreferredSize(new Dimension(220, 50));
        testVM.setFont(new Font("TimesRoman", Font.BOLD, 16));
        testVM.setForeground(Color.decode("#B47EDE"));
        gbc.gridy = 1;
        gbc.gridx = 0;
        displayField.add(testVM, gbc);

        //buttons + button adds -------------------------------------------- (FOR CREATING VENDING MACHINES)
        regularVM = new JButton("Regular");
        regularVM.setOpaque(false);
        regularVM.setFocusPainted(false);
        regularVM.setBorder(BorderFactory.createEtchedBorder(0));
        regularVM.setPreferredSize(new Dimension(150, 50));
        regularVM.setFont(new Font("TimesRoman", Font.BOLD, 20));
        regularVM.setForeground(Color.decode("#B47EDE"));
        gbc.gridy = 0;
        gbc.gridx = 0;
        displayFieldCreate.add(regularVM, gbc);

        specialVM = new JButton("Special");
        specialVM.setOpaque(false);
        specialVM.setFocusPainted(false);
        specialVM.setBorder(BorderFactory.createEtchedBorder(0));
        specialVM.setPreferredSize(new Dimension(150, 50));
        specialVM.setFont(new Font("TimesRoman", Font.BOLD, 20));
        specialVM.setForeground(Color.decode("#B47EDE"));
        gbc.gridy = 1;
        gbc.gridx = 0;
        displayFieldCreate.add(specialVM, gbc);
        
        container.add(displayField, "1");
        container.add(displayFieldCreate, "2");
        cl.show(container, "1");

        //frame config
        this.setVisible(true);
        this.setSize(550, 700);
        this.setResizable(false);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);

        //added methods
        this.buildTestVM();
        this.buildBuyItem();
        this.buildRegularVM();
        this.buildSpecialVM();
        this.buildMaintenanceMode();
        this.buildRestockItemsRVM();
        this.buildRestockItemsSVM();
        this.buildRestockSandwich();
        this.buildSetItemPrice(); 
        this.buildReplenishMoney();
        this.buildViewTransactionHistory();
        this.buildViewInventoryHistory();
        this.buildViewItemInfoR();
        this.buildViewItemInfoS();
        this.buildViewAdditionalItemsS();
        this.buildCustomizeItemSVM();
        this.buildDispenseItemAndChange();
        this.buildItemPreparationSVM();
    }

    //display interface methods

    /**
     * Displays the 1st panel inside the card layout's container. This contains the starting interface where
     * the user can choose to create a vending machine or test a vending machine.
     */
     public void displayFactoryView()  {
        cl.show(container, "1");
     }

    /**
     * Displays the 2nd panel inside the card layout's container. This contains the interface for creating
     * a Regular or Special vending machine.
     */
    public void displayCreateVM() {
        cl.show(container, "2");
    }

    /**
     * Displays the 3rd panel inside the card layout's container. This contains the interface for testing
     * the most recently created vending machine.
     */
    public void displayTestVM(){
        cl.show(container, "3");
     }

     /**
     * Displays the 4th panel inside the card layout's container. This contains the interface for when
     * the user chooses to buy an item.
     */
     public void displayBuyItemInterface(){
        cl.show(container, "4");
     }

     /**
     * Displays the 5th panel inside the card layout's container. This contains the interface for purchasing an
     * item and viewing item information under the Regular vending machine.
     */
     public void displayRVMInterface(){
        cl.show(container, "5");
     }

     /**
     * Displays the 6th panel inside the card layout's container. This contains the interface for purchasing an
     * item and viewing item information under the Special vending machine.
     */
     public void displaySVMInterface(){
        cl.show(container, "6");
     }

     /**
     * Displays the 7th panel inside the card layout's container. This contains the interface for when
     * the user accesses maintenance mode.
     */
     public void displayMaintenanceInterface(){
        cl.show(container, "7");
     }

     /**
     * Displays the 8th panel inside the card layout's container. This contains the interface for
     * restocking items (individual ingredients) under the Regular vending machine.
     */
     public void displayRestockItemRVM(){
        cl.show(container, "8");
     }

     /**
     * Displays the 9th panel inside the card layout's container. This contains the interface for
     * restocking items (individual ingredients) under the Special vending machine.
     */
     public void displayRestockItemSVM(){
        cl.show(container, "9");
     }

    /**
     * Displays the 10th panel inside the card layout's container. This contains the interface for
     * restocking sandwiches under the Regular or Special vending machine (depending on which variant is
     * the most recently created vending machine).
     */
     public void displayRestockSandwiches(){
        cl.show(container, "10");
     }

    /**
     * Displays the 11th panel inside the card layout's container. This contains the interface for
     * setting item prices (individual ingredients) under the Regular vending machine.
     */
     public void displaySetItemPriceRVM(){      
        cl.show(container, "11");
     }

     /**
     * Displays the 12th panel inside the card layout's container. This contains the interface for
     * replenishing the machine's money (used for producing change) under the Regular or Special vending machine
     * (depending on which variant is the most recently created vending machine).
     */
     public void displayReplenishMoney(){
        cl.show(container, "12");
     }

     /**
     * Displays the 13th panel inside the card layout's container. This contains the interface for
     * viewing the items' additional information (calories and availability),
     * under the Regular vending machine, when purchasing a product.
     */
     public void displayViewItemInfoR(){
        cl.show(container, "13");
     }

     /**
     * Displays the 16th panel inside the card layout's container. This contains the interface for
     * viewing the items' additional information (calories and availability),
     * under the Special vending machine, when purchasing a product.
     */
     public void displayViewItemInfoS(){
        cl.show(container, "16");
     }

     /**
     * Displays the 14th panel inside the card layout's container. This contains the interface for
     * when the user chooses to customize their chosen item under the Special vending machine.
     */
     public void displayCustomizeItemsSVMInterface(){
        cl.show(container, "14");
     }

    /**
     * Displays the 15th panel inside the card layout's container. This contains the interface for
     * the receipt produced when the user purchases an item under the Regular or Special
     * vending machine (depending on which variant is the most recently created vending machine).
     */
     public void displayReceiptOfPurchased(){
        cl.show(container, "15");
     }

     /**
     * Displays the 17th panel inside the card layout's container. This contains the interface for
     * viewing additional items (what can be added to customization of product) under the Special vending machine.
     */
     public void displayViewAddtionalItemsS(){
        cl.show(container, "17");
     }

     /**
     * Displays the 18th panel inside the card layout's container. This contains the interface for
     * the item preparation when the user chooses to customize their item under the Special vending machine.
     */
     public void displayViewItemPreparation(){
        cl.show(container, "18");
     }

     /**
     * Displays the 19th panel inside the card layout's container. This contains the interface for
     * viewing the transaction history (transaction number, amount of money received from buyer, change dispensed)
     * that has been stored in the Regular or Special vending machine (depending on which variant is the most recently created vending machine).
     */
     public void displayVMTransactionHistory(){
        cl.show(container, "19");
     }

     /**
     * Displays the 20th panel inside the card layout's container. This contains the interface for
     * viewing the inventory history (initial inventory, inventory after a transaction)
     * that has been stored in the Regular or Special vending machine (depending on which variant is the most recently created vending machine).
     */
     public void displayVMInventoryHistory(){
        cl.show(container, "20");
     }


    //build methods

    /**
     * Contains the contents of the panel to test a vending machine, stored in container 3.
     * Contains buttons to buy an item, access maintenance mode, and go back to the factory menu interface.
     */
    public void buildTestVM()   {
        background_image_test = new ImageIcon("bgtest.png");
        Image img2 = background_image_test.getImage();
        Image temp_img2 = img2.getScaledInstance(550, 700, Image.SCALE_SMOOTH);
        background_image_test = new ImageIcon(temp_img2);
        displayFieldTest = new JLabel("", background_image_test, JLabel.CENTER);
        displayFieldTest.setLayout(new GridBagLayout());

        gbc3 = new GridBagConstraints();
        gbc3.insets = new Insets(8, 5, 20, 5);

        buyItem = new JButton("Buy Item");
        buyItem.setPreferredSize(new Dimension(170, 65));
        buyItem.setForeground(Color.decode("#6513B2"));
        buyItem.setFont(new Font("TimesRoman", Font.BOLD, 23));
        buyItem.setForeground(Color.WHITE);
        buyItem.setOpaque(false);
        buyItem.setContentAreaFilled(false);
        buyItem.setFocusPainted(false);
        buyItem.setBorderPainted(true);
        gbc3.gridx = 0;
        gbc3.gridy = 0;
        displayFieldTest.add(buyItem, gbc3);

        accMain = new JButton("Maintenace Mode");
        accMain.setPreferredSize(new Dimension(170, 50));
        accMain.setForeground(Color.decode("#6513B2"));
        accMain.setFont(new Font("TimesRoman", Font.BOLD, 17));
        accMain.setForeground(Color.WHITE);
        accMain.setOpaque(false);
        accMain.setContentAreaFilled(false);
        accMain.setFocusPainted(false);
        accMain.setBorderPainted(true);
        gbc3.gridx = 0;
        gbc3.gridy = 1;
        displayFieldTest.add(accMain, gbc3);

        goBack = new JButton("Go Back");
        goBack.setPreferredSize(new Dimension(170, 50));
        goBack.setForeground(Color.decode("#6513B2"));
        goBack.setFont(new Font("TimesRoman", Font.BOLD, 20));
        goBack.setForeground(Color.WHITE);
        goBack.setOpaque(false);
        goBack.setContentAreaFilled(false);
        goBack.setFocusPainted(false);
        goBack.setBorderPainted(true);
        gbc3.gridx = 0;
        gbc3.gridy = 2;
        displayFieldTest.add(goBack, gbc3);

        container.add(displayFieldTest, "3");
    }

    /**
     * Contains the contents of the panel to insert money in the vending machine, stored in container 4.
     * Contains interactables to insert money and view the items price list.
     */
    public void buildBuyItem(){
        //interface for BUY ITEM
        background_image_buy = new ImageIcon("moneymenu.png");
        Image img3 = background_image_buy.getImage();
        Image temp_img3 = img3.getScaledInstance(550, 700, Image.SCALE_SMOOTH);
        background_image_buy = new ImageIcon(temp_img3);
        displayFieldBuy = new JLabel("", background_image_buy, JLabel.CENTER);
        displayFieldBuy.setLayout(new GridBagLayout());

        peso1 = new JLabel("insert 1:", SwingConstants.CENTER);
        peso5 = new JLabel("insert 5:", SwingConstants.CENTER);
        peso10 = new JLabel(" insert 10:", SwingConstants.CENTER);
        peso20 = new JLabel(" insert 20:", SwingConstants.CENTER);
        peso50 = new JLabel(" insert 50:", SwingConstants.CENTER);
        peso100 = new JLabel("   insert 100:", SwingConstants.CENTER);
        peso200 = new JLabel("   insert 200:", SwingConstants.CENTER);
        peso500 = new JLabel("   insert 500:", SwingConstants.CENTER);
        peso1000 = new JLabel("    insert 1000:", SwingConstants.CENTER);

        plus1 = new JButton("+");
        plus5 = new JButton("+");
        plus10 = new JButton("+");
        plus20 = new JButton("+");
        plus50 = new JButton("+");
        plus100 = new JButton("+");
        plus200 = new JButton("+");
        plus500 = new JButton("+");
        plus1000 = new JButton("+");

        quant1 = new JTextField("0");
        quant1.setHorizontalAlignment(JTextField.CENTER);
        quant5 = new JTextField("0");
        quant5.setHorizontalAlignment(JTextField.CENTER);
        quant10 = new JTextField("0");
        quant10.setHorizontalAlignment(JTextField.CENTER);
        quant20 = new JTextField("0");
        quant20.setHorizontalAlignment(JTextField.CENTER);
        quant50 = new JTextField("0");
        quant50.setHorizontalAlignment(JTextField.CENTER);
        quant100 = new JTextField("0");
        quant100.setHorizontalAlignment(JTextField.CENTER);
        quant200 = new JTextField("0");
        quant200.setHorizontalAlignment(JTextField.CENTER);
        quant500 = new JTextField("0");
        quant500.setHorizontalAlignment(JTextField.CENTER);
        quant1000 = new JTextField("0");
        quant1000.setHorizontalAlignment(JTextField.CENTER);

        quant1.setEditable(false);
        quant5.setEditable(false);
        quant10.setEditable(false);
        quant20.setEditable(false);
        quant50.setEditable(false);
        quant100.setEditable(false);
        quant200.setEditable(false);
        quant500.setEditable(false);
        quant1000.setEditable(false);

        buySubPanel1.add(peso1);
        buySubPanel1.add(quant1);
        buySubPanel1.add(plus1);
        buySubPanel1.add(peso5);
        
        buySubPanel1.add(quant5);
        buySubPanel1.add(plus5);
        buySubPanel1.add(peso10);
       
        buySubPanel1.add(quant10);
        buySubPanel1.add(plus10);
        buySubPanel1.add(peso20);
        
        buySubPanel1.add(quant20);
        buySubPanel1.add(plus20);
        buySubPanel1.add(peso50);
        
        buySubPanel1.add(quant50);
        buySubPanel1.add(plus50);
        buySubPanel1.add(peso100);
        
        buySubPanel1.add(quant100);
        buySubPanel1.add(plus100);
        buySubPanel1.add(peso200);
        
        buySubPanel1.add(quant200);
        buySubPanel1.add(plus200);
        buySubPanel1.add(peso500);
        
        buySubPanel1.add(quant500);
        buySubPanel1.add(plus500);
        buySubPanel1.add(peso1000);
        
        buySubPanel1.add(quant1000);
        buySubPanel1.add(plus1000);

        currentAmount = new JTextField();
        currentAmount.setHorizontalAlignment(JTextField.CENTER);
        currentAmount.setBorder(javax.swing.BorderFactory.createEmptyBorder());
        currentAmount.setEditable(false);
        currentAmount.setOpaque(false);
        currentAmount.setPreferredSize(new Dimension(300, 100));
        Font font = new Font(currentAmount.getFont().getName(), currentAmount.getFont().getSize(), 16);
        currentAmount.setFont(font);
        confirmPayment = new JButton("Confirm");
        viewPriceList = new JButton("View Price List");

        buySubPanel2.add(confirmPayment);
        buySubPanel2.add(viewPriceList);
        buySubPanel2.add(currentAmount);

        buySubPanel1.setOpaque(false);
        buySubPanel2.setOpaque(false);
        buyMainPanel.setOpaque(false);

        buyMainPanel.add(buySubPanel1);
        buyMainPanel.add(buySubPanel2);
        displayFieldBuy.add(buyMainPanel);

        container.add(displayFieldBuy, "4");
    }

    /**
     * Contains the contents of the panel to view item info(calories and availability) under the Regular vending machine,
     * stored in container 13. Contains a button to go back to the item select interface.
     */
    public void buildViewItemInfoR(){
        background_image_plain = new ImageIcon("viewiteminfomenu.png");
        Image img6 = background_image_plain.getImage();
        Image temp_img6 = img6.getScaledInstance(550, 700, Image.SCALE_SMOOTH);
        background_image_plain = new ImageIcon(temp_img6);
        displayViewItemInfoR = new JLabel("", background_image_plain, JLabel.CENTER);
        displayViewItemInfoR.setLayout(new GridBagLayout());
        layoutViewItemInfoR = new JPanel(new GridLayout(9, 1, 10, 30));

        hamSandAvailabilityR = new JTextField();
        hamSandAvailabilityR.setHorizontalAlignment(JTextField.CENTER);
        cheeseSandAvailabilityR = new JTextField();
        cheeseSandAvailabilityR.setHorizontalAlignment(JTextField.CENTER);
        chickenSandAvailabilityR = new JTextField();
        chickenSandAvailabilityR.setHorizontalAlignment(JTextField.CENTER);
        tunaSandAvailabilityR = new JTextField();
        tunaSandAvailabilityR.setHorizontalAlignment(JTextField.CENTER);
        eggSandAvailabilityR = new JTextField();
        eggSandAvailabilityR.setHorizontalAlignment(JTextField.CENTER);
        peanutBSandAvailabilityR = new JTextField();
        peanutBSandAvailabilityR.setHorizontalAlignment(JTextField.CENTER);
        strawberryJSandAvailabilityR = new JTextField();
        strawberryJSandAvailabilityR.setHorizontalAlignment(JTextField.CENTER);
        nutellaSandAvailabilityR = new JTextField();
        nutellaSandAvailabilityR.setHorizontalAlignment(JTextField.CENTER);

        goBackFromViewInfoR = new JButton("Go Back");

        layoutViewItemInfoR.add(hamSandAvailabilityR);
        layoutViewItemInfoR.add(cheeseSandAvailabilityR);
        layoutViewItemInfoR.add(chickenSandAvailabilityR);
        layoutViewItemInfoR.add(tunaSandAvailabilityR);
        layoutViewItemInfoR.add(eggSandAvailabilityR);
        layoutViewItemInfoR.add(peanutBSandAvailabilityR);
        layoutViewItemInfoR.add(strawberryJSandAvailabilityR);
        layoutViewItemInfoR.add(nutellaSandAvailabilityR);
        layoutViewItemInfoR.add(goBackFromViewInfoR);
        layoutViewItemInfoR.setOpaque(false);

        displayViewItemInfoR.add(layoutViewItemInfoR);

        container.add(displayViewItemInfoR, "13");
     }

     /**
     * Contains the contents of the panel to view item info(calories and availability) under the Special vending machine,
     * stored in container 16. Contains a button to view additional item info(additional ingredients for customization).
     */
     public void buildViewItemInfoS(){
        background_image_plain = new ImageIcon("viewiteminfomenu.png");
        Image img6 = background_image_plain.getImage();
        Image temp_img6 = img6.getScaledInstance(550, 700, Image.SCALE_SMOOTH);
        background_image_plain = new ImageIcon(temp_img6);
        displayViewItemInfoS = new JLabel("", background_image_plain, JLabel.CENTER);
        displayViewItemInfoS.setLayout(new GridBagLayout());
        layoutViewItemInfoS = new JPanel(new GridLayout(9, 1, 10, 30));

        hamSandAvailabilityS = new JTextField();
        hamSandAvailabilityS.setHorizontalAlignment(JTextField.CENTER);
        cheeseSandAvailabilityS = new JTextField();
        cheeseSandAvailabilityS.setHorizontalAlignment(JTextField.CENTER);
        chickenSandAvailabilityS = new JTextField();
        chickenSandAvailabilityS.setHorizontalAlignment(JTextField.CENTER);
        tunaSandAvailabilityS = new JTextField();
        tunaSandAvailabilityS.setHorizontalAlignment(JTextField.CENTER);
        eggSandAvailabilityS = new JTextField();
        eggSandAvailabilityS.setHorizontalAlignment(JTextField.CENTER);
        peanutBSandAvailabilityS = new JTextField();
        peanutBSandAvailabilityS.setHorizontalAlignment(JTextField.CENTER);
        strawberryJSandAvailabilityS = new JTextField();
        strawberryJSandAvailabilityS.setHorizontalAlignment(JTextField.CENTER);
        nutellaSandAvailabilityS = new JTextField();
        nutellaSandAvailabilityS.setHorizontalAlignment(JTextField.CENTER);
        mayoAddAvailability = new JTextField();
        mayoAddAvailability.setHorizontalAlignment(JTextField.CENTER);
        lettuceAddAvailability = new JTextField();
        lettuceAddAvailability.setHorizontalAlignment(JTextField.CENTER);
        tomatoAddAvailability = new JTextField();
        tomatoAddAvailability.setHorizontalAlignment(JTextField.CENTER);
        pickleAddAvailability = new JTextField();
        pickleAddAvailability.setHorizontalAlignment(JTextField.CENTER);

        viewAdditionalInfo = new JButton("See More");

        layoutViewItemInfoS.add(hamSandAvailabilityS);
        layoutViewItemInfoS.add(cheeseSandAvailabilityS);
        layoutViewItemInfoS.add(chickenSandAvailabilityS);
        layoutViewItemInfoS.add(tunaSandAvailabilityS);
        layoutViewItemInfoS.add(eggSandAvailabilityS);
        layoutViewItemInfoS.add(peanutBSandAvailabilityS);
        layoutViewItemInfoS.add(strawberryJSandAvailabilityS);
        layoutViewItemInfoS.add(nutellaSandAvailabilityS);
        layoutViewItemInfoS.add(viewAdditionalInfo);
        layoutViewItemInfoS.setOpaque(false);

        displayViewItemInfoS.add(layoutViewItemInfoS);

        container.add(displayViewItemInfoS, "16");
     }

     /**
     * Contains the contents of the panel to view additional item info(calories and availability) of customizable ingredients
     * under the Special vending machine, stored in container 17. Contains a button to go back to the item select interface.
     */
     public void buildViewAdditionalItemsS(){
        background_image_plain = new ImageIcon("viewadditionalitemmenu.png");
        Image img6 = background_image_plain.getImage();
        Image temp_img6 = img6.getScaledInstance(550, 700, Image.SCALE_SMOOTH);
        background_image_plain = new ImageIcon(temp_img6);
        displayViewAdditionaItemlInfoS = new JLabel("", background_image_plain, JLabel.CENTER);
        displayViewAdditionaItemlInfoS.setLayout(new GridBagLayout());
        layoutViewAdditionalItemInfoS = new JPanel(new GridLayout(9, 1, 10, 30));

        layoutViewAdditionalItemInfoS.setOpaque(false);

        hamAddAvailability = new JTextField();
        hamAddAvailability.setHorizontalAlignment(JTextField.CENTER);
        cheeseAddAvailability = new JTextField();
        cheeseAddAvailability.setHorizontalAlignment(JTextField.CENTER);
        chickenAddAvailability = new JTextField();
        chickenAddAvailability.setHorizontalAlignment(JTextField.CENTER);
        tunaAddAvailability = new JTextField();
        tunaAddAvailability.setHorizontalAlignment(JTextField.CENTER);
        eggAddAvailability = new JTextField();
        eggAddAvailability.setHorizontalAlignment(JTextField.CENTER);
        mayoAddAvailability = new JTextField();
        mayoAddAvailability.setHorizontalAlignment(JTextField.CENTER);
        tomatoAddAvailability = new JTextField();
        tomatoAddAvailability.setHorizontalAlignment(JTextField.CENTER);
        lettuceAddAvailability = new JTextField();
        lettuceAddAvailability.setHorizontalAlignment(JTextField.CENTER);
        pickleAddAvailability = new JTextField();
        pickleAddAvailability.setHorizontalAlignment(JTextField.CENTER);
        peanutBAddAvailability = new JTextField();
        peanutBAddAvailability.setHorizontalAlignment(JTextField.CENTER);
        strawberryJAddAvailability = new JTextField();
        strawberryJAddAvailability.setHorizontalAlignment(JTextField.CENTER);
        nutellaAddAvailability = new JTextField();
        nutellaAddAvailability.setHorizontalAlignment(JTextField.CENTER);

        goBackFromViewAdditionalItemInfoS = new JButton("Go Back");

        layoutViewAdditionalItemInfoS.add(hamAddAvailability);
        layoutViewAdditionalItemInfoS.add(cheeseAddAvailability);
        layoutViewAdditionalItemInfoS.add(chickenAddAvailability);
        layoutViewAdditionalItemInfoS.add(tunaAddAvailability);
        layoutViewAdditionalItemInfoS.add(eggAddAvailability);
        layoutViewAdditionalItemInfoS.add(mayoAddAvailability);
        layoutViewAdditionalItemInfoS.add(tomatoAddAvailability);
        layoutViewAdditionalItemInfoS.add(lettuceAddAvailability);
        layoutViewAdditionalItemInfoS.add(pickleAddAvailability);
        layoutViewAdditionalItemInfoS.add(peanutBAddAvailability);
        layoutViewAdditionalItemInfoS.add(strawberryJAddAvailability);
        layoutViewAdditionalItemInfoS.add(nutellaAddAvailability);
        layoutViewAdditionalItemInfoS.add(goBackFromViewAdditionalItemInfoS);

        displayViewAdditionaItemlInfoS.add(layoutViewAdditionalItemInfoS);

        container.add(displayViewAdditionaItemlInfoS, "17");

     }

     /**
     * Contains the contents of the panel to view the select item interface under the Regular vending machine, stored in container 5.
     * Contains interactables(buttons) to select a product and purchase, view item info, and cancel transaction.
     */
     public void buildRegularVM(){

        background_image_RVM = new ImageIcon("selectitem.png");
        Image img4 = background_image_RVM.getImage();
        Image temp_img4 = img4.getScaledInstance(550, 700, Image.SCALE_SMOOTH);
        background_image_RVM = new ImageIcon(temp_img4);
        displayFieldRVM = new JLabel("", background_image_RVM, JLabel.CENTER);
        displayFieldRVM.setLayout(new GridBagLayout());
        layoutRVM = new JPanel(new GridLayout(4, 3, 10, 10));

        layoutRVM.setOpaque(false);

        slot1R = new JButton(""); // insert icon
        slot2R = new JButton("");
        slot3R = new JButton("");
        slot4R = new JButton("");
        slot5R = new JButton("");
        slot6R = new JButton("");
        slot7R = new JButton("");
        slot8R = new JButton("");
        viewItemInfoR = new JButton("");
        cancelTransactionR = new JButton("");

        //setting the size of just one button will set the size for all due to gridlayout
        slot1R.setPreferredSize(new Dimension(80, 80));

        slot1R.setContentAreaFilled(false);
        slot1R.setFocusPainted(false);
        slot1R.setBorderPainted(false);
        slot2R.setContentAreaFilled(false);
        slot2R.setFocusPainted(false);
        slot2R.setBorderPainted(false);
        slot3R.setContentAreaFilled(false);
        slot3R.setFocusPainted(false);
        slot3R.setBorderPainted(false);
        slot4R.setContentAreaFilled(false);
        slot4R.setFocusPainted(false);
        slot4R.setBorderPainted(false);
        slot5R.setContentAreaFilled(false);
        slot5R.setFocusPainted(false);
        slot5R.setBorderPainted(false);
        slot6R.setContentAreaFilled(false);
        slot6R.setFocusPainted(false);
        slot6R.setBorderPainted(false);
        slot7R.setContentAreaFilled(false);
        slot7R.setFocusPainted(false);
        slot7R.setBorderPainted(false);
        slot8R.setContentAreaFilled(false);
        slot8R.setFocusPainted(false);
        slot8R.setBorderPainted(false);
        viewItemInfoR.setContentAreaFilled(false);
        viewItemInfoR.setFocusPainted(false);
        viewItemInfoR.setBorderPainted(false);
        cancelTransactionR.setContentAreaFilled(false);
        cancelTransactionR.setFocusPainted(false);
        cancelTransactionR.setBorderPainted(false);

        layoutRVM.add(slot1R);
        layoutRVM.add(slot2R);
        layoutRVM.add(slot3R);
        layoutRVM.add(slot4R);
        layoutRVM.add(slot5R);
        layoutRVM.add(slot6R);
        layoutRVM.add(slot7R);
        layoutRVM.add(slot8R);
        layoutRVM.add(viewItemInfoR);
        layoutRVM.add(cancelTransactionR);

        displayFieldRVM.add(layoutRVM);

        container.add(displayFieldRVM, "5");
     }

     /**
     * Contains the contents of the panel to view the select item interface under the Special vending machine, stored in container 6.
     * Contains interactables(buttons) to select a product and purchase, view item info, and cancel transaction.
     */
     public void buildSpecialVM(){
        background_image_SVM = new ImageIcon("selectitem.png");
        Image img5 = background_image_SVM.getImage();
        Image temp_img5 = img5.getScaledInstance(550, 700, Image.SCALE_SMOOTH);
        background_image_SVM = new ImageIcon(temp_img5);
        displayFieldSVM = new JLabel("", background_image_SVM, JLabel.CENTER);
        displayFieldSVM.setLayout(new GridBagLayout());
        layoutSVM = new JPanel(new GridLayout(4, 3, 10, 10));

        layoutSVM.setOpaque(false);

        slot1S = new JButton(""); // insert icon
        slot2S = new JButton("");
        slot3S = new JButton("");
        slot4S = new JButton("");
        slot5S = new JButton("");
        slot6S = new JButton("");
        slot7S = new JButton("");
        slot8S = new JButton("");
        viewItemInfoS = new JButton("");
        cancelTransactionS = new JButton("");

        //setting the size of just one button will set the size for all due to gridlayout
        slot1S.setPreferredSize(new Dimension(80, 80));

        slot1S.setContentAreaFilled(false);
        slot1S.setFocusPainted(false);
        slot1S.setBorderPainted(false);
        slot2S.setContentAreaFilled(false);
        slot2S.setFocusPainted(false);
        slot2S.setBorderPainted(false);
        slot3S.setContentAreaFilled(false);
        slot3S.setFocusPainted(false);
        slot3S.setBorderPainted(false);
        slot4S.setContentAreaFilled(false);
        slot4S.setFocusPainted(false);
        slot4S.setBorderPainted(false);
        slot5S.setContentAreaFilled(false);
        slot5S.setFocusPainted(false);
        slot5S.setBorderPainted(false);
        slot6S.setContentAreaFilled(false);
        slot6S.setFocusPainted(false);
        slot6S.setBorderPainted(false);
        slot7S.setContentAreaFilled(false);
        slot7S.setFocusPainted(false);
        slot7S.setBorderPainted(false);
        slot8S.setContentAreaFilled(false);
        slot8S.setFocusPainted(false);
        slot8S.setBorderPainted(false);
        viewItemInfoS.setContentAreaFilled(false);
        viewItemInfoS.setFocusPainted(false);
        viewItemInfoS.setBorderPainted(false);
        cancelTransactionS.setContentAreaFilled(false);
        cancelTransactionS.setFocusPainted(false);
        cancelTransactionS.setBorderPainted(false);

        layoutSVM.add(slot1S);
        layoutSVM.add(slot2S);
        layoutSVM.add(slot3S);
        layoutSVM.add(slot4S);
        layoutSVM.add(slot5S);
        layoutSVM.add(slot6S);
        layoutSVM.add(slot7S);
        layoutSVM.add(slot8S);
        layoutSVM.add(viewItemInfoS);
        layoutSVM.add(cancelTransactionS);

        displayFieldSVM.add(layoutSVM);

        container.add(displayFieldSVM, "6");
     }

     /**
     * Contains the contents of the panel to view the customize item interface under the Special vending machine, stored in container 14.
     * Contains interactables(buttons) to add additional ingredients to the user's chosen base product, and confirm customization.
     */
     public void buildCustomizeItemSVM(){
        background_image_plain = new ImageIcon("plainbg.png");
        Image img6 = background_image_plain.getImage();
        Image temp_img6 = img6.getScaledInstance(550, 700, Image.SCALE_SMOOTH);
        background_image_plain = new ImageIcon(temp_img6);
        displayCustomizeItemSVM = new JLabel("", background_image_plain, JLabel.CENTER);
        displayCustomizeItemSVM.setLayout(new GridBagLayout());
        layoutCustomizeItemSVM = new JPanel(new GridLayout(13, 3, 5, 5));

        custLabelHam = new JLabel("add Ham");
        custLabelCheese = new JLabel("add Cheese");
        custLabelChicken = new JLabel("add Chicken");
        custLabelTuna = new JLabel("add Tuna");
        custLabelEgg = new JLabel("add Egg");
        custLabelMayo = new JLabel("add Mayo");
        custLabelPeanutB = new JLabel("add Peanut Butter");
        custLabelStrawberryJ = new JLabel("add Strawberry Jam");
        custLabelNutella = new JLabel("add Nutella");
        custLabelLettuce = new JLabel("add Lettuce");
        custLabelTomato = new JLabel("add Tomato");
        custLabelPickle = new JLabel("add Pickle");

        custTextHam = new JTextField();
        custTextHam.setHorizontalAlignment(JTextField.CENTER);
        custTextCheese = new JTextField();
        custTextCheese.setHorizontalAlignment(JTextField.CENTER);
        custTextChicken = new JTextField();
        custTextChicken.setHorizontalAlignment(JTextField.CENTER);
        custTextTuna = new JTextField();
        custTextTuna.setHorizontalAlignment(JTextField.CENTER);
        custTextEgg = new JTextField();
        custTextEgg.setHorizontalAlignment(JTextField.CENTER);
        custTextMayo = new JTextField();
        custTextMayo.setHorizontalAlignment(JTextField.CENTER);
        custTextPeanutB = new JTextField();
        custTextPeanutB.setHorizontalAlignment(JTextField.CENTER);
        custTextStrawberryJ = new JTextField();
        custTextStrawberryJ.setHorizontalAlignment(JTextField.CENTER);
        custTextNutella = new JTextField();
        custTextNutella.setHorizontalAlignment(JTextField.CENTER);
        custTextLettuce = new JTextField();
        custTextLettuce.setHorizontalAlignment(JTextField.CENTER);
        custTextTomato = new JTextField();
        custTextTomato.setHorizontalAlignment(JTextField.CENTER);
        custTextPickle = new JTextField();
        custTextPickle.setHorizontalAlignment(JTextField.CENTER);

        custPlusHam = new JButton("+");
        custPlusCheese = new JButton("+");
        custPlusChicken = new JButton("+");
        custPlusTuna = new JButton("+");
        custPlusEgg = new JButton("+");
        custPlusMayo = new JButton("+");
        custPlusPeanutB = new JButton("+");
        custPlusStrawberryJ = new JButton("+");
        custPlusNutella = new JButton("+");
        custPlusLettuce = new JButton("+");
        custPlusTomato = new JButton("+");
        custPlusPickle = new JButton("+");
        custPurchase = new JButton("Confirm");

        layoutCustomizeItemSVM.add(custLabelHam);
        layoutCustomizeItemSVM.add(custTextHam);
        layoutCustomizeItemSVM.add(custPlusHam);
        layoutCustomizeItemSVM.add(custLabelCheese);
        layoutCustomizeItemSVM.add(custTextCheese);
        layoutCustomizeItemSVM.add(custPlusCheese);
        layoutCustomizeItemSVM.add(custLabelChicken);
        layoutCustomizeItemSVM.add(custTextChicken);
        layoutCustomizeItemSVM.add(custPlusChicken);
        layoutCustomizeItemSVM.add(custLabelTuna);
        layoutCustomizeItemSVM.add(custTextTuna);
        layoutCustomizeItemSVM.add(custPlusTuna);
        layoutCustomizeItemSVM.add(custLabelEgg);
        layoutCustomizeItemSVM.add(custTextEgg);
        layoutCustomizeItemSVM.add(custPlusEgg);
        layoutCustomizeItemSVM.add(custLabelMayo);
        layoutCustomizeItemSVM.add(custTextMayo);
        layoutCustomizeItemSVM.add(custPlusMayo);
        layoutCustomizeItemSVM.add(custLabelPeanutB);
        layoutCustomizeItemSVM.add(custTextPeanutB);
        layoutCustomizeItemSVM.add(custPlusPeanutB);
        layoutCustomizeItemSVM.add(custLabelStrawberryJ);
        layoutCustomizeItemSVM.add(custTextStrawberryJ);
        layoutCustomizeItemSVM.add(custPlusStrawberryJ);
        layoutCustomizeItemSVM.add(custLabelNutella);
        layoutCustomizeItemSVM.add(custTextNutella);
        layoutCustomizeItemSVM.add(custPlusNutella);
        layoutCustomizeItemSVM.add(custLabelLettuce);
        layoutCustomizeItemSVM.add(custTextLettuce);
        layoutCustomizeItemSVM.add(custPlusLettuce);
        layoutCustomizeItemSVM.add(custLabelTomato);
        layoutCustomizeItemSVM.add(custTextTomato);
        layoutCustomizeItemSVM.add(custPlusTomato);
        layoutCustomizeItemSVM.add(custLabelPickle);
        layoutCustomizeItemSVM.add(custTextPickle);
        layoutCustomizeItemSVM.add(custPlusPickle);
        layoutCustomizeItemSVM.add(filler1);
        layoutCustomizeItemSVM.add(filler2);
        layoutCustomizeItemSVM.add(custPurchase);

        layoutCustomizeItemSVM.setOpaque(false);

        displayCustomizeItemSVM.add(layoutCustomizeItemSVM);

        container.add(displayCustomizeItemSVM, "14");
     }

     /**
     * Contains the contents of the panel to view the item preparation interface after item customization,
     * under the Special vending machine, stored in container 18. Contains interactables(buttons) to select
     * a product and purchase, view item info, and cancel transaction.
     */
    public void buildItemPreparationSVM(){
        background_image_plain = new ImageIcon("plainbg.png");
        Image img6 = background_image_plain.getImage();
        Image temp_img6 = img6.getScaledInstance(550, 700, Image.SCALE_SMOOTH);
        background_image_plain = new ImageIcon(temp_img6);
        displayItemPreparation = new JLabel("", background_image_plain, JLabel.CENTER);
        displayItemPreparation.setLayout(new GridBagLayout());
        layoutItemPreparation = new JPanel(new GridLayout(7, 1, 5, 5));

        containItemPreparation1 = new JTextField("Preparing your sandwich...");
        containItemPreparation2 = new JTextField("Toasting bread...");
        containItemPreparation3 = new JTextField("Adding filling...");
        containItemPreparation4 = new JTextField("Adding your additional filling...");
        containItemPreparation5 = new JTextField("Packing sandwich...");
        containItemPreparation6 = new JTextField("Sandwich done!");
        finishItemPreparation = new JButton("Done");

        //ONE SETTING SETS FOR ALL
        containItemPreparation1.setPreferredSize(new Dimension(200, 50));

        Font biggerFont = new Font(containItemPreparation1.getFont().getName(), Font.BOLD, 15);
        containItemPreparation1.setFont(biggerFont);
        containItemPreparation2.setFont(biggerFont);
        containItemPreparation3.setFont(biggerFont);
        containItemPreparation4.setFont(biggerFont);
        containItemPreparation5.setFont(biggerFont);
        containItemPreparation6.setFont(biggerFont);

        Color transparentColor = new Color(0, 0, 0, 0);
        LineBorder transparentBorder = new LineBorder(transparentColor, 1, true);

        containItemPreparation1.setBorder(transparentBorder);
        containItemPreparation2.setBorder(transparentBorder);
        containItemPreparation3.setBorder(transparentBorder);
        containItemPreparation4.setBorder(transparentBorder);
        containItemPreparation5.setBorder(transparentBorder);
        containItemPreparation6.setBorder(transparentBorder);

        layoutItemPreparation.add(containItemPreparation1);
        layoutItemPreparation.add(containItemPreparation2);
        layoutItemPreparation.add(containItemPreparation3);
        layoutItemPreparation.add(containItemPreparation4);
        layoutItemPreparation.add(containItemPreparation5);
        layoutItemPreparation.add(containItemPreparation6);
        layoutItemPreparation.add(finishItemPreparation);

        layoutItemPreparation.setOpaque(false);
        
        containItemPreparation1.setVisible(false);
        containItemPreparation2.setVisible(false);
        containItemPreparation3.setVisible(false);
        containItemPreparation4.setVisible(false);
        containItemPreparation5.setVisible(false);
        containItemPreparation6.setVisible(false);
        finishItemPreparation.setVisible(false);
        
        displayItemPreparation.add(layoutItemPreparation);

        Timer timer1 = new Timer(3000, e -> {
            containItemPreparation1.setVisible(true);
            Timer timer2 = new Timer(3000, e1 -> {
                containItemPreparation2.setVisible(true);
                Timer timer3 = new Timer(3000, e2 -> {
                    containItemPreparation3.setVisible(true);
                    Timer timer4 = new Timer(3000, e3 -> {
                        containItemPreparation4.setVisible(true);
                        Timer timer5 = new Timer(3000, e4 -> {
                            containItemPreparation5.setVisible(true);
                            Timer timer6 = new Timer(3000, e5 -> {
                                containItemPreparation6.setVisible(true);
                                finishItemPreparation.setVisible(true);
                            });
                            timer6.setRepeats(false);
                            timer6.start();
                        });
                        timer5.setRepeats(false);
                        timer5.start();
                    });
                    timer4.setRepeats(false);
                    timer4.start();
                });
                timer3.setRepeats(false);
                timer3.start();
            });
            timer2.setRepeats(false);
            timer2.start();
        });
        timer1.setRepeats(false);
        timer1.start();

        container.add(displayItemPreparation, "18");
     }

     /**
     * Contains the contents of the panel to the print receipt interface under the Regular or Special vending machine
     * (depending on which variant of the machine is being tested on), stored in container 15.
     * Contains interactables(buttons) to finish transaction.
     */
     public void buildDispenseItemAndChange(){  //basically creates a receipt
        background_image_plain = new ImageIcon("plainbg.png");
        Image img6 = background_image_plain.getImage();
        Image temp_img6 = img6.getScaledInstance(550, 700, Image.SCALE_SMOOTH);
        background_image_plain = new ImageIcon(temp_img6);
        displayDispenseItemAndChange = new JLabel("", background_image_plain, JLabel.CENTER);
        displayDispenseItemAndChange.setLayout(new GridBagLayout());
        layoutDispenseItemAndChange = new JPanel(new GridLayout(4, 1, 5, 30));
        layoutDispenseItemSubPanel1 = new JPanel(new FlowLayout(FlowLayout.LEFT));
        layoutDispenseItemSubPanel2 = new JPanel(new FlowLayout(FlowLayout.LEFT));
        layoutDispenseItemSubPanel3 = new JPanel(new FlowLayout(FlowLayout.LEFT));

        receiptTransaction = new JLabel("Your Transaction:");
        showReceiptTransaction = new JTextArea();
        receiptProductPurchased = new JLabel("Product Purchased:");
        showReceiptProductPurchased = new JTextArea();
        receiptProducedChange = new JLabel("Your Change:");
        showReceiptProducedChange = new JTextField();
        receiptGoBackToMenu = new JButton("Finish");

        showReceiptTransaction.setEditable(false);
        showReceiptProductPurchased.setEditable(false);
        showReceiptProducedChange.setEditable(false);
        showReceiptProducedChange.setOpaque(false);
        showReceiptProducedChange.setBorder(javax.swing.BorderFactory.createEmptyBorder());

        layoutDispenseItemSubPanel1.add(receiptTransaction);
        layoutDispenseItemSubPanel1.add(showReceiptTransaction);
        layoutDispenseItemSubPanel2.add(receiptProductPurchased);
        layoutDispenseItemSubPanel2.add(showReceiptProductPurchased);
        layoutDispenseItemSubPanel3.add(receiptProducedChange);
        layoutDispenseItemSubPanel3.add(showReceiptProducedChange);

        layoutDispenseItemAndChange.add(layoutDispenseItemSubPanel1);
        layoutDispenseItemAndChange.add(layoutDispenseItemSubPanel2);
        layoutDispenseItemAndChange.add(layoutDispenseItemSubPanel3);

        layoutDispenseItemAndChange.add(receiptGoBackToMenu);

        layoutDispenseItemSubPanel1.setOpaque(false);
        layoutDispenseItemSubPanel2.setOpaque(false);
        layoutDispenseItemSubPanel3.setOpaque(false);
        layoutDispenseItemAndChange.setOpaque(false);

        displayDispenseItemAndChange.add(layoutDispenseItemAndChange);

        container.add(displayDispenseItemAndChange, "15");
     }

    //MAINTENANCE FEATURES ---------------------------------------------------------------------------------------------------------------------
     
    /**
     * Contains the contents of the panel to view the Maintenance Mode interface under the Regular or Special vending machine
     * (depending on which variant of the machine is being tested on), stored in container 7.
     * Contains interactables(buttons) to restock items, restock sandwiches, set item price, collect user payments,
     * collect stored machine money, replenish machine money, view transaction history, and view inventory history.
     */
     public void buildMaintenanceMode(){
        background_image_Maintenance = new ImageIcon("maintenancemodemenu.png");
        Image img5 = background_image_Maintenance.getImage();
        Image temp_img5 = img5.getScaledInstance(550, 700, Image.SCALE_SMOOTH);
        background_image_Maintenance = new ImageIcon(temp_img5);
        displayFieldMaintenance = new JLabel("", background_image_Maintenance, JLabel.CENTER);
        displayFieldMaintenance.setLayout(new GridBagLayout());
        layoutMaintenance = new JPanel(new GridLayout(5, 2, 10, 15));
        
        layoutMaintenance.setOpaque(false);

        restockItems = new JButton("Restock Items");
        restockSandwich = new JButton("Restock Sandwiches");
        setItemPrice = new JButton("Set Item Price");
        collectPayments = new JButton("Collect Payments");
        collectVMMoney = new JButton("Collect Machine Money");
        replenishVMMoney = new JButton("Replenish Machine Money");
        viewTransactionHistory = new JButton("Transaction History");
        viewInventoryHistory = new JButton("Inventory History");
        goBackTestVM = new JButton("Go Back");

        restockItems.setPreferredSize(new Dimension(150, 65));

        layoutMaintenance.add(restockItems);
        layoutMaintenance.add(restockSandwich);
        layoutMaintenance.add(setItemPrice);
        layoutMaintenance.add(collectPayments);
        layoutMaintenance.add(collectVMMoney);
        layoutMaintenance.add(replenishVMMoney);
        layoutMaintenance.add(viewTransactionHistory);
        layoutMaintenance.add(viewInventoryHistory);
        layoutMaintenance.add(goBackTestVM);

        displayFieldMaintenance.add(layoutMaintenance);

        container.add(displayFieldMaintenance, "7");
     }

     /**
     * Contains the contents of the panel to view the Restock Items interface under the Regular vending machine stored in container 8.
     * Contains interactables(buttons) to increase current item stocks and go back to the maintenance menu interface.
     */
     public void buildRestockItemsRVM(){
        background_image_plain = new ImageIcon("plainbg.png");
        Image img6 = background_image_plain.getImage();
        Image temp_img6 = img6.getScaledInstance(550, 700, Image.SCALE_SMOOTH);
        background_image_plain = new ImageIcon(temp_img6);
        displayBlank1 = new JLabel("", background_image_plain, JLabel.CENTER);
        displayBlank1.setLayout(new GridBagLayout());
        layoutRestockItems = new JPanel(new GridLayout(11, 3, 5, 5));

        layoutRestockItems.setOpaque(false);

        restockBread = new JLabel("Bread");
        restockHam = new JLabel("Ham");
        restockCheese = new JLabel("Cheese");
        restockChicken = new JLabel("Chicken");
        restockTuna = new JLabel("Tuna");
        restockEgg = new JLabel("Egg");
        restockMayo = new JLabel("Mayo");
        restockPeanutButter = new JLabel("Peanut Butter");
        restockStrawberryJam = new JLabel("Strawberry Jam");
        restockNutella = new JLabel("Nutella");

        breadQuantR = new JTextField();
        breadQuantR.setHorizontalAlignment(JTextField.CENTER);
        hamQuantR = new JTextField();
        hamQuantR.setHorizontalAlignment(JTextField.CENTER);
        cheeseQuantR = new JTextField();
        cheeseQuantR.setHorizontalAlignment(JTextField.CENTER);
        chickenQuantR = new JTextField();
        chickenQuantR.setHorizontalAlignment(JTextField.CENTER);
        tunaQuantR = new JTextField();
        tunaQuantR.setHorizontalAlignment(JTextField.CENTER);
        eggQuantR = new JTextField();
        eggQuantR.setHorizontalAlignment(JTextField.CENTER);
        mayoQuantR = new JTextField();
        mayoQuantR.setHorizontalAlignment(JTextField.CENTER);
        peanutBQuantR = new JTextField();
        peanutBQuantR.setHorizontalAlignment(JTextField.CENTER);
        strawberryJQuantR = new JTextField();
        strawberryJQuantR.setHorizontalAlignment(JTextField.CENTER);
        nutellaQuantR = new JTextField();
        nutellaQuantR.setHorizontalAlignment(JTextField.CENTER);


        plusBreadR = new JButton("+");
        plusHamR = new JButton("+");
        plusCheeseR = new JButton("+");
        plusChickenR = new JButton("+");
        plusTunaR = new JButton("+");
        plusEggR = new JButton("+");
        plusMayoR = new JButton("+");
        plusPeanutBR = new JButton("+");
        plusStrawberryJR = new JButton("+");
        plusNutellaR = new JButton("+");
        confirmRestockItemsR = new JButton("Confirm");
        backMaintenanceModeR = new JButton("Go Back");

        layoutRestockItems.add(restockBread);
        layoutRestockItems.add(breadQuantR);
        layoutRestockItems.add(plusBreadR);
        layoutRestockItems.add(restockHam);
        layoutRestockItems.add(hamQuantR);
        layoutRestockItems.add(plusHamR);
        layoutRestockItems.add(restockCheese);
        layoutRestockItems.add(cheeseQuantR);
        layoutRestockItems.add(plusCheeseR);
        layoutRestockItems.add(restockChicken);
        layoutRestockItems.add(chickenQuantR);
        layoutRestockItems.add(plusChickenR);
        layoutRestockItems.add(restockTuna);
        layoutRestockItems.add(tunaQuantR);
        layoutRestockItems.add(plusTunaR);
        layoutRestockItems.add(restockEgg);
        layoutRestockItems.add(eggQuantR);
        layoutRestockItems.add(plusEggR);
        layoutRestockItems.add(restockMayo);
        layoutRestockItems.add(mayoQuantR);
        layoutRestockItems.add(plusMayoR);
        layoutRestockItems.add(restockPeanutButter);
        layoutRestockItems.add(peanutBQuantR);
        layoutRestockItems.add(plusPeanutBR);
        layoutRestockItems.add(restockStrawberryJam);
        layoutRestockItems.add(strawberryJQuantR);
        layoutRestockItems.add(plusStrawberryJR);
        layoutRestockItems.add(restockNutella);
        layoutRestockItems.add(nutellaQuantR);
        layoutRestockItems.add(plusNutellaR);
        layoutRestockItems.add(backMaintenanceModeR);

        layoutRestockItems.add(confirmRestockItemsR);

        displayBlank1.add(layoutRestockItems);

        container.add(displayBlank1, "8");
     }

     /**
     * Contains the contents of the panel to view the Restock Items interface under the Special vending machine stored in container 9.
     * Contains interactables(buttons) to increase current item stocks and go back to the maintenance menu interface.
     */
    public void buildRestockItemsSVM(){
        background_image_plain = new ImageIcon("plainbg.png");
        Image img6 = background_image_plain.getImage();
        Image temp_img6 = img6.getScaledInstance(550, 700, Image.SCALE_SMOOTH);
        background_image_plain = new ImageIcon(temp_img6);
        displayBlank2 = new JLabel("", background_image_plain, JLabel.CENTER);
        displayBlank2.setLayout(new GridBagLayout());
        layoutRestockItems = new JPanel(new GridLayout(14, 3, 5, 5));

        layoutRestockItems.setOpaque(false);

        restockBread = new JLabel("Bread");
        restockHam = new JLabel("Ham");
        restockCheese = new JLabel("Cheese");
        restockChicken = new JLabel("Chicken");
        restockTuna = new JLabel("Tuna");
        restockEgg = new JLabel("Egg");
        restockMayo = new JLabel("Mayo");
        restockPeanutButter = new JLabel("Peanut Butter");
        restockStrawberryJam = new JLabel("Strawberry Jam");
        restockNutella = new JLabel("Nutella");
        restockLettuce = new JLabel("Lettuce");
        restockTomato = new JLabel("Tomato");
        restockPickle = new JLabel("Pickle");

        breadQuantS = new JTextField();
        breadQuantS.setHorizontalAlignment(JTextField.CENTER);
        hamQuantS = new JTextField();
        hamQuantS.setHorizontalAlignment(JTextField.CENTER);
        cheeseQuantS = new JTextField();
        cheeseQuantS.setHorizontalAlignment(JTextField.CENTER);
        chickenQuantS = new JTextField();
        chickenQuantS.setHorizontalAlignment(JTextField.CENTER);
        tunaQuantS = new JTextField();
        tunaQuantS.setHorizontalAlignment(JTextField.CENTER);
        eggQuantS = new JTextField();
        eggQuantS.setHorizontalAlignment(JTextField.CENTER);
        mayoQuantS = new JTextField();
        mayoQuantS.setHorizontalAlignment(JTextField.CENTER);
        peanutBQuantS = new JTextField();
        peanutBQuantS.setHorizontalAlignment(JTextField.CENTER);
        strawberryJQuantS = new JTextField();
        strawberryJQuantS.setHorizontalAlignment(JTextField.CENTER);
        nutellaQuantS = new JTextField();
        nutellaQuantS.setHorizontalAlignment(JTextField.CENTER);
        lettuceQuantS = new JTextField();
        lettuceQuantS.setHorizontalAlignment(JTextField.CENTER);
        tomatoQuantS = new JTextField();
        tomatoQuantS.setHorizontalAlignment(JTextField.CENTER);
        pickleQuantS = new JTextField();
        pickleQuantS.setHorizontalAlignment(JTextField.CENTER);

        plusBreadS = new JButton("+");
        plusHamS = new JButton("+");
        plusCheeseS = new JButton("+");
        plusChickenS = new JButton("+");
        plusTunaS = new JButton("+");
        plusEggS = new JButton("+");
        plusMayoS = new JButton("+");
        plusPeanutBS = new JButton("+");
        plusStrawberryJS = new JButton("+");
        plusNutellaS = new JButton("+");
        plusLettuceS = new JButton("+");
        plusTomatoS = new JButton("+");
        plusPickleS = new JButton("+");
        confirmRestockItemsS = new JButton("Confirm");
        backMaintenanceModeS = new JButton("Go Back");

        layoutRestockItems.add(restockBread);
        layoutRestockItems.add(breadQuantS);
        layoutRestockItems.add(plusBreadS);
        layoutRestockItems.add(restockHam);
        layoutRestockItems.add(hamQuantS);
        layoutRestockItems.add(plusHamS);
        layoutRestockItems.add(restockCheese);
        layoutRestockItems.add(cheeseQuantS);
        layoutRestockItems.add(plusCheeseS);
        layoutRestockItems.add(restockChicken);
        layoutRestockItems.add(chickenQuantS);
        layoutRestockItems.add(plusChickenS);
        layoutRestockItems.add(restockTuna);
        layoutRestockItems.add(tunaQuantS);
        layoutRestockItems.add(plusTunaS);
        layoutRestockItems.add(restockEgg);
        layoutRestockItems.add(eggQuantS);
        layoutRestockItems.add(plusEggS);
        layoutRestockItems.add(restockMayo);
        layoutRestockItems.add(mayoQuantS);
        layoutRestockItems.add(plusMayoS);
        layoutRestockItems.add(restockPeanutButter);
        layoutRestockItems.add(peanutBQuantS);
        layoutRestockItems.add(plusPeanutBS);
        layoutRestockItems.add(restockStrawberryJam);
        layoutRestockItems.add(strawberryJQuantS);
        layoutRestockItems.add(plusStrawberryJS);
        layoutRestockItems.add(restockNutella);
        layoutRestockItems.add(nutellaQuantS);
        layoutRestockItems.add(plusNutellaS);
        layoutRestockItems.add(restockLettuce);
        layoutRestockItems.add(lettuceQuantS);
        layoutRestockItems.add(plusLettuceS);
        layoutRestockItems.add(restockTomato);
        layoutRestockItems.add(tomatoQuantS);
        layoutRestockItems.add(plusTomatoS);
        layoutRestockItems.add(restockPickle);
        layoutRestockItems.add(pickleQuantS);
        layoutRestockItems.add(plusPickleS);
        layoutRestockItems.add(backMaintenanceModeS);

        layoutRestockItems.add(confirmRestockItemsS);

        displayBlank2.add(layoutRestockItems);

        container.add(displayBlank2, "9");
     }

     /**
     * Contains the contents of the panel to view the Restock Sandwiches interface under the Regular or Special vending machine
     * (depending on which variant of the machine is being tested on), stored in container 10.
     * Contains interactables(buttons) to increase current sandwich stocks and go back to the maintenance menu interface.
     */
     public void buildRestockSandwich(){
        background_image_plain = new ImageIcon("plainbg.png");
        Image img6 = background_image_plain.getImage();
        Image temp_img6 = img6.getScaledInstance(550, 700, Image.SCALE_SMOOTH);
        background_image_plain = new ImageIcon(temp_img6);
        displayBlank3 = new JLabel("", background_image_plain, JLabel.CENTER);
        displayBlank3.setLayout(new GridBagLayout());
        layoutRestockSandwiches = new JPanel(new GridLayout(10, 3, 5, 5));

        layoutRestockSandwiches.setOpaque(false);

        restockHamSandwich = new JLabel("Ham Sand.");
        restockCheeseSandwich = new JLabel("Cheese Sand.");
        restockChickenSandwich = new JLabel("Chicken Sand.");
        restockTunaSandwich = new JLabel("Tuna Sand.");
        restockEggSandwich = new JLabel("Egg Sand.");
        restockPeanutButterSandwich = new JLabel("Peanut Butter Sand.");
        restockStrawberryJamSandwich = new JLabel("Strawberry Jam Sand.");
        restockNutellaSandwich = new JLabel("Nutella Sand.");

        hamSandwichQuant = new JTextField();
        hamSandwichQuant.setHorizontalAlignment(JTextField.CENTER);
        cheeseSandwichQuant = new JTextField();
        cheeseSandwichQuant.setHorizontalAlignment(JTextField.CENTER);
        chickenSandwichQuant = new JTextField();
        chickenSandwichQuant.setHorizontalAlignment(JTextField.CENTER);
        tunaSandwichQuant = new JTextField();
        tunaSandwichQuant.setHorizontalAlignment(JTextField.CENTER);
        eggSandwichQuant = new JTextField();
        eggSandwichQuant.setHorizontalAlignment(JTextField.CENTER);
        peanutBSandwichQuant = new JTextField();
        peanutBSandwichQuant.setHorizontalAlignment(JTextField.CENTER);
        strawberryJSandwichQuant = new JTextField();
        strawberryJSandwichQuant.setHorizontalAlignment(JTextField.CENTER);
        nutellaSandwichQuant = new JTextField();
        nutellaSandwichQuant.setHorizontalAlignment(JTextField.CENTER);

        plusHamSandwich = new JButton("+");
        plusCheeseSandwich = new JButton("+");
        plusChickenSandwich = new JButton("+");
        plusTunaSandwich = new JButton("+");
        plusEggSandwich = new JButton("+");
        plusPeanutBSandwich = new JButton("+");
        plusStrawberryJSandwich = new JButton("+");
        plusNutellaSandwich = new JButton("+");
        backMaintenanceModeFromSandwich = new JButton("Go Back");

        layoutRestockSandwiches.add(restockHamSandwich);
        layoutRestockSandwiches.add(hamSandwichQuant);
        layoutRestockSandwiches.add(plusHamSandwich);
        layoutRestockSandwiches.add(restockCheeseSandwich);
        layoutRestockSandwiches.add(cheeseSandwichQuant);
        layoutRestockSandwiches.add(plusCheeseSandwich);
        layoutRestockSandwiches.add(restockChickenSandwich);
        layoutRestockSandwiches.add(chickenSandwichQuant);
        layoutRestockSandwiches.add(plusChickenSandwich);
        layoutRestockSandwiches.add(restockTunaSandwich);
        layoutRestockSandwiches.add(tunaSandwichQuant);
        layoutRestockSandwiches.add(plusTunaSandwich);
        layoutRestockSandwiches.add(restockEggSandwich);
        layoutRestockSandwiches.add(eggSandwichQuant);
        layoutRestockSandwiches.add(plusEggSandwich);
        layoutRestockSandwiches.add(restockPeanutButterSandwich);
        layoutRestockSandwiches.add(peanutBSandwichQuant);
        layoutRestockSandwiches.add(plusPeanutBSandwich);
        layoutRestockSandwiches.add(restockStrawberryJamSandwich);
        layoutRestockSandwiches.add(strawberryJSandwichQuant);
        layoutRestockSandwiches.add(plusStrawberryJSandwich);
        layoutRestockSandwiches.add(restockNutellaSandwich);
        layoutRestockSandwiches.add(nutellaSandwichQuant);
        layoutRestockSandwiches.add(plusNutellaSandwich);
        layoutRestockSandwiches.add(backMaintenanceModeFromSandwich);

        displayBlank3.add(layoutRestockSandwiches);

        container.add(displayBlank3, "10");
     }

     /**
     * Contains the contents of the panel to view the Set Item Price interface under the Regular or Special vending machine
     * (depending on which variant of the machine is being tested on), stored in container 11.
     * Contains interactables(text fields and buttons) to set the current product price, confirm and save changes,
     * and go back (discard changes) to the maintenance menu interface.
     */
     public void buildSetItemPrice(){                                                       
        Image img6 = background_image_plain.getImage();
        Image temp_img6 = img6.getScaledInstance(550, 700, Image.SCALE_SMOOTH);
        background_image_plain = new ImageIcon(temp_img6);
        displayBlank4 = new JLabel("", background_image_plain, JLabel.CENTER);
        displayBlank4.setLayout(new GridBagLayout());
        layoutSetPrice = new JPanel(new GridLayout(9, 2, 5, 5));

        setHamSandwichPrice = new JLabel("Ham Sand. Price:");
        setCheeseSandwichPrice = new JLabel("Cheese Sand. Price:");
        setChickenSandwichPrice = new JLabel("Chicken Sand. Price:");
        setTunaSandwichPrice = new JLabel("Tuna Sand. Price:");
        setEggSandwichPrice = new JLabel("Egg Sand. Price:");
        setPeanutBSandwichPrice = new JLabel("Peanut Butter Sand. Price:");
        setStrawberryJSandwichPrice = new JLabel("Strawberry Jam Sand. Price:");
        setNutellaSandwichPrice = new JLabel("Nutella Sand. Price:");

        curHamSandwichPrice = new JTextField();
        curHamSandwichPrice.setHorizontalAlignment(JTextField.CENTER);
        curCheeseSandwichPrice = new JTextField();
        curCheeseSandwichPrice.setHorizontalAlignment(JTextField.CENTER);
        curChickenSandwichPrice = new JTextField();
        curChickenSandwichPrice.setHorizontalAlignment(JTextField.CENTER);
        curTunaSandwichPrice = new JTextField();
        curTunaSandwichPrice.setHorizontalAlignment(JTextField.CENTER);
        curEggSandwichPrice = new JTextField();
        curEggSandwichPrice.setHorizontalAlignment(JTextField.CENTER);
        curPeanutBSandwichPrice = new JTextField();
        curPeanutBSandwichPrice.setHorizontalAlignment(JTextField.CENTER);
        curStrawberryJSandwichPrice = new JTextField();
        curStrawberryJSandwichPrice.setHorizontalAlignment(JTextField.CENTER);
        curNutellaSandwichPrice = new JTextField();
        curNutellaSandwichPrice.setHorizontalAlignment(JTextField.CENTER);

        confirmItemPrice = new JButton("Confirm");
        backMaintenanceModeFromSetPrice = new JButton("Go Back");

        layoutSetPrice.add(setHamSandwichPrice);
        layoutSetPrice.add(curHamSandwichPrice);
        layoutSetPrice.add(setCheeseSandwichPrice);
        layoutSetPrice.add(curCheeseSandwichPrice);
        layoutSetPrice.add(setChickenSandwichPrice);
        layoutSetPrice.add(curChickenSandwichPrice);
        layoutSetPrice.add(setTunaSandwichPrice);
        layoutSetPrice.add(curTunaSandwichPrice);
        layoutSetPrice.add(setEggSandwichPrice);
        layoutSetPrice.add(curEggSandwichPrice);
        layoutSetPrice.add(setPeanutBSandwichPrice);
        layoutSetPrice.add(curPeanutBSandwichPrice);
        layoutSetPrice.add(setStrawberryJSandwichPrice);
        layoutSetPrice.add(curStrawberryJSandwichPrice);
        layoutSetPrice.add(setNutellaSandwichPrice);
        layoutSetPrice.add(curNutellaSandwichPrice);
        layoutSetPrice.add(backMaintenanceModeFromSetPrice);
        layoutSetPrice.add(confirmItemPrice);

        displayBlank4.add(layoutSetPrice);

        container.add(displayBlank4, "11");
     }

     /**
      * Creates the pop-up window that allows the user to collect and empty the user payments in the
      * Regular or Special vending machine (depends on which vending machine variant is being tested on).
      * 
      * @param message is a String value containing the amount of user payments collected by the machine.
      * @return true is a Boolean value returned when the user chooses the yes option in the pop-up window.
      * @return false is a Boolean value returned when the user chooses the no option in the pop-up window.
      */
     public boolean buildCollectPayment(String message){
        int resultSelectItem = JOptionPane.showConfirmDialog(null, message, "Collect Payment", JOptionPane.YES_NO_OPTION);

        if(resultSelectItem == JOptionPane.YES_OPTION)   {
            return true;
        }

        return false;
     }

     /**
      * Confirms the collection of the user payments in the Regular or Special vending machine
      * (depends on which vending machine variant is being tested on).
      * 
      * @param message is a String value containing the amount of user payments collected by the machine.
      */
     public void confirmCollectPayment(String message)  {
        JOptionPane.showMessageDialog(null, message, "Payment Collected", JOptionPane.INFORMATION_MESSAGE);
     }

     /**
      * Creates the pop-up window that allows the user to collect and empty the machine monet in the
      * Regular or Special vending machine (depends on which vending machine variant is being tested on).
      * 
      * @param message is a String value containing the amount of money stored in the machine.
      * @return true is a Boolean value returned when the user chooses the yes option in the pop-up window.
      * @return false is a Boolean value returned when the user chooses the no option in the pop-up window.
      */
     public boolean buildCollectMachineMoney(String message){
        int resultSelectItem = JOptionPane.showConfirmDialog(null, message, "Collect Vending Machine Money", JOptionPane.YES_NO_OPTION);

        if(resultSelectItem == JOptionPane.YES_OPTION)   {
            return true;
        }

        return false;
     }

     /**
      * Confirms the collection of the machine money in the Regular or Special vending machine
      * (depends on which vending machine variant is being tested on).
      * 
      * @param message is a String value containing the amount of money stored in the machine.
      */
     public void confirmCollectVMMoney(String message)  {
        JOptionPane.showMessageDialog(null, message, "Vending Machine Money Collected", JOptionPane.INFORMATION_MESSAGE);
     }

     /**
      * Contains the contents to the panel that allows the user to replenish or add more to the money that is stored
      * inside the Regular or Special vending machine (depends on which vending machine variant is being tested on).
      * Includes interactables like buttons to increase the amount of bills stored in the machine and a go back button
      * that takes the user back to the maintenance mode menu.
      */
     public void buildReplenishMoney(){
        Image img6 = background_image_plain.getImage();
        Image temp_img6 = img6.getScaledInstance(550, 700, Image.SCALE_SMOOTH);
        background_image_plain = new ImageIcon(temp_img6);
        displayBlank5 = new JLabel("", background_image_plain, JLabel.CENTER);
        displayBlank5.setLayout(new GridBagLayout());
        layoutReplenishMoney = new JPanel(new GridLayout(11, 3, 5, 5));

        curVMMoney = new JLabel("Current Money:");
        showCurVMMoney = new JTextField();
        showCurVMMoney.setHorizontalAlignment(JTextField.CENTER);

        curPeso1 = new JLabel("insert 1:");
        curPeso5 = new JLabel("insert 5:");
        curPeso10 = new JLabel("insert 10:");
        curPeso20 = new JLabel("insert 20:");
        curPeso50 = new JLabel("insert 50:");
        curPeso100 = new JLabel("insert 100:");
        curPeso200 = new JLabel("insert 200:");
        curPeso500 = new JLabel("insert 500:");
        curPeso1000 = new JLabel("insert 1000:");

        cur1 = new JTextField();
        cur1.setHorizontalAlignment(JTextField.CENTER);
        cur5 = new JTextField();
        cur5.setHorizontalAlignment(JTextField.CENTER);
        cur10 = new JTextField();
        cur10.setHorizontalAlignment(JTextField.CENTER);
        cur20 = new JTextField();
        cur20.setHorizontalAlignment(JTextField.CENTER);
        cur50 = new JTextField();
        cur50.setHorizontalAlignment(JTextField.CENTER);
        cur100 = new JTextField();
        cur100.setHorizontalAlignment(JTextField.CENTER);
        cur200 = new JTextField();
        cur200.setHorizontalAlignment(JTextField.CENTER);
        cur500 = new JTextField();
        cur500.setHorizontalAlignment(JTextField.CENTER);
        cur1000 = new JTextField();
        cur1000.setHorizontalAlignment(JTextField.CENTER);

        replenish1 = new JButton("+");
        replenish5 = new JButton("+");
        replenish10 = new JButton("+");
        replenish20 = new JButton("+");
        replenish50 = new JButton("+");
        replenish100 = new JButton("+");
        replenish200 = new JButton("+");
        replenish500 = new JButton("+");
        replenish1000 = new JButton("+");

        goBackFromReplenish = new JButton("Go Back");

        layoutReplenishMoney.add(curVMMoney);
        layoutReplenishMoney.add(showCurVMMoney);
        layoutReplenishMoney.add(filler3);
        layoutReplenishMoney.add(curPeso1);
        layoutReplenishMoney.add(cur1);
        layoutReplenishMoney.add(replenish1);
        layoutReplenishMoney.add(curPeso5);
        layoutReplenishMoney.add(cur5);
        layoutReplenishMoney.add(replenish5);
        layoutReplenishMoney.add(curPeso10);
        layoutReplenishMoney.add(cur10);
        layoutReplenishMoney.add(replenish10);
        layoutReplenishMoney.add(curPeso20);
        layoutReplenishMoney.add(cur20);
        layoutReplenishMoney.add(replenish20);
        layoutReplenishMoney.add(curPeso50);
        layoutReplenishMoney.add(cur50);
        layoutReplenishMoney.add(replenish50);
        layoutReplenishMoney.add(curPeso100);
        layoutReplenishMoney.add(cur100);
        layoutReplenishMoney.add(replenish100);
        layoutReplenishMoney.add(curPeso200);
        layoutReplenishMoney.add(cur200);
        layoutReplenishMoney.add(replenish200);
        layoutReplenishMoney.add(curPeso500);
        layoutReplenishMoney.add(cur500);
        layoutReplenishMoney.add(replenish500);
        layoutReplenishMoney.add(curPeso1000);
        layoutReplenishMoney.add(cur1000);
        layoutReplenishMoney.add(replenish1000);
        layoutReplenishMoney.add(goBackFromReplenish);

        layoutReplenishMoney.setOpaque(false);

        displayBlank5.add(layoutReplenishMoney);

        container.add(displayBlank5, "12");
     }

     /**
      * Contains the contents to the panel that allows the user to view the transaction history that is stored
      * in the Regular or Special vending machine (depends on which vending machine variant is being tested on).
      * Includes interactables like a scroll panel to allow viewing of numerous transaction entries and a go back button
      * that takes the user back to the maintenance mode menu.
      */
     public void buildViewTransactionHistory() {
        background_image_plain = new ImageIcon("plainbg.png");
        Image img6 = background_image_plain.getImage();
        Image temp_img6 = img6.getScaledInstance(550, 700, Image.SCALE_SMOOTH);
        background_image_plain = new ImageIcon(temp_img6);
        displayViewTransactionHistory = new JLabel("", background_image_plain, JLabel.CENTER);
        displayViewTransactionHistory.setLayout(new GridBagLayout());
        layoutDisplayViewTransactionHistory = new JPanel(new GridBagLayout());
    
        containTransactionHistory = new JTextArea();
        goBackFromTransactionHistory = new JButton("Go Back");
    
        containTransactionHistory.setPreferredSize(new Dimension(400, 500));
    
        JScrollPane scrollPaneTransactionHistory = new JScrollPane(containTransactionHistory);
        scrollPaneTransactionHistory.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        scrollPaneTransactionHistory.setPreferredSize(new Dimension(400, 500));
    
        GridBagConstraints gbc4 = new GridBagConstraints();
        gbc4.fill = GridBagConstraints.BOTH;
        gbc4.weightx = 1.0;
        gbc4.weighty = 1.0;
    
        layoutDisplayViewTransactionHistory.add(scrollPaneTransactionHistory, gbc4);
    
        gbc4.gridy = 1; // Move to the next row
        layoutDisplayViewTransactionHistory.add(goBackFromTransactionHistory, gbc4);
    
        displayViewTransactionHistory.add(layoutDisplayViewTransactionHistory);
    
        container.add(displayViewTransactionHistory, "19");
    }

    /**
      * Contains the contents to the panel that allows the user to view the inventory history that is stored
      * in the Regular or Special vending machine (depends on which vending machine variant is being tested on).
      * Includes interactables like a scroll panel to allow viewing of numerous inventory entries and a go back button
      * that takes the user back to the maintenance mode menu.
      */
    public void buildViewInventoryHistory() {
        background_image_plain = new ImageIcon("plainbg.png");
        Image img6 = background_image_plain.getImage();
        Image temp_img6 = img6.getScaledInstance(550, 700, Image.SCALE_SMOOTH);
        background_image_plain = new ImageIcon(temp_img6);
        displayViewInventoryHistory = new JLabel("", background_image_plain, JLabel.CENTER);
        displayViewInventoryHistory.setLayout(new GridBagLayout());
        layoutDisplayInventoryHistory = new JPanel(new GridBagLayout());
    
        containInventoryHistory = new JTextArea();
        goBackFromInventoryHistory = new JButton("Go Back");
    
        containInventoryHistory.setPreferredSize(new Dimension(400, 500));
    
        JScrollPane scrollPaneInventoryHistory = new JScrollPane(containInventoryHistory);
        scrollPaneInventoryHistory.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        scrollPaneInventoryHistory.setPreferredSize(new Dimension(400, 500));
    
        GridBagConstraints gbc5 = new GridBagConstraints();
        gbc5.fill = GridBagConstraints.BOTH;
        gbc5.weightx = 1.0;
        gbc5.weighty = 1.0;
    
        layoutDisplayInventoryHistory.add(scrollPaneInventoryHistory, gbc5);
    
        gbc5.gridy = 1; // Move to the next row
        layoutDisplayInventoryHistory.add(goBackFromInventoryHistory, gbc5);
    
        displayViewInventoryHistory.add(layoutDisplayInventoryHistory);

        container.add(displayViewInventoryHistory, "20");
    }

     //for JOptionPanes
     public boolean dispSelectItem(){
        selectItemRVM = new JOptionPane();
        int resultSelectItem = JOptionPane.showConfirmDialog(null, "Purchase item?\n\nYes - purchase item\nNo - choose another item", "System Message", JOptionPane.YES_NO_OPTION);

        if(resultSelectItem == JOptionPane.YES_OPTION){
            return true;
        }

        return false;
     }


     public int dispCustomizeItem(){
        selectItemSVM = new JOptionPane();
        int resultCustomizeItem = JOptionPane.showConfirmDialog(null, "CUSTOMIZE ITEM?\n\nYes - customize\nNo - purchase as is\nCancel - choose another item", "System Message", JOptionPane.YES_NO_CANCEL_OPTION);

        if(resultCustomizeItem == JOptionPane.YES_OPTION)   {
            return 1;
        } else if (resultCustomizeItem == JOptionPane.NO_OPTION)    {
            return 2;
        } else return 3;
        
     }

     public void dispErrorTestVM(){
        JOptionPane.showMessageDialog(null, "No Vending Machine Created!", "Error", JOptionPane.ERROR_MESSAGE);
        
     }

     public void dispErrorSandwichRestock(){
        JOptionPane.showMessageDialog(null, "Lack of Ingredients!", "Error", JOptionPane.ERROR_MESSAGE);
     }

     public void dispErrorNotEnoughMoney(){
        JOptionPane.showMessageDialog(null, "Not Enough Money", "Error", JOptionPane.ERROR_MESSAGE);
     }

     public void dispErrorNotEnoughMoneySpecial(){
        JOptionPane.showMessageDialog(null, "Cannot Afford this with Current Money!\n\nRedirecting back to adding money", "Error", JOptionPane.ERROR_MESSAGE);
     }

     public void dispErrorNotEnoughStock(){
        JOptionPane.showMessageDialog(null, "Not enough stock", "Error", JOptionPane.ERROR_MESSAGE);
     }



     public void dispViewPriceList(String longText){
        containPriceList = new JTextArea(1, 1);
        containPriceList.setText(longText);
        containPriceList.setOpaque(false);
        containPriceList.setEditable(false);
        JOptionPane.showMessageDialog(null, containPriceList, "View Price List", JOptionPane.PLAIN_MESSAGE);
     }

    //  public void dispViewItemInfo(){
    //     containItemPriceR = new JTextArea(1, 1);
    //     String longText2 = "Ham Sandwich\nP\n\nCheese Sandwich\nP\n\nChicken Sandwich\nP\n\nTuna Sandwich\nP\n\nEgg Salad Sandwich\nP\n\nPeanut Butter Sandwich\nP\n\nStrawberry Jam Sandwich\nP\n\nNutella Sandwich\nP";

    //  }

    //button listeners
    public void setCreateVMListener(ActionListener actnListener)    {
        this.createVM.addActionListener(actnListener);
    }
    
    public void setTestVMListener(ActionListener actnListener)    {
        this.testVM.addActionListener(actnListener);
    }

    public void setBuyItemListener(ActionListener actnListener) {
        this.buyItem.addActionListener(actnListener);
    }

    public void setConfirmMoney(ActionListener actnListener) {
        this.confirmPayment.addActionListener(actnListener);
    }

    public void setViewPriceList(ActionListener actnListener) {
        this.viewPriceList.addActionListener(actnListener);
    }

    public void setMaintenanceListener(ActionListener actnListener) {
        this.accMain.addActionListener(actnListener);
    }

    public void setBackListener(ActionListener actnListener)    {
       this.goBack.addActionListener(actnListener);
    }

    public void setBackTestVMListener(ActionListener actnListener)    {
       this.goBackTestVM.addActionListener(actnListener);
    }

    
    public void setRegularVMBtnListener(ActionListener actnListener)    {
       this.regularVM.addActionListener(actnListener);
    }
    public void setSpecialVMBtnListener(ActionListener actnListener)    {
        this.specialVM.addActionListener(actnListener);
    }

    //button listeners for item slots in RVM and SVM
    public void setSlot1RListener(ActionListener actnListener)    {
        this.slot1R.addActionListener(actnListener);
    }
    public void setSlot2RListener(ActionListener actnListener)    {
        this.slot2R.addActionListener(actnListener);
    }
    public void setSlot3RListener(ActionListener actnListener)    {
        this.slot3R.addActionListener(actnListener);
    }
    public void setSlot4RListener(ActionListener actnListener)    {
        this.slot4R.addActionListener(actnListener);
    }
    public void setSlot5RListener(ActionListener actnListener)    {
        this.slot5R.addActionListener(actnListener);
    }
    public void setSlot6RListener(ActionListener actnListener)    {
        this.slot6R.addActionListener(actnListener);
    }
    public void setSlot7RListener(ActionListener actnListener)    {
        this.slot7R.addActionListener(actnListener);
    }
    public void setSlot8RListener(ActionListener actnListener)    {
        this.slot8R.addActionListener(actnListener);
    }
    public void setSlot1SListener(ActionListener actnListener)    {
        this.slot1S.addActionListener(actnListener);
    }
    public void setSlot2SListener(ActionListener actnListener)    {
        this.slot2S.addActionListener(actnListener);
    }
    public void setSlot3SListener(ActionListener actnListener)    {
        this.slot3S.addActionListener(actnListener);
    }
    public void setSlot4SListener(ActionListener actnListener)    {
        this.slot4S.addActionListener(actnListener);
    }
    public void setSlot5SListener(ActionListener actnListener)    {
        this.slot5S.addActionListener(actnListener);
    }
    public void setSlot6SListener(ActionListener actnListener)    {
        this.slot6S.addActionListener(actnListener);
    }
    public void setSlot7SListener(ActionListener actnListener)    {
        this.slot7S.addActionListener(actnListener);
    }
    public void setSlot8SListener(ActionListener actnListener)    {
        this.slot8S.addActionListener(actnListener);
    }
    public void setViewItemInfoRListener(ActionListener actnListener)    {
        this.viewItemInfoR.addActionListener(actnListener);
    }
    public void setGoBackFromViewItemInfoRListener(ActionListener actnListener)    {
        this.goBackFromViewInfoR.addActionListener(actnListener);
    }
    public void setViewItemInfoSListener(ActionListener actnListener)    {
        this.viewItemInfoS.addActionListener(actnListener);
    }
    public void setProduceReceiptOfPurchaseListener(ActionListener actnListener)    {
        this.finishItemPreparation.addActionListener(actnListener);
    }
    public void setPurchaseCustItemListener(ActionListener actnListener)    {
        this.custPurchase.addActionListener(actnListener);
    }
    public void setReceiptGoBackToMenuListener(ActionListener actnListener)    {
        this.receiptGoBackToMenu.addActionListener(actnListener);
    }
    public void setViewAdditionalInfoListener(ActionListener actnListener)    {
        this.viewAdditionalInfo.addActionListener(actnListener);
    }
    public void setGoBackFromAdditionalInfoListener(ActionListener actnListener)    {
        this.goBackFromViewAdditionalItemInfoS.addActionListener(actnListener);
    }
    public void setCancelTransactionRListener(ActionListener actnListener)    {
        this.cancelTransactionR.addActionListener(actnListener);
    }
    public void setCancelTransactionSListener(ActionListener actnListener)    {
        this.cancelTransactionS.addActionListener(actnListener);
    }


    //button listeners for insert money interface
    public void setPlus1Listener(ActionListener actnListener)  {
        this.plus1.addActionListener(actnListener);
    }
    public void setPlus5Listener(ActionListener actnListener)  {
        this.plus5.addActionListener(actnListener);
    }
    public void setPlus10Listener(ActionListener actnListener) {
        this.plus10.addActionListener(actnListener);
    }
    public void setPlus20Listener(ActionListener actnListener) {
        this.plus20.addActionListener(actnListener);
    }
    public void setPlus50Listener(ActionListener actnListener) {
        this.plus50.addActionListener(actnListener);
    }
    public void setPlus100Listener(ActionListener actnListener)    {
        this.plus100.addActionListener(actnListener);
    }
    public void setPlus200Listener(ActionListener actnListener)    {
        this.plus200.addActionListener(actnListener);
    }
    public void setPlus500Listener(ActionListener actnListener)    {
        this.plus500.addActionListener(actnListener);
    }
    public void setPlus1000Listener(ActionListener actnListener)   {
        this.plus1000.addActionListener(actnListener);
    }
    public String getQuant1()   {
        return this.quant1.getText();
    }
    public String getQuant5()   {
        return this.quant5.getText();
    }
    public String getQuant10()   {
        return this.quant10.getText();
    }
    public String getQuant20()   {
        return this.quant20.getText();
    }
    public String getQuant50()   {
        return this.quant50.getText();
    }
    public String getQuant100()   {
        return this.quant100.getText();
    }
    public String getQuant200()   {
        return this.quant200.getText();
    }
    public String getQuant500()   {
        return this.quant500.getText();
    }
    public String getQuant1000()   {
        return this.quant1000.getText();
    }
    public String getCurrentAmount()    {
        return this.currentAmount.getText();
    }
    public void setQuant1(String quant1) {
        this.quant1.setText(quant1);
    }
    public void setQuant5(String quant5) {
        this.quant5.setText(quant5);
    }
    public void setQuant10(String quant10) {
        this.quant10.setText(quant10);
    }
    public void setQuant20(String quant20) {
        this.quant20.setText(quant20);
    }
    public void setQuant50(String quant50) {
        this.quant50.setText(quant50);
    }
    public void setQuant100(String quant100) {
        this.quant100.setText(quant100);
    }
    public void setQuant200(String quant200) {
        this.quant200.setText(quant200);
    }
    public void setQuant500(String quant500) {
        this.quant500.setText(quant500);
    }
    public void setQuant1000(String quant1000) {
        this.quant1000.setText(quant1000);
    }
    public void setCurrentAmount(String currentAmount)  {
        this.currentAmount.setText(currentAmount);
    }

    //button listeners for maintenance method
    public void setRestockItemsListener(ActionListener actnListener)    {
        this.restockItems.addActionListener(actnListener);
    }
    public void setRestockSandwichesListener(ActionListener actnListener)    {
        this.restockSandwich.addActionListener(actnListener);
    }
    public void setBackMaintenanceModeListenerR(ActionListener actnListener)    {
        this.backMaintenanceModeR.addActionListener(actnListener);
    }
    public void setBackMaintenanceModeListenerS(ActionListener actnListener)    {
        this.backMaintenanceModeS.addActionListener(actnListener);
    }
    public void setBackMaintenanceModeListenerFromSandwich(ActionListener actnListener)    {
        this.backMaintenanceModeFromSandwich.addActionListener(actnListener);
    }

    // button listeners for Restock Items

    public void setPlusBreadListenerR(ActionListener actnListener)   {
        this.plusBreadR.addActionListener(actnListener);
    }

    public void setPlusHamListenerR(ActionListener actnListener)   {
        this.plusHamR.addActionListener(actnListener);
    }

    public void setPlusCheeseListenerR(ActionListener actnListener)   {
        this.plusCheeseR.addActionListener(actnListener);
    }

    public void setPlusChickenListenerR(ActionListener actnListener)   {
        this.plusChickenR.addActionListener(actnListener);
    }

    public void setPlusTunaListenerR(ActionListener actnListener)   {
        this.plusTunaR.addActionListener(actnListener);
    }

    public void setPlusEggListenerR(ActionListener actnListener)   {
        this.plusEggR.addActionListener(actnListener);
    }

    public void setPlusMayoListenerR(ActionListener actnListener)   {
        this.plusMayoR.addActionListener(actnListener);
    }

    public void setPlusPeanutBListenerR(ActionListener actnListener)   {
        this.plusPeanutBR.addActionListener(actnListener);
    }

    public void setPlusStrawberryJListenerR(ActionListener actnListener)   {
        this.plusStrawberryJR.addActionListener(actnListener);
    }

    public void setPlusNutellaListenerR(ActionListener actnListener)   {
        this.plusNutellaR.addActionListener(actnListener);
    }

    // Special
    public void setPlusBreadListenerS(ActionListener actnListener)   {
        this.plusBreadS.addActionListener(actnListener);
    }

    public void setPlusHamListenerS(ActionListener actnListener)   {
        this.plusHamS.addActionListener(actnListener);
    }

    public void setPlusCheeseListenerS(ActionListener actnListener)   {
        this.plusCheeseS.addActionListener(actnListener);
    }

    public void setPlusChickenListenerS(ActionListener actnListener)   {
        this.plusChickenS.addActionListener(actnListener);
    }

    public void setPlusTunaListenerS(ActionListener actnListener)   {
        this.plusTunaS.addActionListener(actnListener);
    }

    public void setPlusEggListenerS(ActionListener actnListener)   {
        this.plusEggS.addActionListener(actnListener);
    }

    public void setPlusMayoListenerS(ActionListener actnListener)   {
        this.plusMayoS.addActionListener(actnListener);
    }

    public void setPlusPeanutBListenerS(ActionListener actnListener)   {
        this.plusPeanutBS.addActionListener(actnListener);
    }

    public void setPlusStrawberryJListenerS(ActionListener actnListener)   {
        this.plusStrawberryJS.addActionListener(actnListener);
    }

    public void setPlusNutellaListenerS(ActionListener actnListener)   {
        this.plusNutellaS.addActionListener(actnListener);
    }


    public void setPlusLettuceListenerS(ActionListener actnListener)   {
        this.plusLettuceS.addActionListener(actnListener);
    }

    public void setPlusTomatoListenerS(ActionListener actnListener)   {
        this.plusTomatoS.addActionListener(actnListener);
    }

    public void setPlusPickleListenerS(ActionListener actnListener)   {
        this.plusPickleS.addActionListener(actnListener);
    }

    public void setConfirmRestockItemsR(ActionListener actnListener)    {
        this.confirmRestockItemsR.addActionListener(actnListener);
    }

    /**
     * 
     * @param actnListener 
     */
    public void setConfirmRestockItemsS(ActionListener actnListener)    {
        this.confirmRestockItemsS.addActionListener(actnListener);
    }

    // getters and setters for TextFields of Restock Items SVM

    /**
     * Gets the String value for the quantity of the bread in stock, under the Regular vending machine.
     * @return breadQuantR.getText() String value containing the quantity of the bread in stock.
     */
    public String getBreadQuantR() {
        return breadQuantR.getText();
    }

    /**
     * Sets the String value for the quantity of the bread in stock, under the Regular vending machine.
     */
    public void setBreadQuantR(String breadQuantR) {
        this.breadQuantR.setText(breadQuantR);
    }

    /**
     * Gets the String value for the quantity of the ham in stock, under the Regular vending machine.
     * @return hamQuantR.getText() is a String value containing the quantity of the ham in stock.
     */
    public String getHamQuantR() {
        return hamQuantR.getText();
    }

    /**
     * Sets the String value for the quantity of the ham in stock, under the Regular vending machine.
     */
    public void setHamQuantR(String hamQuantR) {
        this.hamQuantR.setText(hamQuantR);;
    }

    /**
     * Gets the String value for the quantity of the cheese in stock, under the Regular vending machine.
     * @return cheeseQuantR.getText() is a String value containing the quantity of the cheese in stock.
     */
    public String getCheeseQuantR() {
        return cheeseQuantR.getText();
    }

    /**
     * Sets the String value for the quantity of the cheese in stock, under the Regular vending machine.
     */
    public void setCheeseQuantR(String cheeseQuantR) {
        this.cheeseQuantR.setText(cheeseQuantR);;
    }

    /**
     * Gets the String value for the quantity of the chicken in stock, under the Regular vending machine.
     * @return chickenQuantR.getText() is a String value containing the quantity of the chicken in stock.
     */
    public String getChickenQuantR() {
        return chickenQuantR.getText();
    }

    /**
     * Sets the String value for the quantity of the chicken in stock, under the Regular vending machine.
     */
    public void setChickenQuantR(String chickenQuantR) {
        this.chickenQuantR.setText(chickenQuantR);;
    }

    /**
     * Gets the String value for the quantity of the tuna in stock, under the Regular vending machine.
     * @return tunaQuantR.getText() is a String value containing the quantity of the tuna in stock.
     */
    public String getTunaQuantR() {
        return tunaQuantR.getText();
    }   

    /**
     * Sets the String value for the quantity of the tuna in stock, under the Regular vending machine.
     */
    public void setTunaQuantR(String tunaQuantR) {
        this.tunaQuantR.setText(tunaQuantR);
    }

    /**
     * Gets the String value for the quantity of the egg in stock, under the Regular vending machine.
     * @return eggQuantR.getText() is a String value containing the quantity of the egg in stock.
     */
    public String getEggQuantR() {
        return eggQuantR.getText();
    }

    /**
     * Sets the String value for the quantity of the egg in stock, under the Regular vending machine.
     */
    public void setEggQuantR(String eggQuantR) {
        this.eggQuantR.setText(eggQuantR);;
    }

    /**
     * Gets the String value for the quantity of the mayo in stock, under the Regular vending machine.
     * @return mayoQuantR.getText() is a String value containing the quantity of the mayo in stock.
     */
    public String getMayoQuantR() {
        return mayoQuantR.getText();
    }

    /**
     * Sets the String value for the quantity of the mayo in stock, under the Regular vending machine.
     */
    public void setMayoQuantR(String mayoQuantR) {
        this.mayoQuantR.setText(mayoQuantR);
    }

    /**
     * Gets the String value for the quantity of the peanut butter in stock, under the Regular vending machine.
     * @return peanutBQuantR.getText() is a String value containing the quantity of the peanut butter in stock.
     */
    public String getPeanutBQuantR() {
        return peanutBQuantR.getText();
    }

    /**
     * Sets the String value for the quantity of the peanut butter in stock, under the Regular vending machine.
     */
    public void setPeanutBQuantR(String peanutBQuantR) {
        this.peanutBQuantR.setText(peanutBQuantR);;
    }

    /**
     * Gets the String value for the quantity of the strawberry jam in stock, under the Regular vending machine.
     * @return strawberryJQuantR.getText() is a String value containing the quantity of the strawberry jam in stock.
     */
    public String getStrawberryJQuantR() {
        return strawberryJQuantR.getText();
    }

    /**
     * Sets the String value for the quantity of the strawberry jam in stock, under the Regular vending machine.
     */
    public void setStrawberryJQuantR(String strawberryJQuantR) {
        this.strawberryJQuantR.setText(strawberryJQuantR);;
    }

    /**
     * Gets the String value for the quantity of the nutella in stock, under the Regular vending machine.
     * @return nutellaQuantR.getText() is a String value containing the quantity of the nutella in stock.
     */
    public String getNutellaQuantR() {
        return nutellaQuantR.getText();
    }

    /**
     * Sets the String value for the quantity of the nutella in stock, under the Regular vending machine.
     */
    public void setNutellaQuantR(String nutellaQuantR) {
        this.nutellaQuantR.setText(nutellaQuantR);
    }


    // getters and setters for TextFields of Restock Items SVM

    /**
     * Gets the String value for the quantity of the bread in stock, under the Special vending machine.
     * @return breadQuantS.getText() is a String value containing the quantity of the bread in stock.
     */
    public String getBreadQuantS() {
        return breadQuantS.getText();
    }

    /**
     * Sets the String value for the quantity of the bread in stock, under the Special vending machine.
     */
    public void setBreadQuantS(String breadQuantS) {
        this.breadQuantS.setText(breadQuantS);
    }

    /**
     * Gets the String value for the quantity of the ham in stock, under the Special vending machine.
     * @return hamQuantS.getText() is a String value containing the quantity of the ham in stock.
     */
    public String getHamQuantS() {
        return hamQuantS.getText();
    }

    /**
     * Sets the String value for the quantity of the ham in stock, under the Special vending machine.
     */
    public void setHamQuantS(String hamQuantS) {
        this.hamQuantS.setText(hamQuantS);;
    }

    /**
     * Gets the String value for the quantity of the cheese in stock, under the Special vending machine.
     * @return cheeseQuantS.getText() is a String value containing the quantity of the cheese in stock.
     */
    public String getCheeseQuantS() {
        return cheeseQuantS.getText();
    }

    /**
     * Sets the String value for the quantity of the cheese in stock, under the Special vending machine.
     */
    public void setCheeseQuantS(String cheeseQuantS) {
        this.cheeseQuantS.setText(cheeseQuantS);;
    }

    /**
     * Gets the String value for the quantity of the chicken in stock, under the Special vending machine.
     * @return chickenQuantS.getText() is a String value containing the quantity of the chicken in stock.
     */
    public String getChickenQuantS() {
        return chickenQuantS.getText();
    }

    /**
     * Sets the String value for the quantity of the chicken in stock, under the Special vending machine.
     */
    public void setChickenQuantS(String chickenQuantS) {
        this.chickenQuantS.setText(chickenQuantS);;
    }

    /**
     * Gets the String value for the quantity of the tuna in stock, under the Special vending machine.
     * @return tunaQuantS.getText() is a String value containing the quantity of the tuna in stock.
     */
    public String getTunaQuantS() {
        return tunaQuantS.getText();
    }   

    /**
     * Sets the String value for the quantity of the tuna in stock, under the Special vending machine.
     */
    public void setTunaQuantS(String tunaQuantS) {
        this.tunaQuantS.setText(tunaQuantS);
    }

    /**
     * Gets the String value for the quantity of the egg in stock, under the Special vending machine.
     * @return eggQuantS.getText() is a String value containing the quantity of the egg in stock.
     */
    public String getEggQuantS() {
        return eggQuantS.getText();
    }

    /**
     * Sets the String value for the quantity of the egg in stock, under the Special vending machine.
     */
    public void setEggQuantS(String eggQuantS) {
        this.eggQuantS.setText(eggQuantS);;
    }

    /**
     * Gets the String value for the quantity of the mayo in stock, under the Special vending machine.
     * @return mayoQuantS.getText() is a String value containing the quantity of the mayo in stock.
     */
    public String getMayoQuantS() {
        return mayoQuantS.getText();
    }

    /**
     * Sets the String value for the quantity of the mayo in stock, under the Special vending machine.
     */
    public void setMayoQuantS(String mayoQuantS) {
        this.mayoQuantS.setText(mayoQuantS);
    }

    /**
     * Gets the String value for the quantity of the peanut butter in stock, under the Special vending machine.
     * @return peanutBQuantS.getText() is a String value containing the quantity of the peanut butter in stock.
     */
    public String getPeanutBQuantS() {
        return peanutBQuantS.getText();
    }

    /**
     * Sets the String value for the quantity of the peanut butter in stock, under the Special vending machine.
     */
    public void setPeanutBQuantS(String peanutBQuantS) {
        this.peanutBQuantS.setText(peanutBQuantS);;
    }

    /**
     * Gets the String value for the quantity of the strawberry jam in stock, under the Special vending machine.
     * @return strawberryJQuantS.getText() is a String value containing the quantity of the strawberry jam in stock.
     */
    public String getStrawberryJQuantS() {
        return strawberryJQuantS.getText();
    }

    /**
     * Sets the String value for the quantity of the strawberry jam in stock, under the Special vending machine.
     */
    public void setStrawberryJQuantS(String strawberryJQuantS) {
        this.strawberryJQuantS.setText(strawberryJQuantS);;
    }

    /**
     * Gets the String value for the quantity of the nutella in stock, under the Special vending machine.
     * @return nutellaQuantS.getText() is a String value containing the quantity of the nutella in stock.
     */
    public String getNutellaQuantS() {
        return nutellaQuantS.getText();
    }

    /**
     * Sets the String value for the quantity of the nutella in stock, under the Special vending machine.
     */
    public void setNutellaQuantS(String nutellaQuantS) {
        this.nutellaQuantS.setText(nutellaQuantS);
    }
    /**
     * Gets the String value for the quantity of the lettuce in stock, under the Special vending machine.
     * @return lettuceQuantS.getText() is a String value containing the quantity of the lettuce in stock.
     */
    public String getLettuceQuantS() {
        return lettuceQuantS.getText();
    }

    /**
     * Sets the String value for the quantity of the lettuce in stock, under the Special vending machine.
     */
    public void setLettuceQuantS(String lettuceQuantS) {
        this.lettuceQuantS.setText(lettuceQuantS);;
    }

    /**
     * Gets the String value for the quantity of the tomato in stock, under the Special vending machine.
     * @return tomatoQuantS.getText() is a String value containing the quantity of the tomato in stock.
     */
    public String getTomatoQuantS() {
        return tomatoQuantS.getText();
    }

    /**
     * Sets the String value for the quantity of the tomato in stock, under the Special vending machine.
     */
    public void setTomatoQuantS(String tomatoQuantS) {
        this.tomatoQuantS.setText(tomatoQuantS);;
    }

    /**
     * Gets the String value for the quantity of the pickle in stock, under the Special vending machine.
     * @return pickleQuantS.getText() is a String value containing the quantity of the pickle in stock.
     */
    public String getPickleQuantS() {
        return pickleQuantS.getText();
    }

    /**
     * Sets the String value for the quantity of the pickle in stock, under the Special vending machine.
     */
    public void setPickleQuantS(String pickleQuantS) {
        this.pickleQuantS.setText(pickleQuantS);;
    }

    // Restock Sandwich Getters and setters

    /**
     * Gets the String value for the quantity of the ham sandwich in stock.
     * @return hamSandwichQuant.getText() is a String value containing the quantity of the ham in stock.
     */
    public String getHamSandwichQuant() {
        return hamSandwichQuant.getText();
    }

    /**
     * Sets the String value for the quantity of the ham sandwich in stock.
     */
    public void setHamSandwichQuant(String hamSandwichQuant) {
        this.hamSandwichQuant.setText(hamSandwichQuant);
    }

    /**
     * Gets the String value for the quantity of the cheese sandwich in stock.
     * @return cheeseSandwichQuant.getText() is a String value containing the quantity of the cheese in stock.
     */
    public String getCheeseSandwichQuant() {
        return cheeseSandwichQuant.getText();
    }

    /**
     * Sets the String value for the quantity of the cheese sandwich in stock.
     */
    public void setCheeseSandwichQuant(String cheeseSandwichQuant) {
        this.cheeseSandwichQuant.setText(cheeseSandwichQuant);
    }

    /**
     * Gets the String value for the quantity of the chicken sandwich in stock.
     */
    public String getChickenSandwichQuant() {
        return chickenSandwichQuant.getText();
    }

    /**
     * Sets the String value for the quantity of the chicken salad sandwich in stock.
     */
    public void setChickenSandwichQuant(String chickenSandwichQuant) {
        this.chickenSandwichQuant.setText(chickenSandwichQuant);
    }

    /**
     * Gets the String value for the quantity of the tuna sandwich in stock.
     */
    public String getTunaSandwichQuant() {
        return tunaSandwichQuant.getText();
    }

    /**
     * Sets the String value for the quantity of the tuna sandwich in stock.
     */
    public void setTunaSandwichQuant(String tunaSandwichQuant) {
        this.tunaSandwichQuant.setText(tunaSandwichQuant);
    }

    /**
     * Gets the String value for the quantity of the egg salad sandwich in stock.
     */
    public String getEggSandwichQuant() {
        return eggSandwichQuant.getText();
    }

    /**
     * Sets the String value for the quantity of the egg salad sandwich in stock.
     */
    public void setEggSandwichQuant(String eggSandwichQuant) {
        this.eggSandwichQuant.setText(eggSandwichQuant);
    }

    /**
     * Gets the String value for the quantity of the peanut butter sandwich in stock.
     */
    public String getPeanutBSandwichQuant() {
        return peanutBSandwichQuant.getText();
    }

    /**
     * Sets the String value for the quantity of the peanut butter sandwich in stock.
     */
    public void setPeanutBSandwichQuant(String peanutBSandwichQuant) {
        this.peanutBSandwichQuant.setText(peanutBSandwichQuant);
    }

    /**
     * Gets the String value for the quantity of the strawberry jam sandwich in stock.
     */
    public String getStrawberryJSandwichQuant() {
        return strawberryJSandwichQuant.getText();
    }

    /**
     * Sets the String value for the quantity of the strawberry jam sandwich in stock.
     */
    public void setStrawberryJSandwichQuant(String strawberryJSandwichQuant) {
        this.strawberryJSandwichQuant.setText(strawberryJSandwichQuant);
    }

    /**
     * Gets the String value for the quantity of the nutella sandwich in stock.
     */
    public String getNutellaSandwichQuant() {
        return nutellaSandwichQuant.getText();
    }

    /**
     * Sets the String value for the quantity of the nutella sandwich in stock.
     */
    public void setNutellaSandwichQuant(String nutellaSandwichQuant) {
        this.nutellaSandwichQuant.setText(nutellaSandwichQuant);
    }

    // Restock Sandwich Listeners

    /**
     * Sets an action listener for when the "+" button is pressed in the Restock Sandwich interface.
     * this increases the value of the ham sandwich by +1.
     * 
     * @param actnListener allows the button to perform an action when interacted with.
     */
    public void setPlusHamSandwichListener(ActionListener actnListener) {
        this.plusHamSandwich.addActionListener(actnListener);
    }

    /**
     * Sets an action listener for when the "+" button is pressed in the Restock Sandwich interface.
     * this increases the value of the cheese sandwich by +1.
     * 
     * @param actnListener allows the button to perform an action when interacted with.
     */
    public void setPlusCheeseSandwichListener(ActionListener actnListener)  {
        this.plusCheeseSandwich.addActionListener(actnListener);
    }

    /**
     * Sets an action listener for when the "+" button is pressed in the Restock Sandwich interface.
     * this increases the value of the chicken salad sandwich by +1.
     * 
     * @param actnListener allows the button to perform an action when interacted with.
     */
    public void setPlusChickenSandwichListener(ActionListener actnListener) {
        this.plusChickenSandwich.addActionListener(actnListener);
    }

    /**
     * Sets an action listener for when the "+" button is pressed in the Restock Sandwich interface.
     * this increases the value of the tuna sandwich by +1.
     * 
     * @param actnListener allows the button to perform an action when interacted with.
     */
    public void setPlusTunaSandwichListener(ActionListener actnListener)   {
        this.plusTunaSandwich.addActionListener(actnListener);
    }

    /**
     * Sets an action listener for when the "+" button is pressed in the Restock Sandwich interface.
     * this increases the value of the egg salad sandwich by +1.
     * 
     * @param actnListener allows the button to perform an action when interacted with.
     */
    public void setPlusEggSandwichListener(ActionListener actnListener)    {
        this.plusEggSandwich.addActionListener(actnListener);
    }

    /**
     * Sets an action listener for when the "+" button is pressed in the Restock Sandwich interface.
     * this increases the value of the nutella sandwich by +1.
     * 
     * @param actnListener allows the button to perform an action when interacted with.
     */
    public void setPlusPeanutBSandwichListener(ActionListener actnListener)   {
        this.plusPeanutBSandwich.addActionListener(actnListener);
    }

    /**
     * Sets an action listener for when the "+" button is pressed in the Restock Sandwich interface.
     * this increases the value of the nutella sandwich by +1.
     * 
     * @param actnListener allows the button to perform an action when interacted with.
     */
    public void setPlusStrawberryJSandwichListener(ActionListener actnListener) {
        this.plusStrawberryJSandwich.addActionListener(actnListener);
    }
    
    /**
     * Sets an action listener for when the "+" button is pressed in the Restock Sandwich interface.
     * this increases the value of the nutella sandwich by +1.
     * 
     * @param actnListener allows the button to perform an action when interacted with.
     */
    public void setPlusNutellaSandwichListener(ActionListener actnListener) {
        this.plusNutellaSandwich.addActionListener(actnListener);
    }

    /**
     * Sets an action listener for when the "Collect Payments" button from the Maintenance Mode menu.
     * this allows the user to collect user payments collected by the machine.
     * 
     * @param actnListener allows the button to perform an action when interacted with.
     */
    public void setCollectPaymentsListener(ActionListener actnListener)  {
        this.collectPayments.addActionListener(actnListener);
    }

    /**
     * Sets an action listener for when the "Collect Machine Money" button from the Maintenance Mode menu.
     * this allows the user to collect the money stored the machine.
     * 
     * @param actnListener allows the button to perform an action when interacted with.
     */
    public void setCollectVMMoneyListener(ActionListener actnListener)  {
        this.collectVMMoney.addActionListener(actnListener);
    }

    // Set Item Price Getters and Setters

    /**
     * Sets an action listener for when the "Set Item Price" button is pressed from the Maintenance Mode menu.
     * this takes the user to the Set Item Price interface.
     * 
     * @param actnListener allows the button to perform an action when interacted with.
     */
    public void setSetItemPriceListener(ActionListener actnListener)    {                      
        this.setItemPrice.addActionListener(actnListener);
    }        

    /*
     * Gets the String value for the current price of the ham sandwich.
     */
    public String getCurHamSandwichPrice() {
        return this.curHamSandwichPrice.getText();
    }

    /*
     * Sets the String value for the current price of the ham sandwich.
     */
    public void setCurHamSandwichPrice(String curHamSandwichPrice) {
        this.curHamSandwichPrice.setText(curHamSandwichPrice);
    }

    /*
     * Gets the String value for the current price of the cheese sandwich.
     */
    public String getCurCheeseSandwichPrice()   {
        return this.curCheeseSandwichPrice.getText();
    }

    /*
     * Sets the String value for the current price of the cheese sandwich.
     */
    public void setCurCheeseSandwichPrice(String curCheeseSandwichPrice) {
        this.curCheeseSandwichPrice.setText(curCheeseSandwichPrice);
    }

    /*
     * Gets the String value for the current price of the chicken salad sandwich.
     */
    public String getCurChickenSandwichPrice()  {
        return this.curChickenSandwichPrice.getText();
    }

    /*
     * Sets the String value for the current price of the chicken salad sandwich.
     */
    public void setCurChickenSandwichPrice(String curChickenSandwichPrice) {
        this.curChickenSandwichPrice.setText(curChickenSandwichPrice);
    }

    /*
     * Gets the String value for the current price of the tuna sandwich.
     */
    public String getCurTunaSandwichPrice() {
        return this.curTunaSandwichPrice.getText();
    }

    /*
     * Sets the String value for the current price of the tuna sandwich.
     */
    public void setCurTunaSandwichPrice(String curTunaSandwichPrice) {
        this.curTunaSandwichPrice.setText(curTunaSandwichPrice);
    }

    /*
     * Gets the String value for the current price of the egg salad sandwich.
     */
    public String getCurEggSandwichPrice()  {
        return this.curEggSandwichPrice.getText();
    }

    /*
     * Sets the String value for the current price of the egg salad sandwich.
     */
    public void setCurEggSandwichPrice(String curEggSandwichPrice) {
        this.curEggSandwichPrice.setText(curEggSandwichPrice);
    }

    /*
     * Gets the String value for the current price of the peanut butter sandwich.
     */
    public String getCurPeanutBSandwichPrice()  {
        return this.curPeanutBSandwichPrice.getText();
    }

    /*
     * Sets the String value for the current price of the peanut butter sandwich.
     */
    public void setCurPeanutBSandwichPrice(String curPeanutBSandwichPrice) {
        this.curPeanutBSandwichPrice.setText(curPeanutBSandwichPrice);
    }

    /*
     * Gets the String value for the current price of the strawberry jam sandwich.
     */
    public String getCurStrawberryJSandwichPrice() {
        return this.curStrawberryJSandwichPrice.getText();
    }

    /*
     * Sets the String value for the current price of the strawberry jam sandwich.
     */
    public void setCurStrawberryJSandwichPrice(String curStrawberryJSandwichPrice) {
        this.curStrawberryJSandwichPrice.setText(curStrawberryJSandwichPrice);
    }

    /*
     * Gets the String value of the current price of the nutella sandwich.
     */
    public String getCurNutellaSandwichPrice()  {
        return this.curNutellaSandwichPrice.getText();
    }

    /*
     * Sets the String value for the current price of the nutella sandwich.
     */
    public void setCurNutellaSandwichPrice(String curNutellaSandwichPrice) {
        this.curNutellaSandwichPrice.setText(curNutellaSandwichPrice);
    }

    // Set Item Price Listeners ---------------------------------------------------------------------------------------------------

    /**
     * Sets an action listener for when the "Confirm" button is pressed on the Set Price interface.
     * this allows the machine to save any changes made to the price values.
     * 
     * @param actnListener allows the button to perform an action when interacted with.
     */
    public void setConfirmItemPrice(ActionListener actnListener)   {
        this.confirmItemPrice.addActionListener(actnListener);
    }
    
    /**
     * Sets an action listener for when the "Go Back" button is pressed on the Set Price interface.
     * this takes the user back to the Maintenance Mode menu and discards of any changes made to
     * the price values.
     * 
     * @param actnListener allows the button to perform an action when interacted with.
     */
    public void setBackMaintenanceModeListenerFromSetPrice(ActionListener actnListener)    {    
        this.backMaintenanceModeFromSetPrice.addActionListener(actnListener);
    }

    //Replenish Money Listener

    /**
     * Sets an action listener for when the "Replenish Money" button is pressed on the Maintenance Mode menu.
     * 
     * @param actnListener allows the button to perform an action when interacted with.
     */
    public void setReplenishVMMoneyListener(ActionListener actnListener)    {    
        this.replenishVMMoney.addActionListener(actnListener);
    }

    /*
     * Sets the String value for the total amount of all currently inserted bills inside the vending machine.
     */
    public void setShowCurVMMoney(String curVMMoney)  {
        this.showCurVMMoney.setText(curVMMoney);
    }

    /*
     * Gets the String value for the current amount of 1 bills inside the vending machine.
     */
    public String getCur1() {
        return cur1.getText();
    }

    /*
     * Sets the String value for the current amount of 1 bills inside the vending machine.
     */
    public void setCur1(String cur1) {
        this.cur1.setText(cur1);;
    }

    /*
     * Gets the String value for the current amount of 5 bills inside the vending machine.
     */
    public String getCur5() {
        return cur5.getText();
    }

    /*
     * Sets the String value for the current amount of 5 bills inside the vending machine.
     */
    public void setCur5(String cur5) {
        this.cur5.setText(cur5);;
    }

    /*
     * Gets the String value for the current amount of 10 bills inside the vending machine.
     */
    public String getCur10() {
        return cur10.getText();
    }

    /*
     * Sets the String value for the current amount of 10 bills inside the vending machine.
     */
    public void setCur10(String cur10) {
        this.cur10.setText(cur10);;
    }

    /*
     * Gets the String value for the current amount of 20 bills inside the vending machine.
     */
    public String getCur20() {
        return cur20.getText();
    }

    /*
     * Sets the String value for the current amount of 20 bills inside the vending machine.
     */
    public void setCur20(String cur20) {
        this.cur20.setText(cur20);;
    }

    /*
     * Gets the String value for the current amount of 50 bills inside the vending machine.
     */
    public String getCur50() {
        return cur50.getText();
    }

    /*
     * Sets the String value for the current amount of 50 bills inside the vending machine.
     */
    public void setCur50(String cur50) {
        this.cur50.setText(cur50);;
    }

    /*
     * Gets the String value for the current amount of 100 bills inside the vending machine.
     */
    public String getCur100() {
        return cur100.getText();
    }

    /*
     * Sets the String value for the current amount of 100 bills inside the vending machine.
     */
    public void setCur100(String cur100) {
        this.cur100.setText(cur100);;
    }

    /*
     * Gets the String value for the current amount of 200 bills inside the vending machine.
     */
    public String getCur200() {
        return cur200.getText();
    }

    /*
     * Sets the String value for the current amount of 200 bills inside the vending machine.
     */
    public void setCur200(String cur200) {
        this.cur200.setText(cur200);;
    }

    /*
     * Gets the String value for the current amount of 500 bills inside the vending machine.
     */
    public String getCur500() {
        return cur500.getText();
    }

    /*
     * Sets the String value for the current amount of 500 bills inside the vending machine.
     */
    public void setCur500(String cur500) {
        this.cur500.setText(cur500);;
    }

    /*
     * Gets the String value for the current amount of 1000 bills inside the vending machine.
     */
    public String getCur1000() {
        return cur1000.getText();
    }

    /*
     * Sets the String value for the current amount of 1000 bills inside the vending machine.
     */
    public void setCur1000(String cur1000) {
        this.cur1000.setText(cur1000);;
    }

    // Listeners for Replenish Money ---------------------------------------------------------------------------------------------------

    /**
     * Sets an action listener for when the "+" button gets pressed on the Replenish Money interface.
     * 
     * @param actnListener allows the button to perform an action when interacted with.
     */
    public void setReplenish1Listener(ActionListener actnListener)  {
        this.replenish1.addActionListener(actnListener);
    }

    /**
     * Sets an action listener for when the "+" button gets pressed on the Replenish Money interface.
     * 
     * @param actnListener allows the button to perform an action when interacted with.
     */
    public void setReplenish5Listener(ActionListener actnListener)  {
        this.replenish5.addActionListener(actnListener);
    }

    /**
     * Sets an action listener for when the "+" button gets pressed on the Replenish Money interface.
     * 
     * @param actnListener allows the button to perform an action when interacted with.
     */
    public void setReplenish10Listener(ActionListener actnListener)  {
        this.replenish10.addActionListener(actnListener);
    }

    /**
     * Sets an action listener for when the "+" button gets pressed on the Replenish Money interface.
     * 
     * @param actnListener allows the button to perform an action when interacted with.
     */
    public void setReplenish20Listener(ActionListener actnListener)  {
        this.replenish20.addActionListener(actnListener);
    }

    /**
     * Sets an action listener for when the "+" button gets pressed on the Replenish Money interface.
     * 
     * @param actnListener allows the button to perform an action when interacted with.
     */
    public void setReplenish50Listener(ActionListener actnListener)  {
        this.replenish50.addActionListener(actnListener);
    }

    /**
     * Sets an action listener for when the "+" button gets pressed on the Replenish Money interface.
     * 
     * @param actnListener allows the button to perform an action when interacted with.
     */
    public void setReplenish100Listener(ActionListener actnListener)  {
        this.replenish100.addActionListener(actnListener);
    }

    /**
     * Sets an action listener for when the "+" button gets pressed on the Replenish Money interface.
     * 
     * @param actnListener allows the button to perform an action when interacted with.
     */
    public void setReplenish200Listener(ActionListener actnListener)  {
        this.replenish200.addActionListener(actnListener);
    }

    /**
     * Sets an action listener for when the "+" button gets pressed on the Replenish Money interface.
     * 
     * @param actnListener allows the button to perform an action when interacted with.
     */
    public void setReplenish500Listener(ActionListener actnListener)  {
        this.replenish500.addActionListener(actnListener);
    }

    /**
     * Sets an action listener for when the "+" button gets pressed on the Replenish Money interface.
     * 
     * @param actnListener allows the button to perform an action when interacted with.
     */
    public void setReplenish1000Listener(ActionListener actnListener)  {
        this.replenish1000.addActionListener(actnListener);
    }

    /**
     * Sets an action listener for when the "Go Back" button from the Replenish Money interface is pressed.
     * this takes the user back to the Maintenance Mode menu.
     * 
     * @param actnListener allows the button to perform an action when interacted with.
     */
    public void setGoBackFromReplenishMoneyListener(ActionListener actnListener)  {
        this.goBackFromReplenish.addActionListener(actnListener);
    }

    // Getters and Setters for Customize Item ---------------------------------------------------------------------------------------------------

    /*
     * Gets the String value of the ham's quantity in the customize item interface.
     */
    public String getCustTextHam() {
        return custTextHam.getText();
    }

    /*
     * Sets the String value of the ham's quantity in the customize item interface.
     */
    public void setCustTextHam(String custTextHam) {
        this.custTextHam.setText(custTextHam);
    }

    /*
     * Gets the String value of the cheese's quantity in the customize item interface.
     */
    public String getCustTextCheese() {
        return custTextCheese.getText();
    }

    /*
     * Sets the String value of the cheese's quantity in the customize item interface.
     */
    public void setCustTextCheese(String custTextCheese) {
        this.custTextCheese.setText(custTextCheese);;
    }

    /*
     * Gets the String value of the chicken's quantity in the customize item interface.
     */
    public String getCustTextChicken() {
        return custTextChicken.getText();
    }

    /*
     * Sets the String value of the chicken's quantity in the customize item interface.
     */
    public void setCustTextChicken(String custTextChicken) {
        this.custTextChicken.setText(custTextChicken);;
    }

    /*
     * Gets the String value of the tuna's quantity in the customize item interface.
     */
    public String getCustTextTuna() {
        return custTextTuna.getText();
    }

    /*
     * Sets the String value of the tuna's quantity in the customize item interface.
     */
    public void setCustTextTuna(String custTextTuna) {
        this.custTextTuna.setText(custTextTuna);;
    }

    /*
     * Gets the String value of the egg's quantity in the customize item interface.
     */
    public String getCustTextEgg() {
        return custTextEgg.getText();
    }

    /*
     * Sets the String value of the egg's quantity in the customize item interface.
     */
    public void setCustTextEgg(String custTextEgg) {
        this.custTextEgg.setText(custTextEgg);;
    }

    /*
     * Gets the String value of the mayo's quantity in the customize item interface.
     */
    public String getCustTextMayo() {
        return custTextMayo.getText();
    }

    /*
     * Sets the String value of the mayo's quantity in the customize item interface.
     */
    public void setCustTextMayo(String custTextMayo) {
        this.custTextMayo.setText(custTextMayo);;
    }

    /*
     * Gets the String value of the peanut butter's quantity in the customize item interface.
     */
    public String getCustTextPeanutB() {
        return custTextPeanutB.getText();
    }

    /*
     * Sets the String value of the peanut butter's quantity in the customize item interface.
     */
    public void setCustTextPeanutB(String custTextPeanutB) {
        this.custTextPeanutB.setText(custTextPeanutB);;
    }

    /*
     * Gets the String value of the strawberry jam's quantity in the customize item interface.
     */
    public String getCustTextStrawberryJ() {
        return custTextStrawberryJ.getText();
    }

    /*
     * Sets the String value of the strawberry jam's quantity in the customize item interface.
     */
    public void setCustTextStrawberryJ(String custTextStrawberryJ) {
        this.custTextStrawberryJ.setText(custTextStrawberryJ);;
    }

    /*
     * Gets the String value of the nutella's quantity in the customize item interface.
     */
    public String getCustTextNutella() {
        return custTextNutella.getText();
    }

    /*
     * Sets the String value of the nutella's quantity in the customize item interface.
     */
    public void setCustTextNutella(String custTextNutella) {
        this.custTextNutella.setText(custTextNutella);;
    }

    /*
     * Gets the String value of the lettuce's quantity in the customize item interface.
     */
    public String getCustTextLettuce() {
        return custTextLettuce.getText();
    }

    /*
     * Sets the String value of the lettuce's quantity in the customize item interface.
     */
    public void setCustTextLettuce(String custTextLettuce) {
        this.custTextLettuce.setText(custTextLettuce);;
    }

    /*
     * Gets the String value of the tomato's quantity in the customize item interface.
     */
    public String getCustTextTomato() {
        return custTextTomato.getText();
    }

    /*
     * Sets the String value of the tomato's quantity in the customize item interface.
     */
    public void setCustTextTomato(String custTextTomato) {
        this.custTextTomato.setText(custTextTomato);;
    }

    /*
     * Gets the String value of the pickle's quantity in the customize item interface.
     */
    public String getCustTextPickle() {
        return custTextPickle.getText();
    }

    /*
     * Sets the String value of the pickle's quantity in the customize item interface.
     */
    public void setCustTextPickle(String custTextPickle) {
        this.custTextPickle.setText(custTextPickle);;
    }

    // Action Listeners for Customize Item ---------------------------------------------------------------------------------------------------

    /**
     * Sets an action listener for when the "+" button was pressed on the customize item panel.
     * this increases the default value of 0(given that the item being customized is not a ham sandwich) to +1 per press.
     * 
     * @param actnListener allows the button to perform an action when interacted with.
     */
    public void setCustPlusHamListener(ActionListener actnListener) {
        this.custPlusHam.addActionListener(actnListener);
    }

    /**
     * Sets an action listener for when the "+" button was pressed on the customize item panel.
     * this increases the default value of 0(given that the item being customized is not a cheese sandwich) to +1 per press.
     * 
     * @param actnListener allows the button to perform an action when interacted with.
     */
    public void setCustPlusCheeseListener(ActionListener actnListener) {
        this.custPlusCheese.addActionListener(actnListener);
    }

    /**
     * Sets an action listener for when the "+" button was pressed on the customize item panel.
     * this increases the default value of 0(given that the item being customized is not a chicken salad sandwich) to +1 per press.
     * 
     * @param actnListener allows the button to perform an action when interacted with.
     */
    public void setCustPlusChickenListener(ActionListener actnListener) {
        this.custPlusChicken.addActionListener(actnListener);
    }

    /**
     * Sets an action listener for when the "+" button was pressed on the customize item panel.
     * this increases the default value of 0(given that the item being customized is not a tuna sandwich) to +1 per press.
     * 
     * @param actnListener allows the button to perform an action when interacted with.
     */
    public void setCustPlusTunaListener(ActionListener actnListener) {
        this.custPlusTuna.addActionListener(actnListener);
    }

    /**
     * Sets an action listener for when the "+" button was pressed on the customize item panel.
     * this increases the default value of 0(given that the item being customized is not an egg salad sandwich) to +1 per press.
     * 
     * @param actnListener allows the button to perform an action when interacted with.
     */
    public void setCustPlusEggListener(ActionListener actnListener) {
        this.custPlusEgg.addActionListener(actnListener);
    }

    /**
     * Sets an action listener for when the "+" button was pressed on the customize item panel.
     * this increases the default value of 0(given that the item being customized is not an egg mayo or chicken salad sandwich) to +1 per press.
     * 
     * @param actnListener allows the button to perform an action when interacted with.
     */
    public void setCustPlusMayoListener(ActionListener actnListener) {
        this.custPlusMayo.addActionListener(actnListener);
    }

    /**
     * Sets an action listener for when the "+" button was pressed on the customize item panel.
     * this increases the default value of 0(given that the item being customized is not a peanut butter sandwich) to +1 per press.
     * 
     * @param actnListener allows the button to perform an action when interacted with.
     */
    public void setCustPlusPeanutBListener(ActionListener actnListener) {
        this.custPlusPeanutB.addActionListener(actnListener);
    }

    /**
     * Sets an action listener for when the "+" button was pressed on the customize item panel.
     * this increases the default value of 0(given that the item being customized is not a strawberry jam sandwich) to +1 per press.
     * 
     * @param actnListener allows the button to perform an action when interacted with.
     */
    public void setCustPlusStrawberryJListener(ActionListener actnListener) {
        this.custPlusStrawberryJ.addActionListener(actnListener);
    }

    /**
     * Sets an action listener for when the "+" button was pressed on the customize item panel.
     * this increases the default value of 0(given that the item being customized is not a nutella sandwich) to +1 per press.
     * 
     * @param actnListener allows the button to perform an action when interacted with.
     */
    public void setCustPlusNutellaListener(ActionListener actnListener) {
        this.custPlusNutella.addActionListener(actnListener);
    }

    /**
     * Sets an action listener for when the "+" button was pressed on the customize item panel.
     * this increases the default value of 0 to +1 per press.
     * 
     * @param actnListener allows the button to perform an action when interacted with.
     */
    public void setCustPlusLettuceListener(ActionListener actnListener) {
        this.custPlusLettuce.addActionListener(actnListener);
    }

    /**
     * Sets an action listener for when the "+" button was pressed on the customize item panel.
     * this increases the default value of 0 to +1 per press.
     * 
     * @param actnListener allows the button to perform an action when interacted with.
     */
    public void setCustPlusTomatoListener(ActionListener actnListener) {
        this.custPlusTomato.addActionListener(actnListener);
    }

    /**
     * Sets an action listener for when the "+" button was pressed on the customize item panel.
     * this increases the default value of 0 to +1 per press.
     * 
     * @param actnListener allows the button to perform an action when interacted with.
     */
    public void setCustPlusPickleListener(ActionListener actnListener) {
        this.custPlusPickle.addActionListener(actnListener);
    }

    //transaction & inventory history ---------------------------------------------------------------------------------------------------

    /**
     * Sets the String value for the money inserted of a transaction entry.
     * 
     * @param showReceiptTransaction is a String value containing the amount of money the user inputted in a transaction entry.
     */
    public void setShowReceiptTransaction(String showReceiptTransaction) {
        this.showReceiptTransaction.setText(showReceiptTransaction);
    }

    /**
     * Sets the String value for the product purchased of a transaction entry.
     * 
     * @param showReceiptProductPurchases is a String value containing the details of the product purchased in a transaction entry.
     */
    public void setShowReceiptProductPurchased(String showReceiptProductPurchased) {
        this.showReceiptProductPurchased.setText(showReceiptProductPurchased);
    }
    
    /**
     * Sets the String value for the produced changed of a transaction entry.
     * 
     * @param showReceiptProducedChange is a String value containing the amount of produced change in a transaction entry.
     */
    public void setShowReceiptProducedChange(String showReceiptProducedChange) {
        this.showReceiptProducedChange.setText(showReceiptProducedChange);
    }

    /**
     * Sets an action listener for when the "Transaction History" button on the Maintenance Mode menu was pressed.
     * This takes the user to panel 19 in the container, allowing access to view the Transaction history.
     * 
     * @param actnListener allows the button to perform an action when interacted with.
     */
    public void setViewTransactionHistory(ActionListener actnListener) {
        this.viewTransactionHistory.addActionListener(actnListener);
    }

    /**
     * Sets an action listener for when the "Inventory History" button on the Maintenance Mode menu was pressed.
     * This takes the user to panel 20 in the container, allowing access to view the Inventory history.
     * 
     * @param actnListener allows the button to perform an action when interacted with.
     */
    public void setViewInventoryHistory(ActionListener actnListener) {
        this.viewInventoryHistory.addActionListener(actnListener);
    }

    /**
     * Sets an action listener for when the "Go Back" button on the Transaction History was pressed.
     * This takes back the user to the maintenance mode menu.
     * 
     * @param actnListener allows the button to perform an action when interacted with.
     */
    public void setGoBackFromTransactionHistory(ActionListener actnListener) {
        this.goBackFromTransactionHistory.addActionListener(actnListener);
    }

    /**
     * Sets an action listener for when the "Go Back" button on the Inventory History was pressed.
     * This takes back the user to the maintenance mode menu.
     * 
     * @param actnListener allows the button to perform an action when interacted with.
     */
    public void setGoBackFromInventoryHistory(ActionListener actnListener) {
        this.goBackFromInventoryHistory.addActionListener(actnListener);
    }

    /**
     * Sets the String value of the text area containing the Inventory History.
     * 
     * @param text is a String value containing the inventory history info.
     */
    public void setContainTransactionHistory(String text)   {
        this.containTransactionHistory.setText(text);
    }

    /**
     * Sets the String value of the text area containing the Inventory History.
     * 
     * @param text is a String value containing the inventory history info.
     */
    public void setContainInventoryHistory(String text)   {
        this.containInventoryHistory.setText(text);
    }

    public void setHamSandAvailabilityR(String hamSandAvailabilityR) {
        this.hamSandAvailabilityR.setText(hamSandAvailabilityR);
    }

    public void setCheeseSandAvailabilityR(String cheeseSandAvailabilityR) {
        this.cheeseSandAvailabilityR.setText(cheeseSandAvailabilityR);
    }
    public void setChickenSandAvailabilityR(String chickenSandAvailabilityR) {
        this.chickenSandAvailabilityR.setText(chickenSandAvailabilityR);
    }

    public void setTunaSandAvailabilityR(String tunaSandAvailabilityR) {
        this.tunaSandAvailabilityR.setText(tunaSandAvailabilityR);
    }

    public void setEggSandAvailabilityR(String eggSandAvailabilityR) {
        this.eggSandAvailabilityR.setText(eggSandAvailabilityR);
    }

    public void setPeanutBSandAvailabilityR(String peanutBSandAvailabilityR) {
        this.peanutBSandAvailabilityR.setText(peanutBSandAvailabilityR);
    }

    public void setStrawberryJSandAvailabilityR(String strawberryJSandAvailabilityR) {
        this.strawberryJSandAvailabilityR.setText(strawberryJSandAvailabilityR);
    }

    public void setNutellaSandAvailabilityR(String nutellaSandAvailabilityR) {
        this.nutellaSandAvailabilityR.setText(nutellaSandAvailabilityR);
    }

    public void setHamSandAvailabilityS(String hamSandAvailabilityS) {
        this.hamSandAvailabilityS.setText(hamSandAvailabilityS);
    }

    public void setCheeseSandAvailabilityS(String cheeseSandAvailabilityS) {
        this.cheeseSandAvailabilityS.setText(cheeseSandAvailabilityS);
    }

    public void setChickenSandAvailabilityS(String chickenSandAvailabilityS) {
        this.chickenSandAvailabilityS.setText(chickenSandAvailabilityS);
    }

    public void setTunaSandAvailabilityS(String tunaSandAvailabilityS) {
        this.tunaSandAvailabilityS.setText(tunaSandAvailabilityS);
    }

    public void setEggSandAvailabilityS(String eggSandAvailabilityS) {
        this.eggSandAvailabilityS.setText(eggSandAvailabilityS);
    }

    public void setPeanutBSandAvailabilityS(String peanutBSandAvailabilityS) {
        this.peanutBSandAvailabilityS.setText(peanutBSandAvailabilityS);
    }

    public void setStrawberryJSandAvailabilityS(String strawberryJSandAvailabilityS) {
        this.strawberryJSandAvailabilityS.setText(strawberryJSandAvailabilityS);
    }

    public void setNutellaSandAvailabilityS(String nutellaSandAvailabilityS) {
        this.nutellaSandAvailabilityS.setText(nutellaSandAvailabilityS);
    }

     public void setMayoAddAvailability(String mayoAddAvailability) {
        this.mayoAddAvailability.setText(mayoAddAvailability);
    }

    public void setTomatoAddAvailability(String tomatoAddAvailability) {
        this.tomatoAddAvailability.setText(tomatoAddAvailability);
    }

    public void setHamAddAvailability(String hamAddAvailability) {
        this.hamAddAvailability.setText(hamAddAvailability);
    }

    public void setCheeseAddAvailability(String cheeseAddAvailability) {
        this.cheeseAddAvailability.setText(cheeseAddAvailability);
    }

    public void setChickenAddAvailability(String chickenAddAvailability) {
        this.chickenAddAvailability.setText(chickenAddAvailability);
    }

    public void setTunaAddAvailability(String tunaAddAvailability) {
        this.tunaAddAvailability.setText(tunaAddAvailability);
    }

    public void setEggAddAvailability(String eggAddAvailability) {
        this.eggAddAvailability.setText(eggAddAvailability);
    }

    public void setPeanutBAddAvailability(String peanutBAddAvailability) {
        this.peanutBAddAvailability.setText(peanutBAddAvailability);
    }

    public void setStrawberryJAddAvailability(String strawberryJAddAvailability) {
        this.strawberryJAddAvailability.setText(strawberryJAddAvailability);
    }

    public void setNutellaAddAvailability(String nutellaAddAvailability) {
        this.nutellaAddAvailability.setText(nutellaAddAvailability);
    }

    public void setLettuceAddAvailability(String lettuceAddAvailability) {
        this.lettuceAddAvailability.setText(lettuceAddAvailability);
    }

    public void setPickleAddAvailability(String pickleAddAvailability) {
        this.pickleAddAvailability.setText(pickleAddAvailability);
    }
}
