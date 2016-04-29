package com.lxl.ServerSocket;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

/**
 * 简单服务器，可以向客户端发送消息 服务器程序启动后，等待客户端连接到它的端口 每个服务器都不间断的执行下面的这个循环操作
 * 1）通过输入数据流从客户端接受一个命令 2）通过某种方式获取信息 3）通过输出数据流给客户端发送信息 ClassName:
 * ServerSocketTest
 * 
 * @Description: TODO
 * @author lxl
 * @date 2016-4-21
 */
public class ServerSocketTest {
	public static void main(String[] args) {
		try {
			// ServerSocket 建立一个套接字，此处建立一个负责监控端口8189的服务器
			ServerSocket s = new ServerSocket(8189);
			// 此命令用于告诉程序不停地等待，直到有客户端连接到这个端口
			Socket incoming = s.accept();
			try {
				// 服务器发送给服务器输出流的所有信息都会成为客户端程序的输入，
				// 同时来自客户端程序的所有输出都会被包含在服务器的输入流中
				InputStream inStream = incoming.getInputStream();
				OutputStream outStream = incoming.getOutputStream();
				// 将输入流转换为扫描器，将输出流转换为复写器
				Scanner in = new Scanner(inStream);
				PrintWriter out = new PrintWriter(outStream, true/* autoFlush */);
				// 此代码将给客户端发送一条消息
				out.print("Hello!Enter BYE toexit");

				boolean done = false;
				// 服务器读取客户端的输入，并输出这一行
				while (!done && in.hasNextLine()) {
					String line = in.nextLine();
					out.println("Echo: " + line);
					if ("BYE".equals(line.trim())) {
						done = true;
					}
				}
			} finally {
				// 关闭连接进来的套接字
				incoming.close();
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
