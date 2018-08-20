package 第五章Socket发送字符串;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class ServerLogin {

	public static void main(String[] args) {
		// 1.创建一个ServerSocket对象，并指定端口号
		try {
			ServerSocket ss = new ServerSocket(8000);
			// 2.监听客户端请求
			/**
			 * 因为ss.accept()方法返回的是Socket对象
			 * 所以要用一个socket对象来接受
			 */
			Socket socket = ss.accept();
			// 3.打开输入流，并处理用户请求
			/**
			 * 因为socket.getInputStream()方法返回的是inputStream对象，
			 * 所以要用一个InputStream对象来接收
			 */
			InputStream is = socket.getInputStream();
			BufferedReader br = new BufferedReader(new InputStreamReader(is));
			/*
			 * 下面从BufferedReader中 读取信息了， 需要一个String 类型来接收
			 */
			String info = null;// 即 info=br.readLine()
			/** 读取的时候要一行一行的读，所以要用到 while循环 */
			while ((info = br.readLine()) != null) {
				System.out.println("我是服务器，客户端信息为：" + info);
			}
			/**服务器给客户端一个响应
			 * ①打开输出流，发送数据*/
			OutputStream os=socket.getOutputStream();
			info="欢迎你 登录成功";
			os.write(info.getBytes());
			/**别忘了关闭*/
			// 4.关闭资源
			/** 后开先关 */
			br.close();
			is.close();
			os.close();
			socket.close();
			ss.close();
		} catch (IOException e) {

			e.printStackTrace();
		}
	}

}
