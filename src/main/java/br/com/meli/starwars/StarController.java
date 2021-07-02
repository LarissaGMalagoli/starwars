package br.com.meli.starwars;

import java.net.URI;
import java.util.List;


import br.com.meli.starwars.dto.PersonagemDTO;
import br.com.meli.starwars.entity.Personagem;
import br.com.meli.starwars.service.StarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;



@RestController
@RequestMapping("/starwars")
public class StarController {

    StarService starService;

    public StarController(StarService starService) {
        this.starService = starService;
    }

    @GetMapping
    public List<Personagem> listaPersonagens() {
        return starService.findAll();
    }

    @GetMapping("/{nome}")
    public List<PersonagemDTO> encontraPersonagem(@PathVariable String nome){
        List<PersonagemDTO> lista = PersonagemDTO.converte(starService.findByName(nome));
        return lista;
    }
}