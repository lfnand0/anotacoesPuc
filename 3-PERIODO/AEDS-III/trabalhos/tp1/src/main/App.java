package main;
import java.io.*;
import java.util.*;
import java.lang.*;

import dao.*;

public class App {
    static Scanner sin = new Scanner(System.in);
    RandomAccessFile arq;

    public static void main(String[] args) throws Exception {
            Dao count;
            int i = 0;

            /*CRUD CONTA BANCARIA*/
            do{
                System.out.print("------ CRUD ------\n 1. Create\n 2. Read\n 3. Update\n 4. Delete\n 5. Transferencia\n 6. Sair");
                i = sin.nextInt();

                switch (i){
                    //Create
                    case 1:
                        System.out.print("\n Name: ");
                        String name = sin.nextLine();
                        System.out.print("\n CPF: ");
                        int cpf = sin.nextInt();
                        System.out.print("\n City: ");
                        String city = sin.nextLine();
                        
                        count = new Dao(name,cpf,city);
                        System.out.println("\n Your ID is " + count.create(count));
                    break;
   
                    //Read
                    case 2: 
                    
                    break;
   
                    //Update
                    case 3: 
                    
                    break;
   
                    //Delete
                    case 4: 
                    
                    break;

                    //Trans
                    case 5:

                    break;
                    
                    //Exit
                    case 6:
                        System.out.println("\nTenha um otimo dia!");
                    break;

                    //Invalid Option
                    default:
                        System.out.println("\nPor favor, escolha uma opcao valida!");
                    break;

                }
                
            }while(i != 6);
    }
}
