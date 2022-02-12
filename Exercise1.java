/*Tian Xiaoyang
* Oct 13 2021
* Exercise 1
*/
public class Exercise1 extends Dog {

    public Exercise1(String dog_type, String body_size, int age_NO, String hair_color) {
        breed = dog_type;
        size = body_size;
        age = age_NO;
        color = hair_color;
        showData();
    }
    
    public static void main(String[] args) {
        new Exercise1("Doberman", "Large", 5, "Black");
    }

}
