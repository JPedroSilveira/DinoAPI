package br.ufrgs.inf.pet.dinoapi.controller.contacts;

import br.ufrgs.inf.pet.dinoapi.model.contacts.*;
import br.ufrgs.inf.pet.dinoapi.service.contact.ContactService;
import br.ufrgs.inf.pet.dinoapi.service.contact.ContactServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
    @RequestMapping("/contacts/")
    public class ContactsControllerImpl implements ContactsController {

        @Autowired
        ContactServiceImpl contactServiceImpl;

        @Override
        @GetMapping
        public ResponseEntity<ArrayList<ContactResponseModel>> getContacts() {
            return contactServiceImpl.getContacts();
        }

        @Override
        @PostMapping
        public ResponseEntity<?> saveContact(@RequestBody ContactSaveModel model) {
            return contactServiceImpl.saveContact(model);
        }

}
