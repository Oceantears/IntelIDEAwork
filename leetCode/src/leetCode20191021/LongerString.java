/**
 * <һ�仰���ܼ���>
 *
 * <����һ���ַ����������ҳ����в������ظ��ַ�����Ӵ��ĳ��ȡ�>
 *
 * @author sunmeng
 * @create 2019/10/21   16:09
 */
package leetCode20191021;


public class LongerString {
	public static int lengthOfLongestSubstring(String s) {
		char[] chars=s.toCharArray();
		int maxLength=0;
		int startIndex=0;
		//ѡ��������j����ǰ�����������ȡ�ַ���
		for(int j=0;j<chars.length;j++){
			for(int k=startIndex;k<j;k++){
				if(chars[k]==chars[j]){
					startIndex=k+1;             //�ظ��Ժ��������ƶ�һλ
					break;
				}
			}
			if(j-startIndex+1>maxLength){
				maxLength=j-startIndex+1;
			}
		}
		return maxLength;
	}

	public static void main(String[] args) {
		System.out.println(lengthOfLongestSubstring("abcbcbb"));

	}
}
