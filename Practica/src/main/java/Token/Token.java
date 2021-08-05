/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Token;

/**
 *
 * @author ordso
 */
public class Token {
   
    private String valor;
    private Tipo tipo;
    
   
    public Token(Tipo tipo, String valor){
        this.tipo = tipo;
        this.valor = valor;
    }
    
    public enum Tipo{
        BRACKET_IZQ,
        BRACKET_DER,
        LLAVE_IZQ,
        LLAVE_DER,
        PUNTO,
        IDENTIFICADOR,
        ENTERO,
        DECIMAL,
        ERROR
    }
    public Token.Tipo getTipo(){
        return this.tipo;
    }
    public String getValor(){
        return this.valor;
    }
    public String writeTipo(){
        Token.Tipo actual = this.tipo;
        switch(actual){
            case BRACKET_IZQ:
                return "Bracket izquierdo";
           
            case BRACKET_DER:
                return "Bracket derecho";
             
            
            case LLAVE_IZQ:
                return "Llave izquerda";
             
            
            case LLAVE_DER:
                return "Llave derecha";
               
            
            case IDENTIFICADOR:
                return "Identificador";
              
            
            case ENTERO:
                return "Entero";
               
            
            case DECIMAL:
                return "Decimal";
         
            
        }
        return "";
    }
}
