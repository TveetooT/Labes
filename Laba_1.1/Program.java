class Stack{
    char[] array = new char[5000];
    int len = 0;
    public void append (char obj){
        array[len] = obj;
        len++;
    }
    public void pop (){
        len--;
    }
    public char last (){
        return array[len-1];
    }
}

public class Program{
    static void main (String[] args){
        String[] tests = { 
                "{}"
        };
        if (args != null){
            for (String argument : args){
                System.out.println(skobki(argument));
            }
        }
        for (String argument : tests){
            System.out.println(skobki(argument));
        }
    }
    static boolean skobki (String arr){
        Stack st = new Stack();
        for (int i = 0; i < arr.length(); i++){
            char sk = arr.charAt(i);
            if (sk == '(' || sk == '[' || sk == '{'){
                st.append(sk);
            }
            else{
                if (st.len == 0){
                    return false;
                }
                if (opposite(st.last(), sk)){
                    st.pop();
                }
                else{
                    return false;
                }
            }
        }
        return st.len == 0;
    }
    static boolean opposite(char first, char second){
        if ((first == '(' && second == ')') || (first == '[' && second == ']') || (first == '{' && second == '}')){
            return true;
        }
        return false;

    }
}