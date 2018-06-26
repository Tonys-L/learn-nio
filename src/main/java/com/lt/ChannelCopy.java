package com.lt;

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
	public static void main(String[] args) {
		ReadableByteChannel source = Channels.newChannel(System.in);
		WritableByteChannel dest = Channels.newChannel(System.out);

	}
}
