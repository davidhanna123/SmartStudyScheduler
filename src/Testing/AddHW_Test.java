package Testing;

import BusinessLogic.Add_Homework;
import BusinessLogic.Homework;

public class AddHW_Test {

	public static void main(String[] args) {
		Homework homework = Add_Homework.addHomework();
		System.out.println(homework);

	}

}
