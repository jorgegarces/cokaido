## Shopping Cart Kata
### Scenario 1 - Add items to shopping com.lifull.shoppingBasket.domain.basket
Given I add 2 units of "The Hobbit" to my shopping com.lifull.shoppingBasket.domain.basket
And I add 5 units of "Breaking Bad"
When I check the content of my shopping com.lifull.shoppingBasket.domain.basket
Then it should contain the following information:
- Creation date : 01/03/2020 
- 2 x The Hobbit   // 2 x 5.00 = €10.00 
- 5 x Breaking Bad // 5 x 7.00 = €35.00
- Total: €45.00
*Acceptance criteria:*
- Shopping com.lifull.shoppingBasket.domain.basket should be created when the first com.lifull.shoppingBasket.domain.com.lifull.shoppingBasket.domain.product is added. This creation date can be represented as a String
- Shopping com.lifull.shoppingBasket.domain.basket should be persisted (In-memory, DB later) 
- Each com.lifull.shoppingBasket.domain.user should have her own shopping com.lifull.shoppingBasket.domain.basket.
Products available (in-memory repository):
- Books 
   - 10001: Lord of the Rings - €10.00
   - 10002: The Hobbit - €5.00     
- DVDs
   - 20001: Game of Thrones - €9.00 
   - 20110: Breaking Bad - €7.00
    
```java
    public class com.lifull.shoppingBasket.domain.ShoppingBasketService {
    
        public void addItem(UserID userId, ProductID productId, int quantity) { }
        public ShoppingBasket basketFor(UserID userId) { }
    
    }   
