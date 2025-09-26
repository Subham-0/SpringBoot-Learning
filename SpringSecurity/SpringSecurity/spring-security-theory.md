# 🚦 Spring Request Flow with Filters

When a request comes in, it follows this path:

#### Request → Filter Chain → DispatcherServlet (Front Controller) → Controller → View → Response

---

## 🔎 Filters in the Servlet Filter Chain

In a Spring Boot application (with Spring Security), the **filter chain** is built from multiple **Servlet filters**.
Some common ones include:

- **CharacterEncodingFilter** → ensures request/response character encoding (e.g., UTF-8).
- **HiddenHttpMethodFilter** → allows using HTTP verbs like `PUT`, `DELETE` via `_method` parameter in forms.
- **CorsFilter** → handles CORS pre-flight requests and response headers.
- **RequestContextFilter** → exposes request attributes to Spring’s `RequestContextHolder`.
- **FormContentFilter** → allows form data to be read in `PUT`, `PATCH`, etc.

### 🔐 Spring Security Filters (key ones)

- **`SecurityContextPersistenceFilter`**
- **`UsernamePasswordAuthenticationFilter`** → processes login form submissions
- **`BasicAuthenticationFilter`** → handles HTTP Basic authentication
- **`CsrfFilter`** → provides Cross-Site Request Forgery protection
- **`ExceptionTranslationFilter`** → handles authentication/authorization exceptions
- **`FilterSecurityInterceptor`** → final access decision filter

---

## 📌 Example Flow with Spring Security Enabled

1. **Request comes in**
2. Passes through **generic filters** (encoding, CORS, etc.)
3. Hits the **Spring Security filter chain**
    - (implemented internally as a `DelegatingFilterProxy` that delegates to multiple security filters)
4. If **authentication succeeds** → request goes to **DispatcherServlet → Controller**
5. If **not authenticated** → Spring Security intercepts
    - Redirects to **login page** (form login), or
    - Returns **401 Unauthorized / 403 Forbidden**

---

## 🔒 CSRF (Cross-Site Request Forgery)

**Problem:**  
By stealing or reusing a session ID, an attacker can trick your browser into sending unwanted requests (e.g., modifying
or deleting data).

---

### ✅ How Spring Prevents CSRF

- Spring Security provides a **CSRF token** to protect against such attacks.
- A **CSRF token** is created along with the **session ID**.
- The token is made available to the client as a **hidden form field** or can be sent as a **header**.
- When the client sends a request:
    - Spring Security checks if the **CSRF token is present and valid**.
    - If the token is missing or invalid → the request is **rejected**.
    - If the token matches → the request is **allowed**.

---

### ⚙️ CSRF Token Lifecycle

1. When you **log in**, Spring generates a CSRF token.
2. This token is stored on the server side (tied to your session).
3. The token is also sent to the client (as hidden input or header).
4. On every subsequent request that **modifies state** (POST, PUT, DELETE), the client must send the token back.
5. Spring Security validates the token before processing the request.

---

### 📌 Important Notes

- **GET requests**: CSRF protection is not enforced (safe operations — just reading data).
- **State-changing requests (POST, PUT, DELETE, PATCH)**: CSRF token is **mandatory** if Spring Security is enabled.
- This ensures that only requests originating from your trusted application (with the correct token) are accepted.

---

### Costume Username and password

- you can add your costume username and password just by specify n properties file
    - `spring.security.user.name=subham`
    - `spring.security.user.password=1234`

# 🔑 Spring Security Authentication Flow

When a request comes in, **Spring Security filters** handle authentication before the request reaches your controller.

---

## 1. Filters in Authentication
- The **Authentication Filter** (e.g., `UsernamePasswordAuthenticationFilter`) intercepts login requests.
- It extracts the **username** and **password** from the request (form fields, JSON, headers, etc.).
- Creates an **Authentication object** (with credentials) and passes it to the **Authentication Manager**.

---

## 2. Authentication Manager
- The **AuthenticationManager** is the central point for processing authentication.
- It delegates the request to one or more **Authentication Providers** until one can handle it.

---

## 3. Authentication Provider
- The **AuthenticationProvider** performs the actual verification of credentials.
- It uses:
    - **PasswordEncoder** → to compare raw password with the encoded one stored in DB.
    - **UserDetailsService** → to load user information from the data source (e.g., DB, LDAP, in-memory).

---

## 4. UserDetailsService
- Custom implementation provides user data from your database.
- Important method:
  ```java
  UserDetails loadUserByUsername(String username)
#### Returns a UserDetails object containing:
- username
- password (encoded)
- roles/authorities

Request  
    ↓  
Authentication Filter  
    ↓  
Authentication Manager  
    ↓  
Authentication Provider  
    ↓  
UserDetailsService → loadUserByUsername()  
    ↓  
PasswordEncoder (verify password)  
    ↓  
✅ Success → SecurityContext updated  
❌ Failure → Error response


# ⚙️ Custom Spring Security Configuration

In Spring Security, we can override the default security settings by defining a **SecurityFilterChain** bean.  
This gives full control over authentication, authorization, CSRF, and login mechanisms.

---

## 📌 Key Points in the Example

```java
@Configuration
@EnableWebSecurity
public class WebSecurityConfig {
    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity) throws Exception {
        httpSecurity
            .csrf(Customizer.withDefaults()) // CSRF protection enabled by default
            .authorizeHttpRequests(request -> request.anyRequest().authenticated()) // all requests need authentication
            .formLogin(Customizer.withDefaults()) // enable default login form
            .httpBasic(Customizer.withDefaults()); // enable HTTP Basic auth
        return httpSecurity.build();
    }
}
