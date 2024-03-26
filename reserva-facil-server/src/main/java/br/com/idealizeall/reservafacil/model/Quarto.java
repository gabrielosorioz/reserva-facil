package br.com.idealizeall.reservafacil.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.apache.commons.lang3.RandomStringUtils;

import java.math.BigDecimal;
import java.sql.Blob;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
@AllArgsConstructor
public class Quarto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String tipoQuarto;
    private BigDecimal precoQuarto;
    private boolean isReservado = false;
    @Lob
    private Blob foto;

    @OneToMany(mappedBy = "quarto" ,fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<QuartoReservado> reservas;


    public Quarto() {
        this.reservas = new ArrayList<>();
    }

    public void addReserva(QuartoReservado reserva){
        if(reservas == null){
            reservas = new ArrayList<>();
        }
        reservas.add(reserva);
        reserva.setQuarto(this);
        isReservado = true;
        String codigoReserva = RandomStringUtils.randomNumeric(10);
        reserva.setReservaCodigoConfirm(codigoReserva);

    }
}
