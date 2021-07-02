package br.com.meli.starwars.dto;

import java.util.List;


import br.com.meli.starwars.entity.Personagem;
import org.springframework.boot.autoconfigure.condition.ConditionalOnNotWebApplication;

import java.util.List;
import java.util.stream.Collectors;

public class PersonagemDTO {

        private String name;

    public PersonagemDTO(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public static PersonagemDTO converte(Personagem personagem) {
            return new PersonagemDTO(personagem.getName());
    }

    public static List<PersonagemDTO> converte(List<Personagem> personagem) {
        return personagem.stream().map(a -> new PersonagemDTO(a.getName())).collect(Collectors.toList());
    }

}
