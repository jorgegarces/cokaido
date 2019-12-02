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

    /*@Test
    public void ensure_ones_play_adds_ones(){
        Game currentGame = new Game(new int[]{1,1,2,3,4}, "ones");

        Assert.assertTrue(new Score(2).equals(currentGame.calculateScore()));
    }

    @Test
    public void ensure_pair_of_ones_play_adds_ones(){
        Game currentGame = new Game(new int[]{1,1,2,2,4}, "pair of ones");

        Assert.assertTrue(new Score(2).equals(currentGame.calculateScore()));

    }*/
}
