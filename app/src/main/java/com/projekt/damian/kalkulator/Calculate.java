package com.projekt.damian.kalkulator;

import android.widget.TextView;
import android.widget.Toast;

import org.mariuszgromada.math.mxparser.Expression;

public class Calculate {

    private final String TOAST = "Wrong operation";

    private StringBuilder stringBuilder;
    private TextView screen;
    private TextView secondScreen;
    private Toast toast;
    private int deleteCounter;
    private Expression expression;
    private boolean advanceFlag;
    private boolean numberFlag;

    public Calculate(TextView screen, TextView secondScreen, Toast toast) {
        this.stringBuilder = new StringBuilder();
        this.screen = screen;
        this.secondScreen = secondScreen;
        this.expression = new Expression();
        this.toast = toast;
        this.deleteCounter = 0;
        this.advanceFlag = false;
        this.numberFlag = false;
    }
    public void makeNumber(String number) {
        if(isNounAtFirstPosition(number) && isNumberFirstPosition(number) && isMinus() && fullSize() && isPercent()) {
            stringBuilder.append(number);
            ifSecondNotComma(number);
            numberFlag=true;
        }
        else {
            toast.show();
        }
        secondScreen.setText(stringBuilder.toString());
        deleteCounter = 0;
    }

    public void clickOperator(String operator) {
        if(isGreaterThanZero() && isCommaAtEndString()) {
            if (screen.getText() == null) {
                screen.setText(stringBuilder.append(operator).toString());
            } else {
                if(advanceFlag){
                    advanceFlag=false;
                    stringBuilder.append(')');
                }
                screen.setText(screen.getText() + stringBuilder.append(operator).toString());
            }

            delete();
            deleteCounter = 0;
        }
        else if(screen.getText().length()>0) {
            changeOperator(operator);
        }
        else {
            toast.show();
        }
    }
    private boolean isGreaterThanZero() {
        return stringBuilder.length() > 0;
    }

    private boolean isGreaterThanOne() {
        return stringBuilder.length() > 1;
    }

    private boolean fullSize(){
        return stringBuilder.length()<15;
    }

    private boolean isCommaAtEndString(){
        return !(stringBuilder.charAt(stringBuilder.length()-1)=='.');
    }



    public void delete() {
        advanceFlag=false;
        numberFlag=false;
        deleteCounter++;
        if(deleteCounter == 2){
            deleteAll();
        }
        stringBuilder = new StringBuilder();
        secondScreen.setText(null);
    }

    public void deleteAll() {
        advanceFlag=false;
        numberFlag=false;
        deleteCounter = 0;
        stringBuilder = new StringBuilder();
        screen.setText(null);
        secondScreen.setText(null);
    }

    private void ifSecondNotComma(String input){
        if(isGreaterThanOne()){
            if((stringBuilder.charAt(0)=='0' && !input.contains(".") && stringBuilder.charAt(1)!='.')){
                stringBuilder.deleteCharAt(0);
            }
        }
    }

    private boolean isMinus(){
        return !stringBuilder.toString().contains("-");
    }

    private void changeOperator(String input){
        StringBuilder topScreenValue = new StringBuilder(screen.getText());
        if(topScreenValue.charAt(1) != input.charAt(0)){
            topScreenValue.setCharAt(topScreenValue.length()-1,input.charAt(0));
            screen.setText(topScreenValue);
        }
    }

    private boolean isNounAtFirstPosition(String input){
        if(isGreaterThanZero()) {
            return !(stringBuilder.charAt(0) == '0' && !stringBuilder.toString().contains(".") && input == "0");
        }
        return true;
    }

    private boolean isNumberFirstPosition(String input){
        if(input.contains(".") && !stringBuilder.toString().contains(".") && isGreaterThanZero()) {
            return true;
        }
        else if(!input.contains(".")){
            return true;
        }
        return false;
    }

    private String deleteFraction(String input) {
        if (input.charAt(input.length() - 2) == '.' && input.charAt(input.length() - 1) == '0') {
            return input.substring(0, input.length() - 2);
        }
        return input;
    }


    private boolean divisionByZero(){
        String mainScreenText = screen.getText().toString();
        return mainScreenText.contains("/0") || ((mainScreenText.charAt(mainScreenText.length()-1) == '/') && !stringBuilder.toString().contains(".") && stringBuilder.charAt(0) == '0');
    }

    private boolean isJustZero(){
        if(isGreaterThanZero()){
            if((stringBuilder.length()==1 && stringBuilder.charAt(0)=='0'))
                return false;
        }
        return true;
    }

    private boolean isGreaterThanZeroScreen(){
        return screen.getText().length()>0 && isGreaterThanZero();
    }



    public void sum() {
        if(isGreaterThanZeroScreen() && !divisionByZero() && isCommaAtEndString()) {
            if(advanceFlag){
                advanceFlag=false;
                stringBuilder.append(')');
            }
            String value = screen.getText() + stringBuilder.toString();
            expression.setExpressionString(value);
            stringBuilder = new StringBuilder(deleteFraction(String.valueOf(expression.calculate())));
            secondScreen.setText(stringBuilder.toString());
            screen.setText(null);
            numberFlag=false;
        }
        else if(advanceFlag){
            if((stringBuilder.toString().contains("ln") || stringBuilder.toString().contains("ln")) && stringBuilder.charAt(stringBuilder.length()-1)=='0' && stringBuilder.charAt(stringBuilder.length()-2) =='('){
                toast.show();
            }
            else {
                advanceFlag = false;
                stringBuilder.append(')');
                expression.setExpressionString(stringBuilder.toString());
                stringBuilder = new StringBuilder(deleteFraction(String.valueOf(expression.calculate())));
                secondScreen.setText(stringBuilder.toString());
            }
        }
        else {
            toast.show();
        }

    }

    private boolean isPercent(){
        if(isGreaterThanZero()){
            return !stringBuilder.toString().contains("%");
        }
        return true;
    }
    public void square() {
        if(isGreaterThanZero() && !stringBuilder.toString().contains("^")){
            stringBuilder.append('^');
            screen.setText(stringBuilder);
            stringBuilder = new StringBuilder("2");
            secondScreen.setText(stringBuilder);
        }
        else {
            toast.show();
        }
    }

    public void plusMinus() {
        if(isGreaterThanZero() && isCommaAtEndString() && isJustZero() && !advanceFlag) {
            if (stringBuilder.toString().contains("-")) {
                stringBuilder.delete(0, 2);
                stringBuilder.deleteCharAt(stringBuilder.length() - 1);
            } else {
                stringBuilder.insert(0, '(');
                stringBuilder.insert(1, '-');
                stringBuilder.insert(stringBuilder.length(), ')');
            }
            secondScreen.setText(stringBuilder.toString());
        }
        else if(advanceFlag && !stringBuilder.toString().contains("ln") && !stringBuilder.toString().contains("log") && !stringBuilder.toString().contains("sqrt")){
            if(!stringBuilder.toString().contains("-")) {
                stringBuilder.insert(4, '-');
            }
            else{
                stringBuilder.deleteCharAt(4);
            }

            secondScreen.setText(stringBuilder.toString());

        }
        else {
            toast.setText(TOAST);
            toast.show();
        }
    }

    public void setStringBuilder(String stringBuilder) {
        this.stringBuilder = new StringBuilder(stringBuilder);
    }

    public void percent() {
        if(isPercent() && isGreaterThanZeroScreen()){
            stringBuilder.append('%');
            secondScreen.setText(stringBuilder);
        }
        else {
            toast.show();
        }
    }

    public void func(String input){
        if(!numberFlag && !advanceFlag) {
            advanceFlag = true;
            stringBuilder.append(input);
            secondScreen.setText(stringBuilder);
        }
        else {
            toast.show();
        }
    }


}
