public class Exercicio1FilipeAlexandreRodrigues {
    public static void main(String[] args) throws Exception {
        String produtos = "Mesa:30;Cadeira:25;Faca:2;Copo:3;" + "Fogão:255;Jarro:4;Prato:3";
        String encomenda = "20@copo;5@faca;4@Mesa;1@fogão";

        String[] ps = produtos.split(";");
        String[] es = encomenda.split(";");
        
        //! Supondo que o todos os produtos da encomenda estão na lista dos produtos:

        String[][] result = new String[ps.length][4];

        // result[i][0] > quantity
        // result[i][1] > product name
        // result[i][2] > price x quantity

        for (int i = 0; i < ps.length; i++) {
            String[] temp = ps[i].split(":");
            // result[i][0] starts null
            result[i][1] = temp[0].toUpperCase();
            result[i][2] = temp[1];
        }

        for (int i = 0; i < es.length; i++) {
            String[] temp = es[i].split("@");
            for (int j = 0; j < ps.length; j++) {
                if (result[j][1].equals(temp[1].toUpperCase())) { 
                    result[j][0] = temp[0];
                    result[j][2] = toStr(toInt(result[j][2]) * toInt(temp[0]));
                }
            }
        }

        for (int i = 0; i < ps.length; i++) printArr(result[i]);
        System.out.println(("Total: " + calcTotal(result) + " Euro(s)")); 
    }

    public static void printArr(String[] arr) {
        if (arr[0] != null) System.out.println(arr[0] + " x " + arr[1] + " : " + arr[2]);
    }

    // Better syntax
    public static int toInt(String str) {
        return Integer.parseInt(str);
    }
    
    // Better syntax
    public static String toStr(int num) {
        return Integer.toString(num);
    }

    // Calculate Total Price
    public static int calcTotal(String[][] arg) {
        int total = 0;
        for (int i = 0; i < arg.length; i++) {
            if (arg[i][0] != null) total += toInt(arg[i][2]);
        }
        return total;
    }
}
