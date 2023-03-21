package lesson_19;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.io.Serializable;
import java.util.ArrayList;

public class Methods {

	public static void serialize(File file, Serializable object) throws Exception{
		OutputStream os = new FileOutputStream(file);
		ObjectOutputStream oos = new ObjectOutputStream(os);
		oos.writeObject(object);
		oos.close();
	}
	
	public static Serializable deserealize(File file) throws Exception {
		InputStream is = new FileInputStream(file);
		ObjectInputStream ois = new ObjectInputStream(is);
		Serializable object = (Serializable) ois.readObject();
		is.close();
		ois.close();
		
		return object;
	}
	
	public static void main(String[] args) throws Exception {
		
		File file = new File("lesson_19.txt");
		Employee e1 = new Employee("John", 1, 750);
		Employee e2 = new Employee("Rick", 2, 480);
		Employee e3 = new Employee("Dale", 3, 650);
		Employee e4 = new Employee("Peter", 4, 960);
		Employee e5 = new Employee("Jessica", 5, 340);
		
		ArrayList<Employee> arrList = new ArrayList();
		arrList.add(e1);
		arrList.add(e2);
		arrList.add(e3);
		arrList.add(e4);
		arrList.add(e5);
		
		serialize(file, e1);
		System.out.println(deserealize(file));
		System.out.println();
		
		serialize(file, arrList);
		System.out.println(deserealize(file));
	}
}
