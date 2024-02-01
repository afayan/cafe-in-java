import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Checkout {

    
    public void BillingWindow(float price, float calories) {
       // public static void main(String[] args) {
            
      
        JFrame billingframe = new JFrame();
        billingframe.setLayout(null);

        

        CafeInterface cafeInterface1 = new CafeInterface();
        //float Price = cafeInterface.getPrice();
        //float Calories = cafeInterface.getCalories();
        JLabel pricetag = new JLabel("Price :");
        pricetag.setBounds(20, 20, 200, 30);
        billingframe.add(pricetag);

        JLabel priceLabel = new JLabel(String.valueOf(price));
        priceLabel.setBounds(320, 20, 300, 30);
        billingframe.add(priceLabel);

        JLabel calTag = new JLabel("Calories");
        calTag.setBounds(20, 60, 200, 30);
        billingframe.add(calTag);

        JLabel caloryLabel = new JLabel(String.valueOf(calories));
        caloryLabel.setBounds(320, 60, 300, 30);
        billingframe.add(caloryLabel);

        JLabel label = new JLabel("Enter your amount");
        label.setBounds(30, 100, 300, 30);
        billingframe.add(label);

        TextField enterPrice = new TextField();
        enterPrice.setBounds(30, 130, 100, 30);
        billingframe.add(enterPrice);

        JButton pay = new JButton("Pay");
        pay.setBounds(30, 200, 100, 30); 
        pay.setFocusable(false);
        pay.addActionListener(new ActionListener() {
                    //private String[] args;

                    @Override
                    public void actionPerformed(ActionEvent e) {
                        // Code to be executed when the button is clicked
                      // Get the text from the TextField
                      String inputText = enterPrice.getText();
        
                      // Convert the text to a float
                       float Paidprice  = Float.parseFloat(inputText);

                       if (Paidprice==price) {
                        System.out.println("transaction success");
                       }

                       else{
                        System.out.println("incorrect amount");
                       }
                    }
                });
        billingframe.add(pay);
        

        

        JButton Backbutton = new JButton("Back");
                Backbutton.setBounds(30, 240, 100, 30); // Set the bounds (x, y, width, height) of the button

                // Adding ActionListener to the button
                Backbutton.addActionListener(new ActionListener() {
                    private String[] args;

                    @Override
                    public void actionPerformed(ActionEvent e) {
                        // Code to be executed when the button is clicked

                    

                       //cafeInterface1.main(args);

                       billingframe.dispose();
                    }
                });
        billingframe.add(Backbutton);
        // Add the button to the frame

        billingframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        billingframe.setSize(400, 400);
        billingframe.setVisible(true);
    }
}
