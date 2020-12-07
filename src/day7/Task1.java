package day7;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.*;

public class Task1 {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner scanner = new Scanner(new FileReader(".\\src\\day7\\input"));

        // childrenOfBag is needed only in Task2, but this was made with foresight so i can easily copy-paste later
        Map<String, List<ChildBag>> childrenOfBag = new HashMap<>();
        Map<String, List<String>> parentsOfBag = new HashMap<>();

        while (scanner.hasNextLine()) {
            String line = scanner.nextLine();
            // before contain is parent, after contain are children
            String[] parts = line.split(" contain ");

            // remove " bags" from parent name
            String parent = parts[0].substring(0, parts[0].length() - 5);

            String[] childrenBags = parts[1].split(", ");
            for (int i = 0; i < childrenBags.length; ++i) {
                String child = childrenBags[i];
                String[] childSplit = child.split(" ", 2);

                // if the parent bag doesen't contain children bag break
                if (childSplit[0].equals("no")) {
                    break;
                }
                int number = Integer.parseInt(childSplit[0]);
                String bagName = childSplit[1];
                // remove the dot at the end
                if (i == childrenBags.length -1 ) {
                    bagName = bagName.substring(0, bagName.length()-1);
                }
                // remove bag or bags from the end of the phrase
                if (number == 1) {
                    // this removes " bag"
                    bagName = bagName.substring(0, bagName.length()-4);
                } else {
                    // this removes " bags"
                    bagName = bagName.substring(0, bagName.length()-5);
                }

//                System.out.println(parent + " contain " + number + " " + bagName + "!");

                // in the list that saves who are the children of parent bag add the new child bag
                List<ChildBag> parentBagContainer = childrenOfBag.get(parent);
                if (parentBagContainer == null) {
                    parentBagContainer = new ArrayList<>();
                    childrenOfBag.put(parent, parentBagContainer);
                }
                parentBagContainer.add(new ChildBag(bagName, number));

                // in the list that saves who are the parents of the bag add the parent
                List<String> childBagContainer = parentsOfBag.get(bagName);
                if (childBagContainer == null) {
                    childBagContainer = new ArrayList<>();
                    parentsOfBag.put(bagName, childBagContainer);
                }
                childBagContainer.add(parent);
                parentsOfBag.put(bagName, childBagContainer);
            }

        }

        int total = 0;
        Stack<String> traversalStack = new Stack<>();
        traversalStack.push("shiny gold");
        Map<String, Boolean> visited = new HashMap<>();

        while (!traversalStack.empty()) {
            String top = traversalStack.pop();

            for (String parent : parentsOfBag.get(top)) {
                System.out.println(parent);
               if (!visited.getOrDefault(parent, false)) {
                   total++;
                   visited.put(parent, true);

                   // if the current parent has parents add him to the stack, else we don't need him anymore
                   if (parentsOfBag.containsKey(parent)) {
                       traversalStack.push(parent);
                   }
               }
            }

        }

        System.out.println(total);

    }
}


