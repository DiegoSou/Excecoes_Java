package application;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

import model.entities.Reservation;

public class Program {

	public static void main(String[] args) throws ParseException {
		
		Scanner scan = new Scanner(System.in);
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		
		System.out.print("Room number: ");
		int number = scan.nextInt();
		System.out.print("Check-in Date (dd/MM/yyyy): ");
		Date checkin = sdf.parse(scan.next());
		System.out.print("Check-out Date (dd/MM/yyyy): ");
		Date checkout = sdf.parse(scan.next());
		
		
		if(!checkout.after(checkin)) {
			System.out.println("Error in reservation: Check-out date must be after check-in date");
		}else {
			Reservation reserv = new Reservation(number, checkin, checkout);
			System.out.print("Reservation: " + reserv);
			
			System.out.println(); 
			System.out.println();
			
			System.out.println("Enter data to update the reservation: ");
			System.out.print("Check-in date (dd/MM/yyyy): ");
			checkin = sdf.parse(scan.next());
			System.out.print("Check-out date (dd/MM/yyyy): ");
			checkout = sdf.parse(scan.next());
			
			Date now = new Date();
			if(checkin.before(now) || checkout.before(now)) {
				System.out.println("Error in reservation: Check-out date must be after check-in date");
			}else if(!checkout.after(checkin)) {
				System.out.println("Error in reservation: Check-out date must be after check-in date");
			}else {
				reserv.updateDates(checkin, checkout);
				System.out.print("Reservation: " + reserv);
			}
			
		}
		
		
		
		scan.close();
	}

}
