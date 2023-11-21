package test;

import static org.junit.jupiter.api.Assertions.*;

import java.io.ByteArrayInputStream;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestInstance.Lifecycle;

import main.Triangle;
import main.Triangle.TYPE;

@TestInstance(Lifecycle.PER_CLASS)
class TriangleTest {
	Triangle equilateralTriangle;
	Triangle equilateralTriangle2;
	Triangle isoscelesTriangleRotation1;
	Triangle isoscelesTriangleRotation2;
	Triangle isoscelesTriangleRotation3;
	Triangle scaleneTriangle;
	Triangle scaleneTriangle2;
	Triangle zeroOnSideATriangle;
	Triangle zeroOnSideBTriangle;
	Triangle zeroOnSideCTriangle;
	Triangle impossibleTriangleRotation1;
	Triangle impossibleTriangleRotation2;
	Triangle impossibleTriangleRotation3;

	@BeforeAll
	void setupTriangles() {

		equilateralTriangle = new Triangle(5, 5, 5);
		equilateralTriangle2 = new Triangle(15, 15, 15);
		isoscelesTriangleRotation1 = new Triangle(7, 5, 5);
		isoscelesTriangleRotation2 = new Triangle(5, 7, 5);
		isoscelesTriangleRotation3 = new Triangle(5, 5, 7);
		scaleneTriangle = new Triangle(5, 6, 7);
		scaleneTriangle2 = new Triangle(15, 16, 17);
		zeroOnSideATriangle = new Triangle(0, 1, 1);
		zeroOnSideBTriangle = new Triangle(1, 0, 1);
		zeroOnSideCTriangle = new Triangle(1, 1, 0);
		impossibleTriangleRotation1 = new Triangle(4, 1, 1);
		impossibleTriangleRotation2 = new Triangle(1, 4, 1);
		impossibleTriangleRotation3 = new Triangle(1, 1, 4);
	}

	@DisplayName("Check if impossible triangle is null: First Rotation")
	@Test
	void checkIfImpossibleRotation1IsNull() {
		assertNull(impossibleTriangleRotation1.getCurrent_type());
	}

	@DisplayName("Check if impossible triangle is null: Second Rotation")
	@Test
	void checkIfImpossibleRotation2IsNull() {
		assertNull(impossibleTriangleRotation2.getCurrent_type());
	}

	@DisplayName("Check if impossible triangle is null: Third Rotation")
	@Test
	void checkIfImpossibleRotation3IsNull() {
		assertNull(impossibleTriangleRotation3.getCurrent_type());
	}

	@DisplayName("Check if equilateral triangle is correct")
	@Test
	void checkIfEquilateralTriangleIsCorrect() {
		assertEquals(TYPE.EQUILATERAL, equilateralTriangle.getCurrent_type());
	}
	@DisplayName("Check if equilateral2 triangle is correct")
	@Test
	void checkIfEquilateral2TriangleIsCorrect() {
		assertEquals(TYPE.EQUILATERAL, equilateralTriangle2.getCurrent_type());
	}

	@DisplayName("Check if isoceles triangle is correct: First Rotation")
	@Test
	void checkIfIsoscelesTriangleRotation1IsCorrect() {
		assertEquals(TYPE.ISOSCELES, isoscelesTriangleRotation1.getCurrent_type());
	}

	@DisplayName("Check if isoceles triangle is correct: Second Rotation")
	@Test
	void checkIfIsoscelesTriangleRotation2IsCorrect() {
		assertEquals(TYPE.ISOSCELES, isoscelesTriangleRotation2.getCurrent_type());
	}

	@DisplayName("Check if isoceles triangle is correct: Third Rotation")
	@Test
	void checkIfIsoscelesTriangleRotation3IsCorrect() {
		assertEquals(TYPE.ISOSCELES, isoscelesTriangleRotation3.getCurrent_type());
	}

	@DisplayName("Check if scalene triangle is correct")
	@Test
	void checkIfScaleneTriangleIsCorrect() {
		assertEquals(TYPE.SCALENE, scaleneTriangle.getCurrent_type());
	}
	@DisplayName("Check if scalene2 triangle is correct")
	@Test
	void checkIfScalene2TriangleIsCorrect() {
		assertEquals(TYPE.SCALENE, scaleneTriangle2.getCurrent_type());
	}

	@DisplayName("Check if zero on side A results in null")
	@Test
	void checkIfZeroOnSideAIsNull() {
		assertNull(zeroOnSideATriangle.getCurrent_type());
	}

	@DisplayName("Check if zero on side B results in null")
	@Test
	void checkIfZeroOnSideBIsNull() {
		assertNull(zeroOnSideBTriangle.getCurrent_type());
	}

	@DisplayName("Check if zero on side C results in null")
	@Test
	void checkIfZeroOnSideCIsNull() {
		assertNull(zeroOnSideCTriangle.getCurrent_type());
	}

	@DisplayName("Check if constructor with String array works")
	@Test
	void checkIfConstructorWithStringArrayWorksCorrect() {
		Triangle triangle = new Triangle(new String[] { "1", "1", "1" });

		assertEquals(TYPE.EQUILATERAL, triangle.getCurrent_type());
	}

	@DisplayName("Check if constructor with String Array that has too few arguments is null")
	@Test
	void checkIfConstructorWithStringArrayWithFewerArgumentsIsNull() {
		Triangle triangle = new Triangle(new String[] { "1", "1" });

		assertNull(triangle.getCurrent_type());
	}

	@DisplayName("Check if constructor with String Array that has too many arguments is null")
	@Test
	void checkIfConstructorWithStringArrayWithTooManyArgumentsIsNull() {
		Triangle triangle = new Triangle(new String[] { "1", "1", "1", "1" });

		assertNull(triangle.getCurrent_type());
	}

	@DisplayName("Check if constructor with String Array that has a non Number as argument is null")

	@Test
	void checkIfConstructorWithStringArrayWithNonNumberArgumentIsNull() {
		Triangle triangle = new Triangle(new String[] { "1", "1", "a" });
		assertNull(triangle.getCurrent_type());
	}

	@DisplayName("Check if user input works correctly")

	@Test
	void checkIfCorrectUserInputWorks() {
		Triangle triangle = new Triangle();
		provideInput("1,1,1");
		triangle.getUserInput();

		assertNotNull(triangle.getCurrent_type());
	}

	@DisplayName("Check if user input with too many arguments is null")
	@Test
	void checkUserInputWithTooManyArgumentsIsNull() {
		Triangle triangle = new Triangle();
		provideInput("1,1,1,1");
		triangle.getUserInput();

		assertNull(triangle.getCurrent_type());
	}

	@DisplayName("Check if user input with too few arguments is null")
	@Test
	void checkUserInputWithFewerArgumentsIsNull() {
		Triangle triangle = new Triangle();
		provideInput("1,1");
		triangle.getUserInput();

		assertNull(triangle.getCurrent_type());
	}

	@DisplayName("Check if user input with non integer is null")
	@Test
	void checkUserInputWithNonIntegerInputIsNull() {
		Triangle triangle = new Triangle();
		provideInput("1,1,a");
		triangle.getUserInput();

		assertNull(triangle.getCurrent_type());
	}

	@DisplayName("Check if no arguments is null")
	@Test
	void checkIfNoargumentsIsNull() {
		Triangle triangle = new Triangle();

		assertNull(triangle.getCurrent_type());
	}
	
	@DisplayName("Check")
	@Test
	void checkUpperBounds() {
		Triangle triangle = new Triangle(Integer.MAX_VALUE,1,Integer.MAX_VALUE);

		assertNull(triangle.getCurrent_type());
	}
	
	@DisplayName("Check")
	@Test
	void checknull() {
		
	}

	void provideInput(String input) {
		ByteArrayInputStream testIn = new ByteArrayInputStream(input.getBytes());
		System.setIn(testIn);
	}

}
