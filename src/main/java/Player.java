// Клас, що представляє гравця
public class Player {
    private final String name; // Ім'я гравця
    private int score; // Рахунок гравця
    private boolean hasStopped; // Чи зупинився гравець

    public Player(String name) {
        this.name = name; // Присвоюємо ім'я
        this.score = 0; // Початковий рахунок
        this.hasStopped = false; // Гравець не зупинився
    }

    public String getName() {
        return name; // Отримуємо ім'я
    }

    public int getScore() {
        return score; // Отримуємо рахунок
    }

    public boolean hasStopped() {
        return hasStopped; // Чи зупинився гравець
    }

    public void addScore(int card) {
        score += card; // Додаємо значення карти до рахунку
    }

    public void stop() {
        hasStopped = true; // Гравець зупинився
    }

    public boolean isBusted() {
        return score > 21; // Перевіряємо, чи перевищено 21
    }
}