/*
 * Copyright (c) 2022 Stefan Psutka
 * All rights reserved
 */

package Lab03.Map;

import org.jetbrains.annotations.NotNull;

import java.util.*;
import java.util.stream.Collectors;

public class Team {
    HashMap<String, Player> team;

    public Team() {
        team = new HashMap<>();
    }

    public void put(Player player) {
        team.putIfAbsent(player.getName(), player);
    }


    public Player get(String name) {
        return this.team.get(name);
    }


    public Player remove(int number) {
        Iterator<String> it = team.keySet().iterator();
        while (it.hasNext()) {
            Player p = team.get(it.next());
            if (number == p.getNumber()) {
                it.remove();
                return p;
            }
        }
        return null;
    }

    public Player minNumber() {
        Player s = null;
        for (String value : team.keySet()) {
            Player p = team.get(value);
            if (s == null || p.getNumber() < s.getNumber()) {
                s = p;
            }
        }
        return s;
    }

    public int sumScores() {
        int tscore = 0;
        for (String s : team.keySet()) {
            tscore += team.get(s).getScore();
        }
        return tscore;
    }

    public int size() {
        return team.size();
    }

    public Player maxScore() {
        Player s = null;
        for (String value : team.keySet()) {
            Player p = team.get(value);
            if (s == null || p.getScore() > s.getScore()) {
                s = p;
            }
        }
        return s;
    }

    public float averageScore() {
        return (float) sumScores() / (float) size();
    }

    public void printSortedbyName() {
        ArrayList<String> copyOfKeys = new ArrayList<>(team.keySet());

        Collections.sort(copyOfKeys);
        for (String key : copyOfKeys) {
            System.out.println("Name: " + key + ", Player: " + team.get(key));
        }
    }

    public void printSortedbyNumber() {
        List<Player> list = team.values().stream().sorted(Comparator.comparing(Player::getNumber)).toList();
        for (Player p : list) p.printInfo();

    }

    public Set<Player> findPlayersWithName(String name) {
        return this.team.keySet().stream().filter((n) -> containsIgnoreCase(n, name)).map(n -> team.get(n)).collect(Collectors.toSet());
    }


    public Set<Player> findPlayersWithScore(int start, int lim) {
        return this.team.values().stream().filter(pl -> start <= pl.getScore() && pl.getScore() <= lim).collect(Collectors.toSet());
    }


    @Override
    public String toString() {
        return "Team{" + "team=" + team + '}';
    }

    public void print() {
        System.out.println(this);
    }

    private boolean containsIgnoreCase(@NotNull String org, @NotNull String txt) {
        return org.trim().toLowerCase().contains(txt.trim().toLowerCase());
    }
}
