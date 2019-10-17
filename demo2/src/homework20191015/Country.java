/**
 * <一句话功能简述>
 * <国家类>
 *
 * @author sunmeng
 * @create 2019/10/15   15:39
 */
package homework20191015;


public class Country implements Comparable<Country> {
	private String name;
	private int goldMedal;         //金牌
	private int silverMedal;       //银牌
	private int bronzeMedal;       //铜牌

	public Country(String name, int goldMedal, int silverMedal, int bronzeMedal) {
		this.name = name;
		this.goldMedal = goldMedal;
		this.silverMedal = silverMedal;
		this.bronzeMedal = bronzeMedal;
	}

	public Country() {
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getGoldMedal() {
		return goldMedal;
	}

	public void setGoldMedal(int goldMedal) {
		this.goldMedal = goldMedal;
	}

	public int getSilverMedal() {
		return silverMedal;
	}

	public void setSilverMedal(int silverMedal) {
		this.silverMedal = silverMedal;
	}

	public int getBronzeMedal() {
		return bronzeMedal;
	}

	public void setBronzeMedal(int bronzeMedal) {
		this.bronzeMedal = bronzeMedal;
	}

	@Override
	public String toString() {
		return name + '\t' + goldMedal+'\t' + silverMedal+'\t' + bronzeMedal ;
	}


	@Override
	public int compareTo(Country c) {
		int result=0;
		int result1=- new Integer(this.getGoldMedal()).compareTo(new Integer(c.getGoldMedal()));  //金牌比较
		int result2=- new Integer(this.getSilverMedal()).compareTo(new Integer(c.getSilverMedal()));   //银牌比较
		int result3=- new Integer(this.getBronzeMedal()).compareTo(new Integer(c.getBronzeMedal()));     //铜牌比较
		if(result1!=0){
			result=result1;
		}
		else{
			if(result2!=0){
				result=result2;
			}
			else {
				if(result3!=0){
					result=result3;
				}
				else {
					result=this.getName().compareTo(c.getName());
				}
			}
		}
		return result;
	}

	// @Override
	// public int compare(Country o1, Country o2) {
	// 	int result=0;
	// 	int result1=new Integer(o1.getGoldMedal()).compareTo(new Integer(o2.getGoldMedal()));  //金牌比较
	// 	int result2=new Integer(o1.getSilverMedal()).compareTo(new Integer(o2.getSilverMedal()));   //银牌比较
	// 	int result3=new Integer(o1.getBronzeMedal()).compareTo(new Integer(o2.getBronzeMedal()));     //铜牌比较
	// 	if(result1!=0){
	// 		result=result1;
	// 	}
	// 	else{
	// 		if(result2!=0){
	// 			result=result2;
	// 		}
	// 		else {
	// 			if(result3!=0){
	// 				result=result3;
	// 			}
	// 			else {
	// 				result=o1.getName().compareTo(o2.getName());
	// 			}
	// 		}
	// 	}
	// 	return result;
	// }
}
