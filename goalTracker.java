package goalTracker;

import java.util.ArrayList;
import java.util.Scanner;

class Goal {
    private String description;
    private boolean isComplete;

    public Goal(String description) {
        this.description = description;
        this.isComplete = false;
    }

    public String getDescription() {
        return description;
    }

    public boolean isComplete() {
        return isComplete;
    }

    public void markAsComplete() {
        isComplete = true;
    }

    @Override
    public String toString() {
        return "Goal: " + description + " | Status: " + (isComplete ? "Complete" : "Incomplete");
    }
}

class GoalTracker {
    private ArrayList<Goal> goals;

    public GoalTracker() {
        this.goals = new ArrayList<>();
    }

    public void addGoal(Goal goal) {
        goals.add(goal);
    }

    public void displayGoals() {
        System.out.println("----- Goals -----");
        for (Goal goal : goals) {
            System.out.println(goal);
        }
        System.out.println("-----------------");
    }

    public void markGoalAsComplete(int index) {
        if (index >= 0 && index < goals.size()) {
            goals.get(index).markAsComplete();
            System.out.println("Goal marked as complete: " + goals.get(index).getDescription());
        } else {
            System.out.println("Invalid index.");
        }
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        GoalTracker goalTracker = new GoalTracker();

        while (true) {
            System.out.println("1. Add Goal");
            System.out.println("2. Display Goals");
            System.out.println("3. Mark Goal as Complete");
            System.out.println("4. Exit");

            System.out.print("Choose an option: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume the newline character

            switch (choice) {
                case 1:
                    System.out.print("Enter goal description: ");
                    String goalDescription = scanner.nextLine();
                    Goal newGoal = new Goal(goalDescription);
                    goalTracker.addGoal(newGoal);
                    System.out.println("Goal added: " + newGoal.getDescription());
                    break;

                case 2:
                    goalTracker.displayGoals();
                    break;

                case 3:
                    System.out.print("Enter the index of the goal to mark as complete: ");
                    int index = scanner.nextInt();
                    goalTracker.markGoalAsComplete(index);
                    break;

                case 4:
                    System.out.println("Exiting Goal Tracker. Goodbye!");
                    System.exit(0);

                default:
                    System.out.println("Invalid choice. Please enter a valid option.");
            }
        }
    }
}
