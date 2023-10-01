package ru.stanovihin.cocos.services;

import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;
import ru.stanovihin.cocos.models.entities.CompanyFond;
import ru.stanovihin.cocos.repositories.CompanyFondRepository;

import java.util.List;

@Service
public class CompanyFondService {

    private final CompanyFondRepository companyFondRepository;

    public CompanyFondService(CompanyFondRepository companyFondRepository) {
        this.companyFondRepository = companyFondRepository;
    }

    public CompanyFond save(CompanyFond companyFond){
        List<CompanyFond> fonds = companyFondRepository.findAll();
        if (fonds.size() > 0){
            throw new IllegalArgumentException("В системе уже создан фонд компании. Не может быть" +
                    "больше одного фонда компании.");
        }
        return companyFondRepository.save(companyFond);
    }

    public CompanyFond getOne(){
        List<CompanyFond> fonds = companyFondRepository.findAll();
        System.out.println("Received fonds: " + fonds);
        return fonds.size() == 0 ? null : fonds.get(0);
    }

    public Integer addCoins(Integer coins){
        List<CompanyFond> fonds = companyFondRepository.findAll();
        CompanyFond fond = fonds.get(0);
        int currentBalance = fond.getCurrent();
        fond.setCurrent(currentBalance + coins);
        companyFondRepository.save(fond);
        return fond.getCurrent();
    }
}
