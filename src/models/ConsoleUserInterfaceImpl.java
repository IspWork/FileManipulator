package models;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

import abstact.AbstractFileReader;
import abstact.AbstractMapFileWriter;
import abstact.MapContentContainer;
import abstact.MapContentManipulator;
import interfaces.ConsleUserInterface;
import interfaces.KeyValidator;
import interfaces.ValueValidator;
import interfaces.Writer;

public class ConsoleUserInterfaceImpl implements ConsleUserInterface {
	private AbstractFileReader fileReader;
	private AbstractMapFileWriter<Integer, List<String>> fileWriter;
	private MapContentContainer<Integer, List<String>> contentContainer;
	private MapContentManipulator<Integer, List<String>> manipulator;
	private KeyValidator lineValidator;
	private ValueValidator numberValudator;
	private Writer consoleWriter;
	private BufferedReader bR;
	private List<String> userInput; // The user input.
	private String filePath;

	public ConsoleUserInterfaceImpl() {
		consoleWriter = new ConsloleWriter();
		numberValudator = new MapValueValidator();
		bR = new BufferedReader(new InputStreamReader(System.in));
		userInput = new ArrayList<>();

	}

	@Override
	public void menu() throws IOException {
		askFilePath();
		saveInContainer();
		startLoop();
	}

	private void startLoop() throws IOException {
		boolean run = true;
		addContentToManipulator();
		fileWriter = new WriteMapToFile(filePath);
		lineValidator = new MapKeyValidator(contentContainer.getContent().size());
		while (run) {
			operationalMenu();
			userInput.add(bR.readLine());
			switch (userInput.get(0)) {
			case "1":
				askSwapLines();
				try {
					lineValidator.validateIndex(Integer.valueOf(userInput.get(1)));
					lineValidator.validateIndex(Integer.valueOf(userInput.get(2)));
					lineValidator.checkIndexesEqual(Integer.valueOf(userInput.get(1)),
							Integer.valueOf(userInput.get(2)));

					manipulator.swapLines(Integer.valueOf(userInput.get(1)), Integer.valueOf(userInput.get(2)));

					fileWriter.write(manipulator.getContent());
				} catch (IllegalArgumentException e) {
					consoleWriter.write(e.getMessage());
				}
				break;
			case "2":
				askSwapNumbers();
				try {
					lineValidator.validateIndex(Integer.valueOf(userInput.get(1)));
					lineValidator.validateIndex(Integer.valueOf(userInput.get(2)));
					lineValidator.checkLineEmty(manipulator.getContent().get(Integer.valueOf(userInput.get(1))).size());
					lineValidator.checkLineEmty(manipulator.getContent().get(Integer.valueOf(userInput.get(2))).size());
					lineValidator.checkIndexesEqual(Integer.valueOf(userInput.get(1)),
							Integer.valueOf(userInput.get(2)));

					numberValudator.validateIndex(Integer.valueOf(userInput.get(3)),
							manipulator.getContent().get(Integer.valueOf(userInput.get(1))).size());

					numberValudator.validateIndex(Integer.valueOf(userInput.get(4)),
							manipulator.getContent().get(Integer.valueOf(userInput.get(2))).size());

					manipulator.swapNumbers(Integer.valueOf(userInput.get(1)), Integer.valueOf(userInput.get(2)),
							Integer.valueOf(userInput.get(3)), Integer.valueOf(userInput.get(4)));

					fileWriter.write(manipulator.getContent());
				} catch (IllegalArgumentException e) {
					consoleWriter.write(e.getMessage());
				}
				break;
			case "3":
				askForAdd();
				try {
					lineValidator.validateIndex(Integer.valueOf(userInput.get(1)));

					numberValudator.validateIndex(Integer.valueOf(userInput.get(2)),
							manipulator.getContent().get(Integer.valueOf(userInput.get(1))).size());
					numberValudator.validateValue(userInput.get(3));

					manipulator.add(Integer.valueOf(userInput.get(1)), Integer.valueOf(userInput.get(2)),
							userInput.get(3));

					fileWriter.write(manipulator.getContent());
				} catch (IllegalArgumentException e) {
					consoleWriter.write(e.getMessage());
				}
				break;
			case "4":
				askForRead();
				try {
					lineValidator.validateIndex(Integer.valueOf(userInput.get(1)));
					lineValidator.checkLineEmty(manipulator.getContent().get(Integer.valueOf(userInput.get(1))).size());

					numberValudator.validateIndex(Integer.valueOf(userInput.get(2)),
							manipulator.getContent().get(Integer.valueOf(userInput.get(1))).size());

					manipulator.readNumber(Integer.valueOf(userInput.get(1)), Integer.valueOf(userInput.get(2)));
				} catch (IllegalArgumentException e) {
					consoleWriter.write(e.getMessage());
				}
				break;
			case "5":
				askForModify();
				try {
					lineValidator.validateIndex(Integer.valueOf(userInput.get(1)));
					lineValidator.checkLineEmty(manipulator.getContent().get(Integer.valueOf(userInput.get(1))).size());

					numberValudator.validateIndex(Integer.valueOf(userInput.get(2)),
							manipulator.getContent().get(Integer.valueOf(userInput.get(1))).size());
					numberValudator.validateValue(userInput.get(3));

					manipulator.modify(Integer.valueOf(userInput.get(1)), Integer.valueOf(userInput.get(2)),
							userInput.get(3));

					fileWriter.write(manipulator.getContent());
				} catch (IllegalArgumentException e) {
					consoleWriter.write(e.getMessage());
				}
				break;
			case "6":
				askForRemove();
				try {
					lineValidator.validateIndex(Integer.valueOf(userInput.get(1)));

					lineValidator.checkLineEmty(manipulator.getContent().get(Integer.valueOf(userInput.get(1))).size());
					numberValudator.validateIndex(Integer.valueOf(userInput.get(2)),
							manipulator.getContent().get(Integer.valueOf(userInput.get(1))).size());

					manipulator.remove(Integer.valueOf(userInput.get(1)), Integer.valueOf(userInput.get(2)));

					fileWriter.write(manipulator.getContent());
				} catch (IllegalArgumentException e) {
					consoleWriter.write(e.getMessage());
				}

				break;
			case "0":
				run = false;
				break;
			default:
				consoleWriter.write("Invalid menu option.");
				break;
			}

		}
	}

	private void operationalMenu() {
		userInput.clear();
		consoleWriter.write("Choose from the given options: ");
		consoleWriter.write("Press (1) if you want to switch lanes in the file.");
		consoleWriter.write("Press (2) if you want to switch numbers in the lanes.");
		consoleWriter.write("Press (3) if you want to insert a number at some line.");
		consoleWriter.write("Press (4) if you want to read a number at a given index.");
		consoleWriter.write("Press (5) if you want to modify a number at a given index.");
		consoleWriter.write("Press (6) if you want to remove a number at a given index.");
		consoleWriter.write("Press (0) if you want to exit.");

	}

	private void askSwapLines() throws IOException {
		consoleWriter.write("Please select the first line that you want to switch: ");
		userInput.add(bR.readLine());
		consoleWriter.write("Please select the second line that you want to switch: ");
		userInput.add(bR.readLine());
	}

	private void askSwapNumbers() throws IOException {
		consoleWriter.write("Please select the first line that your number is on: ");
		userInput.add(bR.readLine());
		consoleWriter.write("Please select the second line that your number is on: ");
		userInput.add(bR.readLine());
		consoleWriter.write(
				"Please enter the index of the first number at line " + Integer.valueOf(userInput.get(1)) + " :");
		userInput.add(bR.readLine());
		consoleWriter.write(
				"Please enter the index of the second number at line " + Integer.valueOf(userInput.get(2)) + " :");
		userInput.add(bR.readLine());
	}

	private void askForAdd() throws IOException {
		consoleWriter.write("Please select the line on which you want to insert your number: ");
		userInput.add(bR.readLine());
		consoleWriter.write("Please select the index at which you want to insert your number: ");
		userInput.add(bR.readLine());
		consoleWriter.write("Please write the number that you want to insert: ");
		userInput.add(bR.readLine());

	}

	private void askForRead() throws IOException {
		consoleWriter.write("Please select the line on which you want to read your number: ");
		userInput.add(bR.readLine());
		consoleWriter.write("Please select the index at which you want to read your number: ");
		userInput.add(bR.readLine());
	}

	private void askForRemove() throws IOException {
		consoleWriter.write("Please select the line on which you want to remove your number: ");
		userInput.add(bR.readLine());
		consoleWriter.write("Please select the index at which you want to remove your number: ");
		userInput.add(bR.readLine());
	}

	private void askForModify() throws IOException {
		consoleWriter.write("Please select the line on which you want to modify your number: ");
		userInput.add(bR.readLine());
		consoleWriter.write("Please select the index at which you want to modify your number: ");
		userInput.add(bR.readLine());
		consoleWriter.write("Please enter the new value: ");
		userInput.add(bR.readLine());
	}

	private void addContentToManipulator() {
		manipulator = new FileContentManipulator(contentContainer.getContent());
	}

	private void saveInContainer() {
		fileReader = new ReadFromFile(filePath);
		contentContainer = new NumberFileContent();
		contentContainer.addContentToContainer(fileReader.read());

	}

	private void askFilePath() throws IOException {
		consoleWriter.write("Enter file path: ");
		filePath = bR.readLine();
	}
}
