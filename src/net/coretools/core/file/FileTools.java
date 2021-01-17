package net.coretools.core.file;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

import net.coretools.core.CollectionTools;
import net.coretools.core.OnQuestion;
import net.coretools.core.OnQuestion.Status;

/**
 * 
 * FileTools class is used for working with files. 
 * This class provide many methods with flexible management of files and them data.
 * 
 * @author Krows
 * 
 * @since 1.3.9 (old: 1.39)
 *
 */
public final class FileTools {

/**
 * 
 * The Java preferences file extension.
 * 
 * @category Extensions
 * 
 */
	public static final String JAVA_PREFERENCE_EXTENSION = ".jprefs";

/**
 * 
 * The preferences file extension.
 * 
 * @category Extensions
 * 
 */
	public static final String PREFERENCE_EXTENSION = ".prefs";
	
/**
 * 
 * The properties file extension.
 * 
 */
	public static final String PROPERTIES_EXTENSION = ".properties";

/**
 * 
 * The data file extension.
 * 
 * @category Extensions
 * 
 */
	public static final String DATA_EXTENSION = ".dat";

/**
 * 
 * The default text file extension.
 * 
 * @category Extensions
 * 
 */
	public static final String TEXT_EXTENSION = ".txt";
	
/**
 * 
 * The PNG image file extension.
 * 
 * @category Extensions
 * 
 */
	public static final String PNG_EXTENSION = ".png";
	
/**
 * 
 * The JPEG image file extension.
 * 
 * @category Extensions
 * 
 */
	public static final String JPEG_EXTENSION = ".jpeg";
	
/**
 * 
 * The JPG image file extension.
 * 
 * @category Extensions
 * 
 */
	public static final String JPG_EXTENSION = ".jpg";

/**
 * 
 * The Java Language Pack file extension.
 * 
 * @category Extensions
 * 
 */
	public static final String JAVA_LANGUAGE_PACK_EXTENSION = ".jlp";
	
/**
 * 
 * The Java Language Object file extension.
 * 
 * @category Extensions
 * 
 */
	public static final String JAVA_LANGUAGE_OBJECT_EXTENSION = ".jlo";
	
/**
 * 
 * The Java Archive file extension.
 * 
 * @category Extensions
 * 
 */
	public static final String JAVA_ARCHIVE_EXTENSION = ".jar";
	
/**
 * 
 * The Scalable Vector Graphics file extension.
 * 
 * @category Extensions
 * 
 */
	public static final String SCALABLE_VECTOR_GRAPHICS_EXTENSION = ".svg";
	
/**
 * 
 * The Krow's Markup Code file extension.
 * 
 * @category Extensions
 * 
 */
	public static final String KROWS_MARKUP_CODE_EXTENSION = ".kmc";
	
/**
 * 
 * The local path name to resource directory.
 * 
 * @category Path names
 * 
 */
	public static final String RESOURCE_PATH_NAME = "res\\";
	
/**
 * 
 * The local path to Java Language directory.
 * 
 * @category Path names
 * 
 */
	public static final String JAVA_LANGUAGE_PATH_NAME = RESOURCE_PATH_NAME + "lang\\";

/**
 * 
 * The file of "core" preferences.
 * 
 * @category Files
 * 
 */
	public static final File CORE_PREFERENCE_FILE = new File(RESOURCE_PATH_NAME + "core" + PREFERENCE_EXTENSION);
	
/**
 * 
 * The file of "core" Java preferences.
 * 
 * @category Files
 * 
 */
	public static final File CORE_JAVA_PREFERENCE_FILE = new File(RESOURCE_PATH_NAME + "core" + JAVA_PREFERENCE_EXTENSION);
	
/**
 * 
 * Closed constructor.
 * 
 */
	private FileTools() {
		
	}
	
/**
 * 
 * Extracts all content data from file preserving all control characters like "\r", "\n", "\t" and etc.
 * 
 * @param file File to extract data.
 * 
 * @return All visual content(text) from file.
 * 
 */
	public static String getText(File file) {
		
		return getText(file, Charset.forName("UTF-8"));
	}
	
/**
 * 
 * Extracts all content data from file preserving all control characters like "\r", "\n", "\t" and etc. 
 * with specified {@link Charset}.
 * 
 * @param file File to extract data.
 * @param charset Charset of file.
 * 
 * @return All visual content(text) from file.
 * 
 */
	public static String getText(File file, Charset charset) {
		
		try {
			
			return new String(Files.readAllBytes(file.toPath()), charset);
		} catch (IOException e) {
			
			e.printStackTrace();
		}
		
		return null;
	}
	
/**
 * 
 * Creates Scanner from file avoiding {@link FileNotFoundException},  but it can still be thrown.
 * 
 * @param file File to create Scanner.
 * 
 * @return Scanner of file. Otherwise, if will be thrown {@link FileNotFoundException}, returns null.
 * 
 */
	@OnQuestion(status = Status.REMOVE, description = "This method seems unnecessary.")
	private static Scanner createScanner(File file) {
		
		try {
			
			return new Scanner(file);
		} catch (FileNotFoundException e) {
			
			e.printStackTrace();
		}
		
		return null;
	}
	
/**
 * 
 * Creates {@link Map} of data from file. 
 * It is used if file contains data in format "key-value" (like .lang files or .dat in some cases) to save metadata and use them in the program.
 * 
 * @param file File to extract data.
 * 
 * @return Map of "key-value" data.
 * 
 */
	@OnQuestion(status = Status.REMOVE, description = "This method seems unnecessary because we don't see meaning to use it. Maybe this method will appear in other classes.")
	public static Map<String, String> createFileDataMap(File file) {
		
		Map<String, String> resultMap = new HashMap<>();
		
		try(Scanner scanner = createScanner(file)) {
			
			while(scanner.hasNextLine()) {
				
				resultMap.put(scanner.next(), scanner.nextLine());
			}
		}
		
		return resultMap;
	}
	
/**
 * 
 * Appends specified string text to the file.
 * 
 * @param file File to append the specified string text.
 * @param string Text to append.
 * 
 */
	public static void appendText(File file, String string) {
		
		try(FileWriter writer = new FileWriter(file)) {
			
			writer.append(string);
		} catch (IOException e) {
			
			e.printStackTrace();
		}
	}
	
/**
 * 
 * Flushes specified file and sets into it the specified string text.
 * 
 * @param file File to flush and set text.
 * @param string String text to set.
 * 
 */
	public static void setText(File file, String string) {
		
		try(FileWriter writer = new FileWriter(file)) {
			
			writer.flush();
			writer.write(string);
		} catch (IOException e) {
			
			e.printStackTrace();
		}
	}
	
/**
 * 
 * Returns {@link List} of objects (files and directories) which contains in the path of specified File object. 
 * <strong>For returning files only it needs to use {@link #getLinkedFiles(File)}.</strong>
 * 
 * @param folder Path of objects.
 * 
 * @return List of files and directories contained in path of specified file.
 * 
 */
	public static List<File> getLinkedObjects(File folder) {
		
		return CollectionTools.createModifiableListOf(folder.listFiles() == null ? new File[0] : folder.listFiles());
	}
	
/**
 * 
 * Returns {@link List} of files which contains in the path of specified File object.
 * <strong>For returning files and directories it needs to use {@link #getLinkedObjects(File)}.</strong>
 * 
 * @param folder Path of files.
 * 
 * @return List of files contained in path of specified file.
 *
 */
	public static List<File> getLinkedFiles(File folder) {
		
		List<File> fileList = getLinkedObjects(folder);
		fileList.removeIf(file -> !file.isFile());
		
		return fileList;
	}
	
/**
 * 
 * Returns {@link List} of files which contains in the path of specified File object and also have the same extension as the specified extension.
 * 
 * @param folder Path of files.
 * @param extension Extension which files should have.
 * 
 * @return List of files contained in path of specified file and which have same extension as the specified extension.
 *
 */
	public static List<File> getLinkedSimilarityExtensionFiles(File folder, String extension) {
		
		List<File> fileList = getLinkedFiles(folder);
		fileList.removeIf(file -> !file.isFile() || !getExtension(file).equals(extension));
		
		return fileList;
	}
	
/**
 * 
 * Returns extension of file. 
 * <blockquote>
 * Examples: <br>
 * 1. For file "<strong>apple.jpg</strong>" returns "<strong>.jpg</strong>".<br>	
 * 2. For file "<strong>archive.zip.tgz</strong>" returns "<strong>.tgz</strong>".<br>
 * 3. For file "<strong>file</strong>" returns <strong>null</strong>.
 * </blockquote>
 * Method {@link #getExtensionName(File)} returns extension name only (without dot symbol).
 * 
 * @param file File to return its extension.
 * 
 * @return Extension of file.
 *
 */
	public static String getExtension(File file) {
		
		return file.isFile() ? "." + getExtensionName0(file) : null;
	}
	
/**
 * 
 * Returns extension name of file.
 * <blockquote>
 * Examples: <br>
 * 1. For file "<strong>apple.jpg</strong>" returns "<strong>jpg</strong>".<br>	
 * 2. For file "<strong>archive.zip.tgz</strong>" returns "<strong>tgz</strong>".<br>
 * 3. For file "<strong>file</strong>" returns <strong>null</strong>.
 * </blockquote>
 * Method {@link #getExtension(File)} returns full name of extension (with dot symbol).
 * 
 * @param file File to return its extension.
 * 
 * @return Name of file extension.
 *
 */
	public static String getExtensionName(File file) {
		
		return file.isFile() ? getExtensionName0(file) : null;
	}

/**
 * 
 * Returns extension name of file.
 * <blockquote>
 * Examples: <br>
 * 1. For file "<strong>apple.jpg</strong>" returns "<strong>jpg</strong>".<br>	
 * 2. For file "<strong>archive.zip.tgz</strong>" returns "<strong>tgz</strong>".<br>
 * 3. For file "<strong>file</strong>" returns <strong>null</strong>.
 * </blockquote>
 * 
 * @param file File to return its extension.
 * 
 * @return Name of file extension.
 *
 */
	private static String getExtensionName0(File file) {
		
		int i = file.getName().lastIndexOf('.');
		
		return i != - 1 ? file.getName().substring(i + 1) : null;
	}
	
/**
 * 
 * Returns whether the specified file contains specified extension. 
 * 
 * @param file File to check for contains the specified extension.
 * @param extension Full extension name (with dot symbol) to find it in file.
 * 
 * @return True if the specified file is contained the specified extension, otherwise returns false.
 *
 */
	@OnQuestion(status = Status.REMOVE, description = "This method seems unnecessary because we have other method which doesn't require dot symbol in extension.")
	public static boolean containsExtension(File file, String extension) {
		
		return file.isFile() && file.getName().contains(extension);
	}
	
/**
 * 
 * Returns whether the specified file contains specified extension.
 * 
 * @param file File to check for contain the specified extension.
 * @param extensionName Name of extension (without dot symbol) to find it in file.
 * 
 * @return True if the specified file is contained the specified extension, otherwise returns false.
 * 
 * @see #containsExtension(File, String)
 *
 */
	@OnQuestion(status = Status.EDIT, description = "If we'll decide to remove *containsExtension* method then logic of that method will moved into this method.")
	public static boolean containsExtensionName(File file, String extensionName) {
		
		return containsExtension(file, "." + extensionName);
	}
	
/**
 * 
 * Returns whether the specified file contains any extensions.
 * 
 * @param file File to check for contain the extensions.
 * 
 * @return True if specified file contains at least one extension, otherwise returns false.
 * 
 */
	public static boolean containsExtensions(File file) {
		
		return file.isFile() && file.getName().indexOf('.') != - 1;
	}
	
/**
 * 
 * Returns whether the specified file contains two or more extensions.
 * 
 * @param file File to check for contain the extensions.
 * 
 * @return True if specified file contains at least two extensions, otherwise returns false.
 *
 */
	public static boolean containsSubExtensions(File file) {
		
		return containsExtensions(file) && file.getName().indexOf('.', file.getName().indexOf('.')) != - 1;
	}
}