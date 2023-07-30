import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class FactoryView extends JFrame{
    //panels
    private JPanel buyMainPanel;
    private JPanel buySubPanel1;
    private JPanel buySubPanel2;

    //interactables
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
    private JButton minus1;
    private JButton minus5;
    private JButton minus10;
    private JButton minus20;
    private JButton minus50;
    private JButton minus100;
    private JButton minus200;
    private JButton minus500;
    private JButton minus1000;
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
    private JButton cancelPayment;
    private JTextField currentAmount;

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

     private JTextField breadQuant;
     private JTextField hamQuant;
     private JTextField cheeseQuant;
     private JTextField chickenQuant;
     private JTextField tunaQuant;
     private JTextField eggQuant;
     private JTextField mayoQuant;
     private JTextField peanutBQuant;
     private JTextField strawberryJQuant;
     private JTextField nutellaQuant;
     private JTextField lettuceQuant;
     private JTextField tomatoQuant;
     private JTextField pickleQuant;

     private JButton plusBread;
     private JButton plusHam;
     private JButton plusCheese;
     private JButton plusChicken;
     private JButton plusTuna;
     private JButton plusEgg;
     private JButton plusMayo;
     private JButton plusPeanutB;
     private JButton plusStrawberryJ;
     private JButton plusNutella;
     private JButton plusLettuce;
     private JButton plusTomato;
     private JButton plusPickle;
     private JButton confirmRestock;

     private JPanel layoutRestock;

    //ADDITIONAL COMPONENTS FOR MAINTENANCE MODE WINDOW - SVM

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

    //misc.
    private GridBagConstraints gbc;
    private CardLayout cl;          //sets the card layout
    private Container container;    //uh lalagyan?
    private GridBagConstraints gbc2;
    private GridBagConstraints gbc3;
    private JButton filler;

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
    private JLabel displayBlank6;
    private JLabel displayBlank7;
    private ImageIcon background_image_plain;

    public FactoryView(){
        super("CCPROG3 MCO2");

        //misc.
        gbc = new GridBagConstraints();
        gbc.insets = new Insets(0, 0, 0, 0);
        container = getContentPane();
        gbc2 = new GridBagConstraints();
        gbc2.insets = new Insets(0, 5, 10, 5);
        filler = new JButton("");
        
        //panels
        buyMainPanel = new JPanel();
        buyMainPanel.setLayout(new GridLayout(2, 1, 10, 25));
        buySubPanel1 = new JPanel();
        buySubPanel1.setLayout(new GridLayout(9, 4, 5, 5));
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
    }

    //display interface methods
    public void displayCreateVM() {
        cl.show(container, "2");
    }
    public void displayTestVM(){
        cl.show(container, "3");
     }
     public void displayFactoryView()  {
        cl.show(container, "1");
     }
     public void displayBuyItemInterface(){
        cl.show(container, "4");
     }
     public void displayRVMInterface(){
        cl.show(container, "5");
     }
     public void displaySVMInterface(){
        cl.show(container, "6");
     }
     public void displayMaintenanceInterface(){
        cl.show(container, "7");
     }
     public void displayRestockItemRVM(){
        cl.show(container, "8");
     }
     public void displayRestockItemSVM(){
        cl.show(container, "9");
     }

    //build methods
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

    public void buildBuyItem(){
        //interface for BUY ITEM
        background_image_buy = new ImageIcon("moneymenu.png");
        Image img3 = background_image_buy.getImage();
        Image temp_img3 = img3.getScaledInstance(550, 700, Image.SCALE_SMOOTH);
        background_image_buy = new ImageIcon(temp_img3);
        displayFieldBuy = new JLabel("", background_image_buy, JLabel.CENTER);
        displayFieldBuy.setLayout(new GridBagLayout());

        peso1 = new JLabel("insert 1: ", SwingConstants.RIGHT);
        peso5 = new JLabel("insert 5: ", SwingConstants.RIGHT);
        peso10 = new JLabel("insert 10: ", SwingConstants.RIGHT);
        peso20 = new JLabel("insert 20: ", SwingConstants.RIGHT);
        peso50 = new JLabel("insert 50: ", SwingConstants.RIGHT);
        peso100 = new JLabel("insert 100: ", SwingConstants.RIGHT);
        peso200 = new JLabel("insert 200: ", SwingConstants.RIGHT);
        peso500 = new JLabel("insert 500: ", SwingConstants.RIGHT);
        peso1000 = new JLabel("insert 1000: ", SwingConstants.RIGHT);

        plus1 = new JButton("+");
        plus5 = new JButton("+");
        plus10 = new JButton("+");
        plus20 = new JButton("+");
        plus50 = new JButton("+");
        plus100 = new JButton("+");
        plus200 = new JButton("+");
        plus500 = new JButton("+");
        plus1000 = new JButton("+");
        minus1 = new JButton("-");
        minus5 = new JButton("-");
        minus10 = new JButton("-");
        minus20 = new JButton("-");
        minus50 = new JButton("-");
        minus100 = new JButton("-");
        minus200 = new JButton("-");
        minus500 = new JButton("-");
        minus1000 = new JButton("-");

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
        buySubPanel1.add(minus1);
        buySubPanel1.add(quant1);
        buySubPanel1.add(plus1);
        buySubPanel1.add(peso5);
        buySubPanel1.add(minus5);
        buySubPanel1.add(quant5);
        buySubPanel1.add(plus5);
        buySubPanel1.add(peso10);
        buySubPanel1.add(minus10);
        buySubPanel1.add(quant10);
        buySubPanel1.add(plus10);
        buySubPanel1.add(peso20);
        buySubPanel1.add(minus20);
        buySubPanel1.add(quant20);
        buySubPanel1.add(plus20);
        buySubPanel1.add(peso50);
        buySubPanel1.add(minus50);
        buySubPanel1.add(quant50);
        buySubPanel1.add(plus50);
        buySubPanel1.add(peso100);
        buySubPanel1.add(minus100);
        buySubPanel1.add(quant100);
        buySubPanel1.add(plus100);
        buySubPanel1.add(peso200);
        buySubPanel1.add(minus200);
        buySubPanel1.add(quant200);
        buySubPanel1.add(plus200);
        buySubPanel1.add(peso500);
        buySubPanel1.add(minus500);
        buySubPanel1.add(quant500);
        buySubPanel1.add(plus500);
        buySubPanel1.add(peso1000);
        buySubPanel1.add(minus1000);
        buySubPanel1.add(quant1000);
        buySubPanel1.add(plus1000);

        currentAmount = new JTextField();
        currentAmount.setHorizontalAlignment(JTextField.CENTER);
        currentAmount.setEditable(false);
        currentAmount.setOpaque(false);
        currentAmount.setPreferredSize(new Dimension(300, 100));
        Font font = new Font(currentAmount.getFont().getName(), currentAmount.getFont().getSize(), 16);
        currentAmount.setFont(font);
        confirmPayment = new JButton("Confirm");
        cancelPayment = new JButton("Cancel");
        // confirmPayment.setOpaque(false);
        // confirmPayment.setFocusPainted(false);
        // confirmPayment.setContentAreaFilled(false);
        // confirmPayment.setBorderPainted(true);
        // confirmPayment.setBorder(BorderFactory.createEtchedBorder(0));

        buySubPanel2.add(confirmPayment);
        buySubPanel2.add(cancelPayment);
        buySubPanel2.add(currentAmount);

        buySubPanel1.setOpaque(false);
        buySubPanel2.setOpaque(false);
        buyMainPanel.setOpaque(false);

        buyMainPanel.add(buySubPanel1);
        buyMainPanel.add(buySubPanel2);
        displayFieldBuy.add(buyMainPanel);

        container.add(displayFieldBuy, "4");
    }

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

     public void buildRestockItemsRVM(){
        background_image_plain = new ImageIcon("plainbg.png");
        Image img6 = background_image_plain.getImage();
        Image temp_img6 = img6.getScaledInstance(550, 700, Image.SCALE_SMOOTH);
        background_image_plain = new ImageIcon(temp_img6);
        displayBlank1 = new JLabel("", background_image_plain, JLabel.CENTER);
        displayBlank1.setLayout(new GridBagLayout());
        layoutRestock = new JPanel(new GridLayout(11, 3, 5, 5));

        layoutRestock.setOpaque(false);

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

        breadQuant = new JTextField();
        hamQuant = new JTextField();
        cheeseQuant = new JTextField();
        chickenQuant = new JTextField();
        tunaQuant = new JTextField();
        eggQuant = new JTextField();
        mayoQuant = new JTextField();
        peanutBQuant = new JTextField();
        strawberryJQuant = new JTextField();
        nutellaQuant = new JTextField();

        plusBread = new JButton("+");
        plusHam = new JButton("+");
        plusCheese = new JButton("+");
        plusChicken = new JButton("+");
        plusTuna = new JButton("+");
        plusEgg = new JButton("+");
        plusMayo = new JButton("+");
        plusPeanutB = new JButton("+");
        plusStrawberryJ = new JButton("+");
        plusNutella = new JButton("+");
        confirmRestock = new JButton("Confirm");

        layoutRestock.add(restockBread);
        layoutRestock.add(breadQuant);
        layoutRestock.add(plusBread);
        layoutRestock.add(restockHam);
        layoutRestock.add(hamQuant);
        layoutRestock.add(plusHam);
        layoutRestock.add(restockCheese);
        layoutRestock.add(cheeseQuant);
        layoutRestock.add(plusCheese);
        layoutRestock.add(restockChicken);
        layoutRestock.add(chickenQuant);
        layoutRestock.add(plusChicken);
        layoutRestock.add(restockTuna);
        layoutRestock.add(tunaQuant);
        layoutRestock.add(plusTuna);
        layoutRestock.add(restockEgg);
        layoutRestock.add(eggQuant);
        layoutRestock.add(plusEgg);
        layoutRestock.add(restockMayo);
        layoutRestock.add(mayoQuant);
        layoutRestock.add(plusMayo);
        layoutRestock.add(restockPeanutButter);
        layoutRestock.add(peanutBQuant);
        layoutRestock.add(plusPeanutB);
        layoutRestock.add(restockStrawberryJam);
        layoutRestock.add(strawberryJQuant);
        layoutRestock.add(plusStrawberryJ);
        layoutRestock.add(restockNutella);
        layoutRestock.add(nutellaQuant);
        layoutRestock.add(plusNutella);

        // filler.setContentAreaFilled(false);
        // filler.setFocusPainted(false);
        // filler.setBorderPainted(false);

        // layoutRestock.add(filler);

        layoutRestock.add(confirmRestock);

        displayBlank1.add(layoutRestock);

        container.add(displayBlank1, "8");
     }

     public void buildRestockItemsSVM(){
        background_image_plain = new ImageIcon("plainbg.png");
        Image img6 = background_image_plain.getImage();
        Image temp_img6 = img6.getScaledInstance(550, 700, Image.SCALE_SMOOTH);
        background_image_plain = new ImageIcon(temp_img6);
        displayBlank2 = new JLabel("", background_image_plain, JLabel.CENTER);
        displayBlank2.setLayout(new GridBagLayout());
        layoutRestock = new JPanel(new GridLayout(14, 3, 5, 5));

        layoutRestock.setOpaque(false);

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

        breadQuant = new JTextField();
        hamQuant = new JTextField();
        cheeseQuant = new JTextField();
        chickenQuant = new JTextField();
        tunaQuant = new JTextField();
        eggQuant = new JTextField();
        mayoQuant = new JTextField();
        peanutBQuant = new JTextField();
        strawberryJQuant = new JTextField();
        nutellaQuant = new JTextField();
        lettuceQuant = new JTextField();
        tomatoQuant = new JTextField();
        pickleQuant = new JTextField();

        plusBread = new JButton("+");
        plusHam = new JButton("+");
        plusCheese = new JButton("+");
        plusChicken = new JButton("+");
        plusTuna = new JButton("+");
        plusEgg = new JButton("+");
        plusMayo = new JButton("+");
        plusPeanutB = new JButton("+");
        plusStrawberryJ = new JButton("+");
        plusNutella = new JButton("+");
        plusLettuce = new JButton("+");
        plusTomato = new JButton("+");
        plusPickle = new JButton("+");
        confirmRestock = new JButton("Confirm");

        layoutRestock.add(restockBread);
        layoutRestock.add(breadQuant);
        layoutRestock.add(plusBread);
        layoutRestock.add(restockHam);
        layoutRestock.add(hamQuant);
        layoutRestock.add(plusHam);
        layoutRestock.add(restockCheese);
        layoutRestock.add(cheeseQuant);
        layoutRestock.add(plusCheese);
        layoutRestock.add(restockChicken);
        layoutRestock.add(chickenQuant);
        layoutRestock.add(plusChicken);
        layoutRestock.add(restockTuna);
        layoutRestock.add(tunaQuant);
        layoutRestock.add(plusTuna);
        layoutRestock.add(restockEgg);
        layoutRestock.add(eggQuant);
        layoutRestock.add(plusEgg);
        layoutRestock.add(restockMayo);
        layoutRestock.add(mayoQuant);
        layoutRestock.add(plusMayo);
        layoutRestock.add(restockPeanutButter);
        layoutRestock.add(peanutBQuant);
        layoutRestock.add(plusPeanutB);
        layoutRestock.add(restockStrawberryJam);
        layoutRestock.add(strawberryJQuant);
        layoutRestock.add(plusStrawberryJ);
        layoutRestock.add(restockNutella);
        layoutRestock.add(nutellaQuant);
        layoutRestock.add(plusNutella);
        layoutRestock.add(restockLettuce);
        layoutRestock.add(lettuceQuant);
        layoutRestock.add(plusLettuce);
        layoutRestock.add(restockTomato);
        layoutRestock.add(tomatoQuant);
        layoutRestock.add(plusTomato);
        layoutRestock.add(restockPickle);
        layoutRestock.add(pickleQuant);
        layoutRestock.add(plusPickle);

        // filler.setContentAreaFilled(false);
        // filler.setFocusPainted(false);
        // filler.setBorderPainted(false);

        // layoutRestock.add(filler);

        layoutRestock.add(confirmRestock);

        displayBlank2.add(layoutRestock);

        container.add(displayBlank2, "9");
     }

     //for JOptionPanes
     public void dispSelectItem(){
        selectItemRVM = new JOptionPane();
        int resultSelectItem = JOptionPane.showConfirmDialog(null, "Purchase item?", "System Message", JOptionPane.YES_NO_OPTION);

        if(resultSelectItem == JOptionPane.YES_OPTION){
            
        }
     }

     public void dispCustomizeItem(){
        selectItemSVM = new JOptionPane();
        int resultCustomizeItem = JOptionPane.showConfirmDialog(null, "Customize item?", "System Message", JOptionPane.YES_NO_CANCEL_OPTION);
     }

     public void dispErrorTestVM(){
        JOptionPane.showMessageDialog(null, "No Vending Machine Created!", "Error", JOptionPane.ERROR_MESSAGE);
        
     }

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
    public void setRestockListener(ActionListener actnListener)    {
        this.restockItems.addActionListener(actnListener);
    }


}