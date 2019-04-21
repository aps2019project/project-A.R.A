package Account_package;

import Model.Collection;

import java.util.ArrayList;

public class Account {
    private String name;
    private String password;
    private int drake;
    private ArrayList<MatchResult> matchHistory;
    private Collection collection = new Collection();


    Account(String name, String password){
        this.name = name;
        this.password = password;
        drake = 15000;
        matchHistory = new ArrayList<>();
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getDrake() {
        return drake;
    }

    public void setDrake(int drake) {
        this.drake = drake;
    }

    public ArrayList<MatchResult> getMatchHistory() {
        return matchHistory;
    }

    public void setMatchHistory(ArrayList<MatchResult> matchHistory) {
        this.matchHistory = matchHistory;
    }

    public Collection getCollection() {
        return collection;
    }

    public void setCollection(Collection collection) {
        this.collection = collection;
    }

    public void addToMatchHistory(MatchResult matchResult){
        this.matchHistory.add(matchResult);
    }
}

