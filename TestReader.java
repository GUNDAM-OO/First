package �ַ�����;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.util.Arrays;

public class TestReader {
	// ������
	public static void main(String[] args) {
		// 1.�����ַ�������
		Reader fr = null;
		StringBuffer sb = null;
		try {
			fr = new FileReader("d:/�ҵ��ഺ������.txt");
			// 2.��ʼ��ȡ�ı��ļ�
			/* ����һ�� һ���ַ�һ���ַ��Ķ�ȡ int words; while ((words = fr.read()) != -1) {
			 * System.out.print((char) words);// ��ȡ������̨ }*/
			/** ���ﲻҪ��printlnҪ����������е� */
			/* �������� read����һ����д�������浽�ַ��������ȡ */
			char[] words = new char[1024];// �洢��ȡ�����ַ�
			// ����һ���ַ������Ѷ������ַ�������ƴ��
			sb = new StringBuffer();
			/** ��ʼ��ȡ */
			// ����һ��int���ͽ��ܶ�ȡ���ַ�������
			int len = fr.read(words);
			/** ��ȡ�ҵ��ഺ�ļ������뵽�ַ�����words�У� ���ض�ȡ�����ַ������ȸ���int len */
			System.out.println("int�ĳ�����" + len + "���ʱ�������Ѿ������ı���"+ Arrays.toString(words));
			while (len != -1) {
				// ��Ϊ��һ�仰�Ѿ�����read����������һ�ζ�ȡ
				// ���Ѷ�ȡ�������ݴ��뵽words��
				// ����ֱ�Ӱ�words�е�����ƴ�ӵ�StringBuffer sb�������
				sb.append(words);
				System.out.println("չʾ�ַ���ƴ��" + sb.toString());
				System.out.println("�����ǣ�" + len);
				// Ȼ��ʼ��һ�ζ�ȡ
				len = fr.read(words);
				System.out.println("�ٽ��ж�ȡһ�Σ��ַ��������Ӳ���" + sb.toString());
				System.out.println("�ٶ�ȡһ�Σ� int�ĳ��ȱ仯����Ϊ��" + len);
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				// 3.�ر���
				if (fr != null) {// fr���ǿ��ļ���ʱ������ر�
					fr.close();
				}
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out.println(sb.toString());
		}
	}

}
