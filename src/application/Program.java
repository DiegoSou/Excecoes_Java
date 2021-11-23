package application;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

import model.entities.Reservation;
import model.exceptions.DomainException;

public class Program {

	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		
		try {
			System.out.print("Room number: ");
			int number = scan.nextInt();
			System.out.print("Check-in Date (dd/MM/yyyy): ");
			Date checkin = sdf.parse(scan.next());
			System.out.print("Check-out Date (dd/MM/yyyy): ");
			Date checkout = sdf.parse(scan.next());
			
			Reservation reserv = new Reservation(number, checkin, checkout);
			System.out.println("Reservation: " + reserv);
			
			
			System.out.println();
			System.out.println("Enter data to update the reservation: ");
			System.out.print("Check-in date (dd/MM/yyyy): ");
			checkin = sdf.parse(scan.next());
			System.out.print("Check-out date (dd/MM/yyyy): ");
			checkout = sdf.parse(scan.next());
			
	
			reserv.updateDates(checkin, checkout);
			System.out.print("Reservation: " + reserv);	
		}
		
		catch (ParseException e){
			System.out.println("Invalid date format.");
		}
		catch (DomainException e) {
			System.out.println("Error in reservation: " + e.getMessage());
		}
		catch (RuntimeException e) {
			System.out.println("Unexpected error");
		}
		
		
		scan.close();
	}

}
