import InstructionsToBinary.Nops;

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;
import java.io.PrintWriter;

public class Main {
    public static void main(String[] args) throws IOException {


        ArrayList<String> linhasHexa = new ArrayList<>();

        Scanner scan = new Scanner(System.in);

        System.out.println("Insira o caminho do arquivo dump (com arquivo.dump):");

        String filePathIn = scan.nextLine();

        System.out.println("Insira o nome do arquivo que será salvo, sem extensão. Arquivo será salvo dentro da pasta do projeto.");
        String fileName = scan.nextLine();

        try(BufferedReader br = new BufferedReader(new FileReader(filePathIn))){
            while(br.ready()){
                linhasHexa.add(br.readLine());
            }
        }

        ArrayList<String> resultado = Nops.usarNOPs(linhasHexa);

        try(PrintWriter pw = new PrintWriter(new File(fileName+".dump"))){
            for(String linhaResultado : resultado){
                pw.write(linhaResultado+"\n");

            }
            pw.close();
        }

    }

}