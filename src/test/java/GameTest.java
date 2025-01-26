import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assumptions.assumeTrue;

class GameTest {

    @Test
    void testDetermineWinnerTie() {
        Player player = new Player("Player");
        Player dealer = new Player("Dealer");
        player.addScore(20);
        dealer.addScore(20);

        assertEquals(player.getScore(), dealer.getScore(), "Гра має закінчитися нічиєю.");
    }

    @Test
    void testDetermineWinnerPlayerWins() {
        Player player = new Player("Player");
        Player dealer = new Player("Dealer");
        player.addScore(21);
        dealer.addScore(19);

        assertTrue(player.getScore() > dealer.getScore(), "Гравець має перемогти.");
    }

    @Test
    void testDetermineWinnerDealerWins() {
        Player player = new Player("Player");
        Player dealer = new Player("Dealer");
        player.addScore(18);
        dealer.addScore(20);

        assertTrue(dealer.getScore() > player.getScore(), "Дилер має перемогти.");
    }

    @Test
    void testDetermineWinnerWithAssumption() {
        Player player = new Player("Player");
        Player dealer = new Player("Dealer");
        player.addScore(22); // додаємо гравцю напочатку одразу 22 очки.

        // Припущення: гравець ще не перевищив 21.
        assumeTrue(player.getScore() <= 21, "Гравець не повинен перевищувати 21 до початку тесту");

        dealer.addScore(20);
        player.addScore(18);

        assertTrue(dealer.getScore() > player.getScore(), "Дилер має перемогти.");
    }
}