package 第五章Socket发送字符串;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.Socket;

public class ClientLogin {
	public static void main(String[] args) {
		// 1.创建Socket对象（并制定服务器IP地址以及，端口号）
		try {
			Socket socket = new Socket("localhost", 8000);
			/** 因为服务器在本机，
			 * 所以Ip地址不需要直接写localhost意为“本地主机” */
			// 2.打开输出流
			OutputStream os = socket.getOutputStream();
			/** socket.getOutputStream()方法返回OutputStream对象，
			 * 所以要用其对象来接收 */
			/* 定义客户端要发送的字符串 */
			String info = "用户名：Tom；密码：1234";
			os.write((info.getBytes()));
			/**
			 * os.write()方法中只有返回int和byte数组 
			 * 显然int不合适所以要用getByte
			 * 所以要把要发送的字符串转换成byte类型 info.getByte()
			 */
			///////////////////////////////////
			/**客户端接受服务器信息反馈*/
			InputStream is=socket.getInputStream();
			//可以把字节流封装成bufferedReader
			BufferedReader br=new BufferedReader(new InputStreamReader(is));
			/**注意
			 * BufferedReader的参数是 InputStreamReader
			 * 是一个转换流
			 * 把字节流转换成字符串*/
			info="";//清空操作
			/**循环读入*/
			while((info=br.readLine())!=null){
				System.out.println("我是客户端，服务器的响应是："+info);
			}
			/**别忘了关闭*/
			is.close();
			// 3.关闭资源
			os.close();
			socket.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
