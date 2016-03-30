package basicPicture.test;


import basicPicture.Composite;
import org.junit.Test;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotSame;


/**
 * 
 * 
 * @author Ben Setzer
 *
 */
public class TestStructure {



	/**
	 * There should be one private field and no others.
	 */
	@Test
	public void testFieldsComposite() {
		countFields(Composite.class, 1);
	}


	public void countFields(Class<?> cl, int numberOfFields) {
		Field[] fields = cl.getDeclaredFields();
		assertEquals("The class '" + cl.getName() + "' should have exactly " + numberOfFields + " fields.",
				numberOfFields, fields.length);
		for(Field f : fields ) {
			assertNotSame("The instance field '" + f.getName() 
						+ "' in class '" + cl.getName() + "' should be private.",
					0, f.getModifiers() & Modifier.PRIVATE);
		}
		
	}
	

	@Test
	public void testConstructorsComposite() {
		countConstructors(Composite.class, 1);
	}

	/**
	 *  The number of constructors is checked and each constructor is checked
	 *  	to be public.
	 */
	public void countConstructors(Class<?> cl, int numberOfConstructors) {
		Constructor<?>[] constructors = cl.getDeclaredConstructors();
		assertEquals(numberOfConstructors, constructors.length);
		for (int i = 0; i < constructors.length; i++) {
			assertNotSame("The constructor " + "in class '" + cl.getName() + "' should be public.",
			0, constructors[0].getModifiers() & Modifier.PUBLIC);
		}

	}

//
//	@Test
//	public void testCompositeMethods() {
//		countMethods(Composite.class, 2);
//	}

	/**
	 * Count the methods and compare to the number specified.
	 */
	public void countMethods(Class<?> cl, int numberOfMethods) {
		//Class<?> cl = Length.class;
		//int numberOfMethods = 7;
		Method[] methods = cl.getDeclaredMethods();
		assertEquals("The class '" + cl.getName() + "' should have exactly " 
				+ numberOfMethods + " methods.", 
				numberOfMethods, methods.length);
		
	}
	

	

}