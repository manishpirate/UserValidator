package com.example.demo.cloudkafka;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/rest/message")
public class WebRequestController {

    @Autowired
    Sender sender;

    @PostMapping
    public ResponseEntity<String> getMessageData(@RequestBody String messageBody, @RequestParam String key){
        sender.createMessage(messageBody, key);
        return new ResponseEntity<String>(HttpStatus.ACCEPTED);
    }

}
