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
}