/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplication1;

/**
 *
 * @author admin
 */
public class JavaApplication1 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
     
        int a = 234, b=45;
        if (a ==234) {System.out.println("верно");} 
        else {System.out.println("неверно");} 

        
        if (a != 234) {System.out.println("неравно 234");} 
        else if (a >= 200) {System.out.println("больше 200"); }
                       else {System.out.println("меньше 200"); }
        
        
	if (a !=234 ||b ==45) {System.out.println("неравно 234");} 
        else {System.out.println("больше 200");}

       
        if (a!=234&&b ==45){System.out.println("не равно 234");}
        else {System.out.println("больше 200");}
          
    }
    
}
