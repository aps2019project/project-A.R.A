package Model.Match_package.Battle_Type;

public enum MatchType {
    KILL_HERO("Kill Hero", "you're gonna kill opponent's hero")
    , HOLD_FLAG("Hold Flag", "you need to hold the only flag in the game for 6 rounds")
    , COLLECT_FLAG("Collect Flag", "you need to collect at least half of the flags to win");

    private String title;
    private String hint;

    MatchType(String title, String hint){
        this.hint = hint;
        this.title = title;
    }

    public String getTitle(){
        return title;
    }

    public String getHint(){
        return hint;
    }
}
