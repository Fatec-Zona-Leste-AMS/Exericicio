// Interface base simplificada
interface Bebida {
    String getDescricao();
    double getPreco();
}

// Café como bebida base
class Cafe implements Bebida {
    public String getDescricao() { return "Café"; }
    public double getPreco() { return 2.0; }
}

// Decorator base simplificado
abstract class Adicional implements Bebida {
    private Bebida bebida;
    private String nome;
    private double preco;

    public Adicional(Bebida bebida, String nome, double preco) {
        this.bebida = bebida;
        this.nome = nome;
        this.preco = preco;
    }

    public String getDescricao() {
        return bebida.getDescricao() + " + " + nome;
    }

    public double getPreco() {
        return bebida.getPreco() + preco;
    }
}

// Implementações específicas dos adicionais
class Leite extends Adicional {
    public Leite(Bebida bebida) {
        super(bebida, "Leite", 1.0);
    }
}

class Acucar extends Adicional {
    public Acucar(Bebida bebida) {
        super(bebida, "Açúcar", 0.5);
    }
}

class Chocolate extends Adicional {
    public Chocolate(Bebida bebida) {
        super(bebida, "Chocolate", 3.0);
    }
}

class Chantilly extends Adicional {
    public Chantilly(Bebida bebida) {
        super(bebida, "Chantilly", 5.0);
    }
}

// Classe principal
public class Exercicio {
    public static void main(String[] args) {
        // Café simples
        Bebida cafe = new Cafe();
        System.out.printf("1. %s: R$ %.2f%n",
                cafe.getDescricao(), cafe.getPreco());

        // Café com leite e chocolate
        cafe = new Chocolate(new Leite(new Cafe()));
        System.out.printf("2. %s: R$ %.2f%n",
                cafe.getDescricao(), cafe.getPreco());

        // Café com todos os adicionais
        cafe = new Chantilly(
                new Chocolate(
                        new Acucar(
                                new Leite(new Cafe()))));
        System.out.printf("3. %s: R$ %.2f%n",
                cafe.getDescricao(), cafe.getPreco());
    }
}