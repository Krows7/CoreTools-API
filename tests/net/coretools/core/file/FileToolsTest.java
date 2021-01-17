package net.coretools.core.file;

import static net.coretools.core.file.FileTools.*;
import static org.junit.jupiter.api.Assertions.*;

import java.io.File;
import java.io.IOException;
import java.nio.charset.Charset;

import org.junit.jupiter.api.Test;


/**
 * 
 * JUnit tests for {@link FileTools} class.
 * 
 * @since 1.5.0.
 *
 * @author Krows
 * 
 */
class FileToolsTest {
	
/**
 * 
 * Test method for {@link net.coretools.core.file.FileTools#getText(java.io.File)}.
 * 
 */
	@Test
	final void testGetTextFile() {
		
		assertEquals(getText(new File("tests\\res\\FileToolsTest.txt")), "Hello World!");
	}
	
/**
 * 
 * Test method for {@link net.coretools.core.file.FileTools#getText(java.io.File, java.nio.charset.Charset)}.
 * 
 */
	@Test
	final void testGetTextFileCharset() {
		
		assertEquals(getText(new File("tests\\res\\FileToolsTest.txt"), Charset.forName("UTF-8")), "Hello World!");
	}
	
	/**
	 * Test method for {@link net.coretools.core.file.FileTools#createFileDataMap(java.io.File)}.
	 */
	@Test
	final void testCreateFileDataMap() {
		
		fail("Not yet implemented"); // TODO
	}
	
/**
 * 
 * Test method for {@link net.coretools.core.file.FileTools#appendText(java.io.File, java.lang.String)}.
 * 
 */
	@Test
	final void testAppendText() throws IOException {
		
		String message = "Hello World!";
		
		File file = new File("tests\\res\\FileToolsTest_0.txt");
		file.createNewFile();
		file.deleteOnExit();
		
		appendText(file, message);
		
		assertEquals(getText(file), message);
		
		appendText(file, message);
		
		assertEquals(getText(file), message + message);
	}
	
/**
 * 
 * Test method for {@link net.coretools.core.file.FileTools#setText(java.io.File, java.lang.String)}.
 * 
 */
	@Test
	final void testSetText() throws IOException {
		
		String message = "Hello World!";
		
		File file = new File("tests\\res\\FileToolsTest_1.txt");
		file.createNewFile();
		file.deleteOnExit();
		
		setText(file, message);
		
		assertEquals(getText(file), message);
	}
	
	/**
	 * Test method for {@link net.coretools.core.file.FileTools#getLinkedObjects(java.io.File)}.
	 */
	@Test
	final void testGetLinkedObjects() {
		
		fail("Not yet implemented"); // TODO
	}
	
	/**
	 * Test method for {@link net.coretools.core.file.FileTools#getLinkedFiles(java.io.File)}.
	 */
	@Test
	final void testGetLinkedFiles() {
		
		fail("Not yet implemented"); // TODO
	}
	
	/**
	 * Test method for {@link net.coretools.core.file.FileTools#getLinkedSimilarityExtensionFiles(java.io.File, java.lang.String)}.
	 */
	@Test
	final void testGetLinkedSimilarityExtensionFiles() {
		
		fail("Not yet implemented"); // TODO
	}
	
	/**
	 * Test method for {@link net.coretools.core.file.FileTools#getExtension(java.io.File)}.
	 */
	@Test
	final void testGetExtension() {
		
		fail("Not yet implemented"); // TODO
	}
	
	/**
	 * Test method for {@link net.coretools.core.file.FileTools#getExtensionName(java.io.File)}.
	 */
	@Test
	final void testGetExtensionName() {
		
		fail("Not yet implemented"); // TODO
	}
	
	/**
	 * Test method for {@link net.coretools.core.file.FileTools#containsExtension(java.io.File, java.lang.String)}.
	 */
	@Test
	final void testContainsExtension() {
		
		fail("Not yet implemented"); // TODO
	}
	
	/**
	 * Test method for {@link net.coretools.core.file.FileTools#containsExtensionName(java.io.File, java.lang.String)}.
	 */
	@Test
	final void testContainsExtensionName() {
		
		fail("Not yet implemented"); // TODO
	}
	
	/**
	 * Test method for {@link net.coretools.core.file.FileTools#containsExtensions(java.io.File)}.
	 */
	@Test
	final void testContainsExtensions() {
		
		fail("Not yet implemented"); // TODO
	}
	
	/**
	 * Test method for {@link net.coretools.core.file.FileTools#containsSubExtensions(java.io.File)}.
	 */
	@Test
	final void testContainsSubExtensions() {
		
		fail("Not yet implemented"); // TODO
	}
}
