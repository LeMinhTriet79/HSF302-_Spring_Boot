package com.example.seminar;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SeminarApplication {

	public static void main(String[] args) {
		SpringApplication.run(SeminarApplication.class, args);
	}

	//LẤY LÀ GET

	//POST ~ CREATE NEW
	//POST: /api/student

	//PUT ~ UPDATE
	//PUT: /api/student/id --> cần phải biết cái nào, ai, thông qua id
	//PATCH ---> Cập nhật một trường nào đó cụ thể

	//DELETE
	//DELETE: /api/student/id
	//--> nó giống PUT ~ UPDATE, cần phải chỉ rõ cụ thể, đâu đó rõ ràng, không c nói chung chung
}
