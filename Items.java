public class Items{

    private String itemName;
    private float price;
    private int calories;

    public Items(){
        
    }

    public Items(String itemName,float price,int calories){
        this.itemName = itemName;
        this.price=price;
        this.calories=calories;
    }

    public String getName(){
        return itemName;
    }

    public float getPrice(){
        return price;
    }

    public float getCalories(){
        return calories;
    }

}
