package com.ti2cc;
import java.io.*;
import java.util.*;

public class Principal {
	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);
		DAO dao = new DAO();
		dao.conectar(); // Abrindo o server
		
		Usuario user = new Usuario();

		boolean close = false;
		while (!close) {
			System.out.println("\n------ DB TI2 (Operações CRUD) ------");
			System.out.println("1. List\n2. Insert\n3. Delete\n4. Update\n5. Exit");
			int aux = sc.nextInt();

			if (aux != 5) {
				if (aux == 1) {
					// List
					Usuario[] userArr = dao.getUsuarios();

					System.out.println("\n------ User Listing ------");
					for (int i = 0; i < userArr.length; i++) {
						System.out.println("User " + i + ". " + userArr[i].toString());
					}
				} else if (aux == 2) {
					// Insert
					System.out.println("------ Insert ------");

					System.out.print("Code: ");
					int code = sc.nextInt();

					System.out.print("\nName: ");
					String name = sc.readLine();
					
					System.out.print("\nPassword: ");
					String password = sc.readLine();

					System.out.print("\nGender (M or F): ");
					String gender = sc.nextChar();

					user = new Usuario(code, name, password, gender);
					if (dao.inserirUsuario(user) == true) {
						System.out.println("User " + user.toString() + " inserted succesfully. ");
					} else {
						System.out.println("Sorry, an error occured. Try again later.");
					}
				} else if (aux == 3) {
					// Delete
					System.out.println("------ Delete ------");
					System.out.print("Type the code of the user you want to delete: ");
					int code = sc.nextInt();

					if (dao.excluirUsuario(code)) {
						System.out.println("User deleted.");
					} else {
						System.out.println("Sorry, an error occured. Try again");
					}					
				} else if (aux == 4) {
					// Update
					System.out.println("------ Update ------");
					System.out.println("1. Update name\n2. Update password\n3. Update gender\n4. Exit");
					int updAux = sc.nextInt();
					while (updAux < 1 || updAux > 4) {
						System.out.println("Type a number between 1 and 4: ");
						updAux = sc.nextInt();
					}

					if (updAux != 4) {
						if (updAux == 1) {
							System.out.println("New name: ");
							String newName = sc.readLine();

							user.setLogin(newName);
						} else if (updAux == 2) {
							System.out.println("New password: ");
							String newPassword = sc.readLine();

							user.setPassword(newPassword);
						} else if (updAux == 3) {
							System.out.println("New gender: ");
							char newGender = sc.nextChar();

							user.setSexo(newGender);
						}

						dao.atualizarUsuario(user);
					}
				} else {
					// Error handling (invalid value of aux)
					System.out.println("Error: invalid code. Type a number between 1 and 5");
				}
			} else {
				close = true;
			}
		}

		System.out.println("-------------------------------------");
		dao.close();
		sc.close();
	}
}