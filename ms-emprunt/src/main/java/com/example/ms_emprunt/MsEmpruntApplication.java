package com.example.ms_emprunt;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients //Active les conection entre ms-personnel et ms-emprunt
public class MsEmpruntApplication {

	public static void main(String[] args) {
		SpringApplication.run(MsEmpruntApplication.class, args);
	}

}
