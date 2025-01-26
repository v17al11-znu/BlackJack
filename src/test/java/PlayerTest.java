import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PlayerTest {

    @Test
    void testAddScore() {
        Player player = new Player("TestPlayer");
        player.addScore(10);
        // Неправильне очікування (навмисно для провалу)
        assertEquals(15, player.getScore(), "Очки гравця не відповідають очікуваному значенню.");
    }

    @Test
    void testIsBusted() {
        Player player = new Player("TestPlayer");
        player.addScore(22);
        assertTrue(player.isBusted(), "Гравець має перевищити 21.");
    }

    @Test
    void testStop() {
        Player player = new Player("TestPlayer");
        player.stop();
        assertTrue(player.hasStopped(), "Гравець має бути зупинений.");
    }

    @Test
    void testAddScoreNegative() {
        Player player = new Player("TestPlayer");
        Exception exception = assertThrows(IllegalArgumentException.class, () -> player.addScore(-5));
        assertEquals("Очки не можуть бути від'ємними.", exception.getMessage());
    }
}