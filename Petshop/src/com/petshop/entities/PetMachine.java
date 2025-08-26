package com.petshop.entities;

public class PetMachine {
	private boolean clean = true;
	private int water = 30;
	private int shampoo = 10;
	private Pet pet;
	
	public void bathingPet() {
		if (this.pet == null) {
			System.out.println("Place the pet in the machine to initiate the bath.");
			return;
		}
		this.water -= 10;
		this.shampoo -= 2;
		pet.setClean(true);
		System.out.println("The pet " + pet.getName() + " is clean.");
		
	}
	
	public void addWater() {
		if (water == 30) {
			System.out.println("The machine water capacity is at maximum level.");
			return;
		} else {
			water +=2;
		}
	}
	
	public void addShampoo() {
		if (shampoo == 10) {
			System.out.println("The machine shampoo capacity is at maximum level.");
			return;
		} else {
			shampoo +=2;
		}
	}

	public int getWater() {
		return water;
	}

	public int getShampoo() {
		return shampoo;
	}

	public boolean hasPet() {
		return pet != null;
	}
	
	public void setPet(Pet pet) {
		if (!this.clean) {
			System.out.println("The machine is not clean. To bath your pet is necessary cleaning it.");
			return;
		}
		if (hasPet()) {
			System.out.println("The pet " + this.pet.getName() + " is at machine right now.");
			return;
		}
		this.pet = pet;
		System.out.println("The Pet " + pet.getName() + " was taken to the machine.");
	}
	
	public void removePet() {
		this.clean = this.pet.isClean();
		System.out.println("The pet " + this.pet.getName() + " is clean and was taken off the Machine!");
		this.pet = null;
	}
	
	public void washMachine() {
		this.water -= 10;
		this.shampoo -= 2;
		this.clean = true;
		System.out.println("The machine was cleaned!");
	}
}
