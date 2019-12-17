/**
 * <一句话功能简述>
 * <p>
 * 编写一个装饰者，把输入流内所有大写字符转化成小写
 *
 * @author sunmeng
 * @create 2019/12/12   14:52
 */
package decoratorModel.java_io;


import java.io.FilterInputStream;
import java.io.IOException;
import java.io.InputStream;

public class LowerCaseInputStream extends FilterInputStream {
	/**
	 * Creates a <code>FilterInputStream</code>
	 * by assigning the  argument <code>in</code>
	 * to the field <code>this.in</code> so as
	 * to remember it for later use.
	 *
	 * @param in the underlying input stream, or <code>null</code> if
	 *           this instance is to be created without an underlying stream.
	 */
	protected LowerCaseInputStream(InputStream in) {
		super(in);
	}

	//实现两个read()方法，一个针对字节，一个针对字节数组把每个是大写字符的字节（每个代表一个字符）转成小写
	public int read() throws IOException {
		int c=super.read();                  //如果有字符，c是0到255之间的数，如果读不到字符，就返回-1
		return (c==-1?c:Character.toLowerCase((char)c));
	}
	//b为已经读取的缓冲数组，offset为数组b所在的起始位置，len是数组读取的最小长度
	public int read(byte[] b,int offset,int len) throws IOException {
		int result=super.read(b,offset,len);
		for(int i=offset;i<offset+result;i++){
			b[i]=(byte) Character.toLowerCase((char)b[i]);
		}
		return result;
	}

}
