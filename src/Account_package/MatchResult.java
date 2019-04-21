package Account_package;

public class MatchResult {

    Account opponent;
    MatchResultType matchResultType;

    public MatchResult(Account opponent, MatchResultType matchResultType) {
        this.matchResultType = matchResultType;
        this.opponent = opponent;
    }


    public void setOpponent(Account opponent) {
        this.opponent = opponent;
    }

    public void setMatchResultType(MatchResultType matchResultType) {
        this.matchResultType = matchResultType;
    }

    public Account getOpponent() {
        return opponent;
    }

    public MatchResultType getMatchResultType() {
        return matchResultType;
    }
}
