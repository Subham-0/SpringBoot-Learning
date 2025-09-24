# 🚦 Spring Request Flow with Filters

When a request comes in, it follows this path:


#### Request → Filter Chain → DispatcherServlet (Front Controller) → Controller → View → Response


---

## 🔎 Filters in the Servlet Filter Chain

In a Spring Boot application (with Spring Security), the **filter chain** is built from multiple **Servlet filters**. Some common ones include:

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
By stealing or reusing a session ID, an attacker can trick your browser into sending unwanted requests (e.g., modifying or deleting data).

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
