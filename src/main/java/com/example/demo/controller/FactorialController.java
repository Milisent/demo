package com.example.demo.controller;

import com.example.demo.service.FactorialService;
import org.springframework.web.bind.annotation.*;

import java.math.BigInteger;

@RestController
public class FactorialController {

    @GetMapping("/factorial/{number}")
    @ResponseBody
    public BigInteger hello(@PathVariable int number) {
        return FactorialService.calculate(number);
    }
}
