import javax.swing.*;


    public class main 
    {       
        public static void main(String[] args) 
        {
            //creates object for LanguageGUI class
            LanguageGUI lg = new LanguageGUI();

            //this exits the JFrame when the user closes it
            lg.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

            /*sizes Jframe to ensure that all of the contents 
            are at or above their preferred sizes
            */
            lg.pack();

            //sets size of JFrameto 450 x 150
            lg.setSize(450,150);

            //makes JFrame visible
            lg.setVisible(true);
        }
    
    }
