package com.lxl.ServerSocket;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * 为多个客户端服务的服务器
 * ClassName: ServerSocketThreadTest
 * 
 * @Description: TODO
 * @author lxl
 * @date 2016-4-21
 */
public class ServerSocketThreadTest {
	public static void main(String[] args) {
		try {
			int i = 1;
			ServerSocket s = new ServerSocket(8189);
			while (true) {
				Socket incoming = s.accept();
				System.out.println("Spawning " + i);
				Runnable r = new ThreadedEchoHandler(incoming, i);
				Thread t = new Thread(r);
				t.start();
				i++;
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
