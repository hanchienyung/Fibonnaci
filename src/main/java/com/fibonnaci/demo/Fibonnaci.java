package com.fibonnaci.demo;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class Fibonnaci {


    // Generate Fibonnaci sequence by summing the previous 4 numbers
    private StringBuffer generate_sequence (int fibCount ){


        StringBuffer display = new StringBuffer();
        int[] fib = new int[fibCount];


        fib[0] = 0;
        fib[1] = 1;
        for (int i=2; i < fibCount; i++) {

            if (i >= 4)
            {
               fib[i] = fib[i-1] + fib[i-2] + fib[i-3] + fib[i-4];

            }
            else // if there are less than 4 previous numbers, use the fibonnaci rule for previous 2 numbers
            {
               fib[i] = fib[i-1] + fib[i-2];
            }

        }


        display.append("Fibonnaci series using sum of previous 4 numbers <br/>");


        //build display string
        for(int i=0; i< fibCount; i++){
            display.append(fib[i]);
            display.append(" ");
        }

        return display;
    }


    @RequestMapping("/getCount")
    public String getCount (@RequestParam("count") int count)
    {
        if (count < 2)
        {
           return "Please enter fibonnaci number equal or greater than 2 <br/>";
        }
        else
        {
            return generate_sequence(count).toString();
        }

    }


}
