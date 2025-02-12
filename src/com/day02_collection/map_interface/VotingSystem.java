package com.day02_collection.map_interface;

import java.util.*;

public class VotingSystem {
    // Candidate -> Votes
    Map<String, Integer> votes = new HashMap<>();

    // Maintain vote order
    LinkedHashMap<String, Integer> voteOrder = new LinkedHashMap<>();

    // Display results in sorted order
    TreeMap<String, Integer> sortedVotes = new TreeMap<>();

    void castVote(String candidate) {
        votes.put(candidate, votes.getOrDefault(candidate, 0) + 1);
        voteOrder.put(candidate, votes.get(candidate));
        sortedVotes.put(candidate, votes.get(candidate));
    }

    void displayResults() {
        System.out.println("Votes in order of casting: " + voteOrder);
        System.out.println("Votes sorted by candidate name: " + sortedVotes);
    }

    public static void main(String[] args) {
        VotingSystem voting = new VotingSystem();
        voting.castVote("Alice");
        voting.castVote("Bob");
        voting.castVote("Alice");
        voting.castVote("Charlie");
        voting.castVote("Bob");
        voting.castVote("Alice");

        voting.displayResults();
    }
}
