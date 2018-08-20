package 字符流读;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.util.Arrays;

public class TestReader {
	// 三步走
	public static void main(String[] args) {
		// 1.创建字符流对象
		Reader fr = null;
		StringBuffer sb = null;
		try {
			fr = new FileReader("d:/我的青春我做主.txt");
			// 2.开始读取文本文件
			/* 方法一： 一个字符一个字符的读取 int words; while ((words = fr.read()) != -1) {
			 * System.out.print((char) words);// 读取到控制台 }*/
			/** 这里不要用println要用这个不换行的 */
			/* 方法二： read的另一个重写方法，存到字符数组里读取 */
			char[] words = new char[1024];// 存储读取到的字符
			// 定义一个字符串，把读到的字符串进行拼接
			sb = new StringBuffer();
			/** 开始读取 */
			// 定义一个int类型接受读取的字符串长度
			int len = fr.read(words);
			/** 读取我的青春文件并存入到字符数组words中， 返回读取到的字符串长度赋给int len */
			System.out.println("int的长度是" + len + "这个时候数组已经存入文本了"+ Arrays.toString(words));
			while (len != -1) {
				// 因为上一句话已经调用read方法进行了一次读取
				// 并把读取到的内容存入到words中
				// 所以直接把words中的内容拼接到StringBuffer sb后面好了
				sb.append(words);
				System.out.println("展示字符串拼接" + sb.toString());
				System.out.println("长度是：" + len);
				// 然后开始下一次读取
				len = fr.read(words);
				System.out.println("再进行读取一次，字符串的样子不变" + sb.toString());
				System.out.println("再读取一次， int的长度变化，变为：" + len);
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				// 3.关闭流
				if (fr != null) {// fr不是空文件的时候把流关闭
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
