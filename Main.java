import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {

        Funcionario func1 = new Funcionario("Tulio","Dev", LocalDate.parse("2023-07-10"));
        SistemaRh sistema = new SistemaRh();

        sistema.calcularFerias(func1);
        sistema.listarFerias();
    }
}