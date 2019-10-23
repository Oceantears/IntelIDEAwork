/**
 * <一句话功能简述>
 * <奥运会奖牌榜>
 *
 * 1、金牌数量最多的排在前面
 * 2、其次银牌数量最多的排在前面
 * 3、然后铜牌数量最多的排在前面
 * 4.如果奖牌数量都一样，则按照国家名称的字典顺序排列
 *
 * 输入：
 * 第一行输入整数n(0-21)，代表国家数量。
 * 接下来的n行，每行为一个字符串，包括国家名称，金牌数量，银牌数量，铜牌数量，中间用空格隔开，如(China 54 23 36)
 *
 * 5
 * China 54 23 36
 * America 50 42 33
 * England 45 15 20
 * Rusia 50 42 33
 * Japan 45 15 15
 *
 * @author sunmeng
 * @create 2019/10/15   15:16
 */
package homework20191015;


import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.regex.Pattern;

public class OlympicsList {
	public static void main(String[] args) {
		ArrayList<Country> countries=new ArrayList<>();

		Scanner scanner=new Scanner(System.in);
		System.out.println("请输入国家的数量：");
		int n=scanner.nextInt();
		scanner.nextLine();

		for (int i = 1; i <n+1 ; i++) {
			System.out.println("请输入第"+i+"个国家的名称、金牌数量、银牌数量、铜牌数量：");
			String s=scanner.nextLine();
			countries.add(getCountry(s));
		}
		countries.sort(Country::compareTo);


		System.out.println("================国家奖牌榜================");
		for (Country coun:countries) {
			System.out.println(coun.toString());
		}

	}

	//拆分录入的国家信息
	private static Country getCountry(String s){
		Country country=new Country();
		String[] strings= s.split("\\s+");             //正则表达式\s表示匹配任何空白字符，+表示匹配一次或多次。
		country.setName(strings[0]);
		country.setGoldMedal(Integer.parseInt(strings[1]));
		country.setSilverMedal(Integer.parseInt(strings[2]));
		country.setBronzeMedal(Integer.parseInt(strings[3]));
		return country;
	}

	public static ArrayList<Country> countriesSort(ArrayList<Country> country) {
		// Class clazz=Class.forName("Country");
		// Field[] fields=clazz.getDeclaredFields();             //利用反射机制获取Country类中的字段
		// for (Field f:fields) {
		// 	System.out.println(f.getType().getName());
		// }
		for(int i=0;i<country.size();i++){

		}
		return null;
	}
	public static boolean countryCompare(Country coun1,Country coun2){

		boolean result=false;

		int result1=new Integer(coun1.getGoldMedal()).compareTo(new Integer(coun2.getGoldMedal()));  //金牌比较
		int result2=new Integer(coun1.getSilverMedal()).compareTo(new Integer(coun2.getSilverMedal()));   //银牌比较
		int result3=new Integer(coun1.getBronzeMedal()).compareTo(new Integer(coun2.getBronzeMedal()));     //铜牌比较
		if(result1!=0){
			result=result1==1?true:false;
		}
		else{
			if(result2!=0){
				result=result2==1?true:false;
			}
			else {
				if(result3!=0){
					result=result3==1?true:false;
				}
				else {
					result=coun1.getName().compareTo(coun2.getName())==1?true:false;
				}
			}
		}
		return result;
	}
}
