import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class FactoryView extends JFrame{
    //panels
    private JPanel mainPanel;       //main panel that shows create or test a vending machine
    private JPanel createPanel;     //panel that shows when create panel is chosen
    private JPanel testPanel;       //panel that shows when test panel is chosen
    private JPanel passPanel;       //panel that shows when you've chosen a vending machine to create

    //interactables
    private JButton createVM;
    private JButton testVM;
    private JButton regularVM;
    private JButton specialVM;
    private JButton createPass;
    private JTextField password;

    //misc.
    private GridBagConstraints gbc;
    private CardLayout cl;          //sets the card layout
    private Container container;    //uh lalagyan?

    //for background image
    private JLabel displayField;
    private ImageIcon background_image;
    private JLabel displayFieldCreate;
    private ImageIcon background_image_create;
    private JLabel displayFieldPass;
    private ImageIcon background_image_pass;
    

    public FactoryView(){
        super("CCPROG3 MCO2");

        //misc.
        gbc = new GridBagConstraints();
        gbc.insets = new Insets(20, 5, 10, 5);
        container = getContentPane();

        //panels
        mainPanel = new JPanel();
        mainPanel.setLayout(new GridBagLayout());
        createPanel = new JPanel();
        createPanel.setLayout(new GridBagLayout());
        cl = new CardLayout();
        container.setLayout(cl);
        passPanel = new JPanel();
        passPanel.setLayout(new GridBagLayout());

        //bg images
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
        background_image_pass = new ImageIcon("phonepass.png");
        Image img2 = background_image_pass.getImage();
        Image temp_img2 = img2.getScaledInstance(550, 700, Image.SCALE_SMOOTH);
        background_image_pass = new ImageIcon(temp_img2);
        displayFieldPass = new JLabel("", background_image_pass, JLabel.CENTER);
        displayFieldPass.setLayout(new GridBagLayout());

        //text field (FOR CREATE PASSWORD)
        password = new JTextField();

        //buttons + button adds -------------------------------------------- (FOR MAIN FACTORY MENU)
        createVM = new JButton("Create a Vending Machine");
        createVM.setOpaque(false);
        createVM.setFocusPainted(false);
        createVM.setBorder(BorderFactory.createEtchedBorder(0));
        createVM.setPreferredSize(new Dimension(220, 50));
        createVM.setFont(new Font("TimesRoman", Font.BOLD, 16));
        gbc.gridy = 0;
        gbc.gridx = 0;
        displayField.add(createVM, gbc);

        testVM = new JButton("Test a Vending Machine");
        testVM.setOpaque(false);
        testVM.setFocusPainted(false);
        testVM.setBorder(BorderFactory.createEtchedBorder(0));
        testVM.setPreferredSize(new Dimension(220, 50));
        testVM.setFont(new Font("TimesRoman", Font.BOLD, 16));
        gbc.gridy = 1;
        gbc.gridx = 0;
        displayField.add(testVM, gbc);

        //buttons + button adds -------------------------------------------- (FOR TEST VENDING MACHINE)

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

        //buttons + button adds -------------------------------------------- (FOR CREATE PASS MENU)
        createPass = new JButton("Confirm Password");

        //other adds
        container.add(displayField, "1");
        container.add(displayFieldCreate, "2");
        container.add(displayFieldPass, "4");
        cl.show(container, "1");

        //frame config
        this.setVisible(true);
        this.setSize(550, 700);
        this.setResizable(false);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);


        /*
        //action listeners idk how to implement them sa controller cuz di narread e
        createVM.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            cl.show(container, "2"); // Show createPanel
            
        }
    });
        
        testVM.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            cl.show(container, "3"); // Show testPanel
            
        }
    });
        */
    }

    //button listeners
    // public void setCreateVMListener(ActionListener actnListener)    {
    //    this.createVM.addActionListener(actnListener);
    // }
    
    // public void setTestVMListener(ActionListener actnListener)    {
    //    this.testVM.addActionListener(actnListener);
    // }

    public void setCreateVMListener()    {
        createVM.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cl.show(container, "2"); // Show createPanel
                
            }
        });
    }

    public void setTestVMListener()  {
        testVM.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cl.show(container, "3"); // Show testPanel
                
            }
        });
    }
    
    public void setRegularVMBtnListener(ActionListener actnListener)    {
       this.regularVM.addActionListener(actnListener);
    }

    public void setSpecialVMBtnListener(ActionListener actnListener)    {
        this.specialVM.addActionListener(actnListener);
    }

}


//SCRAP LANG -------------------------------------------------------------------------------------

//private ImageIcon[] backgroundImages;   // Array to store multiple background images
//private int currentImageIndex;          // Index to keep track of the current background image
// backgroundImages = new ImageIcon[2];
//         backgroundImages[0] = new ImageIcon("phone4.png");
//         backgroundImages[1] = new ImageIcon("phone3.png"); // Add more images if needed
//         displayField = new JLabel("", backgroundImages[0], JLabel.CENTER);
//         displayField.setBounds(0, 0, 550, 700);
//currentImageIndex = 0; // Start with the first image
// currentImageIndex = (currentImageIndex + 1) % backgroundImages.length;
//             displayField.setIcon(backgroundImages[currentImageIndex]);
// currentImageIndex = (currentImageIndex + 1) % backgroundImages.length;
//             displayField.setIcon(backgroundImages[currentImageIndex]);