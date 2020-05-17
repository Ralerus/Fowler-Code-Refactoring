package main;

import java.lang.*;
import java.util.*;

public class Customer {
    private String name;
    private Vector rentals = new Vector();
    public Customer (String newname){
        name = newname;
    };
    public void addRental(Rental arg) {
        rentals.addElement(arg);
    };
    public String getName (){
        return name;
    };
    public String statement() {
        Enumeration enum_rentals = rentals.elements();	    
        String result = "Rental Record for " + this.getName() + "\n";
        result += "\t" + "Title" + "\t" + "\t" + "Days" + "\t" + "Amount" + "\n";

        while (enum_rentals.hasMoreElements()) {
            Rental each = (Rental) enum_rentals.nextElement();
            //show figures for this rental
            result += "\t" + each.getMovie().getTitle()+ "\t" + "\t" + each.getDaysRented() + "\t" + String.valueOf(each.getCharge()) + "\n";
        }
        //add footer lines
        result += "Amount owed is " + String.valueOf(getTotalCharge()) + "\n";
        result += "You earned " + String.valueOf(getTotalFrequenterPoints()) + " frequent renter points";
        return result;
    }
    
    public String htmlStatement() {
    	 Enumeration enum_rentals = rentals.elements();	    
         String result = "<H1>Rental Record for <EM>" + this.getName() + "</EM></H1><P>\n";
         result += "\t" + "Title" + "\t" + "\t" + "Days" + "\t" + "Amount" + "\n";

         while (enum_rentals.hasMoreElements()) {
             Rental each = (Rental) enum_rentals.nextElement();
             //show figures for this rental
             result += "\t" + each.getMovie().getTitle()+ ": " + String.valueOf(each.getCharge()) + "</BR>\n";
         }
         //add footer lines
         result += "<P> You owe <EM>" + String.valueOf(getTotalCharge()) + "</EM></P>\n";
         result += "On this rental you earned <EM>" + String.valueOf(getTotalFrequenterPoints()) + "</EM> frequent renter points</P>";
         return result;
    }
    
    private double getTotalCharge() {
    	Enumeration enum_rentals = rentals.elements();
    	double totalAmount = 0;
		while (enum_rentals.hasMoreElements()) {
	        Rental each = (Rental) enum_rentals.nextElement();
	        totalAmount += each.getCharge();
	    }
		return totalAmount;	
    }
    
    private int getTotalFrequenterPoints() {
        int frequentRenterPoints = 0;
        Enumeration enum_rentals = rentals.elements();      
        while (enum_rentals.hasMoreElements()) {
            Rental each = (Rental) enum_rentals.nextElement();
            frequentRenterPoints += each.getFrequentRenterPoints();
        }
        return frequentRenterPoints;
    }
    

}
    