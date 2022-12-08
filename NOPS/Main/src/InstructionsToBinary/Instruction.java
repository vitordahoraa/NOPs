package InstructionsToBinary;


import java.math.BigInteger;

public class Instruction {

    private void setTipoAndCiclos(String toBeCompared){

        for(int i = 0; i < Constants.load.length; ++i) {
            if(toBeCompared.equals(Constants.load[i])) {
                this.tipo = TipoDeInstrucao.Load;
                this.ciclos = 5;
            }
        }

        if(this.tipo != TipoDeInstrucao.Default)
            return;

        for(int i = 0; i < Constants.store.length; ++i) {
            if(toBeCompared.equals(Constants.store[i])) {
                this.tipo = TipoDeInstrucao.Store;
                this.ciclos = 4;
            }
        }

        if(this.tipo != TipoDeInstrucao.Default)
            return;

        for(int i = 0; i < Constants.branch.length; ++i) {
            if(toBeCompared.equals(Constants.branch[i])) {
                this.tipo = TipoDeInstrucao.Branch;
                this.ciclos = 3;
            }
        }
        if(this.tipo != TipoDeInstrucao.Default)
            return;

        for(int i = 0; i < Constants.jump.length; ++i) {
            if(toBeCompared.equals(Constants.jump[i])) {
                this.tipo = TipoDeInstrucao.Jump;
                this.ciclos = 3;
            }
        }
        if(this.tipo != TipoDeInstrucao.Default)
            return;

        this.tipo = TipoDeInstrucao.Rtype;;
        this.ciclos = 4;

    }
    public BigInteger hex;
    public String binary;

    public TipoDeInstrucao tipo;

    public int ciclos;

    public String opCode;

    public boolean isImediateRtype = false;

    Instruction(String input){
        this.hex = new BigInteger(input,16);
        this.binary = this.hex.toString(2);
        this.tipo = TipoDeInstrucao.Default;


        while(this.binary.length() < 32)
            this.binary = "0" + this.binary;

        String opCode = this.binary.substring(0, 6);
        String funct = this.binary.substring(26,32);

        if(opCode.equals("000000")){
            this.setTipoAndCiclos(funct);
            this.opCode = funct;
        }
        else{
            this.setTipoAndCiclos(opCode);
            this.opCode = opCode;
            this.isImediateRtype = true;
        }
    }
}
