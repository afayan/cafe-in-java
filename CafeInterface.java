import java.io.File;
import java.sql.Array;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class CafeInterface extends Cafe{
    // arrayOfButtons = new int 

    public static Cafe cafeObject = new Cafe();
    public static Checkout checkoutObject = new Checkout();
    public static Menu menu = new Menu();
    public static  AdminWindow aw = new AdminWindow();
    public static  CafeInterface cafeInterface = new CafeInterface();
    //public static 
    //static JButton[] ButtonArray = new JButton[50] ;
    //int[] array = new int[20];
    public static JButton[] arrayButtons = new JButton[20];
    public static int[] selectedArray = new int[20];
    public static int j;
    public static float sumOfFoods = 0;
    public static float sumOfCalories= 0;

    public static void main(String[] args) {
      
        
        Menu menuUpdated = aw.giveItemsToMain();

        //demo items added here
        //menuUpdated = addDemoitems(menuUpdated);
       

        int hmargin = 10;
        int vmargin= 100;
        int width = 100;
        int height=20;

        
         //System.out.println("Absolute Path: " + new File("images/coffee.png").getAbsolutePath());
        ImageIcon mainIcon = new ImageIcon("images/coffee.png");
       



        JFrame frame = new JFrame();
        JLabel label = new JLabel("Cafe");
        label.setBounds(10, 10, 100, 30);

       

        JButton button1 = new JButton("Admin");
        button1.setBounds(10, 50, 100, 30);
        //button1.addActionListener(e -> cafeObject.runCafe());
        //button1.addActionListener(null);
        button1.setFocusable(false);

        button1.addActionListener(new ActionListener() {
            //@Override
            public void actionPerformed(ActionEvent e) {
                
                int result = JOptionPane.showConfirmDialog(frame,"You are entering Admin settings","Confirmation",JOptionPane.YES_NO_CANCEL_OPTION);
                if (result == JOptionPane.YES_OPTION) {
                   // System.out.println("User clicked YES");
                   aw.main(args);

                } else if (result == JOptionPane.NO_OPTION) {
                  //  System.out.println("User clicked NO");
                    // Add your code for NO option
                }
                
            
                }});
            
       
        //button1.setHorizontalTextPosition(JFrame.CENTER);
        //button1.setIcon(mainIcon);
        //button1.setBounds(10, 50, mainIcon.getIconWidth(), mainIcon.getIconHeight());

        JButton refresh = new JButton("Refresh");
        refresh.setBounds(110, 50, 100, 30);
        refresh.setFocusable(false);
        frame.add(refresh);

        refresh.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e){
                    cafeInterface.main(args);
            }
        });

        JButton checkout = new JButton("Checkout");
        checkout.setBounds(210, 50, 100, 30);
        checkout.setFocusable(false);
        frame.add(checkout);

        checkout.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e){
                    //System.out.println(sumOfFoods);

                    float finalPrice = sumOfFoods;
                    float finalCals = sumOfCalories;

                    checkoutObject.BillingWindow(finalPrice, finalCals);
            }
        });

        


     

        int addMargin = 0;

        for( j =0; j<menuUpdated.index;j++){

            Items itemGhost = menuUpdated.getitems(j);
            JLabel itemLabel = new JLabel(itemGhost.getName().toString());

            float priceGhost = itemGhost.getPrice();
            JLabel itemPriceLabel = new JLabel(String.valueOf(priceGhost));

            float caloryGhost = itemGhost.getCalories();
            JLabel itemCalorylabel = new JLabel(String.valueOf(caloryGhost));

            JButton selectButton = new JButton("Select");
            arrayButtons[j]=selectButton;
            selectedArray[j]= 0;

            int currentButtonIndex =j;

            selectButton.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e){
                    if(selectedArray[currentButtonIndex]==0){
                        selectButton.setText("Disselect");
                        selectedArray[currentButtonIndex]=1;
                        sumOfFoods = sumOfFoods+priceGhost;
                        sumOfCalories = sumOfCalories + caloryGhost;
                    }
                    else if(selectedArray[currentButtonIndex]==1){
                        selectButton.setText("Select");
                        selectedArray[currentButtonIndex]=0;
                        sumOfFoods = sumOfFoods-priceGhost;
                        sumOfCalories = sumOfCalories - caloryGhost;
                    }                       
                    }
                }
            );

                        
            frame.add(selectButton);
            frame.add(itemLabel);
            frame.add(itemPriceLabel);
            frame.add(itemCalorylabel);
            itemLabel.setBounds(hmargin, vmargin + addMargin, width,height);
            itemPriceLabel.setBounds(hmargin + 100, vmargin + addMargin, width, height);
            itemCalorylabel.setBounds(hmargin+ 200, vmargin+addMargin, width, height);
            selectButton.setBounds(hmargin+300, vmargin+addMargin, width-30, height);
            selectButton.setFocusable(false);
            addMargin = addMargin+50;

        
            }//end of actionlistener

        frame.setLayout(null);
        //frame.setBounds(0, 100, 400, 400);
        frame.setSize(800, 500);
        frame.setVisible(true);
        frame.add(label);
        frame.add(button1);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }


    public float giveTotalPrice(){
        return sumOfFoods;
    }

    public float giveTotalCals(){
        return sumOfCalories;
    }

    public static Menu addDemoitems(Menu menuUpdated){
         //demo items added here [DELETE IN FINAL]
        
        Items i1 = new Items("cupcake", 50, 350);
        menuUpdated.AddItem(i1);
        Items i2 = new Items("pepsi", 10, 200);
        menuUpdated.AddItem(i2);
        //ends here

        return menuUpdated;
    }
}
