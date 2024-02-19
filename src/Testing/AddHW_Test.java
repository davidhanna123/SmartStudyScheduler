package Testing;

import BusinessLogic.Homework;
import Gui.Add_Homework;

public class AddHW_Test {

	public static void main(String[] args) {
		Homework homework = Add_Homework.addHomework();
		System.out.println(homework);

	}

}
