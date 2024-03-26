package br.com.idealizeall.reservafacil.controller;
import br.com.idealizeall.reservafacil.model.Quarto;
import br.com.idealizeall.reservafacil.response.QuartoResponse;
import br.com.idealizeall.reservafacil.service.IQuartoService;
import br.com.idealizeall.reservafacil.service.QuartoServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.math.BigDecimal;
import java.sql.SQLException;

@RestController
@RequiredArgsConstructor
@RequestMapping("/quartos")
public class QuartoController {

    private final QuartoServiceImpl quartoServiceImpl;

    @PostMapping("/adicionar/quarto")
    public ResponseEntity<QuartoResponse> adicionarNovoQuarto (
            @RequestParam("foto") MultipartFile foto,
            @RequestParam("tipoQuarto")String tipoQuarto,
            @RequestParam("precoQuarto")BigDecimal precoQuarto) throws SQLException, IOException {

        Quarto quartoSalvo = quartoServiceImpl.adicionarNovoQuarto(foto, tipoQuarto, precoQuarto);
        QuartoResponse response = new QuartoResponse(quartoSalvo.getId(), quartoSalvo.getTipoQuarto(), quartoSalvo.getPrecoQuarto());

        System.out.println(response);
        return ResponseEntity.ok(response);
    }




}
