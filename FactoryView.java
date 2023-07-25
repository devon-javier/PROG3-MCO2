import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class FactoryView extends JFrame{
    //panels
    private JPanel mainPanel;

    //interactables
    private JButton RegularVM;
    private JButton SpecialVM;

    //misc.
    private GridBagConstraints gbc;

    //listeners
    private ActionListener btnListener;

    //for background image
    private JLabel displayField;
    private ImageIcon background_image;

    public FactoryView(){
        super("CCPROG3 MCO2");

        //panels
        mainPanel = new JPanel();
        mainPanel.setLayout(new GridBagLayout());

        //misc.
        gbc = new GridBagConstraints();
        gbc.insets = new Insets(10, 5, 10, 5);

        //buttons + button adds
        RegularVM = new JButton("Regular");
        RegularVM.setPreferredSize(new Dimension(150, 50));
        RegularVM.setFont(new Font("TimesRoman", Font.BOLD, 20));
        RegularVM.setForeground(Color.decode("#B47EDE"));
        gbc.gridy = 0;
        gbc.gridx = 0;
        mainPanel.add(RegularVM, gbc);

        SpecialVM = new JButton("Special");
        SpecialVM.setPreferredSize(new Dimension(150, 50));
        SpecialVM.setFont(new Font("TimesRoman", Font.BOLD, 20));
        SpecialVM.setForeground(Color.decode("#B47EDE"));
        gbc.gridy = 1;
        gbc.gridx = 0;
        mainPanel.add(SpecialVM, gbc);

        //bg image
        background_image = new ImageIcon("phone4.png");
        Image img = background_image.getImage();
        Image temp_img = img.getScaledInstance(550, 700, Image.SCALE_SMOOTH);
        background_image = new ImageIcon(temp_img);
        displayField = new JLabel("", background_image, JLabel.CENTER);
        displayField.setBounds(0, 0, 550, 700);

        //other adds
        this.add(displayField);
        this.add(mainPanel);

        //frame config
        this.setVisible(true);
        this.setSize(550, 700);
        this.setResizable(false);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
    }

    public void btnListener(){
        btnListener = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e){

            }
        };
    }

}
