import org.junit.Assert;
import org.junit.Test;

public class YatzyShould {

    @Test
    public void ensure_yatzy_play_scores_50_points(){
        Game currentGame = new Game(new Yatzy(DiceValue.ONE, DiceValue.ONE, DiceValue.ONE, DiceValue.ONE, DiceValue.ONE));

//        Assert.assertEquals(new Score(50), yatzy.calculateScore());
        Assert.assertTrue(new Score(50).equals(currentGame.calculateScore()));
    }

    @Test
    public void ensure_erroneous_yatzy_play_scores_0_points(){
        Roll yatzy = new Yatzy(DiceValue.ONE, DiceValue.ONE, DiceValue.ONE, DiceValue.ONE, DiceValue.TWO);
        Game currentGame = new Game(yatzy);

        Assert.assertTrue(new Score(0).equals(currentGame.calculateScore()));
    }

    @Test
    public void ensure_chance_play_adds_the_dices(){
        Game currentGame = new Game(new Chance(DiceValue.ONE, DiceValue.ONE, DiceValue.THREE, DiceValue.THREE, DiceValue.SIX));

        Assert.assertTrue(new Score(14).equals(currentGame.calculateScore()));
    }

    @Test
    public void ensure_ones_play_adds_ones(){
        Game currentGame = new Game(new Ones(DiceValue.ONE, DiceValue.ONE, DiceValue.THREE, DiceValue.THREE, DiceValue.SIX));

        Assert.assertTrue(new Score(2).equals(currentGame.calculateScore()));
    }

    @Test
    public void ensure_twos_play_adds_twos(){
        Game currentGame = new Game(new Twos(DiceValue.ONE, DiceValue.ONE, DiceValue.TWO, DiceValue.TWO, DiceValue.FOUR));

        Assert.assertTrue(new Score(4).equals(currentGame.calculateScore()));

    }

    @Test
    public void ensure_threes_play_adds_threes(){
        Game currentGame = new Game(new Threes(DiceValue.THREE, DiceValue.THREE, DiceValue.TWO, DiceValue.TWO, DiceValue.FOUR));

        Assert.assertTrue(new Score(6).equals(currentGame.calculateScore()));
    }

    @Test
    public void ensure_any_play_scores_zero_when_played_number_is_not_found_in_roll() {
        Game currentGame = new Game(new Ones(DiceValue.THREE, DiceValue.THREE, DiceValue.THREE, DiceValue.FOUR, DiceValue.FIVE));

        Assert.assertTrue(new Score(0).equals(currentGame.calculateScore()));
    }
}
