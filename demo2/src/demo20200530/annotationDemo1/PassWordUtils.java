/**
 * <一句话功能简述>
 * <p>
 * 注解@UseCase的引用实例
 *
 * @author sunmeng
 * @create 2020/5/30   9:19
 */
package demo20200530.annotationDemo1;

import java.util.List;

public class PassWordUtils {
	//验证密码
	@UseCase(id =47,description = "Passwords must contain at least one numeric")
	public boolean validatePassword(String password){
		return password.matches(("\\w*\\d\\w*"));
	}
	//加密密码
	@UseCase(id=48)
	public String encryptPassword(String password){
		return new StringBuilder(password).reverse().toString();
	}
	//新密码检验
	@UseCase(id = 49,description = "New passwords can't equal previously used ones")
	public boolean checkForNewPassword(List<String> prevPasswords,String password){
		return !prevPasswords.contains(password);
	}
}
