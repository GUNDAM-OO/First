package 字符流写;

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
		/** 写入后在进行读取 */
		Reader fr = null;
		BufferedReader br = null;
		try {
			fw = new FileWriter("d:/字符流输出BufferedWriter");
			bw = new BufferedWriter(fw);
			// 写入信息
			bw.write("大家好我正在学习BufferedWriter");
			bw.newLine();/**换行*/
			bw.write("请多多指教");
			bw.flush();/**BufferedWriter记得刷新*/
			// 读信息
			fr = new FileReader("d:/字符流输出BufferedWriter");
			br = new BufferedReader(fr);
			/** BufferedReader按行读取 所以定义String line */
			String line;
			// 开始读取
			// 循环读
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
