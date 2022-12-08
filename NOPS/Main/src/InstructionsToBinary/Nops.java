package InstructionsToBinary;

import java.util.ArrayList;

public class Nops {
    public static ArrayList<String> usarNOPs(ArrayList<String> linhasHexa){
        ArrayList<Instruction> instructions= new ArrayList<>();
        ArrayList<String> resultado = new ArrayList();

        for(String linha : linhasHexa){ //Adiocionar instruções na linha
            instructions.add(new Instruction(linha));
        }

        Instruction instructionAnterior = null;

        for(Instruction instruction: instructions){

            if(instructionAnterior == null){
                resultado.add(instruction.binary);
                instructionAnterior = instruction;
                continue;
            }

            System.out.println(instruction.isImediateRtype);
            if(instruction.tipo == TipoDeInstrucao.Rtype && instructionAnterior.tipo == TipoDeInstrucao.Rtype){
                String registrador;
                String registradorAnterior;

                if(instruction.isImediateRtype){
                    registrador = instruction.binary.substring(11,16);
                } else{
                    registrador = instruction.binary.substring(16,21);
                }

                if(instructionAnterior.isImediateRtype){
                    registradorAnterior = instruction.binary.substring(11,16);
                } else{
                    registradorAnterior = instruction.binary.substring(16,21);
                }

                if(registrador.equals(registradorAnterior)){
                    resultado.add("00000000000000000000000000000000");
                    resultado.add("00000000000000000000000000000000");
                }
            }
            resultado.add(instruction.binary);
            instructionAnterior = instruction;
        }
        return resultado;
    }
}
