package br.edu.infnet.tp1manga.repository;

import br.edu.infnet.tp1manga.model.Manga;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class MangaRepository {

    private static List<Manga> mangasList = new ArrayList<Manga>();
    private static Integer id = 0;

    public Manga save(String titulo, Integer capitulos){
        Manga manga = new Manga();
        manga.setId(idGenerator());
        manga.setTitulo(titulo);
        manga.setCapitulos(capitulos);
        mangasList.add(manga);
        return manga;
    }

    public Integer idGenerator(){
        Integer idValue = this.id;
        this.id++;
        return idValue;
    }

    public Manga findById(Integer id){
        if (id == null) return null;

        for (Manga manga: mangasList) {
            if(manga.getId().equals(id)) {
                return manga;
            }
        }
        return null;
    }

    public Manga update (Integer id, String titulo, Integer capitulos){
        Manga manga = findById(id);
        if(manga != null){
            manga.setTitulo(titulo);
            manga.setCapitulos(capitulos);
        }
        return manga;
    }

    public List<Manga> findAll(){
        return mangasList;
    }

    public void delete(Integer id){
        Manga manga = findById(id);
        if(manga != null){
            mangasList.remove(manga);
        }

    }


}
