package com.digis01.ERoqueProgramacionNCapasWeb;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication
public class ERoqueProgramacionNCapasWebApplication implements CommandLineRunner  {
    
    
    public static Logger Log = LoggerFactory.getLogger("ERoqueProgramacionNCapasWebApplication");    
    
	public static void main(String[] args) {
		SpringApplication.run(ERoqueProgramacionNCapasWebApplication.class, args);
	}
        
        @Override
        public void run(String... args) throws Exception{
            //System.out.println("Hello Word");
            Log.warn("Peligro");
        }
        
       
        

}
