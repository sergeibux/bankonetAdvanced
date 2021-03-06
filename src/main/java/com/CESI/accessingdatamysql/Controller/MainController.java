package main.java.com.CESI.accessingdatamysql.Controller;

import main.java.com.CESI.accessingdatamysql.Entity.Client;
import main.java.com.CESI.accessingdatamysql.Entity.Compte;
import main.java.com.CESI.accessingdatamysql.Entity.CompteCourant;
import main.java.com.CESI.accessingdatamysql.Entity.CompteEpargne;
import main.java.com.CESI.accessingdatamysql.Repository.ClientRepository;
import main.java.com.CESI.accessingdatamysql.Repository.CompteCourantRepository;
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
@RequestMapping(path="/") // This means URL's start with /demo (after Application path)
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
    @GetMapping (path="/AddCompteCourantClient")
    public @ResponseBody String AddCompteCourantClien(@RequestParam int idClient, @RequestParam Double decouvertAutorise, @RequestParam String intitule, @RequestParam Double solde, @RequestParam String numero) {
        CompteCourant compteCourant = new CompteCourant();
        int idCompteCourant = compteCourant.createCompte(decouvertAutorise, intitule, solde, numero, ClientRepository, CompteCourantRepository);
        if (affectCompteCourantClient(idClient, idCompteCourant)){
            return "Saved";
        }else {
            return "Error";
        }
    }

    @GetMapping("/")
    public @ResponseBody String index() {
        return "Greetings from Spring Boot!";
    }

    @GetMapping("/toto")
    public @ResponseBody String toto() {
        return "toto";
    }

    @GetMapping("/compteCourant/toString")
    public @ResponseBody String GetCompteByClientAndPrint(@RequestParam int id) {
        Optional<Client> optClient = ClientRepository.findById(id);
        Client client = optClient.get();
        return client.getCompteCourant().toString();
    }

    @GetMapping("/client/toString")
    public @ResponseBody String GetClientAndPrint(@RequestParam int id) {
        Optional<Client> optClient = ClientRepository.findById(id);
        Client client = optClient.get();
        return client.toString();
    }

    @GetMapping("/compteCourant/crediter")
    public @ResponseBody String CreditCompteCourant(@RequestParam double montant, @RequestParam int id){
        Optional<CompteCourant> optCompteCourant = CompteCourantRepository.findById(id);
        if (optCompteCourant.isPresent()){
            CompteCourant compteCourant = optCompteCourant.get();
            compteCourant.crediter(montant);
            return "new solde : " + compteCourant.get_solde();
        }else {
            return "Compte introuvable";
        }
    }

    @GetMapping("/compteEpargne/crediter")
    public @ResponseBody String CreditCompteEpargne(@RequestParam double montant, @RequestParam int id){
        Optional<CompteEpargne> optCompteEpargne = CompteEpargneRepository.findById(id);
        if (optCompteEpargne.isPresent()){
            CompteEpargne compteEpargne = optCompteEpargne.get();
            compteEpargne.crediter(montant);
            return "new solde : " + compteEpargne.get_solde();
        }else {
            return "Compte introuvable";
        }
    }

    public boolean affectCompteCourantClient(int idClient, int idComtpeCourant){
        Optional<CompteCourant> optionalCompteCourant = CompteCourantRepository.findById(idComtpeCourant);
        Optional<Client> client = ClientRepository.findById(idClient);
        Client monClient ;
        CompteCourant compteCourant;
        if (client.isPresent() && optionalCompteCourant.isPresent()) {
            compteCourant = optionalCompteCourant.get();
            monClient = client.get();
            monClient.addCompte(compteCourant);
        } else {
            return false;
        }
        ClientRepository.save(monClient);
        return true;
    }
}
