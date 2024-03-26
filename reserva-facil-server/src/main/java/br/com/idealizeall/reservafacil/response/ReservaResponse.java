package br.com.idealizeall.reservafacil.response;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ReservaResponse {

    private Long id;
    private LocalDate checkInData;
    private LocalDate checkOutData;
    private String nomeHospede;
    private String emailHospede;
    private int qtdAdultos;
    private int qtdCriancas;
    private int qtdTotalHospedes;
    private String codigoConfirmacaoCode;
    private QuartoResponse quarto;

    public ReservaResponse(Long id, LocalDate checkInData, LocalDate checkOutData, String codigoConfirmacaoCode) {
        this.id = id;
        this.checkInData = checkInData;
        this.checkOutData = checkOutData;
        this.codigoConfirmacaoCode = codigoConfirmacaoCode;
    }
}
