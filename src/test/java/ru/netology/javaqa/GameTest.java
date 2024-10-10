package ru.netology.javaqa;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class GameTest {

    @Test
    public void testWhenFirstPlayerWin() {
        Player petya = new Player(1, "Петя", 200);
        Player vasya = new Player(2, "Вася", 100);
        Game game = new Game();

        game.register(petya);
        game.register(vasya);
        int actual = game.round("Петя", "Вася");
        int expected = 1;

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void testWhenSecondPlayerWin() {
        Player petya = new Player(1, "Петя", 200);
        Player vasya = new Player(2, "Вася", 100);
        Game game = new Game();

        game.register(petya);
        game.register(vasya);
        int actual = game.round("Вася", "Петя");
        int expected = 2;

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void testWhenFirstPlayerNotExist() {
        Game game = new Game();
        Player petya = new Player(1, "Петя", 20);

        game.register(petya);
        Assertions.assertThrows(NotRegisteredException.class, () -> game.round("Гарик", "Петя"));
    }

    @Test
    public void testWhenSecondPlayerNotExist() {
        Game game = new Game();
        Player vasya = new Player(2, "Вася", 10);

        game.register(vasya);
        Assertions.assertThrows(NotRegisteredException.class, () -> game.round("Вася", "Гарик"));
    }

    @Test
    public void testWhenPlayerNotExist() {
        Game game = new Game();

        Assertions.assertThrows(NotRegisteredException.class, () -> game.round("Player1", "Player10"));
    }

    @Test
    public void testRoundDraw() {
        Game game = new Game();
        Player petya = new Player(1, "Петя", 200);
        Player vasya = new Player(2, "Вася", 200);

        game.register(petya);
        game.register(vasya);

        int actual = game.round("Петя", "Вася");
        int expected = 0;
        Assertions.assertEquals(expected, actual);
    }
}
