import java.util.*;
public class Menu extends Items {
    int index = 0;
    ArrayList<Items> menuArray = new ArrayList<>();
     Scanner sc3 = new Scanner(System.in);
    int indextoChoose;
   // Item item = new Item();

    public void AddItem(Items item){
        menuArray.add(item);
        index++;
    }

    public void deleteItem(int indextoChoose){
       
        //System.out.println("Enter item index to remove (first is 1)");

       // indextoChoose = sc3.nextInt();
        
        try {
              menuArray.remove(indextoChoose);

        } catch (Exception e) {
            System.out.println("invalid index number");
        }
        index--;

        //sc3.close();
    }

    public void displayItems(){
        
        for(int i=0;i<index;i++){
           Items itemcount =  menuArray.get(i);

           System.out.println("Index: " + (i + 1) +
           ", Name: " + itemcount.getName() +
           ", Price: $" + itemcount.getPrice() +
           ", Calories: " + itemcount.getCalories());

        }
    }

    public Items getitems(int ItemNo){
        return menuArray.get(ItemNo);
    }

}
