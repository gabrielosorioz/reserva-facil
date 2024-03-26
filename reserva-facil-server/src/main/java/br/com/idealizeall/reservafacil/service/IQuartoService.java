package br.com.idealizeall.reservafacil.service;

import br.com.idealizeall.reservafacil.model.Quarto;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.math.BigDecimal;
import java.sql.SQLException;


public interface IQuartoService {
    Quarto adicionarNovoQuarto(MultipartFile foto, String tipoQuarto, BigDecimal precoQuarto) throws IOException, SQLException;
}
