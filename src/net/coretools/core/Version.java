package net.coretools.core;

/**
 * 
 * The Version class contains current version of the library and version message.
 * 
 * @author Krows
 * 
 * @since 1.0.0 (old: 1.0)
 *
 */
public final class Version {
	
/**
 * 
 * Contains numbers of the current API version.
 * 
 */
	private static final byte[] VERSION_NUMBERS = {1, 5, 0, 0};
	
/**
 * 
 * Contains full name of the current API version.
 * 
 */
	private static final String VERSION = String.format("%s.%s.%s%s", VERSION_NUMBERS[0], VERSION_NUMBERS[1], VERSION_NUMBERS[2], VERSION_NUMBERS[3] == 0 ? " " + getPatchNumber(VERSION_NUMBERS[3]) : "");
	
/**
 * 
 * Contains message of the current API version.
 * 
 */
	private static final String VERSION_MESSAGE = String.format("Version: %s", VERSION);
	
/**
 * 
 * Closed constructor.
 *
 */
	private Version() {
		
	}
	
/**
 * 
 * Returns formatted full name of the current version (e.g. "1.0.0 (1'st patch)").
 * 
 * @return Full name of the current version.
 *
 */
	public static String getVersion() {
		
		return VERSION;
	}
	
/**
 * 
 * Returns formatted message which contains current version (e.g. "Version: 1.0.0 (1'st patch)").
 * 
 * @return Message with current version.
 *
 */
	public static String getMessage() {
		
		return VERSION_MESSAGE;
	}
	
/**
 * 
 * Returns array with numbers of the current API version which includes major version, middle version, minor version and in some cases patch version.
 * 
 * @return Array of numbers of the current API version.
 *
 */
	public static byte[] getVersionNumbers() {
		
		return VERSION_NUMBERS;
	}
	
/**
 * 
 * Returns major number (first number) of the current API version.
 * 
 * @return Major version.
 *
 */
	public static byte getMajorVersion() {
		
		return VERSION_NUMBERS[0];
	}
		
/**
 * 
 * Returns middle number (second number) of the current API version.
 * 
 * @return Middle version.
 *
 */
	public static byte getMiddleVersion() {
			
		return VERSION_NUMBERS[1];
	}
	
/**
 * 
 * Returns minor number (third number) of the current API version.
 * 
 * @return Minor version.
 *
 */
	public static byte getMinorVersion() {
		
		return VERSION_NUMBERS[2];
	}
	
/**
 * 
 * Returns patch number (fourth number) of the current API version. If it does not exist returns 0.
 * 
 * @return Patch version if it exists, otherwise returns 0.
 *
 */
	public static byte getPatchVersion() {
		
		return VERSION_NUMBERS[3];
	}
	
/**
 * 
 * Returns full message of patch message if it contains in current API version.
 * 
 * @param num Number of current patch.
 * 
 * @return Message of current patch version.
 * 
 */
	private static String getPatchNumber(byte num) {
		
		return String.format("(%s patch)", getNumber(num));
	}
	
/**
 * 
 * Returns message with full number designation (For example: 1 = 1'st).
 * 
 * @param num Number for message.
 * 
 * @return Full number designation.
 * 
 */
	private static String getNumber(byte num) {
		
		String result = String.valueOf(num);
		
		switch(result.substring(0, result.length() - 1)) {
			
			case "1" :
				
				return num + "'st";
				
			case "2" :
				
				return num + "'nd";
				
			case "3" :
				
				return num + "'rd";
				
			default :
				
				return num + "'th";
		}
	}
}