package net.coretools.core.io;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

/**
 * 
 * IO class contains methods for working with {@link InputStream} and {@link OutputStream} in one class.
 * 
 * @since 1.5.0
 *
 * @author Krows
 * 
 */
public class IO {
	
/**
 * 
 * InputStream object.
 * 
 */
	protected InputStream input;
	
/**
 * 
 * OutputStream object.
 * 
 */
	protected OutputStream output;
	
/**
 * 
 * Creates new I/O pair.
 * 
 * @param input InputStream object as input.
 * @param output OutputStream object as output.
 *
 */
	public IO(InputStream input, OutputStream output) {
		
		this.input = input;
		
		this.output = output;
	}
	
/**
 * 
 * See {@link InputStream#read()}.
 * 
 * @return See {@link InputStream#read()}.
 * 
 * @throws IOException See {@link InputStream#read()}.
 * 
 */
	public int read() throws IOException {
		
		return input.read();
	}
	
/**
 * 
 * See {@link InputStream#read(byte[])}.
 * 
 * @param b See {@link InputStream#read(byte[])}.
 * 
 * @return See {@link InputStream#read(byte[])}.
 * 
 * @throws IOException See {@link InputStream#read(byte[])}.
 * 
 */
	public int read(byte[] b) throws IOException {
		
		return input.read(b);
	}
	
/**
 * 
 * See {@link InputStream#read(byte[], int, int)}.
 * 
 * @param b See {@link InputStream#read(byte[], int, int)}.
 * @param off See {@link InputStream#read(byte[], int, int)}.
 * @param len See {@link InputStream#read(byte[], int, int)}.
 * 
 * @return See {@link InputStream#read(byte[], int, int)}.
 * 
 * @throws IOException See {@link InputStream#read(byte[], int, int)}.
 * 
 */
	public int read(byte[] b, int off, int len) throws IOException {
		
		return input.read(b, off, len);
	}
	
/**
 * 
 * See {@link InputStream#close()}.
 * 
 * @throws IOException See {@link InputStream#close()}.
 * 
 */
	public void close() throws IOException {
		
		input.close();
	}
	
/**
 * 
 * See {@link InputStream#available()}.
 * 
 * @return See {@link InputStream#available()}.
 * 
 * @throws IOException See {@link InputStream#available()}.
 * 
 */
	public int available() throws IOException {
		
		return input.available();
	}
	
/**
 * 
 * See {@link InputStream#skip(long)}.
 * 
 * @param n See {@link InputStream#skip(long)}.
 * 
 * @return See {@link InputStream#skip(long)}.
 * 
 * @throws IOException See {@link InputStream#skip(long)}.
 * 
 */
	public long skip(long n) throws IOException {
		
		return input.skip(n);
	}
	
/**
 * 
 * See {@link InputStream#markSupported()}.
 * 
 * @return See {@link InputStream#markSupported()}.
 * 
 */
	public boolean markSupported() {
		
		return input.markSupported();
	}
	
/**
 * 
 * See {@link InputStream#mark(int)}.
 * 
 * @param readlimit See {@link InputStream#mark(int)}.
 * 
 */
	public synchronized void mark(int readlimit) {
		
		input.mark(readlimit);
	}
	
/**
 * 
 * See {@link InputStream#reset()}.
 * 
 * @throws IOException See {@link InputStream#reset()}.
 * 
 */
	public synchronized void reset() throws IOException {
		
		input.reset();
	}
	
/**
 * 
 * See {@link OutputStream#write(int)}.
 * 
 * @param b See {@link OutputStream#write(int)}.
 * 
 * @throws IOException See {@link OutputStream#write(int)}.
 *
 */
	public void write(int b) throws IOException {
	
		output.write(b);
	}
	
/**
 * 
 * See {@link OutputStream#write(byte[])}.
 * 
 * @param b See {@link OutputStream#write(byte[])}.
 * 
 * @throws IOException See {@link OutputStream#write(byte[])}.
 *
 */
	public void write(byte[] b) throws IOException {
		
		output.write(b);
	}
	
/**
 * 
 * See {@link OutputStream#write(byte[], int, int)}.
 * 
 * @param b See {@link OutputStream#write(byte[], int, int)}.
 * @param off See {@link OutputStream#write(byte[], int, int)}.
 * @param len See {@link OutputStream#write(byte[], int, int)}.
 * 
 * @throws IOException See {@link OutputStream#write(byte[], int, int)}.
 *
 */
	public void write(byte[] b, int off, int len) throws IOException {
		
		output.write(b, off, len);
	}
	
/**
 * 
 * See {@link OutputStream#flush()}.
 * 
 * @throws IOException See {@link OutputStream#flush()}.
 *
 */
	public void flush() throws IOException {
		
		output.flush();
	}
	
/**
 * 
 * Returns InputStream object of this I/O pair.
 * 
 * @return Input of pair.
 * 
 */
	public InputStream getInput() {
		
		return input;
	}
	
/**
 * 
 * Returns OutputStream object of this I/O pair.
 * 
 * @return Output of pair.
 * 
 */
	public OutputStream getOutput() {
		
		return output;
	}
}