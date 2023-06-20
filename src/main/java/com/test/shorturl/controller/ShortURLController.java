package com.test.shorturl.controller;

import com.test.shorturl.repository.ShortURLRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
public class ShortURLController {

    ShortURLRepository shortURLRepository;

    @Autowired
    public ShortURLController(ShortURLRepository shortURLRepository){
        this.shortURLRepository = shortURLRepository;
    }

    @RequestMapping("/short_url")
    public String main(){
        return "short-url";
    }

    @PostMapping("/short_url")
    public String save(String rawURL, Model model){
        if (rawURL.equals("")) return "short-url";

        String encURL = "http://localhost:8080/" + shortURLRepository.saveURL(rawURL);
        long requestCount = shortURLRepository.printRequestCount(rawURL);
        model.addAttribute("encURL", encURL);
        model.addAttribute("requestCount", requestCount);
        return "short-url";
    }

    @GetMapping("/{encURL}")
    public String redirectURL(@PathVariable String encURL){
        String rawURL = shortURLRepository.findURL(encURL);
        if (rawURL != null) {
            shortURLRepository.addRequestCount(rawURL);
            return "redirect:"+rawURL;
        }
        return "redirect:/error";
    }
}
