# Spring Boot RESTful API Tutorial

## 1. Giới thiệu về RESTful API

<details>
<summary><strong>a. Mô hình Client - Server</strong></summary>

* **Client**: Gửi request (yêu cầu) đến server.
* **Server**: Xử lý request và trả về response (phản hồi).
* Client và server hoạt động độc lập, giao tiếp qua HTTP.

</details>

<details>
<summary><strong>b. API là gì?</strong></summary>

* **API (Application Programming Interface)**: Giao diện giữa các phần mềm cho phép trao đổi dữ liệu.
* Cho phép client giao tiếp với backend mà không cần hiểu rõ logic bên trong.

</details>

<details>
<summary><strong>c. REST là gì?</strong></summary>

* **REST (Representational State Transfer)**: Kiểu thiết kế kiến trúc cho web service.
* Dựa trên giao thức HTTP (GET, POST, PUT, DELETE).
* Dữ liệu thường được gửi với định dạng JSON.

</details>

## 2. Thực hành API qua dự án Quản lý Sinh Viên

* Xây dựng API cho các chức năng:

    * Thêm mới sinh viên
    * Cập nhật thông tin
    * Xóa sinh viên
    * Lịch sử sử dụng API (GET all / GET by ID)
* Sử dụng Spring Boot + Maven + Postman để test.

## 3. Validation trong Spring Boot

* Dùng annotation: `@NotNull`, `@Size`, `@Email`, `@Min`, `@Max`,...
* Tự động validate input từ client trước khi xử lý.
* Kết hợp với `@Valid` trong controller.

## 4. Handle Exception và Response về FE

* Tạo class `@ControllerAdvice` + `@ExceptionHandler` để xử lý exception tập trung.
* Tạo format response chung (message, timestamp, status).
* Tránh lỗi trực tiếp trả về FE.

## 5. Kết nối Database

### a. Giới thiệu ORM & Spring Data JPA

* **ORM (Object Relational Mapping)**: Chuyển đổi giữa object trong Java và bảng trong DB.
* **Spring Data JPA**: Framework hỗ trợ ORM, tự động tạo truy vấn (query).
* **Code First**: Thiết kế Entity trước, DB tự sinh ra từ Entity.

### b. Kết nối DB

* Cấu hình trong `application.properties`:

```properties
spring.datasource.url=jdbc:mysql://localhost:3306/demo
spring.datasource.username=root
spring.datasource.password=123456
spring.jpa.hibernate.ddl-auto=update
```

### c. Tạo Entity demo

```java
@Entity
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    private String name;

    @Email
    private String email;

    private int age;
}
```

## 6. Cách áp dụng AI hỗ trợ code Backend
