package application;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import model.dao.DaoFactory;
import model.dao.DepartmentDao;
import model.entities.Department;

public class Program2 {

	public static void main(String[] args) {
		Scanner ler = new Scanner(System.in);
		
		DepartmentDao departmentDao = DaoFactory.createDepartmentDao();
		System.out.println("===== TEST 1: department findById =====");
		Department department = departmentDao.findById(3);
		System.out.println(department);
		
		List<Department> list = new ArrayList<>();
		System.out.println("\n===== TEST 2: department findAll =====");
		list = departmentDao.findAll();
		list.forEach(System.out::println);
		
		System.out.println("\n===== TEST 3: department insert =====");
		Department newDepartment = new Department(null, "Monitor");
		departmentDao.insert(newDepartment);
		System.out.println("Inserted! New id = " + newDepartment.getId());
		
		System.out.println("\n===== TEST 4: department update =====");
		department = departmentDao.findById(1);
		department.setName("Sports");
		departmentDao.update(department);
		System.out.println("Updated Completed!");
		
		System.out.println("\n===== TEST 5: department delete =====");
		System.out.print("Enter with Id: ");
		int id = ler.nextInt();
		departmentDao.deleteById(id);
		System.out.println("Delete completed!");
		
		ler.close();
	}
}
