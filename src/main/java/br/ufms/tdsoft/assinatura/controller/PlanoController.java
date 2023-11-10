package br.ufms.tdsoft.assinatura.controller;

import br.ufms.tdsoft.assinatura.dto.PlanoRequest;
import br.ufms.tdsoft.assinatura.entity.Plano;
import br.ufms.tdsoft.assinatura.service.PlanoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/plano")
public class PlanoController {

    @Autowired
    private PlanoService planoService;

    @PostMapping("/create")
    public ResponseEntity<Plano> createPlano(@RequestBody PlanoRequest request){
        return ResponseEntity.ok(planoService.create(request));
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<Plano> updatePlano(@RequestParam Long idPlano, @RequestBody PlanoRequest request){
        return ResponseEntity.ok(planoService.update(idPlano, request));
    }

    @DeleteMapping("/delete")
    public <T> ResponseEntity<T> deletePlano(@RequestParam  Long id){
         planoService.deleteById(id);
         return ResponseEntity.ok().build();
    }

    @GetMapping("/list")
    public ResponseEntity<List<Plano>> listAllPlanos(){
        return ResponseEntity.ok(planoService.findAll());
    }

}
