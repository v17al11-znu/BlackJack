import java.util.Scanner;

// Основний клас для логіки гри в 21
public class Game {
    private final Player player; // Гравець
    private final Player dealer; // Дилер
    private final CardDeck cardDeck; // Колода карт
    private final Scanner scanner; // Сканер для зчитування вводу

    public Game() {
        this.player = new Player("Гравець"); // Ініціалізуємо гравця
        this.dealer = new Player("Дилер"); // Ініціалізуємо дилера
        this.cardDeck = new CardDeck(); // Ініціалізуємо колоду
        this.scanner = new Scanner(System.in); // Ініціалізуємо сканер
    }

    // Запуск гри
    public void start() {
        System.out.println("Ласкаво просимо до гри в 21!");

        // Хід гравця
        playerTurn();

        // Хід дилера (лише якщо гравець не перевищив 21)
        if (!player.isBusted()) {
            dealerTurn();
        }

        // Визначення переможця
        determineWinner();
    }

    // Хід гравця
    private void playerTurn() {
        System.out.println("\nХід гравця:");
        while (!player.hasStopped() && !player.isBusted()) {
            System.out.println("Ваш поточний рахунок: " + player.getScore());
            System.out.print("Хочете взяти карту? (y/n): ");
            String choice = scanner.nextLine();

            if (choice.equalsIgnoreCase("y")) {
                int card = cardDeck.drawCard();
                System.out.println("Ви взяли карту: " + card);
                player.addScore(card);

                if (player.isBusted()) {
                    System.out.println("Ви програли з рахунком: " + player.getScore());
                }
            } else {
                player.stop();
            }
        }
    }

    // Хід дилера
    private void dealerTurn() {
        System.out.println("\nХід дилера:");
        while (dealer.getScore() < 17) {
            int card = cardDeck.drawCard();
            System.out.println("Дилер взяв карту: " + card);
            dealer.addScore(card);

            if (dealer.isBusted()) {
                System.out.println("Дилер програв з рахунком: " + dealer.getScore());
                return;
            }
        }
        System.out.println("Дилер зупинився з рахунком: " + dealer.getScore());
    }

    // Визначення переможця
    private void determineWinner() {
        System.out.println("\nКінцевий рахунок:");
        System.out.println("Гравець: " + player.getScore());
        System.out.println("Дилер: " + dealer.getScore());

        if (player.isBusted()) {
            System.out.println("Дилер виграв! Гравець програв.");
        } else if (dealer.isBusted()) {
            System.out.println("Гравець виграв! Дилер програв.");
        } else if (player.getScore() > dealer.getScore()) {
            System.out.println("Гравець виграв!");
        } else if (player.getScore() < dealer.getScore()) {
            System.out.println("Дилер виграв!");
        } else {
            System.out.println("Нічия!");
        }
    }
}