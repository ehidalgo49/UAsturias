package org.challenge.uasturias;

import org.challenge.fizzbuzz.FizzBuzz;
import org.challenge.maxadjsum.MaxAdjSum;
import org.challenge.notificationservice.Solution;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class UAsturiasApplication {

    public static void main(String[] args) {
        FizzBuzz fizz = new FizzBuzz();
        MaxAdjSum max = new MaxAdjSum();
        Solution sol = new Solution();

        //fizz.init(); //Ejercicio 1
        //max.init(new int[]{4, 8, -1, -3, 7, 8}); //Ejercicio 2
        sol.init(); //Ejercicio 3

        //SpringApplication.run(UAsturiasApplication.class, args);
    }

}
