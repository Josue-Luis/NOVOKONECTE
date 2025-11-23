package com.example.KONECTA;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class loginController {

    // Método para exibir a página de login
    @GetMapping("/login")
    public String showLoginPage() {
        return "login";
    }

    // Método para processar o login e criar a sessão
    @PostMapping("/login")
    public String processLogin(
            @RequestParam String username,
            @RequestParam String password,
            HttpServletRequest request) {

        // Exemplo de verificação simples por conta da Ausencia do BD
        if ("Josueluis".equals(username) && "123456".equals(password)) {

            // Cria/Recupera a sessão e armazena o nome do usuário
            // Usando o username como exemplo para a saudação
            request.getSession(true).setAttribute("LOGGED_USER", username);

            // Redireciona para o dashboard
            return "redirect:/dashboard";
        }

        // Erro de senha ou user
        return "redirect:/login?error";
    }

    // método para exibir o dashboard com personalização
    @GetMapping ("/dashboard")
    public String showDashboard (HttpServletRequest request, Model model){


        // Se o usuário não estiver logado, redireciona para o login
        if (request.getSession(false) == null || request.getSession().getAttribute("LOGGED_USER") == null) {
            return "redirect:/login";
        }

        // 🔑 PASSAGEM DE DADOS PARA O HTML (THYMELEAF) 🔑
        String username = (String) request.getSession().getAttribute("LOGGED_USER");

        // Passar o nome para o cabeçalho
        model.addAttribute("nomeDoUsuario", username);

        // Secção Meus Serviços
        model.addAttribute("plano", "Premium 500 Mega");
        model.addAttribute("valorFatura", 179.90);
        model.addAttribute("vencimentoFatura", "15/12/2025");

        return "teste-dashboard";
    }

    // MÉTODO PARA LOGOUT (botão sair)
    @GetMapping("/logout")
    public String logout(HttpServletRequest request) {

        // Invalida a sessão HTTP atual (se existir)
        if (request.getSession(false) != null) {
            request.getSession().invalidate();
        }

        // Redireciona para a página de login
        return "redirect:/login?logout";
    }
}