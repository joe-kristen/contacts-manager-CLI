import java.util.Scanner;

public class Input {

    private static Scanner scanner;

    public Input(){
        scanner = new Scanner(System.in);
    }

    public String getString(String sout){
        System.out.println(sout);
        return scanner.nextLine();
    }

    public boolean yesNo(String sout){
        System.out.println(sout);
        String input = scanner.nextLine();
        if(input.equalsIgnoreCase("y") || input.equalsIgnoreCase("yes")){
            return true;
        } else{
            return false;
        }
    }

//    public boolean yesNo(String sout){
//        System.out.println(sout);
//        String input = scanner.nextLine();
//        boolean returnVal = false;
//        boolean validInput = false;
//        do {
//            if (input.equalsIgnoreCase("y") || input.equalsIgnoreCase("yes")) {
//                returnVal = true;
//            } else if(input.equalsIgnoreCase("n") || input.equalsIgnoreCase("no")){
//                returnVal = false;
//            }else{
//                validInput = false;
//            }
//        }   while(!validInput);
//        return returnVal;
//    }


    public int getInt(int min, int max, String prompt){
        Boolean userContinue = true;
        int input;
        do {
            System.out.printf("Please enter a number between %d and %d", min, max);
            System.out.println();
            input = scanner.nextInt();
            if (input > max || input < min) {
                System.out.println("This is not a valid number");
            }   else if(input >= max || input <= min){
                userContinue = false;
            }
        }while(userContinue);
        return input;
    }

    public int getInt(String sout){
        Boolean validEntry;
        String userInt = null;
        do {
            try {
                userInt = getString(sout);
                Integer.valueOf(userInt);
                validEntry = true;
            } catch (Exception e) {
                System.out.println("That is not a valid entry");
                validEntry = false;
            }
        }   while(!validEntry);
        return Integer.valueOf(userInt);
    }

    public double getDouble(double min, double max){
        Boolean userContinue = true;
        double input;
        do {
            System.out.printf("Please enter a number between %f and %f", min, max);
            System.out.println();
            input = scanner.nextDouble();
            if (input > max || input < min) {
                System.out.println("This is not a valid number");
            }   else if(input <= max || input >= min){
                userContinue = false;
            }
        }while(userContinue);
        return input;
    }

    public double getDouble(String sout){
        Boolean validEntry;
        String userDouble = null;
        do {
            try {
                userDouble = getString(sout);
                Double.valueOf(userDouble);
                validEntry = true;
            } catch (Exception e) {
                System.out.println("That is not a valid entry");
                validEntry = false;
            }
        }   while(!validEntry);
        return Double.valueOf(userDouble);
    }


}
