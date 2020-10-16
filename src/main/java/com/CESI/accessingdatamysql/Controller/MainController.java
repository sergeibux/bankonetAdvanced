package main.java.com.CESI.accessingdatamysql.Controller;

import main.java.com.CESI.accessingdatamysql.Entity.Client;
import main.java.com.CESI.accessingdatamysql.Entity.CompteCourant;
import main.java.com.CESI.accessingdatamysql.Entity.CompteEpargne;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;


import java.util.*;

import javax.persistence.*;

@Controller // This means that this class is a Controller
@RequestMapping(path="/demo") // This means URL's start with /demo (after Application path)
public class MainController {
    @Autowired // This means to get the bean called userRepository
    // Which is auto-generated by Spring, we will use it to handle the data
    private main.java.com.CESI.accessingdatamysql.Repository.ClientRepository ClientRepository;
    @Autowired
    private main.java.com.CESI.accessingdatamysql.Repository.CompteCourantRepository CompteCourantRepository;
    @Autowired
    private main.java.com.CESI.accessingdatamysql.Repository.CompteEpargneRepository CompteEpargneRepository;

    @PostMapping(path="/add") // Map ONLY GET Requests
    public @ResponseBody String addNewUser (@RequestParam String nom, @RequestParam String prenom) {
        // @ResponseBody means the returned String is the response, not a view name
        // @RequestParam means it is a parameter from the GET or POST request

        Client n = new Client();
        if (n.saveClient(nom, prenom, ClientRepository)) {
            return "Saved";
        }else return "Error";
    }

    @GetMapping(path="/all")
    public @ResponseBody Iterable<Client> getAllUsers() {
        // This returns a JSON or XML with the users
        return ClientRepository.findAll();
    }


    @GetMapping(path="/compteCourant")
    public @ResponseBody Iterable<CompteCourant> getAllCptCourant() {
        // This returns a JSON or XML with the users
        return CompteCourantRepository.findAll();
    }


    @GetMapping(path="/compteEpargne")
    public @ResponseBody Iterable<CompteEpargne> getAllCptEpargne() {
        // This returns a JSON or XML with the users
        return CompteEpargneRepository.findAll();
    }


    @GetMapping (path="/GetClientById")
    public @ResponseBody Optional<Client> GetClientById(@RequestParam int id) {
        return  ClientRepository.findById(id);
    }

    @GetMapping (path="/GetCompteByClient")
    public @ResponseBody List<CompteCourant> GetCompteByClient(@RequestParam int id) {
        Optional<Client> optClient = ClientRepository.findById(id);
        Client client = optClient.get();
        return (List<CompteCourant>) client.getCompteCourant();
    }
}
