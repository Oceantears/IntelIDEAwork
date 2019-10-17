/**
 * <一句话功能简述>
 * <一个字符串，包含空格，大小写，标点符号。 输出要求:每个单词首字母大写，单词间只有一个空格，无标点符号，结尾加英文句号(.)>
 *
 * @author sunmeng
 * @create 2019/10/15   20:58
 */
package homework20191015;



public class StringPrint {
	public static void main(String[] args) {
		String s=" ashfj esfh    qeio.fjie   kjdF我sgjs, fsiF!!euh UHA世界IUSFasf ";

		System.out.println(getString(s));
	}
	public static String getString(String s){
		String s4="";
		String s5="";
		if(s!=null){
			String s1=s.trim();                //去前后的空格
			String s2=s1.replaceAll("[\\pP\\p{Punct}]"," ");       //清除所有符号,只留下字母 数字  汉字  共3类.
			String[] s3=s2.split("\\s+");   //去String中的空格

			for (String str: s3) {
				s4=s4+str.replace(str.charAt(0),String.valueOf(str.charAt(0)).toUpperCase().charAt(0))+" ";   //把字符串首字母改为大写
			}
			s5=s4.trim()+".";
		}
		return s5;
	}
}
