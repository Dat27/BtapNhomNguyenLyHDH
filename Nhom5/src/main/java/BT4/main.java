/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BT4;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;
import java.util.*;
/**
 *
 * @author dattk
 */
public class main extends Process{
    
    static int[][] mat = new int[20][6];
  
    static void arrangeArrival(int num, int[][] mat)
    {
        for (int i = 0; i < num; i++) {
            for (int j = 0; j < num - i - 1; j++) {
                if (mat[j][1] > mat[j + 1][1]) {
                    for (int k = 0; k < 5; k++) {
                        int temp = mat[j][k];
                        mat[j][k] = mat[j + 1][k];
                        mat[j + 1][k] = temp;
                    }
                }
            }
        }
    }
    
     static void completionTime(int num, int[][] mat) {
        int temp, val = -1;
        mat[0][3] = mat[0][1] + mat[0][2];
        mat[0][5] = mat[0][3] - mat[0][1];
        mat[0][4] = mat[0][5] - mat[0][2];

        for (int i = 1; i < num; i++) {
            temp = mat[i - 1][3];//11
            int low = mat[i][2];//2

            for (int j = i; j < num; j++) {
                if (temp >= mat[j][1] && low >= mat[j][2]) {
                    low = mat[j][2];
                    val = j;
                }
            }
            mat[val][3] = temp + mat[val][2];
            mat[val][5] = mat[val][3] - mat[val][1];
            mat[val][4] = mat[val][5] - mat[val][2];
            for (int k = 0; k < 6; k++) {
                int tem = mat[val][k];
                mat[val][k] = mat[i][k];
                mat[i][k] = tem;
            }
        }
         for (int i = 0; i < num; i++) {
             for (int j = i+1; j < num -i -1; j++) {
                 if (mat[j][2] == mat[i][2]) {
                    for (int k = 0; k < 5; k++) {
                        int tg = mat[j][k];
                        mat[j][k]=mat[i][k];
                        mat[i][k] = tg;
                    }
                }
             }
         }
    }
 
    public List<Process> readFromFile() {
        int n = 0;
        List<Process> list = new ArrayList<>();
        try {
            FileReader fr = new FileReader("input.txt");
            BufferedReader br = new BufferedReader(fr);
            String line = "";
            while (true) {
                line = br.readLine();
                if (line == null) {
                    break;
                }
                n++;
                String pro[] = line.split(";");
                int proId = Integer.parseInt(pro[0]);
                int arrTime = Integer.parseInt(pro[1]);
                int burTime = Integer.parseInt(pro[2]);
                list.add(new Process(proId, arrTime, burTime));

            }
//            numOfLine =n;
        } catch (Exception e) {
        }
        return list;
    }
    


    public static void main(String[] args) {
        main m = new main();
        int num =0;
        int[][] a = new int[20][6]  ;
        List<Process> list = m.readFromFile();
        for (Process process : list) {
            num++;
        }
        for (int i = 0; i < num; i++) {
            mat[i][0]=list.get(i).getProId();
            mat[i][1]=list.get(i).getArrTime();
            mat[i][2]=list.get(i).getBurTime();  
        }
        System.out.println("Truoc khi lap lich");
        System.out.println("Process ID\tArrival Time\tBurst Time");
        for (int j = 0; j < num; j++) {
            System.out.printf("%d\t\t%d\t\t%d\n",mat[j][0],mat[j][1],mat[j][2]);
        }
        arrangeArrival(num, mat);
        completionTime(num, mat);
        System.out.println("Ket qua: ");
        System.out.println("Process ID\tArrival Time\tBurst Time\tWaiting Time\tTurnaround Time");
        for (int i = 0; i < num; i++) {
            System.out.printf("%d\t\t%d\t\t%d\t\t%d\t\t%d\n", mat[i][0],
                mat[i][1], mat[i][2], mat[i][4], mat[i][5]);
        }


    }
}
