package br.com.idealizeall.reservafacil.service;

import br.com.idealizeall.reservafacil.model.Quarto;
import br.com.idealizeall.reservafacil.repository.QuartoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import javax.sql.rowset.serial.SerialBlob;
import java.io.IOException;
import java.math.BigDecimal;
import java.sql.Blob;
import java.sql.SQLException;

@Service
@RequiredArgsConstructor
public class QuartoServiceImpl implements IQuartoService {

    @Autowired
    private final QuartoRepository quartoRepository;


    @Override
    public Quarto adicionarNovoQuarto(MultipartFile file, String tipoQuarto, BigDecimal precoQuarto) throws IOException, SQLException {
        Quarto newQuarto = new Quarto();
        newQuarto.setTipoQuarto(tipoQuarto);
        newQuarto.setPrecoQuarto(precoQuarto);
        if(!file.isEmpty()){
            byte[] fotoBytes = file.getBytes();
            Blob fotoBlob = new SerialBlob(fotoBytes);
            newQuarto.setFoto(fotoBlob);
        }

        return quartoRepository.save(newQuarto);

    }
}
