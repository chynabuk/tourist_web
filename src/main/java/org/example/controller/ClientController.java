package org.example.controller;

import org.example.entities.Client;
import org.example.services.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
@RequestMapping("/client")
public class ClientController {
    @Autowired
    private ClientService clientService;

    @RequestMapping("/get-all")
    public String showAllClients(Model model){
        List<Client> allClients = clientService.getAll();
        model.addAttribute("allClients", allClients);
        return "clientTable";
    }

    @RequestMapping("/add")
    public String addNewClient(Model model){
        model.addAttribute("clientAdd", new Client());
        return "clientAdd";
    }

    @RequestMapping("/save")
    public String saveClient(@ModelAttribute("clientAdd") Client client){
        clientService.insert(client);
        return "redirect:/client/get-all";
    }

    @RequestMapping("/edit")
    public String editClient(Model model, @RequestParam(value = "clientNumber") Integer clientNumber){
        Client client = clientService.getBy(clientNumber);
        model.addAttribute("clientEdit", client);

        return "clientEdit";
    }

    @RequestMapping("/update")
    public String updateClient(@ModelAttribute("clientEdit") Client client){
        clientService.update(client);

        return "redirect:/client/get-all";
    }

    @RequestMapping("/delete/{clientNumber}")
    public String deleteClient(@PathVariable(value = "clientNumber") Integer clientNumber){
        clientService.delete(clientNumber);
        return "redirect:/client/get-all";
    }
}
