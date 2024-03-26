package br.com.idealizeall.reservafacil.response;

import lombok.Data;
import org.apache.tomcat.util.codec.binary.Base64;

import java.math.BigDecimal;
import java.util.List;

@Data
public class QuartoResponse {

    private Long id;
    private String tipoQuarto;
    private BigDecimal precoQuarto;
    private boolean isReservado;
    private String foto;
    private List<ReservaResponse> reservas;

    public QuartoResponse(Long id, String tipoQuarto, BigDecimal precoQuarto) {
        this.id = id;
        this.tipoQuarto = tipoQuarto;
        this.precoQuarto = precoQuarto;
    }

    public QuartoResponse(Long id, String tipoQuarto, BigDecimal precoQuarto, boolean isReservado, byte[] fotoBytes, List<ReservaResponse> reservas) {
        this.id = id;
        this.tipoQuarto = tipoQuarto;
        this.precoQuarto = precoQuarto;
        this.isReservado = isReservado;
        this.foto = fotoBytes != null ? Base64.encodeBase64String(fotoBytes) : null;
        this.reservas = reservas;
    }
}
