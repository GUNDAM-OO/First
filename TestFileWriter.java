package �ַ���д;

import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;

public class TestFileWriter {
/**
 * ʹ��FileWriter���ı��ļ���д��Ϣ
 * 1.������
 * 2.д����Ϣ
 * 3.�ر���*/
	public static void main(String[] args) {
	//��һ��������
		Writer wr=null;
		try {
			/**trueΪ׷��д*/
			wr=new FileWriter("d:/�ַ����������Ҫ�½������÷����Զ�����.txt",true);
			//�ڶ��� Щ��Ϣ
			
			wr.write("\n�Ұ����й�\n");/**������Ҫ���Ĵ˷�����
			�����{���@������ֱ�ӌ�
			Ҳ���Խ�String str�팍�F ��һ��*/
			
			wr.flush();/**�����Ǻܶ� �����ǵ�ˢ��*/
			//ˢ�»� ����ˢ��  ��������Ϣ�����
			/**��ΪFileWriterû�л����� 
			 * ����ˢ�¸����Ļ���*/
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			if (wr!=null) {
				try {
					wr.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			}
		
	}

}
