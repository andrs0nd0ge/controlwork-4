import entity.Cat;
import service.Service;

import java.util.*;
import java.util.stream.Collectors;

public class Main {

    public static void main(String[] args) {
        List<Cat> cats = new ArrayList<>();
        cats.add(new Cat("Peach", 11));
        cats.add(new Cat("Jasper", 12));
        cats.add(new Cat("Poppy", 9));
        Service.print(cats);
        addCatTo(cats);
        askUserForAction(cats);
        cats = cats.stream()
                .sorted(Comparator.comparing(Cat::getAverage).reversed())
                .collect(Collectors.toList());
        Service.print(cats);
    }

    private static void askUserForAction(List<Cat> cats) {
        int increment = 0;
        int decrement = 0;
        System.out.println("What would you like to do?\n" +
                "1. Feed a cat\n" +
                "2. Play with a cat\n" +
                "3. Send a cat to vet");
        int actionChoice = new Scanner(System.in).nextInt();
        int catChoice = askUserACat(cats);
        if (cats.get(catChoice - 1).getAge() >= 1 && cats.get(catChoice - 1).getAge() <= 5) {
            increment = 7;
            decrement = 3;
        } else if (cats.get(catChoice - 1).getAge() >= 6 && cats.get(catChoice - 1).getAge() <= 10) {
            increment = 5;
            decrement = 5;
        } else if (cats.get(catChoice - 1).getAge() >= 11) {
            increment = 4;
            decrement = 6;
        }
        switch (actionChoice) {
            case 1:
                cats.get(catChoice - 1).setSatietyLevel(cats.get(catChoice - 1).getSatietyLevel() + increment);
                cats.get(catChoice - 1).setMoodLevel(cats.get(catChoice - 1).getMoodLevel() + increment);
                System.out.printf("You've fed %s, who is %s years old\n", cats.get(catChoice - 1).getName(), cats.get(catChoice - 1).getAge());
                break;
            case 2:
                cats.get(catChoice - 1).setMoodLevel(cats.get(catChoice - 1).getMoodLevel() + increment);
                cats.get(catChoice - 1).setHealthLevel(cats.get(catChoice - 1).getHealthLevel() + increment);
                cats.get(catChoice - 1).setSatietyLevel(cats.get(catChoice - 1).getSatietyLevel() - decrement);
                System.out.printf("You've played with %s, who is %s years old\n", cats.get(catChoice - 1).getName(), cats.get(catChoice - 1).getAge());
                break;
            case 3:
                cats.get(catChoice - 1).setSatietyLevel(cats.get(catChoice - 1).getSatietyLevel() - decrement);
                cats.get(catChoice - 1).setMoodLevel(cats.get(catChoice - 1).getMoodLevel() - decrement);
                cats.get(catChoice - 1).setHealthLevel(cats.get(catChoice - 1).getHealthLevel() + increment);
                System.out.printf("You've healed %s, who is %s years old\n", cats.get(catChoice - 1).getName(), cats.get(catChoice - 1).getAge());
                break;
        }
    }

    private static int askUserACat(List<Cat> catList) {
        System.out.println("Enter cat number: (1-" + catList.size() + ")");
        return new Scanner(System.in).nextInt();
    }

    private static void addCatTo(List<Cat> cats) {
        System.out.print("Enter a name of new cat: ");
        String name = new Scanner(System.in).nextLine();
        System.out.print("Enter age of new cat: ");
        Integer age = new Scanner(System.in).nextInt();
        cats.add(new Cat(name, age));
    }
}