package main;

import java.io.IOException;

import interfaces.ConsleUserInterface;
import models.ConsoleUserInterfaceImpl;

public class Main {

	public static void main(String[] args) throws IOException {
		ConsleUserInterface consoleUI = new ConsoleUserInterfaceImpl();
		consoleUI.menu();
	}

}
