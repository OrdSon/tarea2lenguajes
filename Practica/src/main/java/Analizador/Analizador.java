/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Analizador;

import Token.Token;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;
import javax.swing.JTextPane;

/**
 *
 * @author ordso
 */
public class Analizador {

    Character[] cadena;
    boolean errorFound;
    boolean saved;
    ArrayList<Token> tokens = new ArrayList<>();

    public void Analizar(JTextPane textPane) {
        String texto = textPane.getText();
        if (texto.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Nada para compilar");
            return;
        }

        for (int i = 0; i < texto.length(); i++) {
            char caracter = texto.charAt(i);
            if (Character.compare(caracter, '{') == 0) {
                Token token = new Token(Token.Tipo.LLAVE_IZQ, "{");
                tokens.add(token);
            } else if (Character.compare(caracter, '}') == 0) {
                Token token = new Token(Token.Tipo.LLAVE_DER, "}");
                tokens.add(token);
            } else if (Character.compare(caracter, '[') == 0) {
                Token token = new Token(Token.Tipo.BRACKET_IZQ, "[");
                tokens.add(token);
            } else if (Character.compare(caracter, ']') == 0) {
                Token token = new Token(Token.Tipo.BRACKET_DER, "]");
                tokens.add(token);
            } else if (Character.isDigit(texto.charAt(i))) {
                String actual = new String();
                actual += caracter;
                for (int j = i + 1; j < texto.length(); j++) {
                    char temporal = texto.charAt(j);
                    if (errorFound == false && Character.isWhitespace(temporal) || j == (texto.length() - 1)) {
                        Token token = new Token(Token.Tipo.ENTERO, actual);
                        tokens.add(token);
                        i += actual.length();
                        actual = "";

                        break;
                    } else if (errorFound == true && Character.isWhitespace(temporal) || j == (texto.length() - 1)) {
                        Token token = new Token(Token.Tipo.ERROR, actual);
                        tokens.add(token);
                        actual = "";
                        errorFound = false;
                        i += actual.length();
                        break;
                    }
                    if (Character.isDigit(temporal)) {
                        actual += temporal;
                    }
                    if (!Character.isDigit(temporal) && Character.compare(temporal, '.')!=0) {
                        actual += temporal;
                        errorFound = true;
                    }
                    if (Character.compare(temporal, '.') == 0) {
                        actual += ".";
                        for (int k = j + 1; k < texto.length(); k++) {
                            temporal = texto.charAt(k);
                            if (errorFound == false && Character.isWhitespace(temporal)) {
                                Token token = new Token(Token.Tipo.DECIMAL, actual);
                                tokens.add(token);
                                i += actual.length();
                                actual = "";
                                saved = true;
                                break;
                            } else if (errorFound == true && Character.isWhitespace(temporal)) {
                                Token token = new Token(Token.Tipo.ERROR, actual);
                                tokens.add(token);
                                i += actual.length();
                                actual = "";
                                errorFound = false;
                                saved = true;
                                break;
                            } else if (errorFound == false && j == texto.length() - 1) {
                                Token token = new Token(Token.Tipo.ERROR, actual);
                                tokens.add(token);
                                i += actual.length();
                                actual = "";
                                errorFound = false;
                                saved = true;
                                break;
                            }
                            if (!Character.isDigit(temporal)) {
                                actual += temporal;
                                errorFound = true;
                            }
                            if (Character.isDigit(temporal)) {
                                actual += temporal;

                            }
                        }
                    } if (saved) {
                        saved = false;
                        break;
                    }
                }
            } else if (Character.isLetter(caracter)) {

                String actual = new String();
                actual += caracter;
                for (int j = i + 1; j < texto.length(); j++) {
                    char temporal = texto.charAt(j);
                    if (errorFound && Character.isWhitespace(temporal) || j == texto.length() - 1) {
                        Token token = new Token(Token.Tipo.ERROR, actual);
                        tokens.add(token);
                        i += actual.length();
                        actual = "";
                        errorFound = false;
                        break;
                    } else if (Character.isWhitespace(temporal) || j == texto.length() - 1) {
                        Token token = new Token(Token.Tipo.IDENTIFICADOR, actual);
                        tokens.add(token);
                        i += actual.length();
                        actual = "";
                        break;
                    }
                    if (Character.isLetter(temporal)) {
                        actual += temporal;
                    }
                    if (!Character.isLetter(temporal)) {
                        actual += temporal;
                        errorFound = true;
                    }

                }
            } else {
                if (Character.isWhitespace(caracter)) {

                } else {
                    String actual = new String();
                    actual += caracter;
                    for (int j = i + 1; j < texto.length(); j++) {
                        char temporal = texto.charAt(j);
                        actual += temporal;
                        if (Character.isWhitespace(temporal) || i == texto.length() - 1) {
                            Token token = new Token(Token.Tipo.ERROR, actual);
                            tokens.add(token);
                            i += actual.length();
                            actual = "";
                            break;
                        }
                    }
                }
            }
        }

    }

    public void writeAciertos(JTextPane textArea) {
        textArea.setText("");
        for (int i = 0; i < tokens.size(); i++) {
            Token temporal = tokens.get(i);
            if (temporal.getTipo() != Token.Tipo.ERROR) {
                textArea.setText(textArea.getText()+" "+temporal.writeTipo() + " " + temporal.getValor() + "\n");
                //textArea.append(temporal.writeTipo() + " " + temporal.getValor() + "\n");
            }
        }

    }

    public void writeErrores(JTextPane textArea) {
        textArea.setText("");
        for (int i = 0; i < tokens.size(); i++) {
            Token temporal = tokens.get(i);
            if (temporal.getTipo() == Token.Tipo.ERROR) {
                textArea.setText(textArea.getText()+" "+temporal.writeTipo() + " " + temporal.getValor() + "\n");
                //textArea.append(temporal.writeTipo() + " " + temporal.getValor() + "\n");
            }
        }

    }

}
