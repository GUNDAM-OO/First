package �ַ���д;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Reader;
import java.io.Writer;

public class TestBufferedWriter {
	public static void main(String[] args) {
		Writer fw = null;
		BufferedWriter bw = null;
		/** д����ڽ��ж�ȡ */
		Reader fr = null;
		BufferedReader br = null;
		try {
			fw = new FileWriter("d:/�ַ������BufferedWriter");
			bw = new BufferedWriter(fw);
			// д����Ϣ
			bw.write("��Һ�������ѧϰBufferedWriter");
			bw.newLine();/**����*/
			bw.write("����ָ��");
			bw.flush();/**BufferedWriter�ǵ�ˢ��*/
			// ����Ϣ
			fr = new FileReader("d:/�ַ������BufferedWriter");
			br = new BufferedReader(fr);
			/** BufferedReader���ж�ȡ ���Զ���String line */
			String line;
			// ��ʼ��ȡ
			// ѭ����
			while ((line = br.readLine()) != null) {
				System.out.println(line);
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			if (fw != null) {
				try {
					fw.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			if (bw != null) {
				try {
					bw.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				if (fr != null) {
					try {
						fr.close();
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
				if (br != null) {
					try {
						br.close();
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			}
		}

	}

}
