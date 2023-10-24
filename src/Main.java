import java.util.Scanner;
public class Main
{
	// Defining colour-codes
	public static final String COLOUR_RESET = "\u001B[0m";
	public static final String COLOUR_WHITE_BOLD = "\033[1;37m";
	public static final String COLOUR_RED = "\u001B[31m";
	private static int classVarPizzaPrice = 0;
	private static int classVarToppingPrice = 0;
	private static String classVarPizzaName = "";




	public static void main(String[] args)
	{


		// Prompts the user to choose a pizza in a method
		choosePizza();

		// Creating bools of which toppings the customer want on their pizza
		boolean toppingBacon = false;
		boolean toppingDressing = false;
		boolean toppingPepperoni = false;
		boolean toppingAnanas = false;
		boolean toppingJalapenos = false;
		boolean toppingHvidlog = false;
		boolean toppingChili = false;

		// Creates a string variable, that gets its data from the pizzaToppings method. Output in numbers in a string.
		String toppings = pizzaToppings();
		// Loops through the string, and checks which toppings the customer has chosen. The loop has checked the code for duplicates
		for (int i = 0; i < toppings.length(); i++)
		{
			int currentNum = Character.getNumericValue(toppings.charAt(i));
			switch (currentNum)
			{
				case 1: toppingBacon = true; classVarToppingPrice += 10; break;
				case 2: toppingDressing = true; break;
				case 3: toppingPepperoni = true; classVarToppingPrice += 10; break;
				case 4: toppingAnanas = true; classVarToppingPrice += 5; break;
				case 5: toppingJalapenos = true; classVarToppingPrice += 5; break;
				case 6: toppingHvidlog = true; classVarToppingPrice += 5; break;
				case 7: toppingChili = true; break;
			}
		}

		// Creating variables for the size name and which factor the price should be doubled with
		String pizzaSizeName = "";
		double priceFactor = 0;
		switch (pizzaSize())
		{
			case 1: priceFactor = 0.75; pizzaSizeName = "Childrens Size"; break;
			case 2: priceFactor = 1; pizzaSizeName = "Standard Size"; break;
			case 3: priceFactor = 1.5; pizzaSizeName = "Large Size"; break;
		}

		// printing out the final receipt
		// Notice: the toppings price is also effected by the size of the pizza
		System.out.printf("%n%17s%n", "RECEIPT");
		System.out.printf("Pizza:%n");
		System.out.printf("		%s%s%.2f DKK%n", classVarPizzaName, ".".repeat(20-classVarPizzaName.length()), classVarPizzaPrice*priceFactor);

		// Checks if the bools are true and then prints the toppings on the receipt
		System.out.printf("Toppings:%n");
		if (toppingBacon)
			System.out.printf("		Bacon%s%.2f DKK%n", ".".repeat( 20-"Bacon".length()), 10*priceFactor);
		if (toppingDressing)
			System.out.printf("		Dressing%s%.2f DKK%n", ".".repeat(20-"Dressing".length()), 0.00);
		if (toppingPepperoni)
			System.out.printf("		Pepperoni%s%.2f DKK%n", ".".repeat(20-"Pepperoni".length()), 10*priceFactor);
		if (toppingAnanas)
			System.out.printf("		Ananas%s%.2f DKK%n", ".".repeat(20-"Ananas".length()), 5*priceFactor);
		if (toppingJalapenos)
			System.out.printf("		Jalapeños%s%.2f DKK%n", ".".repeat(20-"Jalapenos".length()), 5*priceFactor);
		if (toppingHvidlog)
			System.out.printf("		Hvidløg%s%.2f DKK%n", ".".repeat(20-"Hvidløg".length()), 5*priceFactor);
		if (toppingChili)
			System.out.printf("		Chili%s%.2f DKK%n", ".".repeat(20-"Chili".length()), 0.00);

		// Size is just the saved size in the pizzaSizeName variabel
		System.out.printf("Size:%n");
		System.out.printf("		%s", pizzaSizeName);

		// Total is the price of pizza and toppings and then multiplied by the price factor
		System.out.printf("%n%nTotal:%n");
		System.out.printf("		%.2f DKK", (classVarPizzaPrice+classVarToppingPrice)*priceFactor);
	}




	public static void choosePizza()
	{
		// Calls scanner, because we want the user to input the toppings they want
		Scanner input = new Scanner(System.in);

		// Prints out the menu
		System.out.printf(COLOUR_RED + "Pizza Menu%n" + COLOUR_RESET);
		System.out.printf("1. " + COLOUR_WHITE_BOLD + "Margherita " + COLOUR_RESET + "%33s", "- 60 DKK | tomat, ost & oregano");
		System.out.printf("%n2. " + COLOUR_WHITE_BOLD + "Prima " + COLOUR_RESET + "%68s", "- 70 DKK | tomat, ost, kalkunskinke, pepperoni, løg & oregano");
		System.out.printf("%n3. " + COLOUR_WHITE_BOLD + "Hawaii " + COLOUR_RESET + "%59s", "- 60 DKK | tomat, ost, kalkunskinke, ananas & oregano");
		System.out.printf("%n4. " + COLOUR_WHITE_BOLD + "Pepperoni " + COLOUR_RESET + "%52s", "- 60 DKK | tomat, ost, pepperoni, chili & oregano");
		System.out.printf("%n5. " + COLOUR_WHITE_BOLD + "Cop " + COLOUR_RESET + "%59s", "- 60 DKK | tomat, ost, kalkunskinke, løg & oregano");
		System.out.printf("%n6. " + COLOUR_WHITE_BOLD + "Capricciosa " + COLOUR_RESET + "%44s", "- 60 DKK | tomat, ost, champignon & oregano");
		System.out.printf("%n7. " + COLOUR_WHITE_BOLD + "Isabella " + COLOUR_RESET + "%62s", "- 70 DKK | tomat, ost, kalkunskinke, majs, bacon & oregano");
		System.out.printf("%n8. " + COLOUR_WHITE_BOLD + "Top " + COLOUR_RESET + "%108s", "- 70 DKK | tomat, ost, oksekød, løg, oliven, peberfrugt, champignon, hvidløg, tomatskiver & oregano");
		System.out.printf("%n9. " + COLOUR_WHITE_BOLD + "Hot Shot " + COLOUR_RESET + "%61s", "- 65 DKK | tomat, ost, pepperoni, salami, chili & oregano");
		System.out.printf("%n10. " + COLOUR_WHITE_BOLD + "Al Torino " + COLOUR_RESET + "%78s", "- 70 DKK | tomat, ost, kebab, grøn salat, chili, hvidløg, dressing & oregano");
		System.out.printf("%n%nPlease choose a pizza (the number): ");

		// Depending on the chosen pizza, the switch statement will change the pizzas base price and the pizza name
		switch(inputNumberIntPizza(input.next()))
		{
			case 1: classVarPizzaPrice = 60; classVarPizzaName = "Margherita";	break;
			case 2: classVarPizzaPrice = 70; classVarPizzaName = "Prima";		break;
			case 3: classVarPizzaPrice = 60; classVarPizzaName = "Hawaii";		break;
			case 4: classVarPizzaPrice = 60; classVarPizzaName = "Pepperoni"; 	break;
			case 5: classVarPizzaPrice = 60; classVarPizzaName = "Cop"; 		break;
			case 6: classVarPizzaPrice = 60; classVarPizzaName = "Capricciosa"; break;
			case 7: classVarPizzaPrice = 70; classVarPizzaName = "Isabella";	break;
			case 8: classVarPizzaPrice = 70; classVarPizzaName = "Top";			break;
			case 9: classVarPizzaPrice = 65; classVarPizzaName = "Hot Shot";	break;
			case 10: classVarPizzaPrice = 70; classVarPizzaName = "Al Torino";	break;
		}
	}


	private static int pizzaSize()
	{
		// Calls scanner, because we want the user to input the size they want
		Scanner input = new Scanner(System.in);

		//Creates the pizza price in advanced, so the customer can see what the different sizes will cost
		double pizzaPrice = classVarPizzaPrice + classVarToppingPrice;

		// Prints the different sizes and then the price
		System.out.printf(COLOUR_RED + "%nPizza Size%n" + COLOUR_RESET);
		System.out.printf("1. Child size %7s %.2f DKK%n", "- ", pizzaPrice*0.75);
		System.out.printf("2. Standard size %4s %.2f DKK%n", "- ", pizzaPrice);
		System.out.printf("3. Family size %6s %.2f DKK%n", "- ", pizzaPrice*1.5);
		System.out.printf("%nPlease choose a size (the number): ");

		// returns the selected size, but has been checked if it is a number on the menu and an int
		return inputNumberIntSize(input.next());

	}


	public static String pizzaToppings()
	{
		// Calls scanner, because we want the user to input the toppings they want
		Scanner input = new Scanner(System.in);

		// We create a string, which we are going to return
		String intToppings = "";

		// We create bools of the toppings, since we want it to only take one topping
		boolean toppingBacon = false;
		boolean toppingDressing = false;
		boolean toppingPepperoni = false;
		boolean toppingAnanas = false;
		boolean toppingJalapenos = false;
		boolean toppingHvidlog = false;
		boolean toppingChili = false;

		// Prints out the different toppings and their prices
		System.out.printf(COLOUR_RED + "%nToppings" + COLOUR_RESET);
		System.out.printf("%n1. " + COLOUR_WHITE_BOLD + "Bacon " + COLOUR_RESET + "%14s", "- 10 DKK");
		System.out.printf("%n2. " + COLOUR_WHITE_BOLD + "Dressing " + COLOUR_RESET + "%10s", "- 0 DKK");
		System.out.printf("%n3. " + COLOUR_WHITE_BOLD + "Pepperoni " + COLOUR_RESET + "%10s", "- 10 DKK");
		System.out.printf("%n4. " + COLOUR_WHITE_BOLD + "Ananas " + COLOUR_RESET + "%12s", "- 5 DKK");
		System.out.printf("%n5. " + COLOUR_WHITE_BOLD + "Jalapeños " + COLOUR_RESET + "%9s", "- 5 DKK");
		System.out.printf("%n6. " + COLOUR_WHITE_BOLD + "Hvidløg " + COLOUR_RESET + "%11s", "- 5 DKK");
		System.out.printf("%n7. " + COLOUR_WHITE_BOLD + "Chili " + COLOUR_RESET + "%13s", "- 0 DKK");
		System.out.printf("%n%nPlease choose the toppings you want %n(fx. 15 for Bacon and Jalapeños & 0 for nothing): ");

		// We create a loop to check each of the toppings and if it has been used before, it will skip
		String strToppings = inputNumberStrToppings(input.next());
		for (int i = 0; i < strToppings.length(); i++)
		{
			int currentNum = Character.getNumericValue(strToppings.charAt(i));
			if (currentNum == 1 && !toppingBacon)
			{
				toppingBacon = !toppingBacon;
				intToppings += "1";
			}
			else if (currentNum == 2 && !toppingDressing)
			{
				toppingDressing = !toppingDressing;
				intToppings += "2";
			}
			else if (currentNum == 3 && !toppingPepperoni)
			{
				toppingPepperoni = !toppingPepperoni;
				intToppings += "3";
			}
			else if (currentNum == 4 && !toppingAnanas)
			{
				toppingAnanas = !toppingAnanas;
				intToppings += "4";
			}
			else if (currentNum == 5 && !toppingJalapenos)
			{
				toppingJalapenos = !toppingJalapenos;
				intToppings += "5";
			}
			else if (currentNum == 6 && !toppingHvidlog)
			{
				toppingHvidlog = !toppingHvidlog;
				intToppings += "6";
			}
			else if (currentNum == 7 && !toppingChili)
			{
				toppingChili = !toppingChili;
				intToppings += "7";
			}
		}
		// We return the single digit toppings
		return intToppings;
	}



	// Check if the input is an actual int
	public static boolean isInt(String str)
	{
		if (str == null) return false;
		try {
			Integer.parseInt(str);
			return true;
		} catch (NumberFormatException e) {
			return false;
		}
	}
	public static int inputNumberIntPizza(String str)
	{
		Scanner input = new Scanner(System.in);
		while (!isInt(str) || Integer.parseInt(str) > 10 || Integer.parseInt(str) < 1)
		{
			System.out.println("You have to input a menu number.");
			str = input.next();
		}
		return Integer.parseInt(str);
	}
	public static String inputNumberStrToppings(String str)
	{
		Scanner input = new Scanner(System.in);
		while (!isInt(str))
		{
			System.out.println("You have to input a topping number.");
			str = input.next();
		}
		return str;
	}
	public static int inputNumberIntSize(String str)
	{
		Scanner input = new Scanner(System.in);
		while (!isInt(str) || Integer.parseInt(str) > 3 || Integer.parseInt(str) < 1)
		{
			System.out.println("You have to input a size number.");
			str = input.next();
		}
		return Integer.parseInt(str);
	}
}