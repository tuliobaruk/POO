import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class Ferias {
    static int numeroDeFerias = 0;
    private int codigo;
    private Funcionario funcionario;
    private LocalDate dataDeInicio;
    private LocalDate dataDeTermino;
    private long diasDeFerias;

    public Ferias(Funcionario funcionario, LocalDate dataDeInicio, LocalDate dataDeTermino) {
        this.codigo = numeroDeFerias + 1;
        numeroDeFerias += 1;

        this.funcionario = funcionario;
        this.dataDeInicio = dataDeInicio;
        this.dataDeTermino = dataDeTermino;
        this.diasDeFerias = ChronoUnit.DAYS.between(dataDeInicio, dataDeTermino);
    }

    public Funcionario getFuncionario() {
        return funcionario;
    }

    public void setFuncionario(Funcionario funcionario) {
        this.funcionario = funcionario;
    }

    public LocalDate getDataDeInicio() {
        return dataDeInicio;
    }

    public void setDataDeInicio(LocalDate dataDeInicio) {
        this.dataDeInicio = dataDeInicio;
    }

    public LocalDate getDataDeTermino() {
        return dataDeTermino;
    }

    public void setDataDeTermino(LocalDate dataDeTermino) {
        this.dataDeTermino = dataDeTermino;
    }

    public long getDiasDeFerias() {
        return diasDeFerias;
    }

    public void setDiasDeFerias(long diasDeFerias) {
        this.diasDeFerias = diasDeFerias;
    }

    @Override
    public String toString() {
        return "Funcionario= " + funcionario.getNome() +
                "\ndataDeInicio=" + dataDeInicio +
                "\ndataDeTermino=" + dataDeTermino +
                "\ndiasDeFerias=" + diasDeFerias;
    }
}
