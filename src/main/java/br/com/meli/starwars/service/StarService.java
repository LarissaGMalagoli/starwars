package br.com.meli.starwars.service;


import java.util.List;


import br.com.meli.starwars.dao.StarRepository;
import br.com.meli.starwars.entity.Personagem;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.util.UriComponentsBuilder;


@Service
public class StarService {

    StarRepository starRepository;

    public StarService(StarRepository starRepository) {
        this.starRepository = starRepository;
    }

    public List<Personagem> findAll() {
        return starRepository.findAll();
    }

    public List<Personagem> findByName(String nome){
        return starRepository.findByName(nome);
    }

}
