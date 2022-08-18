package application;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

import entities.Departament;
import entities.HourContract;
import entities.Worker;
import entities.enums.WorkerLevel;

public class Main {

	public static void main(String[] args) throws ParseException {
		Scanner sc = new Scanner(System.in);
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		
		System.out.println("Enter departament's name: ");
		String departament = sc.nextLine();
		System.out.println();
		
		System.out.println("Enter worker's data: ");
		System.out.print("Name: ");
		String name = sc.nextLine();
		System.out.print("Level: ");
		String level = sc.nextLine();
		System.out.print("Base Salary: ");
		double baseSalary = sc.nextDouble();
		
		Worker worker = new Worker(name, WorkerLevel.valueOf(level), baseSalary, new Departament(departament));
		
		System.out.println();
		
		System.out.println("How many contracts have this whorker? ");
		int n = sc.nextInt();
		System.out.println();
		
		for(int i = 0; i < n; i++) {
			System.out.println("Enter contract #" + (i+1) + " data:");
			System.out.println("Date (DD/MM/YYYY)");
			Date contractDate = sdf.parse(sc.next());
			System.out.println("Value per Hour");
			double ValuePerHour = sc.nextDouble();
			System.out.println("Duration (Hours)");
			int hours = sc.nextInt();
			
			HourContract contract = new HourContract(ValuePerHour, hours, contractDate);
			worker.addContract(contract);			
		}
		System.out.println();
		
		System.out.println("Enter month and year to calculate income (MM/YYYY)");
		String MonthYear = sc.next();
		int month = Integer.parseInt(MonthYear.substring(0, 2));
		int year = Integer.parseInt(MonthYear.substring(3));
		
		System.out.println("Name : " + worker.getName());
		System.out.println("Departament: " + worker.getDepartament().getName());
		System.out.println("Income for " + MonthYear + ": " + String.format("%.2f", worker.income(year, month)));
		
		sc.close();
		
	}
}
