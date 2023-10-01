package ru.stanovihin.cocos.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.stanovihin.cocos.models.entities.CompanyFond;
import ru.stanovihin.cocos.services.CompanyFondService;

@CrossOrigin("*")
@RestController
@RequestMapping("/api/companyFond")
public class CompanyFondController {

    private final CompanyFondService companyFondService;

    public CompanyFondController(CompanyFondService companyFondService) {
        this.companyFondService = companyFondService;
    }

    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<CompanyFond> getFond(){
        System.out.println("Received /GET companyFond");
        return ResponseEntity.ok(companyFondService.getOne());
    }

    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<CompanyFond> save(@RequestBody CompanyFond companyFond){
        System.out.println("Received POST /companyFond requestBody: " + companyFond);
        return ResponseEntity.ok(companyFondService.save(companyFond));
    }
}
