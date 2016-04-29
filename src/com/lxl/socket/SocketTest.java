package com.lxl.socket;

import java.io.IOException;
import java.io.InputStream;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

/**
 * 连接到服务器 
 * ClassName: SocketTest
 * 
 * @Description: TODO
 * @author lxl
 * @date 2016-4-21
 */
public class SocketTest {
	public static void main(String[] args) {
		try {
			// 打开一个套接字 （将远程地址和端口号传递给套接字的构造器，连接失败抛出UnknownHostException异常）
			Socket s = new Socket("time-A.timefreq.bldrdoc.gov", 13);
			try {
				// 套接字打开后，可以获得InputStream
				InputStream inStream = s.getInputStream();
				// 获得InputStream后，程序可以使用一个Scanner读取服务器发送的每一行字符，将每一行打印到标准输出
				// 此过程持续到流发送完毕且服务器断开连接为止
				Scanner in = new Scanner(inStream);
				while (in.hasNext()) {
					String line = in.nextLine();
					System.out.println(line);
				}
			} finally {
				s.close();
			}
		} catch (UnknownHostException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
