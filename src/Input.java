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
        return input.equalsIgnoreCase("y") || input.equalsIgnoreCase("yes");
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
        boolean userContinue = true;
        int input;
        do {
            System.out.println(prompt);
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
        boolean validEntry;
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
        return Integer.parseInt(userInt);
    }

    public double getDouble(double min, double max){
        boolean userContinue = true;
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
        boolean validEntry;
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
        return Double.parseDouble(userDouble);
    }

    public void formatPhoneNumber(String phoneNumber) {
        String number;
        if(phoneNumber.length() == 10) {
            number = phoneNumber.replaceFirst("(\\d{3})(\\d{3})(\\d+)", "($1) $2-$3");
            System.out.println(number);
        } else if (phoneNumber.length() == 7) {
            number = phoneNumber.replaceFirst("(\\d{3})(\\d+)", "$1-$2");
            System.out.println(number);
        } else {
            System.out.println("Please enter a 7 or 10 digit number.");
        }
    }



}
