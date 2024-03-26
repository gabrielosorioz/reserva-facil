package br.com.idealizeall.reservafacil.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import java.time.LocalDate;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class QuartoReservado {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idReserva;

    @Column(name = "check_In")
    private LocalDate checkInData;

    @Column(name = "check_Out")
    private LocalDate checkOutData;

    @Column(name = "nome_completo_Hospede")
    private String nomeHospede;

    @Column(name = "email_Hospede")
    private String emailHospede;

    @Column(name = "qtd_adultos")
    private int qtdAdultos;

    @Column(name = "qtd_criancas")
    private int qtdCriancas;

    @Column(name = "qtd_total_hospede")
    private int qtdTotalHospede;

    @Column(name = "codigo_confirmacao")
    private String codigoConfirmacaoReserva;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "quarto_id")
    private Quarto quarto;

    public QuartoReservado(String codigoConfirmacaoReserva) {
        this.codigoConfirmacaoReserva = codigoConfirmacaoReserva;
    }

    public void calcTotalQtdHospede () {
        this.qtdTotalHospede = this.qtdAdultos + qtdCriancas;
    }

    public void setQtdAdultos(int qtdAdultos) {
        this.qtdAdultos = qtdAdultos;
        calcTotalQtdHospede();
    }

    public void setQtdCriancas(int qtdCriancas) {
        this.qtdCriancas = qtdCriancas;
        calcTotalQtdHospede();
    }

}

