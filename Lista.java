import java.util.Scanner;

class Nodo {
    int valor;
    Nodo next;

    Nodo(int valor) {
        this.valor = valor;
        this.next = null;
    }
}

class ListaConexa {
    Nodo head;

    ListaConexa() {
        this.head = null;
    }

    void adicionaFim(int valor) {
        if (head == null) {
            head = new Nodo(valor);
            return;
        }
        Nodo atual = head;
        while (atual.next != null) {
            atual = atual.next;
        }
        atual.next = new Nodo(valor);
    }
}

public class MergeLists {
    static ListaConexa readList() {
        Scanner input = new Scanner(System.in);
        ListaConexa lista = new ListaConexa();
        String[] elementos = input.nextLine().split(" ");
        for (String elemento : elementos) {
            lista.adicionaFim(Integer.parseInt(elemento));
        }
        return lista;
    }

    static ListaConexa juntaListas(ListaConexa lista_A, ListaConexa lista_B, int Z, int Y) {
        Nodo atual_A = lista_A.head;
        Nodo atual_B = lista_B.head;
        ListaConexa lista_C = new ListaConexa();
        Nodo atual_C = lista_C.head;
        boolean muda_B = false;

        while (atual_A != null || atual_B != null) {
            while (atual_A != null && atual_A.valor != Z) {
                if (atual_C == null) {
                    lista_C.head = new Nodo(atual_A.valor);
                    atual_C = lista_C.head;
                } else {
                    atual_C.next = new Nodo(atual_A.valor);
                    atual_C = atual_C.next;
                }
                atual_A = atual_A.next;
            }

            if (atual_A != null) {
                muda_B = true;
                atual_A = atual_A.next;
            }

            while (atual_B != null && (!muda_B || atual_B.valor != Y)) {
                if (atual_C == null) {
                    lista_C.head = new Nodo(atual_B.valor);
                    atual_C = lista_C.head;
                } else {
                    atual_C.next = new Nodo(atual_B.valor);
                    atual_C = atual_C.next;
                }
                atual_B = atual_B.next;
            }

            if (atual_B != null && atual_B.valor == Y) {
                muda_B = false;
                atual_B = atual_B.next;
            }
        }

        return lista_C;
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.println("Digite os elementos da lista A:");
        ListaConexa lista_A = readList();
        System.out.println("Digite os elementos da lista B:");
        ListaConexa lista_B = readList();
        System.out.print("Digite o valor de Z: ");
        int Z = input.nextInt();
        System.out.print("Digite o valor de Y: ");
        int Y = input.nextInt();

        ListaConexa lista_C = juntaListas(lista_A, lista_B, Z, Y);

        Nodo atual_C = lista_C.head;
        System.out.print("Lista final C: ");
        while (atual_C != null) {
            System.out.print(atual_C.valor + " ");
            atual_C = atual_C.next;
        }
    }
}