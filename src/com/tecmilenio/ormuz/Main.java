package com.tecmilenio.ormuz;

import java.util.Scanner;
import java.io.IOException;

public class Main {

    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        MenuSchedule menuSchedule = new MenuSchedule(sc);

        boolean running;
        do {
            running = true;

            try{
                var op = menuSchedule.mainMenu();
                isValid(op);

                switch (op){
                    case 1:
                        menuSchedule.menuList();
                        break;
                    case 2:
                        menuSchedule.menuAdd();
                        break;
                    case 3:
                        menuSchedule.menuDelete();
                        break;
                    default:
                        running = false;
                        break;
                }
            }
            catch (Exception e){
                System.out.println(e.getMessage());
            }


        }while (running);
    }

    public static void isValid(int op) throws Exception {
        if(op < 1 || op > 4){
            throw new Exception("Invalid Opcion");
        }
    }
}
