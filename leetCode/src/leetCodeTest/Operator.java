/**
 * <һ�仰���ܼ���>
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
	 * �����
	 */
	private char operator;

	/**
	 * ����������ȼ�������Խ�����ȼ���Խ��
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
	 * �ӷ�����
	 */
	public final static Operator ADITION = new Operator('+', 100) {
		public double eval(double left, double right) {
			return left + right;
		}
	};

	/**
	 * ��������
	 */
	public final static Operator SUBTRATION = new Operator('-', 100) {
		public double eval(double left, double right) {
			return left - right;
		}
	};

	/**
	 * �˷�����
	 */
	public final static Operator MULTIPLICATION = new Operator('*', 200) {
		public double eval(double left, double right) {
			return left * right;
		}
	};

	/**
	 * ��������
	 */
	public final static Operator DIVITION = new Operator('/', 200) {
		public double eval(double left, double right) {
			return left / right;
		}
	};

	/**
	 * ������
	 */
	public final static Operator EXPONENT = new Operator('^', 300) {
		public double eval(double left, double right) {
			return Math.pow(left, right);
		}
	};

	/**
	 * ȡģ����
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
	 * ����ĳ���������ø�����������ȼ���
	 * @param c
	 * @return      ����������ȼ���
	 */
	public static int getPrority(char c) {
		Operator op = operators.get(c);
		if(op != null) {
			return op.getPriority();
		}
		return 0;
	}

	/**
	 * ���߷������ж�ĳ���ַ��Ƿ��������
	 * @param c
	 * @return      ����������� true�����򷵻� false
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
	 * ������������ Operator ʵ��
	 * @param c
	 * @return      ��ע���е� Operator ����ʵ������δע�᷵�� null
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
	 * ���ݲ��������м���
	 * @param left    �������
	 * @param right   �Ҳ�����
	 * @return        ������
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
	 * ������
	 */
	public final static char LEFT_BRACKET   = '(';

	/**
	 * ������
	 */
	public final static char RIGHT_BRACKET  = ')';

	/**
	 * ��׺���ʽ�еĿո���ҪҪ����
	 */
	public final static char BLANK          = ' ';

	/**
	 * С�������
	 */
	public final static char DECIMAL_POINT  = '.';

	/**
	 * ����
	 */
	public final static char NEGATIVE_SIGN  = '-';

	/**
	 * ����
	 */
	public final static char POSITIVE_SIGN  = '+';

	/**
	 * ��׺���ʽ�ĸ��εķָ���
	 */
	public final static char SEPARATOR      = ' ';
}



class Calculator implements MathSymbol {

	/**
	 * ������׺���ʽ
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
	 * ����׺���ʽת��Ϊ��׺���ʽ
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
	 * �ж�ĳ���ַ��Ƿ������Ż��߸���
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
	 * �ж�ĳ���ַ��Ƿ�Ϊ���ֻ���С����
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
	 * �ж�ĳ���ַ��Ƿ�Ϊ������
	 * @param c
	 * @return
	 */
	private boolean isLeftBracket(char c) {
		return c == LEFT_BRACKET;
	}

	/**
	 * �ж�ĳ���ַ��Ƿ�Ϊ������
	 * @param c
	 * @return
	 */
	private boolean isRightBracket(char c) {
		return c == RIGHT_BRACKET;
	}
}
