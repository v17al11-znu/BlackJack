import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Timeout;
import org.junit.jupiter.api.Assumptions;

import java.util.concurrent.TimeUnit;

import static org.junit.jupiter.api.Assertions.*;

class PlayerTest {

    @Test
    @Tag("positive")
    void testAddScore() {
        Player player = new Player("TestPlayer");
        player.addScore(10);
        assertEquals(10, player.getScore(), "Очки повинні дорівнювати 10.");
    }

    @Test
    @Tag("positive")
    void testIsBusted() {
        Player player = new Player("TestPlayer");
        player.addScore(22);
        assertTrue(player.isBusted(), "Гравець має перевищити 21.");
    }

    @Test
    @Tag("positive")
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

    @Test
    @Tag("negative")
    @Timeout(value = 1, unit = TimeUnit.SECONDS)
    void testTimeout() throws InterruptedException {
        Thread.sleep(500); // Імітація затримки
        assertTrue(true);
    }

    @Test
    void testInitialScore() {
        Player player = new Player("TestPlayer");
        player.addScore(1);  player.addScore(22); // даємо гравцю напочатку більше ніж 0 очків.
        Assumptions.assumeTrue(player.getScore() == 0, "Початковий рахунок повинен бути 0.");
        assertEquals(0, player.getScore());
    }
}