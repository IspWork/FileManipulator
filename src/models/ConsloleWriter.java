/**
 * Prints out information(to the user) in the console.
 */
package models;

import interfaces.Writer;

public class ConsloleWriter implements Writer{

	@Override
	public void write(String content) {
		System.out.println(content);
		
	}

}
