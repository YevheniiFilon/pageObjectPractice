package tests;

import org.junit.jupiter.api.Test;

class First extends TestBase{


    @Test
    void firstTest(){
        mainPage.goTo()
                .addProductsToTheCart(2);
        cartPage.cleanUpCart();
    }
}
