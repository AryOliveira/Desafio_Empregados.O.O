package application;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Locale;
import java.util.Scanner;

import entities.Address;
import entities.Department;
import entities.Employee;

public class Program {

	public static void main(String[] args) throws ParseException {
		
		Department dept = new Department();

		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		SimpleDateFormat sdf = new SimpleDateFormat("dd");
		
		System.out.print("Nome do departamento: ");
		String departmentName = sc.nextLine();
		System.out.print("Dia do pagamento:");
		int payDay = sc.nextInt();
		System.out.println();
		System.out.print("Email: ");		
		String email = sc.nextLine();
		System.out.printf("");
		System.out.print("");
		System.out.println("Telefone: ");
		String phone = sc.nextLine();
		
		Department department = new Department(departmentName, payDay, null);			
	
		System.out.print("Quantos funcionários tem o departamento? ");
		int n = sc.nextInt();
		
		for (int i=1; i<=n; i++) {
			System.out.println("Dados do funcionário" + i + ":");
			System.out.print("Name: ");
			String employeeName = sc.nextLine();
			System.out.println("Salário: ");
			double employeeSalary = sc.nextDouble();
			
			Employee emp = new Employee(employeeName, employeeSalary);
			dept.addEmployee(emp);		
			
		}		
		showReport(dept);
		sc.close();

	}
	
	// Método estático para exibir o relatório na tela
    public static void showReport(Department dept) {
        System.out.println("FOLHA DE PAGAMENTO:");
        System.out.println("Departamento " + dept.getName() + " = R$ " + dept.payroll());
        System.out.println("Pagamento realizado no dia " + dept.getPayDay());
        System.out.println("Funcionários:"); 	
        System.out.print("Para dúvidas favor entrar em contato: " + dept.getAddress().getEmail());
    }
}
