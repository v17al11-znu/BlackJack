import java.util.Random;

// Клас для роботи з колодою карт
public class CardDeck {
    private final Random random = new Random(); // Генератор випадкових чисел

    // Генерує карту зі значенням від 1 до 11
    public int drawCard() {
        return random.nextInt(11) + 1;
    }
}