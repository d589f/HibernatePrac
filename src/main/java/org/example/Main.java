package org.example;


import org.example.hibernate_test_2.operations.AddPerson;
import org.example.hibernate_test_2.operations.DeletePerson;
import org.example.hibernate_test_2.operations.FilteringPeopleBy;
import org.example.hibernate_test_2.operations.ModifyData;

import java.util.Scanner;


public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Choose an operation, what you will do (AddPerson/DeletePerson/ModifyData/FilterBy): ");
        String answer = scanner.nextLine();
        switch (answer){
            case "AddPerson":
                AddPerson.addPerson();
                break;
            case "DeletePerson":
                DeletePerson.deletePerson();
                break;
            case "ModifyData":
                ModifyData.modifyData();
                break;
            case "FilterBy":
                System.out.print("What you would filter salary or department?: ");
                String secondAnswer = scanner.nextLine();
                if(secondAnswer.equalsIgnoreCase("salary")){
                    FilteringPeopleBy.filteringPeopleBySalary();
                } else if (secondAnswer.equalsIgnoreCase("department")) {
                    FilteringPeopleBy.filteringPeopleByDepartment();
                }
                break;
            default:
                System.out.println("There's no such operation yet. ");
        }
    }
}
