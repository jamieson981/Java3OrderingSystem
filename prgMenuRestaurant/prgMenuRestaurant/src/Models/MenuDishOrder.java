package Models;


import java.math.BigDecimal;


/**
 *
 * @author Afarin
 */
public class MenuDishOrder {

    long id; // PK INT AI
    String name; // VARCHAR(50)
    String ingredience;//VARCHAR(100)
    BigDecimal price;// DECIMAL(14,2)
    boolean vegetarian;//BOOLEAN in table
    //String foodtype;// {starter,main,dessert,drink}; //ENUM in table
    int calories;
    
    public BigDecimal getPrice() {
        return price;
    }
    
     public MenuDishOrder(String name, BigDecimal price) {
        this.name = name;
        this.price = price;
    }

    @Override
    public String toString(){
       return String.format("%s with price %.2f",name ,price);
    }

}

