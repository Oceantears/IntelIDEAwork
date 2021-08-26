package demo_20210512_AnnotationDemo.NO1_useCase;

import java.util.List;

/**
 * @date ：Created in 2021/5/12 15:03
 * @version: java 8
 */
public class PassWordUtils {
    @UseCase(id = 47,description = "Password must contain at least one numeric")
    public boolean validatePassword(String password){
        return password.matches("\\w*\\d\\w*");
    }
    @UseCase(id = 48)
    public String encryptPassword(String password){
        return new StringBuilder(password).reverse().toString();
    }
    @UseCase(id = 49,description = "New passwords can not equal previously used ones")
    public boolean checkForNewPassword(List<String> prevPasswords,String password){
        return !prevPasswords.contains(password);
    }
}
