import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import java.awt.Label;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
//import javax.swing.addActionListener;

public class AdminWindow extends Menu{

    public static int addFlag;
    public static int delFlag;
    public static int dispFlag;
    public static String name = "shit";
    public static float price = 420;
    public static int calories = 666;
    public static int delItemNo;
    public static Cafe cafe = new Cafe();
    public static Menu m1 = new Menu();
    public static CafeInterface ci = new CafeInterface();
    
    public static void main(String args[]){
         addFlag=1;
         dispFlag=1;
         delFlag=1;
       

        //JOptionPane.showMessageDialog(null, "Your device will be terminated", "Device Termination Sequence",JOptionPane.WARNING_MESSAGE);
        JFrame frame2 = new JFrame();
         frame2.setLayout(null);
        Label label1 = new Label("Hello");
         label1.setBounds(10, 100, 150, 200);
         frame2.add(label1);

        JTextField textField= new JTextField("Choose operation");
         textField.setBounds(10, 250, 150, 200);
         frame2.add(textField);
        

        JButton add = new JButton("Add item");
        frame2.add(add);
        add.setBounds(10, 50, 100, 20);
        add.setFocusable(false);

        //add demo item (DELETE IN FINAL OUTPUT)
        //Items item1 = new Items("cookie", 49, 4500);
       //m1.AddItem(item1);
         //add button logic
        add.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Perform actions when the "Add item" button is clicked
                //JOptionPane.showMessageDialog(frame2, "Add item functionality goes here!");

                /*JButton next = new JButton("OK");
                frame2.add(next);
                frame2.setBounds(100, 70, 100, 20);*/
          

                        switch (addFlag) {
                        case 1:
                        textField.setText(null);
                        add.setText("Next");
                        label1.setText("Enter name");
                    
                        addFlag = addFlag+1;
                        // System.out.println(addFlag);
                        break;

              
                        case 2:
                        name = textField.getText();
                        textField.setText(null);
                        label1.setText("Enter the price");
                        
                        addFlag = addFlag+1;
                        break;


                        case 3:

                        try {
                            // Get the text from the TextField
                            String inputText = textField.getText();
        
                            // Convert the text to a float
                             price  = Float.parseFloat(inputText);
        
                            // Use the float value as needed
                           // System.out.println("Float value: " + price);
                        } catch (NumberFormatException ex) {
                            // Handle the case where the input is not a valid float
                            textField.setText("Invalid input. Please enter a valid float.");
                        }
                        //price = textField.getText();
                        textField.setText(null);
                        label1.setText("Enter the calories");
                        System.out.println("case 3 read");
                        
                        addFlag = addFlag+1;
                        break;

                

        
                    default:
                           try {
                        String inputText2 = textField.getText();
                        
                        calories = Integer.parseInt(inputText2);

                    } catch (NumberFormatException ex) {
                       textField.setText("Invalid input. Please enter a valid integer.");
                        } 
                    
                        textField.setText(null);
                        //adding items
                        
                        Items itemToAdd = new Items(name, price, calories);
                        m1.AddItem(itemToAdd);
                        label1.setText("Item successfully added.\n Click add to add another item");
                        addFlag = 1;
                    
                    textField.setText("added item "+name+" with price "+price+" and cals "+calories);
                    
                    System.out.println(addFlag);
                    System.out.println(name+ "  "+price+"  "+calories);
                    add.setText("Add");
                        break;

                    
                }

                
                
                //m1.AddItem(m1);
                //text.setText("Gay");
                
            
    }});//add button logic ends

        JButton delete = new JButton("Remove item");
        frame2.add(delete);
        delete.setBounds(110, 50, 100, 20);
        delete.setFocusable(false);
        //delete button logic
        delete.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e){

                switch (delFlag) {
                    case 1:
                    textField.setText(null);
                    delete.setText("next");
                    label1.setText("Enter serial number for item (first is 1)");
                    delFlag=delFlag+1;
                    System.out.println("case 1 done, df = "+delFlag);
                        
                    break;

                    case 2:
                     try {
                        String inputText3 = textField.getText();
                        
                        delItemNo = Integer.parseInt(inputText3);

                    } catch (NumberFormatException ex) {
                       textField.setText("Invalid input. Please enter a valid integer.");
                       return;
                        } 
                    catch(Exception ie){
                        label1.setText("invalid index");
                        }
                    textField.setText(null);
                    delete.setText("Delete selected");
                    label1.setText(m1.getitems(delItemNo-1).getName()+"  "+m1.getitems(delItemNo-1).getPrice()+"  "+m1.getitems(delItemNo-1).getCalories() );
                    //label1.setText();
                    delFlag=delFlag+1;
                    System.out.println("case 2 done, df = "+delFlag);
                    break;

                
                    default:
                    try {
                           m1.deleteItem(delItemNo-1);
                    label1.setText("Deleted item, click to delete another");
                    delete.setText("delete");
                    delFlag = 1;
                    System.out.println("case 3 done, df = "+delFlag);
                    } catch (IndexOutOfBoundsException i) {
                        label1.setText("Item index doesnt exist");
                    }    
                    break;
                }
            }
        });
      //delete button ends here

        JButton displayButton = new JButton("Display");
        frame2.add(displayButton);
        displayButton.setBounds(210, 50, 100, 20);
        displayButton.setFocusable(false);
        //display button logic
        displayButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e){
               // m1.displayItems();
               ci.main(args);
            }
        });

        frame2.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame2.setSize(500, 500);
        frame2.setVisible(true);
        }

   public Menu giveItemsToMain(){
        return m1;
   }
}
