import java.awt.BorderLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class FactoryView extends JFrame{
    
    private JButton RegularVM;
    private JButton SpecialVM;


    //JFrame
    public FactoryView(){
        super("Factory");
        setLayout(new BorderLayout());
        setSize(550, 700);

        setVisible(true);
        setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

}