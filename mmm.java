import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.io.FileNotFoundException;

public class mmm {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		System.out.println("                                  "
				+ "  HangMan Game        ");
		Hangman hello = new Hangman();
		String[] str = new String[320];
		Scanner input = new Scanner(System.in);
		System.out.println("Enter number of guesses:");
		int x = input.nextInt();
		while(x==0 ) {
			System.out.println("Guesses can't be zero ! Enter number of guesses:");
			x = input.nextInt();
		}
		hello.setMaxWrongGuesses(x);
		
		
		
		
		
	}

}
