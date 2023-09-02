import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class GameTest {
    @Test
    public void shouldWinPlayer1() {
        Game game = new Game();

        Player kolya = new Player(1, "Коля", 50);
        Player sasha = new Player(2, "Саша", 45);

        game.register(kolya);
        game.register(sasha);

        int expected = 1;
        int actual = game.round("Коля", "Саша");
        Assertions.assertEquals(expected, actual);


    }

    @Test
    public void shouldWinPlayer2() {
        Game game = new Game();

        Player kolya = new Player(1, "Коля", 50);
        Player sasha = new Player(2, "Саша", 70);

        game.register(kolya);
        game.register(sasha);

        int expected = 2;
        int actual = game.round("Коля", "Саша");
        Assertions.assertEquals(expected, actual);


    }

    @Test
    public void shouldBeDraw() {
        Game game = new Game();

        Player kolya = new Player(1, "Коля", 50);
        Player sasha = new Player(2, "Саша", 50);

        game.register(kolya);
        game.register(sasha);

        int expected = 0;
        int actual = game.round("Коля", "Саша");
        Assertions.assertEquals(expected, actual);


    }

    @Test
    public void player1IsNotRegistered() {
        Game game = new Game();

        Player kolya = new Player(1, "Коля", 50);
        Player sasha = new Player(2, "Саша", 45);

        game.register(kolya);
        game.register(sasha);

        Assertions.assertThrows(NotRegisteredException.class,
                ()->game.round("Маша", "Саша")
       );
        }


    @Test
    public void player2IsNotRegistered() {
        Game game = new Game();

        Player kolya = new Player(1, "Коля", 50);
        Player sasha = new Player(2, "Саша", 45);

        game.register(kolya);
        game.register(sasha);

        Assertions.assertThrows(NotRegisteredException.class,
                ()->game.round("Коля", "Миша")
        );
    }
}
