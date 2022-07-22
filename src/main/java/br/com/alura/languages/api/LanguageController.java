package br.com.alura.languages.api;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LanguageController {

    @Autowired
    private LanguageRepository repository;

    @GetMapping("/languages")
    public List<Language> getLanguages() {
        List<Language> languages = repository.findAll();
        return languages;
    }

    @PostMapping("/languages")
    public Language registerLanguage(@RequestBody Language language) {
        Language savedLanguage = repository.save(language);
        return savedLanguage;
    }

    @PutMapping("/languages/{id}")
    public Language updateLanguage(@PathVariable String id, @RequestBody Language modifiedLanguage){
        Language oldLanguage = repository.findById(id).get();
        modifiedLanguage.setId(oldLanguage.getId());
        repository.save(modifiedLanguage);
        return modifiedLanguage;
    }

    @DeleteMapping("/languages/{id}")
    public void deleteLanguage(@PathVariable String id){
        repository.deleteById(id);
    }

}
