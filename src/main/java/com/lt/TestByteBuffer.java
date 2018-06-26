package com.lt;

import java.nio.ByteBuffer;

/**
 * 功能：
 *
 * @author ：LT(286269159@qq.com)
 * @version ：2018 Version：1.0
 * @create ：2018-06-26 11:26:16
 */
public class TestByteBuffer {
	public static void main(String[] args) {
		byte[] bytes = "123456789".getBytes();
		ByteBuffer byteBuffer = ByteBuffer.allocate(16);
		for (int i = 0; i < bytes.length; i++) {
			byteBuffer.put(bytes[i]);
		}
		byteBuffer.flip();
		for (int i = 0; i < 4; i++) {
			System.out.println(byteBuffer.get());
		}
		byteBuffer.compact();
		byteBuffer.putChar('a');
		System.out.println(byteBuffer.get(byteBuffer.position()-1));
	}
}
