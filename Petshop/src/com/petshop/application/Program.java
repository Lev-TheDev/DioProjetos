package com.petshop.application;

import java.util.Locale;
import java.util.Scanner;

import com.petshop.entities.Pet;
import com.petshop.entities.PetMachine;

public class Program {
	
	private final static Scanner sc = new Scanner(System.in).useLocale(Locale.US);
	private final static PetMachine petMachine = new PetMachine();

	public static void main(String[] args) {
		sc.useDelimiter("\\n");
		
		var option = -1;
		
		do {
			System.out.println("===========================");
			System.out.println("    Choose an option:");
			System.out.println("===========================");
			System.out.println("1 - Bathing your pet");
			System.out.println("2 - Fill machine with water");
			System.out.println("3 - Fill machine with shampoo");
			System.out.println("4 - Check machine water");
			System.out.println("5 - Check machine shampoo");
			System.out.println("6 - Check if there is a pet in the shower");
			System.out.println("7 - Take the pet to the machine");
			System.out.println("8 - Pick-up the pet from the machine");
			System.out.println("9 - Clean the machine");
			System.out.println("0 - ESC");
			option = sc.nextInt();
			
			switch (option) {
				case 1 -> petMachine.bathingPet();
				case 2 -> setWater();
				case 3 -> setShampoo();
				case 4 -> verifyWater();
				case 5 -> verifyShampoo();
				case 6 -> checkIfHasPetInMachine();
				case 7 -> setPetInPetMachine();
				case 8 -> petMachine.removePet();
				case 9 -> petMachine.washMachine();
				case 0 -> System.exit(0);
				default -> System.out.println("Opção inválida!");
			}
		} while (true);
		
	}
	
	private static void setWater() {
		System.out.println("Trying to fill the Machine with water.");
		petMachine.addWater();
	}
	
	private static void setShampoo() {
		System.out.println("Trying to fill the Machine with shampoo.");
		petMachine.addShampoo();
	}

	private static void verifyWater() {
		var amount = petMachine.getWater();
		System.out.println("The machine has " + amount + " liter(s) of water.");
	}
	
	private static void verifyShampoo() {
		var amount = petMachine.getShampoo();
		System.out.println("The machine has " + amount + " liter(s) of shampoo.");
	}
	
	private static void checkIfHasPetInMachine() {
		var hasPet = petMachine.hasPet();
		System.out.println(hasPet ? "There is a Pet in the Machine." : "There's NOT a Pet in the Machine.");
	}

	public static void setPetInPetMachine() {
		String name = "";
		while (name == null || name.isEmpty()) {
			System.out.print("Pet's name: ");
			name = sc.next();	
		}
			
		Pet pet = new Pet(name);
		petMachine.setPet(pet);
	}
	
}
