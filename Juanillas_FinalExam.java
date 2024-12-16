import java.util.Stack;

class CreatureSorter {

    // Creature class to hold name and power level
    static class Creature {
        String name;
        int powerLevel;

        Creature(String name, int powerLevel) {
            this.name = name;
            this.powerLevel = powerLevel;
        }

        @Override
        public String toString() {
            return name + " - " + powerLevel;
        }
    }

    public static void main(String[] args) {
        // creatures and their power levels
        Creature[] creatures = {
                new Creature("Dragon", 95),
                new Creature("Griffin", 88),
                new Creature("Unicorn", 78),
                new Creature("Phoenix", 92),
                new Creature("Centaur", 85)
        };

        System.out.println("* Bubble Sort: Descending Order by Power Level *");
        bubbleSortDescending(creatures);
        printCreatures(creatures);

        System.out.println("\n*** Selection Sort: Ascending Order by Power Level *");
        selectionSortAscending(creatures);
        printCreatures(creatures);

        System.out.println("\n*** Stack Implementation: Popping Creatures *");
        stackImplementation(creatures);
    }

    // Bubble Sort - power level in descending order
    public static void bubbleSortDescending(Creature[] creatures) {
        int n = creatures.length;
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (creatures[j].powerLevel < creatures[j + 1].powerLevel) {
                    // Swap the creatures
                    Creature temp = creatures[j];
                    creatures[j] = creatures[j + 1];
                    creatures[j + 1] = temp;
                }
            }
        }
    }

    // Selection Sort - power level in ascending order
    public static void selectionSortAscending(Creature[] creatures) {
        int n = creatures.length;
        for (int i = 0; i < n - 1; i++) {
            int minIndex = i;
            for (int j = i + 1; j < n; j++) {
                if (creatures[j].powerLevel < creatures[minIndex].powerLevel) {
                    minIndex = j;
                }
            }
            // Swap the creatures
            Creature temp = creatures[minIndex];
            creatures[minIndex] = creatures[i];
            creatures[i] = temp;
        }
    }

    // Stack implementation to display creatures in descending order
    public static void stackImplementation(Creature[] creatures) {
        // Sort creatures using bubble sort (descending order)
        bubbleSortDescending(creatures);

        // Push all creatures onto a stack
        Stack<Creature> stack = new Stack<>();
        for (Creature creature : creatures) {
            stack.push(creature);
        }

        // Pop and display creatures from the stack
        while (!stack.isEmpty()) {
            System.out.println("Popped: " + stack.pop());
        }
    }

    // Helper method to print creatures
    public static void printCreatures(Creature[] creatures) {
        for (Creature creature : creatures) {
            System.out.println(creature);
        }
    }
}