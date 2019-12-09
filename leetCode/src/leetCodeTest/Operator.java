/**
 * <一句话功能简述>
 * <test2>
 *
 * @author sunmeng
 * @create 2019/12/2   17:02
 */
package leetCodeTest;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public abstract class Operator {

	/**
	 * 运算符
	 */
	private char operator;

	/**
	 * 运算符的优先级别，数字越大，优先级别越高
	 */
	private int priority;

	private static Map<Character, Operator> operators = new HashMap<Character, Operator>();

	private Operator(char operator, int priority) {
		setOperator(operator);
		setPriority(priority);
		register(this);
	}

	private void register(Operator operator) {
		operators.put(operator.getOperator(), operator);
	}

	/**
	 * 加法运算
	 */
	public final static Operator ADITION = new Operator('+', 100) {
		public double eval(double left, double right) {
			return left + right;
		}
	};

	/**
	 * 减法运算
	 */
	public final static Operator SUBTRATION = new Operator('-', 100) {
		public double eval(double left, double right) {
			return left - right;
		}
	};

	/**
	 * 乘法运算
	 */
	public final static Operator MULTIPLICATION = new Operator('*', 200) {
		public double eval(double left, double right) {
			return left * right;
		}
	};

	/**
	 * 除法运算
	 */
	public final static Operator DIVITION = new Operator('/', 200) {
		public double eval(double left, double right) {
			return left / right;
		}
	};

	/**
	 * 冪运算
	 */
	public final static Operator EXPONENT = new Operator('^', 300) {
		public double eval(double left, double right) {
			return Math.pow(left, right);
		}
	};

	/**
	 * 取模运算
	 */
	public final static Operator MOD = new Operator('%', 200) {
		public double eval(double left, double right) {
			return left % right;
		}
	};

	public char getOperator() {
		return operator;
	}
	private void setOperator(char operator) {
		this.operator = operator;
	}
	public int getPriority() {
		return priority;
	}
	private void setPriority(int priority) {
		this.priority = priority;
	}

	/**
	 * 根据某个运算符获得该运算符的优先级别
	 * @param c
	 * @return      运算符的优先级别
	 */
	public static int getPrority(char c) {
		Operator op = operators.get(c);
		if(op != null) {
			return op.getPriority();
		}
		return 0;
	}

	/**
	 * 工具方法，判断某个字符是否是运算符
	 * @param c
	 * @return      是运算符返回 true，否则返回 false
	 */
	public static boolean isOperator(char c) {
		return getInstance(c) != null;
	}
	public static boolean isOperator(String str) {
		if(str.length() > 1) {
			return false;
		}
		return isOperator(str.charAt(0));
	}

	/**
	 * 根据运算符获得 Operator 实例
	 * @param c
	 * @return      从注册中的 Operator 返回实例，尚未注册返回 null
	 */
	public static Operator getInstance(char c) {
		return operators.get(c);
	}
	public static Operator getInstance(String str) {
		if(str.length() > 1) {
			return null;
		}
		return getInstance(str.charAt(0));
	}

	/**
	 * 根据操作数进行计算
	 * @param left    左操作数
	 * @param right   右操作数
	 * @return        计算结果
	 */
	public abstract double eval(double left, double right);
}
class Test1 {

	public static void main(String[] args) {
		// String str = "40944.0501-3.2*100";
		String s="7+1  +5    -  4   +3";
		Calculator cal = new Calculator();
		double d = cal.eval(s);
		System.out.println(d);
	}
}

interface MathSymbol {

	/**
	 * 左括号
	 */
	public final static char LEFT_BRACKET   = '(';

	/**
	 * 右括号
	 */
	public final static char RIGHT_BRACKET  = ')';

	/**
	 * 中缀表达式中的空格，需要要忽略
	 */
	public final static char BLANK          = ' ';

	/**
	 * 小数点符号
	 */
	public final static char DECIMAL_POINT  = '.';

	/**
	 * 负号
	 */
	public final static char NEGATIVE_SIGN  = '-';

	/**
	 * 正号
	 */
	public final static char POSITIVE_SIGN  = '+';

	/**
	 * 后缀表达式的各段的分隔符
	 */
	public final static char SEPARATOR      = ' ';
}



class Calculator implements MathSymbol {

	/**
	 * 计算中缀表达式
	 * @param expression
	 * @return
	 */
	public double eval(String expression) {
		String str = infix2Suffix(expression);
		//System.out.println(" Infix Expression: " + expression);
		//System.out.println("Suffix Expression: " + str);
		if(str == null) {
			throw new IllegalArgumentException("Expression is null!");
		}
		String[] strs = str.split("\\s+");
		Stack<String> stack = new Stack<String>();
		for(int i = 0; i < strs.length; i++) {
			if(!Operator.isOperator(strs[i])) {
				stack.push(strs[i]);
			} else {
				Operator op = Operator.getInstance(strs[i]);
				double right = Double.parseDouble(stack.pop());
				double left = Double.parseDouble(stack.pop());
				double result = op.eval(left, right);
				stack.push(String.valueOf(result));
			}
		}
		return Double.parseDouble(stack.pop());
	}

	/**
	 * 将中缀表达式转换为后缀表达式
	 * @param expression
	 * @return
	 */
	public String infix2Suffix(String expression) {
		if(expression == null) {
			return null;
		}
		char[] chs = expression.toCharArray();
		Stack<Character> stack = new Stack<Character>();
		StringBuilder sb = new StringBuilder(chs.length);
		boolean appendSeparator = false;
		boolean sign = true;
		for(int i = 0; i < chs.length; i++) {
			char c = chs[i];
			if(c == BLANK) {
				continue;
			}
			// Next line is used output stack information.
			// System.out.printf("%-20s %s%n", stack, sb.toString());
			if(appendSeparator) {
				sb.append(SEPARATOR);
				appendSeparator = false;
			}
			if(isSign(c) && sign) {
				sb.append(c);
				continue;
			}
			if(isNumber(c)) {
				sign = false;
				sb.append(c);
				continue;
			}
			if(isLeftBracket(c)) {
				stack.push(c);
				continue;
			}
			if(isRightBracket(c)) {
				sign = false;
				while(stack.peek() != LEFT_BRACKET) {
					sb.append(SEPARATOR);
					sb.append(stack.pop());
				}
				stack.pop();
				continue;
			}
			appendSeparator = true;
			if(Operator.isOperator(c)) {
				sign = true;
				if(stack.isEmpty() || stack.peek() == LEFT_BRACKET) {
					stack.push(c);
					continue;
				}
				int precedence = Operator.getPrority(c);
				while(!stack.isEmpty() && Operator.getPrority(stack.peek()) >= precedence) {
					sb.append(SEPARATOR);
					sb.append(stack.pop());
				}
				stack.push(c);
			}
		}
		while(!stack.isEmpty()) {
			sb.append(SEPARATOR);
			sb.append(stack.pop());
		}
		return sb.toString();
	}

	/**
	 * 判断某个字符是否是正号或者负号
	 * @param c
	 * @return
	 */
	private boolean isSign(char c) {
		if(c == NEGATIVE_SIGN || c == POSITIVE_SIGN) {
			return true;
		}
		return false;
	}

	/**
	 * 判断某个字符是否为数字或者小数点
	 * @param c
	 * @return
	 */
	private boolean isNumber(char c) {
		if((c >= '0' && c <= '9') || c == DECIMAL_POINT) {
			return true;
		}
		return false;
	}

	/**
	 * 判断某个字符是否为左括号
	 * @param c
	 * @return
	 */
	private boolean isLeftBracket(char c) {
		return c == LEFT_BRACKET;
	}

	/**
	 * 判断某个字符是否为右括号
	 * @param c
	 * @return
	 */
	private boolean isRightBracket(char c) {
		return c == RIGHT_BRACKET;
	}
}
