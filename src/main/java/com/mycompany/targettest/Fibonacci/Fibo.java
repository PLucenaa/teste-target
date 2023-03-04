/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/File.java to edit this template
 */
package com.mycompany.targettest.Fibonacci;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import static javax.swing.UIManager.get;

/**
 *
 * @author Pedro
 */
public class Fibo {

    public static void main(String args[]) {
        Scanner num = new Scanner(System.in);
        System.out.println("Informe um número para verificar se faz parte da sequência de Fibonacci");
        int n = num.nextInt();
        boolean fazParte = false;
        List<Integer> sequencia = fibonacci(n);
        for(int i = 0; i < sequencia.size(); i++) {
            if(sequencia.get(i) == n) {
                fazParte = true;
                break;
            }
        }
        if(fazParte){
            System.out.printf("%d pertence a sequência de Fibonacci!\n", n);
        }else{
            System.out.printf("%d não pertence a sequência de Fibonacci!\n", n);
        }
        num.close();
    }
    
    public static List<Integer> fibonacci(int max){
        List<Integer> sequencia = new ArrayList<>();
        int a = 0, b = 1, c;
        sequencia.add(a);
        while(b <= max){
            sequencia.add(b);
            c = a + b;
            a = b;
            b = c;
        }
        return sequencia;
    }
}
