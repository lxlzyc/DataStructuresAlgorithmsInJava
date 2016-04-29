package com.lxl.ServerSocket;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

/**
 * 每个客户端连接，启动一个线程
 * ClassName: ThreadedEchoHandler
 * 
 * @Description: TODO
 * @author lxl
 * @date 2016-4-21
 */
public class ThreadedEchoHandler implements Runnable {

	private Socket incoming;
	private int counter;

	public ThreadedEchoHandler(Socket incoming, int counter) {
		this.incoming = incoming;
		this.counter = counter;
	}

	public void run() {
		// TODO Auto-generated method stub
		try {
			try {
				InputStream inStream = incoming.getInputStream();
				OutputStream outStream = incoming.getOutputStream();

				Scanner in = new Scanner(inStream);

				PrintWriter out = new PrintWriter(outStream, true/* 自动刷新 */);

				out.print("Hello! enter BYE to exit");
				boolean done = false;
				while (!done && in.hasNextLine()) {
					String line = in.nextLine();
					out.println("ECHO:" + line);
					if ("BYE".equals(line.trim())) {
						done = true;
					}
				}
			} finally {
				incoming.close();
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
