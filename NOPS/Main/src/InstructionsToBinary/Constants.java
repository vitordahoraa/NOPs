/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package InstructionsToBinary;

import java.util.ArrayList;

/**
 *
 * @author Hugo Tomazi Busnardo
 * Esse código foi utilizado na entrega do cálculo de CPÌ, no qual eu(Vitor Murilo da Hora Coelho) e o Hugo, estavamos juntos.
 */
public class Constants {

    // Store
    public static String[] store = {
        "101000",
        "101001",
        "101011"
    };
    
    // Load
    public static String[] load = {
        "100000\",\n" +
                "        \"100100\",\n" +
                "        \"100001\",\n" +
                "        \"100101\",\n" +
                "        \"100011\",\n" +
                "        \"001111\",\n" +
                "        \"001101"
    };
    
    // Branch
    public static String[] branch = {
        "000100",
        "000111",
        "000110",
        "000101"
    };
    // Jump
    public static String[] jump = {
        "000010",
        "000011",
        "001001"
    };

    public static String[] immediateRtype = {
        "001110",
        "001101",
        "001000",
        "001001",
        "001100",
    };
}
