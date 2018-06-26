package com.lt;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

/**
 * 功能：
 *
 * @author ：LT(286269159@qq.com)
 * @version ：2018 Version：1.0
 * @create ：2018-06-26 10:18:54
 */
public class TestFileChannel {
	public static final String str = "aaabbbcccdddfff";
	public static void main(String[] args) {
		String filename = System.getProperty("user.dir") + File.separator + "test.txt";
		try {
			FileInputStream fileInputStream = new FileInputStream(filename);
			FileChannel fileChannel = fileInputStream.getChannel();
			ByteBuffer byteBuffer = ByteBuffer.allocate(1024);
			for (int i = 0; i < str.length(); i++) {
				byteBuffer.putChar(str.charAt(i));
			}
			fileChannel.write(byteBuffer);
			fileChannel.close();
			fileInputStream.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		/*FileInputStream fileInputStream = new FileInputStream(System.getProperty("user.dir"));*/
	}
}
