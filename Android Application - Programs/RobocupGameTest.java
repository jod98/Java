package ie.mu.ee308.lab5_gamecontroller;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class RobocupGameTest {

    RobocupGame game;

    @Before
    public void setUp() throws Exception {
        game = new RobocupGame();
    }

    @After
    public void tearDown() throws Exception {
        game = null;
    }

    @Test
    public void setGamePeriod() {
        // at this point we are just after setUp so the game should be in the INITIAL state.
        // Let's confirm that is the case
        assertEquals(RobocupGame.STATE_INITIAL, game.getState());

        // two simple positive tests for setGamePeriod:
        // check that we can set the game period to something new while in this INITIAL state
        game.setGamePeriod(RobocupGame.PERIOD_H2);
        assertEquals(RobocupGame.PERIOD_H2, game.getGamePeriod());

        game.setGamePeriod(RobocupGame.PERIOD_PENALTY_SHOOTOUT);
        assertEquals(RobocupGame.PERIOD_PENALTY_SHOOTOUT, game.getGamePeriod());

        // one simple negative test for setGamePeriod
        // check that we cannot set the game period when not in the INITIAL state

        game.setState(RobocupGame.STATE_READY);
        int periodBefore = game.getGamePeriod();

        try {
            game.setGamePeriod(RobocupGame.PERIOD_H1);
            // an exception should be thrown which will jump us straight to the catch.
            // If no exception is thrown we mark the test a failure
            fail("An IllegalStateException should have been thrown");
        } catch (IllegalStateException e) {
            // if we get here the exception was thrown - verify that the period was not changed
            assertEquals(periodBefore, game.getGamePeriod());
        }
    }

    @Test
    public void setPenaltyPositiveTests() {
        game.setState(RobocupGame.STATE_READY);
        game.setPenalty(1, 1, RobocupGame.PENALTY_SPL_ILLEGAL_DEFENDER);
        assertEquals(RobocupGame.PENALTY_SPL_ILLEGAL_DEFENDER, game.getTeam(1).getPlayer(1).getPenalty());

        game.setState(RobocupGame.STATE_SET);

        game.setState(RobocupGame.STATE_PLAYING);
        game.setPenalty(2, 5, RobocupGame.PENALTY_SPL_ILLEGAL_DEFENDER);
        assertEquals(RobocupGame.PENALTY_SPL_ILLEGAL_DEFENDER, game.getTeam(2).getPlayer(5).getPenalty());
    }

    @Test
    public void setPenaltyNegativeTests() {
        game.setState(RobocupGame.STATE_READY); //Can't penalise twice
        game.setPenalty(1, 1, RobocupGame.PENALTY_SPL_PUSHING);
        try {
            game.setPenalty(1, 1, RobocupGame.PENALTY_SPL_LEAVING_THE_FIELD);
            fail("An IllegalStateException should have been thrown");
        } catch (IllegalStateException e) {
            assertEquals(RobocupGame.PENALTY_SPL_PUSHING, game.getTeam(1).getPlayer(1).getPenalty());
        }
        game = new RobocupGame();
        try {
            game.setState(RobocupGame.STATE_INITIAL); //Can't penalise in this state
            game.setPenalty(1, 1, RobocupGame.PENALTY_SPL_LEAVING_THE_FIELD);
            fail("An IllegalStateException should have been thrown");
        } catch (IllegalStateException e) {
            assertEquals(RobocupGame.PENALTY_NONE, game.getTeam(1).getPlayer(1).getPenalty());
        }
    }

    @Test
    public void SetStatePositiveTests(){
        game = new RobocupGame(); //Setting up new game to start state back to initial
        //Checking if state we set into is our current state
        game.setState(RobocupGame.STATE_READY);
        assertEquals(game.getState(),RobocupGame.STATE_READY);
        game.setState(RobocupGame.STATE_SET);
        assertEquals(game.getState(),RobocupGame.STATE_SET);
        game.setState(RobocupGame.STATE_PLAYING);
        assertEquals(game.getState(),RobocupGame.STATE_PLAYING);
        game.setState(RobocupGame.STATE_FINISHED);
        assertEquals(game.getState(),RobocupGame.STATE_FINISHED);
        game.setState(RobocupGame.STATE_INITIAL);
        assertEquals(game.getState(),RobocupGame.STATE_INITIAL);

        game = new RobocupGame(); //Setting up new game to start state back to initial

        //Setting penalty on players in playing state
        game.setState(RobocupGame.STATE_PLAYING);
        game.setPenalty(1,1,RobocupGame.PENALTY_SPL_LEAVING_THE_FIELD);
        game.setPenalty(2,5,RobocupGame.PENALTY_SPL_LEAVING_THE_FIELD);

        //Checking if players don't have a penalty considering they are in an unpenalised state
        game.setState(RobocupGame.STATE_FINISHED);
        assertEquals(game.getTeam(1).getPlayer(1).getPenalty(), RobocupGame.PENALTY_NONE);
        assertEquals(game.getTeam(2).getPlayer(5).getPenalty(), RobocupGame.PENALTY_NONE);
    }
}
