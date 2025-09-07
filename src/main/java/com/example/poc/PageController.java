package com.example.poc;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
public class PageController {
    private boolean isLoggedIn = false;


    @PostMapping("/login")
    public Map<String, Object> doLogin(@RequestParam String username,@RequestParam String password){ // Object pour renvoyer tout type d'objet
        if("user".equals(username)&&"pass".equals(password)){
            isLoggedIn = true;
            return Map.of("success", true, "message", "Connexion réussie"); //keys et values
        }
        else{
            return Map.of("success", false, "message", "Echec de connexion");

        }
    }

    @PostMapping("/logout")
    public Map<String, Object> doLogout(){
        isLoggedIn = false;
        return Map.of("success", true, "message", "Déconnecté avec succès");
    }

    @GetMapping({"/home"})
    public Map<String, Object> home(){
        if(!isLoggedIn){
            return Map.of("error", "Non connecté");
        }
        else{
            return Map.of("page", "home", "message", "bienvenue sur la page d'acceuil");
        }
    }

   @GetMapping({"/java"})
    public Map<String, Object> java(){
        if(!isLoggedIn){
            return Map.of("error", "Non connecté");
        }
        else{
            return Map.of("page", "java", "message", "Cours de Java bientôt disponible");
        }
   }

    @GetMapping({"/python"})
    public Map<String, Object> python(){
        if(!isLoggedIn){
            return Map.of("error", "Non connecté");
        }
        else{
            return Map.of("page", "python", "message", "Cours de python bientôt disponible");
        }
    }

}
