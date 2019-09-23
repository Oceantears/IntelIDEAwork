/**
 * <一句话功能简述>
 * <Address类>
 *
 * @author sunmeng
 * @create 2019/9/20   14:53
 */
package practice20190920.worker;

public class Address {
    public String getAddress() {
        return address;
    }

    public String getZipCode() {
        return zipCode;
    }

    private String address;
    private String zipCode;

    public Address(){

    }
    public Address(String address,String zipCode){
        this.address=address;
        this.zipCode=zipCode;
    }
}
