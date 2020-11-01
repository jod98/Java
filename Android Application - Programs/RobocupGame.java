package ie.mu.ee308.lab5_gamecontroller;

/**
 * this class implements the model (as part of the MVC architecture)
 */
public class RobocupGame {
    public static final int MAX_NUM_PLAYERS = 5;

    public static final int PENALTY_NONE = 0;
    public static final int PENALTY_SPL_PUSHING = 2;
    public static final int PENALTY_SPL_LEAVING_THE_FIELD = 6;
    public static final int PENALTY_SPL_ILLEGAL_DEFENDER = 5;

    public static final int PERIOD_H1 = 0;
    public static final int PERIOD_H2 = 1;
    public static final int PERIOD_PENALTY_SHOOTOUT = 2;

    public static final int STATE_INITIAL = 0;
    public static final int STATE_READY = 1;
    public static final int STATE_SET = 2;
    public static final int STATE_PLAYING = 3;
    public static final int STATE_FINISHED = 4;
// ========================================================================

    public class RobotInfo {
        private int penalty;
        private int secsUntilUnpenalised;

        RobotInfo() {
            penalty = PENALTY_NONE;
            secsUntilUnpenalised = 0;
        }

        public int getPenalty() {
            return penalty;
        }

        public int getSecsUntilUnpenalised() {
            return secsUntilUnpenalised;
        }
    }
// ========================================================================

    public class TeamInfo {
        private String teamName;
        private int score;
        private RobotInfo players[];

        TeamInfo() {
            teamName = "not yet set";

            players = new RobotInfo[MAX_NUM_PLAYERS];
            for (int i = 0; i < players.length; i++)
                players[i] = new RobotInfo();
        }

        RobotInfo getPlayer(int playerNum) {
            return players[playerNum - 1];
        }
    }
    // ========================================================================

    private int gamePeriod;
    private int state;
    private TeamInfo teams[];

    /**
     * construct a new instance of the model
     */
    RobocupGame() {
        state = STATE_INITIAL;

        teams = new TeamInfo[2];
        teams[0] = new TeamInfo();
        teams[1] = new TeamInfo();
    }

    public int getGamePeriod() {
        return gamePeriod;
    }

    public int getState() {
        return state;
    }

    /**
     * get the TeamInfo for one of the two teams
     *
     * @param teamNum - which team to get (1 or 2)
     */
    public TeamInfo getTeam(int teamNum) {
        return teams[teamNum - 1];
    }

    /**
     * Set the game period.
     * This is only permitted when in the INITIAl state
     *
     * @param gamePeriod - one of PERIOD_H1, PERIOD_H2, or PERIOD_PENALTY_SHOOTOUT
     */
    public void setGamePeriod(int gamePeriod) {
        if (state != STATE_INITIAL)
            throw new IllegalStateException("Can't change game period in this state");

        this.gamePeriod = gamePeriod;
    }

    /**
     * Change the game to a new state and unpenalize robots if needed
     *
     * @param newState - one of state constants, i.e. STATE_INITIAL, STATE_READY,
     *                 STATE_SET, STATE_PLAY or STATE_FINISHED
     */
    public void setState(int newState) {
        // TODO: need to unpenalize robots in the INITIAL or FINISHED states
        /*
           Robot can only go from these states so if so go to next state else throw illegalStateException
           Initial - Playing or Ready
           Ready - Set or Finished
           Set - Playing or Finished
           Playing - Ready or Finished
           Finished - Initial
         */

        int currentState = getState(); //Retrieving current state of robot

        if(currentState == STATE_INITIAL && (newState == STATE_PLAYING) || (newState == STATE_READY)) {
            this.state = newState;
        }
        else if(currentState == STATE_READY && (newState == STATE_SET) || (newState == STATE_FINISHED)){
            this.state = newState;
            unpenaliseAll(newState);
        }
        else if(currentState == STATE_SET && (newState == STATE_PLAYING) || (newState == STATE_FINISHED)){
            this.state = newState;
            unpenaliseAll(newState);
        }
        else if(currentState == STATE_PLAYING && (newState == STATE_READY) || (newState == STATE_FINISHED)){
            this.state = newState;
            unpenaliseAll(newState);
        }
        else if(currentState == STATE_FINISHED && (newState == STATE_INITIAL))
        {
            this.state = newState;
            unpenaliseAll(newState);
        }
        else{
            throw new IllegalStateException("Can't change to this state");
        }
    }
    //Function to unpenalise all robots on both teams
    public void unpenaliseAll(int newState){
        if(newState == STATE_FINISHED || newState == STATE_INITIAL){
            for(int playerNum = 1; playerNum <= MAX_NUM_PLAYERS; playerNum++){
                setPenalty(1,playerNum, PENALTY_NONE);
                setPenalty(2,playerNum, PENALTY_NONE);
            }
        }
    }
    /**
     * Penalize (or unpenalize) a robot.
     * To unpenalize a robot, set the newPenalty to PENALTY_NONE
     *
     * @param teamNum    - which team the penalty applies to (1 or 2)
     * @param playerNum  - which player the penalty applies to (1..5)
     * @param newPenalty - one of penalty constants, i.e. PENALTY_NONE,
     *                   PENALTY_SPL_PUSHING, PENALTY_SPL_LEAVING_THE_FIELD,
     *                   or PENALTY_SPL_ILLEGAL_DEFENDER
     */
    public void setPenalty(int teamNum, int playerNum, int newPenalty) {
        // TODO
        RobotInfo player = teams[teamNum - 1].players[playerNum - 1];
        //Robot cannot be penalised in these states so set to unpenalised
        if ((getState() == STATE_INITIAL) || (getState() == STATE_SET) || (getState() == STATE_FINISHED)) {
            if (newPenalty == PENALTY_NONE) {
                player.penalty = PENALTY_NONE;
                player.secsUntilUnpenalised = 0;
            }
            else{
                throw new IllegalStateException("Can't penalize a robot in these states");
            }
        }
        else{   //If robot has a penalty, don't set another penalty (can't penalise twice)
                if(newPenalty == PENALTY_NONE){
                    player.penalty = PENALTY_NONE;
                    player.secsUntilUnpenalised = 0;
                }
                //If they don't currently have a penalty, set a penalty
                else if (player.getPenalty() == PENALTY_NONE) {
                    player.penalty = newPenalty;
                    player.secsUntilUnpenalised = 45;
                }
                else if(newPenalty != PENALTY_NONE){
                    throw new IllegalStateException("Can't penalize a robot that is already penalized");
                }
            }
        }
    }
