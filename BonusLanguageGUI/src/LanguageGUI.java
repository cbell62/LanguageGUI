
//My Imports
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import javax.swing.JButton;
import javax.swing.JColorChooser;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.Timer;


public class LanguageGUI extends JFrame implements ActionListener{

    //My Fields
    private List<String> englishlines, mandarinlines;
    private JLabel instruct;
    private JTextField instruct1;
    private JLabel randomg;
    private JLabel fortyniners;
    private JButton transButton;
    private JButton dictionary;
    private Timer myTimer;
    private Timer timer;
    public int k;
    public int count=0;
    public int times=0;
    public int incorr=0;
   
     
    //creates button to change background color
    JButton colorButton = new JButton("Background Color");
    
    //creates a container 
    Container c = getContentPane();
    
    //creates button to change text color     
    JButton textcButton = new JButton("Text Color");
    
    //creates a container     
    Container s = getContentPane();  
       
    //creates the constructor
    LanguageGUI()
    {
      
      
        getArrayList(); //calls the getArrayList method
      
        //sets layout for container 
        c.setLayout(new FlowLayout()); 
  
        /*adds ActionListener to JButton colorButton to give it an 
        action listen that will then open a colorchooser panel when pressed
        */
        colorButton.addActionListener(this); 
        
        //adds the container(which has color palette) to colorButton
        c.add(colorButton);
        
        //sets layout for container 
        s.setLayout(new FlowLayout());
        
        /*adds ActionListener to JButton textcButton to give it an 
        action listen that will then open a colorchooser panel when pressed
        */
        textcButton.addActionListener(this); 
        
        //adds the container(which has color palette) to textcButton 
        s.add(textcButton);
        
     GridBagConstraints positionConst = null;
     
        myTimer = new Timer(5000, this); //creates a timer of five seconds called myTimer
        myTimer.start(); //starts the timer called myTimer
        
        //creates a new timer of 3 seconds called timer and sets it equal to the counter class called resetClass
        timer = new Timer(3000,new resetClass());
     
        //sets title of JFrame
        setTitle("eLearn");
        
        //sets layout of JFrame
        setLayout(new GridBagLayout());
        
        //creats new JLabel called instruct
        instruct = new JLabel("Welcome to eLearn!");
    
        
        //sets size for JLabel called instruct
        instruct.setSize(100,100);
        
        //sets JLabel position and adds it to/on the JFrame
        add(instruct, positionConst);
        
        //creates new JTextField called instruct1
        instruct1 = new JTextField();
        
        k = getRandomNumber(); 
        
        /*creates new JLabel called randomg and sets it equal to the
        String within one of the arrayLists at the random number 
        */
        randomg = new JLabel(getRandom(k));
       
        /* creates new JLabel caled fortyniners and sets it equal to the 
        percentage that the user has gotten correct
        
        */
        fortyniners = new JLabel("You Got This!");
        
        //creates new JButton called instruct1
        transButton = new JButton("Ok");
        
        /*adds ActionListener to JButton transButton give it an action listen 
        that will then grab the text within the textfield when pressed
        */
        transButton.addActionListener(this);
        
      
     
        //creates new object for GridBagConstraints
        positionConst = new GridBagConstraints();

        // Specify component's grid location
        positionConst.gridx = 0;
        positionConst.gridy = 0;
      
        // 10 pixels of padding around component
        positionConst.insets = new Insets(10, 10, 10, 10);
            
        //Specifies grid location of JLabel randomg
        positionConst.gridx=0;
        positionConst.gridy=2;

        //creates 10 pixels of padding around JLabel
        positionConst.insets = new Insets(10,10,10,10);
            
        //adds the grid location to the JLabel randomg
        add(randomg,positionConst);
        
        //Specifies grid location of JLabel fortyniners
        positionConst.gridx=1;
        positionConst.gridy=0;
        
        //creates 10 pixels of padding around JLabel
        positionConst.insets = new Insets(10,10,10,10);
        
        //adds the grid location to the JLabel fortyniners
        add(fortyniners,positionConst);
        
        // Specifies JTextField instruct1 grid's location
        positionConst.gridx = 1;
        positionConst.gridy = 2;
        
        //sets size of JTextField instruct1
        instruct1.setPreferredSize(new Dimension(100,25));
        instruct1.setMinimumSize(new Dimension(100,25));
        
        //makes JTextField instruct1 editable
        instruct1.setEditable(true);
            
        //adds the grid location to the JTextField instruct1
        add(instruct1,positionConst);
            
        //adds ActionListener to JTextField instruct1
        instruct1.addActionListener(this);
            
        // Specifies the grid's location of the JButton called transButton 
        positionConst.gridx=2;
        positionConst.gridy=2;
            
        //creates 10 pixels of padding around JButton called transButton
        positionConst.insets = new Insets(10,10,10,10);
            
        //adds the grid location to the JButton called transButton 
        add(transButton,positionConst);
        
        
        // Specifies the grid's location of the JButton called colorButton
        positionConst.gridx=0;
        positionConst.gridy=3;
            
        //creates 10 pixels of padding around JButton called colorButton
        positionConst.insets = new Insets(10,10,10,10);
            
        //adds the grid location to the JButton called colorButton
        add(colorButton,positionConst);
            
        // Specifies the grid's location of the JButton called textcButton
        positionConst.gridx=1;
        positionConst.gridy=3;
            
        //creates 10 pixels of padding around JButton called textcButton
        positionConst.insets = new Insets(10,10,10,10);
            
        //adds the grid location to the JButton called textcButton
        add(textcButton,positionConst);
        
    }
    
    @Override
    public void actionPerformed(ActionEvent e) 
    {    showCorrect();//calls the showCorrect method
        myTimer.stop(); //stops the first timer of five seconds
        timer.start(); //this starts the second timer  
           
        //if the button colorButton is pressed, then this happens
        if (e.getSource()==colorButton)
        {
            //pops the JColorChooser Panel up
            Color color = JColorChooser.showDialog(this,"Select a background color", Color.WHITE); 

            //sets the Background color of the JFrame to whatever color the user chooses
            c.setBackground(color);
        
        }
        
        //if the button textcButton is clicked then this happens
        else if (e.getSource()==textcButton)
         {
            //pops the JColorChooser Panel up
            Color textcolor = JColorChooser.showDialog(this, "Select a text color", Color.BLACK);
            
            /*sets the text color of the textcButton JButton, the colorButton
            JButton, the instruct JLabel, the randomg JLabel, and the transButton to 
            whatever color the user chooses. 
            */
            textcButton.setForeground(textcolor); 
            colorButton.setForeground(textcolor);
            instruct.setForeground(textcolor);
            randomg.setForeground(textcolor);
            transButton.setForeground(textcolor);
            fortyniners.setForeground(textcolor);
         }
      
        
       
    }
    

    /*this method is to put each of the two text files in an arraylist 
    and read the lines of both files into their arraylist and then set the two
    ArrayList fields in the constructor to the two arraylists. It also has a
    try catch block around the code that reads the lines of each text file in
    to catch an IO Exception if there is one
    */  
    public void getArrayList()
    {  
        //creates the arraylists for the text file called English.txt
        ArrayList<String> englishlines = new ArrayList<>();

        //creates the arraylists for the text file called Mandarin.txt
        ArrayList<String> mandarinlines = new ArrayList<>();
        
        
        try 
        {  
            File file = new File("English.txt"); //open the file
            Scanner inputFile = new Scanner(file); //read the file using the Scanner class
            File file1 = new File("Mandarin.txt"); //open the file
            Scanner inputFile1 = new Scanner(file1); //read the file using the Scanner class
          
            while(inputFile.hasNext())
            {
               englishlines.add(inputFile.nextLine());
            }
            
            while(inputFile1.hasNext())
            {
               mandarinlines.add(inputFile1.nextLine());
            }
            
        } 
    
        // to catch the IOException if there is one
        catch (IOException e) 
        {
            /*if an IOException is caught. This will print out a message
            saying "Caught IOException" and then the reason why there 
            is an IOException
            */
            System.out.println("Caught IOException" + e.getMessage());
        }
        
        //this sets the two ArrayList fields in the constructor to the two ArrayLists
        this.englishlines = englishlines;
        this.mandarinlines = mandarinlines;
    }
    

    
    /*this method is to create an int variable called random
    and to create a random number generator that will generate 
    a number between 0 and 7 and then return it to the int 
    variable random in order to determine line number.
    */
    public int getRandomNumber()
    {
        int random;
        random = (int)(Math.random() * englishlines.size());       
        return random;
    }
    
    /* this method creates an int variable called ran to generate a number between 0 and 1 and 
    that is going to be used to randomize and determine what language the
    word the user has to translate is going to be in and it returns the value to ran.
    */
    public int getLanguage()
    {
      int ran; //creates int variable called ran
      ran = (int)(Math.random() * 2);  //generates number between 0 and 1
      return ran; //returns that number to the variable ran
        
    }
    
    /*
    This method is to get the line number from the file of whatever language 
    the word the user has to translate to another language will be in. 
    */
    public String getRandom(int k)
    {
        String x=""; //creates a string variable
       
        /*this states that if in the method getLanguage the number generated is 
        0 then the language is english and it calls get random number method
        to get the word from that file and if it generates the nnumber 1 in the 
        method getLanguage then the language is mandarin and calls get random 
        number to get the word from that particular file
        */
        if(getLanguage() == 0)
        {
           x=englishlines.get(k);
        }
        else
        {
          x= mandarinlines.get(k);
        }
        return x; //returns the string to that variable
    }
    
    //this method is to reset the gui after the second timer of three seconds has finished
    public void reset()
     {
         k = getRandomNumber(); 
         randomg.setText(getRandom(k));
         instruct1.setText("");
         instruct.setText("Welcome to eLearn!");
         instruct1.setEditable(true);
         if(times != 0)
         {   
         fortyniners.setText(((double)count/(double)times)*100 + "%");
         }
         else
         {  
         }
     }
     
    //this method is to check if user is correct or not
     public void showCorrect()
     {
        //this increments the total amount of times it is played
        times++;
       
        String text; // this creates a String variable names text
        text=randomg.getText(); //this gets the text of the JLabel randomg
           
        String userInput; //creates string variable called userInput
        
        userInput = instruct1.getText(); //gets the text of the userInput from the JText field
        
        String z = " "; //creates string variable called z
         
        if(englishlines.contains(text))
        {
           z = mandarinlines.get(k);
        }
        else
        {
            z=englishlines.get(k);
        }
        //this if statement determines whether or not userinput is correct or not and updates label 
        if(userInput.equalsIgnoreCase(z))
        {
        //this will update label instruct to say correct if useriput is correct
        instruct.setText("Correct!"); 
        
        // this increments count by 1
        count++;
        
        //this updates the label fortyniners to say correct and updates the number of times they have been correct
        fortyniners.setText("Right: " + count);
        }
        
        else
        {
        //this will update label as well as have the correct answer after the plus if userinput was wrong
        instruct.setText("Incorrect Answer: " + z);
        
        //this increments count by 1
        incorr++;
        
        //this updates the label fortyniners to say correct and updates the number of times they have been incorrect
        fortyniners.setText("Wrong: " + incorr);
        }
        
        //this makes the instruct1 textfield ineditable so user cannot edit anything
        instruct1.setEditable(false);
     }
     
     //this is the counter class for the second timer
     class resetClass implements ActionListener
     {
         public void actionPerformed(ActionEvent ae)
         {
             reset(); // this calls the reset method
             timer.stop(); //this stops the second timer of three seconds
             myTimer.start(); //this starts the first timer back up again
         }
     }
   
}


  

