package ������Socket�����ַ���;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.Socket;

public class ClientLogin {
	public static void main(String[] args) {
		// 1.����Socket���󣨲��ƶ�������IP��ַ�Լ����˿ںţ�
		try {
			Socket socket = new Socket("localhost", 8000);
			/** ��Ϊ�������ڱ�����
			 * ����Ip��ַ����Ҫֱ��дlocalhost��Ϊ������������ */
			// 2.�������
			OutputStream os = socket.getOutputStream();
			/** socket.getOutputStream()��������OutputStream����
			 * ����Ҫ������������� */
			/* ����ͻ���Ҫ���͵��ַ��� */
			String info = "�û�����Tom�����룺1234";
			os.write((info.getBytes()));
			/**
			 * os.write()������ֻ�з���int��byte���� 
			 * ��Ȼint����������Ҫ��getByte
			 * ����Ҫ��Ҫ���͵��ַ���ת����byte���� info.getByte()
			 */
			///////////////////////////////////
			/**�ͻ��˽��ܷ�������Ϣ����*/
			InputStream is=socket.getInputStream();
			//���԰��ֽ�����װ��bufferedReader
			BufferedReader br=new BufferedReader(new InputStreamReader(is));
			/**ע��
			 * BufferedReader�Ĳ����� InputStreamReader
			 * ��һ��ת����
			 * ���ֽ���ת�����ַ���*/
			info="";//��ղ���
			/**ѭ������*/
			while((info=br.readLine())!=null){
				System.out.println("���ǿͻ��ˣ�����������Ӧ�ǣ�"+info);
			}
			/**�����˹ر�*/
			is.close();
			// 3.�ر���Դ
			os.close();
			socket.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
