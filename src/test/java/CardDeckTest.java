import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assumptions.assumeTrue;

class CardDeckTest {

    @Test
    void testDrawCard() {
        CardDeck cardDeck = new CardDeck();
        int card = cardDeck.drawCard();
        assertTrue(card >= 1 && card <= 11, "Карта повинна бути між 1 та 11.");
    }


    @Test
    void testDrawCardWithAssumption() {
        CardDeck cardDeck = new CardDeck();

        // Припущення: тест виконується лише в середовищі з певною властивістю.
        assumeTrue(System.getProperty("env", "test").equals("test"),
                "Цей тест виконується лише в тестовому середовищі");

        int card = cardDeck.drawCard();
        assertTrue(card >= 1 && card <= 11, "Карта повинна бути в діапазоні від 1 до 11");
    }
}