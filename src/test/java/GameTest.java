import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

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
}