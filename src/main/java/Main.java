

import com.pricebasket.app.dal.InMemoryItemDAOImpl;
import com.pricebasket.app.dal.InMemoryOfferDaoImpl;
import com.pricebasket.app.model.BasketResult;
import com.pricebasket.app.service.BasketService;
import com.pricebasket.app.service.ItemService;
import com.pricebasket.app.service.OfferService;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;


public class Main {

    public static void main(String[] args) {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        System.out.print("Enter Basket Items E.g(PriceBasket Apples Milk Bread): ");

        String basket = null;
        try {
            basket = reader.readLine();
            String[] basketArray = basket.split(" ");

            //process basket & print results
            processBasket(basketArray);
        } catch (IOException e) {
            e.printStackTrace();
        }

        if(basket != null){

        }else{
            System.out.println("EBasket Items are not in valid format");
        }

         //String basket = "PriceBasket Apples Milk Bread";
          //String basket = "PriceBasket Apples Milk Soup Soup Soup Soup Bread Bread";

    }

    private static void processBasket(String[] basketArray){
        String[] bItems = Arrays.copyOfRange(basketArray, 1, basketArray.length);
        BasketService basketService = new BasketService(new ItemService(new InMemoryItemDAOImpl()),
                new OfferService(new InMemoryOfferDaoImpl()));
        BasketResult basketResult = basketService.ProcessBasket(bItems);

        for (String ds : basketResult.getMessages()) {
            System.out.println(ds);
        }
    }
}
