package br.ufms.tdsoft.assinatura.controller;


import br.ufms.tdsoft.assinatura.entity.Assinatura;
import br.ufms.tdsoft.assinatura.service.AssinaturaService;
import br.ufms.tdsoft.assinatura.service.PlanoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/assinatura")
public class AssinaturaController {

    @Autowired
    private AssinaturaService assinaturaService;

    @PostMapping("/assinar")
    public ResponseEntity<Assinatura> assinar(@RequestParam Long idUsuario, @RequestParam Long idPlano){
      return ResponseEntity.ok(assinaturaService.realizarAssinatura(idUsuario, idPlano));
    }

    @PutMapping("/cancelar")
    public ResponseEntity<Assinatura> cancelar(@RequestParam Long idUsuario, @RequestParam Long idPlano){
        return ResponseEntity.ok(assinaturaService.cancelarAssinatura(idUsuario, idPlano));
    }

}
