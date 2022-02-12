public class Dog {
	String breed;
	String size;
	int age;
	String color;

	public Dog() {
	}

	public Dog(String breed_, String size_, int age_, String color_) {
		breed = breed_;
		size = size_;
		age = age_;
		color = color_;
	}
	public void showData() {
		System.out.println("Breed is " + breed);
		System.out.println("Size is " + size);
		System.out.println("Age is " + age + " years old");
		System.out.println("Color is " + color);
	}

	public static void main(String[] args) {
		Dog dog = new Dog("Akita Inu", "Midium", 3, "Brown");
		dog.showData();
	}
}
