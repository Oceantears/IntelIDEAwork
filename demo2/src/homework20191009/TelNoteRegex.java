/**
 * <一句话功能简述>
 * <用户输入验证>
 *
 * TelNoteRegex类中方法（无成员变量）
 * menuRegex (int min, int max ) 对菜单输入选项的验证
 * nameRegex ( ) 对用户输入姓名的验证
 * ageRegex ( ) 对用户输入年龄的验证
 * sexRegex ( ) 对用户输入性别的验证
 * telNumRegex ( ) 对用户输入电话号码的验证
 * addressRegex ( ) 对用户输入地址的验证
 *
 * @author sunmeng
 * @create 2019/10/9   9:24
 */
package homework20191009;

import java.util.regex.Pattern;

public class TelNoteRegex {
	//对菜单输入选项的验证
	public boolean menuRegex(int min,int max){
		return true;
	}
	//对用户输入姓名的验证
	public boolean nameRegex(String name){

		return Pattern.matches("[a-zA-Z]{1,10}",name);
	}
	//对用户输入年龄的验证
	public boolean ageRegex(String age){
		return Pattern.matches("1\\d{2}|[1-9]?\\d",age);      //1\\d{2}为100-199，[1-9]?\\d为0-99，？表示一次或者一次也没有，\d前的\为转义
	}
	//对用户输入性别的验证
	public boolean sexRegex(String sex){
		return Pattern.matches("[男女]|[mf]|[MF]",sex);
	}
	//对用户输入电话号码的验证
	public boolean telNumRegex(String telNum){
		return Pattern.matches("[1-9]\\d{5,9}",telNum);
	}
	//对用户输入地址的验证
	public boolean addressRegex(String addr){
		return Pattern.matches("",addr);
	}
}
