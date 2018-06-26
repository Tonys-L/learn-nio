package com.lt;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.Channels;
import java.nio.channels.ReadableByteChannel;
import java.nio.channels.WritableByteChannel;

/**
 * 功能：
 *
 * @author ：LT(286269159@qq.com)
 * @version ：2018 Version：1.0
 * @create ：2018-06-26 10:26:40
 */
public class ChannelCopy {
	public static void main(String[] args) throws IOException {
		ReadableByteChannel source = Channels.newChannel(System.in);
		WritableByteChannel dest = Channels.newChannel(System.out);
		channelCopy(source, dest);
		source.close();
		dest.close();
	}

	private static void channelCopy(ReadableByteChannel source, WritableByteChannel dest) throws IOException {
		ByteBuffer byteBuffer = ByteBuffer.allocateDirect(12 * 1024);
		while ((source.read(byteBuffer)) != -1) {
			byteBuffer.flip();
			dest.write(byteBuffer);
			byteBuffer.clear();
		}
		byteBuffer.flip();
		while (byteBuffer.hasRemaining()) {
			dest.write(byteBuffer);
		}
	}

	private static void channelCopy1(ReadableByteChannel source, WritableByteChannel dest) throws IOException {
		ByteBuffer byteBuffer = ByteBuffer.allocateDirect(16 * 1024);
		while (source.read(byteBuffer) != -1) {
			byteBuffer.flip();
			while (byteBuffer.hasRemaining()) {
				dest.write(byteBuffer);
			}
			byteBuffer.clear();
		}
	}
}
