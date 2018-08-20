package 字符流写;

import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;

public class TestFileWriter {
/**
 * 使用FileWriter想文本文件中写信息
 * 1.创建流
 * 2.写入信息
 * 3.关闭流*/
	public static void main(String[] args) {
	//第一步创建流
		Writer wr=null;
		try {
			/**true为追加写*/
			wr=new FileWriter("d:/字符流输出不需要新建，调用方法自动建立.txt",true);
			//第二部 些信息
			
			wr.write("\n我爱你中国\n");/**傳入想要寫的此符傳，
			可以調用這個方法直接寫
			也可以建String str來實現 都一樣*/
			
			wr.flush();/**还不是很懂 反正记得刷新*/
			//刷新缓 单纯刷新  让所有信息输出？
			/**因为FileWriter没有缓冲区 
			 * 叫做刷新该流的缓冲*/
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
