package com.day02_collection.map_interface;

import java.util.*;
import java.time.*;

class Policy {
    String policyNumber, policyholder;
    LocalDate expiryDate;

    // Constructor to initialize the instance variable
    Policy(String num, String holder, LocalDate expiry) {
        this.policyNumber = num;
        this.policyholder = holder;
        this.expiryDate = expiry;
    }

    @Override
    public String toString() {
        return policyNumber + " - " + policyholder + " (Expires: " + expiryDate + ")";
    }
}

public class InsurancePolicyManagement {
    // Store by policy number
    Map<String, Policy> policies = new HashMap<>();

    LinkedHashMap<String, Policy> orderedPolicies = new LinkedHashMap<>(); // Maintain order

    TreeMap<LocalDate, List<Policy>> sortedByExpiry = new TreeMap<>(); // Sort by expiry date

    void addPolicy(Policy policy) {
        policies.put(policy.policyNumber, policy);
        orderedPolicies.put(policy.policyNumber, policy);
        sortedByExpiry.computeIfAbsent(policy.expiryDate, k -> new ArrayList<>()).add(policy);
    }

    // Retrieve policy by number
    Policy getPolicy(String policyNumber) {
        return policies.get(policyNumber);
    }

    List<Policy> getExpiringPolicies(int days) {
        return sortedByExpiry.headMap(LocalDate.now().plusDays(days), true)
                .values().stream().flatMap(List::stream).toList();
    }

    List<Policy> getPoliciesByHolder(String holder) {
        return policies.values().stream().filter(p -> p.policyholder.equals(holder)).toList();
    }

    void removeExpiredPolicies() {
        LocalDate today = LocalDate.now();
        sortedByExpiry.headMap(today, true).clear();
        policies.values().removeIf(p -> p.expiryDate.isBefore(today));
        orderedPolicies.values().removeIf(p -> p.expiryDate.isBefore(today));
    }

    public static void main(String[] args) {
        InsurancePolicyManagement manager = new InsurancePolicyManagement();

        manager.addPolicy(new Policy("P001", "Alice", LocalDate.of(2024, 3, 10)));

        manager.addPolicy(new Policy("P002", "Bob", LocalDate.of(2024, 2, 25)));

        manager.addPolicy(new Policy("P003", "Alice", LocalDate.of(2024, 4, 15)));

        System.out.println("Expiring in 30 days: " + manager.getExpiringPolicies(30));

        System.out.println("Policies for Alice: " + manager.getPoliciesByHolder("Alice"));
        manager.removeExpiredPolicies();
        System.out.println("Policies after removing expired ones: " + manager.policies);
    }
}

