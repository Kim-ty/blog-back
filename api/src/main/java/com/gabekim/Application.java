package com.gabekim;
import org.jasypt.encryption.pbe.StandardPBEStringEncryptor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.PropertySource;

@SpringBootApplication
@PropertySource(value={"classpath:/dbinfo.properties"})
@PropertySource(value={"classpath:/systeminfo.properties"})
public class Application implements CommandLineRunner {
	public static void main(String[] args) {
		
		SpringApplication.run(Application.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		StandardPBEStringEncryptor spe = new StandardPBEStringEncryptor();
		// spe.setAlgorithm("PBEWithMD5AndDES");
		// spe.setPassword(System.getenv("JASYPT_PASSWORD"));
		// String jdbc = spe.encrypt("jdbc:mariadb://localhost:3306/gabeBlog"); 추후작업
		// String id = spe.encrypt("root"); 추후작업
		// String pw = spe.encrypt("rlaxodus1!"); 추후작업
		
	}


}
