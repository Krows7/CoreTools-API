package net.coretools.core.file;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

import net.coretools.core.UtilTools;

/**
 * 
 * 
 * 
 * @since 1.5.0
 *
 * @author Krows
 * 
 */
public final class Coder {
	
	private Coder() {
		
	}
	
	public static <T extends Serializable> T decode(File file) {
		
		try(ObjectInputStream input = new ObjectInputStream(new FileInputStream(file))) {
			
			return UtilTools.cast(input.readObject());
		} catch(Exception e) {
			
			return null;
		}
	}
	
	public static <T extends Serializable> void encode(File file, T object) {
		
		try(ObjectOutputStream output = new ObjectOutputStream(new FileOutputStream(file))) {
			
			output.writeObject(object);
		} catch(IOException e) {
			
			e.printStackTrace();
		}
	}
}