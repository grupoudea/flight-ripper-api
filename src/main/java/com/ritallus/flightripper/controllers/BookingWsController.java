package com.ritallus.flightripper.controllers;

import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RestController;

@Controller
public class BookingWsController {

    @MessageMapping("/broadcast") //el cliente envia datos por aquí
    @SendTo("/topic/reply") // el server responde como broadcast a todos los sucritos a esta cola
    public String broadcastMessage(@Payload String message) {
        //ir a la base de datos y guardar la booking
        // retornar la bookin guardada en base datos
        // broadcast se eencarga de notificar a todos los clientes en el frontend -> retornan su dto
        return "You have received a message: " + message;
    }
}
