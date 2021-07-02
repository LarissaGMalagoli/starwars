package br.com.meli.starwars.dao;


import br.com.meli.starwars.entity.Personagem;
import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

@Repository
public class StarRepository {
    private static final File FILE = new File("starwars.json");

    ObjectMapper mapper;

    public StarRepository(ObjectMapper mapper) {
        this.mapper = mapper;
    }


    public List<Personagem> findAll() {
        List<Personagem> personagens = new ArrayList<>();
        try {
            FileInputStream is = new FileInputStream(FILE);
            TypeReference<List<Personagem>> typeReference = new TypeReference<List<Personagem>>() {};
            personagens = mapper.readValue(is, typeReference);
            is.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return personagens;
    }

    public List<Personagem> findByName(String name){
        List<Personagem> vars = findAll();
        List<Personagem> lista = new ArrayList<>();
        for (Personagem v : vars) {
            if (v.getName().toLowerCase().contains(name.toLowerCase()) ){
                lista.add(v);

            }
        }
        return lista;
    }

    public void add(Personagem food) {
        try {
            List<Personagem> personagens = findAll();
            personagens.add(food);
            PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter(FILE)));
            mapper.writeValue(out, personagens);
            out.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
