/**
 * <һ�仰���ܼ���>
 * <�����ַ�����7+1  +5    -  4   +3����ֵ>
 *
 * @author sunmeng
 * @create 2019/12/2   16:26
 */
package leetCodeTest;

import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;

public class Test {
	public static void main(String[] args) throws ScriptException {
		String s="7+1  +5    -  4   +3";
		String[] ss=s.split(" ");
		String noSpace="";
		for (String s2:ss) {
			noSpace+=s2;
		}
		System.out.println(noSpace);

		ScriptEngine js = new ScriptEngineManager().getEngineByName("JavaScript");
		System.out.println(noSpace+"�ĺ�Ϊ��"+js.eval(noSpace));
	}
}
