import static org.junit.Assert.*;

import org.junit.Test;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

public class SudokuVerifierTest {

//implement tests to test Sudokuverifier with boundary values.  Use templates from Task 1 to derive and document test cases.
	
// A correct Sudoku string: 417369825632158947958724316825437169791586432346912758289643571573291684164875293
// An incorrect Sudoku string: 123456789912345678891234567789123456678912345567891234456789123345678912234567891
String c = "417369825632158947958724316825437169791586432346912758289643571573291684164875293";
String i = "123456789912345678891234567789123456678912345567891234456789123345678912234567891";
SudokuVerifier v = new SudokuVerifier();

	@Test
	public void testCorrectString() {
		int a = v.verify(c);
		assertEquals("correct string", a, 0);
	}

	@Test
	public void testIncorrectString() {
		int a = v.verify(i);
		assertEquals("incorrect string", a, -2);
		
	}
	
	 @Test
	    public void testValidSudokuSolution() {
	        SudokuVerifier sudokuVerifier = new SudokuVerifier();
	        int result = sudokuVerifier.verify("417369825632158947958724316825437169791586432346912758289643571573291684164875293");
	        assertEquals(0, result);
	    }
	 
	 @Test
	    public void testInvalidCharacters() {
	        SudokuVerifier sudokuVerifier = new SudokuVerifier();
	        int result = sudokuVerifier.verify("41d369825632158947958724316825437169791586432346912758289643571573291684164875293");
	        assertEquals(1, result);
	    }


	 
	 @Test
	    public void testInvalidLengthShort() {
	        SudokuVerifier sudokuVerifier = new SudokuVerifier();
	        int result = sudokuVerifier.verify("41736982563215894795872431682543716979158643234691275828964357157329168416487529");
	        assertEquals(-1, result);
	    }
	 
	 @Test
	    public void testInvalidLengthLong() {
	        SudokuVerifier sudokuVerifier = new SudokuVerifier();
	        int result = sudokuVerifier.verify("4173698256321589479587243168254371697915864323469127582896435715732916841648752931");
	        assertEquals(-1, result);
	    }
	 
	 @Test
	    public void testDuplicateInRow() {
	        SudokuVerifier sudokuVerifier = new SudokuVerifier();
	        int result = sudokuVerifier.verify("117369825632158947958724316825437169791586432346912758289643571573291684164875293");
	        assertEquals(-3, result);
	    }
	 
	 @Test
	    public void testDuplicateInColumn() {
	        SudokuVerifier sudokuVerifier = new SudokuVerifier();
	        // Introduce a duplicate in the first column
	        int result = sudokuVerifier.verify("417369825632158947958724316825437169791586432346912758289643571573291684164875293");
	        assertEquals(-4, result);
	    }
	 
	 
	 @Test
	    public void testSpecialUnicodeCharacter() {
	        SudokuVerifier sudokuVerifier = new SudokuVerifier();
	        List<String> naughtyStrings = readNaughtyStringsFromFile("blns.txt");

	        for (String naughtyString : naughtyStrings) {
	            // Append a special Unicode character to the naughty string
	            String testString = naughtyString + "👨🏿‍🦱";

	            //  test logic
	            int result = sudokuVerifier.verify(testString);
	            assertEquals("Expected result for string: " + testString, 1, result);
	        }
	    }

	    private List<String> readNaughtyStringsFromFile(String fileName) {
	        try {
	        	Path path = Paths.get("C:\\Users\\marja\\git\\SudokuChecker\\tests", fileName);
	            return Files.readAllLines(path);
	        } catch (Exception e) {
	            // Handle exceptions (e.g., file not found)
	            e.printStackTrace();
	            return List.of();
	        }
	    }
	}
