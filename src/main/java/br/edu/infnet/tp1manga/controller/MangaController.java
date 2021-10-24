package br.edu.infnet.tp1manga.controller;

import br.edu.infnet.tp1manga.model.Manga;
import br.edu.infnet.tp1manga.repository.MangaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class MangaController {

    @Autowired
    private MangaRepository mangaRepository;

    @RequestMapping(value={"/manga/all"},method = RequestMethod.GET)
    public List<Manga> findAll(){
        return mangaRepository.findAll();
    }

    @RequestMapping(value={"/manga/find"},method = RequestMethod.GET)
    public Manga findById(@RequestParam("id") Integer id){
        return mangaRepository.findById(id);
    }


    @RequestMapping(value={"/manga/save"},method = RequestMethod.GET)
    public Manga save(@RequestParam("titulo") String titulo, @RequestParam("capitulos") Integer capitulos){
        return mangaRepository.save(titulo, capitulos);
    }

    @RequestMapping(value={"/manga/update"},method = RequestMethod.GET)
    public Manga update(@RequestParam("id") Integer id, @RequestParam("titulo") String titulo, @RequestParam("capitulos") Integer capitulos){
        return mangaRepository.update(id, titulo, capitulos);
    }

    @RequestMapping(value={"/manga/delete"},method = RequestMethod.GET)
    public String delete(@RequestParam("id") Integer id) {
        mangaRepository.delete(id);
        return "O manga id: " + id + " foi deletado da lista!";
    }
}
