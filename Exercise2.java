/*Tian Xiaoyang
 * Oct 13, 2021
 * Exercise 2
 */
public class Exercise2 extends Dog {

    public Exercise2(String dog_type, String body_size, int age_NO, String hair_color) {
        breed = dog_type;
        size = body_size;
        age = age_NO;
        color = hair_color;
        showData();
    }
    public void showData() {
        System.out.println("Data of " + breed + " is " + size + ", " + age +" years old " + " and " + color);
    }

    public static void main(String[] args) {
        new Exercise2("Doberman", "Large", 5, "Black");
    }
}
