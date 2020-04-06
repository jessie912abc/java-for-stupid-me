
package StudentFrame;

import java.awt.Color;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.UIManager;

public class StudentFrame extends JFrame implements ActionListener{
    
    //components
    JButton btn;
    JTextField txt ;
    
    public StudentFrame() {
        super("Student Frame");
    }

    //build interface
    public void createAndShow() throws Exception{
        //add button and text into contain pane
        Container c = getContentPane();
        
        //change the layout
        c.setLayout(new FlowLayout(FlowLayout.LEFT, 5, 5));//flow layout align left, hgap = 5, vgap = 5 
        
        c.add(txt = new JTextField(12));
        c.add(btn = new JButton("Send"));
        btn.addActionListener(this);//set button to handle event
        
        
        //change the look and feel
        UIManager.setLookAndFeel("com.sun.java.swing.plaf.motif.MotifLookAndFeel");
        
        //frame setting
        setVisible(true); // show frame
        setSize(300,200); //set width, height
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //frame exit when click X button
    }
    
    //Event Handler by ActionListener
    @Override
    public void actionPerformed(ActionEvent e) {
        JFileChooser fc = new JFileChooser();
        fc.setMultiSelectionEnabled(false); //not allow to choose multiple file
        if(fc.showOpenDialog(null) == JFileChooser.APPROVE_OPTION){
            //get selected file name
            File f = fc.getSelectedFile();
            txt.setText(f.getAbsolutePath());
        }
    }
    public static void main(String[] args) throws Exception {
        new StudentFrame().createAndShow();
    }

    
}
