package com.example.KONECTA;
 import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
 import org.springframework.web.bind.annotation.PostMapping;
 import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class loginController {

        @GetMapping("/login")
        public String showLoginPage() {
            return "login";
        }
    @PostMapping("/login")
    public String processLogin(@RequestParam String username, @RequestParam String password) {
        // Exemplo de verificação simples (futuramente, isso será substituído por um banco de dados)
        if ("Josueluis".equals(username) && "123456".equals(password)) {
            // Se as credenciais estiverem corretas, redirecione para a página do dashboard
            return "redirect:/dashboard";
        }

        // Se estiverem incorretas, redirecione de volta para a página de login
        return "redirect:/login";
    }

    @GetMapping ("/dashboard")
    public String showDashboard (){
            return "teste-dashboard";
        }
    }
