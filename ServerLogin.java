package ������Socket�����ַ���;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class ServerLogin {

	public static void main(String[] args) {
		// 1.����һ��ServerSocket���󣬲�ָ���˿ں�
		try {
			ServerSocket ss = new ServerSocket(8000);
			// 2.�����ͻ�������
			/**
			 * ��Ϊss.accept()�������ص���Socket����
			 * ����Ҫ��һ��socket����������
			 */
			Socket socket = ss.accept();
			// 3.�����������������û�����
			/**
			 * ��Ϊsocket.getInputStream()�������ص���inputStream����
			 * ����Ҫ��һ��InputStream����������
			 */
			InputStream is = socket.getInputStream();
			BufferedReader br = new BufferedReader(new InputStreamReader(is));
			/*
			 * �����BufferedReader�� ��ȡ��Ϣ�ˣ� ��Ҫһ��String ����������
			 */
			String info = null;// �� info=br.readLine()
			/** ��ȡ��ʱ��Ҫһ��һ�еĶ�������Ҫ�õ� whileѭ�� */
			while ((info = br.readLine()) != null) {
				System.out.println("���Ƿ��������ͻ�����ϢΪ��" + info);
			}
			/**���������ͻ���һ����Ӧ
			 * �ٴ����������������*/
			OutputStream os=socket.getOutputStream();
			info="��ӭ�� ��¼�ɹ�";
			os.write(info.getBytes());
			/**�����˹ر�*/
			// 4.�ر���Դ
			/** ���ȹ� */
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
