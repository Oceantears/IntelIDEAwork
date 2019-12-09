/**
 * <一句话功能简述>
 * <计算字符串“7+1  +5    -  4   +3”的值>
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
		System.out.println(noSpace+"的和为："+js.eval(noSpace));
	}
}
