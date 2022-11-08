
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * 
 */
//class Exception to catch any unexpected events
class ExceptionCar extends Exception {

    public ExceptionCar() {
    }

    public ExceptionCar(String msg){
        super(msg);
    }
}


// It should have been more like this
/*class ColorMismatchException extends Exception {

   public ColorMismatchException(){}

}


class  PriceMistchMatchException extends Exception {

    public PriceMistchMatchException(){}

}


class DayMitchMatchException extends Exception {

    public DayMitchMatchException(){}

}*/

public class Main {
    //Declare scanner
    private static final Scanner in = new Scanner(System.in);
    
    //String validator
    //catch ExceptionCar e if result.length() == 0
    private static String checkInputString() throws ExceptionCar {
        while (true) {
            try {
                String result = in.nextLine();
                if (result.length() == 0) {//Condition for ExceptionCar
                    throw new ExceptionCar();//Throw a new exception here to catch, if your don't it would terminate the program, displaying the exception
            } else {
                    return result;
            }
            } catch (ExceptionCar e) {//Caught an exception, display warning
                System.out.println("Not Empty");
            }
            
        }
    }
     

    //Choice validator
    //Return either True or False
    private static boolean checkYN() throws ExceptionCar {
        while (true) {
            String result = checkInputString();
            if (result.length() == 1) {
                char resultChar = result.charAt(0);
                if (resultChar == 'y' || resultChar == 'Y') {
                    return true;
                }
                if (resultChar == 'n' || resultChar == 'N') {
                    return false;
                }
            }
            System.out.println("Re-input");
        }
    }


    //check if price is higher than zero
    //catch ExceptionCar at price<0
    private static boolean isHigherThanZero(int price){
       try {
            if (price>=0) return true;
            else throw new ExceptionCar();
       } catch (ExceptionCar e) {
            System.out.println("Can't sell Car");
            System.out.println("Price greater than zero");
       }
       return false;
    }



    //check if input price is actually digit
    //catch NumberFormatException at newPrice
    private static boolean isDigit(String price){
        try {
            Integer.parseInt(price);
            return true;
        } catch (NumberFormatException ex) {
            System.out.println("Can't sell Car");
            System.out.println("Price is digit");
            return false;
        }
    }

    //checkout if car exists
    //private static boolean isColorMatch(){}
    //private static boolean isPriceMatch(){}
    //private static boolean isDayMatch(){}


    //to check if the car is painted
    private static boolean isNoColor;

    //Check if the color match with color in the list
    //boolean check to check if the color match
    //catch ExceptionCar at check==false
    private static boolean isColorMatch(String[] listColor, String color) throws ExceptionCar{
        boolean check = false;
        try{
            if (!color.equalsIgnoreCase("no color")){
                for (int i =0; i< listColor.length; i++){
                    if (color.equalsIgnoreCase(listColor[i])){
                        check = true;
                        break;
                    }
                }
            }else if (color.equalsIgnoreCase("no color")){
                isNoColor=true;
                check = true;
            }
            if (!check) throw new ExceptionCar();
        }catch (ExceptionCar ex) {
                System.out.println("Can't sell car");
                System.out.println("Color Car does not exist");
        }
        return check;
    }

    //private int isDigit(){};
    //private boolean isHigherThanZero(){}




    //Check if the price match with price in the list
    //boolean check to check if the price match
    //catch ExceptionCar at check==false
    private static boolean isPriceMatch(String[] listPrice, String price) throws ExceptionCar{
        boolean check = false;
        if (!isDigit(price)) return false; //exit without catching this ExceptionCar
        int newPrice = Integer.parseInt(price); 
        if (!isHigherThanZero(newPrice)) return false;// exit without catching this ExceptionCar
        if (isNoColor==true) newPrice+=100;//Because u get discount of 100 if you get unpainted car
        String finalPrice = Integer.toString(newPrice);
        try {
            for (int i = 0; i< listPrice.length;i++){
                if (finalPrice.equals(listPrice[i])){
                    check = true;
                    break;
                }
            }
            if (!check) throw new ExceptionCar();
        } catch (ExceptionCar ex) {
            System.out.println("Can't sell car");
            System.out.println("Price Car does not exist");
        }
        return check;
    }


    //Check if the day match with day in the list
    //boolean check to check if the day match
    //catch ExceptionCar at check==false
    private static boolean isDayMatch(String[] listSold, String today) throws ExceptionCar{
        boolean check = false;
        try {
            for (int i = 0; i < listSold.length; i++) {
                if (today.equalsIgnoreCase(listSold[i])) {
                    check = true;
                    break;
                }
            }
            if (!check) throw new ExceptionCar();
        } catch (ExceptionCar ex) {
            System.out.println("Can't sell car");
            System.out.println("Car can't sell today");
        }
        return check;
    }

    //Check if car with input propertries does really exist 
    private static boolean checkCarExist(Car car, String color, String price, String today) throws ExceptionCar {
        String[] listColor = car.getColer();
        String[] listPrice = car.getPrice();
        String[] listSold = car.getSoldOn();
        //System.out.println(listSold[0] +listSold[1]);
        if (isColorMatch(listColor, color) && isPriceMatch(listPrice, price) && isDayMatch(listSold, today) ) return true;
        return false;
    }


    //add Car to List
    private static void addCar(ArrayList<Car> lc) {
        String[] listColorAudi = {"White", "Yellow", "Orange"};
        String[] listPriceAudi = {"5500","3000", "4500"};
        String[] listSoldDayAudi = {"Friday", "Sunday", "Monday"};
        lc.add(new Car("Audi", listColorAudi, listPriceAudi, listSoldDayAudi));

        String[] listColorMercedes = {"Green", "Blue", "Purple"};
        String[] listPriceMercedes = {"5000", "6000", "8500"};
        String[] listSoldDayMercedes = {"TuesDay", "Saturday", "Wednesday"};
        lc.add(new Car("Mercedes", listColorMercedes, listPriceMercedes,
                listSoldDayMercedes));

        String[] listColorBMW = {"Pink", "Red", "Brown"};
        String[] listPriceBMW = {"2500", "3000", "3500"};
        String[] listSoldDayBMW = {"Monday", "Sunday", "Thursday"};
        lc.add(new Car("BMW", listColorBMW, listPriceBMW, listSoldDayBMW));
    }

    
    private static boolean checkNameCar(ArrayList<Car> lc, String name, String color, String price, String today) throws ExceptionCar {
        boolean exist =false;
        try {
            int pos=-1;
            for (int i = 0; i < lc.size(); i++) {
                pos++;    
                if (name.equalsIgnoreCase(lc.get(i).getNameCar())) {
                    exist=true;
                    break;
                }
            }
            if (!exist) throw new ExceptionCar();
            if (checkCarExist(lc.get(pos), color, price, today)) {
                System.out.println("Sell Car");
                System.out.print("Do you want find more?(Y/N): ");
                if (!checkYN()) return false;
            }
        }catch (ExceptionCar ex) {
            System.out.println("Can't sell car");
            System.out.println("Car Break");
        }
        return true;
    }



    private static void display() throws ExceptionCar {
        ArrayList<Car> lc = new ArrayList<>();
        addCar(lc);
        System.out.println("===== Showroom car program =====");
        System.out.println("Input information of car");
        while (true){
            System.out.print("Name: ");
            String name = checkInputString();
            System.out.print("Color: ");
            String color = checkInputString();
            System.out.print("Price: ");
            String price = checkInputString();
            System.out.print("Today: ");
            String today = checkInputString();
            if (!checkNameCar(lc, name, color, price, today)) {
                return;
            }
        }
    }

    public static void main(String[] args) throws ExceptionCar {
        display();
    }
}
